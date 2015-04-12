package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import sound.PlayWave;

public class InitailizePanel {

	private LandingPanel land;
	private JPanel infoPanel;
	private JButton logo;
	private JButton hot;
	private JButton team;
	private JButton player;
	private JButton statistic;
	private JButton search;
	private JButton aboutus;
	private JButton back;
	private JButton close;
	private JButton min;
	private int width = 80;
	private int height = 80;
	private int fontsize = 20;
	private int playerCounter = 0;
	private int teamCounter = 0;

	public InitailizePanel() {
	}

	public void init() {
		land = new LandingPanel(AllImages.IMG_BG2);
		land.setOpaque(false);
		land.setBounds(0, 0, Controller.f.getWidth(), Controller.f.getHeight());
		land.setLayout(null);
		
		logo = new JButton();
		logo.setBounds(10, 10, 120, 120);
		logo.setOpaque(false);
		logo.setContentAreaFilled(false);
		logo.setBorderPainted(false);
		logo.setIcon(AllImages.IMG_LOGO);
		land.add(logo, 0);
		
		hot = new JButton();
		hot.setBounds(30, 140, width, height);
		hot.setOpaque(false);
		hot.setContentAreaFilled(false);
		hot.setBorderPainted(false);
		hot.setIcon(AllImages.IMG_HOT);
		hot.addMouseListener(new HotInfoListener());
		land.add(hot, 0);
		
		player = new JButton();
		player.setBounds(30, 220, width, height);
		player.setOpaque(false);
		player.setContentAreaFilled(false);
		player.setBorderPainted(false);
		player.setIcon(AllImages.IMG_PLAYER);
		player.addMouseListener(new PlayerListener());
		land.add(player, 0);
		
		team = new JButton();
		team.setBounds(30, 300, width, height);
		team.setOpaque(false);
		team.setContentAreaFilled(false);
		team.setBorderPainted(false);
		team.setIcon(AllImages.IMG_TEAM);
		team.addMouseListener(new TeamListener());
		land.add(team, 0);
		
		statistic = new JButton();
		statistic.setBounds(30, 380, width, height);
		statistic.setOpaque(false);
		statistic.setContentAreaFilled(false);
		statistic.setBorderPainted(false);
		statistic.setIcon(AllImages.IMG_STATISTIC);
		statistic.addMouseListener(new StatisticListener());
		land.add(statistic, 0);
		
		search = new JButton();
		search.setBounds(30, 460, width, height);
		search.setOpaque(false);
		search.setContentAreaFilled(false);
		search.setBorderPainted(false);
		search.setIcon(AllImages.IMG_SEARCH);
		search.addMouseListener(new SearchListener());
		land.add(search, 0);
		
		aboutus = new JButton();
		aboutus.setBounds(30, 540, width, height);
		aboutus.setOpaque(false);
		aboutus.setContentAreaFilled(false);
		aboutus.setBorderPainted(false);
		aboutus.setIcon(AllImages.IMG_ABOUTUS);
		aboutus.addMouseListener(new AboutUsListener());
		land.add(aboutus, 0);
		
		//close and min put in the landPanel
		close = new JButton();
		close.setBounds(1000-50, 20, 30, 30);
		close.setBorderPainted(false);
		close.setContentAreaFilled(false);
		close.setIcon(AllImages.IMG_CLOSE);
		close.setOpaque(false);
		close.addMouseListener(new CloseListener());
		land.add(close, 0);
		
		min = new JButton();
		min.setBounds(1000-50-40, 20, 30, 30);
		min.setBorderPainted(false);
		min.setContentAreaFilled(false);
		min.setIcon(AllImages.IMG_MIN);
		min.setOpaque(false);
		min.addMouseListener(new MinListener());
		land.add(min, 0);
		
		infoPanel = new JPanel();
		infoPanel.setLayout(null);
		infoPanel.setBounds(130, 0, 1000-130, 700);
		infoPanel.setOpaque(false);
		
		land.add(infoPanel, 0);
		Controller.f.add(land);
	} 
	
	class HotInfoListener implements MouseListener {
		public void mouseClicked(MouseEvent e) {
			PlayWave.startClickSound();
			//TODO
		}
		public void mouseEntered(MouseEvent e) {
			PlayWave.startMoveButtonSound();
		}
		public void mouseExited(MouseEvent e) {	
		}
		public void mousePressed(MouseEvent e) {}

		public void mouseReleased(MouseEvent e) {}
	}
	
	class PlayerListener implements MouseListener {
		public void mouseClicked(MouseEvent e) {
			PlayWave.startClickSound();
			//TODO
			infoPanel.removeAll();
			PlayerPanel pp = new PlayerPanel();
			JPanel p = pp.init();
			infoPanel.add(p, 0);
			infoPanel.repaint();
		}
		public void mouseEntered(MouseEvent e) {
			PlayWave.startMoveButtonSound();
		}
		public void mouseExited(MouseEvent e) {	
		}
		public void mousePressed(MouseEvent e) {}

		public void mouseReleased(MouseEvent e) {}
	}
	
	class TeamListener implements MouseListener {
		public void mouseClicked(MouseEvent e) {
			PlayWave.startClickSound();
			//TODO
			infoPanel.removeAll();
			TeamPanel tp = new TeamPanel();
			JPanel t = tp.init();
			infoPanel.add(t, 0);
			infoPanel.repaint();
		}
		public void mouseEntered(MouseEvent e) {
			PlayWave.startMoveButtonSound();
		}
		public void mouseExited(MouseEvent e) {	
		}
		public void mousePressed(MouseEvent e) {}

		public void mouseReleased(MouseEvent e) {}
	}
	
	class StatisticListener implements MouseListener {
		public void mouseClicked(MouseEvent e) {
			PlayWave.startClickSound();
			//TODO
		}
		public void mouseEntered(MouseEvent e) {
			PlayWave.startMoveButtonSound();
		}
		public void mouseExited(MouseEvent e) {	
		}
		public void mousePressed(MouseEvent e) {}

		public void mouseReleased(MouseEvent e) {}
	}
	
	class SearchListener implements MouseListener {
		public void mouseClicked(MouseEvent e) {
			PlayWave.startClickSound();
			//TODO
		}
		public void mouseEntered(MouseEvent e) {
			PlayWave.startMoveButtonSound();
		}
		public void mouseExited(MouseEvent e) {	
		}
		public void mousePressed(MouseEvent e) {}

		public void mouseReleased(MouseEvent e) {}
	}
	
	class AboutUsListener implements MouseListener {
		public void mouseClicked(MouseEvent e) {
			PlayWave.startClickSound();
			//TODO
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
			PlayWave.startMoveButtonSound();
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
			Controller.f.setExtendedState(JFrame.ICONIFIED);
		}
		public void mouseEntered(MouseEvent e) {
			PlayWave.startMoveButtonSound();
			min.setIcon(AllImages.IMG_MIN_RED);
		}
		public void mouseExited(MouseEvent e) {	
			min.setIcon(AllImages.IMG_MIN);
		}
		public void mousePressed(MouseEvent e) {}

		public void mouseReleased(MouseEvent e) {}
	}
	class BackListener implements MouseListener {
		public void mouseClicked(MouseEvent e) {
			PlayWave.startClickSound();
			//TODO
		}
		public void mouseEntered(MouseEvent e) {
			PlayWave.startMoveButtonSound();
		}
		public void mouseExited(MouseEvent e) {	
		}
		public void mousePressed(MouseEvent e) {}

		public void mouseReleased(MouseEvent e) {}
	}
}
