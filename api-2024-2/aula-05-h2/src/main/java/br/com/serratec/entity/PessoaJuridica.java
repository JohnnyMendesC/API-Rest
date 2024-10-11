package br.com.serratec.entity;

import jakarta.persistence.Entity;

@Entity
public class PessoaJuridica extends Fornecedor {
	// Atributos
	private String cnpj;
	private String inscricaoEstadual;
	private String razaoSocial;

	// Getters Setters
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}
	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	
}
