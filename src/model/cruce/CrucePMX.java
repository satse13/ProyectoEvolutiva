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

	private Pair<ArrayList, ArrayList> cruceAux(Individuo padre1, Individuo padre2) {

		Random r = new Random();
		
		Set<Integer> set1 = new HashSet<Integer>();
		Set<Integer> set2 = new HashSet<Integer>();

		int punto1 = r.nextInt(0,IndividuoTSP.NUM_CIUDADES);
		int punto2 = r.nextInt(0,IndividuoTSP.NUM_CIUDADES);
		
		if(punto1 > punto2) {
			int aux = punto1;
			punto1 = punto2;
			punto2 = aux;
		}

		Map<Integer,Integer> mapa = new HashMap<Integer,Integer>();
		
		for(int i = punto1; i < punto2;i++) {
			
		}
		
	}
		
}
