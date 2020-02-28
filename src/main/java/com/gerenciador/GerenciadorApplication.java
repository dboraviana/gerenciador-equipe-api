package com.gerenciador;

import com.gerenciador.domain.Equipe;
import com.gerenciador.domain.Integrante;
import com.gerenciador.domain.Pessoa;
import com.gerenciador.domain.Sistema;
import com.gerenciador.enums.GeneroPessoa;
import com.gerenciador.enums.TipoPessoa;
import com.gerenciador.repository.EquipeRepository;
import com.gerenciador.repository.IntegranteRepository;
import com.gerenciador.repository.PessoaRepository;
import com.gerenciador.repository.SistemaRepository;
import com.gerenciador.resource.exception.EquipeResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class GerenciadorApplication implements CommandLineRunner {

    @Autowired
    private SistemaRepository sistemaRepository;

    @Autowired
    private IntegranteRepository integranteRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EquipeRepository equipeRepository;

    public static void main (String[] args) {
        SpringApplication.run(GerenciadorApplication.class, args);
    }

    @Override
    public void run (String... args) throws Exception {
        Sistema sistema1 = new Sistema(null, "Sistema de Comercialização de Imoveis", "Emprestimo imobiliario",
                "Java, Spring Boot, Oracle");

        Integrante integrante1 = new Integrante(null, "Débora Viana", null, "Analista de Teste", "Terceirizado");


        Pessoa pessoa1 = new Pessoa(null, "Débora Viana", GeneroPessoa.FEMININO, "deboranwa@gmail.com", "51981109313");

        Equipe equipe1 = new Equipe(null, "Unidos venceremos", "a união faz a força");


        sistemaRepository.save(Arrays.asList(sistema1));
        integranteRepository.save(Arrays.asList(integrante1));
        pessoaRepository.save(Arrays.asList(pessoa1));
        equipeRepository.save(Arrays.asList(equipe1));

    }

}
