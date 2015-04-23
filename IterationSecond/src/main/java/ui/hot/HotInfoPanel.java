package ui.hot;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import sound.PlayWave;
import ui.AllImages;
import ui.IComboBox;
import ui.IScrollBarUI;
import ui.MyTable;
import ui.player.PlayerHomePanel;
import ui.team.TeamHomePanel;
import vo.PlayerAverageVO;
import vo.PlayerBasicVO;
import vo.TeamAverageVO;
import vo.TeamBasicVO;
import BL.PlayerBL;
import BL.PlayerBL_Impl;
import BL.TeamBL;
import BL.TeamBL_Impl;

public class HotInfoPanel {
	/**
	 * @param 展示热点信息的界面
	 *          -> 当天热点球员 
	 *                  -> 具有筛选条件下拉框
	 *                  -> 包括但是不仅限于
	 *                         -> 球员名称
	 *                         -> 所属球队 
	 *                         -> 球员位置
	 *                         -> 球员比赛数据[这里只展示该项数据]
	 *                  -> 点击具体球员跳转到球员具体信息界面
	 *          -> 赛季热点球员
	 *                  -> 具有筛选条件下拉框
	 *                  -> 包括但是不仅限于
	 *                         -> 球员名称
	 *                         -> 所属球队
	 *                         -> 球员位置
	 *                         -> 球员比赛数据[这里只展示该项数据]
	 *                  -> 点击具体球员跳转到球员具体信息界面
	 *          -> 赛季热点球队
	 *                  -> 具有筛选条件下拉框
	 *                  -> 包括但是不仅限于
	 *                         -> 球队名称
	 *                         -> 所属联盟
	 *                         -> 球队比赛数据[这里只展示该项数据]
	 *                  -> 点击具体球队跳转到球队具体信息界面
	 *          -> 进步最快球员
	 *                  -> 具有筛选条件下拉框
	 *                  -> 包括但是不仅限于
	 *                         -> 球员名称
	 *                         -> 所属球队
	 *                         -> 球员最近5场比赛的提升率
	 *                         -> 球员比赛数据[这里只展示该项数据]
	 *                  -> 点击具体球员跳转到球员具体信息界面
	 * @author forIris
	 * @version  June 12, 2015 11:41:31 AM
	 * **/
	public static JPanel hotPanel;
	public static JPanel tablePanel;
	public IComboBox c;
	private String[] columnName = null;
	private Object[][] columnValues = null;
	private JScrollPane scrollPane;
	private MyTable topFive;
	
	public JPanel init(){
		hotPanel = new JPanel();
		hotPanel.setOpaque(false);
		hotPanel.setBounds(130, 0, 1000-130, 700);
		hotPanel.setLayout(null);
		
		tablePanel = new JPanel();
		tablePanel.setOpaque(false);
		tablePanel.setBounds(0, 100, 1000-130, 600);
		tablePanel.setLayout(null);
		
		int width = 100;
		int height = 30;
		JButton hotPlayerToday = new JButton();
		hotPlayerToday.setBounds(40, 40, width, height);
		hotPlayerToday.setOpaque(false);
		hotPlayerToday.setContentAreaFilled(false);
		hotPlayerToday.setBorderPainted(false);
		hotPlayerToday.setIcon(AllImages.IMG_TODAYHOTPLAYER);
		hotPlayerToday.addMouseListener(new HotPlayerTodayListener());
		hotPanel.add(hotPlayerToday, 0);
		
		JButton hotPlayerSeason = new JButton();
		hotPlayerSeason.setBounds(140, 40, width, height);
		hotPlayerSeason.setOpaque(false);
		hotPlayerSeason.setContentAreaFilled(false);
		hotPlayerSeason.setBorderPainted(false);
		hotPlayerSeason.setIcon(AllImages.IMG_SEASONHOTPLAYER);
		hotPlayerSeason.addMouseListener(new HotPlayerSeasonListener());
		hotPanel.add(hotPlayerSeason, 0);
		
		JButton hotTeamSeason = new JButton();
		hotTeamSeason.setBounds(240, 40, width, height);
		hotTeamSeason.setOpaque(false);
		hotTeamSeason.setContentAreaFilled(false);
		hotTeamSeason.setBorderPainted(false);
		hotTeamSeason.setIcon(AllImages.IMG_SEASONHOTTEAM);
		hotTeamSeason.addMouseListener(new HotTeamSeasonListener());
		hotPanel.add(hotTeamSeason, 0);
		
		JButton bestPlayer = new JButton();
		bestPlayer.setBounds(340, 40, width, height);
		bestPlayer.setOpaque(false);
		bestPlayer.setContentAreaFilled(false);
		bestPlayer.setBorderPainted(false);
		bestPlayer.setIcon(AllImages.IMG_BESTPLAYER);
		bestPlayer.addMouseListener(new BestPlayerListener());
		hotPanel.add(bestPlayer, 0);
		
		hotPanel.add(tablePanel);
		return hotPanel;
	}
	
	/** TODO
	 *  for hotPlayerToday button
	 *  show comboBox and sure button
	 * */
	public void hotPlayerTodayPanel(){
		Object[] conditionInfo = {"得分","篮板","助攻","盖帽","抢断"};
		c = new IComboBox(conditionInfo);
		c.setBounds(50, 0, 100, 30);
		c.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent arg0) {
				//System.out.println(c.getSelectedItem());
			}
		});;
		JButton sure = new JButton();
		sure.setOpaque(false);
		sure.setContentAreaFilled(false);
		sure.setBorderPainted(false);
		sure.setIcon(AllImages.IMG_SURE);
		sure.setBounds(180, 0, 80, 30);
		sure.addMouseListener(new HPTComboBoxListener());
		tablePanel.add(c, 0);
		tablePanel.add(sure, 0);
	}
	/**TODO
	 * for hotPlayerToday button
	 * show five player info
	 * */
	public void hotPlayerTodayTable(String id){
		PlayerBL pbl = new PlayerBL_Impl();
		ArrayList<PlayerAverageVO> hptList = new ArrayList<PlayerAverageVO>();
		if (id.equals("篮板")) {
			hptList = pbl.getTodayHotPlayerRankingByNum(0);
		} else if (id.equals("得分")) {
			hptList = pbl.getTodayHotPlayerRankingByNum(11);
		} else if (id.equals("助攻")) {
			hptList = pbl.getTodayHotPlayerRankingByNum(1);
		} else if (id.equals("抢断")) {
			hptList = pbl.getTodayHotPlayerRankingByNum(7);
		} else if (id.equals("盖帽")) {
			hptList = pbl.getTodayHotPlayerRankingByNum(8);
		} else {
			System.out.println("HotInfoPanel-hotPlayerToday-InvalidChoose.");
		}
		columnName = new String[] { "球员头像", "球员名称", "所属球队", "球员位置", "数据" };
		columnValues = new Object[5][columnName.length];
		for (int i = 0; i < 5; i++) {
			columnValues[i][0] = new ImageIcon("playerImg/portrait/"+hptList.get(i).getName()+".png");
			columnValues[i][1] = hptList.get(i).getName();
			columnValues[i][2] = hptList.get(i).getTeamList().get(hptList.get(i).getTeamList().size()-1);
			PlayerBasicVO forPosition = new PlayerBasicVO(hptList.get(i).getName());
			columnValues[i][3] = forPosition.getBasicInfo()[1];
			columnValues[i][4] = hptList.get(i).getPlayerData()[1];//
		}
		topFive = new MyTable(columnValues, columnName);
		topFive.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		topFive.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		topFive.setForeground(Color.white);
		topFive.setRowHeight(50);
		topFive.setBounds(40, 50, 1000-130-100, 480);
		topFive.setOpaque(false);
		
		topFive.addMouseListener(new TablePListener());

		topFive.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		
	    scrollPane = new JScrollPane();
	    scrollPane.setColumnHeaderView(topFive.getTableHeader());	//设置头部（HeaderView部分）  
	    scrollPane.getColumnHeader().setOpaque(false);	//再取出头部，并设置为透明  
	    
	    scrollPane.setViewportView(topFive);	//装载表格  
	    scrollPane.setOpaque(false);
	    scrollPane.getViewport().setOpaque(false);
	    scrollPane.getVerticalScrollBar().setUI(new IScrollBarUI());
        scrollPane.getHorizontalScrollBar().setUI(new IScrollBarUI());
	    
        tablePanel.add(scrollPane);
		scrollPane.setBounds(40, 50, 1000-130-100, 480);
		scrollPane.setOpaque(false);
	}
	/**TODO
	 * for hotPlayerSeason button
	 * show comboBox and sure button
	 * */
	public void hotPlayerSeasonPanel(){
		Object[] conditionInfo = {"场均得分","场均篮板","场均助攻","场均盖帽","场均抢断","三分命中率","投篮命中率","罚球命中率"};
		c = new IComboBox(conditionInfo);
		c.setBounds(50, 0, 100, 30);
		c.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(c.getSelectedItem());
			}
		});;
		JButton sure = new JButton();
		sure.setOpaque(false);
		sure.setContentAreaFilled(false);
		sure.setBorderPainted(false);
		sure.setIcon(AllImages.IMG_SURE);
		sure.setBounds(180, 0, 80, 30);
		sure.addMouseListener(new HPSComboBoxListener());
		tablePanel.add(c, 0);
		tablePanel.add(sure, 0);
	}
	
	/**TODO
	 * for hotPlayerSeason button
	 * show five player info
	 * */
	public void hotPlayerSeasonTable(String id){
		PlayerBL pbl = new PlayerBL_Impl();
		ArrayList<PlayerAverageVO> hpsList = new ArrayList<PlayerAverageVO>();
		if (id.equals("篮板")) {
			hpsList = pbl.getHotPlayerRankingByNum(0);
		} else if (id.equals("得分")) {
			hpsList = pbl.getHotPlayerRankingByNum(11);
		} else if (id.equals("助攻")) {
			hpsList = pbl.getHotPlayerRankingByNum(1);
		} else if (id.equals("抢断")) {
			hpsList = pbl.getHotPlayerRankingByNum(7);
		} else if (id.equals("盖帽")) {
			hpsList = pbl.getHotPlayerRankingByNum(8);
		} else {
			System.out.println("HotInfoPanel-hotPlayerToday-InvalidChoose.");
		}
		columnName = new String[] { "球员头像", "球员名称", "所属球队", "位置", "数据","排名" };
		columnValues = new Object[5][columnName.length];
		for (int i = 0; i < 5; i++) {

			columnValues[i][0] = new ImageIcon("playerImg/portrait/"+hpsList.get(i).getName()+".png");
			columnValues[i][1] = hpsList.get(i).getName();
			columnValues[i][2] = hpsList.get(i).getTeamList().get(hpsList.get(i).getTeamList().size()-1);
			PlayerBasicVO forPosition = new PlayerBasicVO(hpsList.get(i).getName());
			columnValues[i][3] = forPosition.getBasicInfo()[1];
			columnValues[i][4] = hpsList.get(i).getPlayerData()[1];
			columnValues[i][5] = i+1;
		}
		topFive = new MyTable(columnValues, columnName);
		topFive.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		topFive.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		topFive.setForeground(Color.white);
		topFive.setRowHeight(50);
		topFive.setBounds(40, 50, 1000-130-100, 480);
		topFive.setOpaque(false);
		
		topFive.addMouseListener(new TablePListener());

		topFive.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		
	    scrollPane = new JScrollPane();
	    scrollPane.setColumnHeaderView(topFive.getTableHeader());	//设置头部（HeaderView部分）  
	    scrollPane.getColumnHeader().setOpaque(false);	//再取出头部，并设置为透明  
	    
	    scrollPane.setViewportView(topFive);	//装载表格  
	    scrollPane.setOpaque(false);
	    scrollPane.getViewport().setOpaque(false);
	    scrollPane.getVerticalScrollBar().setUI(new IScrollBarUI());
        scrollPane.getHorizontalScrollBar().setUI(new IScrollBarUI());
	    
        tablePanel.add(scrollPane);
		scrollPane.setBounds(40, 50, 1000-130-100, 480);
		scrollPane.setOpaque(false);
	}
	
	/**TODO
	 * for hotTeamSeason button
	 * show comboBox and sure button
	 * */
	public void hotTeamSeasonPanel(){
		Object[] conditionInfo = { "场均得分","场均篮板","场均助攻","场均盖帽","场均抢断","三分命中率","投篮命中率","罚球命中率"};
		c = new IComboBox(conditionInfo);
		c.setBounds(50, 0, 100, 30);
		c.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(c.getSelectedItem());
			}
		});;
		JButton sure = new JButton();
		sure.setOpaque(false);
		sure.setContentAreaFilled(false);
		sure.setBorderPainted(false);
		sure.setIcon(AllImages.IMG_SURE);
		sure.setBounds(180, 0, 80, 30);
		sure.addMouseListener(new HTSComboBoxListener());
		tablePanel.add(c, 0);
		tablePanel.add(sure, 0);
	}
	
	/**TODO
	 * for hotTeamSeason button
	 * show five team info
	 * */
	public void hotTeamSeasonTable(String id){
		//"场均得分","场均篮板","场均助攻","场均盖帽",
		//"场均抢断","三分命中率","投篮命中率","罚球命中率"
		TeamBL tbl = new TeamBL_Impl();
		ArrayList<TeamAverageVO> htsList = new ArrayList<TeamAverageVO>();
		if (id.equals("场均得分")) {
			htsList = tbl.getHotTeamByNum(14);
		} else if (id.equals("场均篮板")) {
			htsList = tbl.getHotTeamByNum(8);
		} else if (id.equals("场均助攻")) {
			htsList = tbl.getHotTeamByNum(9);
		} else if (id.equals("场均盖帽")) {
			htsList = tbl.getHotTeamByNum(11);
		} else if (id.equals("场均抢断")) {
			htsList = tbl.getHotTeamByNum(10);
		} else if (id.equals("三分命中率")) {
			htsList = tbl.getHotTeamByNum(16);
		} else if (id.equals("投篮命中率")) {
			htsList = tbl.getHotTeamByNum(15);
		} else if (id.equals("罚球命中率")) {
			htsList = tbl.getHotTeamByNum(17);
		} else {
			System.out.println("HotInfoPanel-hotTeamSeasonTable-InvalidInput.");
		}
		
		columnName = new String[] { "球队名称", "联盟", "数据" };
		columnValues = new Object[5][columnName.length];
		for (int i = 0; i < 5; i++) {
			columnValues[i][0] = htsList.get(i).getTeamName();
			TeamBasicVO forLeague = new TeamBasicVO(htsList.get(i).getTeamName());
			columnValues[i][1] = forLeague.getTeamInfo()[3]+"-"+forLeague.getTeamInfo()[4];
			columnValues[i][2] = htsList.get(i).getTeamData()[1];
		}
		
		topFive = new MyTable(columnValues, columnName);
		topFive.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		topFive.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		topFive.setForeground(Color.white);
		topFive.setRowHeight(50);
		topFive.setBounds(40, 50, 1000-130-100, 480);
		topFive.setOpaque(false);
		
		topFive.addMouseListener(new TableTListener());

		topFive.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		
	    scrollPane = new JScrollPane();
	    scrollPane.setColumnHeaderView(topFive.getTableHeader());	//设置头部（HeaderView部分）  
	    scrollPane.getColumnHeader().setOpaque(false);	//再取出头部，并设置为透明  
	    
	    scrollPane.setViewportView(topFive);	//装载表格  
	    scrollPane.setOpaque(false);
	    scrollPane.getViewport().setOpaque(false);
	    scrollPane.getVerticalScrollBar().setUI(new IScrollBarUI());
        scrollPane.getHorizontalScrollBar().setUI(new IScrollBarUI());
	    
        tablePanel.add(scrollPane);
		scrollPane.setBounds(40, 50, 1000-130-100, 480);
		scrollPane.setOpaque(false);
	}
	
	/**TODO
	 * for bestPlayer button
	 * show comboBox and sure button
	 * */
	public void bestPlayerPanel(){
		Object[] conditionInfo = {"场均得分","场均篮板","场均助攻"};
		c = new IComboBox(conditionInfo);
		c.setBounds(50, 0, 100, 30);
		c.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(c.getSelectedItem());
			}
		});;
		JButton sure = new JButton();
		sure.setOpaque(false);
		sure.setContentAreaFilled(false);
		sure.setBorderPainted(false);
		sure.setIcon(AllImages.IMG_SURE);
		sure.setBounds(180, 0, 80, 30);
		sure.addMouseListener(new BPComboBoxListener());
		tablePanel.add(c, 0);
		tablePanel.add(sure, 0);
	}
	
	/**TODO
	 * for bestPlayer button
	 * show five player info
	 * */
	public void bestPlayerTable(String id){
		PlayerBL pbl = new PlayerBL_Impl();
		ArrayList<PlayerAverageVO> bpList = new ArrayList<PlayerAverageVO>();
		//"场均得分","场均篮板","场均助攻"
		if (id.equals(id.equals("场均得分"))) {
			bpList = pbl.getMostImprovedPlayerByNum(11);
		} else if (id.equals("场均篮板")) {
			bpList = pbl.getMostImprovedPlayerByNum(0);
		} else if (id.equals("场均助攻")) {
			bpList = pbl.getMostImprovedPlayerByNum(1);
		} else {
			System.out.println("HotInfoPanel-BestPlayerTable-InvalidInput");
		}
		columnName = new String[] { "球员头像", "球员名称", "所属球队", "最近五场比赛提升率","数据" };
		columnValues = new Object[5][columnName.length];
		for (int i = 0; i < 5; i++) {

			columnValues[i][0] = new ImageIcon("playerImg/portrait/"+bpList.get(i).getName()+".png");
			columnValues[i][1] = bpList.get(i).getName();
			columnValues[i][2] = bpList.get(i).getTeamList().get(bpList.get(i).getTeamList().size()-1);
			columnValues[i][3] = bpList.get(i).getPlayerData()[1];
			columnValues[i][4] = bpList.get(i).getPlayerData()[2];
		}
		topFive = new MyTable(columnValues, columnName);
		topFive.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		topFive.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		topFive.setForeground(Color.white);
		topFive.setRowHeight(50);
		topFive.setBounds(40, 50, 1000-130-100, 480);
		topFive.setOpaque(false);
		
		topFive.addMouseListener(new TablePListener());

		topFive.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		
	    scrollPane = new JScrollPane();
	    scrollPane.setColumnHeaderView(topFive.getTableHeader());	//设置头部（HeaderView部分）  
	    scrollPane.getColumnHeader().setOpaque(false);	//再取出头部，并设置为透明  
	    
	    scrollPane.setViewportView(topFive);	//装载表格  
	    scrollPane.setOpaque(false);
	    scrollPane.getViewport().setOpaque(false);
	    scrollPane.getVerticalScrollBar().setUI(new IScrollBarUI());
        scrollPane.getHorizontalScrollBar().setUI(new IScrollBarUI());
	    
        tablePanel.add(scrollPane);
		scrollPane.setBounds(40, 50, 1000-130-100, 480);
		scrollPane.setOpaque(false);
	}
	
	//TODO 
	class HotPlayerTodayListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			PlayWave.startClickSound();
			tablePanel.removeAll();
			hotPlayerTodayPanel();
			tablePanel.repaint();
			hotPanel.repaint();
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
	class HPTComboBoxListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			PlayWave.startClickSound();
			hotPlayerTodayTable(c.getSelectedItem().toString());
			tablePanel.repaint();
			hotPanel.repaint();
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
	class HotPlayerSeasonListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			PlayWave.startClickSound();
			tablePanel.removeAll();
			hotPlayerSeasonPanel();
			tablePanel.repaint();
			hotPanel.repaint();
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
	class HPSComboBoxListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			PlayWave.startClickSound();
			hotPlayerSeasonTable(c.getSelectedItem().toString());
			tablePanel.repaint();
			hotPanel.repaint();
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
	class HotTeamSeasonListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			PlayWave.startClickSound();
			tablePanel.removeAll();
			hotTeamSeasonPanel();
			tablePanel.repaint();
			hotPanel.repaint();
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
	class HTSComboBoxListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			PlayWave.startClickSound();
			hotTeamSeasonTable(c.getSelectedItem().toString());
			tablePanel.repaint();
			hotPanel.repaint();
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
	class BestPlayerListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			PlayWave.startClickSound();
			tablePanel.removeAll();
			bestPlayerPanel();
			tablePanel.repaint();
			hotPanel.repaint();
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
	class BPComboBoxListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			PlayWave.startClickSound();
			bestPlayerTable(c.getSelectedItem().toString());
			tablePanel.repaint();
			hotPanel.repaint();
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
	
	// TODO 
	class TablePListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			if(e.getClickCount()==2){
				System.out.println(topFive.getValueAt(topFive.getSelectedRow(), topFive.getSelectedColumn()));
				if (topFive.getSelectedColumn()==0) {
					hotPanel.removeAll();
					PlayerHomePanel php = new PlayerHomePanel();
					hotPanel.add(php.init(topFive.getValueAt(topFive.getSelectedRow(), topFive.getSelectedColumn()+1).toString()));
					hotPanel.repaint();
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
	// TODO 
	class TableTListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			if(e.getClickCount()==2){
				System.out.println(topFive.getValueAt(topFive.getSelectedRow(), topFive.getSelectedColumn()));
				if (topFive.getSelectedColumn()==0) {
					hotPanel.removeAll();
					TeamHomePanel thp = new TeamHomePanel();
					hotPanel.add(thp.init(topFive.getValueAt(topFive.getSelectedRow(), topFive.getSelectedColumn()+1).toString()));
					hotPanel.repaint();
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
