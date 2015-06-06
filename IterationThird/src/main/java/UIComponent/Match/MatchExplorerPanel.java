package UIComponent.Match;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import UIComponent.MyColor;
import UIComponent.MyScrollPane;
import UIComponent.MyTable;
import UIComponent.Player.PlayerDetailPanel;

public class MatchExplorerPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
JLabel title;
JScrollPane jsp;
MyTable table;
DefaultTableModel model;

//JLabel search,showall;
JPanel left;
JLabel tip;

private ArrayList<String>list=new ArrayList<String>();
private String titlename[]=new String[]{"时间","胜方","负方","比分"};
public MatchExplorerPanel(){
	init();
	addComponent();
	setListener();
}

public void init(){
	
	left=new JPanel();
	left.setLayout(null);
	left.setBounds(0, 0, 400, 580);
	left.setBackground(MyColor.WHITE.getColor());
	left.setBorder(new MatteBorder(0,1,1,1,MyColor.GREY.getColor()));

	title=new JLabel("比赛列表");
	title.setFont(new Font("黑体",Font.PLAIN,20));
	title.setForeground(MyColor.BLUE.getColor());
	title.setBounds(15,0,120,50);

	tip=new JLabel("选择左侧列表中的比赛来显示详细信息");
	tip.setForeground(MyColor.BLUE.getColor());
	tip.setFont(new Font("黑体",Font.PLAIN,16));
	tip.setBounds(520, 275,300,25);

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
	table=new MyTable(model);
	
	      TableColumnModel tcm = table.getColumnModel();
	        tcm.getColumn(0).setPreferredWidth(100);
	        tcm.getColumn(1).setPreferredWidth(100);
	        tcm.getColumn(2).setPreferredWidth(100);
	        tcm.getColumn(3).setPreferredWidth(100);
	        table.setRowHeight(50);

	jsp=new MyScrollPane(table);
	jsp.setBounds(0, 50, 400,530);	
	
	this.setBounds(0, 20, 900, 580);
	this.setBackground(MyColor.WHITE.getColor());
	this.setLayout(null);
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
	ob[0]="12-12-11";
	ob[1]="Aaron Brooks";
	ob[2]="NOP";
	ob[3]="A";
	model.addRow(ob);
	list.add((String) ob[1]);
}
public void addComponent(){
	left.add(title);
	left.add(jsp);
	this.add(left);
	this.add(tip);

}
public void setListener(){
	table.addMouseListener(new MouseAdapter(){
		public void mouseClicked(MouseEvent e){
			int row=table.getSelectedRow();
			String time=(String)table.getValueAt(row, 0);
			String winner=(String)table.getValueAt(row, 1);
			if(getComponentAt(550,275)instanceof JLabel){
				MatchDetailPanel match=new MatchDetailPanel(time,winner);
				match.setBounds(400,20,500, 580);
				remove(tip);
				add(match);
				repaint();
			}else if(getComponentAt(550,275)instanceof MatchDetailPanel){
				MatchDetailPanel matchold=(MatchDetailPanel)getComponentAt(550,275);
				if(!time.equals(matchold.getTime())&&!winner.equals(matchold.getWinner())){
					MatchDetailPanel match=new MatchDetailPanel(time,winner);
					match.setBounds(400,20,500, 580);
					remove(getComponentAt(550,275));
					add(match);
					repaint();
				}
			}
			//TODO
		}
	});
}
}
