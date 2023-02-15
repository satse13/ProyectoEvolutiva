package model;

import java.util.ArrayList;

import model.individuos.Individuo;
import model.individuos.Individuo1;

public class AlgoritmoGenetico {

	private int tamPoblacion;
	private ArrayList<Individuo> poblacion;
	private ArrayList<Double> fitness;
	private int maxGeneraciones;
	private double probCruce;
	private double probMutacion;
	private int tamTorneo;
	private Individuo elMejor; 
	private int pos_mejor;
	private int funcion;
	private int dimension;
	
	
	public AlgoritmoGenetico(int tamPoblacion, int maxGeneraciones, double probCruce, double probMutacion, int funcion, int dimension) {
		this.tamPoblacion = tamPoblacion;
		this.maxGeneraciones = maxGeneraciones;
		this.probCruce = probCruce;
		this.probMutacion = probMutacion;
		this.funcion = funcion;
		this.dimension = dimension;
		
		fitness = new ArrayList<Double>();
		
	}
	
	
	public void run() {
		pobInit();
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
			if(aux > mejor) {
				mejor = aux;
				pos_mejor = i;
			}
		}
		elMejor = poblacion.get(pos_mejor);
	}
	
	private void pobInit() {
				
		switch(funcion) {
		case 0: 
			pobInit1();
			break;
		case 1: 
			pobInit2();
			break;
		case 2:
			pobInit3();
			break;
		case 3: 
			pobInit4a();
			break;
		case 4:
			pobInit4b();
			break;
		default: // Poner excepcion
			break;
		}
		
	}


	private void pobInit4b() {
		// TODO Auto-generated method stub
		
	}


	private void pobInit4a() {
		// TODO Auto-generated method stub
		
	}


	private void pobInit3() {
		// TODO Auto-generated method stub
		
	}


	private void pobInit2() {
		// TODO Auto-generated method stub
		
	}


	private void pobInit1() {
		for(int i = 0; i < this.tamPoblacion;i++) {
			poblacion.add(new Individuo1());
		}	
	}
	
}
