package ui.player;

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
import ui.match.MatchHomePanel;
import ui.team.TeamHomePanel;
import vo.MatchVO;
import vo.PlayerAllVO;
import vo.PlayerAverageVO;
import vo.PlayerBasicVO;
import BL.MatchBL;
import BL.MatchBL_Impl;
import BL.PlayerBL;
import BL.PlayerBL_Impl;

public class PlayerHomePanel {
	/**
	 * @param 球员的个人主页
	 *            -> 球员头像+动态图片 -> 球员的个人基本信息 -> 球员的比赛数据[场均和总赛季] -> 球员的近期比赛 ->
	 *            球员的所有比赛
	 * @author forIris
	 * @version June 13, 2015 15:54:31 PM
	 * **/

	private JPanel pHomePanel;
	private JPanel morePanel;
	//
	private JButton playerPhoto;
	private JButton playerName;
	private JButton playerJerseyNum;
	private JButton playerPosition;
	private JButton playerHeight;
	private JButton playerWeight;
	private JButton playerBirth;
	private JButton playerAge;
	private JButton playerExp;
	private JButton playerSchool;
	private JButton playerTeam;
	//
	private MyStringTable dataTable;
	private JScrollPane dataScrollPane;
	private JButton data;
	private JButton recentM;
	private JButton allM;

	private MyStringTable rMTable;
	private JScrollPane rMScrollPane;
	private MyStringTable aMTable;
	private JScrollPane aMScrollPane;
	
	private String basic_JerseyNum;
	private String basic_Position;
	private String basic_Height;
	private String basic_Weight;
	private String basic_Birth;
	private String basic_Age;
	private String basic_Exp;
	private String basic_School;
	private static String tempButton;
	
	//
	MatchBL mbl = new MatchBL_Impl();
	PlayerBL pbl = new PlayerBL_Impl();
	String playerTempID;
	String teamTempID;

	public JPanel init(String playerID) {
		playerTempID = playerID;
		PlayerBasicVO pbasicList = new PlayerBasicVO(playerTempID);
		pbasicList = pbl.getPlayerBasicByName(playerTempID);
		if (pbasicList==null) {
			basic_JerseyNum = "null";
			basic_Position = "null";
			basic_Height = "null";
			basic_Weight = "null";
			basic_Birth = "null";
			basic_Age = "null";
			basic_Exp = "null";
			basic_School = "null";
		} else {
			basic_JerseyNum = pbasicList.getBasicInfo()[0];
			basic_Position = pbasicList.getBasicInfo()[1];
			basic_Height = pbasicList.getBasicInfo()[2];
			basic_Weight = pbasicList.getBasicInfo()[3];
			basic_Birth = pbasicList.getBasicInfo()[4];
			basic_Age = pbasicList.getBasicInfo()[5];
			basic_Exp = pbasicList.getBasicInfo()[6];
			basic_School = pbasicList.getBasicInfo()[7];
		}
		
		pHomePanel = new JPanel();
		pHomePanel.setOpaque(false);
		pHomePanel.setBounds(0, 0, 1000 - 130, 700);
		pHomePanel.setLayout(null);

		// TODO player photo
		playerPhoto = new JButton();
		playerPhoto.setBounds(40, 50, 176, 280);
		playerPhoto.setOpaque(false);
		playerPhoto.setContentAreaFilled(false);
		playerPhoto.setBorderPainted(false);
		File action = new File("playerImg/action/"+playerTempID+".png");
		if (action.exists()) {
			playerPhoto.setIcon(new ImageIcon("playerImg/action/"+playerTempID+".png"));
		} else {
			playerPhoto.setIcon(AllImages.IMG_DEFAULT_ACTION);
		}
		pHomePanel.add(playerPhoto, 0);

		// TODO basic info labels - name-jerseyNum-position-
		// height-weight-birth-age-exp-school-team
		int toLeftFirst = 230;
		int toLeftSecond = 390;
		int width = 100;
		int height = 30;

		// TODO
		playerName = new JButton();
		playerName.setBounds(toLeftFirst, 80, width, height);
		playerName.setOpaque(false);
		playerName.setContentAreaFilled(false);
		playerName.setBorderPainted(false);
		playerName.setText("姓名");
		playerName.setForeground(Color.GRAY);
		playerName.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		pHomePanel.add(playerName, 0);

		//
		JLabel pName = new JLabel();
		pName.setBounds(toLeftFirst + 100, 80, width, height);
		pName.setOpaque(false);
		pName.setText(playerTempID);
		pName.setForeground(Color.WHITE);
		pName.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		pHomePanel.add(pName, 0);

		playerJerseyNum = new JButton();
		playerJerseyNum.setBounds(toLeftFirst, 130, width, height);
		playerJerseyNum.setOpaque(false);
		playerJerseyNum.setContentAreaFilled(false);
		playerJerseyNum.setBorderPainted(false);
		playerJerseyNum.setText("球衣号码");
		playerJerseyNum.setForeground(Color.GRAY);
		playerJerseyNum.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		pHomePanel.add(playerJerseyNum, 0);

		//
		JLabel pJerseyNum = new JLabel();
		pJerseyNum.setBounds(toLeftFirst + 100, 130, width, height);
		pJerseyNum.setOpaque(false);
		pJerseyNum.setText(basic_JerseyNum);
		pJerseyNum.setForeground(Color.WHITE);
		pJerseyNum.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		pHomePanel.add(pJerseyNum, 0);

		playerPosition = new JButton();
		playerPosition.setBounds(toLeftFirst, 180, width, height);
		playerPosition.setOpaque(false);
		playerPosition.setContentAreaFilled(false);
		playerPosition.setBorderPainted(false);
		playerPosition.setText("位置");
		playerPosition.setForeground(Color.GRAY);
		playerPosition.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		pHomePanel.add(playerPosition, 0);

		//
		JLabel pPosition = new JLabel();
		pPosition.setBounds(toLeftFirst + 100, 180, width, height);
		pPosition.setOpaque(false);
		pPosition.setText(basic_Position);
		pPosition.setForeground(Color.WHITE);
		pPosition.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		pHomePanel.add(pPosition, 0);

		playerHeight = new JButton();
		playerHeight.setBounds(toLeftFirst, 230, width, height);
		playerHeight.setOpaque(false);
		playerHeight.setContentAreaFilled(false);
		playerHeight.setBorderPainted(false);
		playerHeight.setText("身高");
		playerHeight.setForeground(Color.GRAY);
		playerHeight.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		pHomePanel.add(playerHeight, 0);

		//
		JLabel pHeight = new JLabel();
		pHeight.setBounds(toLeftFirst + 100, 230, width, height);
		pHeight.setOpaque(false);
		pHeight.setText(basic_Height);
		pHeight.setForeground(Color.WHITE);
		pHeight.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		pHomePanel.add(pHeight, 0);

		playerWeight = new JButton();
		playerWeight.setBounds(toLeftFirst, 280, width, height);
		playerWeight.setOpaque(false);
		playerWeight.setContentAreaFilled(false);
		playerWeight.setBorderPainted(false);
		playerWeight.setText("体重");
		playerWeight.setForeground(Color.GRAY);
		playerWeight.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		pHomePanel.add(playerWeight, 0);

		//
		JLabel pWeight = new JLabel();
		pWeight.setBounds(toLeftFirst + 100, 280, width, height);
		pWeight.setOpaque(false);
		pWeight.setText(basic_Weight);
		pWeight.setForeground(Color.WHITE);
		pWeight.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		pHomePanel.add(pWeight, 0);

		// TODO
		playerBirth = new JButton();
		playerBirth.setBounds(toLeftSecond, 80, width, height);
		playerBirth.setOpaque(false);
		playerBirth.setContentAreaFilled(false);
		playerBirth.setBorderPainted(false);
		playerBirth.setText("生日");
		playerBirth.setForeground(Color.GRAY);
		playerBirth.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		pHomePanel.add(playerBirth, 0);

		//
		JLabel pBirth = new JLabel();
		pBirth.setBounds(toLeftSecond + 100, 80, width, height);
		pBirth.setOpaque(false);
		pBirth.setText(basic_Birth);
		pBirth.setForeground(Color.WHITE);
		pBirth.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		pHomePanel.add(pBirth, 0);

		playerAge = new JButton();
		playerAge.setBounds(toLeftSecond, 130, width, height);
		playerAge.setOpaque(false);
		playerAge.setContentAreaFilled(false);
		playerAge.setBorderPainted(false);
		playerAge.setText("年龄");
		playerAge.setForeground(Color.GRAY);
		playerAge.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		pHomePanel.add(playerAge, 0);

		//
		JLabel pAge = new JLabel();
		pAge.setBounds(toLeftSecond + 100, 130, width, height);
		pAge.setOpaque(false);
		pAge.setText(basic_Age);
		pAge.setForeground(Color.WHITE);
		pAge.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		pHomePanel.add(pAge, 0);

		playerExp = new JButton();
		playerExp.setBounds(toLeftSecond, 180, width, height);
		playerExp.setOpaque(false);
		playerExp.setContentAreaFilled(false);
		playerExp.setBorderPainted(false);
		playerExp.setText("球龄");
		playerExp.setForeground(Color.GRAY);
		playerExp.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		pHomePanel.add(playerExp, 0);

		//
		JLabel pExp = new JLabel();
		pExp.setBounds(toLeftSecond + 100, 180, width, height);
		pExp.setOpaque(false);
		pExp.setText(basic_Exp);
		pExp.setForeground(Color.WHITE);
		pExp.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		pHomePanel.add(pExp, 0);

		playerSchool = new JButton();
		playerSchool.setBounds(toLeftSecond, 230, width, height);
		playerSchool.setOpaque(false);
		playerSchool.setContentAreaFilled(false);
		playerSchool.setBorderPainted(false);
		playerSchool.setText("毕业学校");
		playerSchool.setForeground(Color.GRAY);
		playerSchool.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		pHomePanel.add(playerSchool, 0);

		//
		JLabel pSchool = new JLabel();
		pSchool.setBounds(toLeftSecond + 100, 230, width, height);
		pSchool.setOpaque(false);
		pSchool.setText(basic_School);
		pSchool.setForeground(Color.WHITE);
		pSchool.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		pHomePanel.add(pSchool, 0);

		// TODO
		playerTeam = new JButton();
		playerTeam.setBounds(600, 80, 100, 30);
		playerTeam.setOpaque(false);
		playerTeam.setContentAreaFilled(false);
		playerTeam.setBorderPainted(false);
		playerTeam.setText("所属球队");
		playerTeam.setForeground(Color.GRAY);
		playerTeam.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		pHomePanel.add(playerTeam, 0);

		// logoIcon
		//PlayerAllVO playerAllList = new PlayerAllVO(playerTempID);
		PlayerAllVO playerAllList = pbl.getPlayerAllByName(playerTempID);
		JSVGCanvas svgCanvas = new JSVGCanvas();
		File f1 = new File("teamImg/"+playerAllList.getTeamList().get(playerAllList.getTeamList().size()-1)+".svg");
		teamTempID = playerAllList.getTeamList().get(playerAllList.getTeamList().size()-1);
		svgCanvas.setBounds(620, 130, 140, 140);
		svgCanvas.setURI(f1.toURI().toString());
		svgCanvas.addSVGDocumentLoaderListener(new SVGDocumentLoaderAdapter() {
			public void documentLoadingStarted(SVGDocumentLoaderEvent e) {
			}

			public void documentLoadingCompleted(SVGDocumentLoaderEvent e) {
			}
		});
		svgCanvas.addGVTTreeBuilderListener(new GVTTreeBuilderAdapter() {
			public void gvtBuildStarted(GVTTreeBuilderEvent e) {
			}

			public void gvtBuildCompleted(GVTTreeBuilderEvent e) {
				// frame.pack();
			}
		});
		svgCanvas.addGVTTreeRendererListener(new GVTTreeRendererAdapter() {
			public void gvtRenderingPrepare(GVTTreeRendererEvent e) {
			}

			public void gvtRenderingCompleted(GVTTreeRendererEvent e) {
				System.out.println("renderCompleted");
			}
		});
		svgCanvas.addMouseListener(new TeamListener());
		pHomePanel.add(svgCanvas, 0);

		//TODO
		morePanel = new JPanel();
		morePanel.setOpaque(false);
		morePanel.setBounds(0, 360, 1000 - 130, 700 - 360);
		morePanel.setLayout(null);
		pHomePanel.add(morePanel, 0);

		PlayerAllVO pAllDataList = pbl.getPlayerAllByName(playerTempID);
		PlayerAverageVO pAverageDataList = pbl.getPlayerAverageByName(playerTempID);
		String[] columnName = new String[] {"TAG", "参赛场数", "先发场数", "篮板数", "助攻数",
				"在场时间", "投篮命中率", "三分命中率", "罚球命中率", "进攻数",
				"防守数", "抢断数",
				"盖帽数", "失误数", "犯规数", "得分", "效率", "GmSc效率值",
				"真实命中数", "投篮效率", "篮板率", "进攻篮板率", "防守篮板率", "助攻率", "抢断率",
				"盖帽率", "失误率", "使用率" };
		Object[][] columnValues = new Object[2][columnName.length];
		for (int i = 0; i < 2; i++) {
			if (i % 2 == 0) {
				columnValues[i][0] = "总赛季";
				columnValues[i][1] = pAllDataList.getCompeteNum();
				columnValues[i][2] = pAllDataList.getOffensiveNum();
				columnValues[i][3] = pAllDataList.getPlayerData()[0];
				columnValues[i][4] = pAllDataList.getPlayerData()[1];
				columnValues[i][5] = pAllDataList.getPlayingTime();
				columnValues[i][6] = pAllDataList.getPlayerData()[2];
				columnValues[i][7] = pAllDataList.getPlayerData()[3];
				columnValues[i][8] = pAllDataList.getPlayerData()[4];
				columnValues[i][9] = pAllDataList.getPlayerData()[5];
				columnValues[i][10] = pAllDataList.getPlayerData()[6];
				columnValues[i][11] = pAllDataList.getPlayerData()[7];
				columnValues[i][12] = pAllDataList.getPlayerData()[8];
				columnValues[i][13] = pAllDataList.getPlayerData()[9];
				columnValues[i][14] = pAllDataList.getPlayerData()[10];
				columnValues[i][15] = pAllDataList.getPlayerData()[11];
				columnValues[i][16] = pAllDataList.getPlayerData()[12];
				columnValues[i][17] = pAllDataList.getPlayerData()[13];
				columnValues[i][18] = pAllDataList.getPlayerData()[14];
				columnValues[i][19] = pAllDataList.getPlayerData()[15];
				columnValues[i][20] = pAllDataList.getPlayerData()[16];
				columnValues[i][21] = pAllDataList.getPlayerData()[17];
				columnValues[i][22] = pAllDataList.getPlayerData()[18];
				columnValues[i][23] = pAllDataList.getPlayerData()[19];
				columnValues[i][24] = pAllDataList.getPlayerData()[20];
				columnValues[i][25] = pAllDataList.getPlayerData()[21];
				columnValues[i][26] = pAllDataList.getPlayerData()[22];
				columnValues[i][27] = pAllDataList.getPlayerData()[23];
			} else {
				columnValues[i][0] = "场均";
				columnValues[i][1] = pAverageDataList.getCompeteNum();
				columnValues[i][2] = pAverageDataList.getOffensiveNum();
				columnValues[i][3] = pAverageDataList.getPlayerData()[0];
				columnValues[i][4] = pAverageDataList.getPlayerData()[1];
				columnValues[i][5] = pAverageDataList.getPlayingTime();
				columnValues[i][6] = pAverageDataList.getPlayerData()[2];
				columnValues[i][7] = pAverageDataList.getPlayerData()[3];
				columnValues[i][8] = pAverageDataList.getPlayerData()[4];
				columnValues[i][9] = pAverageDataList.getPlayerData()[5];
				columnValues[i][10] = pAverageDataList.getPlayerData()[6];
				columnValues[i][11] = pAverageDataList.getPlayerData()[7];
				columnValues[i][12] = pAverageDataList.getPlayerData()[8];
				columnValues[i][13] = pAverageDataList.getPlayerData()[9];
				columnValues[i][14] = pAverageDataList.getPlayerData()[10];
				columnValues[i][15] = pAverageDataList.getPlayerData()[11];
				columnValues[i][16] = pAverageDataList.getPlayerData()[12];
				columnValues[i][17] = pAverageDataList.getPlayerData()[13];
				columnValues[i][18] = pAverageDataList.getPlayerData()[14];
				columnValues[i][19] = pAverageDataList.getPlayerData()[15];
				columnValues[i][20] = pAverageDataList.getPlayerData()[16];
				columnValues[i][21] = pAverageDataList.getPlayerData()[17];
				columnValues[i][22] = pAverageDataList.getPlayerData()[18];
				columnValues[i][23] = pAverageDataList.getPlayerData()[19];
				columnValues[i][24] = pAverageDataList.getPlayerData()[20];
				columnValues[i][25] = pAverageDataList.getPlayerData()[21];
				columnValues[i][26] = pAverageDataList.getPlayerData()[22];
				columnValues[i][27] = pAverageDataList.getPlayerData()[23];
			}
		}

		morePanel.removeAll();

		morePanel.add(initDataTable(columnValues, columnName), 0);

		/*// TODO average match data table
		JLabel pTable = new JLabel();
		pTable.setBounds(30, 5, 80, 30);
		pTable.setOpaque(false);
		pTable.setText("比赛数据");
		pTable.setForeground(Color.WHITE);
		pTable.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		morePanel.add(pTable, 0);*/

		/*JLabel pAver = new JLabel();
		pAver.setBounds(30, 40 - 5, 60, 30);
		pAver.setOpaque(false);
		pAver.setText("场均");
		pAver.setForeground(Color.WHITE);
		pAver.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		morePanel.add(pAver, 0);

		JLabel pAll = new JLabel();
		pAll.setBounds(30, 70 - 5, 60, 30);
		pAll.setOpaque(false);
		pAll.setText("");
		pAll.setForeground(Color.WHITE);
		pAll.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		morePanel.add(pAll, 0);
		morePanel.repaint();*/

		// TODO button data recentM allM
		data = new JButton();
		data.setOpaque(false);
		data.setContentAreaFilled(false);
		data.setBorderPainted(false);
		data.setBounds(30, 330, 100, 30);
		data.setIcon(AllImages.IMG_INIT_PDATA);
		data.addMouseListener(new PDListener());
		pHomePanel.add(data, 0);

		recentM = new JButton();
		recentM.setOpaque(false);
		recentM.setContentAreaFilled(false);
		recentM.setBorderPainted(false);
		recentM.setBounds(130, 330, 100, 30);
		recentM.setIcon(AllImages.IMG_INIT_PRECENTMATCH);
		recentM.addMouseListener(new PRMListener());
		pHomePanel.add(recentM, 0);

		allM = new JButton();
		allM.setOpaque(false);
		allM.setContentAreaFilled(false);
		allM.setBorderPainted(false);
		allM.setBounds(230, 330, 100, 30);
		allM.setIcon(AllImages.IMG_INIT_PALLMATCH);
		allM.addMouseListener(new PAMListener());
		pHomePanel.add(allM, 0);

		return pHomePanel;
	}

	// TODO for button data
	public JScrollPane initDataTable(Object[][] columnValues, String[] columnName) {

		dataTable = new MyStringTable(columnValues, columnName);
		dataTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		dataTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		dataTable.setForeground(Color.white);
		dataTable.setRowHeight(30);
		dataTable.setBounds(30, 10, 1000 - 130 - 100 - 60, 105);
		dataTable.setOpaque(false);
		dataTable.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		
	    dataScrollPane = new JScrollPane();
	    dataScrollPane.setColumnHeaderView(dataTable.getTableHeader());	//设置头部（HeaderView部分）  
	    dataScrollPane.getColumnHeader().setOpaque(false);	//再取出头部，并设置为透明  
	    
	    dataScrollPane.setViewportView(dataTable);	//装载表格  
	    dataScrollPane.setOpaque(false);
	    dataScrollPane.getViewport().setOpaque(false);
	    dataScrollPane.getVerticalScrollBar().setUI(new IScrollBarUI());
	    dataScrollPane.getHorizontalScrollBar().setUI(new IScrollBarUI());
	    
	    dataScrollPane.setBounds(30, 10, 1000-130-60-100, 105);
	    dataScrollPane.setBorder(null);
	    dataScrollPane.setOpaque(false);

		return dataScrollPane;
	}

	// TODO for button recentM
	public JScrollPane initRMTable(Object[][] columnRMValues,
			String[] columnName_RM) {

		rMTable = new MyStringTable(columnRMValues, columnName_RM);
		rMTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		rMTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		rMTable.setForeground(Color.white);
		rMTable.setRowHeight(35);
		rMTable.setBounds(30, 10, 1000 - 130 - 100, 280);
		rMTable.setOpaque(false);

		rMTable.addMouseListener(new TableListener());

		rMTable.setFont(new Font("微软雅黑", Font.PLAIN, 13));

		rMScrollPane = new JScrollPane();
		rMScrollPane.setColumnHeaderView(rMTable.getTableHeader()); // 设置头部（HeaderView部分）
		rMScrollPane.getColumnHeader().setOpaque(false); // 再取出头部，并设置为透明

		rMScrollPane.setViewportView(rMTable); // 装载表格
		rMScrollPane.setOpaque(false);
		rMScrollPane.getViewport().setOpaque(false);
		rMScrollPane.getVerticalScrollBar().setUI(new IScrollBarUI());
		rMScrollPane.getHorizontalScrollBar().setUI(new IScrollBarUI());
		rMScrollPane.setBorder(null);
		rMScrollPane.setBounds(30, 10, 1000 - 130 - 100, 280);
		rMScrollPane.setOpaque(false);
		return rMScrollPane;
	}

	// TODO initAllMatchTable
	public JScrollPane initAMTable(Object[][] columnAMValues,
			String[] columnName_AM) {

		aMTable = new MyStringTable(columnAMValues, columnName_AM);
		aMTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		aMTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		aMTable.setForeground(Color.white);
		aMTable.setRowHeight(35);
		aMTable.setBounds(30, 10, 1000 - 130 - 100, 280);
		aMTable.setOpaque(false);

		aMTable.addMouseListener(new TableListener());

		aMTable.setFont(new Font("微软雅黑", Font.PLAIN, 13));

		aMScrollPane = new JScrollPane();
		aMScrollPane.setColumnHeaderView(aMTable.getTableHeader()); // 设置头部（HeaderView部分）
		aMScrollPane.getColumnHeader().setOpaque(false); // 再取出头部，并设置为透明

		aMScrollPane.setViewportView(aMTable); // 装载表格
		aMScrollPane.setOpaque(false);
		aMScrollPane.getViewport().setOpaque(false);
		aMScrollPane.getVerticalScrollBar().setUI(new IScrollBarUI());
		aMScrollPane.getHorizontalScrollBar().setUI(new IScrollBarUI());
		aMScrollPane.setBorder(null);
		aMScrollPane.setBounds(30, 10, 1000 - 130 - 100, 280);
		aMScrollPane.setOpaque(false);
		return aMScrollPane;
	}

	class PDListener implements MouseListener {
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			tempButton = "pd";
			PlayWave.startClickSound();
			PlayerAllVO pAllDataList = pbl.getPlayerAllByName(playerTempID);
			PlayerAverageVO pAverageDataList = pbl.getPlayerAverageByName(playerTempID);
			String[] columnName = new String[] { "参赛场数", "先发场数", "篮板数", "助攻数",
					"在场时间", "投篮命中率", "三分命中率", "罚球命中率", "进攻数",
					"防守数", "抢断数",
					"盖帽数", "失误数", "犯规数", "得分", "效率", "GmSc效率值",
					"真实命中数", "投篮效率", "篮板率", "进攻篮板率", "防守篮板率", "助攻率", "抢断率",
					"盖帽率", "失误率", "使用率" };
			Object[][] columnValues = new Object[2][columnName.length];
			for (int i = 0; i < 2; i++) {
				if (i % 2 == 0) {
					columnValues[i][0] = "总赛季";
					columnValues[i][1] = pAllDataList.getCompeteNum();
					columnValues[i][2] = pAllDataList.getOffensiveNum();
					columnValues[i][3] = pAllDataList.getPlayerData()[0];
					columnValues[i][4] = pAllDataList.getPlayerData()[1];
					columnValues[i][5] = pAllDataList.getPlayingTime();
					columnValues[i][6] = pAllDataList.getPlayerData()[2];
					columnValues[i][7] = pAllDataList.getPlayerData()[3];
					columnValues[i][8] = pAllDataList.getPlayerData()[4];
					columnValues[i][9] = pAllDataList.getPlayerData()[5];
					columnValues[i][10] = pAllDataList.getPlayerData()[6];
					columnValues[i][11] = pAllDataList.getPlayerData()[7];
					columnValues[i][12] = pAllDataList.getPlayerData()[8];
					columnValues[i][13] = pAllDataList.getPlayerData()[9];
					columnValues[i][14] = pAllDataList.getPlayerData()[10];
					columnValues[i][15] = pAllDataList.getPlayerData()[11];
					columnValues[i][16] = pAllDataList.getPlayerData()[12];
					columnValues[i][17] = pAllDataList.getPlayerData()[13];
					columnValues[i][18] = pAllDataList.getPlayerData()[14];
					columnValues[i][19] = pAllDataList.getPlayerData()[15];
					columnValues[i][20] = pAllDataList.getPlayerData()[16];
					columnValues[i][21] = pAllDataList.getPlayerData()[17];
					columnValues[i][22] = pAllDataList.getPlayerData()[18];
					columnValues[i][23] = pAllDataList.getPlayerData()[19];
					columnValues[i][24] = pAllDataList.getPlayerData()[20];
					columnValues[i][25] = pAllDataList.getPlayerData()[21];
					columnValues[i][26] = pAllDataList.getPlayerData()[22];
					columnValues[i][27] = pAllDataList.getPlayerData()[23];
				} else {
					columnValues[i][0] = "场均";
					columnValues[i][1] = pAverageDataList.getCompeteNum();
					columnValues[i][2] = pAverageDataList.getOffensiveNum();
					columnValues[i][3] = pAverageDataList.getPlayerData()[0];
					columnValues[i][4] = pAverageDataList.getPlayerData()[1];
					columnValues[i][5] = pAverageDataList.getPlayingTime();
					columnValues[i][6] = pAverageDataList.getPlayerData()[2];
					columnValues[i][7] = pAverageDataList.getPlayerData()[3];
					columnValues[i][8] = pAverageDataList.getPlayerData()[4];
					columnValues[i][9] = pAverageDataList.getPlayerData()[5];
					columnValues[i][10] = pAverageDataList.getPlayerData()[6];
					columnValues[i][11] = pAverageDataList.getPlayerData()[7];
					columnValues[i][12] = pAverageDataList.getPlayerData()[8];
					columnValues[i][13] = pAverageDataList.getPlayerData()[9];
					columnValues[i][14] = pAverageDataList.getPlayerData()[10];
					columnValues[i][15] = pAverageDataList.getPlayerData()[11];
					columnValues[i][16] = pAverageDataList.getPlayerData()[12];
					columnValues[i][17] = pAverageDataList.getPlayerData()[13];
					columnValues[i][18] = pAverageDataList.getPlayerData()[14];
					columnValues[i][19] = pAverageDataList.getPlayerData()[15];
					columnValues[i][20] = pAverageDataList.getPlayerData()[16];
					columnValues[i][21] = pAverageDataList.getPlayerData()[17];
					columnValues[i][22] = pAverageDataList.getPlayerData()[18];
					columnValues[i][23] = pAverageDataList.getPlayerData()[19];
					columnValues[i][24] = pAverageDataList.getPlayerData()[20];
					columnValues[i][25] = pAverageDataList.getPlayerData()[21];
					columnValues[i][26] = pAverageDataList.getPlayerData()[22];
					columnValues[i][27] = pAverageDataList.getPlayerData()[23];
				}
				
			}

			morePanel.removeAll();

			morePanel.add(initDataTable(columnValues, columnName), 0);

			// TODO average match data table
			JLabel pTable = new JLabel();
			pTable.setBounds(30, 5, 80, 30);
			pTable.setOpaque(false);
			pTable.setText("比赛数据");
			pTable.setForeground(Color.WHITE);
			pTable.setFont(new Font("微软雅黑", Font.PLAIN, 13));
			morePanel.add(pTable, 0);

			JLabel pAver = new JLabel();
			pAver.setBounds(30, 40 - 5, 60, 30);
			pAver.setOpaque(false);
			pAver.setText("场均");
			pAver.setForeground(Color.WHITE);
			pAver.setFont(new Font("微软雅黑", Font.PLAIN, 13));
			morePanel.add(pAver, 0);

			JLabel pAll = new JLabel();
			pAll.setBounds(30, 70 - 5, 60, 30);
			pAll.setOpaque(false);
			pAll.setText("总赛季");
			pAll.setForeground(Color.WHITE);
			pAll.setFont(new Font("微软雅黑", Font.PLAIN, 13));
			morePanel.add(pAll, 0);
			morePanel.repaint();
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

	class PRMListener implements MouseListener {
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			tempButton = "rm";
			PlayWave.startClickSound();
			ArrayList<MatchVO> playerMatch = new ArrayList<MatchVO>();
			playerMatch = mbl.getRecentMatchByPlayer(playerTempID);
			String[] columnName_RM = new String[] { "比赛名称", "胜方", "负方", "比分", "时间" };
			Object[][] columnRMValues = new Object[5][columnName_RM.length];
			
			for (int i = 0; i < 5; i++) {
				columnRMValues[i][0] = playerMatch.get(i).getName();
				columnRMValues[i][1] = playerMatch.get(i).getWinTeam();
				columnRMValues[i][2] = playerMatch.get(i).getLostTeam();
				columnRMValues[i][3] = playerMatch.get(i).getWinPointer()+":"+playerMatch.get(i).getLostPointer();
				columnRMValues[i][4] = playerMatch.get(i).getTime();
			}
			morePanel.removeAll();
			morePanel.add(initRMTable(columnRMValues, columnName_RM), 0);
			morePanel.repaint();
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

	class PAMListener implements MouseListener {
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			tempButton = "am";
			PlayWave.startClickSound();
			ArrayList<MatchVO> playerMatch = new ArrayList<MatchVO>();
			playerMatch = mbl.getMatchByPlayer(playerTempID);
			String[] columnName_AM = new String[] { "比赛名称", "胜方", "负方", "比分", "时间" };
			Object[][] columnAMValues = new Object[playerMatch.size()][columnName_AM.length];
			for (int i = 0; i < playerMatch.size(); i++) {
				columnAMValues[i][0] = playerMatch.get(i).getName();
				columnAMValues[i][1] = playerMatch.get(i).getWinTeam();
				columnAMValues[i][2] = playerMatch.get(i).getLostTeam();
				columnAMValues[i][3] = playerMatch.get(i).getWinPointer()+":"+playerMatch.get(i).getLostPointer();
				columnAMValues[i][4] = playerMatch.get(i).getTime();
			}
			morePanel.removeAll();
			morePanel.add(initAMTable(columnAMValues, columnName_AM), 0);
			morePanel.repaint();
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
	class TeamListener implements MouseListener {
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			pHomePanel.removeAll();
			TeamHomePanel thp = new TeamHomePanel();
			pHomePanel.add(thp.init(teamTempID), 0);
			pHomePanel.repaint();
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
	class TableListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount()==2) {
				if (tempButton.equals("rm")) {
					System.out.println(rMTable.getValueAt(rMTable.getSelectedRow(), rMTable.getSelectedColumn()));
					pHomePanel.removeAll();
					MatchHomePanel mhp = new MatchHomePanel();
					pHomePanel.add(mhp.init(rMTable.getValueAt(rMTable.getSelectedRow(), rMTable.getSelectedColumn()).toString()));
					pHomePanel.repaint();
				} else if (tempButton.equals("am")) {
					System.out.println(aMTable.getValueAt(aMTable.getSelectedRow(), aMTable.getSelectedColumn()));
					pHomePanel.removeAll();
					MatchHomePanel mhp = new MatchHomePanel();
					pHomePanel.add(mhp.init(aMTable.getValueAt(aMTable.getSelectedRow(), aMTable.getSelectedColumn()).toString()));
					pHomePanel.repaint();
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
}
