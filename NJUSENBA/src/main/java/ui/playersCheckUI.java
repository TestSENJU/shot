package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class playersCheckUI {
    JFrame jFrame=new JFrame("球员数据查看");
    JTextField jTextField=new JTextField("请输入所要查看球员姓名");
    JButton jButton1=new JButton("搜索");
    JButton jButton2=new JButton("查看");
    JLabel jLabel1=new JLabel("请选择分区条件：");
    JLabel jLabel2=new JLabel("请选择升降序条件：");
    String[] selecteditem={"前锋","中锋","后卫","东部","西部","中部区","大西洋区","西北区","太平洋区","东南区","西南区"};
    String[] positionAndLeague={"前锋","中锋","后卫","东部","西部","中部区","大西洋区","西北区","太平洋区","东南区","西南区"};
    JComboBox jComboBox1=new JComboBox(selecteditem);
    JComboBox jComboBox2=new JComboBox(positionAndLeague);
    JLabel jLabel3=new JLabel("background");
    ImageIcon background=new ImageIcon("C://nba/picture/player2.jpg");
    public void playersCheckUI(){
    	jFrame.setVisible(true);
    	jFrame.setSize(900, 600);
    	jFrame.setLayout(null);
    	jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    	jFrame.setLocationRelativeTo(null);
    	jLabel1.setBounds(50, 350, 150, 50);
    	jLabel3.add(jLabel1);
    	jLabel2.setBounds(500, 350, 150, 50);
    	jLabel3.add(jLabel2);
    	jLabel3.setBounds(0, 0, 900, 600);
    	jLabel3.setIcon(background);
    	jFrame.add(jLabel3);
    	jTextField.setBounds(200, 50, 200, 50);
    	jLabel3.add(jTextField);
    	jButton1.setBounds(550, 50, 100, 50);
    	jLabel3.add(jButton1);
    	jButton2.setBounds(380, 450, 200, 50);
    	jLabel3.add(jButton2);
    	jComboBox1.setBounds(200, 350, 200, 50);
    	jLabel3.add(jComboBox1);
    	jComboBox2.setBounds(650, 350, 200, 50);
    	jLabel3.add(jComboBox2);
    	jButton1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				playersInformationUI ui=new playersInformationUI();
				ui.playerInformationUI();
				jFrame.dispose();
			}
		});
    	jButton2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				playersBeforeFiftyUI ui=new playersBeforeFiftyUI();
				ui.playersBeforeFiftyUI();
				jFrame.dispose();
			}
		});
    }
    public static void main(String[]args){
    	playersCheckUI ui=new playersCheckUI();
    	ui.playersCheckUI();
    }
}
