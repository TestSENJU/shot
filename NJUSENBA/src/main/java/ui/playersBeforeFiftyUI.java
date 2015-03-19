package ui;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;

public class playersBeforeFiftyUI{
	JFrame jFrame=new JFrame("球员前50名");
	JLabel jLabel1=new JLabel("background");
    ImageIcon background=new ImageIcon("C://nba/picture/player2.jpg");
	JTable jTable=new JTable(10, 10);
    public void playersBeforeFiftyUI(){
    	jFrame.setVisible(true);
    	jFrame.setSize(900, 600);
    	jFrame.setLayout(null);
    	jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    	jFrame.setLocationRelativeTo(null);
    	jLabel1.setBounds(0, 0, 900, 600);
    	jLabel1.setIcon(background);
    	jTable.setBounds(0, 0, 900,180);
    	jLabel1.add(jTable);
    	jFrame.add(jLabel1);
    }
}
