package ui;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import org.omg.CORBA.PUBLIC_MEMBER;

public class allPlayersInformation {
	JFrame jFrame=new JFrame("球员前50名");
	 String[] data={" ","赛季总数据","赛季平均数据"};
	 JComboBox jComboBox=new JComboBox(data);
	public void allPlayersInformationUI(){
		jFrame.setUndecorated(true);
    	jFrame.setVisible(true);
    	jFrame.setSize(1200, 700);
    	jFrame.setLayout(null);
    	jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    	jFrame.setLocationRelativeTo(null);
    	jComboBox.setBounds(10, 10, 200, 50);
	}
	public String getSelectCondition(){
		String selectCondition=(String)jComboBox.getSelectedItem();
	    return selectCondition;
	}
}
