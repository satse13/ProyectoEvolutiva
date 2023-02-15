package model.individuos;

import java.util.Random;

public abstract class Individuo<T> {

	protected T[] cromosoma;
	protected int[] tamGenes;
	protected double[] max;
	protected double[] min;
	protected Random rand;
	protected int valorError;
	
	public double getFitness() {
		return this.getValor();
	}
	
	protected abstract int tamGen(double valorError, double min, double max);
	protected abstract double getValor();
	protected abstract double getFenotipo(int gen);
	
	protected static int bin2dec(long num) { // TODO Hacer esta funcion
	    int decimalNumber = 0, i = 0;
	    long remainder;
	    
	    while (num != 0) {
	      remainder = num % 10;
	      num /= 10;
	      decimalNumber += remainder * Math.pow(2, i);
	      ++i;
	    }
	    
	    return decimalNumber;
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
	
	
	
}
