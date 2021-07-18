package com.example.webdemo.controller;

import com.example.webdemo.dao.UserRepository;
import com.example.webdemo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author czl
 */
@Slf4j
@RestController
public class MyController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/getUser")
    public User getUser(){
        User user=userRepository.findByUserName("aa");
        log.info("成功获取用户信息：{}",user);
        return user;
    }

    @RequestMapping("/getUsers")
    public List<User> getUsers(){
        List<User> users=userRepository.findAll();
        users.forEach(c->log.info("成功获取用户信息：{}",users));
        return users;
    }

    @RequestMapping("/add")
    public void insert(){
        User user1=User.builder()
                .userName("aa")
                .passWord("123456")
                .email("12345678@qq.com")
                .nickName("czl")
                .creatTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();
        User user2=User.builder()
                .userName("bb")
                .passWord("123456")
                .email("123456789@qq.com")
                .nickName("lyj")
                .creatTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();
        List<User> users=new ArrayList<>();
        users.add(user1);
        users.add(user2);
        userRepository.saveAll(users);
        log.info("add users: {}",users);
    }

}
