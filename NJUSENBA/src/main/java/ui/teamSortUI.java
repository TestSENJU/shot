package ui;

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

public class teamSortUI {
	JFrame jFrame=new JFrame("球队前30名");
	JLabel jLabel1= new JLabel("background");
	JLabel jLabel2=new JLabel("back");
	JLabel jLabel3=new JLabel(" ");
	ImageIcon background=new ImageIcon("img/picture/teamBackground3.jpg");
	ImageIcon back=new ImageIcon("img/picture/teamBackground1Back.jpg");
	ImageIcon exit=new ImageIcon("img/picture/teamBackground1Exit.jpg");
	JTextField jTextField;
	public String[] getPlayerSort(){
		String[] playerSort=null;
		return playerSort;
	}
    public void teamSortUI(){
    	jFrame.setUndecorated(true);
    	jFrame.setVisible(true);
    	jFrame.setSize(1200, 700);
    	jFrame.setLayout(null);
    	jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    	jFrame.setLocationRelativeTo(null);
    	jLabel1.setIcon(background);
    	jLabel2.setIcon(back);
    	jLabel3.setIcon(exit);
    	jLabel1.setBounds(0, 0, 1200, 700);
    	jFrame.add(jLabel1);
    	jLabel2.setBounds(0, 0, 70, 40);
    	jLabel1.add(jLabel2);
    	jLabel3.setBounds(1120, 0, 80, 80);
    	jLabel1.add(jLabel3);
    	jTextField.setOpaque(false);
    	String[] teamSort=getPlayerSort();
    	for(int i=0;i<6;i++){
    		for(int j=0;j<5;j++){
    		jTextField.setBounds(10+200*j, 120+80*i, 200, 80);
    		jTextField=new JTextField(teamSort[i*j]);
    		jTextField.setFont(new Font("宋体", Font.BOLD, 30));
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
				selectTeamUI ui=new selectTeamUI();
				ui.selectTeamUI();
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
				jFrame.dispose();
			}
		});
    }
}
