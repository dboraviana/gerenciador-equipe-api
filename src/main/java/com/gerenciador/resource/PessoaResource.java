package com.gerenciador.resource;

import com.gerenciador.domain.Pessoa;
import com.gerenciador.dto.PessoaDTO;
import com.gerenciador.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaResource {

    @Autowired
    private PessoaService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find (@PathVariable Integer id) {
        Pessoa pessoa = service.find(id);
        return ResponseEntity.ok().body(pessoa);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<PessoaDTO>> findAll () {
        List<Pessoa> list = service.findAll();
        List<PessoaDTO> listDTO = list.stream().map(obj -> new PessoaDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert (@Valid @RequestBody PessoaDTO objDTO) {
        Pessoa obj = service.fromDTO(objDTO);

        obj = service.insert(obj);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update (@RequestBody Pessoa obj, @PathVariable Integer id) {
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
