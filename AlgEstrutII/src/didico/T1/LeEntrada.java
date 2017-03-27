package didico.T1;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Classe para ler o arquivo de entrada para a memória
 *
 * @authors Diego Osmarin Basso
 */
public class LeEntrada {
	//Método para ler entrada arquivo utilizando BufferedReader
	public static String getCodigo (String entrada) {
		Path path = Paths.get(entrada);
		try(BufferedReader br = Files.newBufferedReader(path, Charset.defaultCharset())) {
			return br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
