package com.qbk.entity;

import lombok.Data;


import java.util.Date;
import java.util.List;

/**
 * @Author: quboka
 * @Date: 2018/12/9 16:43
 * @Description: user实体
 */
@Data
public class User {
    private String id;
    private String username;
    private String password;
    private List<String> roles;
}
