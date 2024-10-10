package br.com.serratec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{

}
