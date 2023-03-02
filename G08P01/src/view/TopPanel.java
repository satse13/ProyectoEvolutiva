package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import controller.Controller;
import factories.IndividuoFactory;
import model.AlgoritmoGenetico;
import model.cruce.Cruce;
import model.observers.Observer;
import model.seleccion.Seleccion;

public class TopPanel extends JPanel implements Observer {
	
	private Controller _ctrl;
	
	JCheckBox variedad;
	
	JLabel problemaLabel;
	
	JComboBox problemaBox;
	
	public TopPanel(Controller ctrl) {
		_ctrl = ctrl;
		_ctrl.addObserver(this);
		initGUI();
	}

	private void initGUI() {
		
		variedad = new JCheckBox("Introducir variedad");
		variedad.setBackground(Color.WHITE);
		
		JSeparator separator1 = new JSeparator(JSeparator.VERTICAL);
		separator1.setPreferredSize(new Dimension(20, 0));
		
		problemaLabel = new JLabel("Problema:");
		
		JSeparator separator2 = new JSeparator(JSeparator.VERTICAL);
		separator2.setPreferredSize(new Dimension(5, 0));
		
		String[] ejemplo = new String[] {"Función 1: calibración y prueba", "2"};
		problemaBox = new JComboBox<String>(ejemplo);
		
		problemaBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_ctrl.updateIndividuoFactory((String) problemaBox.getSelectedItem());
			}
		});
		
		add(variedad);
		add(separator1);
		add(problemaLabel);
		add(separator2);
		add(problemaBox);
		
		setBackground(Color.WHITE);
		setVisible(true);
		setPreferredSize(new Dimension(1500, 40));
	}

	@Override
	public void onEnd(AlgoritmoGenetico algoritmo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onReset() {
        problemaBox.setSelectedIndex(0);

    }
}
