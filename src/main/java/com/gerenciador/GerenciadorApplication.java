package com.gerenciador;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gerenciador.domain.Sistema;
import com.gerenciador.repository.SistemaRepository;

@SpringBootApplication
public class GerenciadorApplication implements CommandLineRunner {

	@Autowired
	private SistemaRepository sistemaRepository;

	public static void main(String[] args) {
		SpringApplication.run(GerenciadorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Sistema sistema1 = new Sistema(null, "Sistema de Comercialização de Imoveis", "Emprestimo imobiliario",
				"Java, Spring Boot, Oracle");

		sistemaRepository.save(Arrays.asList(sistema1));

	}

}
