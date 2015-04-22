package ui.team;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

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

public class TeamHomePanel {
	/**
	 * @param 球队的独立主页
	 *         -> 球队队徽
	 *         -> 球队的基本信息
	 *         -> 球队的现役球员[和退役球员maybe]
	 *         -> 球队的比赛数据[场均和总赛季]
	 * @author forIris
	 * @version  June 13, 2015 15:54:31 PM
	 * **/
	private JPanel teamHomePanel;
	private JButton fullName;
	private JButton shortName;
	private JButton location;
	private JButton zone;
	private JButton partition;
	private JButton homeCourt;
	private JButton settingTime;
	
	//
	private JButton initPlayerTable;
	private JButton initTeamDataTable;
	private JButton initRecentMatchTable;
	private JButton initAllMatch;
	//
	private JPanel TablePanel;
	private MyTable pTable;
	private JScrollPane pScrollPane;
	private MyStringTable tTable;
	private JScrollPane tScrollPane;
	private MyStringTable rMTable;
	private JScrollPane rMScrollPane;
	private MyStringTable aMTable;
	private JScrollPane aMScrollPane;
	
	public JPanel init(){
		teamHomePanel = new JPanel();
		teamHomePanel.setOpaque(false);
		teamHomePanel.setBounds(0, 0, 1000-130, 700);
		teamHomePanel.setLayout(null);
		
		//TODO logoIcon
		JSVGCanvas svgCanvas = new JSVGCanvas();
		File f1 = new File("teamImg/ATL.svg");
		svgCanvas.setBounds(30, 50, 120, 120);
		svgCanvas.setURI(f1.toURI().toString());
		svgCanvas.addSVGDocumentLoaderListener(new SVGDocumentLoaderAdapter(){
			public void documentLoadingStarted(SVGDocumentLoaderEvent e){
			}
			public void documentLoadingCompleted(SVGDocumentLoaderEvent e){
			}
		});
		svgCanvas.addGVTTreeBuilderListener(new GVTTreeBuilderAdapter(){
			public void gvtBuildStarted(GVTTreeBuilderEvent e){
			}
			public void gvtBuildCompleted(GVTTreeBuilderEvent e){
				//frame.pack();
			}
		});
		svgCanvas.addGVTTreeRendererListener(new GVTTreeRendererAdapter(){
			 public void gvtRenderingPrepare(GVTTreeRendererEvent e) {  
				 }   
			 public void gvtRenderingCompleted(GVTTreeRendererEvent e) {
				 System.out.println(1);
			 }
		});
		teamHomePanel.add(svgCanvas, 0);
		//TODO basic info
		/**球队全名-球队名缩写-所在地-赛区-分区-主场-建立时间*/
		int toLeftFirst = 200;
		int toLeftSecond = 350;
		int toLeftThird = 500;
		int width = 100;
		int height = 30;
		
		fullName = new JButton();
		fullName.setBounds(toLeftFirst, 50, width, height);
		fullName.setOpaque(false);
		fullName.setContentAreaFilled(false);
		fullName.setBorderPainted(false);
		fullName.setText("队名");
		teamHomePanel.add(fullName, 0);
		
		//TODO
		JLabel tfullName = new JLabel();
		tfullName.setBounds(toLeftFirst+100, 50, width, height);
		tfullName.setOpaque(false);
		tfullName.setText("黄蜂");
		teamHomePanel.add(tfullName, 0);
		
		shortName = new JButton();
		shortName.setBounds(toLeftFirst, 100, width, height);
		shortName.setOpaque(false);
		shortName.setContentAreaFilled(false);
		shortName.setBorderPainted(false);
		shortName.setText("队名缩写");
		teamHomePanel.add(shortName, 0);
		
		//TODO
		JLabel tShortName = new JLabel();
		tShortName.setBounds(toLeftFirst+100, 100, width, height);
		tShortName.setOpaque(false);
		tShortName.setText("HF");
		teamHomePanel.add(tShortName, 0);
		
		location = new JButton();
		location.setBounds(toLeftFirst, 150, width, height);
		location.setOpaque(false);
		location.setContentAreaFilled(false);
		location.setBorderPainted(false);
		location.setText("所在地");
		teamHomePanel.add(location, 0);
		
		//TODO
		JLabel tLocation = new JLabel();
		tLocation.setBounds(toLeftFirst+100, 150, width, height);
		tLocation.setOpaque(false);
		tLocation.setText("NJU");
		teamHomePanel.add(tLocation, 0);
		
		zone = new JButton();
		zone.setBounds(toLeftSecond, 50, width, height);
		zone.setOpaque(false);
		zone.setContentAreaFilled(false);
		zone.setBorderPainted(false);
		zone.setText("赛区");
		teamHomePanel.add(zone, 0);
		
		//TODO
		JLabel tZone = new JLabel();
		tZone.setBounds(toLeftSecond+100, 50, width, height);
		tZone.setOpaque(false);
		tZone.setText("NJU");
		teamHomePanel.add(tZone, 0);
		
		partition = new JButton();
		partition.setBounds(toLeftSecond, 100, width, height);
		partition.setOpaque(false);
		partition.setContentAreaFilled(false);
		partition.setBorderPainted(false);
		partition.setText("分区");
		teamHomePanel.add(partition, 0);
		
		//TODO
		JLabel tPartition = new JLabel();
		tPartition.setBounds(toLeftSecond+100, 100, width, height);
		tPartition.setOpaque(false);
		tPartition.setText("NJU");
		teamHomePanel.add(tPartition, 0);
		
		homeCourt = new JButton();
		homeCourt.setBounds(toLeftThird, 50, width, height);
		homeCourt.setOpaque(false);
		homeCourt.setContentAreaFilled(false);
		homeCourt.setBorderPainted(false);
		homeCourt.setText("主场");
		teamHomePanel.add(homeCourt, 0);
		
		//TODO
		JLabel tHomeCourt = new JLabel();
		tHomeCourt.setBounds(toLeftThird+100, 50, width, height);
		tHomeCourt.setOpaque(false);
		tHomeCourt.setText("NJU");
		teamHomePanel.add(tHomeCourt, 0);
		
		settingTime = new JButton();
		settingTime.setBounds(toLeftThird, 100, width, height);
		settingTime.setOpaque(false);
		settingTime.setContentAreaFilled(false);
		settingTime.setBorderPainted(false);
		settingTime.setText("建立时间");
		teamHomePanel.add(settingTime, 0);
		
		//TODO
		JLabel tSettingTime = new JLabel();
		tSettingTime.setBounds(toLeftThird+100, 100, width, height);
		tSettingTime.setOpaque(false);
		tSettingTime.setText("96-01-19");
		teamHomePanel.add(tSettingTime, 0);
		
		//TODO initButton
		initPlayerTable = new JButton();
		initPlayerTable.setBounds(30, 180, 100, 30);
		initPlayerTable.setOpaque(false);
		initPlayerTable.setContentAreaFilled(false);
		initPlayerTable.setBorderPainted(false);
		initPlayerTable.setIcon(AllImages.IMG_INIT_PLAYERDATA);
		initPlayerTable.addMouseListener(new InitPDTableListener());
		teamHomePanel.add(initPlayerTable, 0);
		
		initTeamDataTable = new JButton();
		initTeamDataTable.setBounds(130, 180, 100, 30);
		initTeamDataTable.setOpaque(false);
		initTeamDataTable.setContentAreaFilled(false);
		initTeamDataTable.setBorderPainted(false);
		initTeamDataTable.setIcon(AllImages.IMG_INIT_TEAMDATA);
		initTeamDataTable.addMouseListener(new InitTDTableListener());
		teamHomePanel.add(initTeamDataTable, 0);
		
		initRecentMatchTable = new JButton();
		initRecentMatchTable.setBounds(230, 180, 100, 30);
		initRecentMatchTable.setOpaque(false);
		initRecentMatchTable.setContentAreaFilled(false);
		initRecentMatchTable.setBorderPainted(false);
		initRecentMatchTable.setIcon(AllImages.IMG_INIT_RECENTMATCH);
		initRecentMatchTable.addMouseListener(new InitRMTableListener());
		teamHomePanel.add(initRecentMatchTable, 0);
		
		initAllMatch = new JButton();
		initAllMatch.setBounds(330, 180, 100, 30);
		initAllMatch.setOpaque(false);
		initAllMatch.setContentAreaFilled(false);
		initAllMatch.setBorderPainted(false);
		initAllMatch.setIcon(AllImages.IMG_INIT_ALLMATCH);
		initAllMatch.addMouseListener(new InitAMTableListener());
		teamHomePanel.add(initAllMatch, 0);
		
		//TODO tablePanel
		TablePanel = new JPanel();
		TablePanel.setLayout(null);
		TablePanel.setOpaque(false);
		TablePanel.setBounds(0, 230, 1000-130, 700-230);
		teamHomePanel.add(TablePanel, 0);
		
		return teamHomePanel;
	}
	//TODO initPlayerTable
	public JScrollPane initPTable(){
		String[] columnName_Player = new String[] { "球员头像", "球员名称", "球衣号码", "球员位置", "身高","体重","生日","年龄","球龄","毕业学校" };
		Object[][] columnPValues = new Object[30][columnName_Player.length];
		for (int i = 0; i < 30; i++) {
			columnPValues[i][0] = i;
			columnPValues[i][1] = i;
			columnPValues[i][2] = i;
			columnPValues[i][3] = i;
			columnPValues[i][4] = i;
			columnPValues[i][5] = i;
			columnPValues[i][6] = i;
			columnPValues[i][7] = i;
			columnPValues[i][8] = i;
			columnPValues[i][9] = i;
		}
		pTable = new MyTable(columnPValues, columnName_Player);
		pTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		pTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		pTable.setForeground(Color.white);
		pTable.setRowHeight(35);
		pTable.setBounds(30, 0, 1000-130-100, 450);
		pTable.setOpaque(false);
		
		//pTable.addMouseListener(new TableListener());

		pTable.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		
	    pScrollPane = new JScrollPane();
	    pScrollPane.setColumnHeaderView(pTable.getTableHeader());	//设置头部（HeaderView部分）  
	    pScrollPane.getColumnHeader().setOpaque(false);	//再取出头部，并设置为透明  
	    
	    pScrollPane.setViewportView(pTable);	//装载表格  
	    pScrollPane.setOpaque(false);
	    pScrollPane.getViewport().setOpaque(false);
	    pScrollPane.getVerticalScrollBar().setUI(new IScrollBarUI());
	    pScrollPane.getHorizontalScrollBar().setUI(new IScrollBarUI());
	    
        pScrollPane.setBounds(30, 0, 1000-130-100, 450);
        pScrollPane.setBorder(null);
        pScrollPane.setOpaque(false);
		return pScrollPane;
	}
	//TODO initTeamDataTable
	public JScrollPane initTTable(){
		 String[] columnName_Team = new String[] { "Tag", "比赛场数", "投篮命中数", 
	        		"投篮出手次数", "三分命中数", "三分出手数","罚球命中数","罚球出手数",
	        		"进攻篮板数","防守篮板数","篮板数",
	        		"助攻数","抢断数","盖帽数","失误数",
	        		"犯规数","比赛得分","投篮命中率","三分命中率",
	        		"罚球命中率","胜率","进攻回合","进攻效率",
	        		"防守效率","篮板效率","抢断效率","助攻率"};
			Object[][] columnTValues = new Object[2][columnName_Team.length];
			for (int i = 0; i < 2; i++) {
				if(i%2==0){
					columnTValues[i][0] = "总赛季";
				} else {
					columnTValues[i][0] = "场均";
				}
				columnTValues[i][1] = i;
				columnTValues[i][2] = i;
				columnTValues[i][3] = i;
				columnTValues[i][4] = i;
				columnTValues[i][5] = i;
				columnTValues[i][6] = i;
				columnTValues[i][7] = i;
				columnTValues[i][8] = i;
				columnTValues[i][9] = i;
				columnTValues[i][10] = i;
				columnTValues[i][11] = i;
				columnTValues[i][12] = i;
				columnTValues[i][13] = i;
				columnTValues[i][14] = i;
				columnTValues[i][15] = i;
				columnTValues[i][16] = i;
				columnTValues[i][17] = i;
				columnTValues[i][18] = i;
				columnTValues[i][19] = i;
				columnTValues[i][20] = i;
				columnTValues[i][21] = i;
				columnTValues[i][22] = i;
				columnTValues[i][23] = i;
				columnTValues[i][24] = i;
				columnTValues[i][25] = i;
				columnTValues[i][26] = i;
			}
			tTable = new MyStringTable(columnTValues, columnName_Team);
			tTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			tTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tTable.setForeground(Color.white);
			tTable.setRowHeight(35);
			tTable.setBounds(30, 0, 1000-130-100, 450);
			tTable.setOpaque(false);
			
			//pTable.addMouseListener(new TableListener());

			tTable.setFont(new Font("微软雅黑", Font.PLAIN, 13));
			
		    tScrollPane = new JScrollPane();
		    tScrollPane.setColumnHeaderView(tTable.getTableHeader());	//设置头部（HeaderView部分）  
		    tScrollPane.getColumnHeader().setOpaque(false);	//再取出头部，并设置为透明  
		    
		    tScrollPane.setViewportView(tTable);	//装载表格  
		    tScrollPane.setOpaque(false);
		    tScrollPane.getViewport().setOpaque(false);
		    tScrollPane.getVerticalScrollBar().setUI(new IScrollBarUI());
		    tScrollPane.getHorizontalScrollBar().setUI(new IScrollBarUI());
		    
	        teamHomePanel.add(tScrollPane);
	        tScrollPane.setBounds(30, 0, 1000-130-100, 450);
	        tScrollPane.setOpaque(false);
		return tScrollPane;
	}
	//TODO initRecentMatchTable
	public JScrollPane initRMTable(){
		String[] columnName_RM = new String[] { "时间", "比赛名称", "比分", "对手" };
		Object[][] columnRMValues = new Object[5][columnName_RM.length];
		for (int i = 0; i < 5; i++) {
			columnRMValues[i][0] = i;
			columnRMValues[i][1] = i;
			columnRMValues[i][2] = i;
			columnRMValues[i][3] = i;
		}
		rMTable = new MyStringTable(columnRMValues, columnName_RM);
		rMTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		rMTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		rMTable.setForeground(Color.white);
		rMTable.setRowHeight(35);
		rMTable.setBounds(30, 0, 1000-130-100, 450);
		rMTable.setOpaque(false);
		
		//pTable.addMouseListener(new TableListener());

		rMTable.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		
	    rMScrollPane = new JScrollPane();
	    rMScrollPane.setColumnHeaderView(rMTable.getTableHeader());	//设置头部（HeaderView部分）  
	    rMScrollPane.getColumnHeader().setOpaque(false);	//再取出头部，并设置为透明  
	    
	    rMScrollPane.setViewportView(rMTable);	//装载表格  
	    rMScrollPane.setOpaque(false);
	    rMScrollPane.getViewport().setOpaque(false);
	    rMScrollPane.getVerticalScrollBar().setUI(new IScrollBarUI());
	    rMScrollPane.getHorizontalScrollBar().setUI(new IScrollBarUI());
	    rMScrollPane.setBorder(null);
	    rMScrollPane.setBounds(30, 0, 1000-130-100, 450);
	    rMScrollPane.setOpaque(false);
		return rMScrollPane;
	}
	//TODO initAllMatchTable
	public JScrollPane initAMTable(){
		String[] columnName_AM = new String[] { "时间", "比赛名称", "比分", "对手" };
		Object[][] columnAMValues = new Object[30][columnName_AM.length];
		for (int i = 0; i < 30; i++) {
			columnAMValues[i][0] = i;
			columnAMValues[i][1] = i;
			columnAMValues[i][2] = i;
			columnAMValues[i][3] = i;
		}
		aMTable = new MyStringTable(columnAMValues, columnName_AM);
		aMTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		aMTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		aMTable.setForeground(Color.white);
		aMTable.setRowHeight(35);
		aMTable.setBounds(30, 0, 1000-130-100, 450);
		aMTable.setOpaque(false);
		
		//pTable.addMouseListener(new TableListener());

		aMTable.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		
		aMScrollPane = new JScrollPane();
		aMScrollPane.setColumnHeaderView(aMTable.getTableHeader());	//设置头部（HeaderView部分）  
		aMScrollPane.getColumnHeader().setOpaque(false);	//再取出头部，并设置为透明  
	    
		aMScrollPane.setViewportView(aMTable);	//装载表格  
		aMScrollPane.setOpaque(false);
		aMScrollPane.getViewport().setOpaque(false);
		aMScrollPane.getVerticalScrollBar().setUI(new IScrollBarUI());
		aMScrollPane.getHorizontalScrollBar().setUI(new IScrollBarUI());
	    aMScrollPane.setBorder(null);
		aMScrollPane.setBounds(30, 0, 1000-130-100, 450);
		aMScrollPane.setOpaque(false);
		return aMScrollPane;
	}
	
	class InitPDTableListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			PlayWave.startClickSound();
			TablePanel.removeAll();		
	        TablePanel.add(initPTable(), 0);
	        TablePanel.repaint();
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
	class InitTDTableListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			PlayWave.startClickSound();
			TablePanel.removeAll();		
	        TablePanel.add(initTTable(), 0);
	        TablePanel.repaint();
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
	class InitRMTableListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			PlayWave.startClickSound();
			TablePanel.removeAll();		
	        TablePanel.add(initRMTable(), 0);
	        TablePanel.repaint();
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
	class InitAMTableListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			PlayWave.startClickSound();
			TablePanel.removeAll();		
	        TablePanel.add(initAMTable(), 0);
	        TablePanel.repaint();
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
