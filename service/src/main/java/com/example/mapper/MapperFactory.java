package com.example.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 孙小云
 * @version 1.0
 * @date 2019/5/24 14:25
 **/
@Component
public class MapperFactory {


    @Autowired
    public  UserMapper userMapper;
}
