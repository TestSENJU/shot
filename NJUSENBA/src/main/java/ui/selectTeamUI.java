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
import javax.swing.WindowConstants;

public class selectTeamUI {
	JFrame jFrame=new JFrame("球队选择");
	JLabel jLabel1=new JLabel("请选择要查询的球队名称：");
	JLabel jLabel2=new JLabel("请选择升降序条件：");
	JLabel jLabel3=new JLabel("backgroundSAC");
	JLabel jLabel4=new JLabel("backgroundSACBack");
	JLabel jLabel5=new JLabel("backgroundSACSearch");
	JLabel jLabel6=new JLabel("backgroundSACCheck");
	ImageIcon backgroundSAC=new ImageIcon("C://nba/picture/backgroundSAC.jpg");
	ImageIcon backgroundSACBack=new ImageIcon("C://nba/picture/backgroundSACBack.jpg");
	ImageIcon backgroundSACSearch=new ImageIcon("C://nba/picture/backgroundSACSearch.jpg");
	ImageIcon backgroundSACCheck=new ImageIcon("C://nba/picture/backgroundSACCheck.jpg");
	String[] team={"马刺队","老鹰队","骑士队","猛龙","公牛队","奇才队","雄鹿队","步行者队","热火队","凯尔特人队","黄蜂队","篮网队","活塞队","魔术队","76人队","尼克斯队","勇士队","灰熊队","开拓者队","火箭队","快船队","小牛队","鹈鹕队","雷霆队","太阳队","爵士队","掘金队","国王队","湖人队","森林狼队"};
	String[] condition={"比赛场数","投篮命中数","投篮出手次数","三分命中数","三分出手数","罚球命中数","罚球出手数","进攻篮板数","防守篮板数","篮板数","助攻数","抢断数","盖帽数","失误数","犯规数","比赛得分","投篮命中率","三分命中率","罚球命中率","胜率","进攻回合","进攻效率","防守效率","篮板效率","抢断效率","助攻率"};
	@SuppressWarnings("rawtypes")
	JComboBox jComboBox1=new JComboBox(team);
	@SuppressWarnings("rawtypes")
	JComboBox jComboBox2=new JComboBox(condition);
	public void selectTeamUI(){
		jFrame.setVisible(true);
    	jFrame.setSize(900, 600);
    	jFrame.setLayout(null);
    	jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    	jFrame.setLocationRelativeTo(null);
    	jLabel1.setBounds(50, 100, 150, 50);
    	jLabel3.add(jLabel1);
    	jLabel2.setBounds(50, 200, 150, 50);
    	jLabel3.add(jLabel2);
    	jLabel3.setBounds(0, 0, 900, 600);
    	jLabel3.setIcon(backgroundSAC);
    	jLabel4.setIcon(backgroundSACBack);
    	jLabel5.setIcon(backgroundSACSearch);
    	jLabel6.setIcon(backgroundSACCheck);
    	jLabel4.setBounds(0, 0, 60, 40);
    	jLabel3.add(jLabel4);
    	jFrame.add(jLabel3);
    	jLabel5.setBounds(550, 100, 200, 50);
    	jLabel3.add(jLabel5);
    	jLabel6.setBounds(550, 200, 200, 50);
    	jLabel3.add(jLabel6);
    	jComboBox1.setBounds(200, 100, 200, 50);
    	jLabel3.add(jComboBox1);
    	jComboBox2.setBounds(200, 200, 200, 50);
    	jLabel3.add(jComboBox2);
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
				teamInformationUI ui=new teamInformationUI();
				ui.teamInformationUI();
				jFrame.dispose();
			}
		});
    	jLabel6.addMouseListener(new MouseListener() {
			
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
				teamSortUI ui=new teamSortUI();
				ui.teamSortUI();
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
				selectTorPUI ui=new selectTorPUI();
				ui.drawSelectTorPUI();
			}
		});
	}
}
