package model.individuos;

import java.util.Random;

public abstract class Individuo<T> implements Comparable<Individuo>{

	protected T cromosoma;
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
	public abstract void setCromosoma(T cromosoma);
	
	public T getCromosoma() {
		return this.cromosoma;
	}
	
	public void mutarBas(double prob) {}
	public void mutarInser(double prob) {}
	public void mutarInter(double prob) {}
	public void mutarInver(double prob) {}
	public void mutarHeur(double prob) {}
	public void mutarTAM(double prob) {}
	public void mutarTer(double prob) {}
	public void mutarFun(double prob) {}
	public void mutarSub(double prob) {}

}
