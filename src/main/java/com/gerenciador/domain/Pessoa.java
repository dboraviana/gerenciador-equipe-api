package com.gerenciador.domain;

import com.gerenciador.enums.GeneroPessoa;
import com.gerenciador.enums.TipoPessoa;

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
    private Integer genero;
    private String email;
    private String telefone;
    private Integer tipoPessoa;

    public Pessoa () {
    }

    public Pessoa (Integer id, String nome, GeneroPessoa genero, String email, String telefone, TipoPessoa tipoPessoa) {
        this.id = id;
        this.nome = nome;
        this.genero = genero.getId();
        this.email = email;
        this.telefone = telefone;
        this.tipoPessoa = tipoPessoa.getId();
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
        this.genero = genero.getId();
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

    public TipoPessoa getTipoPessoa () {
        return TipoPessoa.toEnum(tipoPessoa);
    }

    public void setTipoPessoa (TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa.getId();
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(id, pessoa.id) &&
                Objects.equals(nome, pessoa.nome) &&
                Objects.equals(genero, pessoa.genero) &&
                Objects.equals(email, pessoa.email) &&
                Objects.equals(telefone, pessoa.telefone) &&
                Objects.equals(tipoPessoa, pessoa.tipoPessoa);
    }

    @Override
    public int hashCode () {
        return Objects.hash(id, nome, genero, email, telefone, tipoPessoa);
    }
}
