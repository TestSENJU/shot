package ui.team;

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
	TeamBL tbl = new TeamBL_Impl();
	String teamTempID;
	
	public JPanel init(String teamID){
		teamTempID = teamID;
		TeamBasicVO teamInfo = new TeamBasicVO(teamTempID);
		teamInfo = tbl.getTeamBasicByName(teamTempID);
		
		teamHomePanel = new JPanel();
		teamHomePanel.setOpaque(false);
		teamHomePanel.setBounds(0, 0, 1000-130, 700);
		teamHomePanel.setLayout(null);
		
		//TODO logoIcon
		JSVGCanvas svgCanvas = new JSVGCanvas();
		File f1 = new File("teamImg/"+teamTempID+".svg");
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
		fullName.setForeground(Color.GRAY);
		fullName.setFont(new Font("微软雅黑",Font.PLAIN, 13));
		teamHomePanel.add(fullName, 0);
		
		//TODO
		JLabel tfullName = new JLabel();
		tfullName.setBounds(toLeftFirst+100, 50, width, height);
		tfullName.setOpaque(false);
		tfullName.setText(teamInfo.getLongName());
		tfullName.setForeground(Color.WHITE);
		tfullName.setFont(new Font("微软雅黑",Font.PLAIN, 13));
		teamHomePanel.add(tfullName, 0);
		
		shortName = new JButton();
		shortName.setBounds(toLeftFirst, 100, width, height);
		shortName.setOpaque(false);
		shortName.setContentAreaFilled(false);
		shortName.setBorderPainted(false);
		shortName.setText("队名缩写");
		shortName.setForeground(Color.GRAY);
		shortName.setFont(new Font("微软雅黑",Font.PLAIN, 13));
		teamHomePanel.add(shortName, 0);
		
		//TODO
		JLabel tShortName = new JLabel();
		tShortName.setBounds(toLeftFirst+100, 100, width, height);
		tShortName.setOpaque(false);
		tShortName.setText(teamTempID);
		tShortName.setForeground(Color.WHITE);
		tShortName.setFont(new Font("微软雅黑",Font.PLAIN, 13));
		teamHomePanel.add(tShortName, 0);
		
		location = new JButton();
		location.setBounds(toLeftFirst, 150, width, height);
		location.setOpaque(false);
		location.setContentAreaFilled(false);
		location.setBorderPainted(false);
		location.setText("所在地");
		location.setForeground(Color.GRAY);
		location.setFont(new Font("微软雅黑",Font.PLAIN, 13));
		teamHomePanel.add(location, 0);
		
		//TODO
		JLabel tLocation = new JLabel();
		tLocation.setBounds(toLeftFirst+100, 150, width, height);
		tLocation.setOpaque(false);
		tLocation.setText(teamInfo.getTeamInfo()[1]);
		tLocation.setForeground(Color.WHITE);
		tLocation.setFont(new Font("微软雅黑",Font.PLAIN, 13));
		teamHomePanel.add(tLocation, 0);
		
		zone = new JButton();
		zone.setBounds(toLeftSecond, 50, width, height);
		zone.setOpaque(false);
		zone.setContentAreaFilled(false);
		zone.setBorderPainted(false);
		zone.setText("赛区");
		zone.setForeground(Color.GRAY);
		zone.setFont(new Font("微软雅黑",Font.PLAIN, 13));
		teamHomePanel.add(zone, 0);
		
		//TODO
		JLabel tZone = new JLabel();
		tZone.setBounds(toLeftSecond+100, 50, width, height);
		tZone.setOpaque(false);
		tZone.setText(teamInfo.getTeamInfo()[2]);
		tZone.setForeground(Color.WHITE);
		tZone.setFont(new Font("微软雅黑",Font.PLAIN, 13));
		teamHomePanel.add(tZone, 0);
		
		partition = new JButton();
		partition.setBounds(toLeftSecond, 100, width, height);
		partition.setOpaque(false);
		partition.setContentAreaFilled(false);
		partition.setBorderPainted(false);
		partition.setText("分区");
		partition.setForeground(Color.GRAY);
		partition.setFont(new Font("微软雅黑",Font.PLAIN, 13));
		teamHomePanel.add(partition, 0);
		
		//TODO
		JLabel tPartition = new JLabel();
		tPartition.setBounds(toLeftSecond+100, 100, width, height);
		tPartition.setOpaque(false);
		tPartition.setText(teamInfo.getTeamInfo()[3]);
		tPartition.setForeground(Color.WHITE);
		tPartition.setFont(new Font("微软雅黑",Font.PLAIN, 13));
		teamHomePanel.add(tPartition, 0);
		
		homeCourt = new JButton();
		homeCourt.setBounds(toLeftThird, 50, width, height);
		homeCourt.setOpaque(false);
		homeCourt.setContentAreaFilled(false);
		homeCourt.setBorderPainted(false);
		homeCourt.setText("主场");
		homeCourt.setForeground(Color.GRAY);
		homeCourt.setFont(new Font("微软雅黑",Font.PLAIN, 13));
		teamHomePanel.add(homeCourt, 0);
		
		//TODO
		JLabel tHomeCourt = new JLabel();
		tHomeCourt.setBounds(toLeftThird+100, 50, width, height);
		tHomeCourt.setOpaque(false);
		tHomeCourt.setText(teamInfo.getTeamInfo()[4]);
		tHomeCourt.setForeground(Color.WHITE);
		tHomeCourt.setFont(new Font("微软雅黑",Font.PLAIN, 13));
		teamHomePanel.add(tHomeCourt, 0);
		
		settingTime = new JButton();
		settingTime.setBounds(toLeftThird, 100, width, height);
		settingTime.setOpaque(false);
		settingTime.setContentAreaFilled(false);
		settingTime.setBorderPainted(false);
		settingTime.setText("建立时间");
		settingTime.setForeground(Color.GRAY);
		settingTime.setFont(new Font("微软雅黑",Font.PLAIN, 13));
		teamHomePanel.add(settingTime, 0);
		
		//TODO
		JLabel tSettingTime = new JLabel();
		tSettingTime.setBounds(toLeftThird+100, 100, width, height);
		tSettingTime.setOpaque(false);
		tSettingTime.setText(teamInfo.getTeamInfo()[5]);
		tSettingTime.setForeground(Color.WHITE);
		tSettingTime.setFont(new Font("微软雅黑",Font.PLAIN, 13));
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
	public JScrollPane initPTable(Object[][] columnPValues, String[] columnName_Player){
		
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
	public JScrollPane initTTable(Object[][] columnTValues, String[] columnName_Team){
		
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
	public JScrollPane initRMTable(Object[][] columnRMValues, String[] columnName_RM){
		
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
	public JScrollPane initAMTable(Object[][] columnAMValues, String[] columnName_AM){
		
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
			ArrayList<String> teamPlayerInfoList=tbl.getPlayerNamesOfTeam(teamTempID);
			
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
			ArrayList<TeamAllVO> teamAllDataList = new ArrayList<TeamAllVO>();
			teamAllDataList = tbl.getTeamAll();
			ArrayList<TeamAverageVO> teamAverageDataList = new ArrayList<TeamAverageVO>();
			teamAverageDataList = tbl.getTeamAverage();
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
						columnTValues[i][1] = teamAllDataList.get(i).getMatchNum();
						columnTValues[i][2] = teamAllDataList.get(i).getTeamData()[0];
						columnTValues[i][3] = teamAllDataList.get(i).getTeamData()[1];
						columnTValues[i][4] = teamAllDataList.get(i).getTeamData()[2];
						columnTValues[i][5] = teamAllDataList.get(i).getTeamData()[3];
						columnTValues[i][6] = teamAllDataList.get(i).getTeamData()[4];
						columnTValues[i][7] = teamAllDataList.get(i).getTeamData()[5];
						columnTValues[i][8] = teamAllDataList.get(i).getTeamData()[6];
						columnTValues[i][9] = teamAllDataList.get(i).getTeamData()[7];
						columnTValues[i][10] = teamAllDataList.get(i).getTeamData()[8];
						columnTValues[i][11] = teamAllDataList.get(i).getTeamData()[9];
						columnTValues[i][12] = teamAllDataList.get(i).getTeamData()[10];
						columnTValues[i][13] = teamAllDataList.get(i).getTeamData()[11];
						columnTValues[i][14] = teamAllDataList.get(i).getTeamData()[12];
						columnTValues[i][15] = teamAllDataList.get(i).getTeamData()[13];
						columnTValues[i][16] = teamAllDataList.get(i).getTeamData()[14];
						columnTValues[i][17] = teamAllDataList.get(i).getTeamData()[15];
						columnTValues[i][18] = teamAllDataList.get(i).getTeamData()[16];
						columnTValues[i][19] = teamAllDataList.get(i).getTeamData()[17];
						columnTValues[i][20] = teamAllDataList.get(i).getTeamData()[18];
						columnTValues[i][21] = teamAllDataList.get(i).getTeamData()[19];
						columnTValues[i][22] = teamAllDataList.get(i).getTeamData()[20];
						columnTValues[i][23] = teamAllDataList.get(i).getTeamData()[21];
						columnTValues[i][24] = teamAllDataList.get(i).getTeamData()[22];
						columnTValues[i][25] = teamAllDataList.get(i).getTeamData()[23];
						columnTValues[i][26] = teamAllDataList.get(i).getTeamData()[24];
					} else {
						columnTValues[i][0] = "场均";
						columnTValues[i][1] = teamAverageDataList.get(i).getMatchNum();
						columnTValues[i][2] = teamAverageDataList.get(i).getTeamData()[0];
						columnTValues[i][3] = teamAverageDataList.get(i).getTeamData()[1];
						columnTValues[i][4] = teamAverageDataList.get(i).getTeamData()[2];
						columnTValues[i][5] = teamAverageDataList.get(i).getTeamData()[3];
						columnTValues[i][6] = teamAverageDataList.get(i).getTeamData()[4];
						columnTValues[i][7] = teamAverageDataList.get(i).getTeamData()[5];
						columnTValues[i][8] = teamAverageDataList.get(i).getTeamData()[6];
						columnTValues[i][9] = teamAverageDataList.get(i).getTeamData()[7];
						columnTValues[i][10] = teamAverageDataList.get(i).getTeamData()[8];
						columnTValues[i][11] = teamAverageDataList.get(i).getTeamData()[9];
						columnTValues[i][12] = teamAverageDataList.get(i).getTeamData()[10];
						columnTValues[i][13] = teamAverageDataList.get(i).getTeamData()[11];
						columnTValues[i][14] = teamAverageDataList.get(i).getTeamData()[12];
						columnTValues[i][15] = teamAverageDataList.get(i).getTeamData()[13];
						columnTValues[i][16] = teamAverageDataList.get(i).getTeamData()[14];
						columnTValues[i][17] = teamAverageDataList.get(i).getTeamData()[15];
						columnTValues[i][18] = teamAverageDataList.get(i).getTeamData()[16];
						columnTValues[i][19] = teamAverageDataList.get(i).getTeamData()[17];
						columnTValues[i][20] = teamAverageDataList.get(i).getTeamData()[18];
						columnTValues[i][21] = teamAverageDataList.get(i).getTeamData()[19];
						columnTValues[i][22] = teamAverageDataList.get(i).getTeamData()[20];
						columnTValues[i][23] = teamAverageDataList.get(i).getTeamData()[21];
						columnTValues[i][24] = teamAverageDataList.get(i).getTeamData()[22];
						columnTValues[i][25] = teamAverageDataList.get(i).getTeamData()[23];
						columnTValues[i][26] = teamAverageDataList.get(i).getTeamData()[24];
					}		
				}
			PlayWave.startClickSound();
			TablePanel.removeAll();		
	        TablePanel.add(initTTable(columnTValues, columnName_Team), 0);
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
			MatchBL mbl = new MatchBL_Impl();
			ArrayList<MatchVO> teamMatch = new ArrayList<MatchVO>();
			teamMatch = mbl.getRecentMatchByTeam(teamTempID);
			String[] columnName_RM = new String[] { "比赛名称","时间", "对手", "比分" };
			Object[][] columnRMValues = new Object[teamMatch.size()][columnName_RM.length];
			for (int i = 0; i < teamMatch.size(); i++) {
				columnRMValues[i][0] = teamMatch.get(i).getName();
				columnRMValues[i][1] = teamMatch.get(i).getTime();
				if (teamTempID.equals(teamMatch.get(i).getTeam1())) {
					columnRMValues[i][2] = teamMatch.get(i).getTeam2();
				} else {
					columnRMValues[i][2] = teamMatch.get(i).getTeam1();
				}		
				columnRMValues[i][3] = teamMatch.get(i).getPointer();
			}
			PlayWave.startClickSound();
			TablePanel.removeAll();		
	        TablePanel.add(initRMTable(columnRMValues, columnName_RM), 0);
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
			MatchBL mbl = new MatchBL_Impl();
			ArrayList<MatchVO> teamMatch = new ArrayList<MatchVO>();
			teamMatch = mbl.getMatchByTeam(teamTempID);
			String[] columnName_AM = new String[] { "比赛名称", "时间", "比分", "对手" };
			Object[][] columnAMValues = new Object[teamMatch.size()][columnName_AM.length];
			for (int i = 0; i < teamMatch.size(); i++) {
				columnAMValues[i][0] = teamMatch.get(i).getName();
				columnAMValues[i][1] = teamMatch.get(i).getTime();
				columnAMValues[i][2] = teamMatch.get(i).getPointer();
				if (teamTempID.equals(teamMatch.get(i).getTeam1())) {
					columnAMValues[i][3] = teamMatch.get(i).getTeam2();
				} else {
					columnAMValues[i][3] = teamMatch.get(i).getTeam1();
				}		
			}
			PlayWave.startClickSound();
			TablePanel.removeAll();		
	        TablePanel.add(initAMTable(columnAMValues, columnName_AM), 0);
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
