package com.example.mybatisannotationdemo;

import com.example.mybatisannotationdemo.enums.UserSexEnum;
import com.example.mybatisannotationdemo.mapper.UserMapper;
import com.example.mybatisannotationdemo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class MybatisAnnotationDemoApplicationTests {

    @Autowired
    private UserMapper mapper;
    @Test
    public void testAdd(){
        mapper.insert(User.builder().userName("aa").passWord("123456").userSex(UserSexEnum.MAN).build());
        mapper.insert(User.builder().userName("bb").passWord("123456").userSex(UserSexEnum.WOMAN).build());
        mapper.insert(User.builder().userName("cc").passWord("123456").userSex(UserSexEnum.MAN).build());
        System.out.println(mapper.getOne(3L));
    }


}
