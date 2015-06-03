package UIComponent.Match;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import UIComponent.MyColor;
import UIComponent.MyScrollPane;
import UIComponent.MyTable;

public class MatchExplorerPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
JLabel title;
JScrollPane jsp;
MyTable table;
DefaultTableModel model;

JLabel search,showall;
JPanel left,right;
JLabel tip;

private ArrayList<String>list=new ArrayList<String>();
private String titlename[]=new String[]{"时间","胜方","负方","比分"};
public MatchExplorerPanel(){
	init();
	addComponent();
	setListener();
}

public void init(){
	this.setBounds(0, 20, 900, 580);
	this.setBackground(MyColor.WHITE.getColor());
	this.setLayout(null);
	
	left=new JPanel();
	left.setLayout(null);
	left.setBounds(0, 0, 400, 580);
	left.setBackground(MyColor.WHITE.getColor());
	left.setBorder(new MatteBorder(0,1,1,1,MyColor.GREY.getColor()));
	right=new JPanel();
	right.setLayout(null);
	right.setBounds(400,0,500, 580);
	right.setBackground(MyColor.WHITE.getColor());
	right.setBorder(new MatteBorder(0,1,1,1,MyColor.GREY.getColor()));
	
	title=new JLabel("比赛列表");
	title.setFont(new Font("黑体",Font.PLAIN,20));
	title.setForeground(MyColor.BLUE.getColor());
	title.setBounds(15,0,120,50);

	//TODO
//	JTextField text;
//	JLabel option;
//	JComboBox<String> team;
//	JPanel searchPanel;
//	text=new JTextField(null);
//	text.setBounds(200, 35, 110, 25);
//
//	option=new JLabel("查询依据");
//	option.setForeground(MyColor.BLUE.getColor());
//	option.setFont(new Font("黑体",Font.PLAIN,12));
//	option.setBounds(0, 15, 40, 25);
//	
//	choose=new MyComboBox(new String[]{"","球员","球队","时间"});
//	choose.setBounds(45, 15, 120, 25);
//	
//	team=new MyComboBox(new String[]{"请选择球队","圣安东尼奥马刺队","孟菲斯灰熊队","达拉斯小牛队","休斯敦火箭队","新奥尔良鹈鹕队",
//			"明尼苏达森林狼队","丹佛掘金队","犹他爵士队","波特兰开拓者队","俄克拉荷马雷霆队",
//			"萨克拉门托国王队","菲尼克斯太阳队","洛杉矶湖人队","洛杉矶快船队 ","金州勇士队",
//			"迈阿密热火队","奥兰多魔术队","亚特兰大老鹰队","华盛顿奇才队","夏洛特黄蜂队",
//			"底特律活塞队","印第安纳步行者队","克里夫兰骑士队","芝加哥公牛队","密尔沃基雄鹿队",
//			"波士顿凯尔特人队","费城76人队","纽约尼克斯队","布鲁克林篮网队","多伦多猛龙队"
//			});
//	searchPanel=new JPanel();
//	searchPanel.setLayout(null);
//	searchPanel.setBounds(160, 0, 240, 50);
//	searchPanel.setBackground(MyColor.WHITE.getColor());
	
	search=new JLabel("搜索比赛");
	search.setForeground(MyColor.BLUE.getColor());
	search.setFont(new Font("黑体",Font.PLAIN,12));
	search.setBounds(270, 15,50,25);
	showall=new JLabel("显示所有比赛");
	showall.setForeground(MyColor.BLUE.getColor());
	showall.setFont(new Font("黑体",Font.PLAIN,12));
	showall.setBounds(325, 15,75,25);
	
	tip=new JLabel("选择左侧列表中的比赛来显示详细信息");
	tip.setForeground(MyColor.BLUE.getColor());
	tip.setFont(new Font("黑体",Font.PLAIN,16));
	tip.setBounds(120, 275,300,25);

	model=new DefaultTableModel(null, titlename){
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int row,int column){
			return false;
		}
	};
	initTable();
	table=new MyTable(model) {  

		private static final long serialVersionUID = 1L;

		@SuppressWarnings({ "unchecked", "rawtypes" })
		public Class getColumnClass(int column) {
			
			return getValueAt(0, column).getClass();  
			} 
		};
	
	      TableColumnModel tcm = table.getColumnModel();
	        tcm.getColumn(0).setPreferredWidth(100);
	        tcm.getColumn(1).setPreferredWidth(150);
	        tcm.getColumn(2).setPreferredWidth(75);
	        tcm.getColumn(3).setPreferredWidth(75);
	        table.setRowHeight(50);

	jsp=new MyScrollPane(table);
	jsp.setBounds(0, 50, 400,530);	
}
public void initTable(){
	for(int i=0;i<200;i++){
		Object[] ob=new Object[4];
		ob[0]="13-12";
		ob[1]="Lebron James";
		ob[2]="NOP";
		ob[3]="A";
		model.addRow(ob);
		list.add((String) ob[1]);
	}
	Object[] ob=new Object[4];
	ob[0]=new ImageIcon("myimg/search.png");
	ob[1]="Aaron Brooks";
	ob[2]="NOP";
	ob[3]="A";
	model.addRow(ob);
	list.add((String) ob[1]);
}
public void addComponent(){
	left.add(title);
	left.add(search);
	left.add(showall);
	left.add(jsp);
	right.add(tip);
	this.add(left);
	this.add(right);

}
public void setListener(){
	table.addMouseListener(new MouseAdapter(){
		public void mouseClicked(MouseEvent e){
			int row=table.getSelectedRow();
			String time=(String)table.getValueAt(row, 0);
			String winner=(String)table.getValueAt(row, 1);
			MatchDetailPanel match=new MatchDetailPanel(time,winner);
			right.removeAll();
			right.add(match);
			right.repaint();
			//TODO
		}
	});
	showall.addMouseListener(new MouseAdapter(){
		public void mouseEntered(MouseEvent e){
			showall.setForeground(MyColor.BLACK.getColor());
		}
		public void mouseExited(MouseEvent e){
			showall.setForeground(MyColor.BLUE.getColor());
		}
		public void mouseClicked(MouseEvent e){
			list=new ArrayList<String>();
			for(int i=model.getRowCount()-1;i>=0;i--){
					model.removeRow(i);
			}
			initTable();
		}
	});
	search.addMouseListener(new MouseAdapter(){
		public void mouseEntered(MouseEvent e){
			search.setForeground(MyColor.BLACK.getColor());
		}
		public void mouseExited(MouseEvent e){
			search.setForeground(MyColor.BLUE.getColor());
		}
		public void mouseClicked(MouseEvent e){
			//TODO
			
		}
	});
}
}
