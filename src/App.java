
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import imdb_stickers.entities.Conteudo;
import imdb_stickers.services.ClientHttp;
import utils.ExtratorDeConteudo;
import utils.ExtratorDeConteudoImdb;
import utils.ExtratorDeConteudoNasa;

public class App {

	public static void main(String[] args) throws Exception {

		// fazer uma conexao http e top 250 filmes

		 String url = "https://imdb-api.com/en/API/Top250Movies/k_mw5cq3j3";
		// String top250series = "https://imdb-api.com/en/API/Top250TVs/k_mw5cq3j3";
		// String popularSeries =
		// "https://imdb-api.com/en/API/MostPopularTVs/k_mw5cq3j3";

//		String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14";
		ExtratorDeConteudo extrator = new ExtratorDeConteudoImdb();

		var http = new ClientHttp();
		String json = http.buscaDados(url);

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
//			System.out.println("\u001b[4m\u001b[34m" + conteudo.get("image") + "\u001b[0m");
//			System.out.println("\u001b[37m \u001b[43m Classificacao IMDB:" + conteudo.get("imDbRating") + "\u001b[0m");
//			System.out.println();
		}

	}

}
