package com.example.demobinfa.repository;

import com.example.demobinfa.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

@Slf4j
@SpringBootTest
class UserRepositoryTest {

    @Resource
    private UserRepository userRepository;
    @Resource
    private UserRepositoryJpa userRepositoryJpa;

    @Test
    void say() {

        log.info("开始");

        List<User> userList = new LinkedList<>();
        for (int i = 0; i < 5000; i++) {
            User user = new User();
            user.setName("oumingyuan");
            userList.add(user);
        }
        userRepository.saveAll(userList);
        log.info("结束");
    }

    @Test
    void sayJPA() {

        log.info("开始");

        List<User> userList = new LinkedList<>();
        for (int i = 0; i < 5000; i++) {
            User user = new User();
            user.setName("oumingyuan");
            userList.add(user);
        }
        userRepositoryJpa.saveAll(userList);
        log.info("结束");
    }

}