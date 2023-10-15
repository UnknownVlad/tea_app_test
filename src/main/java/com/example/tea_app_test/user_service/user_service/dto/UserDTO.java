package com.example.tea_app_test.user_service.user_service.dto;

import com.example.tea_app_test.user_service.user_service.model.Role;
import com.example.tea_app_test.user_service.user_service.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserDTO implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public boolean saveUser(User user) {
        User userFromDB = userRepository.findByEmail(user.getUsername());

        if (userFromDB != null) {
            return false;
        }
        user.setRoles(
                Collections.singleton(Role.USER)
        );

        userRepository.save(user);
        return true;
    }
}
