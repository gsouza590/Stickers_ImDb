package br.com.alura.sticker.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.sticker.api.entities.Linguagem;
import br.com.alura.sticker.api.repository.LinguagemRepository;

@RestController
public class LinguagemController {
	

	@Autowired
	private LinguagemRepository repository;
	
	@GetMapping(value="/linguagens")
	public List<Linguagem> obterLinguagens() {
		return repository.findAll();
	}
	
	@PostMapping(value="/linguagens")
	public Linguagem cadastrar(@RequestBody Linguagem linguagem) {
		return repository.save(linguagem);
	}
	
	
	@DeleteMapping("/linguagens/{id}")
	public void deletar(@PathVariable String id ) {
		repository.deleteById(id);
	}
}
