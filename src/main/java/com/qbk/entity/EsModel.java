package com.qbk.entity;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: quboka
 * @Date: 2018/11/19 10:51
 * @Description:
 */
@ApiModel(value = "EsModel",description="Es实体对象")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EsModel {
    private String id ;
    private String name ;
    private Integer age ;
    private Date date ;
}
