package br.com.serratec.controller;

import java.util.List;
import java.util.Optional;

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

import br.com.serratec.entity.Manutencao;
import br.com.serratec.repository.ManutencaoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/manutencoes")
public class ManutencaoController {
	@Autowired
	private ManutencaoRepository repository; // injeção de dependencia

	@PostMapping // ele é um post
	@ResponseStatus(HttpStatus.CREATED)
	public Manutencao inserir(@Valid @RequestBody Manutencao m) {//@precisa do valid antes do @requestbody pra ele saber o que vai validar
		return repository.save(m);
	}
	
	@PostMapping("/varios")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Manutencao> inserirVarios(@RequestBody List<Manutencao> manutencoes) {
	    return repository.saveAll(manutencoes);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Manutencao> alterarManutencao(@PathVariable Long id, @Valid @RequestBody Manutencao m) {
		if (repository.existsById(id)) {
			m.setId(id); //aqui ele vai fazer o put se não ele iria criar outro novo
			return ResponseEntity.ok(repository.save(m));
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping
	public List<Manutencao> listar(){
		return repository.findAll(); // esse faz o select*from produto		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Manutencao> exibirItem(@PathVariable Long id) {
		Optional<Manutencao> manutencaoOptional = repository.findById(id);
		if (manutencaoOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(manutencaoOptional.get());
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
