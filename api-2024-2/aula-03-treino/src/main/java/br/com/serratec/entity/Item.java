package br.com.serratec.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // primeiro diz que essa classe é @ENTITY com essa anotação
public class Item {// a entidade, entity, é onde fica o Item e seus atributos, construtores, getters e setters
	@Id // cria a primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // as duas anotações acima estão atribuidas a este valor
	
	@Column(length = 50, nullable = false) // varchar de 50 e não nulo
	private String nomeDoItem;
	
	@Column(length = 3, nullable = false)
	private String tagDoItem;
	
	private float valorDoItem;
	private LocalDate dataDeCriacaoDoItem = LocalDate.now();

	//Getters Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeDoItem() {
		return nomeDoItem;
	}
	public void setNomeDoItem(String nomeDoItem) {
		this.nomeDoItem = nomeDoItem;
	}
	public String getTagDoItem() {
		return tagDoItem;
	}
	public void setTagDoItem(String tagDoItem) {
		this.tagDoItem = tagDoItem;
	}
	public float getValorDoItem() {
		return valorDoItem;
	}
	public void setValorDoItem(float valorDoItem) {
		this.valorDoItem = valorDoItem;
	}
	public LocalDate getDataDeCriacaoDoItem() {
		return dataDeCriacaoDoItem;
	}
	public void setDataDeCriacaoDoItem(LocalDate dataDeCriacaoDoItem) {
		this.dataDeCriacaoDoItem = dataDeCriacaoDoItem;
	}
	
	
}
