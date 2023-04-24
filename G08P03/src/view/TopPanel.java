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
import javax.swing.JSpinner;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controller.Controller;
import factories.IndividuoFactory;
import model.AlgoritmoGenetico;
import model.cruce.Cruce;
import model.observers.Observer;
import model.seleccion.Seleccion;

public class TopPanel extends JPanel implements Observer {
	
	private Controller _ctrl;
	
	JLabel problemaLabel;
	
	JComboBox problemaBox, parametrosBox;
	
	LeftPanel lp;
	
	BottomPanel bp;
	
	public TopPanel(Controller ctrl, LeftPanel lp, BottomPanel bp) {
		_ctrl = ctrl;
		this.lp = lp;
		this.bp = bp;
		_ctrl.addObserver(this);
		initGUI();
	}

	private void initGUI() {
		
		
		parametrosBox = new JComboBox<String>(lp.getOpciones());
		
		parametrosBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lp.changePanel((String)parametrosBox.getSelectedItem());
				bp.changePanel((String)parametrosBox.getSelectedItem());
			}	
		});
	
		JSeparator separator1 = new JSeparator(JSeparator.VERTICAL);
		separator1.setPreferredSize(new Dimension(20, 0));
		
		problemaLabel = new JLabel("Problema:");
		
		JSeparator separator2 = new JSeparator(JSeparator.VERTICAL);
		separator2.setPreferredSize(new Dimension(5, 0));
		
		problemaBox = new JComboBox<String>(_ctrl.getFuncionKey());
		
		problemaBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_ctrl.updateIndividuoFactory((String) problemaBox.getSelectedItem());		
				lp.setIndividuo((String) problemaBox.getSelectedItem());
				lp.refreshCruceBox();
				lp.refreshMutacionBox();
			}	
		});
		
		JSeparator separator3 = new JSeparator(JSeparator.VERTICAL);
		separator3.setPreferredSize(new Dimension(5, 0)); 
		
		add(new JLabel("Análisis de parametros: "));
		add(parametrosBox);
 		add(separator1);
		add(problemaLabel);
		add(separator2);
		add(problemaBox);
		add(separator3);
		setBackground(Color.WHITE);
		setVisible(true);
		
		
		setPreferredSize(new Dimension(1500, 40));
	}

	@Override
	public void onEnd(AlgoritmoGenetico algoritmo, String key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onReset() {
        problemaBox.setSelectedIndex(0);
        parametrosBox.setSelectedIndex(0);
    }

	@Override
	public void onError(String exception) {
		// TODO Auto-generated method stub
		
	}
}
