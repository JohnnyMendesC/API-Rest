package br.com.serratec.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.com.serratec.exception.EnumException;

public enum Combustivel {
	//Enums
	FLEX(1,"FLEX"), 
	GASOLINA(2,"GASOLINA"), 
	ALCOOL(3,"ALCOOL"), 
	DIESEL(4,"DIESEL"), 
	ELETRICO(5,"ELÉTRICO");
	//Atributos
	private Integer codigo;
	private String tipo;
	//Construtor para organização
	private Combustivel(Integer codigo, String tipo) {
		this.codigo = codigo;
		this.tipo = tipo;
	}
	//Getters Setters
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	@JsonCreator
	public static Combustivel verificar(Integer valor) {
		for (Combustivel c: Combustivel.values()) {
			if (c.getCodigo().equals(valor))
				return c;
		}
		throw new EnumException("Combustível inválido");
	}
}
