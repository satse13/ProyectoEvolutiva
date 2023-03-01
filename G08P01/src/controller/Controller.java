package controller;

import java.util.Map;

import factories.IndividuoFactory;
import model.AlgoritmoGenetico;
import model.observers.Observer;
import model.seleccion.Seleccion;


public class Controller {
	// TODO: Vista
	
	private AlgoritmoGenetico algoritmo;
	
	private Map<String, IndividuoFactory> mapaFactories;
	private Map<String, Seleccion> mapaSeleccion;

	
	public Controller(AlgoritmoGenetico algoritmo, Map<String, IndividuoFactory> mapaFactories, Map<String, Seleccion> mapaSeleccion) {
		this.algoritmo = algoritmo;
		this.mapaFactories = mapaFactories;
		this.mapaSeleccion = mapaSeleccion;	
	}

	public void run() {
		algoritmo.run();
	}
	
	public void reset() {
		//algoritmo.reset();  
	}
	
	public void addObserver(Observer o) {
		algoritmo.addObserver(o);
	}

	public void removeObserver(Observer o) {
		algoritmo.removeObserver(o);
	}

	public void updatePobSize(int parseInt) {
		algoritmo.setPobSize(parseInt);
		
	}
	
}
