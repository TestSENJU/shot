package ui.team;

import javax.swing.JPanel;

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
	private JPanel teamPanel;
	public JPanel init(){
		teamPanel = new JPanel();
		return teamPanel;
	}
}
