package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class HotInfoPanel {

	public LandingPanel land;
	private JLabel teams;
	private JLabel players;

	public HotInfoPanel() {
	}

	public void init() {
		land = new LandingPanel(AllImages.IMG_BG2);
		land.setOpaque(false);
		land.setBounds(0, 0, Controller.f.getWidth(), Controller.f.getHeight());
		land.setLayout(null);
		
		Container c = Controller.f.getContentPane();// 创建一个容器
		c.setLayout(new BorderLayout());// 布局格式
		JTabbedPane tp1 = new JTabbedPane(JTabbedPane.LEFT);// 建立选项卡组件
		String str[] = { "基本数据", "数学", "语文", "英语" };
		for (int i = 0; i < 4; i++) {
			JPanel jp = new JPanel();
			jp.setOpaque(false);
			jp.setLayout(new FlowLayout(FlowLayout.LEFT));
			JLabel lb = new JLabel("菜单面板" + String.valueOf(i + 1));// 菜单面板显示内容
			lb.setFont(new Font("宋体", Font.BOLD, 20));// 设置字体大小格式
			jp.add(lb);
			tp1.addTab(str[i], jp);
			tp1.setOpaque(false);
		}

		//Controller.f.add(land);
		c.add(tp1);
	} 
}
