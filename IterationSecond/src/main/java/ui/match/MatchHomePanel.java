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
import vo.MatchVO;
import vo.PlayerBasicVO;
import vo.TeamAllVO;
import vo.TeamAverageVO;
import vo.TeamBasicVO;
import BL.MatchBL;
import BL.MatchBL_Impl;
import BL.TeamBL;
import BL.TeamBL_Impl;

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
	private JButton matchTime;
	private JButton winnerScore;
	private JButton loserScore;
	private JButton winnerTeam;
	private JButton loserTeam;
	private MyStringTable segScore;
	
	private MyTable winnerPlayerData;
	private MyTable loserPlayerData;
	private JScrollPane wpdScrollPane;
	private JScrollPane lpdScrollPane;
	
	//
	private String matchTempID;
	MatchBL mbl = new MatchBL_Impl();
	
	public JPanel init(String matchID){
		matchTempID = matchID;
		
		matchHomePanel = new JPanel();
		matchHomePanel.setOpaque(false);
		matchHomePanel.setBounds(0, 0, 1000-130, 700);
		matchHomePanel.setLayout(null);
		
		//TODO logoIcon
		JSVGCanvas winnerSvg = new JSVGCanvas();
		File fw = new File("teamImg/"+"ATL"+".svg");
		winnerSvg.setBounds(235, 60, 120, 120);
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
		
		JSVGCanvas loserSvg = new JSVGCanvas();
		File fl = new File("teamImg/"+"ATL"+".svg");
		loserSvg.setBounds(475, 60, 120, 120);
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
		
		//TODO title info
		int width = 100;
		int height = 30;
		
		matchTime = new JButton();
		matchTime.setBounds(365, 30, width, height);
		matchTime.setOpaque(false);
		matchTime.setContentAreaFilled(false);
		matchTime.setBorderPainted(false);
		matchTime.setText("Time");
		matchTime.setForeground(Color.GRAY);
		matchTime.setFont(new Font("微软雅黑",Font.PLAIN, 15));
		matchHomePanel.add(matchTime, 0);
		
		//TODO
		JLabel lScore = new JLabel();
		lScore.setBounds(355, 60, 120, 120);
		lScore.setOpaque(false);
		lScore.setIcon(AllImages.IMG_SCOREVS);
		matchHomePanel.add(lScore, 0);
		
		return matchHomePanel;
	}
	
	//TODO initPlayerTable
	public JScrollPane initWPDTable(Object[][] columnPValues, String[] columnName_Player){
		
		winnerPlayerData = new MyTable(columnPValues, columnName_Player);
		winnerPlayerData.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		winnerPlayerData.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		winnerPlayerData.setForeground(Color.white);
		winnerPlayerData.setRowHeight(35);
		winnerPlayerData.setBounds(30, 0, 1000-130-100, 450);
		winnerPlayerData.setOpaque(false);
		
		winnerPlayerData.addMouseListener(new TableListener());

		winnerPlayerData.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		
	    wpdScrollPane = new JScrollPane();
	    wpdScrollPane.setColumnHeaderView(winnerPlayerData.getTableHeader());	//设置头部（HeaderView部分）  
	    wpdScrollPane.getColumnHeader().setOpaque(false);	//再取出头部，并设置为透明  
	    
	    wpdScrollPane.setViewportView(winnerPlayerData);	//装载表格  
	    wpdScrollPane.setOpaque(false);
	    wpdScrollPane.getViewport().setOpaque(false);
	    wpdScrollPane.getVerticalScrollBar().setUI(new IScrollBarUI());
	    wpdScrollPane.getHorizontalScrollBar().setUI(new IScrollBarUI());
	    
	    wpdScrollPane.setBounds(30, 0, 1000-130-100, 450);
	    wpdScrollPane.setBorder(null);
	    wpdScrollPane.setOpaque(false);
		return wpdScrollPane;
	}
	//TODO initTeamDataTable
	public JScrollPane initLPDTable(Object[][] columnTValues, String[] columnName_Team){
		
			loserPlayerData = new MyTable(columnTValues, columnName_Team);
			loserPlayerData.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			loserPlayerData.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			loserPlayerData.setForeground(Color.white);
			loserPlayerData.setRowHeight(35);
			loserPlayerData.setBounds(30, 0, 1000-130-100, 450);
			loserPlayerData.setOpaque(false);
			
			loserPlayerData.addMouseListener(new TableListener());

			loserPlayerData.setFont(new Font("微软雅黑", Font.PLAIN, 13));
			
		    lpdScrollPane = new JScrollPane();
		    lpdScrollPane.setColumnHeaderView(loserPlayerData.getTableHeader());	//设置头部（HeaderView部分）  
		    lpdScrollPane.getColumnHeader().setOpaque(false);	//再取出头部，并设置为透明  
		    
		    lpdScrollPane.setViewportView(loserPlayerData);	//装载表格  
		    lpdScrollPane.setOpaque(false);
		    lpdScrollPane.getViewport().setOpaque(false);
		    lpdScrollPane.getVerticalScrollBar().setUI(new IScrollBarUI());
		    lpdScrollPane.getHorizontalScrollBar().setUI(new IScrollBarUI());
		    
	        lpdScrollPane.setBounds(30, 0, 1000-130-100, 450);
	        lpdScrollPane.setOpaque(false);
		return lpdScrollPane;
	}
	
	class InitWPDTableListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			/*ArrayList<String> teamPlayerInfoList=tbl.getPlayerNamesOfTeam(teamTempID);
			
			String[] columnName_Player = new String[] { "球员头像", "球员名称", "球衣号码", "球员位置", "身高","体重","生日","年龄","球龄","毕业学校" };
			Object[][] columnPValues = new Object[teamPlayerInfoList.size()][columnName_Player.length];
			for (int i = 0; i < teamPlayerInfoList.size(); i++) {
				PlayerBasicVO pbvo = new PlayerBasicVO(teamPlayerInfoList.get(i));
				columnPValues[i][0] = new ImageIcon("playerImg/portrait"+teamPlayerInfoList.get(i)+".png");
				columnPValues[i][1] = teamPlayerInfoList.get(i);
				columnPValues[i][2] = pbvo.getBasicInfo()[0];
				columnPValues[i][3] = pbvo.getBasicInfo()[1];
				columnPValues[i][4] = pbvo.getBasicInfo()[2];
				columnPValues[i][5] = pbvo.getBasicInfo()[3];
				columnPValues[i][6] = pbvo.getBasicInfo()[4];
				columnPValues[i][7] = pbvo.getBasicInfo()[5];
				columnPValues[i][8] = pbvo.getBasicInfo()[6];
				columnPValues[i][9] = pbvo.getBasicInfo()[7];
			}
			PlayWave.startClickSound();
			TablePanel.removeAll();		
	        TablePanel.add(initPTable(columnPValues, columnName_Player), 0);
	        TablePanel.repaint();*/
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
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
		
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
