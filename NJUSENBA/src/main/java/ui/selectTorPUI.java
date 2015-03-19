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
	JLabel jLabel2=new JLabel("teamSelectButton");
	JLabel jLabel3=new JLabel("playerSelect");
	ImageIcon background=new ImageIcon("C://nba/picture/TorP.jpg");
	ImageIcon teamSelectButton=new ImageIcon("C://nba/picture/teamSelect.jpg");
	ImageIcon playerSelect=new ImageIcon("C://nba/picture/playerSelect.jpg");
    public void drawSelectTorPUI(){
    	jFrame.setVisible(true);
    	jFrame.setSize(900, 650);
    	jFrame.setLayout(null);
    	jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    	jFrame.setLocationRelativeTo(null);
    	jLabel1.setBounds(0, 0, 900, 600);
    	jLabel2.setBounds(350, 520, 150, 60);
    	jLabel3.setBounds(500, 520, 150, 60);
    	jLabel1.setIcon(background);
        jLabel2.setIcon(teamSelectButton);
    	jLabel3.setIcon(playerSelect);
        jFrame.add(jLabel1);
    	jLabel1.add(jLabel2);
    	jLabel1.add(jLabel3);
        jLabel2.addMouseListener(new MouseListener() {
			
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
        jLabel3.addMouseListener(new MouseListener() {
			
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
    }
}
