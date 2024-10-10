package br.com.serratec.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Servico {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String descricao;
	private Double valor;
	
	//Getters Setters
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
}
/*
VEICULO
1 - CORSA

MANUTENCAO
1 - '2024-10-09' - '2024-10-xx' - 'nenhuma' - 1

SERVICO
1 - TROCA DE OLEO - 100,00
2 - FILTRO DE AR - 20,00
3 - TROCA DE VELA - 50,00
4 - REVISAO GERAL - 200,00

MANUTENCAO_SERVICO É CRIADA POIS É N PARA N
1 - 1
1 - 2

UM SERVICO PODE ESTAR EM VARIAS MANUTENCOES
UMA MANUTENCAO PODE TER VARIOS SERVICOS
 */