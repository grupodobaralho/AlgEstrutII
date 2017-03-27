package didico.T1;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Classe para gerar a saída no formato especificado
 *
 * @authors Diego Osmarin Basso
 */
public class GeraSaida {

	public static int gravaDados(GeneralTreeOfInteger tree, String text, int size, String file) {
		int total;
		//Gravando no arquivo
		Path path1 = Paths.get(file);
		// defaultCharset retorna a codificaçãoo padão de textos (usualmente UTF-8)
		try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path1, Charset.forName("utf8")))) {
			//Gravando 
			writer.println("<?xml version=\"1.0\" standalone=\"no\"?>");
			writer.println();
			writer.println("<!-- width e height dizem o tamanho que vai ter no browser -->");
			writer.println();
			writer.println("<!-- a ViewBox diz que a imagem tem coordenadas 0 <= x,y <= " + size + " -->");
			writer.println();
			writer.println("<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"20cm\" height=\"20cm\" viewBox=\"0 0 " + size + " " + size + "\">");
			writer.println();
			writer.println("<g style=\"stroke-width:.05; stroke:black\">");
			writer.println();
			
			total = gravaDadosRecursivo(tree, tree.getRoot(), text, size, 0, 0, writer);
			
			writer.println();
			writer.println("</g>");
			writer.println("</svg>");
			
			return total;
						
		} catch (IOException ioe) {
			System.out.println("\n\nNão foi possível gravar " + file);
			System.out.println("Erro: " + ioe.getMessage());
		}
		return 0;
	}

	private static int gravaDadosRecursivo(GeneralTreeOfInteger tree, Integer pos, String text, int size, int x, int y, PrintWriter writer) {
		ArrayList<Integer> subtree = tree.getSubtree(pos);
		int newX, newY, total = 0;
		for(int i=0; i<subtree.size(); i++) {
			if(i == 0) {
				newX = x + size/2;
				newY = y;
			}
			else if (i == 1) {
				newX = x;
				newY = y;
			}
			else if (i == 2) {
				newX = x;
				newY = y + size/2;
			}
			else {
				newX = x + size/2;
				newY = y + size/2;
			}
			
			char color = text.charAt(subtree.get(i));
			if ( color == 'b') {
				writer.println("<rect x=\"" + newX + "\" y=\"" + newY + "\" width=\"" + size/2 + "\" height=\"" + size/2 +"\" style=\"fill:white\"/>");
			}
			else if (color == 'p') {
				writer.println("<rect x=\"" + newX + "\" y=\"" + newY + "\" width=\"" + size/2 + "\" height=\"" + size/2 +"\" style=\"fill:black\"/>");
				total += Math.pow(size/2, 2);
			}
			else {
				total += gravaDadosRecursivo(tree, subtree.get(i), text, size/2, newX, newY, writer);
			}
		}
		return total;
	}
	
}







