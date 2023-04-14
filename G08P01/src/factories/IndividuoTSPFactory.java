package factories;

import java.util.ArrayList;

import model.individuos.IndividuoTSP;

public class IndividuoTSPFactory implements IndividuoFactory<IndividuoTSP>{
	@Override
	public IndividuoTSP generateInd(double valorError, int dimension, String creacion, int profundidad) {
		return new IndividuoTSP();
	}

	@Override
	public <T> IndividuoTSP generateInd(ArrayList<T> cromosoma, double valorError, int dimension) {
		return new IndividuoTSP((ArrayList<Integer>) cromosoma);
	}

}
