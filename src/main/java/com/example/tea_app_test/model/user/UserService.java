package com.example.tea_app_test.model.user;


import com.example.tea_app_test.model.user.Role;
import com.example.tea_app_test.model.user.User;
import com.example.tea_app_test.model.user.UserDto;
import com.example.tea_app_test.model.user.UserRepository;
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
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public User findById(long id){
        return userRepository.findById(id);
    }

    public boolean save(UserDto user) {
        User userFromDB = userRepository.findByEmail(user.getEmail());

        if (userFromDB != null) {
            return false;
        }
        userRepository.save(
                new User(
                        user.getEmail(),
                        passwordEncoder.encode(user.getPassword()),
                        user.getName(),
                        user.getSurname(),
                        Set.of(Role.USER),
                        false
                )
        );
        return true;
    }

    public void activateAccount(String email){
        User userFromDB = userRepository.findByEmail(email);
        if (userFromDB != null) {
            userFromDB.setActive(true);
            userRepository.save(userFromDB);
        }
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
