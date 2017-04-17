package main;

public class HashTable {

	private Elemento[] elementos;
	// conta o número de 0 0s, ou seja, o número de estaOcupado = false e
	// jaFoiOcupado = false.
	private int contaVazios;
	// conta o número de 1 1s, ou seja, o número de estaOcupado = true e
	// jaFoiOcupado = true.
	private int contaCheios;

	private class Elemento {
		// Cada elemento possui um dado, e a informação se ele está ocupado e se
		// já foi ocupado.
		String dado;
		boolean estaOcupado;
		boolean jaFoiOcupado;

		public Elemento() {
			dado = "";
			estaOcupado = false;
			jaFoiOcupado = false;
		}
	}

	public HashTable(int tamanho) {
		elementos = new Elemento[tamanho];
		// Iniciamos preenchendo todos os espaços com Elementos
		for (int i = 0; i < elementos.length; i++) {
			elementos[i] = new Elemento();
		}
		// todos estão vazios (00), qt de vazios = tamanho
		contaVazios = tamanho;
		// nenhum cheio (11)
		contaCheios = 0;
	}

	// método para colocar um dado em um determinado elemento
	public void put(String s) {
		// se o tiverem poucos vazios, geramos uma hash nova maior
		if (contaVazios < elementos.length / 5)
			resize();

		// define o endereço
		int end = endereco(s);
		// se estiver ocupado, aumenta 1 no end e aplica a funcao novamente
		while (elementos[end].estaOcupado) {
			end = (++end) % elementos.length;
		}

		// incrementa o contaCheios e decrementa contaVazios se for a primeira
		// vez ocupado
		contaCheios++;
		if (!elementos[end].jaFoiOcupado) {
			contaVazios--;
		}

		// poe o dado lá e altera os booleanos para (11)
		elementos[end].dado = s;
		elementos[end].estaOcupado = true;
		elementos[end].jaFoiOcupado = true;

	}

	// função para sortear posição do elemento
	public int endereco(String s) {
		return s.length() % (elementos.length);
	}

	// método que dobra o tamanho do vetor de elementos
	// e passa os dados para o novo vetor
	public void resize() {
		Elemento[] aux = elementos;
		elementos = new Elemento[2 * elementos.length];

		// novamente, preenche o novo vetor com elementos e seta
		for (int i = 0; i < elementos.length; i++) {
			elementos[i] = new Elemento();
		}
		contaVazios = elementos.length;
		contaCheios = 0;

		// passa os elementos para o novo vetor usando o put (nova função
		// válida)
		for (int i = 0; i < aux.length; i++) {
			if (aux[i].estaOcupado) {
				put(aux[i].dado);
			}
		}
	}

	public boolean remove(String s) {
		// buscamos o endereço aplicando a função
		int end = endereco(s);
		// pescorremos o vetor procurando o elemento
		for (int i = 0; i < elementos.length; i++) {
			// se acharmos, ele modifica e retorna true
			if (elementos[end].dado.equals(s)) {
				elementos[end].dado = "";
				elementos[end].estaOcupado = false;
				contaCheios--;
				return true;
			}
			// se nao acharmos, continuamos a busca aplicando
			// funcao novamente para achar a posição seguinte
			end = (++end) % elementos.length;
		}
		// se não achar no vetor, retorna false
		return false;
	}

	public boolean existe(String s) {
		int end = endereco(s);
		for (int i = 0; i < elementos.length; i++) {
			// se acharmos, ele retorna true
			if (elementos[end].dado.equals(s)) {
				return true;
			}
			// se nao acharmos, continuamos a busca aplicando
			// funcao novamente para achar a posição seguinte
			end = (++end) % elementos.length;
		}
		// se não achar no vetor, retorna false
		return false;
	}

	public void print() {
		System.out.println("\n" + contaVazios + " elementos vazios");
		System.out.println(contaCheios + " elementos cheios\n");
		System.out.println("indice\tusado\temUso\tDado");
		for (int i = 0; i < elementos.length; i++) {
			System.out.println(
					i + "\t" + elementos[i].jaFoiOcupado + "\t" + elementos[i].estaOcupado + "\t" + elementos[i].dado);
		}
		System.out.println();
	}

}
