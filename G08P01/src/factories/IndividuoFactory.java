package factories;

import java.util.ArrayList;
import model.individuos.Individuo;


public interface IndividuoFactory<T extends Individuo>{
	
	public Individuo generateInd(double valorError, int dimension, String creacion, int profundidad);
	
	public <T> Individuo generateInd(ArrayList<T> cromosoma, double valorError, int dimension);
	
}
