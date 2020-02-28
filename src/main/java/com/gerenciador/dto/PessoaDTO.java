package com.gerenciador.dto;

import com.gerenciador.domain.Pessoa;
import com.gerenciador.enums.GeneroPessoa;
import com.gerenciador.enums.TipoPessoa;

import java.io.Serializable;

public class PessoaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;
    private GeneroPessoa genero;
    private String email;
    private String telefone;


    public PessoaDTO() {

    }

    public PessoaDTO(Pessoa obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.genero = obj.getGenero();
        this.email = obj.getEmail();
        this.telefone = obj.getTelefone();

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public GeneroPessoa getGenero() {
        return genero;
    }

    public void setGenero(GeneroPessoa genero) {
        this.genero = genero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
