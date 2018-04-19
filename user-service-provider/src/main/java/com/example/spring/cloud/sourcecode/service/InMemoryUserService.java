package com.example.spring.cloud.sourcecode.service;

import com.example.spring.cloud.sourcecode.api.UserService;
import com.example.spring.cloud.sourcecode.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class InMemoryUserService implements UserService {


    private Map<Long, User> repository = new ConcurrentHashMap<>();


    @Override
    public boolean saveUser(User user) {
        return repository.put(user.getId(), user) == null;
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(repository.values());
    }
}
