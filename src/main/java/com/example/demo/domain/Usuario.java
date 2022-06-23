package com.example.demo.domain;

import java.io.Serializable;
import java.util.Objects;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.demo.domain.enums.TipoUsuario;


@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String usuarioCPF;
	private String senha;
	private TipoUsuario tipo;

	public Usuario() {
	}

	public Usuario(Integer id, String nome, String usuarioCPF, String senha, TipoUsuario tipo) {
		super();
		this.id = id;
		this.nome = nome;
		this.usuarioCPF = usuarioCPF;
		this.senha = senha;
		this.tipo = (tipo == null) ? null : tipo;
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

	public String getusuarioCPF() {
		return usuarioCPF;
	}

	public void setusuarioCPF(String usuarioCPF) {
		this.usuarioCPF = usuarioCPF;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public TipoUsuario getTipo() {
		return tipo;
	}

	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
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
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}

}
