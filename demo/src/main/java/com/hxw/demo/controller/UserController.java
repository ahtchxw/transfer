package com.hxw.demo.controller;

import com.hxw.demo.bean.User;
import com.hxw.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController
{

    @Autowired
    private UserService userService;

    @PostMapping
    public int insertUser(@RequestBody User user) {
        return userService.insertUser(user);
    }

    @DeleteMapping("/{id}")
    public int deleteUser(@PathVariable String id) {
        return userService.deleteUser(id);
    }

    @PutMapping
    public int updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @GetMapping
    @CrossOrigin
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping("/login")
    @CrossOrigin
    public String login(@RequestBody User user) {
        System.out.println("登录");
        return userService.login(user);
    }
}
