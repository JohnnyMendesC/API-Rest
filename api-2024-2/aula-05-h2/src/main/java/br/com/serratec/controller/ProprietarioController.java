package br.com.serratec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.entity.Proprietario;
import br.com.serratec.repository.ProprietarioRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/proprietarios")
public class ProprietarioController {
	@Autowired
	private ProprietarioRepository repository; // injeção de dependencia

	@PostMapping // ele é um post
	@ResponseStatus(HttpStatus.CREATED)
	public Proprietario inserir(@Valid @RequestBody Proprietario p) {//@precisa do valid antes do @requestbody pra ele saber o que vai validar
		return repository.save(p);
	}
	
	@PostMapping("/varios")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Proprietario> inserirVarios(@RequestBody List<Proprietario> proprietarios) {
	    return repository.saveAll(proprietarios);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Proprietario> alterarProprietario(@PathVariable Long id, @Valid @RequestBody Proprietario p) {
		if (repository.existsById(id)) {
			p.setId(id); //aqui ele vai fazer o put se não ele iria criar outro novo
			return ResponseEntity.ok(repository.save(p));
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping
	public List<Proprietario> listar(){
		return repository.findAll(); // esse faz o select*from produto		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> apagar(@PathVariable Long id){
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
}
