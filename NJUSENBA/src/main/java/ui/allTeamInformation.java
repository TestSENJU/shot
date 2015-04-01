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

public class allTeamInformation {
	JFrame jFrame=new JFrame("所有球队信息");
	JLabel jLabel1=new JLabel();
	JLabel jLabel2=new JLabel();
	JLabel jLabel3=new JLabel();
	JLabel jLabel4=new JLabel();
	ImageIcon background=new ImageIcon("img/picture/teamBackground.jpg");
	ImageIcon back=new ImageIcon("img/picture/teamBackground1Back.jpg");
	ImageIcon exit=new ImageIcon("img/picture/teamBackground1Exit.jpg");
	String[] select={" ","赛季总数据","赛季场均数据"};
	JTable jTable;
    JComboBox jComboBox=new JComboBox(select);
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
    public void allTeamInformation(){
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
    	jTable=new JTable(61,14);
    	jTable.setBounds(2, 82,1196,618);
    	jLabel1.add(jTable);
    	jScrollPane=new JScrollPane(jTable);
    	jLabel1.add(jScrollPane);
    	jScrollPane.setBounds(0, 80, 1200, 600);
    	jFrame.setVisible(true);
    	jLabel2.setBounds(0, 0, 70, 40);
    	jLabel2.setIcon(back);
    	jLabel1.add(jLabel2);
    	jLabel3.setBounds(1120, 0, 80, 80);
    	jLabel3.setIcon(exit);
    	jLabel1.add(jLabel3);
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
