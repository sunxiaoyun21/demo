package com.example.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author 孙小云
 * @version 1.0
 * @date 2019/5/24 14:09
 **/

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="User对象", description="用户的实体")
public class UserModel {


    @ApiModelProperty(value = "主键id")
    private int id;


    @ApiModelProperty(value = "姓名")
    private  String userName;

    @ApiModelProperty(value = "密码")
    private  String password;

    @ApiModelProperty(value = "年龄")
    private  int age;
}
