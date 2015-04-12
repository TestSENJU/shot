package ui;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

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
		
		String lookAndFeel = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
		try {
			UIManager.setLookAndFeel(lookAndFeel);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		String[] conditionInfo = {"score","rebound","assisting","blockShot","steal","6","7","8"};
		JComboBox<String> c = new JComboBox<String>(conditionInfo);
		c.setBounds(30, 180, 100, 30);
		c.setBackground(Color.BLACK);
		c.setForeground(Color.WHITE);
		hotPanel.add(c, 0);
		
		return hotPanel;
	}
}
