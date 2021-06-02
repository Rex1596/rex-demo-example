package com.example.springbootjpa.repository;

import com.example.springbootjpa.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void initialUser(){
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);

        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User(i+"", i+"", i+"@126.com", i+"", formattedDate);
            users.add(user);
        }
        userRepository.saveAll(users);
    }

    @Test
    public void testBaseQuery() {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);
        User user = new User("ff", "ff123456", "ff@126.com", "ff", formattedDate);
        userRepository.save(user);
        System.out.println("count:  " + userRepository.count());
        System.out.println("findById:  " + userRepository.findById(1L));
        userRepository.findAll().forEach(System.out::println);
        userRepository.delete(user);
        System.out.println("existsById:  " + userRepository.existsById(1L));
    }
    @Test
    public void testPageQuery() throws Exception {
        int page=1,size=2;
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page, size, sort);
        userRepository.findALL(pageable);
        userRepository.findByNickName("testName", pageable);
    }
}