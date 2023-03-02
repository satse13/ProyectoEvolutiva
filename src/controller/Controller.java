package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import factories.IndividuoFactory;
import model.AlgoritmoGenetico;
import model.cruce.Cruce;
import model.observers.Observer;
import model.seleccion.Seleccion;
import utils.TipoDato;
import utils.Trio;


public class Controller {
	
	private AlgoritmoGenetico algoritmo;
	
	private Map<String, Trio<IndividuoFactory, Boolean, TipoDato>> mapaFactories;
	private Map<String, Seleccion> mapaSeleccion;
	private Map<String, Cruce> mapaCruceBool;
	private Map<String, Cruce> mapaCruceDouble;
	private Map<String, Cruce> mapaCruceActual;
	private String tipoCruce;
	
	public Controller(AlgoritmoGenetico algoritmo, Map<String, Trio<IndividuoFactory, Boolean, TipoDato>> mapaFactories, Map<String, Seleccion> mapaSeleccion, Map<String, Cruce> mapaCruceBool,Map<String, Cruce> mapaCruceDouble) {
		this.algoritmo = algoritmo;
		this.mapaFactories = mapaFactories;
		this.mapaSeleccion = mapaSeleccion;	
		this.mapaCruceBool = mapaCruceBool;
		this.mapaCruceDouble = mapaCruceDouble;
		this.mapaCruceActual = new HashMap<String, Cruce> (mapaCruceBool);
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
		algoritmo.setCruce(this.mapaCruceActual.get(selectedItem));
	}
	
	public Map<String, Trio<IndividuoFactory, Boolean, TipoDato>> getMapaFactories(){
		return Collections.unmodifiableMap(mapaFactories);
	}

	public Map<String, Seleccion> getMapaSeleccion(){
		return Collections.unmodifiableMap(mapaSeleccion);
	}
	
	
	private void setMapaCruce(){
		
		TipoDato dato = mapaFactories.get(tipoCruce).getThird();
		
		if(dato.equals(TipoDato.BOOLEAN))
			this.mapaCruceActual = this.mapaCruceBool;
		else if(dato.equals(TipoDato.DOUBLE))
			this.mapaCruceActual = this.mapaCruceDouble;
		
		
	}
	
	public Map<String, Cruce> getMapaCruce(){
		return Collections.unmodifiableMap(mapaCruceActual);
	}

	public void updateListaCruces(String selectedItem) {
		this.tipoCruce = selectedItem;		
		setMapaCruce();
	}

	public String[] getMapaCruceKeys() {
		String[] ret = new String[mapaCruceActual.size()];
		int i = 0;
		for (String clave:mapaCruceActual.keySet()) {
		   ret[i] = clave;
		   i++;
		}
		return ret;
	}

	

	
}
