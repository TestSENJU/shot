package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import sound.PlaySE;

public class Controller {

	public static MyFrame f = new MyFrame(900,618);
	public static LandingPanel land;
	
	static ImageIcon first = new ImageIcon("img/tablebg.jpg");
	
	public void layout() {
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle("NBA Data Analysis System");
		Image frameicon = f.getToolkit().createImage("img/frameIcon.jpg");
		f.setIconImage(frameicon);
		
		//beginning
		land = new LandingPanel("img/tablebg.jpg");
		land.setOpaque(false);
		land.setBounds(0, 0, f.getWidth(), f.getHeight());
		land.setLayout(null);
		
		//销售人员只能使用进货管理、销售管理、和客户管理功能
		JButton Hello = new JButton();
		Hello.setBounds(320, 250, 260, 40);
		Hello.setBorderPainted(true);
		Hello.setContentAreaFilled(false);
		Hello.setText("Hello, NBA fans");
		Hello.setFont(new Font("微软雅黑", Font.PLAIN, 23));
		Hello.setForeground(Color.WHITE);
		//Hello.setIcon(hello);
		Hello.addMouseListener(new HelloListener());
		land.add(Hello, 0);
		
		f.getContentPane().setLayout(null);
		f.getContentPane().add(land);
		f.setVisible(true);
		land.setVisible(true);
	}
	
	class HelloListener implements MouseListener {
		public void mouseClicked(MouseEvent e) {
			SvgPanel sp = new SvgPanel();
			sp.showSvg();
		}
		public void mouseEntered(MouseEvent e) {
			PlaySE se = new PlaySE("music/enter.wav");
			new Thread(se).start();
		}
		public void mouseExited(MouseEvent e) {	
		}
		public void mousePressed(MouseEvent e) {}

		public void mouseReleased(MouseEvent e) {}
	}
}
