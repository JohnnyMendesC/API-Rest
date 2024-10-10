package br.com.serratec.entity;

import org.springframework.stereotype.Component;

@Component //torna a classe pagamento gerenciada pelo spring para não precisar fazer os new manuamente
public class Exame {

	public Double calcularExame(Double valor) {
		return valor = valor * 1.05;
	}
}
