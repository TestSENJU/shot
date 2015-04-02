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

import vo.PlayerStrVO;
import logic.PlayerBL;
import logic.PlayerService;

public class allPlayersInformation {
	 JFrame jFrame=new JFrame("所有球员信息");
	 String[] data={" ","赛季总数据","赛季平均数据"};
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	JComboBox jComboBox=new JComboBox(data);
	 DefaultTableModel table;
	 JTable jTable;
	 JScrollPane jsp;

	 JLabel jLabel1=new JLabel();
	 JLabel jLabel2=new JLabel();
	 JLabel jLabel3=new JLabel();
	 ImageIcon background=new ImageIcon("img/picture/playerBackground.jpg");
	 ImageIcon back=new ImageIcon("img/picture/playerBackground1Back.jpg");
	 ImageIcon exit=new ImageIcon("img/picture/playerBackground1Exit.jpg");
	 private String[] title=new String[]{"球员名称","所属球队","参赛场数","先发场数","篮板数","助攻数","在场时间","投篮命中率","三分命中率","罚球命中率",
			 "进攻篮板数","防守篮板数","抢断数","盖帽数","失误数","犯规数","得分","效率","GmSc效率值"," 真实命中率","投篮效率","篮板率",
			 "进攻篮板率","防守篮板率","助攻率","抢断率","盖帽率","失误率","使用率"};

	public void allPlayersInformationUI(){
		
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
		jsp=new JScrollPane(jTable);   	
        jLabel1.add(jsp);
    	jsp.setBounds(0, 80, 1200, 600);
    	jLabel2.setIcon(back);
    	jLabel3.setIcon(exit);
    	jLabel2.setBounds(0, 0, 50, 35);
    	jLabel1.add(jLabel2);
    	jLabel3.setBounds(1120, 0, 80, 80);
    	jLabel1.add(jLabel3);
    	jLabel1.setVisible(true);
    	setListener();    	
	}
//	public static void main(String[]args){
//		allPlayersInformation ui=new allPlayersInformation();
//		ui.allPlayersInformationUI();
//	}
	public void setListener(){
jLabel2.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				jFrame.dispose();
				playersCheckUI ui=new playersCheckUI();
				ui.playersCheck();
			}
		});
    	jLabel3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
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
					case 1:{
						//TODO
						while(table.getRowCount()>0){      
							table.removeRow(table.getRowCount()-1); }
						PlayerService data1=new PlayerBL();
						ArrayList<PlayerStrVO> data2=new ArrayList<PlayerStrVO>();
						data2=data1.playerAll();
						for(int i=0;i<data2.size();i++){
							String[] playerData=new String[29];
							playerData[0]=data2.get(i).getName();
							playerData[1]=data2.get(i).getTeams();
							playerData[2]=data2.get(i).getCompeteNum();
							playerData[3]=data2.get(i).getOffensiveNum();
							playerData[4]=data2.get(i).getReboundNum();
							playerData[5]=data2.get(i).getAssistingNum();
							playerData[6]=data2.get(i).getPlayingTime();
							playerData[7]=data2.get(i).getHitRate();
							playerData[8]=data2.get(i).getThreePointHitRate();
							playerData[9]=data2.get(i).getFreeThrowHitRate();
							playerData[10]=data2.get(i).getOffensiveReboundNum();
							playerData[11]=data2.get(i).getDefensiveReboundNum();
							playerData[12]=data2.get(i).getStealNum();
							playerData[13]=data2.get(i).getBlockShotNum();
							playerData[14]=data2.get(i).getMuffNum();
							playerData[15]=data2.get(i).getFoulNum();
							playerData[16]=data2.get(i).getScore();
							playerData[17]=data2.get(i).getEfficiency();
							playerData[18]=data2.get(i).getGmScEfficiency();
							playerData[19]=data2.get(i).getTrueHitRate();
							playerData[20]=data2.get(i).getShootEfficiency();
							playerData[21]=data2.get(i).getReboundRate();
							playerData[22]=data2.get(i).getOffensiveReboundRate();
							playerData[23]=data2.get(i).getDefensiveReboundRate();
							playerData[24]=data2.get(i).getAssistingRate();
							playerData[25]=data2.get(i).getStealRate();
							playerData[26]=data2.get(i).getBlockShotRate();
							playerData[27]=data2.get(i).getMuffRate();
							playerData[28]=data2.get(i).getUsage();
						table.addRow(playerData);
						}
					
					break;
					}
					case 2:{
						while(table.getRowCount()>0){      
							table.removeRow(table.getRowCount()-1); }
						PlayerService data3=new PlayerBL();
						ArrayList<PlayerStrVO> data4=new ArrayList<PlayerStrVO>();
						data4=data3.playerAverage();
						for(int i=0;i<448;i++){
							String playerData[]=new String[29];
							playerData[0]=data4.get(i).getName();
							playerData[1]=data4.get(i).getTeams();
							playerData[2]=data4.get(i).getCompeteNum();
							playerData[3]=data4.get(i).getOffensiveNum();
							playerData[4]=data4.get(i).getReboundNum();
							playerData[5]=data4.get(i).getAssistingNum();
							playerData[6]=data4.get(i).getPlayingTime();
							playerData[7]=data4.get(i).getHitRate();
							playerData[8]=data4.get(i).getThreePointHitRate();
							playerData[9]=data4.get(i).getFreeThrowHitRate();
							playerData[10]=data4.get(i).getOffensiveReboundNum();
							playerData[11]=data4.get(i).getDefensiveReboundNum();
							playerData[12]=data4.get(i).getStealNum();
							playerData[13]=data4.get(i).getBlockShotNum();
							playerData[14]=data4.get(i).getMuffNum();
							playerData[15]=data4.get(i).getFoulNum();
							playerData[16]=data4.get(i).getScore();
							playerData[17]=data4.get(i).getEfficiency();
							playerData[18]=data4.get(i).getGmScEfficiency();
							playerData[19]=data4.get(i).getTrueHitRate();
							playerData[20]=data4.get(i).getShootEfficiency();
							playerData[21]=data4.get(i).getReboundRate();
							playerData[22]=data4.get(i).getOffensiveReboundRate();
							playerData[23]=data4.get(i).getDefensiveReboundRate();
							playerData[24]=data4.get(i).getAssistingRate();
							playerData[25]=data4.get(i).getStealRate();
							playerData[26]=data4.get(i).getBlockShotRate();
							playerData[27]=data4.get(i).getMuffRate();
							playerData[28]=data4.get(i).getUsage();
							table.addRow(playerData);
						}
					;break;
					}
				}
			}
		}
		});
	}
}
