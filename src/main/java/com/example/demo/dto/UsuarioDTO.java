package com.example.demo.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import com.example.demo.domain.Usuario;
import com.example.demo.domain.enums.TipoUsuario;
import com.example.demo.services.validation.UsuarioInsert;

@UsuarioInsert
public class UsuarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 5, max = 80 ,message = "O tamanho deve ser entre 5 e 80 caracteres")
	private String nome;
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 11, max = 11 ,message = "O tamanho do cpf deve ser de 11 caracteres")
	@CPF
	@Column(unique = true)
	private String usuarioCPF;
	private String senha;
	private TipoUsuario tipo;
	
	public UsuarioDTO() {
		
	}

	public UsuarioDTO(Usuario obj) {
		id = obj.getId();
		nome = obj.getNome();
		usuarioCPF = obj.getusuarioCPF();
		senha = obj.getSenha();
		tipo = obj.getTipo();
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
	
	
	
}
