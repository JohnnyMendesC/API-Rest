package br.com.serratec.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.entity.Item;
import br.com.serratec.repository.ItemRepository;

@RestController // ele é um controlador Rest
@RequestMapping("/itens") // ele faz requisição de mapeamento
public class ItemController { // aqui a gente cria os CRUDs
	@Autowired
	private ItemRepository itemRepository;

	// pra criar ele precisa requisitar um body
	@PostMapping // criação de um item
	public Item criarItem(@RequestBody Item item) {
		return itemRepository.save(item);
	}

	@PostMapping("/varios") // criar varios
	public List<Item> criarVariosItens(@RequestBody List<Item> itens) {
		return itemRepository.saveAll(itens);
		// aqui usa o tipo List<Item> pois serão varios inserts da entidade itens
	}

	@GetMapping
	public List<Item> exibirTodosItens() {
		return itemRepository.findAll();
	}

	@GetMapping("{id}")
	public ResponseEntity<Item> exibirItem(@PathVariable Long id) {
		Optional<Item> itemOptional = itemRepository.findById(id);
		if (itemOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(itemOptional.get());
	}

	@PutMapping("{id}")
	public ResponseEntity<Item> alterarItem(@PathVariable Long id, @RequestBody Item itemModificado) {
		if (itemRepository.existsById(id)) {
			itemModificado.setId(id); //aqui ele vai fazer o put se não ele iria criar outro novo
			return ResponseEntity.ok(itemRepository.save(itemModificado));
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Void> apagarItem(@PathVariable Long id) {
		if (itemRepository.existsById(id)) {
			itemRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
}
/*
 * @PostMapping de um
 * 
 * @PostMapping de /varios
 * 
 * @GetMapping de um
 * 
 * @GetMapping de /varios
 * 
 * @PutMapping de um
 * 
 * @DeleteMapping de um
 * 
 */
