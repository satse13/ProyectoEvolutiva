package utils;

import java.util.Random;

public class BinTree {
	
	public static final int MAX_PROFUNDIDAD = 5;
	private String dato;
	private BinTree izq;
	private BinTree der;
	private int profundidad;
	
	public static final String[] operadores = new String[] {
			"add", "mul", "sub"
	};
	
	public static final String[] terminales = new String[] {
			"x", "1", "2", "0", "-1", "-2"
	};


	public BinTree(String dato) {
		this.dato = dato;
	}
	
	public void setArbolIzq(BinTree izq) {
		this.izq = izq;
	}
	
	public void setArbolDer(BinTree der) {
		this.der = der;
	}
	
	// Poner en futuro individuo arbol;
	public BinTree inicializacionCompleta(int profundidad) {
		Random r = new Random();
		BinTree arbol;
		if (profundidad < MAX_PROFUNDIDAD) {
			arbol = new BinTree(operadores[r.nextInt(0, operadores.length)]);
			arbol.setArbolIzq(inicializacionCompleta(profundidad+1));
			arbol.setArbolDer(inicializacionCompleta(profundidad+1));
		}
		else {
			arbol = new BinTree(terminales[r.nextInt(0, terminales.length)]);
		}
		return arbol;
	}
	
}

