package factories;

import java.util.ArrayList;

import model.individuos.Individuo1;

public interface IndividuoFactory<Individuo>{
	public ArrayList<Individuo> generatePob(int tamPoblacion);
}
