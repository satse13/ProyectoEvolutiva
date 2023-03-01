package factories;

import java.util.ArrayList;
import model.individuos.Individuo;


public interface IndividuoFactory<Individuo>{
	
	public Individuo generateInd(double valorError);
	
	public <T> Individuo generateInd(ArrayList<T> cromosoma, double valorError);
	
}
