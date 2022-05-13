package com.pro.ClienteApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.pro.ClienteApp.model.entity.ClienteEntity;
import com.pro.ClienteApp.model.repository.ClienteRepository;

@SpringBootApplication
public class ClienteAppApplication {
	
	@Bean
	public CommandLineRunner Run(@Autowired ClienteRepository repository) {
		return args -> {
			ClienteEntity cliente = ClienteEntity.builder().cpf("10955116708")
					.nome("Patrick Ribeiro").build();;
			repository.save(cliente);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ClienteAppApplication.class, args);
	}

}
