package com.gerenciador.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gerenciador.domain.Integrante;
import com.gerenciador.exception.ObjectNotFoundException;
import com.gerenciador.repository.IntegranteRepository;

@Service
public class IntegranteService {

	private IntegranteRepository repositorio;

	public Integrante find(Integer id) {
		Integrante integrante = repositorio.findOne(id);

		if (integrante == null) {
			throw new ObjectNotFoundException("Não foi encontrado integrante com o id: " + id);

		}
		return integrante;
	}

	public List<Integrante> findAll() {
		return repositorio.findAll();
	}

}
