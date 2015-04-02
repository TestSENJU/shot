package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	
    public void teamSort(int AD){
    	
    	//
    	selectTeamUI getdata=new selectTeamUI();
    	String[] teamData=getdata.getData(AD);
    	JTextField jTextField=new JTextField(teamData[0]);
    	JTextField jTextField1=new JTextField(teamData[1]);
    	JTextField jTextField2=new JTextField(teamData[2]);
    	JTextField jTextField3=new JTextField(teamData[3]);
    	JTextField jTextField4=new JTextField(teamData[4]);
    	JTextField jTextField5=new JTextField(teamData[5]);
    	JTextField jTextField6=new JTextField(teamData[6]);
    	JTextField jTextField7=new JTextField(teamData[7]);
    	JTextField jTextField8=new JTextField(teamData[8]);
    	JTextField jTextField9=new JTextField(teamData[9]);
    	JTextField jTextField10=new JTextField(teamData[10]);
    	JTextField jTextField11=new JTextField(teamData[11]);
    	JTextField jTextField12=new JTextField(teamData[12]);
    	JTextField jTextField13=new JTextField(teamData[13]);
    	JTextField jTextField14=new JTextField(teamData[14]);
    	JTextField jTextField15=new JTextField(teamData[15]);
    	JTextField jTextField16=new JTextField(teamData[16]);
    	JTextField jTextField17=new JTextField(teamData[17]);
    	JTextField jTextField18=new JTextField(teamData[18]);
    	JTextField jTextField19=new JTextField(teamData[19]);
    	JTextField jTextField20=new JTextField(teamData[20]);
    	JTextField jTextField21=new JTextField(teamData[21]);
    	JTextField jTextField22=new JTextField(teamData[22]);
    	JTextField jTextField23=new JTextField(teamData[23]);
    	JTextField jTextField24=new JTextField(teamData[24]);
    	JTextField jTextField25=new JTextField(teamData[25]);
    	JTextField jTextField26=new JTextField(teamData[26]);
    	JTextField jTextField27=new JTextField(teamData[27]);
    	JTextField jTextField28=new JTextField(teamData[28]);
    	JTextField jTextField29=new JTextField(teamData[29]);
    	
    	//
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
    	for(int i=0;i<30;i++)
    	System.out.println(teamData[i]);
    	jTextField.setOpaque(false);
    	jTextField.setBounds(70, 120, 150, 50);
    	jTextField.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField);
    	jTextField1.setOpaque(false);
    	jTextField1.setBounds(70, 210, 150, 50);
    	jTextField1.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField1);
    	jTextField2.setOpaque(false);
    	jTextField2.setBounds(70, 290, 150, 50);
    	jTextField2.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField2);
    	jTextField3.setOpaque(false);
    	jTextField3.setBounds(70, 380, 150, 50);
    	jTextField3.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField3);
    	jTextField4.setOpaque(false);
    	jTextField4.setBounds(70, 465, 150, 50);
    	jTextField4.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField4);
    	jTextField5.setOpaque(false);
    	jTextField5.setBounds(70, 545, 150, 50);
    	jTextField5.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField5);
    	
    	jTextField6.setOpaque(false);
    	jTextField6.setBounds(300, 120, 150, 50);
    	jTextField6.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField6);
    	jTextField7.setOpaque(false);
    	jTextField7.setBounds(300, 210, 150, 50);
    	jTextField7.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField7);
    	jTextField8.setOpaque(false);
    	jTextField8.setBounds(300, 290, 150, 50);
    	jTextField8.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField8);
    	jTextField9.setOpaque(false);
    	jTextField9.setBounds(300, 380, 150, 50);
    	jTextField9.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField9);
    	jTextField10.setOpaque(false);
    	jTextField10.setBounds(300, 465, 150, 50);
    	jTextField10.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField10);
    	jTextField11.setOpaque(false);
    	jTextField11.setBounds(300, 545, 150, 50);
    	jTextField11.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField11);
    	
    	jTextField12.setOpaque(false);
    	jTextField12.setBounds(530, 120, 150, 50);
    	jTextField12.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField12);
    	jTextField13.setOpaque(false);
    	jTextField13.setBounds(530, 210, 150, 50);
    	jTextField13.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField13);
    	jTextField14.setOpaque(false);
    	jTextField14.setBounds(530, 290, 150, 50);
    	jTextField14.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField14);
    	jTextField15.setOpaque(false);
    	jTextField15.setBounds(530, 380, 150, 50);
    	jTextField15.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField15);
    	jTextField16.setOpaque(false);
    	jTextField16.setBounds(530, 465, 150, 50);
    	jTextField16.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField16);
    	jTextField17.setOpaque(false);
    	jTextField17.setBounds(530, 545, 150, 50);
    	jTextField17.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField17);
    	
    	jTextField18.setOpaque(false);
    	jTextField18.setBounds(780, 120, 150, 50);
    	jTextField18.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField18);
    	jTextField19.setOpaque(false);
    	jTextField19.setBounds(780, 210, 150, 50);
    	jTextField19.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField19);
    	jTextField20.setOpaque(false);
    	jTextField20.setBounds(780, 290, 150, 50);
    	jTextField20.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField20);
    	jTextField21.setOpaque(false);
    	jTextField21.setBounds(780, 380, 150, 50);
    	jTextField21.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField21);
    	jTextField22.setOpaque(false);
    	jTextField22.setBounds(780, 465, 150, 50);
    	jTextField22.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField22);
    	jTextField23.setOpaque(false);
    	jTextField23.setBounds(780, 545, 150, 50);
    	jTextField23.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField23);
    	
    	jTextField24.setOpaque(false);
    	jTextField24.setBounds(1030, 120, 150, 50);
    	jTextField24.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField24);
    	jTextField25.setOpaque(false);
    	jTextField25.setBounds(1030, 210, 150, 50);
    	jTextField25.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField25);
    	jTextField26.setOpaque(false);
    	jTextField26.setBounds(1030, 290, 150, 50);
    	jTextField26.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField26);
    	jTextField27.setOpaque(false);
    	jTextField27.setBounds(1030, 380, 150, 50);
    	jTextField27.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField27);
    	jTextField28.setOpaque(false);
    	jTextField28.setBounds(1030, 465, 150, 50);
    	jTextField28.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField28);
    	jTextField29.setOpaque(false);
    	jTextField29.setBounds(1030, 545, 150, 50);
    	jTextField29.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField29);
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
				ui.selectTeam();
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
    public static void main(String[]args){
    	teamSortUI ui=new teamSortUI();
    	int AD = 0;
    	ui.teamSort(AD);
    }
}
