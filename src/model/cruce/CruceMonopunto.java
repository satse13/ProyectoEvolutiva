package model.cruce;

import java.util.ArrayList;
import java.util.Random;

import model.individuos.Individuo;
import utils.Pair;

public class CruceMonopunto implements Cruce {

	@Override
	public void cruzar(ArrayList<Individuo> poblacion,ArrayList<Pair<Integer,Integer>> seleccionados, double probCruce) {
		Random r = new Random();
	
		for(Pair<Integer,Integer> p : seleccionados) {
			
			double prob = r.nextDouble();
			
			if(prob < probCruce) { // Se cruzan
				Pair<Individuo,Individuo> hijos = cruzar(poblacion.get((int)p.getFirst()),  poblacion.get(p.getSecond()));
				poblacion.set((int)p.getFirst(),hijos.getFirst());
				poblacion.set((int)p.getSecond(),hijos.getSecond());
			}
		}
		
		return null;
	}

	private Pair<Individuo, Individuo> cruzar(Individuo ind1, Individuo ind2) {
		
		
			
		
		return null;
	}

		
	


	
	
}
