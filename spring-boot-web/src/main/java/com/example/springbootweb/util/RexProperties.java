package com.example.springbootweb.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Author lzw
 * Create 2021/6/1
 * Description 读取配置文件
 */
@Component
public class RexProperties {

    @Value("${com.rex.title}")
    private String title;
    @Value("${com.rex.description}")
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String show(){
        return title+" "+description;
    }
}
