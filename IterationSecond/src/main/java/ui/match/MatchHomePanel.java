package ui.match;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import org.apache.batik.swing.JSVGCanvas;
import org.apache.batik.swing.gvt.GVTTreeRendererAdapter;
import org.apache.batik.swing.gvt.GVTTreeRendererEvent;
import org.apache.batik.swing.svg.GVTTreeBuilderAdapter;
import org.apache.batik.swing.svg.GVTTreeBuilderEvent;
import org.apache.batik.swing.svg.SVGDocumentLoaderAdapter;
import org.apache.batik.swing.svg.SVGDocumentLoaderEvent;

import sound.PlayWave;
import ui.AllImages;
import ui.IScrollBarUI;
import ui.MyStringTable;
import ui.MyTable;
import ui.player.PlayerHomePanel;
import vo.MatchVO;
import BL.MatchBL;
import BL.MatchBL_Impl;

public class MatchHomePanel {
	/**
	 * @param 比赛的独立主页
	 *         -> 双方球队队徽
	 *         -> 比赛时间
	 *         -> 比分+每一节的比分
	 *         -> 双方球队的球员信息
	 * @author forIris
	 * @version  June 27, 2015 10:18:31 AM
	 * **/
	private JPanel matchHomePanel;
	private JPanel tablePanel;
	private JButton matchTime;
	private JButton winnerTeam;
	private JButton loserTeam;
	private MyStringTable segScore;
	private JScrollPane segScrollPane;
	
	private MyTable PlayerData;
	private JScrollPane pdScrollPane;
	
	//
	private String matchTempID;
	MatchBL mbl = new MatchBL_Impl();
	
	public JPanel init(String matchID){
		matchTempID = matchID;
		MatchVO matchData = mbl.getMatchByName(matchTempID);
		
		matchHomePanel = new JPanel();
		matchHomePanel.setOpaque(false);
		matchHomePanel.setBounds(0, 0, 1000-130, 700);
		matchHomePanel.setLayout(null);
		
		tablePanel = new JPanel();
		tablePanel.setOpaque(false);
		tablePanel.setBounds(0, 330, 1000-130, 700-330);
		tablePanel.setLayout(null);
		matchHomePanel.add(tablePanel, 0);
		
		//TODO logoIcon
		JLabel winnerName = new JLabel();
		winnerName.setOpaque(false);
		winnerName.setBounds(235, 80, 120, 30);
		winnerName.setText(matchData.getWinTeam());//full name
		winnerName.setHorizontalAlignment(SwingConstants.CENTER);
		winnerName.setForeground(Color.WHITE);
		winnerName.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		matchHomePanel.add(winnerName, 0);
		
		JLabel winnerScore = new JLabel();
		winnerScore.setHorizontalAlignment(SwingConstants.CENTER);
		winnerScore.setOpaque(false);
		winnerScore.setText(matchData.getWinPointer());// score
		winnerScore.setForeground(Color.WHITE);
		winnerScore.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		winnerScore.setBounds(235, 140, 120, 30);
		matchHomePanel.add(winnerScore, 0);
		
		JSVGCanvas winnerSvg = new JSVGCanvas();
		File fw = new File("teamImg/"+matchData.getWinTeam()+".svg");
		winnerSvg.setBounds(235-120, 60, 120, 120);
		winnerSvg.setURI(fw.toURI().toString());
		winnerSvg.addSVGDocumentLoaderListener(new SVGDocumentLoaderAdapter(){
			public void documentLoadingStarted(SVGDocumentLoaderEvent e){
			}
			public void documentLoadingCompleted(SVGDocumentLoaderEvent e){
			}
		});
		winnerSvg.addGVTTreeBuilderListener(new GVTTreeBuilderAdapter(){
			public void gvtBuildStarted(GVTTreeBuilderEvent e){
			}
			public void gvtBuildCompleted(GVTTreeBuilderEvent e){
				//frame.pack();
			}
		});
		winnerSvg.addGVTTreeRendererListener(new GVTTreeRendererAdapter(){
			 public void gvtRenderingPrepare(GVTTreeRendererEvent e) {  
				 }   
			 public void gvtRenderingCompleted(GVTTreeRendererEvent e) {
				 System.out.println(1);
			 }
		});
		matchHomePanel.add(winnerSvg, 0);
		
		JLabel loserName = new JLabel();
		loserName.setOpaque(false);
		loserName.setBounds(475, 80, 120, 30);
		loserName.setText(matchData.getLostTeam());
		loserName.setHorizontalAlignment(SwingConstants.CENTER);
		loserName.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		loserName.setForeground(Color.WHITE);
		matchHomePanel.add(loserName, 0);
		
		JLabel loserScore = new JLabel();
		loserScore.setOpaque(false);
		loserScore.setBounds(475, 140, 120, 30);
		loserScore.setText(matchData.getLostPointer());
		loserScore.setHorizontalAlignment(SwingConstants.CENTER);
		loserScore.setForeground(Color.WHITE);
		loserScore.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		matchHomePanel.add(loserScore, 0);
		
		JSVGCanvas loserSvg = new JSVGCanvas();
		File fl = new File("teamImg/"+matchData.getLostTeam()+".svg");
		loserSvg.setBounds(475+120, 60, 120, 120);
		loserSvg.setURI(fl.toURI().toString());
		loserSvg.addSVGDocumentLoaderListener(new SVGDocumentLoaderAdapter(){
			public void documentLoadingStarted(SVGDocumentLoaderEvent e){
			}
			public void documentLoadingCompleted(SVGDocumentLoaderEvent e){
			}
		});
		loserSvg.addGVTTreeBuilderListener(new GVTTreeBuilderAdapter(){
			public void gvtBuildStarted(GVTTreeBuilderEvent e){
			}
			public void gvtBuildCompleted(GVTTreeBuilderEvent e){
				//frame.pack();
			}
		});
		loserSvg.addGVTTreeRendererListener(new GVTTreeRendererAdapter(){
			 public void gvtRenderingPrepare(GVTTreeRendererEvent e) {  
				 }   
			 public void gvtRenderingCompleted(GVTTreeRendererEvent e) {
				 System.out.println(1);
			 }
		});
		matchHomePanel.add(loserSvg, 0);
		
		// title info
		int width = 100;
		int height = 30;
		
		matchTime = new JButton();
		matchTime.setBounds(365, 30, width, height);
		matchTime.setOpaque(false);
		matchTime.setContentAreaFilled(false);
		matchTime.setBorderPainted(false);
		matchTime.setText(matchData.getTime());
		matchTime.setForeground(Color.GRAY);
		matchTime.setFont(new Font("微软雅黑",Font.PLAIN, 15));
		matchHomePanel.add(matchTime, 0);
		
		//
		JLabel lScore = new JLabel();
		lScore.setBounds(355, 60, 120, 120);
		lScore.setOpaque(false);
		lScore.setIcon(AllImages.IMG_SCOREVS);
		matchHomePanel.add(lScore, 0);
		
		//TODO
		String[] columnName = new String[] { "球队名", "1", "2", "3", "4", "加时"};
		Object[][] columnValues = new Object[2][columnName.length];
		columnValues[0][0] = matchData.getWinPointer();
		columnValues[0][1] = matchData.getPointerpart1().get(0);
		columnValues[0][2] = matchData.getPointerpart1().get(1);
		columnValues[0][3] = matchData.getPointerpart1().get(2);
		columnValues[0][4] = matchData.getPointerpart1().get(3);
		if(matchData.getPointerpart1().size()<=5){
			columnValues[0][5] = matchData.getPointerpart1().get(4);
		}
		columnValues[1][0] = matchData.getWinPointer();
		columnValues[1][1] = matchData.getPointerpart2().get(0);
		columnValues[1][2] = matchData.getPointerpart2().get(1);
		columnValues[1][3] = matchData.getPointerpart2().get(2);
		columnValues[1][4] = matchData.getPointerpart2().get(3);
		if(matchData.getPointerpart1().size()<=5){
			columnValues[1][5] = matchData.getPointerpart2().get(4);
		}
		PlayWave.startClickSound();
        matchHomePanel.add(initSegTable(columnValues, columnName), 0);
        matchHomePanel.repaint();
		
		//
		winnerTeam = new JButton();
		winnerTeam.setOpaque(false);
		winnerTeam.setContentAreaFilled(false);
		winnerTeam.setBorderPainted(false);
		winnerTeam.setIcon(AllImages.IMG_MATCH_WINNERTEAM);
		winnerTeam.setBounds(60, 300, 100, 30);
		winnerTeam.addMouseListener(new InitWPDTableListener());
		matchHomePanel.add(winnerTeam, 0);
		
		loserTeam = new JButton();
		loserTeam.setOpaque(false);
		loserTeam.setContentAreaFilled(false);
		loserTeam.setBorderPainted(false);
		loserTeam.setIcon(AllImages.IMG_MATCH_LOSERTEAM);
		loserTeam.setBounds(160, 300, 100, 30);
		loserTeam.addMouseListener(new InitLPDTableListener());
		matchHomePanel.add(loserTeam, 0);
		
		return matchHomePanel;
	}
	
	public JScrollPane initSegTable(Object[][] columnValues, String[] columnName){
		segScore = new MyStringTable(columnValues, columnName);
		segScore.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		segScore.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		segScore.setForeground(Color.white);
		segScore.setRowHeight(30);
		segScore.setBounds(195-20, 190, 490-5-2, 82);
		segScore.setBorder(null);
		segScore.setOpaque(false);
		
		segScore.addMouseListener(new TableListener());

		segScore.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		
		segScrollPane = new JScrollPane();
		segScrollPane.setBorder(null);
		segScrollPane.setColumnHeaderView(segScore.getTableHeader());	//设置头部（HeaderView部分）  
		segScrollPane.getColumnHeader().setOpaque(false);	//再取出头部，并设置为透明  
	    
		segScrollPane.setViewportView(segScore);	//装载表格  
		segScrollPane.setOpaque(false); 
		segScrollPane.getViewport().setOpaque(false);
		segScrollPane.getVerticalScrollBar().setUI(new IScrollBarUI());
		segScrollPane.getHorizontalScrollBar().setUI(new IScrollBarUI());
	    
		segScrollPane.setBounds(195-20, 190, 490-5-2, 82);	
		segScrollPane.setOpaque(false);
		return segScrollPane;
		
	}
	
	//TODO initPlayerTable
	public JScrollPane initPDTable(Object[][] columnPValues, String[] columnName_Player){
		
		PlayerData = new MyTable(columnPValues, columnName_Player);
		PlayerData.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		PlayerData.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		PlayerData.setForeground(Color.white);
		PlayerData.setRowHeight(50);
		PlayerData.setBounds(40, 10, 1000-130-100, 700-380);
		PlayerData.setOpaque(false);
		
		PlayerData.addMouseListener(new TableListener());

		PlayerData.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		
	    pdScrollPane = new JScrollPane();
	    pdScrollPane.setColumnHeaderView(PlayerData.getTableHeader());	//设置头部（HeaderView部分）  
	    pdScrollPane.getColumnHeader().setOpaque(false);	//再取出头部，并设置为透明  
	    
	    pdScrollPane.setViewportView(PlayerData);	//装载表格  
	    pdScrollPane.setOpaque(false);
	    pdScrollPane.getViewport().setOpaque(false);
	    pdScrollPane.getVerticalScrollBar().setUI(new IScrollBarUI());
	    pdScrollPane.getHorizontalScrollBar().setUI(new IScrollBarUI());
	    
	    pdScrollPane.setBounds(40, 10, 1000-130-100, 700-380);
	    pdScrollPane.setBorder(null);
	    pdScrollPane.setOpaque(false);
		return pdScrollPane;
	}
	
	class InitWPDTableListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			MatchVO matchData = mbl.getMatchByName(matchTempID);
			ArrayList<String[]> matchPD = matchData.getWinList();
			String[] columnName_Player = new String[] { "球员头像", "球员名称", "位置", "在场时间",
					"投篮命中数","投篮出手数","三分命中数","三分出手数","罚球命中数",
					"罚球出手数","进攻篮板数","防守篮板数","总篮板数",
					"助攻数","抢断数","盖帽数","失误数","犯规数","得分"};
			Object[][] columnPValues = new Object[2][columnName_Player.length];
			for (int i = 0; i < 2; i++) {
				columnPValues[i][0] = new ImageIcon("playerImg/portrait/"+matchPD.get(i)[0]+".png");
				columnPValues[i][1] = matchPD.get(i)[0];
				columnPValues[i][2] = matchPD.get(i)[1];
				columnPValues[i][3] = matchPD.get(i)[2];
				columnPValues[i][4] = matchPD.get(i)[3];
				columnPValues[i][5] = matchPD.get(i)[4];
				columnPValues[i][6] = matchPD.get(i)[5];
				columnPValues[i][7] = matchPD.get(i)[6];
				columnPValues[i][8] = matchPD.get(i)[7];
				columnPValues[i][9] = matchPD.get(i)[8];
				columnPValues[i][10] = matchPD.get(i)[9];
				columnPValues[i][11] = matchPD.get(i)[10];
				columnPValues[i][12] = matchPD.get(i)[11];
				columnPValues[i][13] = matchPD.get(i)[12];
				columnPValues[i][14] = matchPD.get(i)[13];
				columnPValues[i][15] = matchPD.get(i)[14];
				columnPValues[i][16] = matchPD.get(i)[15];
				columnPValues[i][17] = matchPD.get(i)[16];
				columnPValues[i][18] = matchPD.get(i)[17];
			}
			PlayWave.startClickSound();
			tablePanel.removeAll();		
	        tablePanel.add(initPDTable(columnPValues, columnName_Player), 0);
	        tablePanel.repaint();
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
	class TableListener implements MouseListener{
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
			if(e.getClickCount()==2){
				System.out.println(PlayerData.getValueAt(PlayerData.getSelectedRow(), PlayerData.getSelectedColumn()+1));
				if (PlayerData.getSelectedColumn()==0) {
					tablePanel.removeAll();
					matchHomePanel.removeAll();
					PlayerHomePanel php = new PlayerHomePanel();
					matchHomePanel.add(php.init(PlayerData.getValueAt(PlayerData.getSelectedRow(), PlayerData.getSelectedColumn()+1).toString()));
					matchHomePanel.repaint();
				}
			}
		}
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent e) {
		}		
	}

	class InitLPDTableListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			MatchVO matchData = mbl.getMatchByName(matchTempID);
			ArrayList<String[]> matchPD = matchData.getLostList();
			String[] columnName_Player = new String[] { "球员头像", "球员名称", "位置", "在场时间",
					"投篮命中数","投篮出手数","三分命中数","三分出手数","罚球命中数",
					"罚球出手数","进攻篮板数","防守篮板数","总篮板数",
					"助攻数","抢断数","盖帽数","失误数","犯规数","得分"};
			Object[][] columnPValues = new Object[2][columnName_Player.length];
			for (int i = 0; i < 2; i++) {
				columnPValues[i][0] = new ImageIcon("playerImg/portrait/"+matchPD.get(i)[0]+".png");
				columnPValues[i][1] = matchPD.get(i)[0];
				columnPValues[i][2] = matchPD.get(i)[1];
				columnPValues[i][3] = matchPD.get(i)[2];
				columnPValues[i][4] = matchPD.get(i)[3];
				columnPValues[i][5] = matchPD.get(i)[4];
				columnPValues[i][6] = matchPD.get(i)[5];
				columnPValues[i][7] = matchPD.get(i)[6];
				columnPValues[i][8] = matchPD.get(i)[7];
				columnPValues[i][9] = matchPD.get(i)[8];
				columnPValues[i][10] = matchPD.get(i)[9];
				columnPValues[i][11] = matchPD.get(i)[10];
				columnPValues[i][12] = matchPD.get(i)[11];
				columnPValues[i][13] = matchPD.get(i)[12];
				columnPValues[i][14] = matchPD.get(i)[13];
				columnPValues[i][15] = matchPD.get(i)[14];
				columnPValues[i][16] = matchPD.get(i)[15];
				columnPValues[i][17] = matchPD.get(i)[16];
				columnPValues[i][18] = matchPD.get(i)[17];
			}
			PlayWave.startClickSound();
			tablePanel.removeAll();		
	        tablePanel.add(initPDTable(columnPValues, columnName_Player), 0);
	        tablePanel.repaint();
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
