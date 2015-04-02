package ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import vo.TeamStrVO;
import logic.TeamBL;
import logic.TeamService;

public class selectTeamUI {
	JFrame jFrame=new JFrame("球队选择");
	JLabel jLabel1=new JLabel("background");
	JLabel jLabel2=new JLabel("inquiry");
	JLabel jLabel3=new JLabel("check");
	JLabel jLabel4=new JLabel("back");
	JLabel jLabel5=new JLabel(" ");
	JLabel jLabel6=new JLabel();
	ImageIcon background=new ImageIcon("img/picture/teamBackground1.jpg");
	ImageIcon inquiry=new ImageIcon("img/picture/inquiry.jpg");
	ImageIcon check=new ImageIcon("img/picture/check.jpg");
	ImageIcon back=new ImageIcon("img/picture/teamBackground1Back.jpg");
	ImageIcon exit=new ImageIcon("img/picture/teamBackground1Exit.jpg");
	ImageIcon allTeam=new ImageIcon("img/picture/allTeamInformation.jpg");
	String[] team={" ","马刺队","老鹰队","骑士队","猛龙","公牛队","奇才队","雄鹿队","步行者队","热火队","凯尔特人队","黄蜂队","篮网队","活塞队","魔术队","76人队","尼克斯队","勇士队","灰熊队","开拓者队","火箭队","快船队","小牛队","鹈鹕队","雷霆队","太阳队","爵士队","掘金队","国王队","湖人队","森林狼队"};
	String[] condition={" ","比赛场数","投篮命中数","投篮出手次数","三分命中数","三分出手数","罚球命中数","罚球出手数","进攻篮板数","防守篮板数","篮板数","助攻数","抢断数","盖帽数","失误数","犯规数","比赛得分","投篮命中率","三分命中率","罚球命中率","胜率","进攻回合","进攻效率","防守效率","进攻篮板效率","防守篮板效率","抢断效率","助攻率"};
	String[] teamClassify = {"赛季总数据","场均数据"};
	@SuppressWarnings({ "rawtypes", "unchecked" })
	JComboBox jComboBox1=new JComboBox(team);
	@SuppressWarnings({ "rawtypes", "unchecked" })
	JComboBox jComboBox2=new JComboBox(condition);
	@SuppressWarnings({ "rawtypes", "unchecked" })
	JComboBox jComboBoxTeamClassify = new JComboBox(teamClassify);
	public int getSelect(){
		int key = -1;
		String condition=(String)jComboBox2.getSelectedItem();
		if (condition.equals(" ")) {
			key = 0;
		} else if (condition.equals("比赛场数")) {
			key = 1;
		} else if (condition.equals("投篮命中数")) {
			key = 2;
		} else if (condition.equals("投篮出手次数")) {
			key = 3;
		} else if (condition.equals("三分命中数")) {
			key = 4;
		} else if (condition.equals("三分出手数")) {
			key = 5;
		} else if (condition.equals("罚球命中数")) {
			key = 6;
		} else if (condition.equals("罚球出手数")) {
			key = 7;
		} else if (condition.equals("进攻篮板数")) {
			key = 8;
		} else if (condition.equals("防守篮板数")) {
			key = 9;
		} else if (condition.equals("篮板数")) {
			key = 10;
		} else if (condition.equals("助攻数")) {
			key = 11;
		} else if (condition.equals("抢断数")) {
			key = 12;
		} else if (condition.equals("盖帽数")) {
			key = 13;
		} else if (condition.equals("失误数")) {
			key = 14;
		} else if (condition.equals("犯规数")) {
			key = 15;
		} else if (condition.equals("比赛得分")) {
			key = 16;
		} else if (condition.equals("投篮命中率")) {
			key = 17;
		} else if (condition.equals("三分命中率")) {
			key = 18;
		} else if (condition.equals("罚球命中率")) {
			key = 19;
		} else if (condition.equals("胜率")) {
			key = 20;
		} else if (condition.equals("进攻回合")) {
			key = 21;
		} else if (condition.equals("进攻效率")) {
			key = 22;
		} else if (condition.equals("防守效率")) {
			key = 23;
		} else if (condition.equals("进攻篮板效率")) {
			key = 24;
		} else if (condition.equals("防守篮板效率")) {
			key = 25;
		} else if (condition.equals("抢断效率")) {
			key = 26;
			//"进攻效率","防守效率","篮板效率","抢断效率","助攻率"
		} else if (condition.equals("助攻率")) {
			key = 27;
		} else {
			System.out.println("invalid condition.");
		}
		return key;
	}
	public String[] getData(){
		int key = getSelect();
		TeamService ts=new TeamBL();
		ArrayList<TeamStrVO> datateam=new ArrayList<TeamStrVO>();
		datateam = ts.allTeamStr();
		String[] dataName = new String[datateam.size()];
		ArrayList<TeamStrVO> Reteam=new ArrayList<TeamStrVO>();
		Reteam = ts.ascendTeamStr(key, datateam);
		for (int i=0;i < datateam.size();i++){
			dataName[i] = Reteam.get(i).getName();
		}
		return dataName;
	}
	public void selectTeam(){
		jFrame.setUndecorated(true);
		jFrame.setVisible(true);
    	jFrame.setSize(1200, 700);
    	jFrame.setLayout(null);
    	jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    	jFrame.setLocationRelativeTo(null);
    	jLabel1.setBounds(0, 0, 1200, 700);
    	jLabel1.setIcon(background);
    	jLabel2.setIcon(inquiry);
    	jLabel3.setIcon(check);
    	jLabel4.setIcon(back);
    	jLabel5.setIcon(exit);
    	jLabel1.add(jLabel4);
    	jFrame.add(jLabel1);
    	jLabel2.setBounds(885, 150, 150, 60);
    	jLabel1.add(jLabel2);
    	jLabel3.setBounds(900, 420, 150, 60);
    	jLabel1.add(jLabel3);
    	jLabel4.setBounds(0,0,70,40);
    	jLabel1.add(jLabel4);
    	jLabel5.setBounds(1120, 0, 80, 80);
    	jLabel1.add(jLabel5);
    	jComboBox1.setBounds(450, 150, 200, 50);
    	jLabel1.add(jComboBox1);
    	jComboBox2.setBounds(450, 420, 200, 50);
    	jLabel1.add(jComboBox2);
    	jComboBoxTeamClassify.setBounds(450, 500, 200, 50);
    	jLabel1.add(jComboBoxTeamClassify);
    	jLabel6.setBounds(20, 550, 450, 50);
    	jLabel6.setIcon(allTeam);
    	jLabel1.add(jLabel6);
    	jLabel2.addMouseListener(new MouseListener() {
			
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
				ui.teamInformation();
				jFrame.dispose();
			}
		});
    	jLabel3.addMouseListener(new MouseListener() {
			
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
				jFrame.dispose();
				teamSortUI ui=new teamSortUI();
				ui.teamSort();

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
    	jLabel5.addMouseListener(new MouseListener() {
			
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
    	jLabel6.addMouseListener(new MouseListener() {
			
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
				allTeamInformation ui=new allTeamInformation();
				ui.allTeamInformationUI();
			}
		});
	}
}
