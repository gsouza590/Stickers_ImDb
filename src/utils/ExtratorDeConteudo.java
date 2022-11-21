package utils;

import java.util.List;

import imdb_stickers.entities.Conteudo;

public interface ExtratorDeConteudo {

	List<Conteudo> extraiConteudo(String json);
}
