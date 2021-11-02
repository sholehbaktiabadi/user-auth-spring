package com.example.userService.services.user.service;

import com.example.userService.services.user.entity.User;
import com.example.userService.services.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service()
public class UserService {
    @Autowired()
    private UserRepository userRepository;

    public User saveUser(User user){
        return  userRepository.save(user);
    }

    public List<User> bulkSave(List<User> user){
        return userRepository.saveAll(user);
    }

    public ArrayList<User> findAll(){
        return (ArrayList<User>) userRepository.findAll();
    }

    public User getOneId(int id){
        return userRepository.findById(id).orElse(null);
    }

    public User getOneName(String name){
        return userRepository.findByName(name);
    }

    public String getOnedelete(int id){
        userRepository.deleteById(id);
        return  "deleted id" + id;
    }

    public User updateUser(User user){
        User selected = userRepository.findById(user.getId()).orElse(null);
        selected.setName(user.getName());
        selected.setCity(user.getCity());
        return userRepository.save(selected);


    }
}
