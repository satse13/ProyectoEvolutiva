package model.cruce;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import model.individuos.Individuo;
import model.individuos.IndividuoTSP;
import utils.Pair;

public class CruceCodificacionOrdinal extends Cruce{
	
	protected Pair<ArrayList, ArrayList> cruceAux(Individuo padre1, Individuo padre2) {
		
		ArrayList<Integer> cPadre1 = padre1.getCromosoma();
		ArrayList<Integer> cPadre2 = padre2.getCromosoma();
		
		Random r = new Random();
		
		ArrayList<Integer> crom1 = new ArrayList<Integer>(cPadre1.size());
		for(int i = 0; i < cPadre1.size();i++) {
			crom1.add(i, null);
		} 
		ArrayList<Integer> crom2 = new ArrayList<Integer>(cPadre2.size());
		for(int i = 0; i < cPadre2.size();i++) {
			crom2.add(i, null);
		}
		
		ArrayList<Integer> nP1 = codificar(cPadre1);
		ArrayList<Integer> nP2 = codificar(cPadre2);

		ArrayList<Integer> h1 = new ArrayList<Integer>();
		ArrayList<Integer> h2 = new ArrayList<Integer>();

		int punto = r.nextInt(0,nP1.size());
				
		for(int i = 0; i < punto;i++) {
			h1.add(nP1.get(i));
			h2.add(nP2.get(i));
		}
		
		for(int i = punto; i < nP1.size();i++) {
			h1.add(nP2.get(i));
			h2.add(nP2.get(i));
		}
		
		crom1 = decodificar(h1);
		crom2 = decodificar(h2);
		
		return new Pair<ArrayList,ArrayList>(crom1,crom2);

	}
	
	private ArrayList<Integer> codificar(ArrayList<Integer> cP1) {
		ArrayList<Integer> lista = new ArrayList<Integer>();
		for(int i = 0; i <= IndividuoTSP.NUM_CIUDADES;i++) {
			if(i !=25)
				lista.add(i);
		}
				
		ArrayList<Integer> ind = new ArrayList<Integer>();
		
		for(int i: cP1) {
			int temp = lista.indexOf(i);
			lista.remove(temp);
			ind.add(temp);
		}
		
		return ind;
	}
	
	private ArrayList<Integer> decodificar(ArrayList<Integer> cP1) {
		
		ArrayList<Integer> lista = new ArrayList<Integer>();
		for(int i = 0; i <= IndividuoTSP.NUM_CIUDADES;i++) {
			if(i !=25)
				lista.add(i);
		}
		ArrayList<Integer> ind = new ArrayList<Integer>();
		
		for(int i: cP1) {
			int temp = lista.get(i);
			lista.remove(i);
			ind.add(temp);
		}
		
		return ind;
	}
}
