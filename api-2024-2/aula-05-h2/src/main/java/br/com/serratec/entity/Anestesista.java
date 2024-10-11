package br.com.serratec.entity;

import jakarta.persistence.Entity;

@Entity
public class Anestesista extends Medico {
	// Atributos
	private String tipoAnestesia;

	// Getters Setters
	public String getTipo() {
		return tipoAnestesia;
	}

	public void setTipo(String tipo) {
		this.tipoAnestesia = tipo;
	}
}
