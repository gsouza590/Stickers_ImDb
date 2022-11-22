package br.com.alura.sticker.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.alura.sticker.api.entities.Linguagem;

public interface LinguagemRepository extends MongoRepository<Linguagem, String> {

}
