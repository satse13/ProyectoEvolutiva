package utils;

import java.util.Random;

public class BinTree<T> {
	
	private T dato;
	private BinTree izq;
	private BinTree der;
	private int profundidad;
	
	public BinTree() {
	}
	
	public BinTree(T dato) {
		this.dato = dato;
	}
	
	public void setArbolIzq(BinTree izq) {
		this.izq = izq;
	}
	
	public void setArbolDer(BinTree der) {
		this.der = der;
	}
	
	public T getDato(){
		return dato;
	}
	
	public BinTree<T> getIzq() {
		return izq;
	}
	
	public BinTree<T> getDer() {
		return der;
	}

	public void add(T dato) {
		// TODO Auto-generated method stub
		
	}
}

