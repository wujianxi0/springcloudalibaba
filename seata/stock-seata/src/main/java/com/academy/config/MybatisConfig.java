package com.academy.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.academy.stock.mapper")
public class MybatisConfig {

}
