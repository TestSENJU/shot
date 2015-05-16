package ui.statistic;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;

//import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import sound.PlayWave;
import ui.AllImages;
import ui.DialogPanel;
import ui.IComboBox;
import ui.IScrollBarUI;
//import ui.MyDialog;
//import ui.MyDialog.DialogWindow;
import ui.MyStringTable;
import ui.MyTable;
import ui.player.PlayerHomePanel;
import ui.team.TeamHomePanel;
import vo.PlayerAllVO;
import vo.PlayerAverageVO;
import vo.PlayerBasicVO;
import vo.TeamAllVO;
import vo.TeamAverageVO;
import BL.PlayerBL;
import BL.PlayerBL_Impl;
import BL.TeamBL;
import BL.TeamBL_Impl;

public class StatisticPanel {
	/**
	 * @param 展示球员和球队的比赛数据的界面
	 * @author forIris
	 * @version  June 12, 2015 11:41:31 AM
	 * **/
	private JPanel statisticPanel;
	public static JPanel tablePanel;
	private JButton playerAverage;
	private JButton playerAll;
	private JButton teamAverage;
	private JButton teamAll;
	private JScrollPane pScrollPane;
	private JScrollPane tScrollPane;
	private MyTable pDataTable;
	private MyStringTable tDataTable;
	//
	protected DialogPanel dPanel;
	//private DialogWindow dw;
	protected JButton sure;
	protected JButton cancel;
	protected JLabel choose;
	protected JRadioButton ascend;
	protected JRadioButton descend;
	//private ButtonGroup group;
	public static String AorD = "";
	public static String tempTableButton = "";
	public static String playerCondition = "";
	public static String teamCondition = "";
	//tool panel
	public static JPanel toolPanel;
	private JComboBox<Object> position;
	private JComboBox<Object> league;
	private JComboBox<Object> sortBy;
	private JButton sureTool;
	//TODO
	PlayerBL pbl = new PlayerBL_Impl();
	TeamBL tbl = new TeamBL_Impl();
	
	public JPanel init(){
		statisticPanel = new JPanel();
		statisticPanel.setOpaque(false);
		statisticPanel.setBounds(130, 0, 1000-130, 700);
		statisticPanel.setLayout(null);
		
		toolPanel = new JPanel();
		toolPanel.setOpaque(false);
		toolPanel.setBounds(0, 70, 1000-130, 80);
		toolPanel.setLayout(null);
		statisticPanel.add(toolPanel, 0);
		
		tablePanel = new JPanel();
		tablePanel.setOpaque(false);
		tablePanel.setBounds(0, 150, 1000-130, 530);
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
	
	public void initToolPanel(){
		//0,70,1000-130,100
		//combo
		JLabel po = new JLabel();
		po.setOpaque(false);
		po.setText("筛选-> 球员位置");
		po.setBounds(30, 20, 100, 30);
		po.setFont(new Font("微软雅黑",Font.PLAIN,13));
		po.setForeground(Color.WHITE);
		toolPanel.add(po, 0);
		
		Object[] poInfo = {"前锋","中锋","后卫"};
		position = new IComboBox(poInfo);
		position.setBounds(140, 20, 100, 30);
		position.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
				System.out.println(position.getSelectedItem());
			}
		});
		toolPanel.add(position, 0);
		
		JLabel le = new JLabel();
		le.setOpaque(false);
		le.setText("球员联盟");
		le.setBounds(250, 20, 70, 30);
		le.setFont(new Font("微软雅黑",Font.PLAIN,13));
		le.setForeground(Color.WHITE);
		toolPanel.add(le, 0);
		
		Object[] leInfo = {"东部东南分区","东部中央分区","东部大西洋分区",
				"西部太平洋分区","西部西北分区","西部西南分区"};
		league = new IComboBox(leInfo);
		league.setBounds(330, 20, 120, 30);
		league.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println(league.getSelectedItem());
			}
		});
		toolPanel.add(league, 0);
		
		JLabel sb = new JLabel();
		sb.setOpaque(false);
		sb.setText("筛选条件");
		sb.setBounds(460, 20, 70, 30);
		sb.setFont(new Font("微软雅黑",Font.PLAIN,13));
		sb.setForeground(Color.WHITE);
		toolPanel.add(sb, 0);
		
		Object[] sbInfo = {"得分","篮板","助攻","得分/篮板/助攻",
				"盖帽","抢断","犯规","失误","分钟","效率","投篮",
				"三分","罚球","两双"};
		 
		sortBy = new IComboBox(sbInfo);
		sortBy.setBounds(540, 20, 120, 30);
		sortBy.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println(sortBy.getSelectedItem());
			}
		});
		toolPanel.add(sortBy, 0);
		
		sureTool = new JButton();
		sureTool.setOpaque(false);
		sureTool.setContentAreaFilled(false);
		sureTool.setBorderPainted(false);
		sureTool.setIcon(AllImages.IMG_SURE);
		sureTool.setBounds(680, 20, 80, 30);
		sureTool.addMouseListener(new SureToolListener());
		toolPanel.add(sureTool, 0);
	}
	
	public JScrollPane playerDataTable(Object[][] columnValues, String[] columnName){
		pDataTable = new MyTable(columnValues, columnName);
		pDataTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		pDataTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		pDataTable.setForeground(Color.white);
		pDataTable.setRowHeight(50);
		pDataTable.setBounds(40, 0, 1000-130-100, 500);
		pDataTable.setOpaque(false);
		
		pDataTable.addMouseListener(new pTableListener());
		pDataTable.getTableHeader().addMouseListener(new pTableHeaderListener());

		pDataTable.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		
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
		
		tDataTable.addMouseListener(new tTableListener());
		tDataTable.getTableHeader().addMouseListener(new tTableHeaderListener());

		tDataTable.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		
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
	public int judgeADNum(String condition){
		int result=-1;
		if (tempTableButton.equals("playerAverage") || tempTableButton.equals("playerAll")) {
			
			if (condition.equals("球员名称")) {
				result = 27;
			} else if (condition.equals("参赛场数")) {
				result = 25;
			} else if (condition.equals("先发场数")) {
				result = 26;
			} else if (condition.equals("在场时间")) {
				result = 24;
			} else if (condition.equals("篮板数")) {
				result = 0;
			} else if (condition.equals("助攻数")) {
				result = 1;
			} else if (condition.equals("投篮命中率")) {
				result = 2;
				
			} else if (condition.equals("三分命中率")) {
				result = 3;
			} else if (condition.equals("罚球命中率")) {
				result = 4;
			} else if (condition.equals("进攻数")) {
				result = 5;
			} else if (condition.equals("防守数")) {
				result = 6;
			} else if (condition.equals("抢断数")) {
				result = 7;
			} else if (condition.equals("盖帽数")) {
				result = 8;
			} else if (condition.equals("失误数")) {
				result = 9;
			} else if (condition.equals("犯规数")) {
				result = 10;
			} else if (condition.equals("得分")) {
				result = 11;
			} else if (condition.equals("效率")) {
				result = 12;
			} else if (condition.equals("GmSc效率值")) {
				result = 13;
			} else if (condition.equals("真实命中数")) {
				result = 14;
			} else if (condition.equals("投篮效率")) {
				result = 15;
			} else if (condition.equals("篮板率")) {
				result = 16;
			} else if (condition.equals("进攻篮板率")) {
				result = 17;
			} else if (condition.equals("防守篮板率")) {
				result = 18;
			} else if (condition.equals("助攻率")) {
				result = 19;
			} else if (condition.equals("抢断率")) {
				result = 20;
			} else if (condition.equals("盖帽率")) {
				result = 21;
			} else if (condition.equals("失误率")) {
				result = 22;
			} else if (condition.equals("使用率")) {
				result = 23;
			} else {
				
			}
		} else if (tempTableButton.equals("teamAverage") || tempTableButton.equals("teamAll")) {
		
			if (condition.equals("比赛场数")) {
				result = 25;
			} else if (condition.equals("投篮命中数")) {
				result = 0;
			} else if (condition.equals("投篮出手次数")) {
				result = 1;
			} else if (condition.equals("三分命中数")) {
				result = 2;
			} else if (condition.equals("三分出手数")) {
				result = 3;
			} else if (condition.equals("罚球命中数")) {
				result = 4;
			} else if (condition.equals("罚球出手数")) {
				result = 5;
			} else if (condition.equals("进攻篮板数")) {
				result = 6;
			} else if (condition.equals("防守篮板数")) {
				result = 7;
			} else if (condition.equals("篮板数")) {
				result = 8;
			} else if (condition.equals("助攻数")) {
				result = 9;
			} else if (condition.equals("抢断数")) {
				result = 10;
			} else if (condition.equals("盖帽数")) {
				result = 11;
			} else if (condition.equals("失误数")) {
				result = 12;
			} else if (condition.equals("犯规数")) {
				result = 13;
			} else if (condition.equals("比赛得分")) {
				result = 14;
			} else if (condition.equals("投篮命中率")) {
				result = 15;
			} else if (condition.equals("三分命中率")) {
				result = 16;
			} else if (condition.equals("罚球命中率")) {
				result = 17;
			} else if (condition.equals("胜率")) {
				result = 18;
			} else if (condition.equals("进攻回合")) {
				result = 19;
			} else if (condition.equals("进攻效率")) {
				result = 20;
			} else if (condition.equals("防守效率")) {
				result = 21;
			} else if (condition.equals("篮板效率")) {
				result = 22;
			} else if (condition.equals("抢断效率")) {
				result = 23;
			} else if (condition.equals("助攻率")) {
				result = 24;
			} else {
				
			}
		} else {
			System.out.println("StatisticPanel_TableHeaderListener_tempTableButton_is_null.");
		}
		return result;
	}
	
	//TODO 
	class PlayerAverageListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			tempTableButton = "playerAverage";
			ArrayList<PlayerAverageVO> playerAverageData = new ArrayList<PlayerAverageVO>();
			playerAverageData = pbl.getPlayerAverage();
			PlayWave.startClickSound();
			tablePanel.removeAll();
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
			tablePanel.add(playerDataTable(columnValues, columnName));
			tablePanel.repaint();
			initToolPanel();
			toolPanel.repaint();
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
			tempTableButton = "playerAll";
			ArrayList<PlayerAllVO> playerAllData = new ArrayList<PlayerAllVO>();
			playerAllData = pbl.getPlayerAll();
			String[] columnName = new String[] {"头像","球员名称","所属球队","参赛场数", "先发场数",
					"篮板数", "助攻数", "在场时间","投篮命中率",
					"三分命中率","罚球命中率","进攻数","防守数" ,
					"抢断数","盖帽数","失误数" ,"犯规数",
					"得分","效率" ,"GmSc效率值","真实命中数","投篮效率",
					"篮板率","进攻篮板率","防守篮板率","助攻率",
					"抢断率","盖帽率" ,
					"失误率","使用率" };
			Object[][] columnValues = new Object[playerAllData.size()][columnName.length];
			for (int i = 0; i < playerAllData.size(); i++) {
				File img = new File("playerImg/portrait/"+playerAllData.get(i).getPlayerName()+".png");
				if (img.exists()) {
					columnValues[i][0] = new ImageIcon("playerImg/portrait/"+playerAllData.get(i).getPlayerName()+".png");
				} else {
					columnValues[i][0] = AllImages.IMG_DEFAULTPLAYER;
				}
				columnValues[i][1] = playerAllData.get(i).getPlayerName();
				columnValues[i][2] = playerAllData.get(i).getTeamList();
				columnValues[i][3] = playerAllData.get(i).getCompeteNum();
				columnValues[i][4] = playerAllData.get(i).getOffensiveNum();
				columnValues[i][5] = playerAllData.get(i).getPlayerData()[0];
				columnValues[i][6] = playerAllData.get(i).getPlayerData()[1];
				columnValues[i][7] = playerAllData.get(i).getPlayingTime();
				columnValues[i][8] = playerAllData.get(i).getPlayerData()[2];
				columnValues[i][9] = playerAllData.get(i).getPlayerData()[3];
				columnValues[i][10] = playerAllData.get(i).getPlayerData()[4];
				columnValues[i][11] = playerAllData.get(i).getPlayerData()[5];
				columnValues[i][12] = playerAllData.get(i).getPlayerData()[6];
				columnValues[i][13] = playerAllData.get(i).getPlayerData()[7];
				columnValues[i][14] = playerAllData.get(i).getPlayerData()[8];
				columnValues[i][15] = playerAllData.get(i).getPlayerData()[9];
				columnValues[i][16] = playerAllData.get(i).getPlayerData()[10];
				columnValues[i][17] = playerAllData.get(i).getPlayerData()[11];
				columnValues[i][18] = playerAllData.get(i).getPlayerData()[12];
				columnValues[i][19] = playerAllData.get(i).getPlayerData()[13];
				columnValues[i][20] = playerAllData.get(i).getPlayerData()[14];
				columnValues[i][21] = playerAllData.get(i).getPlayerData()[15];
				columnValues[i][22] = playerAllData.get(i).getPlayerData()[16];
				columnValues[i][23] = playerAllData.get(i).getPlayerData()[17];
				columnValues[i][24] = playerAllData.get(i).getPlayerData()[18];
				columnValues[i][25] = playerAllData.get(i).getPlayerData()[19];
				columnValues[i][26] = playerAllData.get(i).getPlayerData()[20];
				columnValues[i][27] = playerAllData.get(i).getPlayerData()[21];
				columnValues[i][28] = playerAllData.get(i).getPlayerData()[22];
				columnValues[i][29] = playerAllData.get(i).getPlayerData()[23];
			}
			PlayWave.startClickSound();
			tablePanel.removeAll();
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
			tempTableButton = "teamAverage";
			ArrayList<TeamAverageVO> teamAverageData = new ArrayList<TeamAverageVO>();
			teamAverageData = tbl.getTeamAverage();
			String[] columnName = new String[] {"球队名称", "缩写名","比赛场数", "投篮命中数", 
    		"投篮出手次数", "三分命中数", "三分出手数","罚球命中数","罚球出手数",
    		"进攻篮板数","防守篮板数","篮板数",
    		"助攻数","抢断数","盖帽数","失误数",
    		"犯规数","比赛得分","投篮命中率","三分命中率",
    		"罚球命中率","胜率","进攻回合","进攻效率",
    		"防守效率","篮板效率","抢断效率","助攻率"};
			Object[][] columnValues = new Object[30][columnName.length];
			for (int i = 0; i < 30; i++) {
				columnValues[i][0] = teamAverageData.get(i).getTeamNameLong();
				columnValues[i][1] = teamAverageData.get(i).getTeamName();
				columnValues[i][2] = teamAverageData.get(i).getMatchNum();
				columnValues[i][3] = teamAverageData.get(i).getTeamData()[0];
				columnValues[i][4] = teamAverageData.get(i).getTeamData()[1];
				columnValues[i][5] = teamAverageData.get(i).getTeamData()[2];
				columnValues[i][6] = teamAverageData.get(i).getTeamData()[3];
				columnValues[i][7] = teamAverageData.get(i).getTeamData()[4];
				columnValues[i][8] = teamAverageData.get(i).getTeamData()[5];
				columnValues[i][9] = teamAverageData.get(i).getTeamData()[6];
				columnValues[i][10] = teamAverageData.get(i).getTeamData()[7];
				columnValues[i][11] = teamAverageData.get(i).getTeamData()[8];
				columnValues[i][12] = teamAverageData.get(i).getTeamData()[9];
				columnValues[i][13] = teamAverageData.get(i).getTeamData()[10];
				columnValues[i][14] = teamAverageData.get(i).getTeamData()[11];
				columnValues[i][15] = teamAverageData.get(i).getTeamData()[12];
				columnValues[i][16] = teamAverageData.get(i).getTeamData()[13];
				columnValues[i][17] = teamAverageData.get(i).getTeamData()[14];
				columnValues[i][18] = teamAverageData.get(i).getTeamData()[15];
				columnValues[i][19] = teamAverageData.get(i).getTeamData()[16];
				columnValues[i][20] = teamAverageData.get(i).getTeamData()[17];
				columnValues[i][21] = teamAverageData.get(i).getTeamData()[18];
				columnValues[i][22] = teamAverageData.get(i).getTeamData()[19];
				columnValues[i][23] = teamAverageData.get(i).getTeamData()[20];
				columnValues[i][24] = teamAverageData.get(i).getTeamData()[21];
				columnValues[i][25] = teamAverageData.get(i).getTeamData()[22];
				columnValues[i][26] = teamAverageData.get(i).getTeamData()[23];
				columnValues[i][27] = teamAverageData.get(i).getTeamData()[24];
			}
			PlayWave.startClickSound();
			toolPanel.removeAll();
			toolPanel.repaint();
			tablePanel.removeAll();
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
			tempTableButton = "teamAll";
			ArrayList<TeamAllVO> teamAllData = new ArrayList<TeamAllVO>();
			teamAllData = tbl.getTeamAll();
			String[] columnName = new String[] {"球队名称", "缩写名", "比赛场数", "投篮命中数", 
    		"投篮出手次数", "三分命中数", "三分出手数","罚球命中数","罚球出手数",
    		"进攻篮板数","防守篮板数","篮板数",
    		"助攻数","抢断数","盖帽数","失误数",
    		"犯规数","比赛得分","投篮命中率","三分命中率",
    		"罚球命中率","胜率","进攻回合","进攻效率",
    		"防守效率","篮板效率","抢断效率","助攻率"};
			Object[][] columnValues = new Object[30][columnName.length];
			for (int i = 0; i < 30; i++) {
				columnValues[i][0] = teamAllData.get(i).getTeamNameLong();
				columnValues[i][1] = teamAllData.get(i).getTeamName();
				columnValues[i][2] = teamAllData.get(i).getMatchNum();
				columnValues[i][3] = teamAllData.get(i).getTeamData()[0];
				columnValues[i][4] = teamAllData.get(i).getTeamData()[1];
				columnValues[i][5] = teamAllData.get(i).getTeamData()[2];
				columnValues[i][6] = teamAllData.get(i).getTeamData()[3];
				columnValues[i][7] = teamAllData.get(i).getTeamData()[4];
				columnValues[i][8] = teamAllData.get(i).getTeamData()[5];
				columnValues[i][9] = teamAllData.get(i).getTeamData()[6];
				columnValues[i][10] = teamAllData.get(i).getTeamData()[7];
				columnValues[i][11] = teamAllData.get(i).getTeamData()[8];
				columnValues[i][12] = teamAllData.get(i).getTeamData()[9];
				columnValues[i][13] = teamAllData.get(i).getTeamData()[10];
				columnValues[i][14] = teamAllData.get(i).getTeamData()[11];
				columnValues[i][15] = teamAllData.get(i).getTeamData()[12];
				columnValues[i][16] = teamAllData.get(i).getTeamData()[13];
				columnValues[i][17] = teamAllData.get(i).getTeamData()[14];
				columnValues[i][18] = teamAllData.get(i).getTeamData()[15];
				columnValues[i][19] = teamAllData.get(i).getTeamData()[16];
				columnValues[i][20] = teamAllData.get(i).getTeamData()[17];
				columnValues[i][21] = teamAllData.get(i).getTeamData()[18];
				columnValues[i][22] = teamAllData.get(i).getTeamData()[19];
				columnValues[i][23] = teamAllData.get(i).getTeamData()[20];
				columnValues[i][24] = teamAllData.get(i).getTeamData()[21];
				columnValues[i][25] = teamAllData.get(i).getTeamData()[22];
				columnValues[i][26] = teamAllData.get(i).getTeamData()[23];
				columnValues[i][27] = teamAllData.get(i).getTeamData()[24];
			}
			
			PlayWave.startClickSound();
			toolPanel.removeAll();
			toolPanel.repaint();
			tablePanel.removeAll();
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
	class pTableListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			//PlayWave.startClickSound();
			if(e.getClickCount()==2){
				System.out.println(pDataTable.getValueAt(pDataTable.getSelectedRow(), pDataTable.getSelectedColumn()+1));
				if (pDataTable.getSelectedColumn()==0) {
					tablePanel.removeAll();
					statisticPanel.removeAll();
					PlayerHomePanel php = new PlayerHomePanel();
					statisticPanel.add(php.init(pDataTable.getValueAt(pDataTable.getSelectedRow(), pDataTable.getSelectedColumn()+1).toString()));
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
	//
	class pTableHeaderListener implements MouseListener{

		public void mouseClicked(MouseEvent et) {
			/*PlayWave.startClickSound();
			if(et.getClickCount()==2){
				System.out.println(pDataTable.getColumnName(pDataTable.getTableHeader().columnAtPoint(et.getPoint())));
				playerCondition = pDataTable.getColumnName(pDataTable.getTableHeader().columnAtPoint(et.getPoint()));
				// TODO DIALOG------------------------------------------------
				dPanel = new DialogPanel(AllImages.IMG_DIALOG_BG);
				dPanel.setLayout(null);
				dPanel.setSize(400, 300);
				//dPanel.setDragable();
				// 设置panel为透明
				dPanel.setOpaque(false);
				// 设置布局管理为绝对布局
				dPanel.setLayout(null);
				// 注册鼠标监听器
				dPanel.addMouseListener(this);
				// 注册鼠标移动监听器
				//dPanel.addMouseMotionListener(this);
				MyDialog pd = new MyDialog();
				dw = pd.init(400, 300, dPanel);
				
				choose = new JLabel();
				choose.setOpaque(false);
				choose.setText("请选择升序 or 降序：");
				choose.setBounds(30, 50, 200, 30);
				choose.setFont(new Font("微软雅黑", Font.PLAIN, 18));
				choose.setForeground(Color.WHITE);
				dPanel.add(choose, 0);
				
				ascend = new JRadioButton("升序", AllImages.IMG_RIGHT_RADIO, true);
				ascend.setBounds(90, 140, 100, 25);
				ascend.setOpaque(false);
				ascend.setForeground(Color.WHITE);
				ascend.setFont(new Font("微软雅黑", Font.PLAIN, 15));
				ascend.addItemListener(new ItemListener());
				dPanel.add(ascend, 0);
				
				descend = new JRadioButton("降序",AllImages.IMG_FALSE_RADIO, false);
				descend.setBounds(240, 140, 100, 25);
				descend.setForeground(Color.WHITE);
				descend.setOpaque(false);
				descend.setFont(new Font("微软雅黑", Font.PLAIN, 15));
				descend.addItemListener(new ItemListener());
				dPanel.add(descend, 0);
				
				group = new ButtonGroup();
				group.add(ascend);
				group.add(descend);
				
				sure = new JButton();
				sure.setBounds(100, 220, 80, 30);
				sure.setContentAreaFilled(false);
				sure.setBorderPainted(false);
				sure.setOpaque(false);
				sure.setIcon(AllImages.IMG_SURE);
				sure.addMouseListener(new MouseListener(){
					public void mouseClicked(MouseEvent e) {
						// TODO 
						PlayWave.startClickSound();
						System.out.println(ascend.isSelected());
						if (ascend.isSelected()) {
							AorD = "ascend";
							if (tempTableButton.equals("playerAll")){
								
								ArrayList<PlayerAllVO> playerAllData = pbl.getPlayerAllRankingByNumRaising(judgeADNum(playerCondition));
								String[] columnName = new String[] {"头像","球员名称","所属球队","参赛场数", "先发场数",
										"篮板数", "助攻数", "在场时间","投篮命中率",
										"三分命中率","罚球命中率","进攻数","防守数" ,
										"抢断数","盖帽数","失误数" ,"犯规数",
										"得分","效率" ,"GmSc效率值","真实命中数","投篮效率",
										"篮板率","进攻篮板率","防守篮板率","助攻率",
										"抢断率","盖帽率" ,
										"失误率","使用率" };
								Object[][] columnValues = new Object[playerAllData.size()][columnName.length];
								for (int i = 0; i < playerAllData.size(); i++) {
									File img = new File("playerImg/portrait/"+playerAllData.get(i).getPlayerName()+".png");
									if (img.exists()) {
										columnValues[i][0] = new ImageIcon("playerImg/portrait/"+playerAllData.get(i).getPlayerName()+".png");
									} else {
										columnValues[i][0] = AllImages.IMG_DEFAULTPLAYER;
									}
									
									columnValues[i][1] = playerAllData.get(i).getPlayerName();
									columnValues[i][2] = playerAllData.get(i).getTeamList();
									columnValues[i][3] = playerAllData.get(i).getCompeteNum();
									columnValues[i][4] = playerAllData.get(i).getOffensiveNum();
									columnValues[i][5] = playerAllData.get(i).getPlayerData()[0];
									columnValues[i][6] = playerAllData.get(i).getPlayerData()[1];
									columnValues[i][7] = playerAllData.get(i).getPlayingTime();
									columnValues[i][8] = playerAllData.get(i).getPlayerData()[2];
									columnValues[i][9] = playerAllData.get(i).getPlayerData()[3];
									columnValues[i][10] = playerAllData.get(i).getPlayerData()[4];
									columnValues[i][11] = playerAllData.get(i).getPlayerData()[5];
									columnValues[i][12] = playerAllData.get(i).getPlayerData()[6];
									columnValues[i][13] = playerAllData.get(i).getPlayerData()[7];
									columnValues[i][14] = playerAllData.get(i).getPlayerData()[8];
									columnValues[i][15] = playerAllData.get(i).getPlayerData()[9];
									columnValues[i][16] = playerAllData.get(i).getPlayerData()[10];
									columnValues[i][17] = playerAllData.get(i).getPlayerData()[11];
									columnValues[i][18] = playerAllData.get(i).getPlayerData()[12];
									columnValues[i][19] = playerAllData.get(i).getPlayerData()[13];
									columnValues[i][20] = playerAllData.get(i).getPlayerData()[14];
									columnValues[i][21] = playerAllData.get(i).getPlayerData()[15];
									columnValues[i][22] = playerAllData.get(i).getPlayerData()[16];
									columnValues[i][23] = playerAllData.get(i).getPlayerData()[17];
									columnValues[i][24] = playerAllData.get(i).getPlayerData()[18];
									columnValues[i][25] = playerAllData.get(i).getPlayerData()[19];
									columnValues[i][26] = playerAllData.get(i).getPlayerData()[20];
									columnValues[i][27] = playerAllData.get(i).getPlayerData()[21];
									columnValues[i][28] = playerAllData.get(i).getPlayerData()[22];
									columnValues[i][29] = playerAllData.get(i).getPlayerData()[23];
								}
								tablePanel.removeAll();
								tablePanel.add(playerDataTable(columnValues, columnName));
								tablePanel.repaint();
								initToolPanel();
								toolPanel.repaint();
							} else if (tempTableButton.equals("playerAverage")){
								ArrayList<PlayerAverageVO> playerAverageData = pbl.getPlayerAvergaeRankingByNumRaising(judgeADNum(playerCondition));
								tablePanel.removeAll();
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
								tablePanel.add(playerDataTable(columnValues, columnName));
								tablePanel.repaint();
								initToolPanel();
								toolPanel.repaint();
							} else {
								
							}
							
						} else if(descend.isSelected()){
							AorD = "descend";
							if (tempTableButton.equals("playerAll")){
							
								ArrayList<PlayerAllVO> playerAllData = pbl.getPlayerAllRankingByNumDeclining(judgeADNum(playerCondition));
								String[] columnName = new String[] {"头像","球员名称","所属球队","参赛场数", "先发场数",
										"篮板数", "助攻数", "在场时间","投篮命中率",
										"三分命中率","罚球命中率","进攻数","防守数" ,
										"抢断数","盖帽数","失误数" ,"犯规数",
										"得分","效率" ,"GmSc效率值","真实命中数","投篮效率",
										"篮板率","进攻篮板率","防守篮板率","助攻率",
										"抢断率","盖帽率" ,
										"失误率","使用率" };
								Object[][] columnValues = new Object[playerAllData.size()][columnName.length];
								for (int i = 0; i < playerAllData.size(); i++) {
									columnValues[i][0] = new ImageIcon("playerImg/portrait/"+playerAllData.get(i).getPlayerName()+".png");
									columnValues[i][1] = playerAllData.get(i).getPlayerName();
									columnValues[i][2] = playerAllData.get(i).getTeamList();
									columnValues[i][3] = playerAllData.get(i).getCompeteNum();
									columnValues[i][4] = playerAllData.get(i).getOffensiveNum();
									columnValues[i][5] = playerAllData.get(i).getPlayerData()[0];
									columnValues[i][6] = playerAllData.get(i).getPlayerData()[1];
									columnValues[i][7] = playerAllData.get(i).getPlayingTime();
									columnValues[i][8] = playerAllData.get(i).getPlayerData()[2];
									columnValues[i][9] = playerAllData.get(i).getPlayerData()[3];
									columnValues[i][10] = playerAllData.get(i).getPlayerData()[4];
									columnValues[i][11] = playerAllData.get(i).getPlayerData()[5];
									columnValues[i][12] = playerAllData.get(i).getPlayerData()[6];
									columnValues[i][13] = playerAllData.get(i).getPlayerData()[7];
									columnValues[i][14] = playerAllData.get(i).getPlayerData()[8];
									columnValues[i][15] = playerAllData.get(i).getPlayerData()[9];
									columnValues[i][16] = playerAllData.get(i).getPlayerData()[10];
									columnValues[i][17] = playerAllData.get(i).getPlayerData()[11];
									columnValues[i][18] = playerAllData.get(i).getPlayerData()[12];
									columnValues[i][19] = playerAllData.get(i).getPlayerData()[13];
									columnValues[i][20] = playerAllData.get(i).getPlayerData()[14];
									columnValues[i][21] = playerAllData.get(i).getPlayerData()[15];
									columnValues[i][22] = playerAllData.get(i).getPlayerData()[16];
									columnValues[i][23] = playerAllData.get(i).getPlayerData()[17];
									columnValues[i][24] = playerAllData.get(i).getPlayerData()[18];
									columnValues[i][25] = playerAllData.get(i).getPlayerData()[19];
									columnValues[i][26] = playerAllData.get(i).getPlayerData()[20];
									columnValues[i][27] = playerAllData.get(i).getPlayerData()[21];
									columnValues[i][28] = playerAllData.get(i).getPlayerData()[22];
									columnValues[i][29] = playerAllData.get(i).getPlayerData()[23];
								}
								tablePanel.removeAll();
								tablePanel.add(playerDataTable(columnValues, columnName));
								tablePanel.repaint();
								initToolPanel();
								toolPanel.repaint();
							} else if (tempTableButton.equals("playerAverage")){
								ArrayList<PlayerAverageVO> playerAverageData = pbl.getPlayerAvergaeRankingByNumDeclining(judgeADNum(playerCondition));
								tablePanel.removeAll();
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
									columnValues[i][0] = new ImageIcon("playerImg/portrait/"+playerAverageData.get(i).getName()+".png");
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
								tablePanel.add(playerDataTable(columnValues, columnName));
								tablePanel.repaint();
								initToolPanel();
								toolPanel.repaint();
							} else {
								
							}
						} else {
							AorD = "0";
						}
						dw.dispose();
					}
					public void mouseEntered(MouseEvent e) {
					}
					public void mouseExited(MouseEvent e) {						
					}
					public void mousePressed(MouseEvent e) {				
					}
					public void mouseReleased(MouseEvent arg0) {					
					}
				});
				dPanel.add(sure, 0);
				
				cancel = new JButton();
				cancel.setBounds(220, 220, 80, 30);
				cancel.setContentAreaFilled(false);
				cancel.setBorderPainted(false);
				cancel.setIcon(AllImages.IMG_CANCEL);
				cancel.setOpaque(false);
				cancel.addMouseListener(new MouseListener(){

					public void mouseClicked(MouseEvent arg0) {
						PlayWave.startClickSound();
						dw.dispose();
					}

					public void mouseEntered(MouseEvent arg0) {
					}

					public void mouseExited(MouseEvent arg0) {
						
					}

					public void mousePressed(MouseEvent arg0) {
				
					}

					public void mouseReleased(MouseEvent arg0) {
					
					}
					
				});
				dPanel.add(cancel, 0);
	
			}*/
		}
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
		class ItemListener implements java.awt.event.ItemListener{

			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				 if (e.getSource() == ascend) {
			            ascend.setIcon(AllImages.IMG_RIGHT_RADIO);
			            descend.setIcon(AllImages.IMG_FALSE_RADIO);
			        } else {
			        	descend.setIcon(AllImages.IMG_RIGHT_RADIO);
				        ascend.setIcon(AllImages.IMG_FALSE_RADIO);
			        }
			}
			
		}
	}
	//TODO
	class tTableListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			if(e.getClickCount()==2){
				System.out.println(tDataTable.getValueAt(tDataTable.getSelectedRow(), tDataTable.getSelectedColumn()+1));
				if (tDataTable.getSelectedColumn()==0) {
					tablePanel.removeAll();
					statisticPanel.removeAll();
					TeamHomePanel thp = new TeamHomePanel();
					statisticPanel.add(thp.init(tDataTable.getValueAt(tDataTable.getSelectedRow(), tDataTable.getSelectedColumn()+1).toString()));
					
					ArrayList<String> teamPlayerInfoList = tbl.getPlayerNamesOfTeam(tDataTable.getValueAt(tDataTable.getSelectedRow(), tDataTable.getSelectedColumn()+1).toString());
					
					String[] columnName_Player = new String[] { "球员头像", "球员名称", "球衣号码", "球员位置", "身高","体重","生日","年龄","球龄","毕业学校" };
					Object[][] columnPValues = new Object[teamPlayerInfoList.size()][columnName_Player.length];
					for (int i = 0; i < teamPlayerInfoList.size(); i++) {
						PlayerBasicVO pbvo = new PlayerBasicVO(teamPlayerInfoList.get(i));
						pbvo = pbl.getPlayerBasicByName(teamPlayerInfoList.get(i));
						columnPValues[i][0] = new ImageIcon("playerImg/portrait/"+teamPlayerInfoList.get(i)+".png");
						columnPValues[i][1] = teamPlayerInfoList.get(i);
						if (pbvo==null) {
							columnPValues[i][2] = "null";
							columnPValues[i][3] = "null";
							columnPValues[i][4] = "null";
							columnPValues[i][5] = "null";
							columnPValues[i][6] = "null";
							columnPValues[i][7] = "null";
							columnPValues[i][8] = "null";
							columnPValues[i][9] = "null";
						} else {
							columnPValues[i][2] = pbvo.getBasicInfo()[0];
							columnPValues[i][3] = pbvo.getBasicInfo()[1];
							columnPValues[i][4] = pbvo.getBasicInfo()[2];
							columnPValues[i][5] = pbvo.getBasicInfo()[3];
							columnPValues[i][6] = pbvo.getBasicInfo()[4];
							columnPValues[i][7] = pbvo.getBasicInfo()[5];
							columnPValues[i][8] = pbvo.getBasicInfo()[6];
							columnPValues[i][9] = pbvo.getBasicInfo()[7];
						}	
					}
					TeamHomePanel.TablePanel.removeAll();		
					TeamHomePanel.TablePanel.add(thp.initPTable(columnPValues, columnName_Player), 0);
					TeamHomePanel.TablePanel.repaint();
					
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
		class tTableHeaderListener implements MouseListener{

			public void mouseClicked(MouseEvent e) {
				/*PlayWave.startClickSound();
				if(e.getClickCount()==2){
					System.out.println(tDataTable.getColumnName(tDataTable.getTableHeader().columnAtPoint(e.getPoint())));
					teamCondition = tDataTable.getColumnName(tDataTable.getTableHeader().columnAtPoint(e.getPoint()));
					// TODO DIALOG------------------------------------------------
					dPanel = new DialogPanel(AllImages.IMG_DIALOG_BG);
					dPanel.setLayout(null);
					dPanel.setSize(400, 300);
					//dPanel.setDragable();
					// 设置panel为透明
					dPanel.setOpaque(false);
					// 设置布局管理为绝对布局
					dPanel.setLayout(null);
					// 注册鼠标监听器
					dPanel.addMouseListener(this);
					// 注册鼠标移动监听器
					//dPanel.addMouseMotionListener(this);
					MyDialog pd = new MyDialog();
					dw = pd.init(400, 300, dPanel);
					
					choose = new JLabel();
					choose.setOpaque(false);
					choose.setText("请选择升序 or 降序：");
					choose.setBounds(30, 50, 200, 30);
					choose.setFont(new Font("微软雅黑", Font.PLAIN, 18));
					choose.setForeground(Color.WHITE);
					dPanel.add(choose, 0);
					
					ascend = new JRadioButton("升序", AllImages.IMG_RIGHT_RADIO, true);
					ascend.setBounds(90, 140, 100, 25);
					ascend.setOpaque(false);
					ascend.setForeground(Color.WHITE);
					ascend.setFont(new Font("微软雅黑", Font.PLAIN, 15));
					ascend.addItemListener(new ItemListener());
					dPanel.add(ascend, 0);
					
					descend = new JRadioButton("降序",AllImages.IMG_FALSE_RADIO, false);
					descend.setBounds(240, 140, 100, 25);
					descend.setForeground(Color.WHITE);
					descend.setOpaque(false);
					descend.setFont(new Font("微软雅黑", Font.PLAIN, 15));
					descend.addItemListener(new ItemListener());
					dPanel.add(descend, 0);
					
					group = new ButtonGroup();
					group.add(ascend);
					group.add(descend);
					
					sure = new JButton();
					sure.setBounds(100, 220, 80, 30);
					sure.setContentAreaFilled(false);
					sure.setBorderPainted(false);
					sure.setOpaque(false);
					sure.setIcon(AllImages.IMG_SURE);
					sure.addMouseListener(new MouseListener(){
						public void mouseClicked(MouseEvent e) {
							// TODO 
							PlayWave.startClickSound();
							System.out.println(ascend.isSelected());
							if (ascend.isSelected()) {
								AorD = "ascend";
								if (tempTableButton.equals("teamAll")) {
									ArrayList<TeamAllVO> teamAllData = tbl.getTeamAllRankingByNumRaising(judgeADNum(teamCondition));
									String[] columnName = new String[] {"球队名称", "比赛场数", "投篮命中数", 
								    		"投篮出手次数", "三分命中数", "三分出手数","罚球命中数","罚球出手数",
								    		"进攻篮板数","防守篮板数","篮板数",
								    		"助攻数","抢断数","盖帽数","失误数",
								    		"犯规数","比赛得分","投篮命中率","三分命中率",
								    		"罚球命中率","胜率","进攻回合","进攻效率",
								    		"防守效率","篮板效率","抢断效率","助攻率"};
											Object[][] columnValues = new Object[30][columnName.length];
											for (int i = 0; i < 30; i++) {
												columnValues[i][0] = teamAllData.get(i).getTeamNameLong();
												columnValues[i][1] = teamAllData.get(i).getMatchNum();
												columnValues[i][2] = teamAllData.get(i).getTeamData()[0];
												columnValues[i][3] = teamAllData.get(i).getTeamData()[1];
												columnValues[i][4] = teamAllData.get(i).getTeamData()[2];
												columnValues[i][5] = teamAllData.get(i).getTeamData()[3];
												columnValues[i][6] = teamAllData.get(i).getTeamData()[4];
												columnValues[i][7] = teamAllData.get(i).getTeamData()[5];
												columnValues[i][8] = teamAllData.get(i).getTeamData()[6];
												columnValues[i][9] = teamAllData.get(i).getTeamData()[7];
												columnValues[i][10] = teamAllData.get(i).getTeamData()[8];
												columnValues[i][11] = teamAllData.get(i).getTeamData()[9];
												columnValues[i][12] = teamAllData.get(i).getTeamData()[10];
												columnValues[i][13] = teamAllData.get(i).getTeamData()[11];
												columnValues[i][14] = teamAllData.get(i).getTeamData()[12];
												columnValues[i][15] = teamAllData.get(i).getTeamData()[13];
												columnValues[i][16] = teamAllData.get(i).getTeamData()[14];
												columnValues[i][17] = teamAllData.get(i).getTeamData()[15];
												columnValues[i][18] = teamAllData.get(i).getTeamData()[16];
												columnValues[i][19] = teamAllData.get(i).getTeamData()[17];
												columnValues[i][20] = teamAllData.get(i).getTeamData()[18];
												columnValues[i][21] = teamAllData.get(i).getTeamData()[19];
												columnValues[i][22] = teamAllData.get(i).getTeamData()[20];
												columnValues[i][23] = teamAllData.get(i).getTeamData()[21];
												columnValues[i][24] = teamAllData.get(i).getTeamData()[22];
												columnValues[i][25] = teamAllData.get(i).getTeamData()[23];
												columnValues[i][26] = teamAllData.get(i).getTeamData()[24];
											}
											toolPanel.removeAll();
											toolPanel.repaint();
											tablePanel.removeAll();
											tablePanel.add(teamDataTable(columnValues, columnName));
											tablePanel.repaint();
								} else if (tempTableButton.equals("teamAverage")) {
									ArrayList<TeamAverageVO> teamAverageData = tbl.getTeamAverageRankingByNum(judgeADNum(teamCondition));
									String[] columnName = new String[] {"球队名称", "比赛场数", "投篮命中数", 
								    		"投篮出手次数", "三分命中数", "三分出手数","罚球命中数","罚球出手数",
								    		"进攻篮板数","防守篮板数","篮板数",
								    		"助攻数","抢断数","盖帽数","失误数",
								    		"犯规数","比赛得分","投篮命中率","三分命中率",
								    		"罚球命中率","胜率","进攻回合","进攻效率",
								    		"防守效率","篮板效率","抢断效率","助攻率"};
											Object[][] columnValues = new Object[30][columnName.length];
											for (int i = 0; i < 30; i++) {
												columnValues[i][0] = teamAverageData.get(i).getTeamNameLong();
												columnValues[i][1] = teamAverageData.get(i).getMatchNum();
												columnValues[i][2] = teamAverageData.get(i).getTeamData()[0];
												columnValues[i][3] = teamAverageData.get(i).getTeamData()[1];
												columnValues[i][4] = teamAverageData.get(i).getTeamData()[2];
												columnValues[i][5] = teamAverageData.get(i).getTeamData()[3];
												columnValues[i][6] = teamAverageData.get(i).getTeamData()[4];
												columnValues[i][7] = teamAverageData.get(i).getTeamData()[5];
												columnValues[i][8] = teamAverageData.get(i).getTeamData()[6];
												columnValues[i][9] = teamAverageData.get(i).getTeamData()[7];
												columnValues[i][10] = teamAverageData.get(i).getTeamData()[8];
												columnValues[i][11] = teamAverageData.get(i).getTeamData()[9];
												columnValues[i][12] = teamAverageData.get(i).getTeamData()[10];
												columnValues[i][13] = teamAverageData.get(i).getTeamData()[11];
												columnValues[i][14] = teamAverageData.get(i).getTeamData()[12];
												columnValues[i][15] = teamAverageData.get(i).getTeamData()[13];
												columnValues[i][16] = teamAverageData.get(i).getTeamData()[14];
												columnValues[i][17] = teamAverageData.get(i).getTeamData()[15];
												columnValues[i][18] = teamAverageData.get(i).getTeamData()[16];
												columnValues[i][19] = teamAverageData.get(i).getTeamData()[17];
												columnValues[i][20] = teamAverageData.get(i).getTeamData()[18];
												columnValues[i][21] = teamAverageData.get(i).getTeamData()[19];
												columnValues[i][22] = teamAverageData.get(i).getTeamData()[20];
												columnValues[i][23] = teamAverageData.get(i).getTeamData()[21];
												columnValues[i][24] = teamAverageData.get(i).getTeamData()[22];
												columnValues[i][25] = teamAverageData.get(i).getTeamData()[23];
												columnValues[i][26] = teamAverageData.get(i).getTeamData()[24];
											}
											toolPanel.removeAll();
											toolPanel.repaint();
											tablePanel.removeAll();
											tablePanel.add(teamDataTable(columnValues, columnName));
											tablePanel.repaint();
								} else {
									
								}
							} else if(descend.isSelected()){
								AorD = "descend";
								if (tempTableButton.equals("teamAll")) {
									ArrayList<TeamAllVO> teamAllData = tbl.getTeamAllRankingByNumDeclining(judgeADNum(teamCondition));
									String[] columnName = new String[] {"球队名称", "比赛场数", "投篮命中数", 
								    		"投篮出手次数", "三分命中数", "三分出手数","罚球命中数","罚球出手数",
								    		"进攻篮板数","防守篮板数","篮板数",
								    		"助攻数","抢断数","盖帽数","失误数",
								    		"犯规数","比赛得分","投篮命中率","三分命中率",
								    		"罚球命中率","胜率","进攻回合","进攻效率",
								    		"防守效率","篮板效率","抢断效率","助攻率"};
											Object[][] columnValues = new Object[30][columnName.length];
											for (int i = 0; i < 30; i++) {
												columnValues[i][0] = teamAllData.get(i).getTeamNameLong();
												columnValues[i][1] = teamAllData.get(i).getMatchNum();
												columnValues[i][2] = teamAllData.get(i).getTeamData()[0];
												columnValues[i][3] = teamAllData.get(i).getTeamData()[1];
												columnValues[i][4] = teamAllData.get(i).getTeamData()[2];
												columnValues[i][5] = teamAllData.get(i).getTeamData()[3];
												columnValues[i][6] = teamAllData.get(i).getTeamData()[4];
												columnValues[i][7] = teamAllData.get(i).getTeamData()[5];
												columnValues[i][8] = teamAllData.get(i).getTeamData()[6];
												columnValues[i][9] = teamAllData.get(i).getTeamData()[7];
												columnValues[i][10] = teamAllData.get(i).getTeamData()[8];
												columnValues[i][11] = teamAllData.get(i).getTeamData()[9];
												columnValues[i][12] = teamAllData.get(i).getTeamData()[10];
												columnValues[i][13] = teamAllData.get(i).getTeamData()[11];
												columnValues[i][14] = teamAllData.get(i).getTeamData()[12];
												columnValues[i][15] = teamAllData.get(i).getTeamData()[13];
												columnValues[i][16] = teamAllData.get(i).getTeamData()[14];
												columnValues[i][17] = teamAllData.get(i).getTeamData()[15];
												columnValues[i][18] = teamAllData.get(i).getTeamData()[16];
												columnValues[i][19] = teamAllData.get(i).getTeamData()[17];
												columnValues[i][20] = teamAllData.get(i).getTeamData()[18];
												columnValues[i][21] = teamAllData.get(i).getTeamData()[19];
												columnValues[i][22] = teamAllData.get(i).getTeamData()[20];
												columnValues[i][23] = teamAllData.get(i).getTeamData()[21];
												columnValues[i][24] = teamAllData.get(i).getTeamData()[22];
												columnValues[i][25] = teamAllData.get(i).getTeamData()[23];
												columnValues[i][26] = teamAllData.get(i).getTeamData()[24];
											}
											toolPanel.removeAll();
											toolPanel.repaint();
											tablePanel.removeAll();
											tablePanel.add(teamDataTable(columnValues, columnName));
											tablePanel.repaint();
								} else if (tempTableButton.equals("teamAverage")) {
									ArrayList<TeamAverageVO> teamAverageData = tbl.getTeamAverageRankingByNumDeclining(judgeADNum(teamCondition));
									String[] columnName = new String[] {"球队名称", "比赛场数", "投篮命中数", 
								    		"投篮出手次数", "三分命中数", "三分出手数","罚球命中数","罚球出手数",
								    		"进攻篮板数","防守篮板数","篮板数",
								    		"助攻数","抢断数","盖帽数","失误数",
								    		"犯规数","比赛得分","投篮命中率","三分命中率",
								    		"罚球命中率","胜率","进攻回合","进攻效率",
								    		"防守效率","篮板效率","抢断效率","助攻率"};
											Object[][] columnValues = new Object[30][columnName.length];
											for (int i = 0; i < 30; i++) {
												columnValues[i][0] = teamAverageData.get(i).getTeamNameLong();
												columnValues[i][1] = teamAverageData.get(i).getMatchNum();
												columnValues[i][2] = teamAverageData.get(i).getTeamData()[0];
												columnValues[i][3] = teamAverageData.get(i).getTeamData()[1];
												columnValues[i][4] = teamAverageData.get(i).getTeamData()[2];
												columnValues[i][5] = teamAverageData.get(i).getTeamData()[3];
												columnValues[i][6] = teamAverageData.get(i).getTeamData()[4];
												columnValues[i][7] = teamAverageData.get(i).getTeamData()[5];
												columnValues[i][8] = teamAverageData.get(i).getTeamData()[6];
												columnValues[i][9] = teamAverageData.get(i).getTeamData()[7];
												columnValues[i][10] = teamAverageData.get(i).getTeamData()[8];
												columnValues[i][11] = teamAverageData.get(i).getTeamData()[9];
												columnValues[i][12] = teamAverageData.get(i).getTeamData()[10];
												columnValues[i][13] = teamAverageData.get(i).getTeamData()[11];
												columnValues[i][14] = teamAverageData.get(i).getTeamData()[12];
												columnValues[i][15] = teamAverageData.get(i).getTeamData()[13];
												columnValues[i][16] = teamAverageData.get(i).getTeamData()[14];
												columnValues[i][17] = teamAverageData.get(i).getTeamData()[15];
												columnValues[i][18] = teamAverageData.get(i).getTeamData()[16];
												columnValues[i][19] = teamAverageData.get(i).getTeamData()[17];
												columnValues[i][20] = teamAverageData.get(i).getTeamData()[18];
												columnValues[i][21] = teamAverageData.get(i).getTeamData()[19];
												columnValues[i][22] = teamAverageData.get(i).getTeamData()[20];
												columnValues[i][23] = teamAverageData.get(i).getTeamData()[21];
												columnValues[i][24] = teamAverageData.get(i).getTeamData()[22];
												columnValues[i][25] = teamAverageData.get(i).getTeamData()[23];
												columnValues[i][26] = teamAverageData.get(i).getTeamData()[24];
											}
											toolPanel.removeAll();
											toolPanel.repaint();
											tablePanel.removeAll();
											tablePanel.add(teamDataTable(columnValues, columnName));
											tablePanel.repaint();
								} else {
									
								}
							} else {
								AorD = "0";
								
							}
							dw.dispose();
						}
						public void mouseEntered(MouseEvent e) {
						}
						public void mouseExited(MouseEvent e) {						
						}
						public void mousePressed(MouseEvent e) {				
						}
						public void mouseReleased(MouseEvent arg0) {					
						}
					});
					dPanel.add(sure, 0);
					
					cancel = new JButton();
					cancel.setBounds(220, 220, 80, 30);
					cancel.setContentAreaFilled(false);
					cancel.setBorderPainted(false);
					cancel.setIcon(AllImages.IMG_CANCEL);
					cancel.setOpaque(false);
					cancel.addMouseListener(new MouseListener(){

						public void mouseClicked(MouseEvent arg0) {
							PlayWave.startClickSound();
							dw.dispose();
						}

						public void mouseEntered(MouseEvent arg0) {
						}

						public void mouseExited(MouseEvent arg0) {
							
						}

						public void mousePressed(MouseEvent arg0) {
					
						}

						public void mouseReleased(MouseEvent arg0) {
						
						}
						
					});
					dPanel.add(cancel, 0);
		
				}*/
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
			}
			public void mousePressed(MouseEvent e) {
			}
			public void mouseReleased(MouseEvent arg0) {
			}
			class ItemListener implements java.awt.event.ItemListener{

				public void itemStateChanged(ItemEvent e) {
					// TODO Auto-generated method stub
					 if (e.getSource() == ascend) {
				            ascend.setIcon(AllImages.IMG_RIGHT_RADIO);
				            descend.setIcon(AllImages.IMG_FALSE_RADIO);
				        } else {
				        	descend.setIcon(AllImages.IMG_RIGHT_RADIO);
					        ascend.setIcon(AllImages.IMG_FALSE_RADIO);
				        }
				}
				
			}
		}

	class SureToolListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			/*PlayWave.startClickSound();
			System.out.println(position.getSelectedItem().toString()+league.getSelectedItem().toString()+sortBy.getSelectedItem().toString());
			int num = -1;
			String location = "";
			String pLeague = "";
			if (position.getSelectedItem().toString().equals("前锋")) {
				location = "F";
			} else if (position.getSelectedItem().toString().equals("中锋")) {
				location = "C";
			} else if (position.getSelectedItem().toString().equals("后卫")) {
				location = "G";
			} else {
				location = "F";
				System.out.println("StatisticPanel-SureToolListener-location invalid.default F");
			}
			/**"东部东南分区","东部中央分区","东部大西洋分区",
				"西部太平洋分区","西部西北分区","西部西南分区"
			if (league.getSelectedItem().toString().equals("东部东南分区")) {
				pLeague = "E-Southeast";
			} else if (league.getSelectedItem().toString().equals("东部中央分区")) {
				pLeague = "E-Central";
			} else if (league.getSelectedItem().toString().equals("东部大西洋分区")) {
				pLeague = "E-Atlantic";
			} else if (league.getSelectedItem().toString().equals("西部太平洋分区")) {
				pLeague = "W-Pacific";
			} else if (league.getSelectedItem().toString().equals("西部西北分区")) {
				pLeague = "W-Northwest";
			} else if (league.getSelectedItem().toString().equals("西部西南分区")) {
				pLeague = "W-Southeast";
			} else {
				pLeague = "E-Southeast";
				System.out.println("StatisticPanel-SureToolListener-league invalid.default E-Southeast");
			}
			if (sortBy.getSelectedItem().toString().equals("得分")) {
				num = 0;
			} else if (sortBy.getSelectedItem().toString().equals("篮板")) {
				num = 1;
			} else if (sortBy.getSelectedItem().toString().equals("助攻")) {
				num = 2;
			} else if (sortBy.getSelectedItem().toString().equals("得分/篮板/助攻")) {
				num = 3;
			} else if (sortBy.getSelectedItem().toString().equals("盖帽")) {
				num = 4;
			} else if (sortBy.getSelectedItem().toString().equals("抢断")) {
				num = 5;
			} else if (sortBy.getSelectedItem().toString().equals("犯规")) {
				num = 6;
			} else if (sortBy.getSelectedItem().toString().equals("失误")) {
				num = 7;
			} else if (sortBy.getSelectedItem().toString().equals("分钟")) {
				num = 8;
			} else if (sortBy.getSelectedItem().toString().equals("效率")) {
				num = 9;
			} else if (sortBy.getSelectedItem().toString().equals("投篮")) {
				num = 10;
			} else if (sortBy.getSelectedItem().toString().equals("三分")) {
				num = 11;
			} else if (sortBy.getSelectedItem().toString().equals("罚球")) {
				num = 12;
			} else if (sortBy.getSelectedItem().toString().equals("两双")) {
				num = 13;
			} else {
				num = 0;
				System.out.println("StatisticPanel-SureToolListener-num invalid.default 0");
			}
			if (tempTableButton.equals("playerAll")) {
				ArrayList<PlayerAllVO> playerFilterAll = pbl.getPlayerAllByMultipleConRaising(location, pLeague, num);
				String[] columnName = new String[] {"头像","球员名称","所属球队","参赛场数", "先发场数",
						"篮板数", "助攻数", "在场时间","投篮命中率",
						"三分命中率","罚球命中率","进攻数","防守数" ,
						"抢断数","盖帽数","失误数" ,"犯规数",
						"得分","效率" ,"GmSc效率值","真实命中数","投篮效率",
						"篮板率","进攻篮板率","防守篮板率","助攻率",
						"抢断率","盖帽率" ,
						"失误率","使用率" };
				Object[][] columnValues = new Object[playerFilterAll.size()][columnName.length];
				for (int i = 0; i < playerFilterAll.size(); i++) {
					columnValues[i][0] = new ImageIcon("playerImg/portrait/"+playerFilterAll.get(i).getPlayerName()+".png");
					columnValues[i][1] = playerFilterAll.get(i).getPlayerName();
					columnValues[i][2] = playerFilterAll.get(i).getTeamList();
					columnValues[i][3] = playerFilterAll.get(i).getCompeteNum();
					columnValues[i][4] = playerFilterAll.get(i).getOffensiveNum();
					columnValues[i][5] = playerFilterAll.get(i).getPlayerData()[0];
					columnValues[i][6] = playerFilterAll.get(i).getPlayerData()[1];
					columnValues[i][7] = playerFilterAll.get(i).getPlayingTime();
					columnValues[i][8] = playerFilterAll.get(i).getPlayerData()[2];
					columnValues[i][9] = playerFilterAll.get(i).getPlayerData()[3];
					columnValues[i][10] = playerFilterAll.get(i).getPlayerData()[4];
					columnValues[i][11] = playerFilterAll.get(i).getPlayerData()[5];
					columnValues[i][12] = playerFilterAll.get(i).getPlayerData()[6];
					columnValues[i][13] = playerFilterAll.get(i).getPlayerData()[7];
					columnValues[i][14] = playerFilterAll.get(i).getPlayerData()[8];
					columnValues[i][15] = playerFilterAll.get(i).getPlayerData()[9];
					columnValues[i][16] = playerFilterAll.get(i).getPlayerData()[10];
					columnValues[i][17] = playerFilterAll.get(i).getPlayerData()[11];
					columnValues[i][18] = playerFilterAll.get(i).getPlayerData()[12];
					columnValues[i][19] = playerFilterAll.get(i).getPlayerData()[13];
					columnValues[i][20] = playerFilterAll.get(i).getPlayerData()[14];
					columnValues[i][21] = playerFilterAll.get(i).getPlayerData()[15];
					columnValues[i][22] = playerFilterAll.get(i).getPlayerData()[16];
					columnValues[i][23] = playerFilterAll.get(i).getPlayerData()[17];
					columnValues[i][24] = playerFilterAll.get(i).getPlayerData()[18];
					columnValues[i][25] = playerFilterAll.get(i).getPlayerData()[19];
					columnValues[i][26] = playerFilterAll.get(i).getPlayerData()[20];
					columnValues[i][27] = playerFilterAll.get(i).getPlayerData()[21];
					columnValues[i][28] = playerFilterAll.get(i).getPlayerData()[22];
					columnValues[i][29] = playerFilterAll.get(i).getPlayerData()[23];
				}
				tablePanel.removeAll();
				tablePanel.add(playerDataTable(columnValues, columnName));
				tablePanel.repaint();
			} else if (tempTableButton.equals("playerAverage")) {
				ArrayList<PlayerAverageVO> playerFilterAverage = pbl.getPlayerAverageByMultipleConRaising(location, pLeague, num);
				tablePanel.removeAll();
				String[] columnName = new String[] {"头像","球员名称","所属球队","参赛场数", "先发场数",
						"篮板数", "助攻数", "在场时间","投篮命中率",
						"三分命中率","罚球命中率","进攻数","防守数" ,
						"抢断数","盖帽数","失误数" ,"犯规数",
						"得分","效率" ,"GmSc效率值","真实命中数","投篮效率",
						"篮板率","进攻篮板率","防守篮板率","助攻率",
						"抢断率","盖帽率" ,
						"失误率","使用率" };
				Object[][] columnValues = new Object[playerFilterAverage.size()][columnName.length];
				for (int i = 0; i < playerFilterAverage.size(); i++) {
					columnValues[i][0] = new ImageIcon("playerImg/portrait/"+playerFilterAverage.get(i).getName()+".png");
					columnValues[i][1] = playerFilterAverage.get(i).getName();
					columnValues[i][2] = playerFilterAverage.get(i).getTeamList();
					columnValues[i][3] = playerFilterAverage.get(i).getCompeteNum();
					columnValues[i][4] = playerFilterAverage.get(i).getOffensiveNum();
					columnValues[i][5] = playerFilterAverage.get(i).getPlayerData()[0];
					columnValues[i][6] = playerFilterAverage.get(i).getPlayerData()[1];
					columnValues[i][7] = playerFilterAverage.get(i).getPlayingTime();
					columnValues[i][8] = playerFilterAverage.get(i).getPlayerData()[2];
					columnValues[i][9] = playerFilterAverage.get(i).getPlayerData()[3];
					columnValues[i][10] = playerFilterAverage.get(i).getPlayerData()[4];
					columnValues[i][11] = playerFilterAverage.get(i).getPlayerData()[5];
					columnValues[i][12] = playerFilterAverage.get(i).getPlayerData()[6];
					columnValues[i][13] = playerFilterAverage.get(i).getPlayerData()[7];
					columnValues[i][14] = playerFilterAverage.get(i).getPlayerData()[8];
					columnValues[i][15] = playerFilterAverage.get(i).getPlayerData()[9];
					columnValues[i][16] = playerFilterAverage.get(i).getPlayerData()[10];
					columnValues[i][17] = playerFilterAverage.get(i).getPlayerData()[11];
					columnValues[i][18] = playerFilterAverage.get(i).getPlayerData()[12];
					columnValues[i][19] = playerFilterAverage.get(i).getPlayerData()[13];
					columnValues[i][20] = playerFilterAverage.get(i).getPlayerData()[14];
					columnValues[i][21] = playerFilterAverage.get(i).getPlayerData()[15];
					columnValues[i][22] = playerFilterAverage.get(i).getPlayerData()[16];
					columnValues[i][23] = playerFilterAverage.get(i).getPlayerData()[17];
					columnValues[i][24] = playerFilterAverage.get(i).getPlayerData()[18];
					columnValues[i][25] = playerFilterAverage.get(i).getPlayerData()[19];
					columnValues[i][26] = playerFilterAverage.get(i).getPlayerData()[20];
					columnValues[i][27] = playerFilterAverage.get(i).getPlayerData()[21];
					columnValues[i][28] = playerFilterAverage.get(i).getPlayerData()[22];
					columnValues[i][29] = playerFilterAverage.get(i).getPlayerData()[23];
				}
				tablePanel.add(playerDataTable(columnValues, columnName));
				tablePanel.repaint();
				initToolPanel();
				toolPanel.repaint();
			}
			
		*/
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
