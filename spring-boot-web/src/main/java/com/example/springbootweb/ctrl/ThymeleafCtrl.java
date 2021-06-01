package com.example.springbootweb.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Author lzw
 * Create 2021/6/1
 * Description Thymeleaf测试
 */
@Controller
public class ThymeleafCtrl {

    @GetMapping("/hi")
    public String hello(Locale locale, Model model){
        model.addAttribute("greeting", "Hello!");

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        String formattedDate = dateFormat.format(date);
        model.addAttribute("currentTime", formattedDate);


        return "hello";
    }
}
