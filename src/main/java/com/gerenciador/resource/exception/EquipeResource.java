package com.gerenciador.resource.exception;

import com.gerenciador.domain.Equipe;
import com.gerenciador.dto.EquipeDTO;
import com.gerenciador.service.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/equipe")
public class EquipeResource {

    @Autowired
    private EquipeService service;


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Equipe> find (@PathVariable Integer id) {
        Equipe equipe = service.find(id);
        return ResponseEntity.ok().body(equipe);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<EquipeDTO>> findAll () {
        List<Equipe> list = service.findAll();
        List<EquipeDTO> listDTO = list.stream().map(obj -> new EquipeDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert (@Valid @RequestBody EquipeDTO objDTO) {
        Equipe obj = service.fromDTO(objDTO);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update (@RequestBody Equipe obj, @PathVariable Integer id) {
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete (@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.badRequest().build();
    }
}
