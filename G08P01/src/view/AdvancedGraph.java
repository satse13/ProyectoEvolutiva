package view;

import javax.swing.JPanel;

import controller.Controller;
import model.AlgoritmoGenetico;
import model.observers.Observer;

public class AdvancedGraph extends JPanel implements Observer {
	
	Controller ctrl;
	
	public AdvancedGraph(Controller _ctrl) {
		ctrl = _ctrl;
		ctrl.addObserver(this);
		initGUI();
	}

	private void initGUI() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onEnd(AlgoritmoGenetico algoritmo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onReset() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onError(String exception) {
		// TODO Auto-generated method stub
		
	}
}
