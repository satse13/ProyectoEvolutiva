package launcher;

import java.util.HashMap;
import java.util.Map;

import javax.swing.SwingUtilities;

import controller.Controller;
import factories.Individuo1Factory;
import factories.IndividuoFactory;
import model.AlgoritmoGenetico;
import model.cruce.Cruce;
import model.cruce.CruceMonopunto;
import model.seleccion.Seleccion;
import model.seleccion.SeleccionRuleta;
import view.MainWindow;

public class Main {

	private static Map<String, IndividuoFactory> mapaFactories = null;

	private static Map<String, Seleccion> mapaSeleccion = null;
	
	private static Map<String, Cruce> mapaCruce = null;
	
		
	public static void main(String[] args) {
		
		initMaps();
		AlgoritmoGenetico algoritmo = new AlgoritmoGenetico();
		Controller ctrl = new Controller(algoritmo,mapaFactories,mapaSeleccion, mapaCruce);
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MainWindow(ctrl);
			}
		});	
	}
	
	private static void initMaps() {
		
		 mapaFactories = new HashMap<String, IndividuoFactory>(){{
				put("Funci�n 1: calibraci�n y prueba", new Individuo1Factory());
		}};
			
		mapaSeleccion = new HashMap<String, Seleccion>(){{
				put("Ruleta", new SeleccionRuleta());
		}};
		
		mapaCruce = new HashMap<String, Cruce>(){{
			put("Cruce Monopunto", new CruceMonopunto());
	}};
	}

}
