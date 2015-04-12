package ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;

import ui.InitailizePanel.CloseListener;
import ui.InitailizePanel.MinListener;

public class PlayerPanel {
	private JPanel playerPanel;

	private JButton close;
	private JButton min;
	private JButton test;
	
	public JPanel init(){
		playerPanel = new JPanel();
		playerPanel.setOpaque(false);
		playerPanel.setBounds(0, 0, 1000-130, 700);
		playerPanel.setLayout(null);
		
		JButton test = new JButton();
		test.setBounds(0, 200, 120, 40);
		test.setOpaque(false);
		test.setContentAreaFilled(false);
		test.setText("test");
		test.setFont(new Font("Arial", Font.PLAIN, 20));
		test.setForeground(Color.WHITE);
		//Hello.setIcon(hello);
		playerPanel.add(test, 0);
		
		return playerPanel;
	}
}
