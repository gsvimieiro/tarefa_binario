package com.cast.tarefabinario.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Arquivo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	@Lob
	private String direito;
	
	@Lob
	private String esquerdo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDireito() {
		return direito;
	}

	public void setDireito(String direito) {
		this.direito = direito;
	}

	public String getEsquerdo() {
		return esquerdo;
	}

	public void setEsquerdo(String esquerdo) {
		this.esquerdo = esquerdo;
	}

}
