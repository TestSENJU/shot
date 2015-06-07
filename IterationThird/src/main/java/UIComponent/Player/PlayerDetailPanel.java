package UIComponent.Player;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
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
JLabel photo;
JLabel leftside;
JLabel rightside;
JPanel photoPanel;
ImageIcon icon1,icon2;
JLabel change1,change2;
public PlayerDetailPanel(String playername){
	this.player=playername;

	initJLabel();
	initJPanel();

	addComponent();
	setListener();
}
public void initJLabel(){
	leftside=new JLabel();
	leftside.setBackground(MyColor.WHITE.getColor());
	leftside.setBounds(0, 0, 20, 580);
	leftside.setVisible(true);

	rightside=new JLabel();
	rightside.setBackground(MyColor.WHITE.getColor());
	rightside.setBounds(490, 0, 20, 580);
	rightside.setVisible(true);
	
	photoPanel=new JPanel();

	photoPanel.setBackground(MyColor.WHITE.getColor());
	photoPanel.setBorder(new MatteBorder(1,1,1,1,MyColor.GREY.getColor()));
	photoPanel.setBounds(40, 50, 150, 200);
	
	photo=new JLabel();
	photo.setBounds(0,0,150,180);
	icon1=new ImageIcon("playerHead/"+player+".png");
	 icon1=new ImageIcon(icon1.getImage().getScaledInstance(photo.getWidth(), photo.getHeight()-60, Image.SCALE_DEFAULT));    
	 icon2=new ImageIcon("playerBody/"+player+".png");
	 icon2=new ImageIcon(icon2.getImage().getScaledInstance(photo.getWidth()-40, photo.getHeight()-25, Image.SCALE_DEFAULT));    
	 photo.setIcon(icon1);  
	 photo.setHorizontalAlignment(SwingConstants.CENTER);  
	 photo.setVerticalAlignment(SwingConstants.CENTER);
	change1=new JLabel(new ImageIcon("img/picturechange.png"));
	change2=new JLabel(new ImageIcon("img/picturechange.png"));
	change1.setBounds(63, 190, 10, 10);
	change2.setBounds(77, 190,10,10);
	
	String ss="名字: "+player;

	if(ss.length()<=16){
		name=new JLabel(ss);
		name.setBounds(200, 60, 150, 20);
	}else{
		name=new JLabel("<HTML>"+ss.substring(0,16)+"<br>"+"   "+ss.substring(16)+"<HTML>");
		name.setBounds(200, 60, 150, 40);
	}
	name.setForeground(MyColor.BLACK.getColor());
	name.setFont(new Font("微软雅黑",Font.PLAIN,14));
	
	number=new JLabel("号码: "+"A");
	number.setForeground(MyColor.BLACK.getColor());
	number.setFont(new Font("微软雅黑",Font.PLAIN,14));
	number.setBounds(350, 60, 150, 20);
	
	position=new JLabel("位置: A");
	position.setForeground(MyColor.BLACK.getColor());
	position.setFont(new Font("微软雅黑",Font.PLAIN,14));
	position.setBounds(200, 100, 150, 20);
	
	height=new JLabel("体重: 75kg");
	height.setForeground(MyColor.BLACK.getColor());
	height.setFont(new Font("微软雅黑",Font.PLAIN,14));
	height.setBounds(350,100,150,20);
	
	weight=new JLabel("身高: 179cm");
	weight.setForeground(MyColor.BLACK.getColor());
	weight.setFont(new Font("微软雅黑",Font.PLAIN,14));
	weight.setBounds(200,140,150,20);
	
	birth=new JLabel("出生日期: 1993-12-11");
	birth.setForeground(MyColor.BLACK.getColor());
	birth.setFont(new Font("微软雅黑",Font.PLAIN,14));
	birth.setBounds(350,140,150,20);
	
	age=new JLabel("年龄: 21");
	age.setForeground(MyColor.BLACK.getColor());
	age.setFont(new Font("微软雅黑",Font.PLAIN,14));
	age.setBounds(200, 180, 150, 20);
	
	exp=new JLabel("球龄: 3");
	exp.setForeground(MyColor.BLACK.getColor());
	exp.setFont(new Font("微软雅黑",Font.PLAIN,14));
	exp.setBounds(200, 220, 150, 20);
	
	String s="学校: nannauersi";
	if(s.length()<=15){
		school=new JLabel(s);	
				school.setBounds(350, 180, 150, 20);
	}else{
		school=new JLabel("<HTML>"+s.substring(0,15)+"<br>"+"   "+s.substring(15)+"<HTML>");			
		school.setBounds(350, 180, 150, 40);
	}
	school.setForeground(MyColor.BLACK.getColor());
	school.setFont(new Font("微软雅黑",Font.PLAIN,14));
	
	team=new JLabel("所属球队: NOP");
	team.setForeground(MyColor.BLACK.getColor());
	team.setFont(new Font("微软雅黑",Font.PLAIN,14));
	team.setBounds(350, 220, 150, 20);
}
public void initJPanel(){

	this.setBackground(MyColor.WHITE.getColor());
	this.setBorder(new MatteBorder(0,0,1,1,MyColor.GREY.getColor()));
	this.setLayout(null);
}
public void addComponent(){
	this.add(leftside);
	this.add(rightside);
	this.add(name);
	this.add(number);
	this.add(position);
	this.add(height);
	this.add(weight);
	this.add(birth);
	this.add(age);
	this.add(exp);
	this.add(school);
	this.add(team);
	photoPanel.add(photo);
	photoPanel.add(change1);
	photoPanel.add(change2);
	this.add(photoPanel);
}
public void setListener(){
    change1.addMouseListener(new MouseAdapter(){
    	public void mouseEntered(MouseEvent e){
    		
    	}
    	public void mouseClicked(MouseEvent e){
    		photoPanel.remove(photo);
    		photo.setIcon(icon1);
    		photoPanel.add(photo);
    		photoPanel.repaint();
    	}
    	public void mouseExited(MouseEvent e){
    		
    	}
    });
    change2.addMouseListener(new MouseAdapter(){
    	public void mouseEntered(MouseEvent e){
    		
    	}
    	public void mouseClicked(MouseEvent e){
    		photoPanel.remove(photo);
    		photo.setIcon(icon2);
    		photoPanel.add(photo);
    		photoPanel.repaint();
    	}
    	public void mouseExited(MouseEvent e){
    		
    	}
    });
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
public String getName(){
	return this.player;
}
}
