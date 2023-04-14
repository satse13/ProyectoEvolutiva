package model.cruce;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import model.individuos.Individuo;
import model.individuos.Individuo4B;
import model.individuos.IndividuoTSP;
import utils.Pair;

public class CruceRecombinacionRutas extends Cruce{

	
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

		ArrayList<ArrayList<Integer>> table = new ArrayList<ArrayList<Integer>>();		
		
		for(int i = 0; i <= IndividuoTSP.NUM_CIUDADES;i++) {
			table.add(new ArrayList<Integer>());
		}
		
		
	    ArrayList<Integer>temp = new ArrayList<Integer>();
	    temp.add(cPadre1.get(cPadre1.size()-1));
	    temp.add(cPadre1.get(1));
	    table.set(cPadre1.get(0),temp);
		
	    for(int i = 1; i < cPadre1.size()-1;i++) {
	    	temp = new ArrayList<Integer>();
	    	temp.add(cPadre1.get(i-1));
	    	temp.add(cPadre1.get(i+1));
	    	table.set(cPadre1.get(i), temp);
	    }
	    
	    temp = new ArrayList<Integer>();
	    temp.add(cPadre1.get(0));
	    temp.add(cPadre1.get(cPadre1.size()-2));
	    table.set(cPadre1.get(cPadre1.size()-1),temp);

	    if(!contains(table.get(cPadre2.get(0)),cPadre2.get(cPadre2.size()-1))){
	    	table.get(cPadre2.get(0)).add(cPadre2.get(cPadre2.size()-1));
	    }
	    if(!contains(table.get(cPadre2.get(0)),cPadre2.get(1))){
	    	table.get(cPadre2.get(0)).add(cPadre2.get(1));
	    }	    
	    
	    for(int i = 1; i < cPadre2.size()-1;i++) {
		    if(!contains(table.get(cPadre2.get(i)),cPadre2.get(i-1))){
		    	table.get(cPadre2.get(i)).add(cPadre2.get(i-1));
		    }
		    if(!contains(table.get(cPadre2.get(i)),cPadre2.get(i+1))){
		    	table.get(cPadre2.get(i)).add(cPadre2.get(i+1));
		    }
	    }
	    
	    if(!contains(table.get(cPadre2.get(cPadre2.size()-1)),cPadre2.get(cPadre2.size()-2))){
	    	table.get(cPadre2.get(cPadre2.size()-1)).add(cPadre2.get(cPadre2.size()-2));
	    }
	    if(!contains(table.get(cPadre2.get(cPadre2.size()-1)),cPadre2.get(0))){
	    	table.get(cPadre2.get(cPadre2.size()-1)).add(cPadre2.get(0));
	    }	
	    
	    
	    Set<Integer> hijo1 = new HashSet<Integer>();
	    crom1.set(0, cPadre1.get(0));
	    hijo1.add(cPadre1.get(0));
	    int contador = 1;
	    int index = cPadre1.get(0);
	    while(contador < cPadre1.size()) {
	    	int menor = table.get(index).get(0);
	    	if(check(table,index,hijo1)) { // En caso de llegar a un bloqueo
	    		for(int c: cPadre1) {
	    			if(!hijo1.contains(c)) {
	    				menor = c;
	    			}
	    		}
	    	}
	    	else {
		    	for(int in: table.get(index)) {
		    		if((table.get(in).size() < table.get(menor).size() && !hijo1.contains(in)) || hijo1.contains(menor)) {
		    			menor = in;
		    		}
		    	}
	    	}
	    	crom1.set(contador,menor);
	    	hijo1.add(menor);
	    	index = menor;
	    	contador++;
	    }
	    
	    Set<Integer> hijo2 = new HashSet<Integer>();
	    crom2.set(0, cPadre2.get(0));
	    hijo2.add(cPadre2.get(0));
	    contador = 1;
	    index = cPadre2.get(0);
	    while(contador < cPadre2.size()) {
	    	int menor = table.get(index).get(0);
	    	if(check(table,index,hijo2)) { // En caso de llegar a un bloqueo
	    		for(int c: cPadre2) {
	    			if(!hijo2.contains(c)) {
	    				menor = c;
	    			}
	    		}
	    	}
	    	else {
		    	for(int in: table.get(index)) {
		    		if((table.get(in).size() < table.get(menor).size() && !hijo2.contains(in)) || hijo2.contains(menor)) {
		    			menor = in;
		    		}
		    	}
	    	}
	    	crom2.set(contador,menor);
	    	hijo2.add(menor);
	    	index = menor;
	    	contador++;
	    }
	     
		return new Pair<ArrayList,ArrayList>(crom1,crom2);
	}
	
	private boolean contains(ArrayList<Integer> lista, int valor) {
		for(Integer t : lista) {
			if(t.equals(valor))
				return true;
		}
		return false;
	}
	
	private boolean check(ArrayList<ArrayList<Integer>> table, int index, Set<Integer> hijo1) {
		for(int in: table.get(index)) {
    		if(!hijo1.contains(in))
    			return false;
    	}
		return true;
	}
}
