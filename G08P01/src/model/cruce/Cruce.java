package model.cruce;

import java.util.ArrayList;
import java.util.Random;

import factories.IndividuoFactory;
import model.individuos.Individuo;
import utils.Pair;
@SuppressWarnings("rawtypes")
public interface Cruce {
	
	public default ArrayList<Individuo> cruzar(ArrayList<Individuo> poblacion,ArrayList<Pair<Integer,Integer>> seleccionados, double probCruce) {
		
		Random r = new Random();
		ArrayList<Individuo> nuevaGeneracion = new ArrayList<Individuo>();
	
		for(Pair<Integer,Integer> p : seleccionados) {
			
			double prob = r.nextDouble();
			
			if(prob < probCruce) { // Se cruzan
				Pair<Individuo,Individuo> hijos = cruzar(poblacion.get((int)p.getFirst()),  poblacion.get(p.getSecond()));
				nuevaGeneracion.add(hijos.getFirst());
				nuevaGeneracion.add(hijos.getSecond());
			}
		}
		
		return nuevaGeneracion;
	}

	public void cruzar(Individuo ind1, Individuo ind2);
	
}
