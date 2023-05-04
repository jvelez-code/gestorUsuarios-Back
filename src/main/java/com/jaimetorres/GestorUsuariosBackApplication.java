package com.jaimetorres;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

public class GestorUsuariosBackApplication {
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		
		SpringApplication.run(GestorUsuariosBackApplication.class, args);
		System.out.print("Hola Mundo homeOfice:v1");
		
	}

}
