package launcher;

 
import factories.Individuo1Factory;
import model.AlgoritmoGenetico;
 import model.cruce.CruceMonopunto;
import model.individuos.Individuo1;
import model.seleccion.SeleccionRuleta;
 
public class Main {

	public static void main(String[] args) {
	 
		AlgoritmoGenetico algo = new AlgoritmoGenetico(1000,1000,0.7,0.6,0.05,new Individuo1Factory(), new SeleccionRuleta(), new CruceMonopunto(),3,0.1);

		algo.run();
	
	
	}
	
	
	
}
