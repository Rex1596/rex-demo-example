package com.example.springbootweb.ctrl;

import com.example.springbootweb.po.User;
import com.example.springbootweb.util.RexProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author lzw
 * Create 2021/6/1
 * Description json 接口开发
 */
@RestController
public class HelloCtrl {
    @Value("${com.rex.title}")
    private String title;
    @Value("${com.rex.description}")
    private String description;

    @RequestMapping("/user")
    public User getUser(){
        return new User("张三","123456");
    }

    @RequestMapping("/prop")
    public String getProperties(){

        return title+"  "+description;
    }
}
