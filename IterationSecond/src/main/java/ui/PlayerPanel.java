package ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PlayerPanel {
	/**
	 * @param 展示所有球员基本信息的表格界面
	 *         ->点击表格球员头像可以进入球员具体信息界面
	 * @author forIris
	 * @version  June 12, 2015 11:41:31 AM
	 * **/
	private JPanel playerPanel;

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
