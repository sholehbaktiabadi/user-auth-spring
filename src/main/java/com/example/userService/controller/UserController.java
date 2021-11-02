package com.example.userService.controller;

import com.example.userService.entity.User;
import com.example.userService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController()
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping()
    public ArrayList<User> getAll(){
        return userService.findAll();
    }

    @PostMapping()
    public User createUser(@RequestBody() User user){
        return userService.saveUser(user);
    }

    @GetMapping("{id}")
    public User getOne(@PathVariable("id") int id){
        return userService.getOneId(id);
    }
}
