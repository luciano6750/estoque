package com.example.demo.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Votos implements Serializable{
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	private VotosPK id = new VotosPK();

	private String protocolo;

	public Votos() {
	}

	public Votos(Candidato candidato, Usuario usuario, String protocolo) {
		super();
		id.setCandidato(candidato);
		id.setUsuario(usuario);
		this.protocolo = protocolo;
	}

	public VotosPK getId() {
		return id;
	}

	public void setId(VotosPK id) {
		this.id = id;
	}
	@JsonIgnore
	public Candidato getCandidato() {
		return id.getCandidato();
	}

	public void setCandidato(Candidato candidato) {
		 id.setCandidato(candidato);
	}

	@JsonIgnore
	public Usuario getUsuario() {
		return id.getUsuario();
	}

	public void setUsuario(Usuario usuario) {
		id.setUsuario(usuario);
	}

	public String getProtocolo() {
		return protocolo;
	}

	public void setProtocolo(String protocolo) {
		this.protocolo = protocolo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Votos other = (Votos) obj;
		return Objects.equals(id, other.id);
	}



}
