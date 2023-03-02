package launcher;

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
import model.seleccion.Seleccion;
import model.seleccion.SeleccionRuleta;
import utils.TipoDato;
import utils.Trio;
import view.MainWindow;

public class Main {

	private static Map<String, Trio<IndividuoFactory, Boolean, TipoDato>> mapaFactories = null;

	private static Map<String, Seleccion> mapaSeleccion = null;
	
	private static Map<String, Cruce> mapaCruceDouble = null;
	
	private static Map<String, Cruce> mapaCruceBool = null;
	
		
	public static void main(String[] args) {
		
		initMaps();
		AlgoritmoGenetico algoritmo = new AlgoritmoGenetico();
		Controller ctrl = new Controller(algoritmo,mapaFactories,mapaSeleccion, mapaCruceBool,mapaCruceDouble);
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MainWindow(ctrl);
			}
		});	
	}
	
	private static void initMaps() {
		
		 mapaFactories = new TreeMap<String, Trio<IndividuoFactory, Boolean, TipoDato>>(){{
				put("Función 1: Calibración y prueba",new Trio<IndividuoFactory, Boolean, TipoDato>(new Individuo1Factory(),false,TipoDato.BOOLEAN));
				put("Función 2: GrieWank",new Trio<IndividuoFactory, Boolean, TipoDato>(new Individuo1Factory(),false,TipoDato.DOUBLE)); // Esto se cambi

		}};
			
		mapaSeleccion = new HashMap<String, Seleccion>(){{
				put("Ruleta", new SeleccionRuleta());
		}};
		
		mapaCruceDouble = new HashMap<String, Cruce>(){{
				put("Cruce Monopunto", new CruceMonopunto());
		}};
		
		mapaCruceBool = new HashMap<String, Cruce>(){{
				put("Cruce Monopunto", new CruceMonopunto());
				put("Cruce dos", new CruceMonopunto());
		}};
	}

}
