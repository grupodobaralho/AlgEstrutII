import java.util.HashMap;
import java.util.Scanner;

import graph.BreadthFirstPaths;
import graph.Graph;
import graph.In;

public class AppDegreesOfSeparation {

	public static void main(String[] args) {
		In in = new In("movies.txt");
		String[] filmes = in.readAllLines();
		System.out.println("Total: " + filmes.length);

		int total = 0;
		Graph grafo = new Graph(120000); // tem aprox. 119 mil...

		// Dicion�rio para a leitura e consultas: mapeia um nome para um id
		HashMap<String, Integer> dic = new HashMap<>();
		
		// Dicion�rio invertido, para listar o caminho
		HashMap<Integer, String> dicRev = new HashMap<>();
		
		// Para cada filme...
		for (String linha : filmes) {
			String[] campos = linha.split("/");
			// O nome � o primeiro campo
			String nome = campos[0];
			int chaveNome = 0;
			// Se n�o existir no dicion�rio, cria
			if (!dic.containsKey(nome)) {
				dic.put(nome, ++total);
				dicRev.put(total, nome);
				chaveNome = total;
			} else
				chaveNome = dic.get(nome);
			// Para cada pessoa...
			for (int pos = 1; pos < campos.length; pos++) {
				String pessoa = campos[pos];
				int chavePessoa = 0;
				// Se n�o existir no dicion�rio, cria
				if (!dic.containsKey(pessoa)) {
					dic.put(pessoa, ++total);
					dicRev.put(total, pessoa);
					chavePessoa = total;
				} else
					chavePessoa = dic.get(pessoa);
				// Adiciona a aresta ao grafo
				grafo.addEdge(chaveNome, chavePessoa);
			}
		}
		System.out.println("Total v�rtices: " + dic.size());

		Scanner entrada = new Scanner(System.in);

		System.out.print("De: ");
		String de = entrada.nextLine();

		System.out.print("Para: ");
		String para = entrada.nextLine();

		if (dic.containsKey(de)) {
			if (dic.containsKey(para)) {
				int chaveDe = dic.get(de);
				int chavePara = dic.get(para);
				BreadthFirstPaths bfs = new BreadthFirstPaths(grafo, chaveDe);
				// Se houver caminho de um v�rtice para outro...
				if (bfs.hasPathTo(chavePara)) {
					// Lista o caminho, usando o dicion�rio invertido
					// para mapear do id -> nome
					for (int vertice : bfs.pathTo(chavePara))
						System.out.println("  -> " + dicRev.get(vertice));
				}
				else
				  // N�o verifiquei se h� um caso assim, mas just in case...
				  System.out.println("N�o h� liga��o entre os v�rtices!");
			} else
				System.out.println("Nome " + para + " inexistente!");
		} else
			System.out.println("Nome " + de + " inexistente!");
	}
}