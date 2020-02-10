package com.gerenciador;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gerenciador.domain.Integrante;
import com.gerenciador.domain.Sistema;
import com.gerenciador.repository.IntegranteRepository;
import com.gerenciador.repository.SistemaRepository;

@SpringBootApplication
public class GerenciadorApplication implements CommandLineRunner {

	@Autowired
	private SistemaRepository sistemaRepository;
	
	@Autowired
	private IntegranteRepository integranteRepository;

	public static void main(String[] args) {
		SpringApplication.run(GerenciadorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Sistema sistema1 = new Sistema(null, "Sistema de Comercialização de Imoveis", "Emprestimo imobiliario",
				"Java, Spring Boot, Oracle");
		
		Integrante integrante1 = new Integrante(null, "Débora Viana",null, "Analista de Teste", "Terceirizado");

		sistemaRepository.save(Arrays.asList(sistema1));		
		integranteRepository.save(Arrays.asList(integrante1));

	}

}
