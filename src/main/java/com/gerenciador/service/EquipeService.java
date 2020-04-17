package com.gerenciador.service;

import com.gerenciador.domain.Equipe;
import com.gerenciador.domain.Integrante;
import com.gerenciador.domain.Sistema;
import com.gerenciador.dto.EquipeDTO;
import com.gerenciador.dto.IntegranteDTO;
import com.gerenciador.exception.ObjectNotFoundException;
import com.gerenciador.repository.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipeService {

    @Autowired
    private EquipeRepository repositorio;

    public Equipe find(Integer id) {
        Optional<Equipe> obj = repositorio.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Sistema não encontrado" + Equipe.class.getName()));
    }

    public List<Equipe> findAll() {
        return repositorio.findAll();
    }

    public Equipe insert(Equipe obj) {
        obj.setId(null);
        return repositorio.save(obj);
    }

    public Equipe fromDTO(EquipeDTO objDTO) {
        return new Equipe(objDTO.getId(), objDTO.getNomeEquipe(), objDTO.getDescricao());
    }

    public Equipe update(Equipe obj) {
        find(obj.getId());
        return repositorio.save(obj);
    }

    public void delete(Integer id) {
        find(id);
        repositorio.deleteById(id);
    }
}
