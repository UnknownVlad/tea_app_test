package com.example.tea_app_test.model.user;


import com.example.tea_app_test.global_error_handling.exeptions.UserExistException;
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

    public void save(User user) {
        userRepository.save(user);
    }

    public void save(UserDTO userDTO) {
        User userFromDB = userRepository.findByEmail(userDTO.getEmail());
        if (userFromDB != null) {
            throw new UserExistException("Пользователь с таким email адресом уже существует");
        }
        userRepository.save(
                User.builder()
                        .email(userDTO.getEmail())
                        .password(passwordEncoder.encode(userDTO.getPassword()))
                        .name(userDTO.getName())
                        .surname(userDTO.getSurname())
                        .active(false)
                        .roles(userDTO.getRole())
                .build()
        );
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
