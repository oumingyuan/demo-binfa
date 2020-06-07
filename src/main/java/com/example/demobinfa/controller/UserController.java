package com.example.demobinfa.controller;

import com.example.demobinfa.entity.User;
import com.example.demobinfa.repository.UserRepository;
import com.example.demobinfa.repository.UserRepositoryJpa;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserRepository userRepository;
    @Resource
    private UserRepositoryJpa userRepositoryJpa;

    /**
     * http://localhost:8080/user/add?name=Tracy
     *
     * @param name name
     * @return object
     */
    @RequestMapping("/add")
    public Object add(@RequestParam(name = "name", required = true) String name) {
        User user = new User();
        user.setName(name);
        userRepository.save(user);
        return user;
    }

    @RequestMapping("/list")
    public Object list() {
        Iterable<User> users = userRepository.findAll();
        return users;
    }

    /**
     * http://localhost:8080/user/add/3000
     *
     * @param number
     */
    @GetMapping("/add/{number}")
    public void demo(@PathVariable(name = "number") int number) {
        log.info("开始");

        List<User> userList = new LinkedList<>();
        for (int i = 0; i < number; i++) {
            User user = new User();
            user.setName("oumingyuan");
            userList.add(user);
        }
        userRepository.saveAll(userList);
        log.info("结束");
    }

    /**
     * http://localhost:8080/user/add-jpa/3000
     *
     * @param number
     */
    @GetMapping("/add-jpa/{number}")
    public void addJpa(@PathVariable(name = "number") int number) {
        log.info("JPA开始");

        List<User> userList = new LinkedList<>();
        for (int i = 0; i < number; i++) {
            User user = new User();
            user.setName("oumingyuan");
            userList.add(user);
        }
        userRepositoryJpa.saveAll(userList);
        log.info("JPA结束");
    }




    public Object add123(@RequestParam(name = "name", required = true) String name) {
        User user = new User();
        user.setName(name);
        userRepository.save(user);


        return user;
    }


}