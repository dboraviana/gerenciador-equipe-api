package com.gerenciador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciador.domain.Integrante;
import com.gerenciador.dto.IntegranteDTO;
import com.gerenciador.exception.ObjectNotFoundException;
import com.gerenciador.repository.IntegranteRepository;

@Service
public class IntegranteService {
	@Autowired
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

	public Integrante insert(Integrante obj) {
		obj.setId(null);
		return repositorio.save(obj);
	}

	public Integrante fromDTO(IntegranteDTO objDTO) {
		return new Integrante(objDTO.getId(), objDTO.getNome(), objDTO.getCpf(), objDTO.getCargo(),
				objDTO.getTipoContratacao());
	}

	public Integrante update(Integrante obj) {
		find(obj.getId());
		return repositorio.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		repositorio.delete(id);
	}
}
