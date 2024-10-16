package br.com.serratec.entity;

public class Pagamento {
//	private Consulta consulta = new Consulta(); // não é uma maneira boa de fazer pois a criação 
//	private Exame exame = new Exame();			// dos objetos fica escondida dentro de pagamento
	
	private Consulta consulta; // deixa só o atributo e faz um construtor
	private Exame exame;

	public Pagamento(Consulta consulta, Exame exame) {
		this.consulta = consulta;
		this.exame = exame;
	}

	public Double calcularProcedimento(Double valorExame, Double valorConsulta) {
		return exame.calcularExame(valorExame) + consulta.calcularConsulta(valorConsulta);
	}
}
