package UIComponent.Match;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import UIComponent.MyColor;
import UIComponent.MyTable;

public class MatchDetailPanel extends JPanel{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String time;
private String winner;
JLabel winnerIcon,loserIcon;
JLabel leftside,rightside;
JLabel undo,forward;
JLabel winnerName,loserName;
MyTable scoreTable;
MyTable playerTable;
public MatchDetailPanel(String stime,String swinner){
	this.time=stime;
	this.winner=swinner;

	initComponent();
	initPanel();
	addComponent();
}
public void initComponent(){
	leftside=new JLabel();
	leftside.setBackground(MyColor.WHITE.getColor());
	leftside.setBounds(0, 0, 20, 580);
	leftside.setVisible(true);

	rightside=new JLabel();
	rightside.setBackground(MyColor.WHITE.getColor());
	rightside.setBounds(490, 0, 20, 580);
	rightside.setVisible(true);
	
	winnerIcon=new JLabel(new ImageIcon("team/ATL.png"));
	winnerIcon.setBounds(80,20,100,100);
	loserIcon=new JLabel(new ImageIcon("team/HOU.png"));
	loserIcon.setBounds(320, 20,100,100);
	
	winnerName=new JLabel("胜方: ATL");
	winnerName.setBackground(MyColor.WHITE.getColor());
	winnerName.setForeground(MyColor.RED.getColor());
	winnerName.setFont(new Font("黑体",Font.PLAIN,16));
	winnerName.setBounds(80,130,100,30);
	winnerName.setHorizontalAlignment(SwingConstants.CENTER);
	
	loserName=new JLabel("负方: HOU");
	loserName.setBackground(MyColor.WHITE.getColor());
	loserName.setForeground(MyColor.BLACK.getColor());
	loserName.setFont(new Font("黑体",Font.PLAIN,16));
	loserName.setBounds(320,130,100,30);
	loserName.setHorizontalAlignment(SwingConstants.CENTER);
	
	scoreTable=new MyTable(new String[][]{{"85-112","27-25","29-31","13-25","16-31"}},new String[]{"总比分","第一场","第二场","第三场","第四场"}){
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int row,int column){
			return false;
		}
	};
	scoreTable.getTableHeader().setBounds(70, 180, 375, 20);
	scoreTable.setBounds(70, 200, 400, 50);
	
	playerTable=new MyTable(new String[][]{},new String[]{"","",""});
}
public void initPanel(){
	this.setBackground(MyColor.WHITE.getColor());
	this.setLayout(null);
	this.setBorder(new MatteBorder(0,0,1,1,MyColor.GREY.getColor()));
}
public void addComponent(){
	this.add(leftside);
	this.add(rightside);
	this.add(winnerIcon);
	this.add(loserIcon);
	this.add(winnerName);
	this.add(loserName);
	this.add(scoreTable.getTableHeader());
	this.add(scoreTable);
}
public void setListener(){
	leftside.addMouseListener(new MouseAdapter(){
		public void mouseEntered(MouseEvent e){
			undo=new JLabel(new ImageIcon("img/undo.png"));
			undo.setBounds(0, 275, 50, 50);

			add(undo);
			repaint();
		}
		public void mouseExited(MouseEvent e){
			remove(undo);
			repaint();
		}
	});
	rightside.addMouseListener(new MouseAdapter(){
		public void mouseEntered(MouseEvent e){
			forward=new JLabel(new ImageIcon("img/do.png"));
			forward.setBounds(450, 275, 50, 50);
			
			add(forward,0);
			repaint();
		}
		public void mouseExited(MouseEvent e){
			remove(forward);
			repaint();
		}
	});
	if(undo!=null){
		undo.addMouseListener(new MouseAdapter(){
		public void mouseClicked(MouseEvent e){
			
		}
	});
	}
	if(forward!=null){
		forward.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				
			}
		});
	}
}
public String getTime(){
	return this.time;
	
}
public String getWinner(){
	return this.winner;
}
}
