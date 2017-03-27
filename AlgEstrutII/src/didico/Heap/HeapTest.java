package didico.Heap;

import java.util.Scanner;

public class HeapTest {

  public static void main( String[] args ) {
    Heap H = new Heap();

    Scanner input = new Scanner( System.in );
    System.out.println("");

    while ( input.hasNext() ) {
      String temp = input.next();
      
      if ( temp.equals( "badheap" ) ) H.fazBadHeap();
      if ( temp.equals( "heap" ) ) H.fazHeap();
      if ( temp.equals( "heapsort" ) ) H.heapsort();
      if ( temp.equals( "size" ) ) H.printSize();
      if ( temp.equals( "quit" ) ) System.exit(0);
      if ( temp.equals( "get" ) )  System.out.println( H.get() );
      if ( temp.matches( "[0-9]+" ) ) H.put( Integer.parseInt( temp ) );

      H.print();
    }
  }
}