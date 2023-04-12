package launcher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import controller.Controller;
import factories.Individuo1Factory;
import factories.Individuo2Factory;
import factories.Individuo3Factory;
import factories.Individuo4AFactory;
import factories.Individuo4BFactory;
import factories.IndividuoFactory;
import factories.IndividuoTSPFactory;
import model.AlgoritmoGenetico;
import model.cruce.Cruce;
import model.cruce.CruceATX;
import model.cruce.CruceAritmetico;
import model.cruce.CruceBLXA;
import model.cruce.CruceCX;
import model.cruce.CruceCodificacionOrdinal;
import model.cruce.CruceMonopunto;
import model.cruce.CruceOX;
import model.cruce.CruceOrdenPrioritario;
import model.cruce.CrucePMX;
import model.cruce.CrucePosPrio;
import model.cruce.CruceRecombinacionRutas;
import model.cruce.CruceUniforme;
import model.mutacion.Mutacion;
import model.mutacion.MutacionBasica;
import model.mutacion.MutacionHeuristica;
import model.mutacion.MutacionInsercion;
import model.mutacion.MutacionIntercambio;
import model.mutacion.MutacionInversion;
import model.mutacion.MutacionTAM;
import model.seleccion.EstocasticoUniversal;
import model.seleccion.Ranking;
import model.seleccion.Restos;
import model.seleccion.Seleccion;
import model.seleccion.SeleccionRuleta;
import model.seleccion.TorneoDeterministico;
import model.seleccion.TorneoProbabilistico;
import model.seleccion.Truncamiento;
import utils.TipoDato;
import utils.Trio;
import view.MainWindow;

public class Main {

	private static Map<String, Trio<IndividuoFactory, Boolean, Trio<ArrayList<String>,ArrayList<String>,ArrayList<String>>>> mapaFactories = null;

	private static Map<String, Seleccion> mapaSeleccion = null;

	private static Map<String, Cruce> mapaCruce = null;
	
	private static Map<String, Mutacion> mapaMutacion = null;
	
	private static ArrayList<String> listaSeleccion = null;
	
	private static ArrayList<String> listaCruceDouble = null;
		
	private static ArrayList<String> listaCruceBool = null;
	
	private static ArrayList<String> listaMutacionBasica = null;
	
	private static ArrayList<String> listaCruceTSP= null;

	private static ArrayList<String> listaMutacionTSP = null;

	

	public static void main(String[] args) {
		
		initMaps();
		AlgoritmoGenetico algoritmo = new AlgoritmoGenetico();
		Controller ctrl = new Controller(algoritmo,mapaFactories,mapaSeleccion, mapaCruce,mapaMutacion);
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
					new MainWindow(ctrl);
				
			}
		});	
	}
	
	private static void initMaps() {
		
		mapaSeleccion = new HashMap<String, Seleccion>(){{
				put("Ruleta", new SeleccionRuleta());
				put("Torneo Determin�stico", new TorneoDeterministico());
				put("Torneo Probabil�sitco", new TorneoProbabilistico());
				put("Estoc�stico Universal", new EstocasticoUniversal());
				put("Truncamiento", new Truncamiento());
				put("Restos", new Restos());
				put("Ranking", new Ranking());
		}};
		
		mapaCruce = new HashMap<String, Cruce>(){{
			put("Cruce Monopunto", new CruceMonopunto());
			put("Cruce Uniforme" , new CruceUniforme());
			put("Cruce Aritm�tico", new CruceAritmetico());
			put("BLX-Alpha", new CruceBLXA());
			put("PMX", new CrucePMX()); // A�adida esta linea post entrega
			put("OX", new CruceOX());
			put("Posiciones Prioritarias", new CrucePosPrio());
			put("Orden Prioritario", new CruceOrdenPrioritario());
			put("Ciclos", new CruceCX()); // Este tenia el cruce por orden en vez del de ciclos
			put("Recombinaci�n rutas", new CruceRecombinacionRutas());
			put("Codificaci�n ordinal", new CruceCodificacionOrdinal());
			put("ATX", new CruceATX());
		}};
		
		mapaMutacion = new HashMap<String, Mutacion>(){{
			put("B�sica", new MutacionBasica());
			put("Heuristica", new MutacionHeuristica());
			put("Inserci�n", new MutacionInsercion());
			put("Inversi�n", new MutacionInversion());
			put("Intercambio", new MutacionIntercambio());
			put("TAM",new MutacionTAM());
		}};
		
		listaSeleccion = new ArrayList<String>() {{
			add("Ruleta");
			add("Torneo Determin�stico");
			add("Torneo Probabil�sitco");
			add("Estoc�stico Universal");
			add("Truncamiento");
			add("Restos");
			add("Ranking");
		}};
		
		
		listaCruceDouble = new ArrayList<String>() {{
			add("Cruce Monopunto");
			add("Cruce Uniforme");
			add("Cruce Aritm�tico");
			add("BLX-Alpha");
		}};
		
		listaCruceBool = new ArrayList<String>() {{
			add("Cruce Monopunto");
			add("Cruce Uniforme");
		}};
	
		listaMutacionBasica = new ArrayList<String>(){{
			add("B�sica");
		}};
		
		listaCruceTSP = new ArrayList<String>() {{
			add("PMX"); // A�adida esta linea post entrega
			add("OX");
			add("Posiciones Prioritarias");
			add("Orden Prioritario");
			add("Ciclos");
			add("Recombinaci�n rutas");
			add("Codificaci�n ordinal");
			add("ATX");
		}};		
		
		listaMutacionTSP = new ArrayList<String>(){{
			add("Inserci�n");
			add("Inversi�n");
			add("Intercambio");
			add("Heuristica");
			add("TAM");
		}};		 
		
		mapaFactories = new TreeMap<String, Trio<IndividuoFactory, Boolean, Trio<ArrayList<String>,ArrayList<String>,ArrayList<String>>>>(){{
		 	put("Funci�n 1: Calibraci�n y prueba", new Trio<IndividuoFactory, Boolean, Trio<ArrayList<String>, ArrayList<String>, ArrayList<String>>>(new Individuo1Factory(), false, new Trio<ArrayList<String>,ArrayList<String>,ArrayList<String>>(listaSeleccion,listaCruceBool,listaMutacionBasica)));
		 	put("Funci�n 2: GrieWank", new Trio<IndividuoFactory, Boolean, Trio<ArrayList<String>, ArrayList<String>, ArrayList<String>>>(new Individuo2Factory(), false, new Trio<ArrayList<String>,ArrayList<String>,ArrayList<String>>(listaSeleccion,listaCruceBool,listaMutacionBasica)));
		 	put("Funci�n 3: Styblinski-tang", new Trio<IndividuoFactory, Boolean, Trio<ArrayList<String>, ArrayList<String>, ArrayList<String>>>(new Individuo3Factory(), false, new Trio<ArrayList<String>,ArrayList<String>,ArrayList<String>>(listaSeleccion,listaCruceBool,listaMutacionBasica)));
		 	put("Funci�n 4A: Michalewicz", new Trio<IndividuoFactory, Boolean, Trio<ArrayList<String>, ArrayList<String>, ArrayList<String>>>(new Individuo4AFactory(), true, new Trio<ArrayList<String>,ArrayList<String>,ArrayList<String>>(listaSeleccion,listaCruceBool,listaMutacionBasica)));
		 	put("Funci�n 4B: Michalewicz", new Trio<IndividuoFactory, Boolean, Trio<ArrayList<String>, ArrayList<String>, ArrayList<String>>>(new Individuo4BFactory(), true, new Trio<ArrayList<String>,ArrayList<String>,ArrayList<String>>(listaSeleccion,listaCruceDouble,listaMutacionBasica)));
		 	put("Funci�n 5: TSP", new Trio<IndividuoFactory, Boolean, Trio<ArrayList<String>, ArrayList<String>, ArrayList<String>>>(new IndividuoTSPFactory(), false, new Trio<ArrayList<String>,ArrayList<String>,ArrayList<String>>(listaSeleccion,listaCruceTSP,listaMutacionTSP)));
		}};
			
	}

}
