import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;
public class GeraFigurinha {
  
  public void cria(InputStream inputStream, String nomeArquivo) throws Exception{

    //leitura da imagem

    //InputStream inputStream = new FileInputStream(new File("C:/Users/godin/Desktop/imdb_stickers/entrada/filme-maior.jpg"));
    // InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg").openStream();

    BufferedImage imagemOriginal= ImageIO.read(inputStream);

    // criar nova imagem em memoria com tamanho e transparencia
    
    int width = imagemOriginal.getWidth();
    int height= imagemOriginal.getHeight();

    int novaAltura = height +200;
    BufferedImage novaImagem = new BufferedImage(width,novaAltura, BufferedImage.TRANSLUCENT);
    
    
    // copiar a imagem original para nova imagem

    Graphics2D graphics= (Graphics2D)novaImagem.getGraphics();
    graphics.drawImage(imagemOriginal, 0, 0, null);

    //configurar fonte
    var fonte = new Font(Font.SANS_SERIF,Font.BOLD, 64);
    graphics.setColor(Color.ORANGE);
    graphics.setFont(fonte);
    //escrever uma frase na nova imagem
    graphics.drawString("TOPZERA", 150, novaAltura-100);

    //escrever a nova imagem em um arquivo
    ImageIO.write(novaImagem, "png", new File(nomeArquivo));
  }
}
