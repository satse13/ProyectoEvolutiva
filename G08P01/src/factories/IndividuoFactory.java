package factories;


import model.individuos.Individuo;

public interface IndividuoFactory<Individuo>{
	public Individuo generateInd(double valorError);
}
