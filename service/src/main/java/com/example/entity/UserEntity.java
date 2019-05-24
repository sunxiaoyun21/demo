package com.example.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Table;

/**
 * @author 孙小云
 * @version 1.0
 * @date 2019/5/24 14:17
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Table(name = "user")
public class UserEntity {


    private int Id;

    private String userName;

    private  String password;

    private  int age;

}
