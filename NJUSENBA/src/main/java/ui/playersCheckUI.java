package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class playersCheckUI {
    JFrame jFrame=new JFrame("球员数据查看");
    JLabel jLabel1=new JLabel("background");
    JLabel jLabel2=new JLabel("back");
    JLabel jLabel3=new JLabel(" ");
    JLabel jLabel4=new JLabel("search");
    JLabel jLabel5=new JLabel("check");
    JLabel jLabel6=new JLabel("allCheck");
    String[] position={" ","前锋","中锋","后卫"};
    String[] league={" ","东部","西部","中部区","大西洋区","西北区","太平洋区","东南区","西南区"};
    String[] condition={" ","得分","篮板","助攻","得分/篮板/助攻","盖帽","抢断","犯规","失误","分钟","效率","投篮","三分","罚球","两双"};
    JComboBox jComboBox1=new JComboBox(condition);
    JComboBox jComboBox2=new JComboBox(position);
    JComboBox jComboBox3=new JComboBox(league);
    ImageIcon background=new ImageIcon("img/picture/playerBackground1.jpg");
    ImageIcon back=new ImageIcon("img/picture/playerBackground1Back.jpg");
    ImageIcon exit=new ImageIcon("img/picture/playerBackground1Exit.jpg");
    ImageIcon search=new ImageIcon("img/picture/playerBackground1Check.jpg");
    ImageIcon check=new ImageIcon("img/picture/playerBackground1search.jpg");
    ImageIcon allCheck=new ImageIcon("img/picture/playerBackground1AllCheck.jpg");
    JTextField jTextField=new JTextField(" ");
    public String[] getSelectCondition(){
    	String[] select={(String)jComboBox1.getSelectedItem(),(String)jComboBox2.getSelectedItem(),(String)jComboBox3.getSelectedItem()};
    	return select;
    }
    public String getPlayerName(){
    	String playerName=jTextField.getText();
    	return playerName;
    }
    public void playersCheckUI(){
    	jFrame.setUndecorated(true);
    	jFrame.setVisible(true);
    	jFrame.setSize(1200, 700);
    	jFrame.setLayout(null);
    	jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    	jFrame.setLocationRelativeTo(null);
        jLabel1.setIcon(background);
        jLabel2.setIcon(back);
        jLabel3.setIcon(exit);
        jLabel4.setIcon(search);
        jLabel5.setIcon(check);
        jComboBox1.setBounds(400, 220, 200, 50);
    	jLabel1.add(jComboBox1);
    	jComboBox2.setBounds(400, 330, 200, 50);
    	jLabel1.add(jComboBox2);
    	jComboBox3.setBounds(400, 430, 200, 50);
    	jLabel1.add(jComboBox3);
        jLabel1.setBounds(0, 0, 1200, 700);
        jFrame.add(jLabel1);
    	jLabel2.setBounds(0, 0, 50, 35);
    	jLabel1.add(jLabel2);
    	jLabel3.setBounds(1120, 0, 80, 80);
    	jLabel1.add(jLabel3);
    	jLabel4.setBounds(750, 100, 140, 60);
    	jLabel1.add(jLabel4);
    	jLabel5.setBounds(750, 320, 130, 60);
    	jLabel1.add(jLabel5);
    	jTextField.setBounds(500, 100, 200, 50);
    	jLabel1.add(jTextField);
    	jLabel6.setBounds(10, 580, 450, 50);
    	jLabel6.setIcon(allCheck);
    	jLabel1.add(jLabel6);
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
				jFrame.dispose();
				selectTorPUI ui=new selectTorPUI();
				ui.drawSelectTorPUI();
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
    	jLabel4.addMouseListener(new MouseListener() {
			
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
				playersInformationUI ui=new playersInformationUI();
			    ui.playerInformationUI();
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
				playersBeforeFiftyUI ui=new playersBeforeFiftyUI();
				ui.playersBeforeFiftyUI();
			}
		});
    	jLabel6.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				allPlayersInformation ui=new allPlayersInformation();
				ui.allPlayersInformationUI();
				jFrame.dispose();
			}
		});
    }
    public static void main(String[]args){
    	playersCheckUI ui=new playersCheckUI();
    	ui.playersCheckUI();
    }
}
