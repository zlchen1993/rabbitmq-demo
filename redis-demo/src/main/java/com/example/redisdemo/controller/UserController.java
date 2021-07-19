package com.example.redisdemo.controller;

import com.example.redisdemo.model.User;
import com.example.redisdemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * @Cacheable产生缓存
 *
 * @CachePut更新缓存
 *
 * @CacheEvict删除缓存
 */
@RestController
@EnableCaching(proxyTargetClass = true)
/**
 * @EnableCaching注解是spring framework中的注解驱动的缓存管理功能。
 * 自spring版本3.1起加入了该注解如果你使用了这个注解，那么你就不需要在
 * XML文件中配置cache manager了
 */
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping("/add")
    public void add(){
        User user1=User.builder()
                .userName("czl")
                .passWord("123456")
                .email("12345678@qq.com")
                .build();
        User user2=User.builder()
                .userName("lyj")
                .passWord("123456")
                .email("987654321@qq.com")
                .build();
        List<User> lists=Arrays.asList(user1,user2);
        userService.addUser(user1);
        userService.addUser(user2);
        log.info("保存所有用户：{}",userService.getAll());
    }
    @RequestMapping("/getUsers")
    public void getAll(){
        for (int i = 0; i <5 ; i++) {
            log.info("read from cache");
            userService.getAll().forEach(c->log.info("获取的用户信息：{}",c));
        }
    }

    @RequestMapping("/reload")
    public void reload(){
        userService.reloadUser();
        userService.getAll().forEach(c->log.info("获取的用户信息：{}",c));
    }


    //session的Controller
    @RequestMapping("/uid")
    public String uid(HttpSession session){
        UUID uid = (UUID) session.getAttribute("/uid");
        if (uid==null){
            uid=UUID.randomUUID();
        }
        session.setAttribute("uid",uid);
        return session.getId();
    }


}
