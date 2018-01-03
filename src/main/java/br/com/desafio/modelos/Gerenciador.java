package br.com.desafio.modelos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("serial")
@Entity
@Table(name="gerenciador")
public class Gerenciador implements Serializable {

	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
	
	@NotEmpty
	@Column(name="servico")
	private String servico;
	
	@NotEmpty
	@Column(name="senha")
	private String senha;
	
	@Column(name="email")
	private String email;

	public Gerenciador() {}
	
	public Gerenciador(String servico, String email, String senha) {
		this.servico = servico;
		this.email = email;
		this.senha = senha;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getServico() {
		return servico;
	}

	public void setServico(String servico) {
		this.servico = servico;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
