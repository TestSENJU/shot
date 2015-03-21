package ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class playersBeforeFiftyUI{
	JFrame jFrame=new JFrame("球员前50名");
	JLabel jLabel1=new JLabel("background");
	JLabel jLabel2=new JLabel("back");
	JLabel jLabel3=new JLabel(" ");
    ImageIcon background=new ImageIcon("C://nba/picture/playerBackground3.jpg");
    ImageIcon back=new ImageIcon("C://nba/picture/playerBackground1Back.jpg");
    ImageIcon exit=new ImageIcon("C://nba/picture/playerBackground1Exit.jpg");
    String[] playerBeforeFifty=null;
    JTextField jTextField;
    public void playersBeforeFiftyUI(String[] playerBeforeFifty){
    	jFrame.setUndecorated(true);
    	jFrame.setVisible(true);
    	jFrame.setSize(1200, 700);
    	jFrame.setLayout(null);
    	jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    	jFrame.setLocationRelativeTo(null);
    	jLabel1.setBounds(0, 0, 1200, 700);
    	jLabel1.setIcon(background);
    	jLabel2.setIcon(back);
    	jLabel3.setIcon(exit);
    	jFrame.add(jLabel1);
    	jLabel2.setBounds(0, 0, 50, 35);
    	jLabel1.add(jLabel2);
    	jLabel3.setBounds(1120, 0, 80, 80);
    	jLabel1.add(jLabel3);
    	for(int i=0;i<10;i++){
    		for(int j=0;i<5;j++){
    			jTextField=new JTextField();
    			jTextField.setBounds(10+230*j, 70+58*i, 230, 58);
    			jTextField.setFont(new Font("宋体",Font.BOLD,30));
    		}
    	}
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
				playersCheckUI ui=new playersCheckUI();
				ui.playersCheckUI();
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
}
