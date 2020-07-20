package com.springbatch.pagingreader.dominio.app2;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transacao")
public class TransacaoApp2 {
	
    @Id
	public String id;
	public String email;
	public String nome;
	public Double valor;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	@Override
	public String toString() {
		return "Transacao [id=" + id + ", email=" + email + ", nome=" + nome + ", valor=" + valor + "]";
	}

}
