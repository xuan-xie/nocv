package com.example.controller;

import com.example.common.Const;
import com.example.common.ServerResponse;
import com.example.pojo.User;
import com.example.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private HttpSession session;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ServerResponse login( Integer userId, String password) {
        ServerResponse response = userService.login(userId, password);
        // 登陆成功，那么就保存session信息，把session传给前端
        if (response.isSuccess()) {
            session.setAttribute(Const.CURRENT_USER, response);
            String token = session.getId();
            Map<String, String> map = new HashMap<>(1);
            map.put("token", token);
            response = ServerResponse.createSuccessData(map);
        }
        return response;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ServerResponse logout(Integer userId, String password) {
        session.removeAttribute(Const.CURRENT_USER);
        return ServerResponse.createSuccess();
    }

    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public ServerResponse userInfo( ) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createError("用户未登录，无法查看信息");
        }
        return ServerResponse.createSuccessData(user);
    }
}
