package com.example.exception;

import java.util.Properties;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

/**
 * GlobException  全局异常处理类
 */
@Configuration
public class GlobException {

    public SimpleMappingExceptionResolver gExceptionResolver(){
        SimpleMappingExceptionResolver resolver =new SimpleMappingExceptionResolver();

        Properties mappings =new Properties();

        //key:异常的类型，必须是异常类型的全名
        //value:视图名 
        //如下：空指针异常及算数异常 都跳到500页面
        mappings.put("java.lang.NullPointerException", "500");
        mappings.put("java.lang.ArithmeticException", "500");
        //设置异常与视图映射信息
        resolver.setExceptionMappings(mappings);

        return resolver;
    }
}