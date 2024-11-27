package com.example.UserProfile.service;

import com.example.UserProfile.model.User;
import com.example.UserProfile.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository1;
    // User is model name
    public User createUser(User user){
        System.out.println("User to save:" +user);
        return userRepository1.save(user);
    }
    public List<User> getAllUsers(){
        return userRepository1.findAll();
    }
    public User getUserById(Long id){
        return userRepository1.findById(id).orElse(null);
    }
    public User updateUserById(Long id,User user){
        User existingUser = userRepository1.findById(id).orElse(null);
        if (existingUser !=null){
            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
            return userRepository1.save(existingUser);
        }
        return null;

    }
    public void deleteUser(Long id){
        userRepository1.deleteById(id);
    }
}
