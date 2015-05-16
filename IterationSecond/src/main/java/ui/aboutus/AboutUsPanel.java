package ui.aboutus;

import javax.swing.JButton;
import javax.swing.JPanel;

import ui.AllImages;

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
		hotPanel.setBounds(130, 0, 1000-130, 700);
		hotPanel.setLayout(null);
		
		JButton test = new JButton();
		test.setBounds(0, 50, 1000-130, 650);
		test.setOpaque(false);
		test.setContentAreaFilled(false);
		test.setBorderPainted(false);
		test.setIcon(AllImages.IMG_ABOUTUSICON);
		hotPanel.add(test, 0);
		
		return hotPanel;
	}
}
