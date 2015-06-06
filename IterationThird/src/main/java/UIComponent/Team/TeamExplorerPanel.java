package UIComponent.Team;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import UIComponent.MyColor;
import UIComponent.MyScrollPane;

public class TeamExplorerPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
JLabel west,east;
JPanel jp;
JPanel left;
MyScrollPane jsp;
JLabel tip;
JLabel eastsouthlabel,centerlabel,westoceanlabel,westsouthlabel,westnorthlabel,oceanlabel;
//东南分区区 中央分区 大西洋分区 　 西南分区 西北分区 太平洋分区 
JLabel eastsouthicons[];
JLabel centericons[];
JLabel westoceanicons[];
JLabel westsouthicons[];
JLabel westnorthicons[];
JLabel oceanicons[];

JLabel eastsouthtexts[];
JLabel centertexts[];
JLabel westoceantexts[];
JLabel westsouthtexts[];
JLabel westnorthtexts[];
JLabel oceantexts[];
private String[] eastsouthpath=new String[]{"team/SAS.png","team/MEM.png","team/DAL.png","team/HOU.png","team/NOP.png"};
private String[]eastsouth=new String[]{"圣安东尼奥马刺队","孟菲斯灰熊队","达拉斯小牛队","休斯敦火箭队","新奥尔良鹈鹕队"};

private String[] centerpath=new String[]{"team/MIN.png","team/DEN.png","team/UTA.png","team/POR.png","team/OKC.png"};
private String[] center=new String[]{"明尼苏达森林狼队","丹佛掘金队","犹他爵士队","波特兰开拓者队","俄克拉荷马雷霆队"};

private String[] westoceanpath=new String[]{"team/SAC.png","team/PHX.png","team/LAL.png","team/LAC.png","team/GSW.png"};
private String[] westocean=new String[]{"萨克拉门托国王队","菲尼克斯太阳队","洛杉矶湖人队","洛杉矶快船队 ","金州勇士队"};

private String[] westsouthpath=new String[]{"team/MIA.png","team/ORL.png","team/ATL.png","team/WAS.png","team/CHA.png"};
private String[] westsouth=new String[]{"迈阿密热火队","奥兰多魔术队","亚特兰大老鹰队","华盛顿奇才队","夏洛特黄蜂队"};

private String[] westnorthpath=new String[]{"team/DET.png","team/IND.png","team/CLE.png","team/CHI.png","team/MIL.png"};
private String[] westnorth=new String[]{"底特律活塞队","印第安纳步行者队","克里夫兰骑士队","芝加哥公牛队","密尔沃基雄鹿队"};

private String[] oceanpath=new String[]{"team/BOS.png","team/PHI.png","team/NYK.png","team/BKN.png","team/TOR.png"};
private String ocean[]=new String[]{"波士顿凯尔特人队","费城76人队","纽约尼克斯队","布鲁克林篮网队","多伦多猛龙队"};

public TeamExplorerPanel(){   
    initLabel();
    initPanel();
    initFrame();
    setListener();
}
public void initLabel(){
	
	west=new JLabel("西部分区");
	west.setForeground(MyColor.BLUE.getColor());
	west.setFont(new Font("黑体",Font.PLAIN,20));
	west.setBounds(30, 790, 370, 50);
	
	east=new JLabel("东部分区");
	east.setForeground(MyColor.BLUE.getColor());
	east.setFont(new Font("黑体",Font.PLAIN,20));
	east.setBounds(30,10,370,50);
//	JLabel eastsouthicons[];
	eastsouthicons=new JLabel[5];
	for(int i=0;i<5;i++){
		eastsouthicons[i]=new JLabel(new ImageIcon(eastsouthpath[i]));
		eastsouthicons[i].setBounds(15, 110+130*i, 100, 100);
	}
//	JLabel centericons[];
	centericons=new JLabel[5];
	for(int i=0;i<5;i++){
		centericons[i]=new JLabel(new ImageIcon(centerpath[i]));
		centericons[i].setBounds(145, 110+130*i, 100, 100);
	}
//	JLabel westoceanicons[];
	westoceanicons=new JLabel[5];
	for(int i=0;i<5;i++){
		westoceanicons[i]=new JLabel(new ImageIcon(westoceanpath[i]));
		westoceanicons[i].setBounds(275, 110+130*i, 100, 100);
	}
//	JLabel westsouthicons[];
	westsouthicons=new JLabel[5];
	for(int i=0;i<5;i++){
		westsouthicons[i]=new JLabel(new ImageIcon(westsouthpath[i]));
		westsouthicons[i].setBounds(15, 900+130*i, 100, 100);
	}
//	JLabel westnorthicons[];
	westnorthicons=new JLabel[5];
	for(int i=0;i<5;i++){
		westnorthicons[i]=new JLabel(new ImageIcon(westnorthpath[i]));
		westnorthicons[i].setBounds(145, 900+130*i, 100, 100);
	}
//	JLabel oceanicons[];
	oceanicons=new JLabel[5];
	for(int i=0;i<5;i++){
		oceanicons[i]=new JLabel(new ImageIcon(oceanpath[i]));
		oceanicons[i].setBounds(275, 900+130*i, 100, 100);
	}
	
	eastsouthtexts=new JLabel[5];
	for(int i=0;i<5;i++){
		eastsouthtexts[i]=new JLabel("<HTML><U>"+eastsouth[i]+"</U></HTML>");
		eastsouthtexts[i].setForeground(MyColor.BLACK.getColor());
		eastsouthtexts[i].setFont(new Font("黑体",Font.PLAIN,14));
		eastsouthtexts[i].setBounds(5, 210+130*i, 130, 30);
		eastsouthtexts[i].setHorizontalAlignment(SwingConstants.CENTER);
	}
	centertexts=new JLabel[5];
	for(int i=0;i<5;i++){
		centertexts[i]=new JLabel("<HTML><U>"+center[i]+"</U></HTML>");
		centertexts[i].setForeground(MyColor.BLACK.getColor());
		centertexts[i].setFont(new Font("黑体",Font.PLAIN,14));
		centertexts[i].setBounds(135, 210+130*i, 130, 30);
		centertexts[i].setHorizontalAlignment(SwingConstants.CENTER);
	}
	westoceantexts=new JLabel[5];
	for(int i=0;i<5;i++){
		westoceantexts[i]=new JLabel("<HTML><U>"+westocean[i]+"</U></HTML>");
		westoceantexts[i].setForeground(MyColor.BLACK.getColor());
		westoceantexts[i].setFont(new Font("黑体",Font.PLAIN,14));
		westoceantexts[i].setBounds(265, 210+130*i, 130, 30);
		westoceantexts[i].setHorizontalAlignment(SwingConstants.CENTER);
	}
	westsouthtexts=new JLabel[5];
	for(int i=0;i<5;i++){
		westsouthtexts[i]=new JLabel("<HTML><U>"+westsouth[i]+"</U></HTML>");
		westsouthtexts[i].setForeground(MyColor.BLACK.getColor());
		westsouthtexts[i].setFont(new Font("黑体",Font.PLAIN,14));
		westsouthtexts[i].setBounds(5, 1000+130*i, 130, 30);
		westsouthtexts[i].setHorizontalAlignment(SwingConstants.CENTER);
	}
	westnorthtexts=new JLabel[5];
	for(int i=0;i<5;i++){
		westnorthtexts[i]=new JLabel("<HTML><U>"+westnorth[i]+"</U></HTML>");
		westnorthtexts[i].setForeground(MyColor.BLACK.getColor());
		westnorthtexts[i].setFont(new Font("黑体",Font.PLAIN,14));
		westnorthtexts[i].setBounds(135, 1000+130*i, 130, 30);
		westnorthtexts[i].setHorizontalAlignment(SwingConstants.CENTER);
	}
	oceantexts=new JLabel[5];
	for(int i=0;i<5;i++){
		oceantexts[i]=new JLabel("<HTML><U>"+ocean[i]+"</U></HTML>");
		oceantexts[i].setForeground(MyColor.BLACK.getColor());
		oceantexts[i].setFont(new Font("黑体",Font.PLAIN,14));
		oceantexts[i].setBounds(265, 1000+130*i, 130, 30);
		oceantexts[i].setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	eastsouthlabel=new JLabel("东南分区");
	eastsouthlabel.setForeground(MyColor.PURPLE.getColor());
	eastsouthlabel.setFont(new Font("黑体",Font.PLAIN,18));
	eastsouthlabel.setBounds(5, 70, 130, 30);
	eastsouthlabel.setHorizontalAlignment(SwingConstants.CENTER);
		
	centerlabel=new JLabel("中央分区");
	centerlabel.setForeground(MyColor.PURPLE.getColor());
	centerlabel.setFont(new Font("黑体",Font.PLAIN,18));
	centerlabel.setBounds(135, 70, 130, 30);
	centerlabel.setHorizontalAlignment(SwingConstants.CENTER);
	
	westoceanlabel=new JLabel("大西洋分区");
	westoceanlabel.setForeground(MyColor.PURPLE.getColor());
	westoceanlabel.setFont(new Font("黑体",Font.PLAIN,18));
	westoceanlabel.setBounds(265, 70, 130, 30);
	westoceanlabel.setHorizontalAlignment(SwingConstants.CENTER);
	
	westsouthlabel=new JLabel("西南分区");
	westsouthlabel.setForeground(MyColor.PURPLE.getColor());
	westsouthlabel.setFont(new Font("黑体",Font.PLAIN,18));
	westsouthlabel.setBounds(5, 860, 130, 30);
	westsouthlabel.setHorizontalAlignment(SwingConstants.CENTER);
	
	westnorthlabel=new JLabel("西北分区");
	westnorthlabel.setForeground(MyColor.PURPLE.getColor());
	westnorthlabel.setFont(new Font("黑体",Font.PLAIN,18));
	westnorthlabel.setBounds(135, 860, 130, 30);
	westnorthlabel.setHorizontalAlignment(SwingConstants.CENTER);
	
	oceanlabel=new JLabel("太平洋分区");
	oceanlabel.setForeground(MyColor.PURPLE.getColor());
	oceanlabel.setFont(new Font("黑体",Font.PLAIN,18));
	oceanlabel.setBounds(265, 860, 130, 30);
	oceanlabel.setHorizontalAlignment(SwingConstants.CENTER);

	tip=new JLabel("选择左侧列表中的球队来显示详细信息");
	tip.setForeground(MyColor.BLUE.getColor());
	tip.setFont(new Font("黑体",Font.PLAIN,16));
	tip.setBounds(530, 275,300,25);
}
public void initPanel(){
	
	   jp=new JPanel();
	   jp.setLayout(null);
	   jp.setBackground(MyColor.WHITE.getColor());
	   jp.setPreferredSize(new Dimension(400,1600));
	        jp.add(east);
			jp.add(eastsouthlabel);
			jp.add(centerlabel);
			jp.add(westoceanlabel);
			for(int i=0;i<5;i++){
				jp.add(eastsouthicons[i]);
			}
			for(int i=0;i<5;i++){
				jp.add(centericons[i]);
			}
			for(int i=0;i<5;i++){
				jp.add(westoceanicons[i]);
			}
			for(int i=0;i<5;i++){
				jp.add(westsouthicons[i]);
			}
			for(int i=0;i<5;i++){
				jp.add(westnorthicons[i]);
			}
			for(int i=0;i<5;i++){
				jp.add(oceanicons[i]);
			}
			
			for(int i=0;i<5;i++){
				jp.add(eastsouthtexts[i]);
			}
			for(int i=0;i<5;i++){
				jp.add(centertexts[i]);
			}
			for(int i=0;i<5;i++){
				jp.add(westoceantexts[i]);
			}
			for(int i=0;i<5;i++){
				jp.add(westsouthtexts[i]);
			}
			for(int i=0;i<5;i++){
				jp.add(westnorthtexts[i]);
			}
			for(int i=0;i<5;i++){
				jp.add(oceantexts[i]);
			}
			jp.add(west);
			jp.add(westsouthlabel);
			jp.add(westnorthlabel);
			jp.add(oceanlabel);
			jp.add(centerlabel);
					
		    jsp=new MyScrollPane(jp);
		    jsp.setVisible(true);
		    jsp.setOpaque(false);
			jsp.setBounds(0,0, 400, 580);
			jsp.setBorder(new MatteBorder(0,1,1,1,MyColor.GREY.getColor()));
		    jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		    jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		    
		    left=new JPanel();
		    left.setBackground(MyColor.WHITE.getColor());
		    left.setLayout(null);
		    left.setBounds(0, 0, 400, 580);
}
public void initFrame(){
	left.add(jsp);
	
	this.setLayout(null);
	this.setBounds(0, 20, 900, 580);
	this.setBackground(MyColor.WHITE.getColor());
	this.setBorder(new MatteBorder(0,1,1,1,MyColor.GREY.getColor()));
	this.add(left);
	this.add(tip);

}
public void setListener(){
	for(int i=0;i<5;i++){
		eastsouthtexts[i].addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
		         JLabel tmp=(JLabel)e.getSource();
		         tmp.setForeground(MyColor.BLUE.getColor());
			}
			public void mouseExited(MouseEvent e){
		         JLabel tmp=(JLabel)e.getSource();
		         tmp.setForeground(MyColor.BLACK.getColor());
			}
            public void mouseClicked(MouseEvent e){
				//TODO
                JLabel tmp=(JLabel)e.getSource();
		         tmp.setForeground(MyColor.RED.getColor());
                String str=tmp.getText();
                String s[]=str.split(">")[2].split("<");
                if(getComponentAt(530,275)instanceof JLabel){
                	 remove(tip);
                     TeamDetailPanel team=new TeamDetailPanel(s[0]);
                     team.setBounds(400, 20, 500, 580);
                     add(team);
                     repaint();
                }else if(getComponentAt(530,275)instanceof TeamDetailPanel){
                	TeamDetailPanel teamold=(TeamDetailPanel)getComponentAt(530,275);
                	if(s[0].equals(teamold.getTeam())){
                	}else{
                		 TeamDetailPanel team=new TeamDetailPanel(s[0]);
                         team.setBounds(400, 20, 500, 580);
                         remove(getComponentAt(530,275));
                         add(team);
                         repaint();
                	}
                }
               
			}
		});
	}
	for(int j=0;j<5;j++){
		centertexts[j].addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
		         JLabel tmp=(JLabel)e.getSource();
		         tmp.setForeground(MyColor.BLUE.getColor());
			}
			public void mouseExited(MouseEvent e){
		         JLabel tmp=(JLabel)e.getSource();
		         tmp.setForeground(MyColor.BLACK.getColor());
			}
           public void mouseClicked(MouseEvent e){
				//TODO
        	   JLabel tmp=(JLabel)e.getSource();
		         tmp.setForeground(MyColor.RED.getColor());
              String str=tmp.getText();
              String s[]=str.split(">")[2].split("<");
              if(getComponentAt(530,275)instanceof JLabel){
             	 remove(tip);
                  TeamDetailPanel team=new TeamDetailPanel(s[0]);
                  team.setBounds(400, 20, 500, 580);
                  add(team);
                  repaint();
             }else if(getComponentAt(530,275)instanceof TeamDetailPanel){
             	TeamDetailPanel teamold=(TeamDetailPanel)getComponentAt(530,275);
             	if(s[0].equals(teamold.getTeam())){
             	}else{
             		 TeamDetailPanel team=new TeamDetailPanel(s[0]);
                      team.setBounds(400, 20, 500, 580);
                      remove(getComponentAt(530,275));
                      add(team);
                      repaint();
             	}
             }
			}
		});
	}
	for(int i=0;i<5;i++){
		westoceantexts[i].addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
		         JLabel tmp=(JLabel)e.getSource();
		         tmp.setForeground(MyColor.BLUE.getColor());
			}
			public void mouseExited(MouseEvent e){
		         JLabel tmp=(JLabel)e.getSource();
		         tmp.setForeground(MyColor.BLACK.getColor());
			}
           public void mouseClicked(MouseEvent e){
				//TODO
        	   JLabel tmp=(JLabel)e.getSource();
		         tmp.setForeground(MyColor.RED.getColor());
              String str=tmp.getText();
              String s[]=str.split(">")[2].split("<");
              if(getComponentAt(530,275)instanceof JLabel){
             	 remove(tip);
                  TeamDetailPanel team=new TeamDetailPanel(s[0]);
                  team.setBounds(400, 20, 500, 580);
                  add(team);
                  repaint();
             }else if(getComponentAt(530,275)instanceof TeamDetailPanel){
             	TeamDetailPanel teamold=(TeamDetailPanel)getComponentAt(530,275);
             	if(s[0].equals(teamold.getTeam())){
             	}else{
             		 TeamDetailPanel team=new TeamDetailPanel(s[0]);
                      team.setBounds(400, 20, 500, 580);
                      remove(getComponentAt(530,275));
                      add(team);
                      repaint();
             	}
             }
			}
		});
	}
	for(int i=0;i<5;i++){
		westsouthtexts[i].addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
		         JLabel tmp=(JLabel)e.getSource();
		         tmp.setForeground(MyColor.BLUE.getColor());
			}
			public void mouseExited(MouseEvent e){
		         JLabel tmp=(JLabel)e.getSource();
		         tmp.setForeground(MyColor.BLACK.getColor());
			}
           public void mouseClicked(MouseEvent e){
				//TODO
        	   JLabel tmp=(JLabel)e.getSource();
		         tmp.setForeground(MyColor.RED.getColor());
              String str=tmp.getText();
              String s[]=str.split(">")[2].split("<");
              if(getComponentAt(530,275)instanceof JLabel){
             	 remove(tip);
                  TeamDetailPanel team=new TeamDetailPanel(s[0]);
                  team.setBounds(400, 20, 500, 580);
                  add(team);
                  repaint();
             }else if(getComponentAt(530,275)instanceof TeamDetailPanel){
             	TeamDetailPanel teamold=(TeamDetailPanel)getComponentAt(530,275);
             	if(s[0].equals(teamold.getTeam())){
             	}else{
             		 TeamDetailPanel team=new TeamDetailPanel(s[0]);
                      team.setBounds(400, 20, 500, 580);
                      remove(getComponentAt(530,275));
                      add(team);
                      repaint();
             	}
             }
			}
		});
	}
	for(int i=0;i<5;i++){
		westnorthtexts[i].addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
		         JLabel tmp=(JLabel)e.getSource();
		         tmp.setForeground(MyColor.BLUE.getColor());
			}
			public void mouseExited(MouseEvent e){
		         JLabel tmp=(JLabel)e.getSource();
		         tmp.setForeground(MyColor.BLACK.getColor());
			}
           public void mouseClicked(MouseEvent e){
				//TODO
        	   JLabel tmp=(JLabel)e.getSource();
		         tmp.setForeground(MyColor.RED.getColor());
              String str=tmp.getText();
              String s[]=str.split(">")[2].split("<");
              if(getComponentAt(530,275)instanceof JLabel){
             	 remove(tip);
                  TeamDetailPanel team=new TeamDetailPanel(s[0]);
                  team.setBounds(400, 20, 500, 580);
                  add(team);
                  repaint();
             }else if(getComponentAt(530,275)instanceof TeamDetailPanel){
             	TeamDetailPanel teamold=(TeamDetailPanel)getComponentAt(530,275);
             	if(s[0].equals(teamold.getTeam())){
             	}else{
             		 TeamDetailPanel team=new TeamDetailPanel(s[0]);
                      team.setBounds(400, 20, 500, 580);
                      remove(getComponentAt(530,275));
                      add(team);
                      repaint();
             	}
             }
			}
		});
	}
	for(int i=0;i<5;i++){
		oceantexts[i].addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
		         JLabel tmp=(JLabel)e.getSource();
		         tmp.setForeground(MyColor.BLUE.getColor());
			}
			public void mouseExited(MouseEvent e){
		         JLabel tmp=(JLabel)e.getSource();
		         tmp.setForeground(MyColor.BLACK.getColor());
			}
           public void mouseClicked(MouseEvent e){
				//TODO
        	  JLabel tmp=(JLabel)e.getSource();
		      tmp.setForeground(MyColor.RED.getColor());
              String str=tmp.getText();
              String s[]=str.split(">")[2].split("<");
              if(getComponentAt(530,275)instanceof JLabel){
             	 remove(tip);
                  TeamDetailPanel team=new TeamDetailPanel(s[0]);
                  team.setBounds(400, 20, 500, 580);
                  add(team);
                  repaint();
             }else if(getComponentAt(530,275)instanceof TeamDetailPanel){
             	TeamDetailPanel teamold=(TeamDetailPanel)getComponentAt(530,275);
             	if(s[0].equals(teamold.getTeam())){
             	}else{
             		 TeamDetailPanel team=new TeamDetailPanel(s[0]);
                      team.setBounds(400, 20, 500, 580);
                      remove(getComponentAt(530,275));
                      add(team);
                      repaint();
             	}
             }
			}
		});
	}
	
}

}
