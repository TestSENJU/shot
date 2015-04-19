package ui.search;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SearchPanel {
	/**
	 * @param 检索界面 
	 *         -> 检索比赛+球员+球队
	 *         -> 比赛按照时间检索 
	 *              -> 点击具体比赛展示具体信息如比赛时间比分双方球员的数据
	 *         -> 球员 模糊搜索名字 + 26字母的索引
	 *              -> 点击具体球员跳转到球员具体信息界面
	 *         -> 球队 模糊搜索名字 + 26字母的索引
	 *              -> 点击具体球队跳转到球队具体信息界面
	 * @author forIris
	 * @version  June 12, 2015 11:41:31 AM
	 * **/
	private JPanel searchPanel;
	public JPanel init(){
		searchPanel = new JPanel();
		searchPanel.setOpaque(false);
		searchPanel.setBounds(0, 0, 1000-130, 700);
		searchPanel.setLayout(null);
		
		JButton test = new JButton();
		test.setBounds(0, 200, 120, 40);
		test.setOpaque(false);
		test.setContentAreaFilled(false);
		test.setText("test");
		test.setFont(new Font("Arial", Font.PLAIN, 20));
		test.setForeground(Color.WHITE);
		//Hello.setIcon(hello);
		searchPanel.add(test, 0);
		
		return searchPanel;
	}
}
