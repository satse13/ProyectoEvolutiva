package model.individuos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import utils.BinTree;
import utils.Function;
import utils.Pair;

public class IndividuoArbol extends Individuo<String>{
	
	public final static String COMPLETO = "COMPLETO";
	public final static String CRECIENTE = "CRECIENTE";
	public final static String RAMPED = "RAMPED";
	
	public static final int MAX_PROFUNDIDAD = 5;
	
	public static final Set<String> operadores = new HashSet<String>() {{add("add"); add("mul"); add("sub");}};
	
	public static final Set<String> terminales = new HashSet<String>() {{add("x"); add("1"); add("2"); add("0"); add("-1"); add("-2");}};
	
	private BinTree<String> arbol;
	
	private int profundidad;
	
	private Map<String, Function<Integer>> mapaFunciones = new HashMap<String, Function<Integer>>() {{
		put(COMPLETO, (x) -> inicializacionCompleta(x));
		put(CRECIENTE, (x) -> inicializacionCreciente(x));
		put(RAMPED, (x) -> RampedAndHalf(x));
	}};
	
	
	public IndividuoArbol( String tipoCreacion, int profundidad) {
		this.profundidad = profundidad;
		this.cromosoma = new ArrayList<String>();
		mapaFunciones.get(tipoCreacion).apply(1);
		arbol.toArray(cromosoma);
		this.fitness = this.getValor();
	}
	
	public IndividuoArbol(ArrayList<String> cromosoma) {
		this.cromosoma = new ArrayList<String>(cromosoma);
		arbol = new BinTree<String>();
		//arbol.arbolToBinTreeAux(cromosoma, profundidad);
	}
	
	@Override
	public int compareTo(Individuo o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected double getValor() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected String decodificar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getFenotipo(int gen) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean mejorFitness(Individuo individuo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Double adaptar(Individuo individuo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void inicializacionCompleta(int profundidad) {
		arbol = inicializacionCompletaAux(profundidad);
	}
	
	private void inicializacionCreciente(int profundidad) {
		arbol = inicializacionCompletaAux(profundidad);
	}
	
	private void RampedAndHalf(int profundidad) {
		arbol = inicializacionCompletaAux(profundidad);
	}

	public BinTree<String> inicializacionCompletaAux(int profundidad) {
		BinTree<String> arbolAux;
		if (profundidad < this.profundidad) {
			arbolAux = new BinTree(operadores[rand.nextInt(0, operadores.length)]);
			arbolAux.setArbolIzq(inicializacionCompletaAux(profundidad+1));
			arbolAux.setArbolDer(inicializacionCompletaAux(profundidad+1));
		}
		else {
			arbolAux = new BinTree(terminales[rand.nextInt(0, terminales.length)]);
		}
		return arbolAux;
	}
	
	public BinTree<String> inicializacionCrecienteAux(int profundidad) { // OJO CON EL PIOJO LA INSTANCIA DEL ARBOL
		// TODO
		return arbol;
	}
	
	public BinTree<String> RampedAndHalfAux(int profundidad) { // OJO CON EL PIOJO LA INSTANCIA DEL ARBOL
		//TODO
		return arbol;
	}
	
	private void toArrayAux(ArrayList<String> array, BinTree<String> a){
		array.add(a.getDato());
		toArrayAux(array,a.getIzq());
		toArrayAux(array,a.getDer());
	}
	
	private void toBinTreeAux(ArrayList<String> array, BinTree<String> arbol, int cont) {
		if (arbol.getDato()) {
			
		}
	}

}
