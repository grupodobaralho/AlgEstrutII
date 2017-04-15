package main;


public class HashTable {
	private Elemento elementos[];
	private int vazio;
	private int cheio;
	
	private class Elemento {
		String dados;
		boolean usado;
		boolean emUso;
		
		public Elemento() {
			dados = "";
			usado = emUso = false;
		}
	}
	
	public HashTable(int tamanho) {
		elementos = new Elemento[tamanho];
		for(int i=0; i<elementos.length; i++){
			elementos[i] = new Elemento();
		}
		vazio = tamanho;
		cheio = 0;		
	}
	
	public void resize(){
		Elemento[] aux = elementos;
		elementos = new Elemento[2*elementos.length];
		
		for(int i=0; i<elementos.length; i++){
			elementos[i] = new Elemento();
		}
		vazio = elementos.length;
		cheio = 0;
		
		for(int i=0; i<aux.length; i++){
			if(aux[i].emUso) {
				put(aux[i].dados);
			}
		}		
	}
	
	public void put(String s){
		if(vazio < elementos.length/5){
			resize();
		}
		
		int end = endereco(s);
		while(elementos[end].emUso) {
			end = (++end)%elementos.length;
		}
		
		cheio++;
		if(!elementos[end].usado) {
			vazio--;
		}
		elementos[end].dados = s;
		elementos[end].usado = true;
		elementos[end].emUso = true;
	}
	
	public boolean existe(String s){
		int end = endereco(s);
		for(int i=0; i<elementos.length && elementos[end].usado; i++) {
			if(s.equals(elementos[end].dados)) return true;
			end = (++end)%elementos.length;
		}
		return false;
	}
	
	public int endereco(String s){
		return s.length()%(elementos.length);
	}
	
	public boolean remove(String s){
		int end = endereco(s);
		for(int i=0; i<elementos.length && elementos[end].usado; i++) {
			if(s.equals(elementos[end].dados)){
				elementos[end].dados = "";
				elementos[end].emUso = false;
				cheio--;
				return true;
			}
			end = (++end)%elementos.length;
		}
		return false;
	}
	
	public void print(){
		System.out.println("\n"+vazio + " elementos vazios");
		System.out.println(cheio + " elementos cheios\n");
		System.out.println("indice\tusado\temUso\tDado");
		for(int i=0; i<elementos.length; i++){
			System.out.println(i+"\t"+elementos[i].usado+"\t"+elementos[i].emUso+"\t"+elementos[i].dados);
		}
		System.out.println();
	}
}











