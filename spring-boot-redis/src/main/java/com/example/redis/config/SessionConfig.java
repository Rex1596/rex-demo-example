package com.example.redis.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Author lzw
 * Create 2021/6/2
 * Description
 */
@Configuration
// maxInactiveIntervalInSeconds: 设置 Session 失效时间
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 86400*30)
public class SessionConfig {
}
