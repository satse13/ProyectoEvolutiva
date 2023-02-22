package model.cruce;

import java.util.ArrayList;

import model.individuos.Individuo;
import utils.Pair;

public interface Cruce {

	public void cruzar(ArrayList<Individuo> poblacion,ArrayList<Pair<Integer,Integer>> seleccionados, double probCruce);
	
}
