package com.freitas.redis.controller;

import com.freitas.redis.model.User;
import com.freitas.redis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/save")
    public ResponseEntity<User> save() {
        User user = userRepository.save(new User(1, "Raphael"));
        
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(location).body(user);
    }

    @RequestMapping("/findall")
    public ResponseEntity<Map<Long, User>> findAll() {
        Map<Long, User> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }

    @RequestMapping("/findone/{id}")
    public ResponseEntity<User> findOne(@PathVariable Long id) {
        User user = userRepository.fidnOne(id);
        return ResponseEntity.ok(user);
    }

    @RequestMapping("delete/{id}")
    public void delete(@PathVariable Long id) {
        userRepository.delete(id);
    }

}
