package com.freitas.redis.repository;

import com.freitas.redis.model.User;

import java.util.Map;

public interface UserRepository {

    void save(User user);
    User fidnOne(Long id);
    Map<Long, User> findAll();
    void update(User user);
    void delete(Long id);

}
