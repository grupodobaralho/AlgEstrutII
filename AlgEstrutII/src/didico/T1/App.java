package didico.T1;

public class App {
	
	private static int TAM_DIVISAO = 4;
	private static String FILE = "d";

	public static void main(String[] args) {
		//declarações
		GeneralTreeOfInteger tree = new GeneralTreeOfInteger();
		String texto;
		int tamanho;
		Integer father;
		
		//inicializações
		texto = LeEntrada.getCodigo("src/didico/T1/Arquivos/t2" + FILE + ".txt");
		tamanho = Integer.parseInt(texto.split(" ")[0]);
		texto = texto.split(" ")[1];
		
		father = 0;
		tree.add(father, null);
		//System.out.println("\n" + tree.getRoot() + "\n");
		for(int i=1; i<texto.length(); i++) {
			while (tree.getSubtreeSize(father) == TAM_DIVISAO) {
				father = tree.getFather(father);
			}
			tree.add(i, father);
			if (texto.charAt(i) == 'c') {
				father = i;
			}
		}
		
		System.out.println("Células pintadas de preto: " + GeraSaida.gravaDados(tree, texto, tamanho, "src/didico/T1/Arquivos/t2" + FILE + ".svg"));
		
		//System.out.println("\n\n" + tree);
		
		//System.out.println("\n\nPositionsWidth " + tree.positionsWidth());
		
		//System.out.println("\n\nPositionsPre " + tree.positionsPre());
		
		//System.out.println("\n\nPositionsPos " + tree.positionsPos());		
		
		//System.out.println("\n\nmaxLevel " + maxLevel + "\n\n");
		
		System.out.println("\n\nTamanho " + tamanho + "\ntexto.length() " + texto.length() + "\ntree.size() " + tree.size() + "\n\n");
			
	}

}
