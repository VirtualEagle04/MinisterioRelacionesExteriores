package co.edu.unbosque.view;

import java.util.Scanner;

public class Consola {
	private Scanner sc;
	
	public Consola() {
		sc = new Scanner(System.in);
	}
	
	public void printSalto(String str) {
		System.out.println(str);
	}
	
	public void printSinSalto(String str) {
		System.out.print(str);
	}
	
	public void printErrorSalto(String str) {
		System.err.println(str);
	}
	
	public void printErrorSinSalto(String str) {
		System.err.print(str);
	}
	
	public int leerInt() {
		return sc.nextInt();
	}
	
	public float leerFloat() {
		return sc.nextFloat();
	}
	
	public long leerLong() {
		return sc.nextLong();
	}
	
	public double leerDouble() {
		return sc.nextDouble();
	}
	
	public boolean leerBooleano() {
		return sc.nextBoolean();
	}
	
	public String leerNextLine() {
		return sc.nextLine();
	}
	
	public String leerNext() {
		return sc.next();
	}
	
	public void quemarLinea() {
		sc.nextLine();
	}
	
}
