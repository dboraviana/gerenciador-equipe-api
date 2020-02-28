package com.gerenciador.domain;

import com.gerenciador.enums.GeneroPessoa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Pessoa implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String genero;
    private String email;
    private String telefone;


    public Pessoa () {
    }

    public Pessoa (Integer id, String nome, GeneroPessoa genero, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.genero = genero.getCodigo();
        this.email = email;
        this.telefone = telefone;

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

    public GeneroPessoa getGenero () {
        return GeneroPessoa.toEnum(genero);
    }

    public void setGenero (GeneroPessoa genero) {
        this.genero = genero.getCodigo();
    }

    public String getEmail () {
        return email;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public String getTelefone () {
        return telefone;
    }

    public void setTelefone (String telefone) {
        this.telefone = telefone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(id, pessoa.id) &&
                Objects.equals(nome, pessoa.nome) &&
                Objects.equals(genero, pessoa.genero) &&
                Objects.equals(email, pessoa.email) &&
                Objects.equals(telefone, pessoa.telefone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, genero, email, telefone);
    }
}
