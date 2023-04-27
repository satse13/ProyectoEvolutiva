package factories;

import java.util.ArrayList;

import model.individuos.Individuo;
import model.individuos.IndividuoArbol;

public class IndividuoArbolFactory implements IndividuoFactory<IndividuoArbol>{

	@Override
	public Individuo generateInd(double valorError, int dimension, String creacion, int profundidad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> Individuo generateInd(T cromosoma, double valorError, int dimension) {
		// TODO Auto-generated method stub
		return null;
	}

}
