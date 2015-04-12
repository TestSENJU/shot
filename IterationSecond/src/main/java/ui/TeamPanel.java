package ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;

public class TeamPanel {
	/**
	 * @param 展示所有球队信息的界面
	 *           ->只展示所有球队的队徽和名称点击可以进入详细信息界面
	 * @author forIris
	 * @version  June 12, 2015 11:41:31 AM
	 * **/
	private JPanel teamPanel;

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
