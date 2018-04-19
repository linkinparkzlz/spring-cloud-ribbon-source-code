package com.example.spring.cloud.sourcecode.api;

import com.example.spring.cloud.sourcecode.domain.User;

import java.util.List;

public interface UserService {


    /**
     * 保存用户
     *
     * @param user
     * @return
     */
    boolean saveUser(User user);


    /**
     * 查询所有用户列表
     * @return
     */
    List<User> findAll();


}
