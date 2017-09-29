package heap;

public class MinHeap {

	private Object v[];
	private int size;

	public MinHeap() {
		size = 0;
		v = new Object[11];
	}

	public MinHeap(int tamanho) {
		size = 0;
		v = new Object[tamanho + 1];
	}

	public int getParent(int i) {
		return i / 2;
	}

	public int getLeftChild(int i) {
		return i * 2;
	}

	public int getRightChild(int i) {
		return (i * 2) + 1;
	}

	// Promovendo um nodo (subindo na árvore)
	public void swim(int i) {
		while (i > 1 && i < getParent(i)) {
			Object aux = v[i];
			v[i] = v[getParent(i)];
			v[getParent(i)] = aux;
		}
	}

	// Retrocede um nodo (desce na árvore)
	public void sink(int i) {
		//nodos acima de 2*i são folhas
		while ( 2*i <= size){
			int aux = 2*i;
			int maior;
			if(getRightChild(i) > getLeftChild(i)){
	
			}
		}
	}

	// Incrementa a quantidade de elementos e insere na última posição. Após
	// isso, reorganiza o headp chamando swim.
	public void insert(Object o) {
		v[++size] = o;
		swim(size);
	}
	

}
