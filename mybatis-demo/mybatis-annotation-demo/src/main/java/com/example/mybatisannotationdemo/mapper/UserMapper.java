package com.example.mybatisannotationdemo.mapper;


import com.example.mybatisannotationdemo.enums.UserSexEnum;
import com.example.mybatisannotationdemo.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from users")
    @Results({@Result(property = "userSex",column = "user_sex",javaType = UserSexEnum.class),
            @Result(property = "nickName",column = "nick_name")
    })
    List<User> getAll();
    @Select("select * from users where id=#{id}")
    @Results({
            @Result(property = "userSex",  column = "user_sex", javaType = UserSexEnum.class),
            @Result(property = "nickName", column = "nick_name")
    })
    User getOne(Long id);
    @Insert("insert into users(userName,passWord,user_sex) values (#{userName},#{passWord},#{userSex})")
    void insert(User user);

    @Delete("drop from users where id=#{id}")
    void delete(Long id);

    @Update("UPDATE users SET userName=#{userName},nick_name=#{nickName} WHERE id =#{id}")
    void update(User user);
}
