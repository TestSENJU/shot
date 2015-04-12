package ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;

public class TeamPanel {
	private JPanel teamPanel;

	private JButton close;
	private JButton min;
	private JButton test;
	
	public JPanel init(){
		teamPanel = new JPanel();
		teamPanel.setOpaque(false);
		teamPanel.setBounds(0, 0, 1000-130, 700);
		teamPanel.setLayout(null);
		
		JButton test = new JButton();
		test.setBounds(0, 100, 120, 40);
		test.setOpaque(false);
		test.setContentAreaFilled(false);
		test.setText("test");
		test.setFont(new Font("Arial", Font.PLAIN, 20));
		test.setForeground(Color.WHITE);
		//Hello.setIcon(hello);
		teamPanel.add(test, 0);
		
		return teamPanel;
	}
}
