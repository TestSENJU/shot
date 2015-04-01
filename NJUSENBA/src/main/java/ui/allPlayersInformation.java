package ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;

public class allPlayersInformation {
	 JFrame jFrame=new JFrame("所有球员信息");
	 String[] data={" ","赛季总数据","赛季平均数据"};
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	JComboBox jComboBox=new JComboBox(data);
	 JTable jTable;
	 JLabel jLabel1=new JLabel();
	 JLabel jLabel2=new JLabel();
	 JLabel jLabel3=new JLabel();
	 ImageIcon background=new ImageIcon("img/picture/playerBackground.jpg");
	 ImageIcon back=new ImageIcon("img/picture/playerBackground1Back.jpg");
	 ImageIcon exit=new ImageIcon("img/picture/playerBackground1Exit.jpg");
	 JScrollPane jScrollPane;
	 public String getSelectCondition(){
		 String selectCondition=(String)jComboBox.getSelectedItem();
		 return selectCondition;
	 }
	 public String[] getData(){
		 String[] playerData=null;
		 String selectCondition=getSelectCondition();
		 if(selectCondition.equals("赛季总数据")){
			 return playerData;
		 }
		 else if(selectCondition.equals("赛季平均数据")){
			 return playerData;
		 }
		 else 
			 return null;
	 }
	public void allPlayersInformationUI(){
		jFrame.setUndecorated(true);
    	jFrame.setSize(1200, 700);
    	jFrame.setLayout(null);
    	jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    	jFrame.setLocationRelativeTo(null);
      	jLabel1.setBounds(0, 0, 1200, 700);
    	jLabel1.setIcon(background);
    	jFrame.add(jLabel1);
    	jComboBox.setBounds(800, 10, 200, 50);
    	jLabel1.add(jComboBox);
    	jTable=new JTable(897, 15);
    	jTable.setBounds(2, 82,1196,618);
    	jLabel1.add(jTable);
    	jScrollPane=new JScrollPane(jTable);
        jLabel1.add(jScrollPane);
    	jScrollPane.setBounds(0, 80, 1200, 600);
    	jFrame.setVisible(true);
    	jLabel2.setIcon(back);
    	jLabel3.setIcon(exit);
    	jLabel2.setBounds(0, 0, 50, 35);
    	jLabel1.add(jLabel2);
    	jLabel3.setBounds(1120, 0, 80, 80);
    	jLabel1.add(jLabel3);
    	jLabel2.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				jFrame.dispose();
				selectTeamUI ui=new selectTeamUI();
				ui.selectTeam();
			}
		});
    	jLabel3.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				jFrame.dispose();
			}
		});
	}
	public static void main(String[]args){
		allPlayersInformation ui=new allPlayersInformation();
		ui.allPlayersInformationUI();
	}
}
