package com.example.mybatisannotationdemo.controller;

import com.example.mybatisannotationdemo.mapper.UserMapper;
import com.example.mybatisannotationdemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserMapper mapper;

    @RequestMapping("/getUsers")
    public List<User> getAll(){
        List<User> users = mapper.getAll();
        users.stream().forEach(System.out::print);
        return users;
    }

    @RequestMapping("/getOne")
    public User getOne(Long id){
        User user=mapper.getOne(id);
        return user;
    }

    @RequestMapping("/add")
    public void save(User user) {
        mapper.insert(user);
    }

    @RequestMapping(value="update")
    public void update(User user) {
        mapper.update(user);
    }

    @RequestMapping(value="/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        mapper.delete(id);
    }
}
