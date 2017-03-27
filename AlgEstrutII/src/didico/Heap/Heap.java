package didico.Heap;

public class Heap {
	private static int TAM = 50;
	
    private int v[];
    private int size;

    public Heap() {
        size = 0;
        v = new int[TAM];
    }

    private int left ( int i )   { return 2 * i + 1; }

    private int right ( int i )  { return 2 * i + 2; }

    private int parent ( int i ) { return (i-1) / 2; }

    
    private void sift_up ( int pos ) {
        if(pos==0) return;

        int pai = parent(pos);

        if(v[pai] < v[pos]) {
            int aux = v[pai];
            v[pai] = v[pos];
            v[pos] = aux;
            sift_up(pai);
        }
    }

    
    public void put( int data ) {
    	if (size >= TAM) {
    		System.out.println("Vetor atingiu seu máximo de " + TAM + " valores!");
    		return;
    	}
        v[size] = data;
        //sift_up( size );
        size++;
    }

    
    public void fazHeap(){
        int pos = (size-1)/2;
        while (pos >=0) {
        	sift_down(pos--);
        }
    }
    
    
    public void heapsort(){
    	fazHeap();
    	int tam = size-1;
    	while (tam>0){
    		int aux = v[tam];
    		v[tam] = v[0];
    		v[0] = aux;
    		tam--;
    		sift_down_2 ( 0, tam+1 );
    	}
    }
    
    private void sift_down_2 ( int pos, int tam ) {
        int ptroca = pos;
        int pLeft = left(pos);
        int pRight = right(pos);

        if( pLeft < tam && v[pLeft] > v[pos] ) ptroca = pLeft;
        if( pRight < tam && v[pRight] > v[ptroca] ) ptroca = pRight;
        if( ptroca == pos ) return;

        int aux = v[ptroca];
        v[ptroca] = v[pos];
        v[pos] = aux;
        sift_down_2(ptroca, tam);
    }
    
    
    
    
    private void sift_down ( int pos ) {
        int ptroca = pos;
        int pLeft = left(pos);
        int pRight = right(pos);

        if( pLeft < size && v[pLeft] > v[pos] ) ptroca = pLeft;
        if( pRight < size && v[pRight] > v[ptroca] ) ptroca = pRight;
        if( ptroca == pos ) return;

        int aux = v[ptroca];
        v[ptroca] = v[pos];
        v[pos] = aux;
        sift_down(ptroca);
    }

    
    public int get( ) {
    	if (size <= 0) {
    		System.out.println("Vetor não possui valores!");
    		return -1;
    	}
        int res = v[0];
        v[0] = v[--size];
        sift_down( 0 );
        return res;
    }

    
    private void print( int b, int elem, int sp )  {
        int i, j;

        System.out.println( "" );
        for( j = 0; j < size; j++ ) System.out.print( v[j] + " " );
        System.out.println( "" );

        while ( true ) {
            for( j = 0; j <= sp / 2; j++ ) System.out.print( " " );
            for( i = b; i < b + elem; i++ ) {
                if ( i == size ) return;
                System.out.print( v[i] );
                for( j = 0; j < sp; j++ ) System.out.print( " " );
            }
            System.out.println( "" );
            b = b + elem;
            elem = 2 * elem;
            sp = sp / 2;
        }
    }
    
    
    public void fazBadHeap(){
        fazBadHeap(0);
    }
    
    private void fazBadHeap(int pos){
    	if(pos>=size) return;
    	
        int ptroca = pos;
        int pLeft = left(pos);
        int pRight = right(pos);
              
        fazBadHeap(pLeft);
        fazBadHeap(pRight);
        
        if( pLeft < size && v[pLeft] > v[pos] ) ptroca = pLeft;
        if( pRight < size && v[pRight] > v[ptroca] ) ptroca = pRight;
        if( ptroca == pos ) return;

        int aux = v[ptroca];
        v[ptroca] = v[pos];
        v[pos] = aux;
        
        fazBadHeap(ptroca);
    }
    
        
    public void print( )  {
        System.out.println( "\n" );
        print( 0, 1, 32 );
        System.out.println( "\n" );
    }
    
    public void printSize( )  {
        System.out.println( "\nSize " + size + "\n" );
    }

}
