package isra;

public class Heap {

	private int[] v;
	private int size;

	// Um vetor de 10 inteiros com size 0;
	public Heap() {
		size = 0;
		v = new int[10];
	}

	// Regra do da esquerda: 2*posicao +1;
	private int left(int i) {
		return 2 * i + 1;
	}

	// Regra do da direita: 2*posicao +2;
	private int right(int i) {
		return 2 * i + 2;
	}

	// Regra do pai: (posicao-1)/2;
	private int parent(int i) {
		return (i - 1) / 2;
	}

	// ****************************************************************************************************
	// ****************************************************************************************************
	// ****************************************************************************************************
	// ****************************************************************************************************
	// ****************************************************************************************************
	// método para adicionar, ele chama o Sift_Up
	public void put(int data) {
		v[size] = data;
		// sift_up removido para testar o fazHeap!
		// sift_up(size);
		size++;
	}

	private void sift_up(int pos) {
		// a recursão para se a posicão for 0, (raiz)
		if (pos == 0)
			return;

		// int pai = (pos-1)/2;
		int pai = parent(pos);

		// compara com o pai, se for maior, troca de posição e repete o siftUp
		// para o próximo pai
		if (v[pai] < v[pos]) {
			int aux = v[pai];
			v[pai] = v[pos];
			v[pos] = aux;
			sift_up(pai);
		}
	}

	// ****************************************************************************************************
	// ****************************************************************************************************
	// ****************************************************************************************************
	// ****************************************************************************************************
	// ****************************************************************************************************
	// para remover, sempre remove o primeiro. Troca o primeiro pela maior
	// folha da direita e chama o sift_down para arrumar
	public int get() {
		// não pode remover se não houver valores
		if (size <= 0) {
			return -1;
		}
		int res = v[0];
		v[0] = v[--size];
		sift_down(0);
		return res;
	}

	// compara os dois filhos e escolhe o maior para trocar com a raiz
	// continua até os filhos não serem maiores ou se não houverem mais filhos
	private void sift_down(int pos) {
		int ptroca = pos;
		int pLeft = left(pos);
		int pRight = right(pos);

		if (pLeft < size && v[pLeft] > v[pos])
			ptroca = pLeft;
		if (pRight < size && v[pRight] > v[ptroca])
			ptroca = pRight;
		if (ptroca == pos)
			return;

		int aux = v[ptroca];
		v[ptroca] = v[pos];
		v[pos] = aux;
		sift_down(ptroca);
	}

	// ****************************************************************************************************
	// ****************************************************************************************************
	// ****************************************************************************************************
	// ****************************************************************************************************
	// ****************************************************************************************************
	// O método fazHeapRuim utiliza o sift_down.
	// É um método porco do Heap-Sort para ordenar o Heap.
	public void fazHeapRuim() {
		fazHeapRuim(0);
	}

	public void fazHeapRuim(int pos) {
		if (pos >= size)
			return;

		int pTroca = pos;
		int pLeft = left(pos);
		int pRight = right(pos);

		fazHeapRuim(pLeft);
		fazHeapRuim(pRight);

		if (pLeft < size && v[pLeft] > v[pos])
			pTroca = pLeft;
		if (pRight < size && v[pRight] > v[pTroca])
			pTroca = pRight;
		if (pTroca == pos)
			return;

		int aux = v[pTroca];
		v[pTroca] = v[pos];
		v[pos] = aux;

		fazHeapRuim(pTroca);
	}

	// ****************************************************************************************************
	// ****************************************************************************************************
	// ****************************************************************************************************
	// ****************************************************************************************************
	// ****************************************************************************************************
	// O heapsort divide-se em 2 fazes
	public void heapsort() {
		fazHeap();
		int tam = size - 1;
		while (tam > 0) {
			int aux = v[tam];
			v[tam] = v[0];
			v[0] = aux;
			tam--;
			sift_down_2(0, tam + 1);
		}
	}

	// A parte 1, faz sift_down da metade do vetor, O(n)
	public void fazHeap() {
		int pos = (size - 1) / 2;
		while (pos >= 0) {
			sift_down(pos--);
		}
	}

	// A parte 2, poe o v[0] (maior elemento) no último e isola ele lá.
	// depois, faz sift_down do v[0]. Ao final, o segundo maior irá para o v[0],
	// poe ele no final e isola tb, repete o processo até todos ordenados. O(n
	// log n)
	private void sift_down_2(int pos, int tam) {
		int ptroca = pos;
		int pLeft = left(pos);
		int pRight = right(pos);

		if (pLeft < tam && v[pLeft] > v[pos])
			ptroca = pLeft;
		if (pRight < tam && v[pRight] > v[ptroca])
			ptroca = pRight;
		if (ptroca == pos)
			return;

		int aux = v[ptroca];
		v[ptroca] = v[pos];
		v[pos] = aux;
		sift_down_2(ptroca, tam);
	}

	// ****************************************************************************************************
	// ****************************************************************************************************
	// ****************************************************************************************************
	// ****************************************************************************************************
	// ****************************************************************************************************
	private void print(int b, int elem, int sp) {
		int i, j;

		System.out.println("");
		for (j = 0; j < size; j++)
			System.out.print(v[j] + " ");
		System.out.println("");

		while (true) {
			for (j = 0; j <= sp / 2; j++)
				System.out.print(" ");
			for (i = b; i < b + elem; i++) {
				if (i == size)
					return;
				System.out.print(v[i]);
				for (j = 0; j < sp; j++)
					System.out.print(" ");
			}
			System.out.println("");
			b = b + elem;
			elem = 2 * elem;
			sp = sp / 2;
		}
	}

	public void print() {
		System.out.println("");
		print(0, 1, 64);
		System.out.println("");
	}
}
