package com.gerenciador.dto;

import com.gerenciador.domain.Equipe;

import java.io.Serializable;

public class EquipeDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nomeEquipe;
    private String descricao;

    public EquipeDTO () {

    }

    public EquipeDTO (Equipe obj) {
        this.id = obj.getId();
        this.nomeEquipe = obj.getNomeEquipe();
        this.descricao = obj.getDescricao();
    }

    public Integer getId () {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public String getNomeEquipe () {
        return nomeEquipe;
    }

    public void setNomeEquipe (String nomeEquipe) {
        this.nomeEquipe = nomeEquipe;
    }

    public String getDescricao () {
        return descricao;
    }

    public void setDescricao (String descricao) {
        this.descricao = descricao;
    }
}
