package model.mutacion;

import java.util.ArrayList;

import model.individuos.Individuo;

public class MutacionHeuristica implements Mutacion{

	@Override
	public void mutar(ArrayList<Individuo> poblacion, double prob) {
		for(Individuo in: poblacion) {
			in.mutarHeur(prob);
		}	
	}
}
