package com.example.mybatisdemo.mapper;




import com.example.mybatisdemo.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> getAll();

    User getOne(Long id);

    void insert(User user);


    void delete(Long id);


    void update(User user);
}
