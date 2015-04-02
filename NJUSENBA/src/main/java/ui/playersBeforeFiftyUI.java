package ui;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class playersBeforeFiftyUI{
	JFrame jFrame=new JFrame("球员前50名");
	JLabel jLabel1=new JLabel("background");
	JLabel jLabel2=new JLabel("back");
	JLabel jLabel3=new JLabel(" ");
    ImageIcon background=new ImageIcon("img/picture/playerBackground3.jpg");
    ImageIcon back=new ImageIcon("img/picture/playerBackground1Back.jpg");
    ImageIcon exit=new ImageIcon("img/picture/playerBackground1Exit.jpg");
    playersCheckUI ui=new playersCheckUI();
    String[] playerNameData=ui.getData();
    JTextField jTextField=new JTextField(playerNameData[0]);
    JTextField jTextField1=new JTextField(playerNameData[1]);
    JTextField jTextField2=new JTextField(playerNameData[2]);
    JTextField jTextField3=new JTextField(playerNameData[3]);
    JTextField jTextField4=new JTextField(playerNameData[4]);
    JTextField jTextField5=new JTextField(playerNameData[5]);
    JTextField jTextField6=new JTextField(playerNameData[6]);
    JTextField jTextField7=new JTextField(playerNameData[7]);
    JTextField jTextField8=new JTextField(playerNameData[8]);
    JTextField jTextField9=new JTextField(playerNameData[9]);
    
    JTextField jTextField10=new JTextField(playerNameData[10]);
    JTextField jTextField11=new JTextField(playerNameData[11]);
    JTextField jTextField12=new JTextField(playerNameData[12]);
    JTextField jTextField13=new JTextField(playerNameData[13]);
    JTextField jTextField14=new JTextField(playerNameData[14]);
    JTextField jTextField15=new JTextField(playerNameData[15]);
    JTextField jTextField16=new JTextField(playerNameData[16]);
    JTextField jTextField17=new JTextField(playerNameData[17]);
    JTextField jTextField18=new JTextField(playerNameData[18]);
    JTextField jTextField19=new JTextField(playerNameData[19]);
    
    JTextField jTextField20=new JTextField(playerNameData[20]);
    JTextField jTextField21=new JTextField(playerNameData[21]);
    JTextField jTextField22=new JTextField(playerNameData[22]);
    JTextField jTextField23=new JTextField(playerNameData[23]);
    JTextField jTextField24=new JTextField(playerNameData[24]);
    JTextField jTextField25=new JTextField(playerNameData[25]);
    JTextField jTextField26=new JTextField(playerNameData[26]);
    JTextField jTextField27=new JTextField(playerNameData[27]);
    JTextField jTextField28=new JTextField(playerNameData[28]);
    JTextField jTextField29=new JTextField(playerNameData[29]);
    
    JTextField jTextField30=new JTextField(playerNameData[30]);
    JTextField jTextField31=new JTextField(playerNameData[31]);
    JTextField jTextField32=new JTextField(playerNameData[32]);
    JTextField jTextField33=new JTextField(playerNameData[33]);
    JTextField jTextField34=new JTextField(playerNameData[34]);
    JTextField jTextField35=new JTextField(playerNameData[35]);
    JTextField jTextField36=new JTextField(playerNameData[36]);
    JTextField jTextField37=new JTextField(playerNameData[37]);
    JTextField jTextField38=new JTextField(playerNameData[38]);
    JTextField jTextField39=new JTextField(playerNameData[39]);
    
    JTextField jTextField40=new JTextField(playerNameData[40]);
    JTextField jTextField41=new JTextField(playerNameData[41]);
    JTextField jTextField42=new JTextField(playerNameData[42]);
    JTextField jTextField43=new JTextField(playerNameData[43]);
    JTextField jTextField44=new JTextField(playerNameData[44]);
    JTextField jTextField45=new JTextField(playerNameData[45]);
    JTextField jTextField46=new JTextField(playerNameData[46]);
    JTextField jTextField47=new JTextField(playerNameData[47]);
    JTextField jTextField48=new JTextField(playerNameData[48]);
    JTextField jTextField49=new JTextField(playerNameData[49]);
    public void playersBeforeFifty(){
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
    	
    	jTextField.setOpaque(false);
    	jTextField.setBounds(70, 70, 150, 50);
    	jTextField.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField);
    	jTextField1.setOpaque(false);
    	jTextField1.setBounds(70, 130, 150, 50);
    	jTextField1.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField1);
    	jTextField2.setOpaque(false);
    	jTextField2.setBounds(70, 190, 150, 50);
    	jTextField2.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField2);
    	jTextField3.setOpaque(false);
    	jTextField3.setBounds(70, 250, 150, 50);
    	jTextField3.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField3);
    	jTextField4.setOpaque(false);
    	jTextField4.setBounds(70, 310, 150, 50);
    	jTextField4.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField4);
    	jTextField5.setOpaque(false);
    	jTextField5.setBounds(70, 370, 150, 50);
    	jTextField5.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField5);
    	jTextField6.setOpaque(false);
    	jTextField6.setBounds(70, 430, 150, 50);
    	jTextField6.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField6);
    	jTextField7.setOpaque(false);
    	jTextField7.setBounds(70, 490, 150, 50);
    	jTextField7.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField7);
    	jTextField8.setOpaque(false);
    	jTextField8.setBounds(70, 550, 150, 50);
    	jTextField8.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField8);
    	jTextField9.setOpaque(false);
    	jTextField9.setBounds(70, 610, 150, 50);
    	jTextField9.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField9);
    	
    	jTextField10.setOpaque(false);
    	jTextField10.setBounds(300, 70, 150, 50);
    	jTextField10.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField10);
    	jTextField11.setOpaque(false);
    	jTextField11.setBounds(300, 130, 150, 50);
    	jTextField11.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField11);
    	jTextField12.setOpaque(false);
    	jTextField12.setBounds(300, 190, 150, 50);
    	jTextField12.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField12);
    	jTextField13.setOpaque(false);
    	jTextField13.setBounds(300, 250, 150, 50);
    	jTextField13.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField13);
    	jTextField14.setOpaque(false);
    	jTextField14.setBounds(300, 310, 150, 50);
    	jTextField14.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField14);
    	jTextField15.setOpaque(false);
    	jTextField15.setBounds(300, 370, 150, 50);
    	jTextField15.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField15);
    	jTextField16.setOpaque(false);
    	jTextField16.setBounds(300, 430, 150, 50);
    	jTextField16.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField16);
    	jTextField17.setOpaque(false);
    	jTextField17.setBounds(300, 490, 150, 50);
    	jTextField17.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField17);
    	jTextField18.setOpaque(false);
    	jTextField18.setBounds(300, 530, 150, 50);
    	jTextField18.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField18);
    	jTextField19.setOpaque(false);
    	jTextField19.setBounds(300, 610, 150, 50);
    	jTextField19.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField19);
    	
    	jTextField20.setOpaque(false);
    	jTextField20.setBounds(530, 70, 150, 50);
    	jTextField20.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField20);
    	jTextField21.setOpaque(false);
    	jTextField21.setBounds(530, 130, 150, 50);
    	jTextField21.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField21);
    	jTextField22.setOpaque(false);
    	jTextField22.setBounds(530, 190, 150, 50);
    	jTextField22.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField22);
    	jTextField23.setOpaque(false);
    	jTextField23.setBounds(530, 250, 150, 50);
    	jTextField23.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField23);
    	jTextField24.setOpaque(false);
    	jTextField24.setBounds(530, 310, 150, 50);
    	jTextField24.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField24);
    	jTextField25.setOpaque(false);
    	jTextField25.setBounds(530, 370, 150, 50);
    	jTextField25.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField25);
    	jTextField26.setOpaque(false);
    	jTextField26.setBounds(530, 430, 150, 50);
    	jTextField26.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField26);
    	jTextField27.setOpaque(false);
    	jTextField27.setBounds(530, 490, 150, 50);
    	jTextField27.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField27);
    	jTextField28.setOpaque(false);
    	jTextField28.setBounds(530, 550, 150, 50);
    	jTextField28.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField28);
    	jTextField29.setOpaque(false);
    	jTextField29.setBounds(530, 610, 150, 50);
    	jTextField29.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField29);
    	
    	jTextField30.setOpaque(false);
    	jTextField30.setBounds(780, 70, 150, 50);
    	jTextField30.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField30);
    	jTextField31.setOpaque(false);
    	jTextField31.setBounds(780, 130, 150, 50);
    	jTextField31.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField31);
    	jTextField32.setOpaque(false);
    	jTextField32.setBounds(780, 190, 150, 50);
    	jTextField32.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField32);
    	jTextField33.setOpaque(false);
    	jTextField33.setBounds(780, 250, 150, 50);
    	jTextField33.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField33);
    	jTextField34.setOpaque(false);
    	jTextField34.setBounds(780, 310, 150, 50);
    	jTextField34.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField34);
    	jTextField35.setOpaque(false);
    	jTextField35.setBounds(780, 370, 150, 50);
    	jTextField35.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField35);
    	jTextField36.setOpaque(false);
    	jTextField36.setBounds(780, 430, 150, 50);
    	jTextField36.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField36);
    	jTextField37.setOpaque(false);
    	jTextField37.setBounds(780, 490, 150, 50);
    	jTextField37.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField37);
    	jTextField38.setOpaque(false);
    	jTextField38.setBounds(780, 550, 150, 50);
    	jTextField38.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField38);
    	jTextField39.setOpaque(false);
    	jTextField39.setBounds(780, 610, 150, 50);
    	jTextField39.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField39);
    	
    	jTextField40.setOpaque(false);
    	jTextField40.setBounds(1030, 70, 150, 50);
    	jTextField40.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField40);
    	jTextField41.setOpaque(false);
    	jTextField41.setBounds(1030, 130, 150, 50);
    	jTextField41.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField41);
    	jTextField42.setOpaque(false);
    	jTextField42.setBounds(1030, 190, 150, 50);
    	jTextField42.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField42);
    	jTextField43.setOpaque(false);
    	jTextField43.setBounds(1030, 250, 150, 50);
    	jTextField43.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField43);
    	jTextField44.setOpaque(false);
    	jTextField44.setBounds(1030, 310, 150, 50);
    	jTextField44.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField44);
    	jTextField45.setOpaque(false);
    	jTextField45.setBounds(1030, 370, 150, 50);
    	jTextField45.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField45);
    	jTextField46.setOpaque(false);
    	jTextField46.setBounds(1030, 430, 150, 50);
    	jTextField46.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField46);
    	jTextField47.setOpaque(false);
    	jTextField47.setBounds(1030, 490, 150, 50);
    	jTextField47.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField47);
    	jTextField48.setOpaque(false);
    	jTextField48.setBounds(1030, 550, 150, 50);
    	jTextField48.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField48);
    	jTextField49.setOpaque(false);
    	jTextField49.setBounds(1030, 610, 150, 50);
    	jTextField49.setFont(new Font("宋体", Font.BOLD, 30));
    	jLabel1.add(jTextField49);
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
				ui.playersCheck();
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
