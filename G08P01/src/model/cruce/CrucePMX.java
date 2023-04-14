package model.cruce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import model.individuos.Individuo;
import model.individuos.IndividuoTSP;
import utils.Pair;

public class CrucePMX extends Cruce {

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
		
		int punto1 = r.nextInt(0,cPadre1.size());
		int punto2 = r.nextInt(0,cPadre2.size());

		if(punto1 > punto2) {
			int aux = punto1;
			punto1 = punto2;
			punto2 = aux;
		}
		
		Map<T,T> mapa1= new HashMap<T,T>();
		Map<T,T> mapa2= new HashMap<T,T>();
		Set<T> hijo1 = new HashSet<T>();
		Set<T> hijo2 = new HashSet<T>();

		for(int i = punto1;i <= punto2;i++) {
			crom1.set(i,cPadre2.get(i));
			crom2.set(i, cPadre1.get(i));
			hijo1.add(cPadre2.get(i));
			hijo2.add(cPadre1.get(i));
			mapa1.put(cPadre2.get(i),cPadre1.get(i));
			mapa2.put(cPadre1.get(i),cPadre2.get(i));			
		}
		
		int puntoH = (punto2+1) % cPadre1.size();
		
		while(puntoH != punto1) {
			if(!hijo1.contains(cPadre1.get(puntoH))) {
				crom1.set(puntoH,cPadre1.get(puntoH));
				hijo1.add(cPadre1.get(puntoH));

			}
			else {
				puntoH = (puntoH + 1) % cPadre1.size();
			}
		}
		
		puntoH = (punto2+1) % cPadre2.size();
		
		while(puntoH != punto1) {
			if(!hijo2.contains(cPadre2.get(puntoH))) {
				crom2.set(puntoH,cPadre2.get(puntoH));
				hijo2.add(cPadre2.get(puntoH));
			}
			else {
				puntoH = (puntoH + 1) % cPadre2.size();
			}
		}
		
		for(int i = 0; i < cPadre1.size();i++) {
			if(crom1.get(i) == null){
				T aux = cPadre1.get(i);
				while(hijo1.contains(aux)) {
					aux = mapa1.get(aux);
				}
				crom1.set(i, aux);
				hijo1.add(aux);
			}
		}
		
		for(int i = 0; i < cPadre2.size();i++) {
			if(crom2.get(i) == null){
				T aux = cPadre2.get(i);
				while(hijo2.contains(aux)) {
					aux = mapa2.get(aux);
				}
				crom2.set(i, aux);
				hijo2.add(aux);
			}
		}		
		
		if(hijo1.size() != cPadre1.size() || hijo2.size() != cPadre2.size()) {
			int x = 0;
		}
		return new Pair<ArrayList,ArrayList>(crom1,crom2);
		
	}
			
}
