package ui.search;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;

import ui.AllImages;

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
	private JPanel searchToolPanel;
	private JPanel tablePanel;
	private JButton searchP;
	private JButton searchT;
	private JButton searchM;
	
	public JPanel init(){
		searchPanel = new JPanel();
		searchPanel.setOpaque(false);
		searchPanel.setBounds(130, 0, 1000-130, 700);
		searchPanel.setLayout(null);
		
		int width = 100;
		int height = 30;
		searchP = new JButton();
		searchP.setBounds(40, 40, width, height);
		searchP.setOpaque(false);
		searchP.setContentAreaFilled(false);
		searchP.setBorderPainted(false);
		searchP.setIcon(AllImages.IMG_SEARCHPLAYER);
		searchPanel.add(searchP, 0);
		
		searchT = new JButton();
		searchT.setBounds(140, 40, width, height);
		searchT.setOpaque(false);
		searchT.setContentAreaFilled(false);
		searchT.setBorderPainted(false);
		searchT.setIcon(AllImages.IMG_SEARCHTEAM);
		searchPanel.add(searchT, 0);
		
		searchM = new JButton();
		searchM.setBounds(240, 40, width, height);
		searchM.setOpaque(false);
		searchM.setContentAreaFilled(false);
		searchM.setBorderPainted(false);
		searchM.setIcon(AllImages.IMG_SEARCHMATCH);
		searchPanel.add(searchM, 0);
		
		//TODO
		searchToolPanel = new JPanel();
		searchToolPanel.setOpaque(false);
		searchToolPanel.setBounds(0, 70, 1000-130, 100);
		searchToolPanel.setLayout(null);
		searchPanel.add(searchToolPanel, 0);
		
		//TODO
		tablePanel = new JPanel();
		tablePanel.setOpaque(false);
		tablePanel.setBounds(0, 170, 1000-130, 700-170);
		tablePanel.setLayout(null);
		searchPanel.add(tablePanel, 0);
		
		return searchPanel;
	}
}
