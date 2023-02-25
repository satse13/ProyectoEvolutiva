package launcher;

 
import factories.Individuo1Factory;
import model.AlgoritmoGenetico;
 import model.cruce.CruceMonopunto;
import model.seleccion.SeleccionRuleta;
 
public class Main {

	public static void main(String[] args) {
		//MainWindow mw = new MainWindow(null);
	 
		AlgoritmoGenetico algo = new AlgoritmoGenetico(10,1,0.7,0.7,0.1,new Individuo1Factory(), new SeleccionRuleta(), new CruceMonopunto(),3);

		algo.run();
	
	}
}
