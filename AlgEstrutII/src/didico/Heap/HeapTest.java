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
      if ( temp.equals( "maxheap" ) ) H.maxHeap();
      if ( temp.equals( "minheap" ) ) H.minHeap();
      if ( temp.equals( "heapsortasc" ) ) H.heapsortAsc();
      if ( temp.equals( "heapsortdesc" ) ) H.heapsortDesc();
      if ( temp.equals( "size" ) ) H.printSize();
      if ( temp.equals( "quit" ) ) System.exit(0);
      if ( temp.equals( "getmax" ) )  System.out.println( H.getMax() );
      if ( temp.equals( "getmin" ) )  System.out.println( H.getMin() );
      if ( temp.matches( "[0-9]+" ) ) H.put( Integer.parseInt( temp ) );

      H.print();
    }
  }
}