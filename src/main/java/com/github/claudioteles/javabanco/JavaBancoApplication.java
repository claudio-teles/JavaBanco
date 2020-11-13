package com.github.claudioteles.javabanco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.github.claudioteles.javabanco")
public class JavaBancoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaBancoApplication.class, args);
	}

}
