package br.com.serratec.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.serratec.enums.StatusConsulta;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Consulta {
	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private LocalDate dataConsulta;
	private LocalTime horaConsulta;
	@Enumerated(EnumType.ORDINAL)
	private StatusConsulta statusConsulta;

	// Getters Setters
	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public LocalDate getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(LocalDate dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public LocalTime getHoraConsulta() {
		return horaConsulta;
	}

	public void setHoraConsulta(LocalTime horaConsulta) {
		this.horaConsulta = horaConsulta;
	}


	public StatusConsulta getStatusConsulta() {
		return statusConsulta;
	}

	public void setStatusConsulta(StatusConsulta statusConsulta) {
		this.statusConsulta = statusConsulta;
	}
	
	// FK
	@ManyToOne // relação n para 1
	@JsonBackReference // complementa o @JsonManagedReference para não dar loops
	@JoinColumn(name = "id_paciente")
	private Paciente paciente;

	@ManyToOne // relação n para 1 com medico
	@JsonBackReference
	@JoinColumn(name = "id_medico")
	private Medico medico;
	
	@ManyToMany
	@JoinTable(name = "consulta_medico",
	joinColumns = @JoinColumn(name = "id_consulta"),
	inverseJoinColumns = @JoinColumn(name = "id_medico"))
	private List<Consulta> consultas;

	public List<Consulta> getConsultas() {
		return consultas;
	}
	
	
	public Paciente getPaciente() {
		return paciente;
	}
	
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public Medico getMedico() {
		return medico;
	}
	
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
}