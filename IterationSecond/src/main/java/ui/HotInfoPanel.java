package ui;

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
	public IComboBox c;
	private String[] columnName = null;
	private Object[][] columnValues = null;
	private JScrollPane scrollPane;
	
	public JPanel init(){
		hotPanel = new JPanel();
		hotPanel.setOpaque(false);
		hotPanel.setBounds(0, 0, 1000-130, 700);
		hotPanel.setLayout(null);
		
		int width = 100;
		int height = 30;
		JButton hotPlayerToday = new JButton();
		hotPlayerToday.setBounds(40, 40, width, height);
		hotPlayerToday.setOpaque(false);
		hotPlayerToday.setContentAreaFilled(false);
		hotPlayerToday.setBorderPainted(false);
		hotPlayerToday.setIcon(AllImages.IMG_TODAYHOTPLAYER);
		//hotPlayerToday.addMouseListener(new HotInfoListener());
		hotPanel.add(hotPlayerToday, 0);
		
		JButton hotPlayerSeason = new JButton();
		hotPlayerSeason.setBounds(140, 40, width, height);
		hotPlayerSeason.setOpaque(false);
		hotPlayerSeason.setContentAreaFilled(false);
		hotPlayerSeason.setBorderPainted(false);
		hotPlayerSeason.setIcon(AllImages.IMG_SEASONHOTPLAYER);
		//hotPlayerSeason.addMouseListener(new HotInfoListener());
		hotPanel.add(hotPlayerSeason, 0);
		
		JButton hotTeamSeason = new JButton();
		hotTeamSeason.setBounds(240, 40, width, height);
		hotTeamSeason.setOpaque(false);
		hotTeamSeason.setContentAreaFilled(false);
		hotTeamSeason.setBorderPainted(false);
		hotTeamSeason.setIcon(AllImages.IMG_SEASONHOTTEAM);
		//hotPlayerSeason.addMouseListener(new HotInfoListener());
		hotPanel.add(hotTeamSeason, 0);
		
		JButton bestPlayer = new JButton();
		bestPlayer.setBounds(340, 40, width, height);
		bestPlayer.setOpaque(false);
		bestPlayer.setContentAreaFilled(false);
		bestPlayer.setBorderPainted(false);
		bestPlayer.setIcon(AllImages.IMG_BESTPLAYER);
		//hotPlayerSeason.addMouseListener(new HotInfoListener());
		hotPanel.add(bestPlayer, 0);
		
		Object[] conditionInfo = {"score","rebound","assisting","blockShot","steal"};
		c = new IComboBox(conditionInfo);
		c.setBounds(50, 100, 100, 30);
		c.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(c.getSelectedItem());
			}
		});;
		hotPanel.add(c, 0);
		
		columnName = new String[] { "球员名称", "所属球队", "球员位置", "数据" };
		columnValues = new Object[30][columnName.length];
		for (int i = 0; i < 30; i++) {

			columnValues[i][0] = i;
			columnValues[i][1] = i;
			columnValues[i][2] = i;
			columnValues[i][3] = i;
		}
		JTable topFive = new MyTable(columnValues, columnName);
		topFive.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		topFive.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		topFive.setForeground(Color.white);
		topFive.setRowHeight(35);
		topFive.setBounds(40, 150, 1000-130-80, 480);
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
	    
	    hotPanel.add(scrollPane);
		scrollPane.setBounds(40, 150, 1000-130-80, 480);
		scrollPane.setOpaque(false);
		hotPanel.setLayout(null);
		return hotPanel;
	}
	class ComboBoxListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			System.out.println("0"+c.getSelectedItem());
		}

		public void mouseEntered(MouseEvent e) {
			System.out.println("1"+c.getSelectedItem());
		}

		public void mouseExited(MouseEvent e) {
			
		}

		public void mousePressed(MouseEvent e) {
			
		}

		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
