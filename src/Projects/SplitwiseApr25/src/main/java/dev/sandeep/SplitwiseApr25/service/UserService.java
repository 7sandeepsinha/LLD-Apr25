package dev.sandeep.SplitwiseApr25.service;

import dev.sandeep.SplitwiseApr25.model.User;
import dev.sandeep.SplitwiseApr25.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }


}
