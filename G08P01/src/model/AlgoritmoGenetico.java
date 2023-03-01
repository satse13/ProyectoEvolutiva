package model;

import java.util.ArrayList;
import java.util.Collections;
 
import factories.IndividuoFactory;
import model.cruce.Cruce;
import model.individuos.Individuo;
import model.observers.Observable;
import model.observers.Observer;
import model.seleccion.Seleccion;
 
public class AlgoritmoGenetico implements Observable<Observer>{

	private int tamPoblacion;
	private ArrayList<Individuo> poblacion;
	private ArrayList<Double> fitness;
	private IndividuoFactory<Individuo> factory;
	private Seleccion seleccion;
	private Cruce cruce;
	private int maxGeneraciones;
	private double probCruce;
	private double probMutacion;
	private int tamTorneo;
	private Individuo elMejor; 
	private int dimension;
	private double valorError = 0.00001;
	private double porElitismo = 0.05;
	private ArrayList<Individuo> elite;
	
	private ArrayList<Observer> observers;
		
	public AlgoritmoGenetico(int tamPoblacion, int maxGeneraciones, double probCruce, double probMutacion, IndividuoFactory factory, Seleccion seleccion,Cruce cruce, int dimension, double porElitismo) {
		this.tamPoblacion = tamPoblacion;
		this.maxGeneraciones = maxGeneraciones;
		this.probCruce = probCruce;
		this.probMutacion = probMutacion;
		this.dimension = dimension;		
		this.factory = factory;
		this.seleccion = seleccion;
		this.cruce = cruce;
		this.porElitismo = porElitismo;
		fitness = new ArrayList<Double>();
		poblacion = new ArrayList<Individuo>();
		elite = new ArrayList<Individuo>((int)(poblacion.size()*porElitismo));
		observers = new ArrayList<>();
	}
	
	public void run() {
		
		
		initPoblacion();
		
		pobEvaluation();
		
		
		
		//for(int j = 0; j < poblacion.size();j++) { 
			//System.out.println(poblacion.get(j).getCromosoma());
		//}
		
		//System.out.println("--------------------");
		ArrayList<Integer> seleccionados = new ArrayList<Integer>();
		ArrayList cromosomas = new ArrayList<>();
		
		
		
		for (int i = 0; i < maxGeneraciones; ++i) {
			
			if(porElitismo > 0)
				seleccionaElite();
			
			seleccionados = seleccion.seleccionar(poblacion); 
			cromosomas = cruce.cruzar(poblacion,seleccionados, probCruce);
			poblacion = nuevaGen(cromosomas);
		
			//for(int j = 0; j < poblacion.size();j++) { 
				//System.out.println(poblacion.get(j).getCromosoma());
			//}
			
			// mutacion
			for(int j = 0; j < poblacion.size();j++) {
				poblacion.get(j).mutar(probMutacion);
			}
			
			//System.out.println("-------------------");
			
			//for(int j = 0; j < poblacion.size();j++) {  // ESTO HAY QUE BORRARLO
				//System.out.println(poblacion.get(j).getCromosoma());
			//}
			if(porElitismo > 0)
				incluirElite();
			
			pobEvaluation();
		}
		
		
		System.out.println(elMejor.getFenotipo(0));
		System.out.println(elMejor.getFenotipo(1));
		System.out.println(elMejor.getFitness());

	}
	
	private void incluirElite() {
		Collections.sort(poblacion);
		for (int i = 0; i < elite.size(); ++i) {
			poblacion.set(i, elite.get(i));
		}
	}

	private void seleccionaElite() {
		
		Collections.sort(poblacion);
				
		int j = poblacion.size() - 1;
		for(int i = 0; i < elite.size();i++){
			elite.set(i, poblacion.get(j));
			j--;
		}
	}

	private void pobEvaluation() {
		Collections.sort(poblacion);
		elMejor = poblacion.get(poblacion.size()-1);
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

	@Override
	public void addObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		observers.remove(o);
	}
	
	public Individuo getMejor() {
		return elMejor;
	}

	public void setPobSize(int parseInt) {
		this.tamPoblacion = parseInt;
		
	}
}
