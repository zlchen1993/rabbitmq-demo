package com.example.webdemo.dao;

import com.example.webdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author czl
 */
public interface UserRepository extends JpaRepository<User,Long> {
    /**
     *提供用户名查找
     */
    User findByUserName(String userName);

    User findByUserNameOrEmail(String userName,String email);
}
