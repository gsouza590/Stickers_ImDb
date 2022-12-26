package application;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

import entities.Conteudo;
import services.ClientHttp;
import utils.API;
import utils.ExtratorDeConteudo;

public class App {

	public static void main(String[] args) throws Exception {


		API api = API.IMDB_TOPSERIES;
		
		ExtratorDeConteudo extrator = api.extrator();

		var http = new ClientHttp();
		String json = http.buscaDados(api.url());

		// extrair alguns dados (titulo, poster, classificacao)- parsear dados

		List<Conteudo> conteudos = extrator.extraiConteudo(json);

		// Exibir e manipular os dados

		var geraFigurinha = new GeraFigurinha();

		for (int i = 0; i < 3; i++) {
			Conteudo conteudo = conteudos.get(i);
			InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
			String nomeArquivo = "saida/" + conteudo.getTitulo() + ".png";
			geraFigurinha.cria(inputStream, nomeArquivo);
			System.out.println("\u001b[1m\u001b[35m" + conteudo.getTitulo() + "\u001b[0m");
			System.out.println("\u001b[4m\u001b[34m" + conteudo.getUrlImagem() + "\u001b[0m");
			//System.out.println("\u001b[37m \u001b[43m Classificacao IMDB:" + conteudo.get("imDbRating") + "\u001b[0m");
			System.out.println();
		}

	}

}
