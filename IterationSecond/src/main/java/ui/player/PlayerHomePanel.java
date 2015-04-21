package ui.player;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.ListSelectionModel;

import ui.IScrollBarUI;
import ui.MyStringTable;

public class PlayerHomePanel {
	/**
	 * @param 球员的个人主页
	 *         -> 球员头像+动态图片
	 *         -> 球员的个人基本信息
	 *         -> 球员的比赛数据[场均和总赛季]
	 * @author forIris
	 * @version  June 13, 2015 15:54:31 PM
	 * **/
	
	private JPanel pHomePanel;
	private JScrollPane scrollPaneP;
	private MyStringTable playerTable;
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
	
	public JPanel init(String playerID){
		pHomePanel = new JPanel();
		pHomePanel.setOpaque(false);
		pHomePanel.setBounds(0, 0, 1000-130, 700);
		pHomePanel.setLayout(null);
		
		//TODO player photo
		playerPhoto = new JButton();
		playerPhoto.setBounds(30, 50, 176, 280);
		playerPhoto.setOpaque(false);
		playerPhoto.setContentAreaFilled(false);
		playerPhoto.setBorderPainted(false);
		playerPhoto.setIcon(new ImageIcon("playerImg/action/Aaron Brooks.png"));
		pHomePanel.add(playerPhoto, 0);
		
		//TODO basic info labels - name-jerseyNum-position-
		//height-weight-birth-age-exp-school-team
		int toLeftFirst = 230;
		int toLeftSecond = 390;
		int width = 100;
		int height = 30;
		
		playerName = new JButton();
		playerName.setBounds(toLeftFirst, 80, width, height);
		playerName.setOpaque(false);
		playerName.setContentAreaFilled(false);
		playerName.setBorderPainted(false);
		playerName.setText("姓名");
		pHomePanel.add(playerName, 0);
		
		//TODO
		JLabel pName = new JLabel();
		pName.setBounds(toLeftFirst+100, 80, width, height);
		pName.setOpaque(false);
		pName.setText("aron");
		pHomePanel.add(pName, 0);
		
		playerJerseyNum = new JButton();
		playerJerseyNum.setBounds(toLeftFirst, 130, width, height);
		playerJerseyNum.setOpaque(false);
		playerJerseyNum.setContentAreaFilled(false);
		playerJerseyNum.setBorderPainted(false);
		playerJerseyNum.setText("球衣号码");
		pHomePanel.add(playerJerseyNum, 0);
		
		//TODO
		JLabel pJerseyNum = new JLabel();
		pJerseyNum.setBounds(toLeftFirst+100, 130, width, height);
		pJerseyNum.setOpaque(false);
		pJerseyNum.setText("19");
		pHomePanel.add(pJerseyNum, 0);
		
		
		playerPosition = new JButton();
		playerPosition.setBounds(toLeftFirst, 180, width, height);
		playerPosition.setOpaque(false);
		playerPosition.setContentAreaFilled(false);
		playerPosition.setBorderPainted(false);
		playerPosition.setText("位置");
		pHomePanel.add(playerPosition, 0);
		
		//TODO
		JLabel pPosition = new JLabel();
		pPosition.setBounds(toLeftFirst+100, 180, width, height);
		pPosition.setOpaque(false);
		pPosition.setText("F");
		pHomePanel.add(pPosition, 0);
		
		playerHeight = new JButton();
		playerHeight.setBounds(toLeftFirst, 230, width, height);
		playerHeight.setOpaque(false);
		playerHeight.setContentAreaFilled(false);
		playerHeight.setBorderPainted(false);
		playerHeight.setText("身高");
		pHomePanel.add(playerHeight, 0);
		
		//TODO
		JLabel pHeight = new JLabel();
		pHeight.setBounds(toLeftFirst+100, 230, width, height);
		pHeight.setOpaque(false);
		pHeight.setText("174");
		pHomePanel.add(pHeight, 0);
		
		playerWeight = new JButton();
		playerWeight.setBounds(toLeftFirst, 280, width, height);
		playerWeight.setOpaque(false);
		playerWeight.setContentAreaFilled(false);
		playerWeight.setBorderPainted(false);
		playerWeight.setText("体重");
		pHomePanel.add(playerWeight, 0);
		
		//TODO
		JLabel pWeight = new JLabel();
		pWeight.setBounds(toLeftFirst+100, 280, width, height);
		pWeight.setOpaque(false);
		pWeight.setText("60kg");
		pHomePanel.add(pWeight, 0);
		
		//
		playerBirth = new JButton();
		playerBirth.setBounds(toLeftSecond, 80, width, height);
		playerBirth.setOpaque(false);
		playerBirth.setContentAreaFilled(false);
		playerBirth.setBorderPainted(false);
		playerBirth.setText("生日");
		pHomePanel.add(playerBirth, 0);
		
		//TODO
		JLabel pBirth = new JLabel();
		pBirth.setBounds(toLeftSecond+100, 80, width, height);
		pBirth.setOpaque(false);
		pBirth.setText("96-01-19");
		pHomePanel.add(pBirth, 0);
		
		playerAge = new JButton();
		playerAge.setBounds(toLeftSecond, 130, width, height);
		playerAge.setOpaque(false);
		playerAge.setContentAreaFilled(false);
		playerAge.setBorderPainted(false);
		playerAge.setText("年龄");
		pHomePanel.add(playerAge, 0);
		
		//TODO
		JLabel pAge = new JLabel();
		pAge.setBounds(toLeftSecond+100, 130, width, height);
		pAge.setOpaque(false);
		pAge.setText("19");
		pHomePanel.add(pAge, 0);
		
		playerExp = new JButton();
		playerExp.setBounds(toLeftSecond, 180, width, height);
		playerExp.setOpaque(false);
		playerExp.setContentAreaFilled(false);
		playerExp.setBorderPainted(false);
		playerExp.setText("球龄");
		pHomePanel.add(playerExp, 0);
		
		//TODO
		JLabel pExp = new JLabel();
		pExp.setBounds(toLeftSecond+100, 180, width, height);
		pExp.setOpaque(false);
		pExp.setText("1.5 years");
		pHomePanel.add(pExp, 0);
		
		playerSchool = new JButton();
		playerSchool.setBounds(toLeftSecond, 230, width, height);
		playerSchool.setOpaque(false);
		playerSchool.setContentAreaFilled(false);
		playerSchool.setBorderPainted(false);
		playerSchool.setText("毕业学校");
		pHomePanel.add(playerSchool, 0);
		
		//TODO
		JLabel pSchool = new JLabel();
		pSchool.setBounds(toLeftSecond+100, 230, width, height);
		pSchool.setOpaque(false);
		pSchool.setText("CPU");
		pHomePanel.add(pSchool, 0);
		
		playerTeam = new JButton();
		playerTeam.setBounds(550, 100, 100, 100);
		playerTeam.setOpaque(false);
		playerTeam.setContentAreaFilled(false);
		playerTeam.setBorderPainted(false);
		playerTeam.setText("所属球队");
		pHomePanel.add(playerTeam, 0);
		
		//TODO average match data table
		JLabel pTable = new JLabel();
		pTable.setBounds(30, 350, width, height);
		pTable.setOpaque(false);
		pTable.setText("比赛数据");
		pHomePanel.add(pTable, 0);
		
		JLabel pAver = new JLabel();
		pAver.setBounds(30, 410-5, 60, 30);
		pAver.setOpaque(false);
		pAver.setText("场均");
		pHomePanel.add(pAver, 0);
		
		JLabel pAll = new JLabel();
		pAll.setBounds(30, 440-5, 60, 30);
		pAll.setOpaque(false);
		pAll.setText("总赛季");
		pHomePanel.add(pAll, 0);
		
		String[] columnName = new String[] {"Tag", "参赛场数", "先发场数",
				"篮板数", "助攻数", "在场时间","投篮命中率",
				"三分命中率","罚球命中率","进攻数","防守数" ,
				"抢断数","盖帽数","失误数" ,"犯规数",
				"得分","效率" ,"GmSc效率值","真实命中数","投篮效率",
				"篮板率","进攻篮板率","防守篮板率","助攻率",
				"抢断率","盖帽率" ,
				"失误率","使用率"};
		Object[][] columnValues = new Object[2][columnName.length];
		for (int i = 0; i < 2; i++) {
			if(i%2==0){
				columnValues[i][0] = "总赛季";
			} else {
				columnValues[i][0] = "场均";
			}
			columnValues[i][1] = i;
			columnValues[i][2] = i;
			columnValues[i][3] = i;
			columnValues[i][4] = i;
			columnValues[i][5] = i;
			columnValues[i][6] = i;
			columnValues[i][7] = i;
			columnValues[i][8] = i;
			columnValues[i][9] = i;
			columnValues[i][10] = i;
			columnValues[i][11] = i;
			columnValues[i][12] = i;
			columnValues[i][13] = i;
			columnValues[i][14] = i;
			columnValues[i][15] = i;
			columnValues[i][16] = i;
			columnValues[i][17] = i;
			columnValues[i][18] = i;
			columnValues[i][19] = i;
			columnValues[i][20] = i;
			columnValues[i][21] = i;
			columnValues[i][22] = i;
			columnValues[i][23] = i;
			columnValues[i][24] = i;
			columnValues[i][25] = i;
			columnValues[i][26] = i;
			columnValues[i][27] = i;
		}
		playerTable = new MyStringTable(columnValues, columnName);
		playerTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		playerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		playerTable.setForeground(Color.white);
		playerTable.setRowHeight(30);
		playerTable.setBounds(90, 380, 1000-130-100-60, 105);
		playerTable.setOpaque(false);
		
		//playerAverage.addMouseListener(new TableListener());

		playerTable.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
		String[] name = {"Test"};
		Object[][] value = new Object[2][1];
		value[0][0] = "ave";
		value[1][0] = "all";
		MyStringTable tt = new MyStringTable(value, name);
		tt.setForeground(Color.WHITE);
		tt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tt.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tt.setRowHeight(30);
		tt.setOpaque(false);
		tt.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
	    scrollPaneP = new JScrollPane();
	    scrollPaneP.setColumnHeaderView(playerTable.getTableHeader());	//设置头部（HeaderView部分）  
	    scrollPaneP.getColumnHeader().setOpaque(false);	//再取出头部，并设置为透明  
	    
	    scrollPaneP.setViewportView(playerTable);	//装载表格  
	    scrollPaneP.setOpaque(false);
	    scrollPaneP.getViewport().setOpaque(false);
	    scrollPaneP.getVerticalScrollBar().setUI(new IScrollBarUI());
	    scrollPaneP.getHorizontalScrollBar().setUI(new IScrollBarUI());
	    
        pHomePanel.add(scrollPaneP);
        scrollPaneP.setBounds(90, 380, 1000-130-100-60, 105);
        scrollPaneP.setOpaque(false);
		return pHomePanel;
	}

}
