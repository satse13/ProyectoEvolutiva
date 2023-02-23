package factories;

import model.individuos.Individuo1;

public class Individuo1Factory implements IndividuoFactory<Individuo1>{
	
	public Individuo1 generateInd(double valorError) {
		
		return new Individuo1(valorError);
	}
}
