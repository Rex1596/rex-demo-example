package com.example.mybatis.annotation.mapper;

import com.example.mybatis.annotation.enums.UserSexEnum;
import com.example.mybatis.annotation.model.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class UserMapperTest {

    @Autowired
    private UserMapper  userMapper;

    @Test
    void getUserByName() {
        System.out.println(userMapper.getUserByName("大猫"));
    }

    @Test
    void getOne() {
        System.out.println(userMapper.getOne(28L));
    }

    @Test
    void getAll() {
        userMapper.getAll().forEach(System.out::println);
    }

    @Test
    void insert() {
        for (int i = 0; i < 10; i++) {
            System.out.println(userMapper
                    .insert(new User(
                            "a" + i,
                            i + "",
                            i % 2 == 0 ? UserSexEnum.MAN : UserSexEnum.WOMAN)));
        }
    }

    @Test
    void update() {
        User user = new User();
        user.setId(28L);
        user.setUserName("大猫");
        user.setNickName("大猫");
        System.out.println(userMapper.update(user));
    }

    @Test
    void delete() {
        User user = new User();
        user.setId(29L);
        System.out.println(userMapper.delete(user));
    }


}