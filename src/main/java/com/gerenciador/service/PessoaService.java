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
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repositorio;

    public Pessoa find(Integer id) {
        Optional<Pessoa> obj = repositorio.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Sistema não encontrado" + Pessoa.class.getName()));
    }

    public List<Pessoa> findAll() {
        return repositorio.findAll();
    }

    public Pessoa insert(Pessoa obj) {
        obj.setId(null);
        return repositorio.save(obj);
    }

    public Pessoa fromDTO(PessoaDTO objDTO) {
        return new Pessoa(objDTO.getId(), objDTO.getNome(), objDTO.getGenero(), objDTO.getEmail(), objDTO.getTelefone());

    }

    public void delete(Integer id) {
        find(id);
        repositorio.deleteById(id);
    }

    public Pessoa update(Pessoa obj) {
        find(obj.getId());
        return repositorio.save(obj);

    }
}
