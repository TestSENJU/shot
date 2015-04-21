package ui.player;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import ui.AllImages;
import ui.IScrollBarUI;
import ui.MyTable;

public class PlayerPanel {
	/**
	 * @param 展示所有球员基本信息的表格界面
	 *         ->双击表格球员头像可以进入球员具体信息界面
	 * @author forIris
	 * @version  June 12, 2015 11:41:31 AM
	 * **/
	private JPanel playerPanel;
	private JScrollPane scrollPane;
	private MyTable players;
	private JButton panelTitle;

	public JPanel init(){
		playerPanel = new JPanel();
		playerPanel.setOpaque(false);
		playerPanel.setBounds(130, 0, 1000-130, 700);
		playerPanel.setLayout(null);
		
		panelTitle = new JButton();
		panelTitle.setBounds(40, 15, 300, 70);
		panelTitle.setOpaque(false);
		panelTitle.setContentAreaFilled(false);
		panelTitle.setBorderPainted(false);
		panelTitle.setIcon(AllImages.IMG_PLAYERPANEL_TITLE);
		playerPanel.add(panelTitle, 0);
		
		String[] columnName = new String[] { "球员头像", "球员名称", "球衣号码", "球员位置", "身高","体重","生日","年龄","球龄","毕业学校" };
		Object[][] columnValues = new Object[30][columnName.length];
		for (int i = 0; i < 30; i++) {
			columnValues[i][0] = i;
			columnValues[i][1] = i;
			columnValues[i][2] = i;
			columnValues[i][3] = i;
			columnValues[i][4] = i;
			columnValues[i][5] = i;
			columnValues[i][6] = i;
			columnValues[i][7] = i;
			columnValues[i][8] = i;
			columnValues[i][9] = i;
		}
		players = new MyTable(columnValues, columnName);
		players.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		players.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		players.setForeground(Color.white);
		players.setRowHeight(50);
		players.setBounds(40, 100, 1000-130-100, 480);
		players.setOpaque(false);
		
		players.addMouseListener(new TableListener());

		players.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
	    scrollPane = new JScrollPane();
	    scrollPane.setColumnHeaderView(players.getTableHeader());	//设置头部（HeaderView部分）  
	    scrollPane.getColumnHeader().setOpaque(false);	//再取出头部，并设置为透明  
	    
	    scrollPane.setViewportView(players);	//装载表格  
	    scrollPane.setOpaque(false);
	    scrollPane.getViewport().setOpaque(false);
	    scrollPane.getVerticalScrollBar().setUI(new IScrollBarUI());
        scrollPane.getHorizontalScrollBar().setUI(new IScrollBarUI());
	    
        playerPanel.add(scrollPane);
		scrollPane.setBounds(40, 100, 1000-130-100, 480);
		scrollPane.setOpaque(false);
		
		return playerPanel;
	}
	
	// TODO 
	class TableListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			if(e.getClickCount()==2){
				System.out.println(players.getValueAt(players.getSelectedRow(), players.getSelectedColumn()));
				if (players.getSelectedColumn()==0) {
					playerPanel.removeAll();
					PlayerHomePanel php = new PlayerHomePanel();
					playerPanel.add(php.init("A"));
					playerPanel.repaint();
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
