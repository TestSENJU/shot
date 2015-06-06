package UIComponent.Player;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import UIComponent.MyColor;

public class PlayerDetailPanel extends JPanel{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
private String player;
JLabel name;
JLabel number;
JLabel position,height,weight,birth,age,exp,school,team;
JLabel undo,forward;
JPanel backwards;
JLabel photo;
JLabel leftside;
JLabel rightside;
public PlayerDetailPanel(String playername){
	this.player=playername;

	initJLabel();
	initJPanel();

	addComponent();
	setListener();
}
public void initJLabel(){
	leftside=new JLabel();
	leftside.setBackground(MyColor.RED.getColor());
	leftside.setBounds(0, 0, 20, 580);
	leftside.setVisible(true);
	
	undo=new JLabel(new ImageIcon("img/undo.png"));
	undo.setBounds(0, 235, 30, 30);

	forward=new JLabel(new ImageIcon("img/do.png"));
	forward.setBounds(470, 235, 30, 30);
	
	photo=new JLabel(new ImageIcon("img/search.png"));
	
	name=new JLabel("名字");
	name.setForeground(MyColor.PURPLE.getColor());
	name.setFont(new Font("黑体",Font.PLAIN,12));
	
	number=new JLabel("号码");
	number.setForeground(MyColor.PURPLE.getColor());
	number.setFont(new Font("黑体",Font.PLAIN,12));
	
	position=new JLabel("位置");
	position.setForeground(MyColor.PURPLE.getColor());
	position.setFont(new Font("黑体",Font.PLAIN,12));
	
	height=new JLabel("体重");
	height.setForeground(MyColor.PURPLE.getColor());
	height.setFont(new Font("黑体",Font.PLAIN,12));
	
	weight=new JLabel("身高");
	weight.setForeground(MyColor.PURPLE.getColor());
	weight.setFont(new Font("黑体",Font.PLAIN,12));
	
	birth=new JLabel("出生日期");
	birth.setForeground(MyColor.PURPLE.getColor());
	birth.setFont(new Font("黑体",Font.PLAIN,12));
	
	age=new JLabel("年龄");
	age.setForeground(MyColor.PURPLE.getColor());
	age.setFont(new Font("黑体",Font.PLAIN,12));
	
	exp=new JLabel("球龄");
	exp.setForeground(MyColor.PURPLE.getColor());
	exp.setFont(new Font("黑体",Font.PLAIN,12));
	
	school=new JLabel("毕业学校");
	school.setForeground(MyColor.PURPLE.getColor());
	school.setFont(new Font("黑体",Font.PLAIN,12));
	
	team=new JLabel("所属球队");
	team.setForeground(MyColor.PURPLE.getColor());
	team.setFont(new Font("黑体",Font.PLAIN,12));
}
public void initJPanel(){
//	backwards=new JPanel();
//	backwards.setBackground(MyColor.WHITE.getColor());
//	backwards.setBorder(new MatteBorder(0,0,1,0,MyColor.GREY.getColor()));
//	backwards.setBounds(0, 0, 500, 40);
	this.setBackground(MyColor.WHITE.getColor());
	this.setBorder(new MatteBorder(0,0,1,1,MyColor.GREY.getColor()));
	this.setLayout(null);
}
public void addComponent(){
//	backwards.add(undo);
//	backwards.add(forward);
//	
//	this.add(backwards);
//	this.add(leftside);
//	this.add(rightside);
	this.add(leftside);
	this.add(undo);
}
public void setListener(){
//	leftside.addMouseListener(new MouseAdapter(){
//		public void mouseEntered(MouseEvent e){
//			add(undo,0);
//		}
//		public void mouseExited(MouseEvent e){
//			remove(undo);
//		}
//	});
}
public String getName(){
	return this.player;
}
}
