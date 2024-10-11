package br.com.serratec.entity;

import jakarta.persistence.Entity;

@Entity
public class Cirurgiao extends Medico {
	// Atributos
	private String especialidadeCirurgica;

	// Getters Setters
	public String getEspecialidadeCirurgica() {
		return especialidadeCirurgica;
	}

	public void setEspecialidadeCirurgica(String especialidadeCirurgica) {
		this.especialidadeCirurgica = especialidadeCirurgica;
	}
}
