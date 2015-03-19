package ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.WindowConstants;

public class teamInformationUI {
	JFrame jFrame=new JFrame("球队信息");
	JLabel jLabel1=new JLabel("选择查看赛季总数据或场均数据：");
	String[] select={"赛季总数据","赛季场均数据"};
    JComboBox jComboBox=new JComboBox(select);
    JLabel jLabel2=new JLabel("teamInformationBackgound");
    ImageIcon teamInformationBackgound=new ImageIcon("C://nba/picture/backgroundSAC.jpg");
    JLabel jLabel3=new JLabel("back");
    ImageIcon back=new ImageIcon("C://nba/picture/backgroundSACBack.jpg");
    public void teamInformationUI(){
    	jFrame.setVisible(true);
    	jFrame.setSize(900, 600);
    	jFrame.setLayout(null);
    	jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    	jFrame.setLocationRelativeTo(null);
    	String[] columnNames={"球队名称","比赛场数","投篮命中数","投篮出手次数","三分命中数","三分出手数","罚球命中数","罚球出手数","进攻篮板数","防守篮板数","篮板数","助攻数","抢断数","盖帽数"};
    	String[][] data={{"球队名称","比赛场数","投篮命中数","投篮出手次数","三分命中数","三分出手数","罚球命中数","罚球出手数","进攻篮板数","防守篮板数","篮板数","助攻数","抢断数","盖帽数"},{"1","2","3","4","5","6","7","8","9","10","11","12","13","14"},{"失误数","犯规数","比赛得分","投篮命中率","三分命中率","罚球命中率","胜率","进攻回合","进攻效率","防守效率","篮板效率","抢断效率","助攻率"," "}};
    	JTable jTable=new JTable(data,columnNames);
    	jLabel2.setBounds(0, 0, 900, 600);
    	jLabel2.setIcon(teamInformationBackgound);
    	jFrame.add(jLabel2);
    	jTable.setBounds(0, 100, 900, 100);
    	jLabel2.add(jTable);
    	jLabel1.setBounds(200, 20, 250, 80);
    	jLabel2.add(jLabel1);
    	jComboBox.setBounds(450, 30, 200, 50);
    	jComboBox.setName("赛季总数据");
    	jLabel2.add(jComboBox);
    	jLabel3.setBounds(0, 0, 60, 40);
    	jLabel3.setIcon(back);
    	jLabel2.add(jLabel3);
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
				selectTeamUI ui=new selectTeamUI();
				ui.selectTeamUI();
			}
		});
    }
}
