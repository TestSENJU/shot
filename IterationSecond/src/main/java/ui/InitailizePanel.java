package ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import sound.PlayWave;
import ui.aboutus.AboutUsPanel;
import ui.hot.HotInfoPanel;
import ui.player.PlayerPanel;
import ui.search.SearchPanel;
import ui.statistic.StatisticPanel;
import ui.team.TeamPanel;
import vo.PlayerAverageVO;
import BL.PlayerBL;
import BL.PlayerBL_Impl;

public class InitailizePanel {
	/** 
	 * @param 进入系统后的初始化界面-real Controller
	 * @author forIris
	 * @version  June 12, 2015 11:41:31 AM
	 * **/
	public static JLayeredPane bg;
	public static LandingPanel land;
	public static JPanel infoPanel;
	private JButton logo;
	private JButton hot;
	private JButton team;
	private JButton player;
	private JButton statistic;
	private JButton search;
	private JButton aboutus;
	private JButton close;
	private JButton min;
	public static JButton refresh;
	private int width = 80;
	private int height = 80;
	
	PlayerBL pbl = new PlayerBL_Impl();

	public InitailizePanel() {
	}

	public void init() {
		land = new LandingPanel(AllImages.IMG_BG2);
		land.setOpaque(false);
		land.setBounds(0, 0, Controller.f.getWidth(), Controller.f.getHeight());
		land.setLayout(null);
		
		bg = new JLayeredPane();
		bg.setBounds(0, 0, Controller.f.getWidth(), Controller.f.getHeight());
		bg.add(land, new Integer(0));
	
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
		
		refresh = new JButton();
		refresh.setBounds(1000-50-40-50, 20, 40, 30);
		refresh.setBorderPainted(false);
		refresh.setContentAreaFilled(false);
		refresh.setIcon(AllImages.IMG_REFRESH);
		refresh.setOpaque(false);
		refresh.addMouseListener(new RefreshListener());
		land.add(refresh, 0);
		
		infoPanel = new JPanel();
		infoPanel.setLayout(null);
		infoPanel.setBounds(130, 0, 1000-130, 700);
		infoPanel.setOpaque(false);
		
		bg.add(infoPanel, new Integer(1));
		Controller.f.getContentPane().add(bg);
	} 
	
	class HotInfoListener implements MouseListener {
		public void mouseClicked(MouseEvent e) {
			PlayWave.startClickSound();
			//TODO
			bg.remove(new Integer(1));
			HotInfoPanel hp = new HotInfoPanel();
			JPanel h = hp.init();
			bg.add(h, new Integer(1));
			bg.repaint();
		}
		public void mouseEntered(MouseEvent e) {
			//PlayWave.startMoveButtonSound();
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
			//infoPanel.removeAll();
			bg.remove(new Integer(1));
			PlayerPanel pp = new PlayerPanel();
			JPanel p = pp.init();
			bg.add(p, new Integer(1));
			bg.repaint();
		}
		public void mouseEntered(MouseEvent e) {
			//PlayWave.startMoveButtonSound();
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
			bg.remove(new Integer(1));
			TeamPanel tp = new TeamPanel();
			bg.add(tp.init(), new Integer(1));
			/*TeamHomePanel thp = new TeamHomePanel();
			infoPanel.add(thp.init());*/
			bg.repaint();
		}
		public void mouseEntered(MouseEvent e) {
			//PlayWave.startMoveButtonSound();
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
			bg.remove(new Integer(1));
			StatisticPanel sp = new StatisticPanel();
			JPanel s = sp.init();
			bg.add(s, 0);
			StatisticPanel.tempTableButton = "playerAverage";
			ArrayList<PlayerAverageVO> playerAverageData = new ArrayList<PlayerAverageVO>();
			playerAverageData = pbl.getPlayerAverage();
			PlayWave.startClickSound();
			StatisticPanel.tablePanel.removeAll();
			String[] columnName = new String[] {"头像","球员名称","所属球队","参赛场数", "先发场数",
					"篮板数", "助攻数", "在场时间","投篮命中率",
					"三分命中率","罚球命中率","进攻数","防守数" ,
					"抢断数","盖帽数","失误数" ,"犯规数",
					"得分","效率" ,"GmSc效率值","真实命中数","投篮效率",
					"篮板率","进攻篮板率","防守篮板率","助攻率",
					"抢断率","盖帽率" ,
					"失误率","使用率" };
			Object[][] columnValues = new Object[playerAverageData.size()][columnName.length];
			for (int i = 0; i < playerAverageData.size(); i++) {
				File img = new File("playerImg/portrait/"+playerAverageData.get(i).getName()+".png");
				if (img.exists()) {
					columnValues[i][0] = new ImageIcon("playerImg/portrait/"+playerAverageData.get(i).getName()+".png");
				} else {
					columnValues[i][0] = AllImages.IMG_DEFAULTPLAYER;
				}
				columnValues[i][1] = playerAverageData.get(i).getName();
				columnValues[i][2] = playerAverageData.get(i).getTeamList();
				columnValues[i][3] = playerAverageData.get(i).getCompeteNum();
				columnValues[i][4] = playerAverageData.get(i).getOffensiveNum();
				columnValues[i][5] = playerAverageData.get(i).getPlayerData()[0];
				columnValues[i][6] = playerAverageData.get(i).getPlayerData()[1];
				columnValues[i][7] = playerAverageData.get(i).getPlayingTime();
				columnValues[i][8] = playerAverageData.get(i).getPlayerData()[2];
				columnValues[i][9] = playerAverageData.get(i).getPlayerData()[3];
				columnValues[i][10] = playerAverageData.get(i).getPlayerData()[4];
				columnValues[i][11] = playerAverageData.get(i).getPlayerData()[5];
				columnValues[i][12] = playerAverageData.get(i).getPlayerData()[6];
				columnValues[i][13] = playerAverageData.get(i).getPlayerData()[7];
				columnValues[i][14] = playerAverageData.get(i).getPlayerData()[8];
				columnValues[i][15] = playerAverageData.get(i).getPlayerData()[9];
				columnValues[i][16] = playerAverageData.get(i).getPlayerData()[10];
				columnValues[i][17] = playerAverageData.get(i).getPlayerData()[11];
				columnValues[i][18] = playerAverageData.get(i).getPlayerData()[12];
				columnValues[i][19] = playerAverageData.get(i).getPlayerData()[13];
				columnValues[i][20] = playerAverageData.get(i).getPlayerData()[14];
				columnValues[i][21] = playerAverageData.get(i).getPlayerData()[15];
				columnValues[i][22] = playerAverageData.get(i).getPlayerData()[16];
				columnValues[i][23] = playerAverageData.get(i).getPlayerData()[17];
				columnValues[i][24] = playerAverageData.get(i).getPlayerData()[18];
				columnValues[i][25] = playerAverageData.get(i).getPlayerData()[19];
				columnValues[i][26] = playerAverageData.get(i).getPlayerData()[20];
				columnValues[i][27] = playerAverageData.get(i).getPlayerData()[21];
				columnValues[i][28] = playerAverageData.get(i).getPlayerData()[22];
				columnValues[i][29] = playerAverageData.get(i).getPlayerData()[23];
			}
			StatisticPanel.tablePanel.add(sp.playerDataTable(columnValues, columnName));
			StatisticPanel.tablePanel.repaint();
			sp.initToolPanel();
			StatisticPanel.toolPanel.repaint();
			bg.repaint();
		}
		public void mouseEntered(MouseEvent e) {
			//PlayWave.startMoveButtonSound();
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
			bg.remove(new Integer(1));
			SearchPanel sep = new SearchPanel();
			JPanel s = sep.init();
			bg.add(s, 0);
			bg.repaint();
		}
		public void mouseEntered(MouseEvent e) {
			//PlayWave.startMoveButtonSound();
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
			bg.remove(new Integer(1));
			AboutUsPanel aup = new AboutUsPanel();
			JPanel a = aup.init();
			bg.add(a, 0);
			bg.repaint();
		}
		public void mouseEntered(MouseEvent e) {
			//PlayWave.startMoveButtonSound();
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
			Controller.f.setExtendedState(JFrame.ICONIFIED);
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
	class BackListener implements MouseListener {
		public void mouseClicked(MouseEvent e) {
			PlayWave.startClickSound();
			//TODO
		}
		public void mouseEntered(MouseEvent e) {
			//PlayWave.startMoveButtonSound();
		}
		public void mouseExited(MouseEvent e) {	
		}
		public void mousePressed(MouseEvent e) {}

		public void mouseReleased(MouseEvent e) {}
	}
	
	class RefreshListener implements MouseListener {

		public void mouseClicked(MouseEvent arg0) {
			PlayWave.startClickSound();
			bg.removeAll();
			init();
			HotInfoPanel hp = new HotInfoPanel();
			JPanel h = hp.init();
			bg.add(h, new Integer(1));
			hp.hotPlayerTodayPanel();
			HotInfoPanel.hotPanel.repaint();
			bg.repaint();
			refresh.setIcon(AllImages.IMG_REFRESH);
			Write w = new Write();
			w.writeTxtFile();
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
