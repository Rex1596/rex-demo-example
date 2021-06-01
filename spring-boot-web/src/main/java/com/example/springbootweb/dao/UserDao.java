package com.example.springbootweb.dao;

import com.example.springbootweb.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author lzw
 * Create 2021/6/1
 * Description
 */
public interface UserDao extends JpaRepository<User, Long> {
    User findByUserName(String userName);
    User findByUserNameOrEmail(String username, String email);
}
