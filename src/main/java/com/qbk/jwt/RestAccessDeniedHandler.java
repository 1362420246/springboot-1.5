package com.qbk.jwt;

import com.alibaba.fastjson.JSON;
import com.qbk.util.BaseResultGenerator;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 自定403返回值
 */
@Component
public class RestAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) {
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