package UIComponent;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.MatteBorder;

import UIComponent.Match.MatchExplorerPanel;
import UIComponent.Player.PlayerExplorerPanel;
import UIComponent.Team.TeamExplorerPanel;
import UIComponent.statics.StaticsPanel;

public class MainFrame {
static JFrame frame;
JPanel west,center;
JPanel title;
JPanel total,detail;
JLabel first,player,team,match,statics,search,refresh;
CloseButton closeButton;
MiniButton miniButton;
JLabel currentTime;
Timer timer;
private int xx, yy;
private boolean isDraging = false;

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
//	--------------虽然我很想写出来时钟的效果，但是这个好像线程不太安全会影响到我别的界面的东西，还是不要写了-------------------
	currentTime=new JLabel();
	currentTime.setForeground(MyColor.PURPLE.getColor());
    currentTime.setFont(new Font("黑体",Font.PLAIN,12));
    currentTime.setBackground(MyColor.WHITE.getColor());
    currentTime.setBounds(0, 560, 100, 40);
	timer=new Timer(1000,null);
	timer.start();
	
	miniButton=new MiniButton();
	closeButton=new CloseButton();
	first=new JLabel(new ImageIcon("img/home.png"));
	first.setBounds(20,40 ,60 ,80 );
	player=new JLabel(new ImageIcon("img/player.png"));
	player.setBounds(20,120 ,60 ,80 );
	team=new JLabel(new ImageIcon("img/team.png"));
	team.setBounds(20,200 ,60 ,80 );
	match=new JLabel(new ImageIcon("img/match.png"));
	match.setBounds(20,280 ,60 ,80 );
	statics=new JLabel(new ImageIcon("img/statics.png"));
	statics.setBounds(20,360 ,60 ,80 );
	search=new JLabel(new ImageIcon("img/search.png"));
	search.setBounds(20,440 ,60 ,80 );
	refresh=new JLabel(new ImageIcon("img/refresh.png"));
//	refresh.setBounds(20,520 ,60 ,80 );
	
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
   west.add(match);
   west.add(search);
   west.add(statics);
//   west.add(refresh);
   west.add(currentTime);
	center.add(title,0);
	
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
	timer.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			 Date date =new Date();
			 DateFormat format =new SimpleDateFormat("MM-dd HH:mm:ss");
			 west.remove(currentTime);
			 currentTime.setText(format.format(date));	 
			 west.add(currentTime);
			 west.repaint();
		}
	});
       frame.addMouseListener(new MouseAdapter() {
		 public void mousePressed(MouseEvent e) {

		isDraging = true;
		xx = e.getX();
		yy = e.getY();
		 }

		 public void mouseReleased(MouseEvent e) {
		isDraging = false;
		 }
		 });
	frame.addMouseMotionListener(new MouseMotionAdapter() {
		 public void mouseDragged(MouseEvent e) {

		if (isDraging) {
		 int left = frame.getLocation().x;
		 int top = frame.getLocation().y;
		 frame.setLocation(left + e.getX() - xx, top + e.getY() - yy);
		} 
		 }
		 });
	first.addMouseListener(new MouseAdapter(){
		public void mouseClicked(MouseEvent e){
			center.remove(center.getComponentAt(200,300));
			center.repaint();
		}
	});
	player.addMouseListener(new MouseAdapter(){
		public void mouseClicked(MouseEvent e){
			if(!(center.getComponentAt(0,20) instanceof PlayerExplorerPanel)){
					PlayerExplorerPanel total=new PlayerExplorerPanel();
					center.remove(center.getComponentAt(200,300));
					center.add(total);
					center.repaint();
			}
		}
	});
	match.addMouseListener(new MouseAdapter(){
          public void mouseClicked(MouseEvent e){
  			if(!(center.getComponentAt(0,20) instanceof MatchExplorerPanel)){
  				MatchExplorerPanel total=new MatchExplorerPanel();
  				center.remove(center.getComponentAt(200,300));
			center.add(total);
			center.repaint();
  			}		
		}
	});
	team.addMouseListener(new MouseAdapter(){
		public void mouseClicked(MouseEvent e){
  			if(!(center.getComponentAt(0,20) instanceof TeamExplorerPanel)){
  					TeamExplorerPanel total=new TeamExplorerPanel();
  					center.remove(center.getComponentAt(200,300));
			center.add(total);
			center.repaint();
  			}
		
		}
	});
	statics.addMouseListener(new MouseAdapter(){
		public void mouseClicked(MouseEvent e){
			if(!(center.getComponentAt(0,20) instanceof TeamExplorerPanel)){
					StaticsPanel total=new StaticsPanel();
					center.remove(center.getComponentAt(200,300));
		center.add(total);
		center.repaint();
			}
		}
	});
	search.addMouseListener(new MouseAdapter(){
		public void mouseClicked(MouseEvent e){
			center.remove(center.getComponentAt(200,300));
			center.repaint();
		}
	});
}

public static void main(String args[]){
	MainFrame test=new MainFrame();

	test.open();
//-----------------有的界面会出现一开始出不来但是鼠标移过去之后就出来了组件，陈大人教我这样子用线程刷新，但是也没有用----------------
//-----------------之前出现这种情况的时候我都是重新调一遍setbounds的，这个刷新的还是先留着吧------------------------
//	Thread thread=new Thread(){
//		public void run(){
//			try {
//				Thread.sleep(10000);
//				frame.repaint();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	};
//	thread.start();
}
}

