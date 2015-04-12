package ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;

public class StatisticPanel {
	/**
	 * @param 展示热点信息的界面
	 * @author forIris
	 * @version  June 12, 2015 11:41:31 AM
	 * **/
	private JPanel statisticPanel;
	
	public JPanel init(){
		statisticPanel = new JPanel();
		statisticPanel.setOpaque(false);
		statisticPanel.setBounds(0, 0, 1000-130, 700);
		statisticPanel.setLayout(null);
		
		JButton test = new JButton();
		test.setBounds(0, 200, 120, 40);
		test.setOpaque(false);
		test.setContentAreaFilled(false);
		test.setText("test");
		test.setFont(new Font("Arial", Font.PLAIN, 20));
		test.setForeground(Color.WHITE);
		//Hello.setIcon(hello);
		statisticPanel.add(test, 0);
		
		return statisticPanel;
	}
}
