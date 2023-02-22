package view;
import java.awt.Color;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import org.math.plot.*;

import controller.Controller;

public class Graph extends Plot2DPanel {
	
	public Graph(Controller _ctrl) {
		initGUI();
	}

	private void initGUI() {
		Border _defaultBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
		setBorder(BorderFactory.createTitledBorder(_defaultBorder, "Gráfica", TitledBorder.LEFT,TitledBorder.TOP));
		removePlotToolBar();
		
		double[] x = { 1, 2, 3, 4, 5, 6 };
		double[] y = { 45, 89, 6, 32, 63, 12 };

		
		// define the legend position
		addLegend("SOUTH");
		
		// add a line plot to the PlotPanel
		addLinePlot("my plot", x, y);
		
		
		Plot2DPanel plot = new Plot2DPanel();
	}
}



