package ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class mainUI {
	JFrame jFrame=new JFrame("mainUI");
	JLabel jLabel1=new JLabel("background");
	JLabel jLabel2=new JLabel("enter");
	JLabel jLabel3=new JLabel(" ");
	ImageIcon background=new ImageIcon("img/picture/background1.jpg");
	ImageIcon enter=new ImageIcon("img/picture/background1Enter.jpg");
	ImageIcon exit=new ImageIcon("img/picture/background1Exit.jpg");
    public void drawMainUI(){
    	jFrame.setUndecorated(true);
    	jFrame.setVisible(true);
    	jFrame.setSize(1200, 700);
    	jFrame.setLayout(null);
    	jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    	jFrame.setLocationRelativeTo(null);
    	jLabel1.setBounds(0, 0, 1200,700);
    	jFrame.add(jLabel1);
    	jLabel1.add(jLabel2);
    	jLabel1.setIcon(background);
    	jLabel2.setIcon(enter);
    	jLabel3.setIcon(exit);
    	jLabel2.setBounds(460, 480, 280, 60);
    	jLabel3.setBounds(1120, 0, 80, 80);
    	jLabel1.add(jLabel3);
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
				jFrame.dispose();
				selectTorPUI sTorPUI=new selectTorPUI();
				sTorPUI.drawSelectTorPUI();
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
				jFrame.dispose();
			}
		});
    }
	public static void main(String[]args){
    	mainUI ui=new mainUI();
    	ui.drawMainUI();
    }
}
