package com.qbk.controller;

import com.qbk.entity.User;
import com.qbk.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.sasl.AuthenticationException;
import javax.servlet.http.HttpServletRequest;

/**
 * 其他请求需要 设置 Headers  Authorization : Bearer + token
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/user", produces = "text/html;charset=UTF-8")
public class AuthController {
    @Autowired
    private AuthService authService;

    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 操作结果
     * @throws AuthenticationException 错误信息
     */
    @PostMapping(value = "/login", params = {"username", "password"})
    public String getToken(String username, String password) throws AuthenticationException {
        return authService.login(username, password);
    }

    /**
     * 用户注册
     *
     * @param user          用户信息
     * @return 操作结果
     * @throws AuthenticationException 错误信息
     */
    @PostMapping(value = "/register")
    public String register(User user) throws AuthenticationException {
        return authService.register(user);
    }

    /**
     * 刷新密钥
     *
     * @param authorization 原密钥
     * @return 新密钥
     * @throws AuthenticationException 错误信息
     */
    @GetMapping(value = "/refreshToken")
    public String refreshToken(@RequestHeader String authorization) throws AuthenticationException {
        return authService.refreshToken(authorization);
    }
}
