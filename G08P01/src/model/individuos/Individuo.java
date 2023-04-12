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
	
	public String getDeco() {
		return decodificar();
	}
	
	protected abstract double getValor();
	protected abstract String decodificar();
	public abstract double getFenotipo(int gen);
	public abstract boolean mejorFitness(Individuo individuo);
	public abstract Double adaptar(Individuo individuo);
	
	public ArrayList<T> getCromosoma() {
		return this.cromosoma;
	}
	
	public void setCromosoma(ArrayList<T> cromosoma) {
		for(int i = 0; i < cromosoma.size();i++) {
			this.cromosoma.set(i, cromosoma.get(i));
		}
		this.fitness = this.getValor();
	}

	public void mutarBas(double prob) {}
	public void mutarInser(double prob) {}
	public void mutarInter(double prob) {}
	public void mutarInver(double prob) {}
	public void mutarHeur(double prob) {}
	public void mutarTAM(double prob) {}
}
