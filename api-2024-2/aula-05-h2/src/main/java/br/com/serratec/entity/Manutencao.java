package br.com.serratec.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Manutencao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private LocalDate dataEntrada;
	private LocalDate dataSaida;
	private String obs;	
	
	//Getters Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public LocalDate getDataSaida() {
		return dataSaida;
	}
	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	
	//Foreign Key
	//MANUTENCAO DO VEICULO
	@ManyToOne //relação n para 1
	@JsonBackReference //complementa o @JsonManagedReference para não dar loops
	@JoinColumn(name ="id_veiculo")
	private Veiculo veiculo;
	
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	//SERVICOS DAS MANUTENCOES
	@ManyToMany //como é n para n usa a JoinTable que cria uma tabela intermediaria
	@JoinTable(name = "manutencao_servico",
	joinColumns = @JoinColumn(name = "id_manutencao"),
	inverseJoinColumns = @JoinColumn(name = "id_servico"))
	private List<Servico> servicos;

	public List<Servico> getServicos() {
		return servicos;
	}

}
