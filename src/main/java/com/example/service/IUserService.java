package com.example.service;

import com.example.common.ServerResponse;
import com.example.pojo.User;

public interface IUserService {
    ServerResponse<User> login(Integer userId, String password);
}
