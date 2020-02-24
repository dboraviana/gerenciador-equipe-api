package com.gerenciador.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Equipe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nomeEquipe;
    private String descricao;
//    private  Sistema sistema;
//    private Pessoa integrante;


    public Equipe () {
    }

    public Equipe (Integer id, String nomeEquipe, String descricao) {
        this.id = id;
        this.nomeEquipe = nomeEquipe;
        this.descricao = descricao;

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

//    public Sistema getSistema () {
//        return sistema;
//    }
//
//    public void setSistema (Sistema sistema) {
//        this.sistema = sistema;
//    }
//
//    public Pessoa getIntegrante () {
//        return integrante;
//    }
//
//    public void setIntegrante (Pessoa integrante) {
//        this.integrante = integrante;

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipe equipe = (Equipe) o;
        return Objects.equals(id, equipe.id) &&
                Objects.equals(nomeEquipe, equipe.nomeEquipe) &&
                Objects.equals(descricao, equipe.descricao);
    }

    @Override
    public int hashCode () {
        return Objects.hash(id, nomeEquipe, descricao);
    }
//    }


}
