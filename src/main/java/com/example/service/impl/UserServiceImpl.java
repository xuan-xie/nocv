package com.example.service.impl;

import com.example.common.ServerResponse;
import com.example.dao.UserMapper;
import com.example.pojo.User;
import com.example.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public ServerResponse<User> login(Integer userId, String password) {
        // 1.先查账号
        int count = userMapper.countByUserId(userId);
        if (count == 0){
            return ServerResponse.createError("账号密码错误");
        }
        // 2,账号存在再查密码
        User user = userMapper.selectLoginInfo(userId, password);
        if (user == null){
            return ServerResponse.createError("账号密码错误");

        }
        user.setPassword(StringUtils.EMPTY);
        return ServerResponse.createSuccessData("登陆成功", user);
    }
}
