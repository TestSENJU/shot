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

import vo.PlayerStrVO;
import logic.PlayerService;

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
    	final String[][] playerData = null;
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
						PlayerService data1=null;
						ArrayList<PlayerStrVO> data2=new ArrayList<PlayerStrVO>();
						data2=data1.playerAll();
						for(int i=0;i<448;i++){
							playerData[i][0]=data2.get(0).getName();
						}
						for(int i=0;i<448;i++){
							playerData[i][1]=data2.get(1).getTeams();
						}
						for(int i=0;i<448;i++){
							playerData[i][2]=data2.get(2).getCompeteNum();
						}
						for(int i=0;i<448;i++){
							playerData[i][3]=data2.get(3).getOffensiveNum();
						}
						for(int i=0;i<448;i++){
							playerData[i][4]=data2.get(4).getReboundNum();
						}
						for(int i=0;i<448;i++){
							playerData[i][5]=data2.get(5).getAssistingNum();
						}
						for(int i=0;i<448;i++){
							playerData[i][6]=data2.get(6).getPlayingTime();
						}
						for(int i=0;i<448;i++){
							playerData[i][7]=data2.get(7).getHitRate();
						}
						for(int i=0;i<448;i++){
							playerData[i][8]=data2.get(8).getThreePointHitRate();
						}
						for(int i=0;i<448;i++){
							playerData[i][9]=data2.get(9).getFreeThrowHitRate();
						}
						for(int i=0;i<448;i++){
							playerData[i][10]=data2.get(10).getOffensiveReboundNum();
						}
						for(int i=0;i<448;i++){
							playerData[i][11]=data2.get(11).getDefensiveReboundNum();
						}
						for(int i=0;i<448;i++){
							playerData[i][12]=data2.get(12).getStealNum();
						}
						for(int i=0;i<448;i++){
							playerData[i][13]=data2.get(13).getBlockShotNum();
						}
						for(int i=0;i<448;i++){
							playerData[i][14]=data2.get(14).getMuffNum();
						}
						for(int i=0;i<448;i++){
							playerData[i][15]=data2.get(15).getFoulNum();
						}
						for(int i=0;i<448;i++){
							playerData[i][16]=data2.get(16).getScore();
						}
						for(int i=0;i<448;i++){
							playerData[i][17]=data2.get(17).getEfficiency();
						}
						for(int i=0;i<448;i++){
							playerData[i][18]=data2.get(18).getGmScEfficiency();
						}
						for(int i=0;i<448;i++){
							playerData[i][19]=data2.get(19).getTrueHitRate();
						}
						for(int i=0;i<448;i++){
							playerData[i][20]=data2.get(20).getShootEfficiency();
						}
						for(int i=0;i<448;i++){
							playerData[i][21]=data2.get(21).getReboundRate();
						}
						for(int i=0;i<448;i++){
							playerData[i][22]=data2.get(22).getOffensiveReboundRate();
						}
						for(int i=0;i<448;i++){
							playerData[i][23]=data2.get(23).getDefensiveReboundRate();
						}
						for(int i=0;i<448;i++){
							playerData[i][24]=data2.get(24).getAssistingRate();
						}
						for(int i=0;i<448;i++){
							playerData[i][25]=data2.get(25).getStealRate();
						}
						for(int i=0;i<448;i++){
							playerData[i][26]=data2.get(26).getBlockShotRate();
						}
						for(int i=0;i<448;i++){
							playerData[i][27]=data2.get(27).getMuffRate();
						}
						for(int i=0;i<448;i++){
							playerData[i][28]=data2.get(28).getUsage();
						}
					;break;
					}
					case 2:{
						PlayerService data3=null;
						ArrayList<PlayerStrVO> data4=new ArrayList<PlayerStrVO>();
						data4=data3.playerAverage();
						for(int i=0;i<448;i++){
							playerData[i][0]=data4.get(0).getName();
						}
						for(int i=0;i<448;i++){
							playerData[i][1]=data4.get(1).getTeams();
						}
						for(int i=0;i<448;i++){
							playerData[i][2]=data4.get(2).getCompeteNum();
						}
						for(int i=0;i<448;i++){
							playerData[i][3]=data4.get(3).getOffensiveNum();
						}
						for(int i=0;i<448;i++){
							playerData[i][4]=data4.get(4).getReboundNum();
						}
						for(int i=0;i<448;i++){
							playerData[i][5]=data4.get(5).getAssistingNum();
						}
						for(int i=0;i<448;i++){
							playerData[i][6]=data4.get(6).getPlayingTime();
						}
						for(int i=0;i<448;i++){
							playerData[i][7]=data4.get(7).getHitRate();
						}
						for(int i=0;i<448;i++){
							playerData[i][8]=data4.get(8).getThreePointHitRate();
						}
						for(int i=0;i<448;i++){
							playerData[i][9]=data4.get(9).getFreeThrowHitRate();
						}
						for(int i=0;i<448;i++){
							playerData[i][10]=data4.get(10).getOffensiveReboundNum();
						}
						for(int i=0;i<448;i++){
							playerData[i][11]=data4.get(11).getDefensiveReboundNum();
						}
						for(int i=0;i<448;i++){
							playerData[i][12]=data4.get(12).getStealNum();
						}
						for(int i=0;i<448;i++){
							playerData[i][13]=data4.get(13).getBlockShotNum();
						}
						for(int i=0;i<448;i++){
							playerData[i][14]=data4.get(14).getMuffNum();
						}
						for(int i=0;i<448;i++){
							playerData[i][15]=data4.get(15).getFoulNum();
						}
						for(int i=0;i<448;i++){
							playerData[i][16]=data4.get(16).getScore();
						}
						for(int i=0;i<448;i++){
							playerData[i][17]=data4.get(17).getEfficiency();
						}
						for(int i=0;i<448;i++){
							playerData[i][18]=data4.get(18).getGmScEfficiency();
						}
						for(int i=0;i<448;i++){
							playerData[i][19]=data4.get(19).getTrueHitRate();
						}
						for(int i=0;i<448;i++){
							playerData[i][20]=data4.get(20).getShootEfficiency();
						}
						for(int i=0;i<448;i++){
							playerData[i][21]=data4.get(21).getReboundRate();
						}
						for(int i=0;i<448;i++){
							playerData[i][22]=data4.get(22).getOffensiveReboundRate();
						}
						for(int i=0;i<448;i++){
							playerData[i][23]=data4.get(23).getDefensiveReboundRate();
						}
						for(int i=0;i<448;i++){
							playerData[i][24]=data4.get(24).getAssistingRate();
						}
						for(int i=0;i<448;i++){
							playerData[i][25]=data4.get(25).getStealRate();
						}
						for(int i=0;i<448;i++){
							playerData[i][26]=data4.get(26).getBlockShotRate();
						}
						for(int i=0;i<448;i++){
							playerData[i][27]=data4.get(27).getMuffRate();
						}
						for(int i=0;i<448;i++){
							playerData[i][28]=data4.get(28).getUsage();
						}
					;break;
					}
				}
			}
		}
		});
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
