package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.example.Controller","com.example.Service"})
@MapperScan(basePackages = {"com.example.Mapper"})
@SpringBootApplication
public class HyspringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(HyspringbootApplication.class, args);
	}
}
