package ui.player;

import javax.swing.JPanel;

public class PlayerHomePanel {
	/**
	 * @param 球员的个人主页
	 *         -> 球员头像+动态图片
	 *         -> 球员的个人基本信息
	 *         -> 球员的比赛数据[场均和总赛季]
	 * @author forIris
	 * @version  June 13, 2015 15:54:31 PM
	 * **/
	
	private JPanel homePanel;
	public JPanel init(){
		homePanel = new JPanel();
		return homePanel;
	}
}
