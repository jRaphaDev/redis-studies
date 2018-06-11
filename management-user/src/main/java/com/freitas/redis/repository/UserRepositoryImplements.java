package com.freitas.redis.repository;

import com.freitas.redis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepositoryImplements implements UserRepository {

    private static final String KEY =  "user";

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations<String, Long, User> hashOperations;

    @PostConstruct
    private void init(){
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(User user) {
        hashOperations.put(KEY, user.getId(), user);
    }

    @Override
    public User fidnOne(Long id) {
        return hashOperations.get(KEY, id);
    }

    @Override
    public Map<Long, User> findAll() {
        return hashOperations.entries(KEY);
    }

    @Override
    public void update(User user) {
        hashOperations.put(KEY, user.getId(), user);
    }

    @Override
    public void delete(Long id) {
        hashOperations.delete(KEY, id);
    }
}
