package UIComponent;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import UIComponent.Player.PlayerExplorerPanel;
import UIComponent.Team.TeamExplorerPanel;

public class MainFrame {
JFrame frame;
JPanel west,center;
JPanel title;
JPanel total,detail;
JLabel first,player,team,statics,search,refresh;
CloseButton closeButton;
MiniButton miniButton;
public MainFrame(){

	init();
	
	addComponent();
	
	setBasicListener();
	
	setListener();
}
public void open(){
	frame.setVisible(true);
}
public void init(){
	miniButton=new MiniButton();
	closeButton=new CloseButton();
	first=new JLabel(new ImageIcon("myimg/firstpage.png"));
	first.setBounds(0,50 ,100 ,100 );
	player=new JLabel(new ImageIcon("myimg/player.png"));
	player.setBounds(0,150 ,100 ,100 );
	team=new JLabel(new ImageIcon("myimg/team.png"));
	team.setBounds(0,250 ,100 ,100 );
	statics=new JLabel(new ImageIcon("myimg/statics.png"));
	statics.setBounds(0, 350, 100, 100);
	search=new JLabel(new ImageIcon("myimg/search.png"));
	search.setBounds(0,450 ,100 ,100 );
	refresh=new JLabel(new ImageIcon("myimg/refresh.png"));
	refresh.setBounds(0,550,20,20);
	
	center=new JPanel();
	center.setBackground(MyColor.WHITE.getColor());
	center.setBounds(100, 0, 900, 600);
	center.setLayout(null);
	center.setBorder(new MatteBorder(1,1,1,1,MyColor.GREY.getColor()));

	title=new JPanel();
	title.setBackground(Color.white);
	title.setBounds(0, 0, 900, 20);
	title.setLayout(new FlowLayout(FlowLayout.RIGHT,0,0));  
	title.setBorder(new MatteBorder(1,1,0,1,MyColor.GREY.getColor()));
	
    west=new JPanel();
    west.setBounds(0, 0, 100, 600);
	west.setLayout(null);
	west.setBorder(new MatteBorder(1, 1, 1, 1, MyColor.GREY.getColor()));
	west.setBackground(MyColor.WHITE.getColor());
		
	frame=new JFrame();

	frame.setSize(1000, 600);	
	frame.setLayout(null);
	frame.setLocationRelativeTo(null);
	frame.setUndecorated(true);
	frame.setVisible(false);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
public void addComponent(){

	title.add(miniButton);
	title.add(closeButton);

   west.add(first);
   west.add(player);
   west.add(team);
   west.add(search);
   west.add(statics);
   west.add(refresh);
   
	center.add(title);
//	center.add(total);
//	center.add(detail);
	
	frame.getContentPane().add(west);
	frame.getContentPane().add(center);
	
}
public void setBasicListener(){

	closeButton.addMouseListener(new MouseAdapter(){
		public void mouseClicked(MouseEvent e){
			frame.dispose();	
			System.exit(0);
		}
	});
	miniButton.addMouseListener(new MouseAdapter(){
		public void mouseClicked(MouseEvent e){
			frame.setExtendedState(JFrame.ICONIFIED);
		}
	});
}
public void setListener(){
	first.addMouseListener(new MouseAdapter(){
		public void mouseClicked(MouseEvent e){
			center.removeAll();
			center.add(title);
			center.repaint();
		}
	});
	player.addMouseListener(new MouseAdapter(){
		public void mouseClicked(MouseEvent e){
			PlayerExplorerPanel total=new PlayerExplorerPanel();
			center.removeAll();
			center.add(title);
			center.add(total);
			center.repaint();
		}
	});
	team.addMouseListener(new MouseAdapter(){
		public void mouseClicked(MouseEvent e){
			
			TeamExplorerPanel total=new TeamExplorerPanel();
			center.removeAll();
			center.add(title);
			center.add(total);
			center.repaint();
		}
	});
	statics.addMouseListener(new MouseAdapter(){
		public void mouseClicked(MouseEvent e){
			
		}
	});
	search.addMouseListener(new MouseAdapter(){
		public void mouseClicked(MouseEvent e){
			
		}
	});
}
public static void main(String args[]){
	MainFrame frame=new MainFrame();
	frame.open();
}
}
