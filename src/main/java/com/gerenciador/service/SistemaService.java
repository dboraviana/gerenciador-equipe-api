package com.gerenciador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciador.domain.Sistema;
import com.gerenciador.dto.SistemaDTO;
import com.gerenciador.exception.ObjectNotFoundException;
import com.gerenciador.repository.SistemaRepository;

@Service
public class SistemaService {
    @Autowired
    private SistemaRepository repositorio;

    public Sistema find(Integer id) {
        Optional<Sistema> obj = repositorio.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Sistema não encontrado" + Sistema.class.getName()));
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
        repositorio.deleteById(id);

    }

    public Sistema update(Sistema obj) {
        find(obj.getId());
        return repositorio.save(obj);

    }

}
