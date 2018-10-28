package com.qbk.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: quboka
 * @Date: 2018/10/29 00:04
 * @Description: TestInfo的VO
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestVo implements Serializable {
    private Integer id ;
    //字段不同
    private String username ;
}
