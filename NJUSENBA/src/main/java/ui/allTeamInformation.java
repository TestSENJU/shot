package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;

import org.omg.PortableServer.ForwardRequest;
import org.omg.PortableServer.ForwardRequestHelper;

import vo.TeamAverageVO;
import vo.TeamInfoVO;
import vo.TeamStrVO;
import vo.TeamVO;
import logic.TeamService;

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
    @SuppressWarnings({ "rawtypes", "unchecked" })
	JComboBox jComboBox=new JComboBox(select);
    JScrollPane jScrollPane;
    public void allTeamInformationUI(){
    	jFrame.setUndecorated(true);
    	jFrame.setSize(1200, 700);
    	jFrame.setLayout(null);
    	jFrame.setVisible(true);
    	jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    	jFrame.setLocationRelativeTo(null);
      	jLabel1.setBounds(0, 0, 1200, 700);
    	jLabel1.setIcon(background);
    	jFrame.add(jLabel1);
    	jComboBox.setBounds(800, 10, 200, 50);
    	jLabel1.add(jComboBox);
    	final String[][] playerData=null;
    	jComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==jComboBox){
					int index=jComboBox.getSelectedIndex();
					switch(index){
					case 0:  
					         break;
					case 1: {
					 TeamService data = null;
					 ArrayList<TeamStrVO> data1 =new ArrayList<TeamStrVO>();
					 data1=data.allTeamStr();
					 for(int i=0;i<30;i++){
					     playerData[i][0]=data1.get(0).getName();
					 }
					 for(int i=0;i<30;i++){
						 playerData[i][1]=data1.get(1).getMatchSum();
					 }
					 for(int i=0;i<30;i++){
						 playerData[i][2]=data1.get(2).getHitSum();
					 }
					 for(int i=0;i<30;i++){
						 playerData[i][3]=data1.get(3).getShootSum();
					 }
					 for(int i=0;i<30;i++){
						 playerData[i][4]=data1.get(4).getThreePointHitSum();
					 }
					 for(int i=0;i<30;i++){
						 playerData[i][5]=data1.get(5).getThreePointSum();
					 }
					 for(int i=0;i<30;i++){
						 playerData[i][6]=data1.get(6).getFreeThrowHitSum();
					 }
					 for(int i=0;i<30;i++){
						 playerData[i][7]=data1.get(7).getFreeThrowSum();
					 }
					 for(int i=0;i<30;i++){
						 playerData[i][8]=data1.get(8).getOffensiveReboundSum();
					 }
					 for(int i=0;i<30;i++){
						 playerData[i][9]=data1.get(9).getDefensiveReboundSum();
					 }
					 for(int i=0;i<30;i++){
						 playerData[i][10]=data1.get(10).getReboundSum();
					 }
					 for(int i=0;i<30;i++){
						 playerData[i][11]=data1.get(11).getAssistingSum();
					 }
					 for(int i=0;i<30;i++){
						 playerData[i][12]=data1.get(12).getStealSum();
					 }
					 for(int i=0;i<30;i++){
						 playerData[i][13]=data1.get(13).getBlockShotSum();
					 }
					 for(int i=0;i<30;i++){
						 playerData[i][14]=data1.get(14).getMuffSum();
					 }
					 for(int i=0;i<30;i++){
						 playerData[i][15]=data1.get(15).getFoulSum();
					 }
					 for(int i=0;i<30;i++){
						 playerData[i][16]=data1.get(16).getScore();
					 }
					 for(int i=0;i<30;i++){
						 playerData[i][17]=data1.get(17).getHitRate();
					 }
					 for(int i=0;i<30;i++){
						 playerData[i][18]=data1.get(18).getThreePointHitRate();
					 }
					 for(int i=0;i<30;i++){
						 playerData[i][19]=data1.get(19).getFreeThrowHitRate();
					 }
					 for(int i=0;i<30;i++){
						 playerData[i][20]=data1.get(20).getWinRate();
					 }
					 for(int i=0;i<30;i++){
						 playerData[i][21]=data1.get(21).getOffensiveRound();
					 }
					 for(int i=0;i<30;i++){
						 playerData[i][22]=data1.get(22).getOffensiveEfficiency();
					 }
					 for(int i=0;i<30;i++){
						 playerData[i][23]=data1.get(23).getDefensiveEfficiency();
					 }
					 for(int i=0;i<30;i++){
						 playerData[i][24]=data1.get(24).getOffensiveReboundRate();
					 }
					 for(int i=0;i<30;i++){
						 playerData[i][25]=data1.get(25).getDefensiveReboundRate();
					 }
					 for(int i=0;i<30;i++){
						 playerData[i][26]=data1.get(26).getStealRate();
					 }
					 for(int i=0;i<30;i++){
						 playerData[i][27]=data1.get(27).getAssistingRate();
					 }
					}
					 ;break;
					case 2:{
						TeamService data2=null;
						ArrayList<TeamStrVO> data3=new ArrayList<TeamStrVO>();
						data3=data2.allTeamAverStr();
						for(int i=0;i<30;i++){
						     playerData[i][0]=data3.get(0).getName();
						 }
						 for(int i=0;i<30;i++){
							 playerData[i][1]=data3.get(1).getMatchSum();
						 }
						 for(int i=0;i<30;i++){
							 playerData[i][2]=data3.get(2).getHitSum();
						 }
						 for(int i=0;i<30;i++){
							 playerData[i][3]=data3.get(3).getShootSum();
						 }
						 for(int i=0;i<30;i++){
							 playerData[i][4]=data3.get(4).getThreePointHitSum();
						 }
						 for(int i=0;i<30;i++){
							 playerData[i][5]=data3.get(5).getThreePointSum();
						 }
						 for(int i=0;i<30;i++){
							 playerData[i][6]=data3.get(6).getFreeThrowHitSum();
						 }
						 for(int i=0;i<30;i++){
							 playerData[i][7]=data3.get(7).getFreeThrowSum();
						 }
						 for(int i=0;i<30;i++){
							 playerData[i][8]=data3.get(8).getOffensiveReboundSum();
						 }
						 for(int i=0;i<30;i++){
							 playerData[i][9]=data3.get(9).getDefensiveReboundSum();
						 }
						 for(int i=0;i<30;i++){
							 playerData[i][10]=data3.get(10).getReboundSum();
						 }
						 for(int i=0;i<30;i++){
							 playerData[i][11]=data3.get(11).getAssistingSum();
						 }
						 for(int i=0;i<30;i++){
							 playerData[i][12]=data3.get(12).getStealSum();
						 }
						 for(int i=0;i<30;i++){
							 playerData[i][13]=data3.get(13).getBlockShotSum();
						 }
						 for(int i=0;i<30;i++){
							 playerData[i][14]=data3.get(14).getMuffSum();
						 }
						 for(int i=0;i<30;i++){
							 playerData[i][15]=data3.get(15).getFoulSum();
						 }
						 for(int i=0;i<30;i++){
							 playerData[i][16]=data3.get(16).getScore();
						 }
						 for(int i=0;i<30;i++){
							 playerData[i][17]=data3.get(17).getHitRate();
						 }
						 for(int i=0;i<30;i++){
							 playerData[i][18]=data3.get(18).getThreePointHitRate();
						 }
						 for(int i=0;i<30;i++){
							 playerData[i][19]=data3.get(19).getFreeThrowHitRate();
						 }
						 for(int i=0;i<30;i++){
							 playerData[i][20]=data3.get(20).getWinRate();
						 }
						 for(int i=0;i<30;i++){
							 playerData[i][21]=data3.get(21).getOffensiveRound();
						 }
						 for(int i=0;i<30;i++){
							 playerData[i][22]=data3.get(22).getOffensiveEfficiency();
						 }
						 for(int i=0;i<30;i++){
							 playerData[i][23]=data3.get(23).getDefensiveEfficiency();
						 }
						 for(int i=0;i<30;i++){
							 playerData[i][24]=data3.get(24).getOffensiveReboundRate();
						 }
						 for(int i=0;i<30;i++){
							 playerData[i][25]=data3.get(25).getDefensiveReboundRate();
						 }
						 for(int i=0;i<30;i++){
							 playerData[i][26]=data3.get(26).getStealRate();
						 }
						 for(int i=0;i<30;i++){
							 playerData[i][27]=data3.get(27).getAssistingRate();
						 }
					};break;
					}
				}
			}
		});
    	String[] columnName={"比赛场数","投篮命中数","投篮出手次数","三分命中数","三分出手数","罚球命中数","罚球出手数","进攻篮板数","防守篮板数","篮板数","助攻数","抢断数","盖帽数","失误数"};
    	jTable=new JTable(playerData,columnName);  	
    	jTable.setBounds(2, 82,1196,618);
    	jLabel1.add(jTable);
    	jScrollPane=new JScrollPane(jTable);
    	jLabel1.add(jScrollPane);
    	jScrollPane.setBounds(0, 80, 1200, 600);
    	jLabel2.setBounds(0, 0, 70, 40);
    	jLabel2.setIcon(back);
    	jLabel1.add(jLabel2);
    	jLabel3.setBounds(1120, 0, 80, 80);
    	jLabel3.setIcon(exit);
    	jLabel1.add(jLabel3);
    	jLabel1.setVisible(true);
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
				ui.selectTeam();
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
    public static void main(String[]args){
    	allTeamInformation ui=new allTeamInformation();
    	ui.allTeamInformationUI();
    }
}
