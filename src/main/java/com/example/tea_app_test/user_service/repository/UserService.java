package com.example.tea_app_test.user_service.repository;


import com.example.tea_app_test.user_service.domain.Role;
import com.example.tea_app_test.user_service.domain.User;
import com.example.tea_app_test.user_service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }


    public boolean save(UserDto user) {
        User userFromDB = userRepository.findByEmail(user.getEmail());

        if (userFromDB != null) {
            return false;
        }
        //Делать пользователя неактивным
        userRepository.save(
                new User(
                        user.getEmail(),
                        passwordEncoder.encode(user.getPassword()),
                        user.getName(),
                        user.getSurname(),
                        Set.of(Role.USER),
                        true
                )
        );

        return true;
    }


    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByEmail(username);

        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        return user;
    }
}
