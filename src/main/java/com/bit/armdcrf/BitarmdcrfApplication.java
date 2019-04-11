package com.bit.armdcrf;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.bit.armdcrf.dao")
public class BitarmdcrfApplication {

	public static void main(String[] args) {
		SpringApplication.run(BitarmdcrfApplication.class, args);
	}
}
