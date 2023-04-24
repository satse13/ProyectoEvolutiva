package launcher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import controller.Controller;
import factories.IndividuoArbolFactory;
import factories.IndividuoFactory;
import model.AlgoritmoGenetico;
import model.cruce.Cruce;
import model.cruce.CruceAritmetico;
import model.cruce.CruceBLXA;
import model.cruce.CruceMonopunto;
import model.cruce.CruceUniforme;
import model.mutacion.Mutacion;
import model.mutacion.MutacionBasica;
import model.seleccion.EstocasticoUniversal;
import model.seleccion.Ranking;
import model.seleccion.Restos;
import model.seleccion.Seleccion;
import model.seleccion.SeleccionRuleta;
import model.seleccion.TorneoDeterministico;
import model.seleccion.TorneoProbabilistico;
import model.seleccion.Truncamiento;
import utils.Pair;
import utils.TipoDato;
import utils.Trio;
import view.MainWindow;

public class Main {

	private static Map<String, Pair<IndividuoFactory, Trio<ArrayList<String>,ArrayList<String>,ArrayList<String>>>> mapaFactories = null;

	private static Map<String, Seleccion> mapaSeleccion = null;

	private static Map<String, Cruce> mapaCruce = null;
	
	private static Map<String, Mutacion> mapaMutacion = null;
	
	private static ArrayList<String> listaSeleccion = null;
	
	private static ArrayList<String> listaMutacion = null;
	
	private static ArrayList<String> listaCruce= null;
	

	public static void main(String[] args) {
		
		initMaps();
		AlgoritmoGenetico algoritmo = new AlgoritmoGenetico();
		Controller ctrl = new Controller(algoritmo,mapaFactories,mapaSeleccion, mapaCruce,mapaMutacion);
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
					new MainWindow(ctrl);
			}
		});	
	}
	
	private static void initMaps() {
		
		mapaSeleccion = new HashMap<String, Seleccion>(){{
				put("Ruleta", new SeleccionRuleta());
				put("Torneo Determinístico", new TorneoDeterministico());
				put("Torneo Probabilísitco", new TorneoProbabilistico());
				put("Estocástico Universal", new EstocasticoUniversal());
				put("Truncamiento", new Truncamiento());
				put("Restos", new Restos());
				put("Ranking", new Ranking());
		}};
		
		mapaCruce = new HashMap<String, Cruce>(){{
			put("Cruce Monopunto", new CruceMonopunto());
			put("Cruce Uniforme" , new CruceUniforme());
			put("Cruce Aritmético", new CruceAritmetico());
			put("BLX-Alpha", new CruceBLXA());
		}};
		
		mapaMutacion = new HashMap<String, Mutacion>(){{
			put("Básica", new MutacionBasica());
		}};
		
		listaSeleccion = new ArrayList<String>() {{
			add("Ruleta");
			add("Torneo Determinístico");
			add("Torneo Probabilísitco");
			add("Estocástico Universal");
			add("Truncamiento");
			add("Restos");
			add("Ranking");
		}};
	
		listaMutacion = new ArrayList<String>(){{
			add("Básica");
		}}; 
		
		listaCruce = new ArrayList<String>() {{
			add("Cruce Monopunto");
			add("Cruce Uniforme");
			add("Cruce Aritmético");
			add("BLX-Alpha");
		}};
		
		mapaFactories = new TreeMap<String, Pair<IndividuoFactory, Trio<ArrayList<String>,ArrayList<String>,ArrayList<String>>>>(){{
		 		put("Individuo Arbol", new Pair<IndividuoFactory, Trio<ArrayList<String>, ArrayList<String>, ArrayList<String>>>(new IndividuoArbolFactory(), new Trio<ArrayList<String>,ArrayList<String>,ArrayList<String>>(listaSeleccion,listaCruce,listaMutacion)));
		}};
			
	}

}
