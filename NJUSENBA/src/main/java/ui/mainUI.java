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

public class mainUI {
	JFrame jFrame=new JFrame("mainUI");
	JLabel jLabel1=new JLabel("mainUI");
	JLabel jLabel2=new JLabel("mainBuuton");
	ImageIcon mainUI=new ImageIcon("C://nba/picture/mainUI2.jpg");
	ImageIcon  mainButton=new ImageIcon("C://nba/picture/mainButton.jpg");
    public void drawMainUI(){
    	jFrame.setVisible(true);
    	jFrame.setSize(900, 380);
    	jFrame.setLayout(null);
    	jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    	jFrame.setLocationRelativeTo(null);
    	jLabel1.setBounds(0, 0, 900, 380);
    	jLabel1.setIcon(mainUI);
    	jLabel2.setIcon(mainButton);
    	jLabel2.setBounds(370, 240, 200, 120);
    	jFrame.add(jLabel1);
    	jLabel1.add(jLabel2);
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
    }
	public static void main(String[]args){
    	mainUI ui=new mainUI();
    	ui.drawMainUI();
    }
}
