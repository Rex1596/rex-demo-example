package com.example.springbootweb.dao;

import com.example.springbootweb.po.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.util.Date;

/**
 * Author lzw
 * Create 2021/6/1
 * Description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void test(){
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);

        User save = userDao.save(new User("aa1", "aa@126.com", "aa", "aa123456", formattedDate));



        Assert.assertEquals(1, userDao.findAll().size());

        userDao.delete(userDao.findByUserName("aa1"));
}
}
