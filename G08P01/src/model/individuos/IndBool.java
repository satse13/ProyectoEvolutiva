package model.individuos;

import java.util.ArrayList;
import java.util.Random;

public abstract class IndBool extends Individuo<Boolean>{

	
	protected abstract int tamGen(double valorError, double min, double max);
	protected abstract double getValor();

	public double getFenotipo(int gen) {
        int tam = this.tamGenes[gen];
        double min = this.min[gen], max = this.max[gen];
        double valor = 0;
        int inicio = 0;
        for(int i = 0; i < gen; i++) { inicio += this.tamGenes[i]; }
        
        for(int i = 0; i < tam; i++) {
            if(this.cromosoma.get(inicio + i)) { valor += Math.pow(2, tam - i - 1); }
        }
        return min + (max - min) * valor / (Math.pow(2, tam) - 1);
    }
	
	@Override
	public void mutar(double prob) {  
		Random r = new Random();	 
		for(int i = 0; i < cromosoma.size();i++) {
			if(r.nextDouble(0,1) < prob) {
				cromosoma.set(i, !cromosoma.get(i));
			}
		}
	}
	
	public ArrayList<Boolean> getCromosoma() {
		return this.cromosoma;
	}

}
