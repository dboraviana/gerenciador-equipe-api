package com.gerenciador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciador.domain.Sistema;
import com.gerenciador.dto.SistemaDTO;
import com.gerenciador.repository.SistemaRepository;
import com.gerenciador.resource.exception.ObjectNotFoundException;

@Service
public class SistemaService {
	@Autowired
	private SistemaRepository repositorio;

	public Sistema find(Integer id) {
		Sistema sistema = repositorio.findOne(id);
		if (sistema == null) {
			throw new ObjectNotFoundException("Não foi encontrado sistema com id: " + id);

		}
		return sistema;
	}

	public List<Sistema> findAll() {
		return repositorio.findAll();
	}

	public Sistema insert(Sistema obj) {
		obj.setId(null);
		return repositorio.save(obj);
	}

	public Sistema fromDTO(SistemaDTO objDTO) {
		return new Sistema(objDTO.getId(), objDTO.getNome(), objDTO.getDescricao(), objDTO.getDependencias());
	}

	public void delete(Integer id) {
		find(id);
		repositorio.delete(id);
	}

	public Sistema update(Sistema obj) {
		find(obj.getId());
		return repositorio.save(obj);

	}

}
