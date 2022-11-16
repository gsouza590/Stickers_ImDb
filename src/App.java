import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
  
    public static void main(String[] args) throws Exception {
        

        // fazer uma conexao http e top 250 filmes
        String url ="https://imdb-api.com/en/API/Top250Movies/k_mw5cq3j3";
        URI endereco = URI.create(url);
        var client= HttpClient.newHttpClient();
        HttpRequest request =  HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request,BodyHandlers.ofString());
        String body= response.body();
      

        // extrair alguns dados (titulo, poster, classificacao)- parsear dados
        JsonParser parser = new JsonParser();
        List<Map<String, String>> listafilmes= parser.parse(body);
        
        // Exibir e manipular os dados

        for (Map<String,String> filme : listafilmes) {
            System.out.println("\u001b[1m\u001b[35m"+ filme.get("title")+"\u001b[0m" );
            System.out.println("\u001b[4m\u001b[34m"+ filme.get("image")+"\u001b[0m");
            System.out.println("\u001b[37m \u001b[43m Classificacao IMDB:"+filme.get("imDbRating")+"\u001b[0m");
            System.out.println();
             System.out.println("\u2B50");
        }
    }
}
