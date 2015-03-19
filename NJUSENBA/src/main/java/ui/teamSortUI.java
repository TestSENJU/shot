package ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;

public class teamSortUI {
	JFrame jFrame=new JFrame("球队前30名");
	JLabel jLabel1= new JLabel("background");
	JLabel jLabel2=new JLabel("back");
	ImageIcon background=new ImageIcon("C://nba/picture/backgroundSAC.jpg");
	ImageIcon back=new ImageIcon("C://nba/picture/backgroundSACBack.jpg");
	JTable jTable=new JTable(6, 10);
    public void teamSortUI(){
    	jFrame.setVisible(true);
    	jFrame.setSize(900, 600);
    	jFrame.setLayout(null);
    	jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    	jFrame.setLocationRelativeTo(null);
    	jTable.setBounds(0, 0, 900, 600);
    	jFrame.add(jLabel1);
    	jTable.setBounds(0, 50, 900, 300);
    	jTable.setOpaque(false);
     	jLabel1.add(jTable);
    	jLabel1.setIcon(background);
    	jLabel1.setBounds(0, 0, 900, 600);
    	jLabel2.setIcon(back);
    	jLabel2.setBounds(0, 0, 60, 40);
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
				selectTeamUI ui=new selectTeamUI();
				ui.selectTeamUI();
			}
		});
    }
}
