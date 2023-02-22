package model.seleccion;

import java.util.ArrayList;
import java.util.Random;

import model.individuos.Individuo;
import utils.Pair;

public class SeleccionRuleta implements Seleccion {

	@Override
	public ArrayList<Pair<Integer, Integer>> seleccionar(ArrayList<Individuo> poblacion, double prob) {
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
		ArrayList<Pair<Integer, Integer>> seleccionados = new ArrayList<Pair<Integer, Integer>>(poblacion.size() / 2);
		double r;
		int a, b;
		for (int i = 0; i < poblacion.size() / 2; ++i) {
			r = random.nextDouble();
			a = buscarIndividuo(probabilidades, r, 0, probabilidades.size());
			r = random.nextDouble();
			b = buscarIndividuo(probabilidades, r, 0, probabilidades.size());
			seleccionados.add(new Pair<Integer, Integer>(a,b));
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
