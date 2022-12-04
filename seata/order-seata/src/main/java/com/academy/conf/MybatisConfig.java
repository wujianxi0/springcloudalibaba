package com.academy.conf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.academy.order.mapper")
public class MybatisConfig {

}
