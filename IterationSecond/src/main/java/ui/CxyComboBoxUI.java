package ui;

import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicComboBoxUI;

public class CxyComboBoxUI extends BasicComboBoxUI {
	JComboBox<?> jcbox;
	public CxyComboBoxUI (JComboBox<?> jcbox) {
		this.jcbox = jcbox;
	}
	
	public void installUI(JComponent comboBox){
		super.installUI(jcbox);
		listBox.setForeground(new Color(1, 1, 1, 0.8f));
		listBox.setBackground(new Color(0, 0, 0, 0.3f));
	}
}
