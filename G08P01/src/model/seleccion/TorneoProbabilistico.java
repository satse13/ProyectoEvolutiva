package model.seleccion;

import java.util.ArrayList;
import java.util.Random;

import model.individuos.Individuo;

public class TorneoProbabilistico implements Seleccion{

	private final int SIZE_GRUPO = 3;
	private final double P = 0.5;
	
	@Override
	public ArrayList<Integer> seleccionar(ArrayList<Individuo> poblacion) {
		
		ArrayList<Integer> seleccionados = new ArrayList<Integer>();
		Random r = new Random();
		
		 for(int i = 0; i < poblacion.size();i++) {
			  ArrayList<Integer> competidores = new ArrayList<Integer>();
			  for (int j = 0; j < SIZE_GRUPO; j++) {
		            competidores.add(r.nextInt(0,poblacion.size()));
		      }
			 
			  int ganador = competidores.get(0);
			  
			  double prob = r.nextDouble(0,1);
			  
			  if(prob > P) { // Se coge el mejor del grupo
				  for (int j = 1; j < SIZE_GRUPO; j++) {
			            int actual = competidores.get(j);
			            if (poblacion.get(ganador).mejorFitness(poblacion.get(actual))) {
			                ganador = actual;
			            }
			       }
			  }
			  else { 
				  for (int j = 1; j < SIZE_GRUPO; j++) {
			            int actual = competidores.get(j);
			            if (!poblacion.get(ganador).mejorFitness(poblacion.get(actual))) {
			                ganador = actual;
			            }
			       }
			  }
			  
			  seleccionados.add(ganador);
		 }
		return seleccionados;
	}

}
