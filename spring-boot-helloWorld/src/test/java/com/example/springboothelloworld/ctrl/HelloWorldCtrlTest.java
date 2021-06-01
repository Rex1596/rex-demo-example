package com.example.springboothelloworld.ctrl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class) // 为JUnit的运行环境
@WebMvcTest(HelloWorldCtrl.class)
class HelloWorldCtrlTest {


    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        System.out.println("============== 测试类开始 ==============");
    }

    @AfterEach
    void tearDown(){
        System.out.println("============== 测试类结束 ==============");
    }



    @Test
    void helloWorld() throws Exception {
        ResultActions result = mockMvc.perform(MockMvcRequestBuilders
                .get("/helloWorld")
                // 设置UTF-8
                .accept("application/json;charset=UTF-8"))
                // 是否 200
                .andExpect(MockMvcResultMatchers.status().isOk())
                // 打印结果
                .andDo(MockMvcResultHandlers.print());
        System.out.println(result.andReturn().getResponse().getContentAsString());
    }
}