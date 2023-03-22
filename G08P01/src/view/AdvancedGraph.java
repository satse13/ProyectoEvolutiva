package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import org.math.plot.Plot2DPanel;

import controller.Controller;
import model.AlgoritmoGenetico;
import model.observers.Observer;
import utils.Pair;

public class AdvancedGraph extends JPanel implements Observer {
	
	Controller ctrl;
	
	Plot2DPanel plot;
	
	String key;
	
	int maxGeneraciones;
	
	public AdvancedGraph(Controller _ctrl) {
		ctrl = _ctrl;
		ctrl.addObserver(this);
		key = "Ninguno";
		initGUI();
	}

	private void initGUI() {
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		Border _defaultBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
		setBorder(BorderFactory.createTitledBorder(_defaultBorder, "Gráfica", TitledBorder.LEFT,TitledBorder.TOP));
		
		plot = new Plot2DPanel();
		
		plot.setAxisLabels(key, "Valor del fitness");

		plot.addLegend("SOUTH");
		
		add(plot, BorderLayout.CENTER);
	}

	@Override
	public void onEnd(AlgoritmoGenetico algoritmo, String key) {
		plot.removeAllPlots();
		Pair<double[], double[]> individuos = algoritmo.getMejoresIntervalos();
		plot.addLinePlot("Mejores Individuos", individuos.getFirst(), individuos.getSecond());
		
	}
	

	@Override
	public void onReset() {
		plot.removeAllPlots();		
	}

	@Override
	public void onError(String exception) {
		// TODO Auto-generated method stub
		
	}
}
