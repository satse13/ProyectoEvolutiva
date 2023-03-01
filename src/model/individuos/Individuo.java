package model.individuos;

import java.util.ArrayList;
import java.util.Random;

public abstract class Individuo<T> implements Comparable<Individuo>{

	protected ArrayList<T> cromosoma;
	protected int[] tamGenes;
	protected double[] max;
	protected double[] min;
	protected Random rand;
	protected double fitness;
	
	public double getFitness() {
		return this.fitness;
	}
	
	protected abstract int tamGen(double valorError, double min, double max);
	protected abstract double getValor();
	public abstract double getFenotipo(int gen);
	public abstract void mutar(double prob);

	
	public ArrayList<T> getCromosoma() {
		return this.cromosoma;
	}

	public abstract boolean mejorFitness(Individuo individuo);

	public abstract Double adaptar(Individuo individuo);
	
}
