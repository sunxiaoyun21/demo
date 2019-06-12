package com.example.dubbo;

import com.example.api.UserApi;
import com.alibaba.dubbo.config.annotation.Service;

import com.example.entity.UserEntity;
import com.example.mapper.MapperFactory;
import com.example.model.UserModel;
import com.example.utils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @author 孙小云
 * @version 1.0
 * @date 2019/5/24 14:15
 **/

@Service
@Component
public class UserService implements UserApi {

    @Autowired
    MapperFactory mapperFactory;


    @Override
    public boolean saveUser(UserModel userModel) {

        return mapperFactory.userMapper.insert( BeanUtils.copy(userModel, UserEntity.class))>0;
    }
}
