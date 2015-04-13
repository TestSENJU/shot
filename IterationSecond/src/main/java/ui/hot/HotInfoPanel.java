package ui.hot;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import sound.PlayWave;
import ui.AllImages;
import ui.IComboBox;
import ui.IScrollBarUI;
import ui.InitailizePanel;
import ui.MyTable;
import ui.player.PlayerPanel;

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
	private JPanel hotPanel;
	private JPanel tablePanel;
	public IComboBox c;
	private String[] columnName = null;
	private Object[][] columnValues = null;
	private JScrollPane scrollPane;
	private MyTable topFive;
	
	public JPanel init(){
		hotPanel = new JPanel();
		hotPanel.setOpaque(false);
		hotPanel.setBounds(0, 0, 1000-130, 700);
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
				System.out.println(c.getSelectedItem());
			}
		});;
		JButton sure = new JButton();
		sure.setOpaque(false);
		sure.setText("sure");
		sure.setBounds(180, 0, 80, 30);
		sure.addMouseListener(new HPTComboBoxListener());
		tablePanel.add(c, 0);
		tablePanel.add(sure, 0);
	}
	/**TODO
	 * for hotPlayerToday button
	 * show five player info
	 * */
	public void hotPlayerTodayTable(){
		columnName = new String[] { "球员头像", "球员名称", "所属球队", "球员位置", "数据" };
		columnValues = new Object[30][columnName.length];
		for (int i = 0; i < 30; i++) {
			columnValues[i][0] = i;
			columnValues[i][1] = i;
			columnValues[i][2] = i;
			columnValues[i][3] = i;
			columnValues[i][4] = i;
		}
		topFive = new MyTable(columnValues, columnName);
		topFive.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		topFive.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		topFive.setForeground(Color.white);
		topFive.setRowHeight(50);
		topFive.setBounds(40, 50, 1000-130-100, 480);
		topFive.setOpaque(false);
		
		topFive.addMouseListener(new TableListener());

		topFive.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
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
		sure.setText("sure");
		sure.setBounds(180, 0, 80, 30);
		sure.addMouseListener(new HPSComboBoxListener());
		tablePanel.add(c, 0);
		tablePanel.add(sure, 0);
	}
	
	/**TODO
	 * for hotPlayerSeason button
	 * show five player info
	 * */
	public void hotPlayerSeasonTable(){
		columnName = new String[] { "球员头像", "球员名称", "所属球队", "位置", "数据" };
		columnValues = new Object[30][columnName.length];
		for (int i = 0; i < 30; i++) {

			columnValues[i][0] = i+1;
			columnValues[i][1] = i+1;
			columnValues[i][2] = i+1;
			columnValues[i][3] = i+1;
			columnValues[i][4] = i+1;
		}
		JTable topFive = new MyTable(columnValues, columnName);
		topFive.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		topFive.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		topFive.setForeground(Color.white);
		topFive.setRowHeight(50);
		topFive.setBounds(40, 50, 1000-130-100, 480);
		topFive.setOpaque(false);

		topFive.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
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
		sure.setText("sure");
		sure.setBounds(180, 0, 80, 30);
		sure.addMouseListener(new HTSComboBoxListener());
		tablePanel.add(c, 0);
		tablePanel.add(sure, 0);
	}
	
	/**TODO
	 * for hotTeamSeason button
	 * show five team info
	 * */
	public void hotTeamSeasonTable(){
		columnName = new String[] { "球队头像", "球队名称", "联盟", "数据" };
		columnValues = new Object[30][columnName.length];
		for (int i = 0; i < 30; i++) {

			columnValues[i][0] = i+2;
			columnValues[i][1] = i+2;
			columnValues[i][2] = i+2;
			columnValues[i][3] = i+2;
		}
		JTable topFive = new MyTable(columnValues, columnName);
		topFive.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		topFive.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		topFive.setForeground(Color.white);
		topFive.setRowHeight(50);
		topFive.setBounds(40, 50, 1000-130-100, 480);
		topFive.setOpaque(false);

		topFive.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
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
		sure.setText("sure");
		sure.setBounds(180, 0, 80, 30);
		sure.addMouseListener(new BPComboBoxListener());
		tablePanel.add(c, 0);
		tablePanel.add(sure, 0);
	}
	
	/**TODO
	 * for bestPlayer button
	 * show five player info
	 * */
	public void bestPlayerTable(){
		columnName = new String[] { "球员头像", "球员名称", "所属球队", "最近五场比赛提升率","数据" };
		columnValues = new Object[30][columnName.length];
		for (int i = 0; i < 30; i++) {

			columnValues[i][0] = i+3;
			columnValues[i][1] = i+3;
			columnValues[i][2] = i+3;
			columnValues[i][3] = i+3;
			columnValues[i][4] = i+3;
		}
		JTable topFive = new MyTable(columnValues, columnName);
		topFive.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		topFive.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		topFive.setForeground(Color.white);
		topFive.setRowHeight(50);
		topFive.setBounds(40, 50, 1000-130-100, 480);
		topFive.setOpaque(false);

		topFive.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
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
			hotPlayerTodayTable();
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
			hotPlayerSeasonTable();
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
			hotTeamSeasonTable();
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
			bestPlayerTable();
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
	class TableListener implements MouseListener {

		public void mouseClicked(MouseEvent arg0) {
			System.out.println(topFive.getValueAt(topFive.getSelectedRow(), topFive.getSelectedColumn()));
			hotPanel.setVisible(false);
			PlayerPanel pp = new PlayerPanel();
			JPanel p = pp.init();
			InitailizePanel.infoPanel.add(p);
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
