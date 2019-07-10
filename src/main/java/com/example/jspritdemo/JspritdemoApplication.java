package com.example.jspritdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.example.jspritdemo.dao")
public class JspritdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JspritdemoApplication.class, args);
	}

}
