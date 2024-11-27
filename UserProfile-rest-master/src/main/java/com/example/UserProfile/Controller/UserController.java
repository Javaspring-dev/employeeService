package com.example.UserProfile.Controller;

import com.example.UserProfile.model.User;
import com.example.UserProfile.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping()
    //User for Model
    public User  createUser(@RequestBody User user){
System.out.println("Recived user:"+ user); return userService.createUser(user);
    }
    @GetMapping("/getalluser")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }
    @PutMapping("/{id}")
    public User updateUser(@PathVariable long id ,@RequestBody User user){
        return userService.updateUserById(id, user);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
}
}