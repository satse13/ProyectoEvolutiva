package model.individuos;

import java.util.ArrayList;
import java.util.Random;

public class Individuo1 extends Individuo<Boolean>{

	public Individuo1(double valorError) {
		initIndividuo();
		this.tamGenes[0] = this.tamGen(valorError, min[0], max[0]);
		this.tamGenes[1] = this.tamGen(valorError, min[1], max[1]);
		int tamTotal = tamGenes[0] + tamGenes[1];
		this.cromosoma = new ArrayList<Boolean>(tamTotal);
		for(int i = 0; i < tamTotal; i++) { this.cromosoma.add(this.rand.nextBoolean()); }
	}
	
	public Individuo1(ArrayList<Boolean> cromosoma, double valorError) {
		initIndividuo();
		this.tamGenes[0] = this.tamGen(valorError, min[0], max[0]);
		this.tamGenes[1] = this.tamGen(valorError, min[1], max[1]);
		int tamTotal = tamGenes[0] + tamGenes[1];
		this.cromosoma = cromosoma;	
	}

	protected int tamGen(double valorError, double min, double max) {
		return (int) (Math.log10(((max - min) / valorError) + 1) / Math.log10(2));
	}
	
	protected double getValor() {
		double x1 = this.getFenotipo(0), x2 = this.getFenotipo(1);
		return (21.5 + x1 * Math.sin(4 * Math.PI * x1) + x2 * Math.sin(20 * Math.PI * x2));
	}
	
	protected double getFenotipo(int gen) { // TODO hacer funcion
		
		
//		return  (this.min[gen] + (this.cromosoma));
		return 0;
	}
	
	protected long bool2int(boolean foo) {
	    return (foo) ? 1 : 0;
	}
	
	protected long bool2long(Boolean[] bool, int ini, int fin) {
		int acc = 1;
		long num = 0;
		for (int i = fin; i >= ini; --i) {
			num += (acc * bool2int(bool[i]));
			acc = acc * 10;
	
		}
		return num;	
	}
	
	public ArrayList<Boolean> getCromosoma() {
		return this.cromosoma;
	}
	
	private void initIndividuo() {
		this.tamGenes = new int[2];
		this.min = new double[2];
		this.max = new double[2];
		this.min[0] = -3.000;
		this.min[1] = 4.100;
		this.max[0] = 12.100;
		this.max[1] = 5.800;
		this.rand = new Random();
	}
	
}
