package model.cruce;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import model.individuos.Individuo;
import model.individuos.Individuo4B;
import utils.Pair;

public class CruceOrdenPrioritario extends Cruce{


	protected <T> Pair<ArrayList, ArrayList> cruceAux(Individuo padre1, Individuo padre2) {
		
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

		ArrayList<Integer> puntos = new ArrayList<Integer>();
		
		Set<Integer> punt = new HashSet<Integer>();
		
		while(puntos.size() < cPadre1.size()/2) {
			int aux = r.nextInt(0,cPadre1.size());
			if(!punt.contains(aux)) {
				puntos.add(aux);
				punt.add(aux);
			}
		}
		
		Set<T> hijo1 = new HashSet<T>();

		for(int p: puntos) {
			hijo1.add(cPadre1.get(p));
		}
		
		for(int i = 0; i < cPadre2.size();i++) {
			if(!hijo1.contains(cPadre2.get(i))) {
				crom1.set(i,cPadre2.get(i));
			}
		}
		int aux1 = 0;
		for(int p: puntos) {
			while(crom1.get(aux1) != null) {
				aux1 = (aux1 + 1) % cPadre1.size();
			}
			crom1.set(aux1,cPadre1.get(p));
		}
		
		puntos.clear();
		punt.clear();
						
		while(puntos.size() < cPadre1.size()/2) {
			int aux = r.nextInt(0,cPadre2.size());
			if(!punt.contains(aux)) {
				puntos.add(aux);
				punt.add(aux);
			}
		}
		
		Set<T> hijo2 = new HashSet<T>();

		for(int p: puntos) {
			hijo2.add(cPadre2.get(p));
		}
		
		for(int i = 0; i < cPadre1.size();i++) {
			if(!hijo2.contains(cPadre1.get(i))) {
				crom2.set(i,cPadre1.get(i));
			}
		}
		int aux = 0;
		for(int p: puntos) {
			while(crom2.get(aux) != null) {
				aux = (aux + 1) % cPadre2.size();
			}
			crom2.set(aux,cPadre2.get(p));
		}
		
		return new Pair<ArrayList,ArrayList>(crom1,crom2);
	}
}
