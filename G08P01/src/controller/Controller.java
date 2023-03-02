package controller;

import java.util.Map;

import factories.IndividuoFactory;
import model.AlgoritmoGenetico;
import model.cruce.Cruce;
import model.observers.Observer;
import model.seleccion.Seleccion;


public class Controller {
	// TODO: Vista
	
	private AlgoritmoGenetico algoritmo;
	
	private Map<String, IndividuoFactory> mapaFactories;
	private Map<String, Seleccion> mapaSeleccion;
	private Map<String, Cruce> mapaCruce;

	
	public Controller(AlgoritmoGenetico algoritmo, Map<String, IndividuoFactory> mapaFactories, Map<String, Seleccion> mapaSeleccion, Map<String, Cruce> mapaCruce) {
		this.algoritmo = algoritmo;
		this.mapaFactories = mapaFactories;
		this.mapaSeleccion = mapaSeleccion;	
		this.mapaCruce = mapaCruce;
	}

	public void run() {
		algoritmo.run();
	}
	
	public void reset() {
		algoritmo.reset();  
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

	public void updateGenSize(int parseInt) {
		algoritmo.setGenSize(parseInt);
		
	}

	public void updateValorError(double d) {
		algoritmo.setValorError(d);
		
	}

	public void updateProbCruce(double d) {
		algoritmo.setProbCruce(d);
		
	}

	public void updateProbMuta(double d) {
		algoritmo.setProbMutacion(d);
		
	}

	public void updatePorElite(double d) {
		algoritmo.setPorElitismo(d);
	}


	public void updateSeleccion(String selectedItem) {
		algoritmo.setSeleccion(mapaSeleccion.get(selectedItem));
		
	}

	public void updateCruce(String selectedItem) {
		algoritmo.setProbCruce(mapaCruce.get(selectedItem));
		
	}

	public void updateIndividuoFactory(String selectedItem) {
		algoritmo.setIndividuoFactory(mapaFactories.get(selectedItem));
		
	}
	
}
