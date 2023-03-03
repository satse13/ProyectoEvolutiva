package model.seleccion;

import java.util.ArrayList;

import model.individuos.Individuo;

public class Truncamiento implements Seleccion{

	
	private final double P = 0.4;  
			
	@Override
	public ArrayList<Integer> seleccionar(ArrayList<Individuo> poblacion) {
		
		
 		double indiVueltas = poblacion.size() * P;
		
		ArrayList<Integer> seleccionados = new ArrayList<Integer>(poblacion.size());
		
		while(seleccionados.size() < poblacion.size()){
			int i = 0; 
			while(i < indiVueltas && seleccionados.size() < poblacion.size()) {
				seleccionados.add(poblacion.size()-1-i);
				i++;
			}
		}
		
		return seleccionados;
	}

}
