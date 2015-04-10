package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import sound.PlaySE;

public class Controller {

	public static MyFrame f = new MyFrame(1000,700);
	public static LandingPanel land;
		
	public void layout() {
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle("NBA Data Analysis System");
		//Image frameicon = f.getToolkit().createImage("img/frameIcon.jpg");
		f.setIconImage(AllImages.IMG_FRAMEICON);
		
		//beginning
		land = new LandingPanel(AllImages.IMG_BG);
		land.setOpaque(false);
		land.setBounds(0, 0, f.getWidth(), f.getHeight());
		land.setLayout(null);
		
		JLabel Hello = new JLabel();
		Hello.setBounds(380, 250, 260, 40);
		Hello.setText("Hello, NBA fans");
		Hello.setFont(new Font("微软雅黑", Font.PLAIN, 30));
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
			PlaySE se = new PlaySE("music/click.wav");
			new Thread(se).start();
			land.setVisible(false);
			HotInfoPanel hip = new HotInfoPanel();
			hip.init();
		}
		public void mouseEntered(MouseEvent e) {
			PlaySE se = new PlaySE("music/click3.wav");
			new Thread(se).start();
		}
		public void mouseExited(MouseEvent e) {	
		}
		public void mousePressed(MouseEvent e) {}

		public void mouseReleased(MouseEvent e) {}
	}
}
