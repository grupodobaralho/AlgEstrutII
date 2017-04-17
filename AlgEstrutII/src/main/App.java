package main;

import java.util.Scanner;

public class App {

	private static Scanner input;

	public static void main(String[] args) {
		// testaHash();
	}

	public static void testaHash() {

		HashTable H = new HashTable(10);
		System.out.println();

		input = new Scanner(System.in);

		while (input.hasNext()) {
			String temp = input.next();

			if (temp.equals("quit"))
				System.exit(0);
			else if (temp.equals("existe"))
				System.out.println("\t" + H.existe(input.next()));
			else if (temp.equals("remove"))
				System.out.println("\t" + H.remove(input.next()));
			else if (temp.matches("[a-z]+"))
				H.put(temp);

			H.print();

		}
	}
}
