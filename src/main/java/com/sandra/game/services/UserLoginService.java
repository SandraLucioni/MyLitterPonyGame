package com.sandra.game.services;

import com.sandra.game.entities.User;
import com.sandra.game.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserLoginService {

    private final UserRepository userRepository;

    public UserLoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User update(User user){
        return userRepository.save(user);
    }

    public Optional<User> searchUser(String id){
        return userRepository.findById(id);
    }

    private User searchByEmailAndPassword(String email, String password){
        return userRepository.findByEmailAndPassword(email, password);
    }

    private User searchByNameAndPassword(String username, String password){
        return userRepository.findByEmailAndPassword(username, password);
    }

    public User searchLoginUser(String one, String two){
        if (one.contains("@"))  return searchByEmailAndPassword(one, two);
        return searchByNameAndPassword(one, two);
    }

}
