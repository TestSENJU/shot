package ui;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class teamInformationUI {
	JFrame jFrame=new JFrame("球队信息");
	JLabel jLabel1=new JLabel("background");
	JLabel jLabel2=new JLabel("back");
	JLabel jLabel3=new JLabel(" ");
	String[] select={" ","赛季总数据","赛季场均数据"};
    JComboBox jComboBox=new JComboBox(select);
    ImageIcon background=new ImageIcon("C://nba/picture/teamBackground2.jpg");
    ImageIcon back=new ImageIcon("C://nba/picture/teamBackground1Back.jpg");
    ImageIcon exit=new ImageIcon("C://nba/picture/teamBackground1Exit.jpg");
    ImageIcon team;
    JTextField jTextField;
    String selectData=(String)jComboBox.getSelectedItem();
    public String[] getTeamData(){
    	String[] teamData = null;
    	if(selectData.equals("赛季总数据")){
    		return teamData;
    	}
    	if(selectData.equals("赛季平均数据")){
    		return teamData;
    	}
    	else 
    		return null;
    }
    public void teamInformationUI(String[] teamData){
    	jFrame.setUndecorated(true);
    	jFrame.setVisible(true);
    	jFrame.setSize(1200, 700);
    	jFrame.setLayout(null);
    	jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    	jFrame.setLocationRelativeTo(null);
    	String[] columnNames={"比赛场数","投篮命中数","投篮出手次数","三分命中数","三分出手数","罚球命中数","罚球出手数","进攻篮板数","防守篮板数","篮板数","助攻数","抢断数","盖帽数"};
    	String[][] data={{"比赛场数","投篮命中数","投篮出手次数","三分命中数","三分出手数","罚球命中数","罚球出手数","进攻篮板数","防守篮板数","篮板数","助攻数","抢断数","盖帽数"},{teamData[1] ,teamData[2],teamData[3],teamData[4],teamData[5],teamData[6],teamData[7],teamData[8],teamData[9],teamData[10],teamData[11],teamData[12],teamData[13]},{"失误数","犯规数","比赛得分","投篮命中率","三分命中率","罚球命中率","胜率","进攻回合","进攻效率","防守效率","篮板效率","抢断效率","助攻率"},{teamData[14],teamData[15],teamData[16],teamData[17],teamData[18],teamData[19],teamData[20],teamData[21],teamData[22],teamData[23],teamData[24],teamData[25],teamData[26]}};
    	JTable jTable=new JTable(data,columnNames);
    	jLabel1.setBounds(0, 0, 1200, 700);
    	jLabel1.setIcon(background);
    	jFrame.add(jLabel1);
    	jTable.setBounds(0, 550, 1200, 65);
    	jLabel1.add(jTable);
    	jLabel2.setBounds(0, 0, 70, 40);
    	jLabel2.setIcon(back);
    	jLabel1.add(jLabel2);
    	jComboBox.setBounds(400, 390, 200, 50);
    	jLabel1.add(jComboBox);
    	jLabel3.setBounds(1120, 0, 80, 80);
    	jLabel3.setIcon(exit);
    	jLabel1.add(jLabel3);
    	selectTeamUI selectTeamUI=new selectTeamUI();
    	String[] teamString=selectTeamUI.selectTeamUI();
    	String team=teamString[0];
    	String[] teamName={"马刺队","老鹰队","骑士队","猛龙","公牛队","奇才队","雄鹿队","步行者队","热火队","凯尔特人队","黄蜂队","篮网队","活塞队","魔术队","76人队","尼克斯队","勇士队","灰熊队","开拓者队","火箭队","快船队","小牛队","鹈鹕队","雷霆队","太阳队","爵士队","掘金队","国王队","湖人队","森林狼队"};
    	String[] teamName2={"SAS","ATL","CLE","TOR","CHI","WAS","MIL","IND","MIA","BOS","CHA","BKN","DET","ORL","PHI","NYK","GSW","MEM","POR","HOU","LAC","DAL","NOP","OKC","PHX","UTA","DEN","SAC","LAL","MIN"};
    	jTextField.setBounds(650, 300, 150, 50);
    	jTextField.setOpaque(false);
    	for(int i=0;i<30;i++){
    		if(team.equals(teamName[i])){
    			jTextField=new JTextField(teamName[i]);
    			jTextField.setFont(new Font("宋体", Font.BOLD, 30));
    			team=new ImageIcon();
    		}
    	}
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
