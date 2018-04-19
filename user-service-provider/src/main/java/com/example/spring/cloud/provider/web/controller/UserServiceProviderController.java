package com.example.spring.cloud.provider.web.controller;

import com.example.spring.cloud.sourcecode.api.UserService;
import com.example.spring.cloud.sourcecode.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserServiceProviderController {


    @Autowired
    private UserService userService;

    @PostMapping("/user/save")
    public boolean user(@RequestBody User user) {

        return userService.saveUser(user);
    }


}























