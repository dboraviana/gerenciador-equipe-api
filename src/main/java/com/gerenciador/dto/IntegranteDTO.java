package com.gerenciador.dto;

import java.io.Serializable;

import com.gerenciador.domain.Integrante;

public class IntegranteDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;
    private Character cpf;
    private String cargo;
    private String tipoContratacao;

    public IntegranteDTO () {

    }

    public IntegranteDTO (Integrante obj) {
        id = obj.getId();
        nome = obj.getNome();
        cpf = obj.getCpf();
        cargo = obj.getCargo();
        tipoContratacao = obj.getTipoContratacao();

    }

    public Integer getId () {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public String getNome () {
        return nome;
    }

    public void setNome (String nome) {
        this.nome = nome;
    }

    public Character getCpf () {
        return cpf;
    }

    public void setCpf (Character cpf) {
        this.cpf = cpf;
    }

    public String getCargo () {
        return cargo;
    }

    public void setCargo (String cargo) {
        this.cargo = cargo;
    }

    public String getTipoContratacao () {
        return tipoContratacao;
    }

    public void setTipoContratacao (String tipoContratacao) {
        this.tipoContratacao = tipoContratacao;
    }

}
