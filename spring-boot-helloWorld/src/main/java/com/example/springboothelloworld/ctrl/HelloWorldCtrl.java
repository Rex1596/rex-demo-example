package com.example.springboothelloworld.ctrl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author lzw
 * Create 2021/5/31
 * Description hello world
 */
@RestController
public class HelloWorldCtrl {

    @GetMapping("/helloWorld")
    public String helloWorld(){
        return "Hello World!!!";
    }
}
