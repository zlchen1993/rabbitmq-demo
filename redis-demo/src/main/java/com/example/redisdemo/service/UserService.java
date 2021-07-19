package com.example.redisdemo.service;

import com.example.redisdemo.model.User;
import com.example.redisdemo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@CacheConfig(cacheNames = "user")
public class UserService {

    @Autowired
    private UserRepository repository;

    @Cacheable
    public List<User> getAll(){
        List<User> users = repository.findAll();
        return users;
    }

    public void addUser(User user){
        repository.save(user);
    }
    @CacheEvict
    public void reloadUser(){

    }

    public Optional<User> findOneUser(String name){
        ExampleMatcher matcher=ExampleMatcher.matching().withMatcher("name",ExampleMatcher.GenericPropertyMatchers.exact()
                .ignoreCase());
        Optional<User> user=repository.findOne(Example.of(User.builder().userName(name).build(),matcher));
        log.info("user found：{}",user);
        return user;
    }


}
