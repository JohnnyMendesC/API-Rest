package br.com.serratec.entity;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)//todos medicos ficam em uma table só nesse caso
@DiscriminatorColumn(name = "tipo_especializacao")//filtra os atributos para aparecer só os dele, assim um cirurgiao nao terá atributos de anestesista
@Entity
public class Medico {
	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;
	protected String crm;
	protected String nome;
	protected String email;
	
	// Getters Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCrm() {
		return crm;
	}
	public void setCrm(String crm) {
		this.crm = crm;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
