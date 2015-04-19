package ui.team;

import java.awt.Color;
import java.awt.Font;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import org.apache.batik.swing.JSVGCanvas;
import org.apache.batik.swing.gvt.GVTTreeRendererAdapter;
import org.apache.batik.swing.gvt.GVTTreeRendererEvent;
import org.apache.batik.swing.svg.GVTTreeBuilderAdapter;
import org.apache.batik.swing.svg.GVTTreeBuilderEvent;
import org.apache.batik.swing.svg.SVGDocumentLoaderAdapter;
import org.apache.batik.swing.svg.SVGDocumentLoaderEvent;

import ui.IScrollBarUI;
import ui.MyStringTable;
import ui.MyTable;

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
	private JPanel teamHomePanel;
	private JButton fullName;
	private JButton shortName;
	private JButton location;
	private JButton zone;
	private JButton partition;
	private JButton homeCourt;
	private JButton settingTime;
	private MyTable pTable;
	private JScrollPane pScrollPane;
	private MyStringTable tTable;
	private JScrollPane tScrollPane;
	
	public JPanel init(){
		teamHomePanel = new JPanel();
		teamHomePanel.setOpaque(false);
		teamHomePanel.setBounds(0, 0, 1000-130, 700);
		teamHomePanel.setLayout(null);
		
		//TODO logo
		JSVGCanvas svgCanvas = new JSVGCanvas();
		File f1 = new File("teamImg/ATL.svg");
		svgCanvas.setBounds(30, 50, 120, 120);
		svgCanvas.setURI(f1.toURI().toString());
		svgCanvas.addSVGDocumentLoaderListener(new SVGDocumentLoaderAdapter(){
			public void documentLoadingStarted(SVGDocumentLoaderEvent e){
			}
			public void documentLoadingCompleted(SVGDocumentLoaderEvent e){
			}
		});
		svgCanvas.addGVTTreeBuilderListener(new GVTTreeBuilderAdapter(){
			public void gvtBuildStarted(GVTTreeBuilderEvent e){
			}
			public void gvtBuildCompleted(GVTTreeBuilderEvent e){
				//frame.pack();
			}
		});
		svgCanvas.addGVTTreeRendererListener(new GVTTreeRendererAdapter(){
			 public void gvtRenderingPrepare(GVTTreeRendererEvent e) {  
				 }   
			 public void gvtRenderingCompleted(GVTTreeRendererEvent e) {
				 System.out.println(1);
			 }
		});
		teamHomePanel.add(svgCanvas, 0);
		//TODO basic info
		/**球队全名-球队名缩写-所在地-赛区-分区-主场-建立时间*/
		int toLeftFirst = 200;
		int toLeftSecond = 350;
		int toLeftThird = 500;
		int width = 100;
		int height = 30;
		
		fullName = new JButton();
		fullName.setBounds(toLeftFirst, 50, width, height);
		fullName.setOpaque(false);
		fullName.setContentAreaFilled(false);
		fullName.setBorderPainted(false);
		fullName.setText("队名");
		teamHomePanel.add(fullName, 0);
		
		//TODO
		JLabel tfullName = new JLabel();
		tfullName.setBounds(toLeftFirst+100, 50, width, height);
		tfullName.setOpaque(false);
		tfullName.setText("黄蜂");
		teamHomePanel.add(tfullName, 0);
		
		shortName = new JButton();
		shortName.setBounds(toLeftFirst, 100, width, height);
		shortName.setOpaque(false);
		shortName.setContentAreaFilled(false);
		shortName.setBorderPainted(false);
		shortName.setText("队名缩写");
		teamHomePanel.add(shortName, 0);
		
		//TODO
		JLabel tShortName = new JLabel();
		tShortName.setBounds(toLeftFirst+100, 100, width, height);
		tShortName.setOpaque(false);
		tShortName.setText("HF");
		teamHomePanel.add(tShortName, 0);
		
		location = new JButton();
		location.setBounds(toLeftFirst, 150, width, height);
		location.setOpaque(false);
		location.setContentAreaFilled(false);
		location.setBorderPainted(false);
		location.setText("所在地");
		teamHomePanel.add(location, 0);
		
		//TODO
		JLabel tLocation = new JLabel();
		tLocation.setBounds(toLeftFirst+100, 150, width, height);
		tLocation.setOpaque(false);
		tLocation.setText("NJU");
		teamHomePanel.add(tLocation, 0);
		
		zone = new JButton();
		zone.setBounds(toLeftSecond, 50, width, height);
		zone.setOpaque(false);
		zone.setContentAreaFilled(false);
		zone.setBorderPainted(false);
		zone.setText("赛区");
		teamHomePanel.add(zone, 0);
		
		//TODO
		JLabel tZone = new JLabel();
		tZone.setBounds(toLeftSecond+100, 50, width, height);
		tZone.setOpaque(false);
		tZone.setText("NJU");
		teamHomePanel.add(tZone, 0);
		
		partition = new JButton();
		partition.setBounds(toLeftSecond, 100, width, height);
		partition.setOpaque(false);
		partition.setContentAreaFilled(false);
		partition.setBorderPainted(false);
		partition.setText("分区");
		teamHomePanel.add(partition, 0);
		
		//TODO
		JLabel tPartition = new JLabel();
		tPartition.setBounds(toLeftSecond+100, 100, width, height);
		tPartition.setOpaque(false);
		tPartition.setText("NJU");
		teamHomePanel.add(tPartition, 0);
		
		homeCourt = new JButton();
		homeCourt.setBounds(toLeftThird, 50, width, height);
		homeCourt.setOpaque(false);
		homeCourt.setContentAreaFilled(false);
		homeCourt.setBorderPainted(false);
		homeCourt.setText("主场");
		teamHomePanel.add(homeCourt, 0);
		
		//TODO
		JLabel tHomeCourt = new JLabel();
		tHomeCourt.setBounds(toLeftThird+100, 50, width, height);
		tHomeCourt.setOpaque(false);
		tHomeCourt.setText("NJU");
		teamHomePanel.add(tHomeCourt, 0);
		
		settingTime = new JButton();
		settingTime.setBounds(toLeftThird, 100, width, height);
		settingTime.setOpaque(false);
		settingTime.setContentAreaFilled(false);
		settingTime.setBorderPainted(false);
		settingTime.setText("建立时间");
		teamHomePanel.add(settingTime, 0);
		
		//TODO
		JLabel tSettingTime = new JLabel();
		tSettingTime.setBounds(toLeftThird+100, 100, width, height);
		tSettingTime.setOpaque(false);
		tSettingTime.setText("96-01-19");
		teamHomePanel.add(tSettingTime, 0);
		
		//TODO player info table	
		String[] columnName_Player = new String[] { "球员头像", "球员名称", "球衣号码", "球员位置", "身高","体重","生日","年龄","球龄","毕业学校" };
		Object[][] columnPValues = new Object[30][columnName_Player.length];
		for (int i = 0; i < 30; i++) {
			columnPValues[i][0] = i;
			columnPValues[i][1] = i;
			columnPValues[i][2] = i;
			columnPValues[i][3] = i;
			columnPValues[i][4] = i;
			columnPValues[i][5] = i;
			columnPValues[i][6] = i;
			columnPValues[i][7] = i;
			columnPValues[i][8] = i;
			columnPValues[i][9] = i;
		}
		pTable = new MyTable(columnPValues, columnName_Player);
		pTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		pTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		pTable.setForeground(Color.white);
		pTable.setRowHeight(35);
		pTable.setBounds(30, 200, 1000-130-100, 300);
		pTable.setOpaque(false);
		
		//pTable.addMouseListener(new TableListener());

		pTable.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
	    pScrollPane = new JScrollPane();
	    pScrollPane.setColumnHeaderView(pTable.getTableHeader());	//设置头部（HeaderView部分）  
	    pScrollPane.getColumnHeader().setOpaque(false);	//再取出头部，并设置为透明  
	    
	    pScrollPane.setViewportView(pTable);	//装载表格  
	    pScrollPane.setOpaque(false);
	    pScrollPane.getViewport().setOpaque(false);
	    pScrollPane.getVerticalScrollBar().setUI(new IScrollBarUI());
	    pScrollPane.getHorizontalScrollBar().setUI(new IScrollBarUI());
	    
        teamHomePanel.add(pScrollPane);
        pScrollPane.setBounds(30, 200, 1000-130-100, 300);
        pScrollPane.setOpaque(false);
		//TODO average data table
		//TODO all data table
        String[] columnName_Team = new String[] { "Tag", "比赛场数", "投篮命中数", 
        		"投篮出手次数", "三分命中数", "三分出手数","罚球命中数","罚球出手数",
        		"进攻篮板数","防守篮板数","篮板数",
        		"助攻数","抢断数","盖帽数","失误数",
        		"犯规数","比赛得分","投篮命中率","三分命中率",
        		"罚球命中率","胜率","进攻回合","进攻效率",
        		"防守效率","篮板效率","抢断效率","助攻率"};
		Object[][] columnTValues = new Object[2][columnName_Team.length];
		for (int i = 0; i < 2; i++) {
			if(i%2==0){
				columnTValues[i][0] = "总赛季";
			} else {
				columnTValues[i][0] = "场均";
			}
			columnTValues[i][1] = i;
			columnTValues[i][2] = i;
			columnTValues[i][3] = i;
			columnTValues[i][4] = i;
			columnTValues[i][5] = i;
			columnTValues[i][6] = i;
			columnTValues[i][7] = i;
			columnTValues[i][8] = i;
			columnTValues[i][9] = i;
			columnTValues[i][10] = i;
			columnTValues[i][11] = i;
			columnTValues[i][12] = i;
			columnTValues[i][13] = i;
			columnTValues[i][14] = i;
			columnTValues[i][15] = i;
			columnTValues[i][16] = i;
			columnTValues[i][17] = i;
			columnTValues[i][18] = i;
			columnTValues[i][19] = i;
			columnTValues[i][20] = i;
			columnTValues[i][21] = i;
			columnTValues[i][22] = i;
			columnTValues[i][23] = i;
			columnTValues[i][24] = i;
			columnTValues[i][25] = i;
			columnTValues[i][26] = i;
		}
		tTable = new MyStringTable(columnTValues, columnName_Team);
		tTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tTable.setForeground(Color.white);
		tTable.setRowHeight(35);
		tTable.setBounds(30, 530, 1000-130-100, 120);
		tTable.setOpaque(false);
		
		//pTable.addMouseListener(new TableListener());

		tTable.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
	    tScrollPane = new JScrollPane();
	    tScrollPane.setColumnHeaderView(tTable.getTableHeader());	//设置头部（HeaderView部分）  
	    tScrollPane.getColumnHeader().setOpaque(false);	//再取出头部，并设置为透明  
	    
	    tScrollPane.setViewportView(tTable);	//装载表格  
	    tScrollPane.setOpaque(false);
	    tScrollPane.getViewport().setOpaque(false);
	    tScrollPane.getVerticalScrollBar().setUI(new IScrollBarUI());
	    tScrollPane.getHorizontalScrollBar().setUI(new IScrollBarUI());
	    
        teamHomePanel.add(tScrollPane);
        tScrollPane.setBounds(30, 530, 1000-130-100, 120);
        tScrollPane.setOpaque(false);
		
		return teamHomePanel;
	}
}
