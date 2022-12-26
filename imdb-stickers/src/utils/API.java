package utils;

public enum API {
    IMDB_TOPMOVIES ("https://imdb-api.com/en/API/Top250Movies/k_mw5cq3j3",new ExtratorDeConteudoImdb()),
    NASA ("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14", new ExtratorDeConteudoNasa()),
	IMDB_TOPSERIES ("https://imdb-api.com/en/API/Top250TVs/k_mw5cq3j3",new ExtratorDeConteudoImdb());
	// String url = "http://localhost:8080/linguagens";
	
    private String url;
    private ExtratorDeConteudo extrator;
    
	private API(String url, ExtratorDeConteudo extratorDeConteudo) {
    	this.url = url;
		this.extrator= extratorDeConteudo;
	}
	
	   public String url() {
	        return url;
	    }

	    public ExtratorDeConteudo extrator() {
	        return extrator;
	    }
}
