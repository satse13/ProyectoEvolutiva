package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import controller.Controller;

public class TopPanel extends JPanel {
	
	private Controller _ctrl;
	
	JCheckBox variedad;
	
	JLabel problemaLabel;
	
	JComboBox problemaBox;
	
	public TopPanel(Controller ctrl) {
		_ctrl = ctrl;
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
		
		Integer[] ejemplo = new Integer[] {1,2,3,4,5};
		problemaBox = new JComboBox<Integer>(ejemplo);
		
		add(variedad);
		add(separator1);
		add(problemaLabel);
		add(separator2);
		add(problemaBox);
		
		setBackground(Color.WHITE);
		setVisible(true);
		setPreferredSize(new Dimension(1500, 40));
	}

}
