package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.plaf.ViewportUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

public class playersInformationUI {
    JFrame jFrame=new JFrame("球员信息查看");
    JLabel jLabel1=new JLabel("background");
    JLabel jLabel2=new JLabel("back");
    JLabel jLabel3=new JLabel(" ");
    ImageIcon background=new ImageIcon("C://nba/picture/playerBackground2.jpg");
    ImageIcon back=new ImageIcon("C://nba/picture/playerBackground1Back.jpg");
    ImageIcon exit=new ImageIcon("C://nba/picture/playerBackground1Exit.jpg");
    String[] data={" ","赛季总数据","赛季平均数据"};
    JTextField jTextField1;
    JTextField jTextField2;
    JComboBox jComboBox=new JComboBox(data);
    String selectCondition=(String)jComboBox.getSelectedItem();
    public String[] getPlayerData(){
    	String[] playerData=null;
    	if(selectCondition.equals("赛季总数据")){
    		return playerData;
    	}
    	if(selectCondition.equals("赛季平均数据")){
    		return playerData;
    	}
    	else 
			return null;
    }
    public void playerInformationUI(){
    	jFrame.setUndecorated(true);
    	jFrame.setVisible(true);
    	jFrame.setSize(1200, 700);
    	jFrame.setLayout(null);
    	jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    	jFrame.setLocationRelativeTo(null);
    	playersInformationUI ui=new playersInformationUI();
    	String[] playerData=ui.getPlayerData();
    	String[] columnNames={"参赛场数","先发场数","篮板数","助攻数","在场时间","投篮命中率","三分命中率","罚球命中率","进攻数"};
        String[][] tableValues={{"参赛场数","先发场数","篮板数","助攻数","在场时间","投篮命中率","三分命中率","罚球命中率","进攻数"},{playerData[2],playerData[3],playerData[4],playerData[5],playerData[6],playerData[7],playerData[8],playerData[9],playerData[10]},{"防守数","抢断数","盖帽数","失误数","犯规数","得分","效率","GmSc效率值","真实命中率"},{playerData[11],playerData[12],playerData[13],playerData[14],playerData[15],playerData[16],playerData[17],playerData[18],playerData[19]},{"投篮效率","篮板率","进攻篮板率","防守篮板率","助攻率","抢断率","盖帽率","失误率","使用率"},{playerData[20],playerData[21],playerData[22],playerData[23],playerData[24],playerData[25],playerData[26],playerData[27],playerData[28]}};
        jTextField1.setBounds(600, 200, 200, 50);
        jTextField1=new JTextField(playerData[0]);
        jTextField1.setFont(new Font("宋体", Font.BOLD, 30));
        jTextField2.setBounds(600, 300, 200, 50);
        jTextField2=new JTextField(playerData[1]);
        jTextField2.setFont(new Font("宋体", Font.BOLD, 30));
        JTable table1=new JTable(tableValues,columnNames);
        table1.setBounds(0, 480, 1200, 200);
    	jLabel1.add(table1);
        jLabel1.setBounds(0, 0, 1200, 700);
        jLabel1.setIcon(background);
        jLabel2.setIcon(back);
        jLabel3.setIcon(exit);
        jFrame.add(jLabel1);
        jComboBox.setBounds(400, 360, 200, 50);
    	jLabel1.add(jComboBox);
    	jLabel2.setBounds(0, 0, 50, 35);
    	jLabel1.add(jLabel2);
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

