package model.seleccion;

import java.util.ArrayList;
import java.util.Random;

import model.individuos.Individuo;
import utils.Pair;

public class SeleccionRuleta implements Seleccion {

	@Override
	public ArrayList<Integer> seleccionar(ArrayList<Individuo> poblacion, double prob) {
		int sumaFit = 0;
		for (int i = 0; i < poblacion.size(); ++i) {
			sumaFit += poblacion.get(i).getFitness();
		}
		
		double probabilidad = 0;
		ArrayList<Double> probabilidades = new ArrayList<Double>(poblacion.size());
		for (int i = 0; i < poblacion.size(); ++i) {
			probabilidad += poblacion.get(i).getFitness() / sumaFit;
			probabilidades.add(probabilidad);
		}
		
		Random random = new Random();
		ArrayList<Integer> seleccionados = new ArrayList<Integer>(poblacion.size());
		double r;
		int indi;
		for (int i = 0; i < poblacion.size(); ++i) {
			r = random.nextDouble();
			indi = buscarIndividuo(probabilidades, r, 0, probabilidades.size());
			seleccionados.add(indi);
		}
		return seleccionados;
	}

	private int buscarIndividuo(ArrayList<Double> probabilidades, double r, int ini, int fin) {
		if (ini + 1 == fin) {
			return ini;
		}
		else {
			int mitad = (ini + fin - 1) / 2;
			if (probabilidades.get(mitad) < r) {
				return buscarIndividuo(probabilidades, r, mitad + 1, fin);
			}
			else {
				return buscarIndividuo(probabilidades, r, ini, mitad + 1);
			}
		}
	}

}
