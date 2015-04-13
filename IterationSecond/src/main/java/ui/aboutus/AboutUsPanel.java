package ui.aboutus;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;

public class AboutUsPanel {
	/**
	 * @param 展示组员信息的界面
	 *         -> 组员头像 + 属性2333
	 * @author forIris
	 * @version  June 12, 2015 11:41:31 AM
	 * **/
	private JPanel hotPanel;
	public JPanel init(){
		hotPanel = new JPanel();
		hotPanel.setOpaque(false);
		hotPanel.setBounds(0, 0, 1000-130, 700);
		hotPanel.setLayout(null);
		
		JButton test = new JButton();
		test.setBounds(0, 200, 120, 40);
		test.setOpaque(false);
		test.setContentAreaFilled(false);
		test.setText("test");
		test.setFont(new Font("Arial", Font.PLAIN, 20));
		test.setForeground(Color.WHITE);
		//Hello.setIcon(hello);
		hotPanel.add(test, 0);
		
		return hotPanel;
	}
}
