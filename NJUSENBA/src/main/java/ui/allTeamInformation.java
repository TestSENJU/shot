package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import vo.TeamStrVO;
import logic.TeamBL;
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
	DefaultTableModel table;
    @SuppressWarnings({ "rawtypes", "unchecked" })
	JComboBox jComboBox=new JComboBox(select);
    JScrollPane jScrollPane;
    private String[] title=new String[]{"球队名称","比赛场数","投篮命中数","投篮出手次数","三分命中次数","三分出手数","罚球命中数","罚球出手数","进攻篮板数","防守篮板数",
			 "篮板数","助攻数","抢断数","盖帽数","失误数","犯规数","比赛得分","投篮命中率","三分命中率","罚球命中率","胜率","进攻回合",
			 "进攻效率","防守效率","进攻篮板效率","防守篮板效率","抢断效率","助攻率"};

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
    	
    	table=new DefaultTableModel(null,title);
     	jTable=new JTable(table);  	
    	jTable.setBounds(2, 82,1196,618);
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
      setListener();
    }
    public void setListener(){
    	  jLabel2.addMouseListener(new MouseAdapter() {
  			public void mouseClicked(MouseEvent arg0) {
  				// TODO Auto-generated method stub
  				jFrame.dispose();
  				selectTeamUI ui=new selectTeamUI();
  				ui.open();
  			}
  		});
      	 jLabel3.addMouseListener(new MouseAdapter() {
  			public void mouseClicked(MouseEvent arg0) {
  				// TODO Auto-generated method stub
  				jFrame.dispose();
  			}
  		});
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
						while(table.getRowCount()>0){      
							table.removeRow(table.getRowCount()-1);
							}
					 TeamService data = new TeamBL();
					 ArrayList<TeamStrVO> data1 =new ArrayList<TeamStrVO>();
					 data1=data.allTeamStr();
					 for(int i=0;i<30;i++){
						 String playerData[]=new String[28];
					     playerData[0]=data1.get(i).getName();
						 playerData[1]=data1.get(i).getMatchSum();
						 playerData[2]=data1.get(i).getHitSum();
						 playerData[3]=data1.get(i).getShootSum();
						 playerData[4]=data1.get(i).getThreePointHitSum();
						 playerData[5]=data1.get(i).getThreePointSum();
						 playerData[6]=data1.get(i).getFreeThrowHitSum();
						 playerData[7]=data1.get(i).getFreeThrowSum();
						 playerData[8]=data1.get(i).getOffensiveReboundSum();
						 playerData[9]=data1.get(i).getDefensiveReboundSum();
						 playerData[10]=data1.get(i).getReboundSum();
						 playerData[11]=data1.get(i).getAssistingSum();
						 playerData[12]=data1.get(i).getStealSum();
						 playerData[13]=data1.get(i).getBlockShotSum();
						 playerData[14]=data1.get(i).getMuffSum();
						 playerData[15]=data1.get(i).getFoulSum();
						 playerData[16]=data1.get(i).getScore();
						 playerData[17]=data1.get(i).getHitRate();
						 playerData[18]=data1.get(i).getThreePointHitRate();
						 playerData[19]=data1.get(i).getFreeThrowHitRate();
						 playerData[20]=data1.get(i).getWinRate();
						 playerData[21]=data1.get(i).getOffensiveRound();
						 playerData[22]=data1.get(i).getOffensiveEfficiency();
						 playerData[23]=data1.get(i).getDefensiveEfficiency();
						 playerData[24]=data1.get(i).getOffensiveReboundRate();
						 playerData[25]=data1.get(i).getDefensiveReboundRate();
						 playerData[26]=data1.get(i).getStealRate();
						 playerData[27]=data1.get(i).getAssistingRate();
						 table.addRow(playerData);
					 }
					}
					 ;break;
					case 2:{
						while(table.getRowCount()>0){      
							table.removeRow(table.getRowCount()-1); }
						TeamService data2=new TeamBL();
						ArrayList<TeamStrVO> data3=new ArrayList<TeamStrVO>();
						data3=data2.allTeamAverStr();
						for(int i=0;i<30;i++){
							String playerData[]=new String[28];
						     playerData[0]=data3.get(i).getName();
							 playerData[1]=data3.get(i).getMatchSum();
							 playerData[2]=data3.get(i).getHitSum();
							 playerData[3]=data3.get(i).getShootSum();
							 playerData[4]=data3.get(i).getThreePointHitSum();
							 playerData[5]=data3.get(i).getThreePointSum();
							 playerData[6]=data3.get(i).getFreeThrowHitSum();
							 playerData[7]=data3.get(i).getFreeThrowSum();
							 playerData[8]=data3.get(i).getOffensiveReboundSum();
							 playerData[9]=data3.get(i).getDefensiveReboundSum();
							 playerData[10]=data3.get(i).getReboundSum();
							 playerData[11]=data3.get(i).getAssistingSum();
							 playerData[12]=data3.get(i).getStealSum();
							 playerData[13]=data3.get(i).getBlockShotSum();
							 playerData[14]=data3.get(i).getMuffSum();
							 playerData[15]=data3.get(i).getFoulSum();
							 playerData[16]=data3.get(i).getScore();
							 playerData[17]=data3.get(i).getHitRate();
							 playerData[18]=data3.get(i).getThreePointHitRate();
							 playerData[19]=data3.get(i).getFreeThrowHitRate();
							 playerData[20]=data3.get(i).getWinRate();
							 playerData[21]=data3.get(i).getOffensiveRound();
							 playerData[22]=data3.get(i).getOffensiveEfficiency();
							 playerData[23]=data3.get(i).getDefensiveEfficiency();
							 playerData[24]=data3.get(i).getOffensiveReboundRate();
							 playerData[25]=data3.get(i).getDefensiveReboundRate();
							 playerData[26]=data3.get(i).getStealRate();
							 playerData[27]=data3.get(i).getAssistingRate();
							 table.addRow(playerData);
						 }
					};break;
					}
				}
			}
		});
    }
}
