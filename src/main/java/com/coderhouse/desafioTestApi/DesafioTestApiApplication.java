package com.coderhouse.desafioTestApi;

import com.coderhouse.desafioTestApi.model.Producto;
import com.coderhouse.desafioTestApi.repository.RepositoryProductos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DesafioTestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioTestApiApplication.class, args);
	}
}
