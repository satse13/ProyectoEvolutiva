package model;

import java.util.ArrayList;

import factories.IndividuoFactory;
import model.individuos.Individuo;

public class AlgoritmoGenetico {

	private int tamPoblacion;
	private ArrayList<Individuo> poblacion;
	private ArrayList<Double> fitness;
	private IndividuoFactory<Individuo> factory;
	private int maxGeneraciones;
	private double probCruce;
	private double probMutacion;
	private int tamTorneo;
	private Individuo elMejor; 
	private int pos_mejor = 0;
	private int dimension;
	
	public AlgoritmoGenetico(int tamPoblacion, int maxGeneraciones, double probCruce, double probMutacion, IndividuoFactory factory, int dimension) {
		this.tamPoblacion = tamPoblacion;
		this.maxGeneraciones = maxGeneraciones;
		this.probCruce = probCruce;
		this.probMutacion = probMutacion;
		this.dimension = dimension;		
		this.factory = factory;
		
		fitness = new ArrayList<Double>();
	}
	
	public void run() {
		poblacion = factory.generatePob(tamPoblacion);
		pobEvaluation();
		for (int i = 0; i < maxGeneraciones; ++i) {
			// seleccion();
			
			pobEvaluation();
		}
	}
	
	private void pobEvaluation() {
		double aux;
		double mejor = 0;
		for(int i = 0; i < tamPoblacion;i++) {
			aux = poblacion.get(i).getFitness();
			fitness.set(i, aux);
			if(aux > mejor) { // TODO Esto depende de si queremos encontrar el maximo o el minimo
				mejor = aux;
				pos_mejor = i;
			}
		}
		elMejor = poblacion.get(pos_mejor);
	}	
}
