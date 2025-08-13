package dev.sandeep.SplitwiseApr25.service;

import dev.sandeep.SplitwiseApr25.configuration.BCryptEncoder;
import dev.sandeep.SplitwiseApr25.exception.UserDoesNotExistException;
import dev.sandeep.SplitwiseApr25.model.User;
import dev.sandeep.SplitwiseApr25.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptEncoder bCryptEncoder;

    public User save(User user) {
        return userRepository.save(user);
    }

    public User findUserById(Integer id) {
        return userRepository.findById(id).orElseThrow(
                () -> new UserDoesNotExistException("User with id " + id + " not found")
        );
    }

    public User login(String email, String password) {
        User savedUser = userRepository.findByEmail(email);
        if(bCryptEncoder.matches(password, savedUser.getPassword())) {
            return savedUser;
        } else {
            return null;
        }
    }

}
