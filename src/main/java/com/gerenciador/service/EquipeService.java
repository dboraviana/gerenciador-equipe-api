package com.gerenciador.service;

import com.gerenciador.domain.Equipe;
import com.gerenciador.domain.Integrante;
import com.gerenciador.dto.EquipeDTO;
import com.gerenciador.dto.IntegranteDTO;
import com.gerenciador.exception.ObjectNotFoundException;
import com.gerenciador.repository.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipeService {

    @Autowired
    private EquipeRepository repositorio;

    public Equipe find (Integer id) {
        Equipe equipe = repositorio.findOne(id);

        if (equipe == null) {
            throw new ObjectNotFoundException("Não foi encontrado equipe com o id: " + id);

        }
        return equipe;
    }

    public List<Equipe> findAll () {
        return repositorio.findAll();
    }

    public Equipe insert (Equipe obj) {
        obj.setId(null);
        return repositorio.save(obj);
    }

    public Equipe fromDTO (EquipeDTO objDTO) {
        return new Equipe(objDTO.getId(), objDTO.getNomeEquipe(), objDTO.getDescricao());
    }

    public Equipe update (Equipe obj) {
        find(obj.getId());
        return repositorio.save(obj);
    }

    public void delete (Integer id) {
        find(id);
        repositorio.delete(id);
    }
}
