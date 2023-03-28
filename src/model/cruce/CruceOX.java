package model.cruce;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import model.individuos.Individuo;
import utils.Pair;

public class CruceOX implements Cruce{

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


		int punto1 = r.nextInt(0,cPadre1.size());
		int punto2 = r.nextInt(0,cPadre2.size());
		
		if(punto1 > punto2) {
			int aux = punto1;
			punto1 = punto2;
			punto2 = aux;
		}
		
		Set<T> hijo1 = new HashSet<T>();
		Set<T> hijo2 = new HashSet<T>();

		
		for(int i = punto1; i <= punto2;i++) {
			crom1.set(i, cPadre2.get(i));
			hijo1.add(cPadre2.get(i));
			crom2.set(i, cPadre1.get(i));
			hijo2.add(cPadre1.get(i));
		}
		
		int puntoH = (punto2+1) % cPadre1.size();
		int puntoP = (punto2+1) % cPadre1.size();
		while(hijo1.size() != cPadre1.size()) {
			
			if(crom1.get(puntoH) == null) {
				while(hijo1.contains(cPadre1.get(puntoP))) {
					puntoP = (puntoP + 1) % cPadre1.size();
				}
				crom1.set(puntoH, cPadre1.get(puntoP));
				hijo1.add(cPadre1.get(puntoP));
			}
			else 
				puntoH = (puntoH + 1) % cPadre1.size();
		}
		
		puntoH = (punto2+1) % cPadre2.size();
		puntoP = (punto2+1) % cPadre2.size();
		while(hijo2.size() != cPadre2.size()) {
			
			if(crom2.get(puntoH) == null) {
				while(hijo2.contains(cPadre2.get(puntoP))) {
					puntoP = (puntoP + 1) % cPadre2.size();
				}
				crom2.set(puntoH, cPadre2.get(puntoP));
				hijo2.add(cPadre2.get(puntoP));

			}
			else 
				puntoH = (puntoH + 1) % cPadre2.size();
		}
		
		return new Pair<ArrayList,ArrayList>(crom1,crom2);
	}
}
