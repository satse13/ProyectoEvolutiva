package model.cruce;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import model.individuos.Individuo;
import model.individuos.IndividuoTSP;
import utils.Pair;

public class CruceATX extends Cruce{
	
	protected <T> Pair<ArrayList, ArrayList> cruceAux(Individuo padre1, Individuo padre2) {
	
		ArrayList<T> cPadre1 = padre1.getCromosoma();
		ArrayList<T> cPadre2 = padre2.getCromosoma();
		
		ArrayList<T> crom1 = new ArrayList<T>(cPadre1.size());
		for(int i = 0; i < cPadre1.size();i++) {
			crom1.add(i, null);
		} 
		ArrayList<T> crom2 = new ArrayList<T>(cPadre2.size());
		for(int i = 0; i < cPadre2.size();i++) {
			crom2.add(i, null);
		}
		
		Random r = new Random();
		double aux;
		
		int punto = r.nextInt(0,IndividuoTSP.NUM_CIUDADES);
		
		Set<T> hijo1 = new HashSet<T>();
		Set<T> hijo2 = new HashSet<T>();

		for(int i = 0; i < punto;i++) {
			crom1.set(i, cPadre1.get(i));
			hijo1.add(cPadre1.get(i));
			crom2.set(i, cPadre2.get(i));
			hijo2.add(cPadre2.get(i));
		}
		
		for(int i = punto; i < cPadre1.size();i++){
			if(!hijo1.contains(cPadre2.get(i))) {
				crom1.set(i, cPadre2.get(i));
				hijo1.add(cPadre2.get(i));
			}
			if(!hijo2.contains(cPadre1.get(i))) {
				crom2.set(i, cPadre1.get(i));
				hijo2.add(cPadre1.get(i));
			}
		}
		
		int puntoH = (punto + 1) % cPadre1.size();
		int puntoP = (punto + 1) % cPadre1.size();
		
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
		
		puntoH = (punto + 1) % cPadre2.size();
		puntoP = (punto + 1) % cPadre2.size();
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
