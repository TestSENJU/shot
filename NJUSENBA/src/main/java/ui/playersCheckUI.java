package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import vo.PlayerStrVO;
import logic.PlayerBL;
import logic.PlayerService;

public class playersCheckUI {
	JFrame jFrame;
	JLabel jLabel1;
	String[] position = { " ", "G", "F", "C" };
	String[] league = { " ", "E-Southeast", "E-Atlantic", "E-Central",
			"W-Southwest", "W-Atlantic", "W-Northwest", "W-Pacific" };
	String[] condition = { " ", "score", "rebound", "assisting", "S_R_A",
			"blockShot", "steal", "foul", "muff", "playTime", "efficiency",
			"shoot", "threePoint", "freeThrow", "D_D" };
	String[] sort = { "name", "competeNum", "offensiveNum",
			"reboundNum", "assistingNum", "playingTime", "hitRate",
			"threePointHitRate", "freeThrowHitRate", "offensiveReboundNum",
			"defensiveReboundNum", "stealNum", "blockShotNum", "muffNum",
			"foulNum", "score", "efficiency", "GmScEfficiency", "trueHitRate",
			"shootEfficiency", "reboundRate", "offensiveReboundRate",
			"defensiveReboundRate", "assistingRate", "stealRate",
			"blockShotRate", "muffRate", "usage" };
	String[] playerClassify = {"总赛季数据","场均数据"};
	String[] shengjiangxu={"升序","降序"};
	DefaultComboBoxModel<String> model1;
	DefaultComboBoxModel<String> model2;
	DefaultComboBoxModel<String> model3;
	DefaultComboBoxModel<String> model4;
	DefaultComboBoxModel<String> model5;
	DefaultComboBoxModel<String> model6;
	JComboBox<String> jComboBox1;
	JComboBox<String> jComboBox3;
	JComboBox<String> jComboBox2;
	JComboBox<String> jComboBoxSortCondition;
	JComboBox<String> jComboBoxClassify;
	JComboBox <String>jComboBoxAD;
	JLabel jLabel2 ;
	JLabel jLabel3;
	JLabel jLabel4;
	JLabel jLabel5;
	JLabel jLabel6;
	private String conditionSe;
	private String positionSe;
	private String leagueSe;
	private String sortSe;
	private String shengjiangSe;
	private int classify;
	ImageIcon background = new ImageIcon("img/picture/playerBackground1.jpg");
	ImageIcon back = new ImageIcon("img/picture/playerBackground1Back.jpg");
	ImageIcon exit = new ImageIcon("img/picture/playerBackground1Exit.jpg");
	ImageIcon search = new ImageIcon("img/picture/playerBackground1Check.jpg");
	ImageIcon check = new ImageIcon("img/picture/playerBackground1search.jpg");
	ImageIcon allCheck = new ImageIcon(
			"img/picture/playerBackground1AllCheck.jpg");
	public playersCheckUI(){
		 jFrame = new JFrame("球员数据查看");
		 jLabel1 = new JLabel("background");
		 jLabel2 = new JLabel("back");
		 jLabel3 = new JLabel(" ");
		 jLabel4 = new JLabel("search");
		 jLabel5 = new JLabel("check");
		 jLabel6 = new JLabel("allCheck");
		
		 model1=new DefaultComboBoxModel<String>(position);
		jComboBox1 = new JComboBox<String>(model1);
		jComboBox2 = new JComboBox<String>(league);
		jComboBox3 = new JComboBox<String>(condition);
		 jComboBoxSortCondition = new JComboBox<String>(sort);
		 jComboBoxClassify = new JComboBox<String>(playerClassify);
		 //TODO
		 jComboBoxAD=new JComboBox<String>(shengjiangxu);
	
			jFrame.setUndecorated(true);
			
			jFrame.setSize(1200, 700);
			jFrame.setLayout(null);
			jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			jFrame.setLocationRelativeTo(null);
			jLabel1.setIcon(background);
			jLabel2.setIcon(back);
			jLabel3.setIcon(exit);
			jLabel4.setIcon(search);
			jLabel5.setIcon(check);
			jComboBox1.setBounds(400, 220, 200, 50);
			jLabel1.add(jComboBox1);
			jComboBox2.setBounds(400, 330, 200, 50);
			jLabel1.add(jComboBox2);
			jComboBox3.setBounds(400, 430, 200, 50);
			jLabel1.add(jComboBox3);
			jComboBoxSortCondition.setBounds(500, 30, 200, 30);
			jLabel1.add(jComboBoxSortCondition);
			jComboBoxAD.setBounds(500, 100, 200, 30);
			jLabel1.add(jComboBoxAD);
			jComboBoxClassify.setBounds(500, 150, 200, 30);
			jLabel1.add(jComboBoxClassify);
			jLabel1.setBounds(0, 0, 1200, 700);
			jFrame.add(jLabel1);
			jLabel2.setBounds(0, 0, 50, 35);
			jLabel1.add(jLabel2);
			jLabel3.setBounds(1120, 0, 80, 80);
			jLabel1.add(jLabel3);
			jLabel4.setBounds(750, 100, 140, 60);
			jLabel1.add(jLabel4);
			jLabel5.setBounds(750, 320, 130, 60);
			jLabel1.add(jLabel5);
			jLabel6.setBounds(10, 580, 450, 50);
			jLabel6.setIcon(allCheck);
			jLabel1.add(jLabel6);
			jFrame.setVisible(false);
			setListener();
	}
public void open(){
	jFrame.setVisible(true);
}
	public void setListener(){
		jComboBoxAD.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				sortSe=(String)jComboBoxAD.getSelectedItem();
			}
			
		});
		jComboBoxSortCondition.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				shengjiangSe=(String)jComboBoxSortCondition.getSelectedItem();
			}
		});
		jComboBoxClassify.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				classify=jComboBoxClassify.getSelectedIndex();
			}
		});
		jLabel2.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				selectTorPUI ui=new selectTorPUI();
				ui.drawSelectTorPUI();
			}
		});
		jLabel4.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				jFrame.dispose();
							
				String[] playerNameData = getSortBy(classify);
				playersBeforeFiftyUI ui = new playersBeforeFiftyUI(playerNameData);
				ui.open();
			}
		});
		jLabel3.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				jFrame.dispose();
			}
		});
		jLabel5.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				jFrame.dispose();
				String selectCondition = positionSe + "," + leagueSe + "," + conditionSe;
							
				String[] playerNameData = getData(selectCondition);
				playersBeforeFiftyUI ui = new playersBeforeFiftyUI(playerNameData);
				ui.open();
			}
		});
		jLabel6.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				allPlayersInformation ui = new allPlayersInformation();
				ui.allPlayersInformationUI();
				jFrame.dispose();
			}
		});
		jComboBox1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				positionSe=(String)jComboBox1.getSelectedItem();
			}
			
		});
		jComboBox2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				leagueSe=(String)jComboBox2.getSelectedItem();
			}
			
		});
		jComboBox3.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				conditionSe=(String)jComboBox3.getSelectedItem();
			}
			
		});
		
	}
	

	public String[] getSortBy(int classify){
		int key = -1;
		String sortBy = jComboBoxSortCondition.getSelectedItem().toString();
		if (sortBy.equals("name")) {
			key = 0;
		} else if (sortBy.equals("competeNum")) {
			key = 2;
		} else if (sortBy.equals("offensiveNum")) {
			key = 3;
		} else if (sortBy.equals("reboundNum")) {
			key = 4;
		} else if (sortBy.equals("assistingNum")) {
			key = 5;
		} else if (sortBy.equals("hitRate")) {
			key = 7;
		} else if (sortBy.equals("threePointHitRate")) {
			key = 8;
		} else if (sortBy.equals("freeThrowHitRate")) {
			key = 9;
		} else if (sortBy.equals("offensiveReboundNum")) {
			key = 10;
		} else if (sortBy.equals("defensiveReboundNum")) {
			key = 11;
		} else if (sortBy.equals("stealNum")) {
			key = 12;
		} else if (sortBy.equals("blockShotNum")) {
			key = 13;
		} else if (sortBy.equals("muffNum")) {
			key = 14;
		} else if (sortBy.equals("foulNum")) {
			key = 15;	
		} else if (sortBy.equals("score")) {
			key = 16;
		} else if (sortBy.equals("efficiency")) {
			key = 17;
		} else if (sortBy.equals("GmScEfficiency")) {
			key = 18;
		} else if (sortBy.equals("trueHitRate")) {
			key = 19;
		} else if (sortBy.equals("shootEfficiency")) {
			key = 20;
		} else if (sortBy.equals("reboundRate")) {
			key = 21;
		} else if (sortBy.equals("offensiveReboundRate")) {
			key = 22;
		} else if (sortBy.equals("defensiveReboundRate")) {
			key = 23;
		} else if (sortBy.equals("assistingRate")) {
			key = 24;
		} else if (sortBy.equals("stealRate")) {
			key = 25;
		} else if (sortBy.equals("blockShotRate")) {
			key = 26;
		} else if (sortBy.equals("muffRate")) {
			key = 27;
		} else if (sortBy.equals("usage")) {
			key = 28;
		}  else {
			System.out.println("invalid sortBy Condition");
		}
		
    	PlayerService ps = new PlayerBL();
    	ArrayList<PlayerStrVO> playerList = new ArrayList<PlayerStrVO>();
    	ArrayList<PlayerStrVO> rePlayer = new ArrayList<PlayerStrVO>();
    	if(classify==0) {
    		playerList = ps.playerAll();
    		rePlayer = ps.ascendPlayerStr(key, playerList);
    	} else if (classify==1) {
    		playerList = ps.playerAverage();
    		rePlayer = ps.ascendPlayerAStr(key, playerList);
    	} else {
    		System.out.println("invalid classify-player.");
    	}
    	String[]  playerName = new String[rePlayer.size()];
    	for (int i=0;i < rePlayer.size();i++) {
    		playerName[i] = rePlayer.get(i).getName();
    	}

    	return playerName;
    }

	public String[] getData(String condition) {
		PlayerService data1 = new PlayerBL();
		ArrayList<PlayerStrVO> data2 = new ArrayList<PlayerStrVO>();
		data2 = data1.filterAll(condition);
		// TODO
		if (data2.size() > 50) {
			String[] playerData = new String[50];
			for (int i = 0; i < 50; i++) {
				playerData[i] = data2.get(i).getName();
			}
			return playerData;
		} else {
			String[] playerDataless = new String[data2.size()];
			for (int i = 0; i < data2.size(); i++) {
				playerDataless[i] = data2.get(i).getName();
			}
			return playerDataless;
		}
	}
}
