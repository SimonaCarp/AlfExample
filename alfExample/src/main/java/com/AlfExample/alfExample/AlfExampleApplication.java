package com.AlfExample.alfExample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.AlfExample.alfExample.service", "com.AlfExample.alfExample.controllers"})
public class AlfExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlfExampleApplication.class, args);
	}

}
