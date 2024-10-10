package br.com.serratec.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component //torna a classe pagamento gerenciada pelo spring para não precisar fazer os new manuamente
public class Pagamento {	
	//com o autowired é preferivel e parece o lombok
	@Autowired //o autowired em cada atributo é preferivel no lugar do construtor
	private Consulta consulta;
	@Autowired
	private Exame exame;

	//não tão ideal, com o @Component atraves do construtor cheio ele ja sabe que tem fazer o new automaticamente, injeção de dependencia
//	public Pagamento(Consulta consulta, Exame exame) {
//		this.consulta = consulta;
//		this.exame = exame;
//	}
	
	//com o new que não é ideal
//	private Consulta consulta = new Consulta(); // não é uma maneira boa de fazer pois a criação 
//	private Exame exame = new Exame();			// dos objetos fica escondida dentro de pagamento

	public Double calcularProcedimento(Double valorExame, Double valorConsulta) {
		return exame.calcularExame(valorExame) + consulta.calcularConsulta(valorConsulta);
	}
}
