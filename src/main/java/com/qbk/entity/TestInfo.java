package com.qbk.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 @ApiModel:注解Model
 @ApiModelProperty:注解Model下的属性，当前端传过来的是一个对象时swagger中该对象的属性注解就是ApiModelProperty中的value

 @Data注解，类默认@ToString和@EqualsAndHashCode以及每个字段都有@Setter和@getter。该注解也会生成一个公共构造函数，可以将任何@NonNull和final字段作为参数。
 @Builder()类似于链式编程，使用Builder构造对象，更加便捷,但无法通过构造函数实例化
 @NoArgsConstructor:注解在类上;为类提供一个无参的构造方法
 @AllArgsConstructor:该注解使用在类上，该注解提供一个全参数的构造方法，默认不提供无参构造。
 */
@ApiModel(value = "TestInfo",description="测试实体对象")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestInfo implements Serializable{
    @ApiModelProperty(value = "主键",required=true)
    private Integer id ;
    @ApiModelProperty(value = "名称")
    private String name ;
}
