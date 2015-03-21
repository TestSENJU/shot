package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class selectTorPUI {
	JFrame jFrame=new JFrame("选择进入球员或者球队查询系统");
	JLabel jLabel1=new JLabel("background");
	JLabel jLabel2=new JLabel("backgroundPlayer");
	JLabel jLabel3=new JLabel("backgroundTeam");
	JLabel jLabel4=new JLabel(" ");
	JLabel jLabel5=new JLabel(" ");
	ImageIcon background=new ImageIcon("C://nba/picture/background2.jpg");
	ImageIcon backgroundPlayer=new ImageIcon("C://nba/picture/background2Player.jpg");
	ImageIcon backgroundTeam=new ImageIcon("C://nba/picture/background2Team.jpg");
	ImageIcon exit=new ImageIcon("C://nba/picture/background1Exit.jpg");
	ImageIcon back=new ImageIcon("C://nba/picture/background2Back.jpg");
    public void drawSelectTorPUI(){
    	jFrame.setUndecorated(true);
    	jFrame.setVisible(true);
    	jFrame.setSize(1200, 700);
    	jFrame.setLayout(null);
    	jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    	jFrame.setLocationRelativeTo(null);
    	jLabel1.setBounds(0, 0, 1200, 700);
    	jLabel2.setBounds(120, 500, 420, 60);
    	jLabel3.setBounds(670, 500, 420, 60);
    	jLabel4.setBounds(1120, 0, 80, 80);
    	jLabel5.setBounds(0, 0, 75, 44);
    	jLabel1.setIcon(background);
        jLabel2.setIcon(backgroundPlayer);
    	jLabel3.setIcon(backgroundTeam);
    	jLabel4.setIcon(exit);
    	jLabel5.setIcon(back);
        jFrame.add(jLabel1);
    	jLabel1.add(jLabel2);
    	jLabel1.add(jLabel3);
    	jLabel1.add(jLabel4);
    	jLabel1.add(jLabel5);
        jLabel2.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				playersCheckUI ui=new playersCheckUI();
				ui.playersCheckUI();
				jFrame.dispose();
			}
		});
        jLabel3.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				selectTeamUI sTeamUI=new selectTeamUI();
				sTeamUI.selectTeamUI();
				jFrame.dispose();
			}
		});
        jLabel4.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				jFrame.dispose();
			}
		});
        jLabel5.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				jFrame.dispose();
				mainUI ui=new mainUI();
				ui.drawMainUI();
			}
		});
    }
}
