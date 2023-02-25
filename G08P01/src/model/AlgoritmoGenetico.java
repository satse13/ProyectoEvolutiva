package model;

import java.util.ArrayList;

import factories.IndividuoFactory;
import model.cruce.Cruce;
import model.individuos.Individuo;
import model.seleccion.Seleccion;
import utils.Pair;

public class AlgoritmoGenetico {

	private int tamPoblacion;
	private ArrayList<Individuo> poblacion;
	private ArrayList<Double> fitness;
	private IndividuoFactory<Individuo> factory;
	private Seleccion seleccion;
	private Cruce cruce;
	private int maxGeneraciones;
	private double probSel;
	private double probCruce;
	private double probMutacion;
	private int tamTorneo;
	private Individuo elMejor; 
	private int pos_mejor = 0;
	private int dimension;
	private double valorError = 0.1;
	
	public AlgoritmoGenetico(int tamPoblacion, int maxGeneraciones, double probSel, double probCruce, double probMutacion, IndividuoFactory factory, Seleccion seleccion,Cruce cruce, int dimension) {
		this.tamPoblacion = tamPoblacion;
		this.maxGeneraciones = maxGeneraciones;
		this.probSel = probSel; 
		this.probCruce = probCruce;
		this.probMutacion = probMutacion;
		this.dimension = dimension;		
		this.factory = factory;
		this.seleccion = seleccion;
		this.cruce = cruce;
		
		fitness = new ArrayList<Double>();
		poblacion = new ArrayList<Individuo>();
	}
	
	public void run() {
		
		initPoblacion();
	//	pobEvaluation();
		
		for(int j = 0; j < poblacion.size();j++) {
			System.out.println(poblacion.get(j).getCromosoma());
		}
		
		System.out.println("--------------------");
		ArrayList<Integer> seleccionados = new ArrayList<Integer>();
		ArrayList cromosomas = new ArrayList<>();
		
		for (int i = 0; i < maxGeneraciones; ++i) {
			
			seleccionados = seleccion.seleccionar(poblacion, probSel); 
			cromosomas = cruce.cruzar(poblacion,seleccionados, probCruce);
			poblacion = nuevaGen(cromosomas);
		
			for(int j = 0; j < poblacion.size();j++) {
				System.out.println(poblacion.get(j).getCromosoma());
			}
			
			// mutacion
			
			
			//pobEvaluation();
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
	
	private void initPoblacion() {
		for(int i = 0; i < this.tamPoblacion;i++) {
			poblacion.add(factory.generateInd(valorError)); 
		}
	}
	
	private <T> ArrayList<Individuo> nuevaGen(ArrayList cromosomas) {
		ArrayList<Individuo> nuevaGen = new ArrayList<Individuo>();
		
		for(int i = 0; i < cromosomas.size();i++) {
			nuevaGen.add(factory.generateInd((ArrayList<T>) cromosomas.get(i),valorError));
		}
		
		return nuevaGen;
	}
}
