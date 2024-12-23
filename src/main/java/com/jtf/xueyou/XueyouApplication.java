package com.jtf.xueyou;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jtf.xueyou.mapper")
public class XueyouApplication {

    public static void main(String[] args) {
        SpringApplication.run(XueyouApplication.class, args);
    }

}
