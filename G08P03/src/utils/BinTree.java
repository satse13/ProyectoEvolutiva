package utils;

import java.util.ArrayList;

public class BinTree<T> {
	
	private T dato;
	private BinTree<T> izq;
	private BinTree<T> der;
	private boolean completo = false;
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
		
	}
	
	public void toArray(ArrayList<T> array) {
		array.add(dato);
		izq.toArray(array);
		der.toArray(array);
	}


}

