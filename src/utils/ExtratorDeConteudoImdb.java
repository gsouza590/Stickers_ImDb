package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Parser.JsonParser;
import imdb_stickers.entities.Conteudo;

public class ExtratorDeConteudoImdb implements ExtratorDeConteudo{
	
@Override
public List<Conteudo> extraiConteudo(String json){
		
		// extrair dados
	JsonParser parser = new JsonParser();
	List<Map<String, String>> listaDeAtributos = parser.parse(json);
	List<Conteudo> conteudos= new ArrayList<>();
	
	//  popular lista
	
	for (Map<String, String> atributos: listaDeAtributos) {
		String titulo = atributos.get("title");
		String urlImagem = atributos.get("image").replaceAll("(@+)(.*).jpg$", "$1.jpg");
		var conteudo = new Conteudo(titulo, urlImagem);
		conteudos.add(conteudo);
	}
	return conteudos;
	}

}
