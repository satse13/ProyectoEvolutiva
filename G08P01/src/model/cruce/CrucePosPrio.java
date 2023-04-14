package model.cruce;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import model.individuos.Individuo;
import model.individuos.Individuo4B;
import utils.Pair;

public class CrucePosPrio extends Cruce{

	
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


		int punto1 = r.nextInt(0,cPadre1.size());
		int punto2 = r.nextInt(0,cPadre2.size());
			
		Set<T> hijo1 = new HashSet<T>();
		Set<T> hijo2 = new HashSet<T>();

		
		crom1.set(punto1, cPadre2.get(punto1));
		hijo1.add(cPadre2.get(punto1));
		crom1.set(punto2, cPadre2.get(punto2));
		hijo1.add(cPadre2.get(punto2));
		
		crom2.set(punto1,  cPadre1.get(punto1));
		hijo2.add(cPadre1.get(punto1));
		crom2.set(punto2, cPadre1.get(punto2));
		hijo2.add(cPadre1.get(punto2));
		
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
