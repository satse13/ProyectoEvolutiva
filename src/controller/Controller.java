package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import factories.IndividuoFactory;
import model.AlgoritmoGenetico;
import model.cruce.Cruce;
import model.mutacion.Mutacion;
import model.observers.Observer;
import model.seleccion.Seleccion;
import utils.TipoDato;
import utils.Trio;


public class Controller {
	
	private AlgoritmoGenetico algoritmo;
	
	private Map<String, Trio<IndividuoFactory, Boolean, Trio<ArrayList<String>,ArrayList<String>,ArrayList<String>>>> mapaFactories;
	private Map<String, Seleccion> mapaSeleccion;
	private Map<String, Cruce> mapaCruce;
	private Map<String ,Mutacion> mapaMutacion;
	
	private String tipoCruce;
	
	public Controller(AlgoritmoGenetico algoritmo, Map<String, Trio<IndividuoFactory, Boolean, Trio<ArrayList<String>,ArrayList<String>,ArrayList<String>>>> mapaFactories, Map<String, Seleccion> mapaSeleccion,Map<String, Cruce> mapaCruce, Map<String,Mutacion> mapaMutacion) {
		this.algoritmo = algoritmo;
		this.mapaFactories = mapaFactories;
		this.mapaSeleccion = mapaSeleccion;	
		this.mapaCruce = mapaCruce;
		this.mapaMutacion = mapaMutacion;
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

	public String[] getFuncionKey(){
		String[] ret = new String[mapaFactories.size()];
		int i = 0;
		for (String clave:mapaFactories.keySet()) {
		   ret[i] = clave;
		   i++;
		}
		return ret;
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


	public void updateIndividuoFactory(String selectedItem) {
		algoritmo.setIndividuoFactory(mapaFactories.get(selectedItem).getFirst());
		
	}
	
	public void updateDimension(int value) {
		algoritmo.setDimension(value);
		
	}
	
	public void updateCruce(String selectedItem) {
		algoritmo.setCruce(this.mapaCruce.get(selectedItem));
	}

	public Map<String, Trio<IndividuoFactory, Boolean, Trio<ArrayList<String>,ArrayList<String>,ArrayList<String>>>> getMapaFactories() {
		return Collections.unmodifiableMap(mapaFactories);
	}

	public void updateMutacion(String selectedItem) {
		algoritmo.setMutacion(this.mapaMutacion.get(selectedItem));
	}
	
	

}