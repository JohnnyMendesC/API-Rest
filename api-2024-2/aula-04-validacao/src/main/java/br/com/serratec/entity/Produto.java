package br.com.serratec.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Produto {
	@Id //<- definida como primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // <- serial
	private Long id;
	
	@Column(length = 50, nullable = false) //descrição varchar de 50 e not null não nulo
	@NotBlank(message = "Descrição inválida") //filtra valores vazios
	@Size(max=50, message="Valor máximo de caracteres excedido")
	private String descricao;
	
	@DecimalMin(value = "10", message="Valor inválido")
	@DecimalMax(value = "5000", message="Valor inválido")
	private Double valor;
	
	private LocalDate dataCadastro;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

}
