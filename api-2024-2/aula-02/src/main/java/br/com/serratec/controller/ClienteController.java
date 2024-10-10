package br.com.serratec.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.entity.Cliente;
//se não importar automatico ctrl+shift+o

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	private static List<Cliente> clientes = new ArrayList<>();

	static {// criou a classe a primeira coisa que ele vai executar é o static e depois o
			// construtor
		clientes.add(new Cliente(1, "Maria", "m@mail.com", "Petrópolis")); // ctrl + alt + seta para copiar linha
		clientes.add(new Cliente(2, "Igor", "i@mail.com", "São Francisco de Itabapoana"));
		clientes.add(new Cliente(3, "Ana", "a@mail.com", "Juiz de Fora"));
	}

	@GetMapping
	public List<Cliente> listar() {
		return clientes;
	}

	@GetMapping("{id}")
	public Cliente buscar(@PathVariable Integer id) {
		/*
		 * for (int i = 0; i < clientes.size(); i++) {
		 * if(clientes.get(i).getId().equals(id)) { //exemplo de breakpoint para debug
		 * return clientes.get(i); } } return null;
		 */
		// exemplo usando filter
		return clientes.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente inserir(@RequestBody Cliente cliente) {
		clientes.add(cliente);
		return cliente;
	}

	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getId().equals(id)) {
				clientes.remove(i);
			}

		}
	}

	@PutMapping("{id}")
	public Cliente alterar(@PathVariable Integer id, @RequestBody Cliente c) {
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getId().equals(id)) {
				clientes.set(i, c);
				return c;
			}
		}
		return null;
	}
}
