package launcher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.SwingUtilities;

import controller.Controller;
import factories.Individuo1Factory;
import factories.IndividuoFactory;
import model.AlgoritmoGenetico;
import model.cruce.Cruce;
import model.cruce.CruceMonopunto;
import model.cruce.CruceUniforme;
import model.seleccion.EstocasticoUniversal;
import model.seleccion.Seleccion;
import model.seleccion.SeleccionRuleta;
import model.seleccion.TorneoDeterministico;
import model.seleccion.TorneoProbabilistico;
import model.seleccion.Truncamiento;
import utils.TipoDato;
import utils.Trio;
import view.MainWindow;

public class Main {

	private static Map<String, Trio<IndividuoFactory, Boolean, TipoDato>> mapaFactories = null;

	private static Map<String, Seleccion> mapaSeleccion = null;
	
	private static ArrayList<String> listaSeleccion = null;
	
	private static Map<String, Cruce> mapaCruceDouble = null;
	
	private static ArrayList<String> listaCruceDouble = null;
	
	private static Map<String, Cruce> mapaCruceBool = null;
	
	private static ArrayList<String> listaCruceBool = null;


	public static void main(String[] args) {
		
		initMaps();
		AlgoritmoGenetico algoritmo = new AlgoritmoGenetico();
		Controller ctrl = new Controller(algoritmo,mapaFactories,mapaSeleccion, mapaCruceBool,mapaCruceDouble, listaCruceBool,listaCruceDouble,listaSeleccion);
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MainWindow(ctrl);
			}
		});	
	}
	
	private static void initMaps() {
		
		 mapaFactories = new TreeMap<String, Trio<IndividuoFactory, Boolean, TipoDato>>(){{
				put("Funci�n 1: Calibraci�n y prueba",new Trio<IndividuoFactory, Boolean, TipoDato>(new Individuo1Factory(),false,TipoDato.BOOLEAN));
				put("Funci�n 2: GrieWank",new Trio<IndividuoFactory, Boolean, TipoDato>(new Individuo1Factory(),false,TipoDato.BOOLEAN)); // Esto se cambi

		}};
			
		mapaSeleccion = new HashMap<String, Seleccion>(){{
				put("Ruleta", new SeleccionRuleta());
				put("Torneo Determin�stico", new TorneoDeterministico());
				put("Torneo Probabil�sitco", new TorneoProbabilistico());
				put("Estoc�stico Universal", new EstocasticoUniversal());
				put("Truncamiento", new Truncamiento());
		}};
		
		
		listaSeleccion = new ArrayList<String>() {{
				add("Ruleta");
				add("Torneo Determin�stico");
				add("Torneo Probabil�sitco");
				add("Estoc�stico Universal");
				add("Truncamiento");
		}};
		
		mapaCruceDouble = new HashMap<String, Cruce>(){{
				put("Cruce Monopunto", new CruceMonopunto());
				put("Cruce Uniforme" , new CruceUniforme());
		}};
		
		listaCruceDouble = new ArrayList<String>() {{
				add("Cruce Monopunto");
				add("Cruce Uniforme");
		}};
		
		mapaCruceBool = new HashMap<String, Cruce>(){{
				put("Cruce Monopunto", new CruceMonopunto());
				put("Cruce Uniforme" , new CruceUniforme());
		}};
		
		listaCruceBool = new ArrayList<String>() {{
			add("Cruce Monopunto");
			add("Cruce Uniforme");
	}};
	}

}
