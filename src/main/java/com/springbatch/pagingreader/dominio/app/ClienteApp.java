package com.springbatch.pagingreader.dominio.app;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="cliente")
public class ClienteApp {
	
    @Id
	private String email;
	private String nome;
	private String sobrenome;
	private String idade;
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Cliente [email=" + email + ", nome=" + nome + ", sobrenome=" + sobrenome + ", idade=" + idade + "]";
	}


}