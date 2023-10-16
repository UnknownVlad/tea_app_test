package com.example.tea_app_test.user_service.repository;


import com.example.tea_app_test.user_service.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;


    public User loadUserByUsername(String email) throws Exception {
        User user = userRepository.findByEmail(email);

        if (user == null) {
            throw new Exception("User not found");
        }

        return user;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public boolean save(User user) {
        User userFromDB = userRepository.findByEmail(user.getEmail());

        if (userFromDB != null) {
            System.out.println("+");
            return false;
        }


        userRepository.save(user);
        return true;
    }
}
