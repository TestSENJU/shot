package ui;

import java.awt.Dimension;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;

public class IComboBox extends JComboBox<Object> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IComboBox() {
		super();
		init();
	}

	public IComboBox(ComboBoxModel<Object> model) {
		super(model);
		init();
	}

	public IComboBox(Object[] items) {
		super(items);
		init();
	}

	public IComboBox(Vector<Object> items) {
		super(items);
		init();
	}

	private void init() {
		setOpaque(false);
		//setUI(new CxyComboBoxUI(this));
		setUI(new IComboBoxUI());
		setRenderer(new IComboBoxRenderer());
		//setBackground(Color.CYAN);//TODO XUtil.defaultComboBoxColor
	}

	public Dimension getPreferredSize() {
		return super.getPreferredSize();
	}
}