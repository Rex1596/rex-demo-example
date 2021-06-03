package com.example.mybatis.xml.mapper;

import com.example.mybatis.xml.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Author lzw
 * Create 2021/6/3
 * Description
 */
@Mapper
public interface UserMapper {

    List<User> getAll();

    User getOne(Long id);

    void insert(User user);

    void update(User user);

    void delete(Long id);

}