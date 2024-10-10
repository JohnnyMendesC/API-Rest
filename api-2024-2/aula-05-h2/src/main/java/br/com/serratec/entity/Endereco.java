package br.com.serratec.entity;

import br.com.serratec.enums.Estado;
import jakarta.persistence.Embeddable;

@Embeddable
public class Endereco {
	//Atributos
	private String logradouro;
	private String numero;
	private String bairro;
	private String cidade;
	private Estado estado;
	
	//Getters Setters
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
}
