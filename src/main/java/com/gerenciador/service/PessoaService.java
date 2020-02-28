package com.gerenciador.service;

import com.gerenciador.domain.Pessoa;
import com.gerenciador.domain.Sistema;
import com.gerenciador.dto.PessoaDTO;
import com.gerenciador.dto.SistemaDTO;
import com.gerenciador.enums.TipoPessoa;
import com.gerenciador.exception.ObjectNotFoundException;
import com.gerenciador.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repositorio;

    public Pessoa find (Integer id) {
        Pessoa pessoa = repositorio.findOne(id);
        if (pessoa == null) {
            throw new ObjectNotFoundException("Não foi encontrado pessoa para o id:  " + id);
        }
        return pessoa;
    }

    public List<Pessoa> findAll () {
        return repositorio.findAll();
    }

    public Pessoa insert (Pessoa obj) {
        obj.setId(null);
        return repositorio.save(obj);
    }

    public Pessoa fromDTO (PessoaDTO objDTO) {
        return new Pessoa(objDTO.getId(), objDTO.getNome(), objDTO.getGenero(), objDTO.getEmail(), objDTO.getTelefone());

    }

    public void delete (Integer id) {
        find(id);
        repositorio.delete(id);
    }

    public Pessoa update (Pessoa obj) {
        find(obj.getId());
        return repositorio.save(obj);

    }
}
