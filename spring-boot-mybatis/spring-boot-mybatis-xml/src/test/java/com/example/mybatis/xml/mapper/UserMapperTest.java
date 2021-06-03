package com.example.mybatis.xml.mapper;

import com.example.mybatis.xml.enums.UserSexEnum;
import com.example.mybatis.xml.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void getAll() {
        userMapper.getAll().forEach(System.out::println);
    }

    @Test
    public void getOne() {
        System.out.println(userMapper.getOne(28L));
    }

    @Test
    public void insert() {
        userMapper.insert(new User("big_cat","ss", UserSexEnum.MAN));
    }

    @Test
    public void update() {
        User user = new User();
        user.setId(30L);
        user.setNickName("猫咪");
        userMapper.update(user);
    }

    @Test
    public void delete() {
        userMapper.delete(49L);
    }
}