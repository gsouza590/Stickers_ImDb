package utils;

import java.util.List;

import entities.Conteudo;

public interface ExtratorDeConteudo {

	List<Conteudo> extraiConteudo(String json);
}
