package com.freitas.redis.controller;

import com.freitas.redis.model.User;
import com.freitas.redis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/save")
    public String save() {
        userRepository.save(new User(1, "Raphael"));
        userRepository.save(new User(2, "Freitas"));
        return "Done";
    }

    @RequestMapping("/findall")
    public String findAll() {
        String result = "";
        Map<Long, User> users = userRepository.findAll();

        for (User user : users.values()) {
            result += user.toString() + "<br>";
        }

        return result;

    }

}
