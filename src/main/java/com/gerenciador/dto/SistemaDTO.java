package com.gerenciador.dto;

import java.io.Serializable;

import com.gerenciador.domain.Sistema;

public class SistemaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String descricao;
	private String dependencias;
	
	
	public SistemaDTO() {
		
	}
	
	public SistemaDTO(Sistema obj) {
		id = obj.getId();
		nome = obj.getNome();
		descricao = obj.getDescricao();
		dependencias = obj.getDependencias();
		
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDependencias() {
		return dependencias;
	}

	public void setDependencias(String dependencias) {
		this.dependencias = dependencias;
	}
	
	
	
}
