package br.com.serratec;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.serratec.entity.Consulta;
import br.com.serratec.entity.Exame;
import br.com.serratec.entity.Pagamento;

@SpringBootApplication
public class Aula04ValidacaoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Aula04ValidacaoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//inversão de controle, tira a instancia do pagamento e joga pro main
		Consulta consulta = new Consulta();
		Exame exame = new Exame();
		Pagamento pagamento = new Pagamento(consulta, exame);
		System.out.println("Total à pagar:"+ pagamento.calcularProcedimento(100.,100.));	
	}
}
