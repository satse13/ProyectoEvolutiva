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

public class CrucePMX implements Cruce {

	
	@Override
	public ArrayList<ArrayList> cruzar(ArrayList<Individuo> poblacion, ArrayList<Integer> seleccionados,
			double probCruce) {

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

	public static <T> Pair<ArrayList, ArrayList> cruceAux(Individuo padre1, Individuo padre2) {

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
		
		//int punto1 = 6;
		//int punto2 = 7;
		
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
	
	 public static void main(String[] args) {
	       
		 
		 ArrayList<Integer> m = new ArrayList<Integer>();
		 m.add(6);
		 m.add(8);
		 m.add(5);
		 m.add(0);
		 m.add(1);
		 m.add(2);
		 m.add(3);
		 m.add(4);
		 m.add(7);

		 
		 ArrayList<Integer> n = new ArrayList<Integer>();
		 n.add(0);
		 n.add(5);
		 n.add(1);
		 n.add(6);
		 n.add(7);
		 n.add(4);
		 n.add(8);
		 n.add(2);
		 n.add(3);
		 
		 IndividuoTSP a = new IndividuoTSP();
		 IndividuoTSP b = new IndividuoTSP();

		 CrucePMX c = new CrucePMX();
		 
		Pair<ArrayList,ArrayList> hijos = c.cruceAux(a,b);

		System.out.println(hijos.getFirst());
		System.out.println(hijos.getSecond());
		 
	 }
		
}
