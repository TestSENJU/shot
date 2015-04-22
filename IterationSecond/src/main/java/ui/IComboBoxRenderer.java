package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class IComboBoxRenderer implements ListCellRenderer<Object> {

	private DefaultListCellRenderer defaultCellRenderer = new DefaultListCellRenderer();

	public IComboBoxRenderer() {
		super();
	}

	public Component getListCellRendererComponent(@SuppressWarnings("rawtypes") JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {

		JLabel renderer = (JLabel) defaultCellRenderer
				.getListCellRendererComponent(list, value, index, isSelected,
						cellHasFocus);
		if (isSelected) {
			renderer.setBackground(Color.GRAY);//XUtil.defaultComboBoxBoundsColor
			renderer.setForeground(Color.WHITE);
		} else {
			renderer.setForeground(Color.WHITE);
			renderer.setBackground(Color.DARK_GRAY);
		}
		list.setSelectionBackground(Color.WHITE);//XUtil.defaultComboBoxColor
		list.setBorder(null);
		renderer.setFont(new Font("微软雅黑", Font.PLAIN, 12));//XUtil.defaultComboBoxFont
		renderer.setHorizontalAlignment(JLabel.LEFT);
		return renderer;
	}
}