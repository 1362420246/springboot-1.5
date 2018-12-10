package com.qbk.jwt;

import com.alibaba.fastjson.JSON;
import com.qbk.util.BaseResultGenerator;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 自定401返回值
 *
 * @author hackyo
 * Created on 2017/12/9 20:10.
 */
@Component
public class EntryPointUnauthorizedHandler implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setStatus(200);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try {
            PrintWriter writer = response.getWriter();
            writer.print(JSON.toJSONString(BaseResultGenerator.error("登录失效")));
            writer.flush();
            writer.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

}