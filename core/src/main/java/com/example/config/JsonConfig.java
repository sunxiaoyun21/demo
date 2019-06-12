package com.example.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import com.example.core.others.AjaxSerializerModifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * JSON相关的配置
 *
 * @author sxy
 * @version 1.0
 * @date 2019/4/2 17:54
 **/
@Configuration
@ConditionalOnClass(ObjectMapper.class)
public class JsonConfig {
    /**
     * 基本配置
     */
    private ObjectMapper baseObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        // 转换为格式化的json
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        //如果字段类型为空，不报错
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        //如果json中的字段在实体类中未出现，不报错
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper;
    }

    @Bean
    AjaxSerializerModifier ajaxSerializerModifier() {
        return new AjaxSerializerModifier();
    }

    /**
     * jackson对象声明
     */
    @Bean
    @ConditionalOnProperty(prefix = "common", name = "jackson", havingValue = "true", matchIfMissing = true)
    @ConditionalOnClass(ObjectMapper.class)
    public ObjectMapper objectMapper() {
        return baseObjectMapper();
    }

    /**
     * jackson对象声明
     */
    @Bean("ajaxObjectMapper")
    @ConditionalOnProperty(prefix = "common", name = "jackson", havingValue = "true", matchIfMissing = true)
    @ConditionalOnClass(ObjectMapper.class)
    public ObjectMapper ajaxObjectMapper(AjaxSerializerModifier ajaxSerializerModifier) {
        ObjectMapper objectMapper = baseObjectMapper();
        // 为mapper注册一个带有SerializerModifier的Factory，针对值为null的字段进行特殊处理
        objectMapper.setSerializerFactory(objectMapper.getSerializerFactory().withSerializerModifier(ajaxSerializerModifier));
        return objectMapper;
    }

}
