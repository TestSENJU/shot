package ui.statistic;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import sound.PlayWave;
import ui.AllImages;
import ui.IScrollBarUI;
import ui.MyDialog;
import ui.MyStringTable;
import ui.MyTable;
import ui.player.PlayerHomePanel;

public class StatisticPanel {
	/**
	 * @param 展示球员和球队的比赛数据的界面
	 * @author forIris
	 * @version  June 12, 2015 11:41:31 AM
	 * **/
	private JPanel statisticPanel;
	private JPanel tablePanel;
	private JButton playerAverage;
	private JButton playerAll;
	private JButton teamAverage;
	private JButton teamAll;
	private JScrollPane pScrollPane;
	private JScrollPane tScrollPane;
	private MyTable pDataTable;
	private MyStringTable tDataTable;
	
	public JPanel init(){
		statisticPanel = new JPanel();
		statisticPanel.setOpaque(false);
		statisticPanel.setBounds(130, 0, 1000-130, 700);
		statisticPanel.setLayout(null);
		
		tablePanel = new JPanel();
		tablePanel.setOpaque(false);
		tablePanel.setBounds(0, 100, 1000-130, 600);
		tablePanel.setLayout(null);
		statisticPanel.add(tablePanel, 0);
		
		int width = 100;
		int height = 30;
		playerAverage = new JButton();
		playerAverage.setBounds(40, 40, width-1, height);
		playerAverage.setOpaque(false);
		playerAverage.setContentAreaFilled(false);
		playerAverage.setBorderPainted(false);
		playerAverage.setIcon(AllImages.IMG_PLAYER_AVERAGE_DATA);
		playerAverage.addMouseListener(new PlayerAverageListener());
		statisticPanel.add(playerAverage, 0);
		
		playerAll = new JButton();
		playerAll.setBounds(140+1, 40, width-2, height);
		playerAll.setOpaque(false);
		playerAll.setContentAreaFilled(false);
		playerAll.setBorderPainted(false);
		playerAll.setIcon(AllImages.IMG_PLAYER_ALL_DATA);
		playerAll.addMouseListener(new PlayerAllListener());
		statisticPanel.add(playerAll, 0);
		
		teamAll = new JButton();
		teamAll.setBounds(240+1, 40, width-2, height);
		teamAll.setOpaque(false);
		teamAll.setContentAreaFilled(false);
		teamAll.setBorderPainted(false);
		teamAll.setIcon(AllImages.IMG_TEAM_ALL_DATA);
		teamAll.addMouseListener(new TeamAllListener());
		statisticPanel.add(teamAll, 0);
		
		teamAverage = new JButton();
		teamAverage.setBounds(340+1, 40, width, height);
		teamAverage.setOpaque(false);
		teamAverage.setContentAreaFilled(false);
		teamAverage.setBorderPainted(false);
		teamAverage.setIcon(AllImages.IMG_TEAM_AVERAGE_DATA);
		teamAverage.addMouseListener(new TeamAverageListener());
		statisticPanel.add(teamAverage, 0);
		
		return statisticPanel;
	}
	
	public JScrollPane playerDataTable(Object[][] columnValues, String[] columnName){
		pDataTable = new MyTable(columnValues, columnName);
		pDataTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		pDataTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		pDataTable.setForeground(Color.white);
		pDataTable.setRowHeight(35);
		pDataTable.setBounds(40, 0, 1000-130-100, 500);
		pDataTable.setOpaque(false);
		
		pDataTable.addMouseListener(new pTableListener());
		pDataTable.getTableHeader().addMouseListener(new pTableHeaderListener());

		pDataTable.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
	    pScrollPane = new JScrollPane();
	    pScrollPane.setColumnHeaderView(pDataTable.getTableHeader());	//设置头部（HeaderView部分）  
	    pScrollPane.getColumnHeader().setOpaque(false);	//再取出头部，并设置为透明  
	    
	    pScrollPane.setViewportView(pDataTable);	//装载表格  
	    pScrollPane.setOpaque(false);
	    pScrollPane.getViewport().setOpaque(false);
	    pScrollPane.getVerticalScrollBar().setUI(new IScrollBarUI());
	    pScrollPane.getHorizontalScrollBar().setUI(new IScrollBarUI());
	    
        pScrollPane.setBounds(40, 0, 1000-130-100, 500);
        pScrollPane.setOpaque(false);
        return pScrollPane;
	}
	
	public JScrollPane teamDataTable(Object[][] columnValues, String[] columnName){
		tDataTable = new MyStringTable(columnValues, columnName);
		tDataTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tDataTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tDataTable.setForeground(Color.white);
		tDataTable.setRowHeight(35);
		tDataTable.setBounds(40, 0, 1000-130-100, 500);
		tDataTable.setOpaque(false);
		
		tDataTable.addMouseListener(new pTableListener());

		tDataTable.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
	    tScrollPane = new JScrollPane();
	    tScrollPane.setColumnHeaderView(tDataTable.getTableHeader());	//设置头部（HeaderView部分）  
	    tScrollPane.getColumnHeader().setOpaque(false);	//再取出头部，并设置为透明  
	    
	    tScrollPane.setViewportView(tDataTable);	//装载表格  
	    tScrollPane.setOpaque(false);
	    tScrollPane.getViewport().setOpaque(false);
	    tScrollPane.getVerticalScrollBar().setUI(new IScrollBarUI());
	    tScrollPane.getHorizontalScrollBar().setUI(new IScrollBarUI());
	    
	    tScrollPane.setBounds(40, 0, 1000-130-100, 500);
	    tScrollPane.setOpaque(false);
        return tScrollPane;
	}
	
	//TODO 
	class PlayerAverageListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			PlayWave.startClickSound();
			tablePanel.removeAll();
			String[] columnName = new String[] {"球员名称","所属球队","参赛场数", "先发场数",
					"篮板数", "助攻数", "在场时间","投篮命中率",
					"三分命中率","罚球命中率","进攻数","防守数" ,
					"抢断数","盖帽数","失误数" ,"犯规数",
					"得分","效率" ,"GmSc效率值","真实命中数","投篮效率",
					"篮板率","进攻篮板率","防守篮板率","助攻率",
					"抢断率","盖帽率" ,
					"失误率","使用率" };
			Object[][] columnValues = new Object[30][columnName.length];
			for (int i = 0; i < 30; i++) {
				columnValues[i][0] = i;
				columnValues[i][1] = i;
				columnValues[i][2] = i;
				columnValues[i][3] = i;
				columnValues[i][4] = i;
				columnValues[i][5] = i;
				columnValues[i][6] = i;
				columnValues[i][7] = i;
				columnValues[i][8] = i;
				columnValues[i][9] = i;
			}
			tablePanel.add(playerDataTable(columnValues, columnName));
			tablePanel.repaint();
		}
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	//TODO 
	class PlayerAllListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			PlayWave.startClickSound();
			tablePanel.removeAll();
			String[] columnName = new String[] {"球员名称","所属球队","参赛场数", "先发场数",
					"篮板数", "助攻数", "在场时间","投篮命中率",
					"三分命中率","罚球命中率","进攻数","防守数" ,
					"抢断数","盖帽数","失误数" ,"犯规数",
					"得分","效率" ,"GmSc效率值","真实命中数","投篮效率",
					"篮板率","进攻篮板率","防守篮板率","助攻率",
					"抢断率","盖帽率" ,
					"失误率","使用率" };
			Object[][] columnValues = new Object[30][columnName.length];
			for (int i = 0; i < 30; i++) {
				columnValues[i][0] = i;
				columnValues[i][1] = i;
				columnValues[i][2] = i;
				columnValues[i][3] = i;
				columnValues[i][4] = i;
				columnValues[i][5] = i;
				columnValues[i][6] = i;
				columnValues[i][7] = i;
				columnValues[i][8] = i;
				columnValues[i][9] = i;
			}
			tablePanel.add(playerDataTable(columnValues, columnName));
			tablePanel.repaint();
		}
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	//TODO 
	class TeamAverageListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			PlayWave.startClickSound();
			tablePanel.removeAll();
			String[] columnName = new String[] {"Tag", "比赛场数", "投篮命中数", 
    		"投篮出手次数", "三分命中数", "三分出手数","罚球命中数","罚球出手数",
    		"进攻篮板数","防守篮板数","篮板数",
    		"助攻数","抢断数","盖帽数","失误数",
    		"犯规数","比赛得分","投篮命中率","三分命中率",
    		"罚球命中率","胜率","进攻回合","进攻效率",
    		"防守效率","篮板效率","抢断效率","助攻率"};
			Object[][] columnValues = new Object[30][columnName.length];
			for (int i = 0; i < 30; i++) {
				columnValues[i][0] = i;
				columnValues[i][1] = i;
				columnValues[i][2] = i;
				columnValues[i][3] = i;
				columnValues[i][4] = i;
				columnValues[i][5] = i;
				columnValues[i][6] = i;
				columnValues[i][7] = i;
				columnValues[i][8] = i;
				columnValues[i][9] = i;
			}
			tablePanel.add(teamDataTable(columnValues, columnName));
			tablePanel.repaint();
		}
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	//TODO 
	class TeamAllListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			PlayWave.startClickSound();
			tablePanel.removeAll();
			String[] columnName = new String[] {"球队名称", "比赛场数", "投篮命中数", 
    		"投篮出手次数", "三分命中数", "三分出手数","罚球命中数","罚球出手数",
    		"进攻篮板数","防守篮板数","篮板数",
    		"助攻数","抢断数","盖帽数","失误数",
    		"犯规数","比赛得分","投篮命中率","三分命中率",
    		"罚球命中率","胜率","进攻回合","进攻效率",
    		"防守效率","篮板效率","抢断效率","助攻率"};
			Object[][] columnValues = new Object[30][columnName.length];
			for (int i = 0; i < 30; i++) {
				columnValues[i][0] = i;
				columnValues[i][1] = i;
				columnValues[i][2] = i;
				columnValues[i][3] = i;
				columnValues[i][4] = i;
				columnValues[i][5] = i;
				columnValues[i][6] = i;
				columnValues[i][7] = i;
				columnValues[i][8] = i;
				columnValues[i][9] = i;
			}
			tablePanel.add(teamDataTable(columnValues, columnName));
			tablePanel.repaint();
		}
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	//TODO 
	class pTableListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			PlayWave.startClickSound();
			if(e.getClickCount()==2){
				System.out.println(pDataTable.getValueAt(pDataTable.getSelectedRow(), pDataTable.getSelectedColumn()));
				if (pDataTable.getSelectedColumn()==0) {
					tablePanel.removeAll();
					statisticPanel.removeAll();
					PlayerHomePanel php = new PlayerHomePanel();
					statisticPanel.add(php.init("A"));
					statisticPanel.repaint();
				}
			}
		}
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	//TODO 
	class pTableHeaderListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			PlayWave.startClickSound();
			if(e.getClickCount()==2){
				System.out.println(pDataTable.getColumnName(pDataTable.getTableHeader().columnAtPoint(e.getPoint())));
				new MyDialog(300, 200);
			}
		}
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	//TODO
	class tTableListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			
		}
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}
}
