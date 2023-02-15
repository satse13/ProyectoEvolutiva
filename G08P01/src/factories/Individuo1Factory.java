package factories;

import java.util.ArrayList;

import model.individuos.Individuo1;

public class Individuo1Factory implements IndividuoFactory<Individuo1>{
	
	public ArrayList<Individuo1> generatePob(int tamPoblacion) {
		
		ArrayList<Individuo1> poblacion = new ArrayList<Individuo1>();
		
		for(int i = 0; i < tamPoblacion;i++) {
			poblacion.add(new Individuo1());
		}
		
		return poblacion;
		
	}
}
