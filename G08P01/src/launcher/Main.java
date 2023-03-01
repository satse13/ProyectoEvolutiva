package launcher;

import java.util.HashMap;
import java.util.Map;

import javax.swing.SwingUtilities;

import controller.Controller;
import factories.Individuo1Factory;
import factories.IndividuoFactory;
import model.AlgoritmoGenetico;
import model.seleccion.Seleccion;
import model.seleccion.SeleccionRuleta;
import view.MainWindow;

public class Main {

	private static Map<String, IndividuoFactory> mapaFactories = null;

	private static Map<String, Seleccion> mapaSeleccion = null;
	
		
	public static void main(String[] args) {
		
		initMaps();
		AlgoritmoGenetico algoritmo = new AlgoritmoGenetico(0, 0, 0, 0, null, null, null, 0, 0);
		Controller ctrl = new Controller(algoritmo,mapaFactories,mapaSeleccion);
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MainWindow(ctrl);
			}
		});	
	}
	
	private static void initMaps() {
		
		 mapaFactories = new HashMap<String, IndividuoFactory>(){{
				put("Función 1: calibración y prueba", new Individuo1Factory());
		}};
			
		mapaSeleccion = new HashMap<String, Seleccion>(){{
				put("Ruleta", new SeleccionRuleta());
		}};
	}

}
