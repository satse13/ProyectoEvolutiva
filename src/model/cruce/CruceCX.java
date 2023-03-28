package model.cruce;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import model.individuos.Individuo;
import model.individuos.Individuo4B;
import utils.Pair;

public class CruceCX implements Cruce{

	@Override
	public ArrayList<ArrayList> cruzar(ArrayList<Individuo> poblacion, ArrayList<Integer> seleccionados,double probCruce) {
		ArrayList nuevaGen = new ArrayList<>();
		
		Individuo padre1, padre2;
		
		Random r = new Random();
		
		if(poblacion.size() % 2 == 1) {
			nuevaGen.add(poblacion.get(seleccionados.get(seleccionados.size()-1)).getCromosoma());
			seleccionados.remove(seleccionados.size()-1);
		}
		
		for(int i = 0; i < seleccionados.size();i+=2) {
			
			padre1 = poblacion.get(seleccionados.get(i));
			padre2 = poblacion.get(seleccionados.get(i+1));

			if(r.nextDouble() < probCruce) { // Se cruzan
				Pair<ArrayList,ArrayList> hijos = cruceAux(padre1,padre2);
				nuevaGen.add(hijos.getFirst());
				nuevaGen.add(hijos.getSecond());
			}
			
			else {
				nuevaGen.add(padre1.getCromosoma());
				nuevaGen.add(padre2.getCromosoma());
			}
			
		}
		
		return nuevaGen;
	}

	private <T> Pair<ArrayList, ArrayList> cruceAux(Individuo padre1, Individuo padre2) {
		
		ArrayList<T> cPadre1 = padre1.getCromosoma();
		ArrayList<T> cPadre2 = padre2.getCromosoma();
		
		Random r = new Random();
		
		ArrayList<T> crom1 = new ArrayList<T>(cPadre1.size());
		for(int i = 0; i < cPadre1.size();i++) {
			crom1.add(i, null);
		} 
		ArrayList<T> crom2 = new ArrayList<T>(cPadre2.size());
		for(int i = 0; i < cPadre2.size();i++) {
			crom2.add(i, null);
		}
		
		crom1.set(0, cPadre1.get(0));
		Set<T> hijo1 = new HashSet<T>();
		hijo1.add(crom1.get(0));
		int index = pos(cPadre1,cPadre2.get(0));
		
		while(!hijo1.contains(cPadre2.get(index))) {
			crom1.set(index, cPadre1.get(index));
			index = pos(cPadre1,cPadre2.get(index));
		}
		
		crom1.set(index, cPadre1.get(index));
		
		for(int i = 0; i < cPadre1.size();i++) {
			if(crom1.get(i) == null) {
				crom1.set(i, cPadre2.get(i));
			}
		}
		
		crom2.set(0, cPadre2.get(0));
		Set<T> hijo2 = new HashSet<T>();
		hijo2.add(crom2.get(0));
		index = pos(cPadre2,cPadre1.get(0));
		
		while(!hijo2.contains(cPadre1.get(index))) {
			crom2.set(index, cPadre2.get(index));
			index = pos(cPadre2,cPadre1.get(index));
		}
		
		crom2.set(index, cPadre2.get(index));

		
		for(int i = 0; i < cPadre2.size();i++) {
			if(crom2.get(i) == null) {
				crom2.set(i, cPadre1.get(i));
			}
		}
		
		return new Pair<ArrayList,ArrayList>(crom1,crom2);

	}

	private <T> int pos(ArrayList lista,T valor) {
		for(int i = 0; i < lista.size();i++) {
			if(lista.get(i).equals(valor))
				return i;
		}
		return -1;
	}
}
