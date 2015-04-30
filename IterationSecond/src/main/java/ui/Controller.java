package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import launch.Change;
import sound.PlayWave;
import ui.hot.HotInfoPanel;
import ui.match.MatchHomePanel;

public class Controller {
	/** 
	 * @param 初始化frame - 系统首界面 - 无法返回这一界面
	 * @author forIris
	 * @version  June 12, 2015 11:41:31 AM
	 * **/
	public static MyFrame f = new MyFrame(1000,700);
	public static JLayeredPane bg;
	public static LandingPanel land;
	private JButton close;
	private JButton min;
		
	public void layout() {
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle("NBA Data Analysis System");
		f.setUndecorated(true);
		//Image frameicon = f.getToolkit().createImage("img/frameIcon.jpg");
		f.setIconImage(AllImages.IMG_FRAMEICON);
		
		//beginning
		land = new LandingPanel(AllImages.IMG_BG);
		land.setOpaque(false);
		land.setBounds(0, 0, f.getWidth(), f.getHeight());
		land.setLayout(null);
		
		bg = new JLayeredPane();
		bg.setBounds(0, 0, Controller.f.getWidth(), Controller.f.getHeight());
		bg.add(land, new Integer(0));
		
		JLabel Hello = new JLabel();
		Hello.setBounds(380, 250, 260, 40);
		Hello.setText("Hello, NBA fans");
		Hello.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		Hello.setForeground(Color.WHITE);
		//Hello.setIcon(hello);
		Hello.addMouseListener(new Hello());
		land.add(Hello, 0);
		
		JButton welcome = new JButton();
		welcome.setBounds(425, 450, 150, 40);
		welcome.setBorderPainted(false);
		welcome.setIcon(AllImages.IMG_WELCOME);
		welcome.setOpaque(false);
		welcome.addMouseListener(new WelcomeListener());
		land.add(welcome, 0);
		
		close = new JButton();
		close.setBounds(950, 20, 30, 30);
		close.setBorderPainted(false);
		close.setContentAreaFilled(false);
		close.setIcon(AllImages.IMG_CLOSE);
		close.setOpaque(false);
		close.addMouseListener(new CloseListener());
		land.add(close, 0);
		
		min = new JButton();
		min.setBounds(910, 20, 30, 30);
		min.setBorderPainted(false);
		min.setContentAreaFilled(false);
		min.setIcon(AllImages.IMG_MIN);
		min.setOpaque(false);
		min.addMouseListener(new MinListener());
		land.add(min, 0);
		
		f.getContentPane().setLayout(null);
		f.getContentPane().add(bg);
		f.setVisible(true);
		//land.setVisible(true);
	}
	
	class WelcomeListener implements MouseListener {
		public void mouseClicked(MouseEvent e) {
			PlayWave.startClickSound();
			land.setVisible(false);
			InitailizePanel hip = new InitailizePanel();
			hip.init();
			HotInfoPanel hp = new HotInfoPanel();
			JPanel h = hp.init();
			InitailizePanel.bg.add(h, new Integer(1));
			hp.hotPlayerTodayPanel();
			HotInfoPanel.hotPanel.repaint();
			/*Monitor.startMonitor();
			Change.startChange();*/
		}
		public void mouseEntered(MouseEvent e) {
			PlayWave.startMoveButtonSound();
		}
		public void mouseExited(MouseEvent e) {	
		}
		public void mousePressed(MouseEvent e) {}

		public void mouseReleased(MouseEvent e) {}
	}
	class CloseListener implements MouseListener {
		public void mouseClicked(MouseEvent e) {
			PlayWave.startClickSound();
			close.setIcon(AllImages.IMG_CLOSE_RED);
			System.exit(0);
		}
		public void mouseEntered(MouseEvent e) {
			//PlayWave.startMoveButtonSound();
			close.setIcon(AllImages.IMG_CLOSE_RED);
		}
		public void mouseExited(MouseEvent e) {	
			close.setIcon(AllImages.IMG_CLOSE);
		}
		public void mousePressed(MouseEvent e) {}

		public void mouseReleased(MouseEvent e) {}
	}
	class MinListener implements MouseListener {
		public void mouseClicked(MouseEvent e) {
			PlayWave.startClickSound();
			min.setIcon(AllImages.IMG_MIN_RED);
			f.setExtendedState(JFrame.ICONIFIED);
		}
		public void mouseEntered(MouseEvent e) {
			//PlayWave.startMoveButtonSound();
			min.setIcon(AllImages.IMG_MIN_RED);
		}
		public void mouseExited(MouseEvent e) {	
			min.setIcon(AllImages.IMG_MIN);
		}
		public void mousePressed(MouseEvent e) {}

		public void mouseReleased(MouseEvent e) {}
	}
	class Hello implements MouseListener {

		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			land.setVisible(false);
			MatchHomePanel mhp = new MatchHomePanel();
			f.getContentPane().add(mhp.init("ATL"));
			f.repaint();
		}
		public void mouseEntered(MouseEvent arg0) {
		}
		public void mouseExited(MouseEvent arg0) {
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}		
	}
}
