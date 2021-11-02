package com.example.userService.services.user.controller;

import com.example.userService.config.MyUserDetailService;
import com.example.userService.model.AuthenticationRequest;
import com.example.userService.model.AuthenticationResponse;
import com.example.userService.services.user.entity.User;
import com.example.userService.services.user.service.UserService;
import com.example.userService.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController()
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private MyUserDetailService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

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
