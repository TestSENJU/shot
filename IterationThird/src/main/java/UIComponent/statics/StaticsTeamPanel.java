package UIComponent.statics;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import UIComponent.MyColor;
import UIComponent.MyComboBox;
import UIComponent.MyScrollPane;
import UIComponent.MyTable;

public class StaticsTeamPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel rateOption;
	JLabel[] option=new JLabel[25];
	JLabel choose;
	JLabel season;
	JLabel aver;
	JLabel all;
	JLabel current;
	JLabel after;
	MyComboBox seasonbox;
	JLabel num,rate;
	DefaultTableModel nummodel;
	MyScrollPane numjsp;
	MyTable numTable;
	MyTable rateTable;
	DefaultTableModel ratemodel;
	MyScrollPane ratejsp;
	
	private boolean average=true;
	private boolean now=true;

	private String[] optionName=new String[]{"比赛场数","投篮命中数","投篮出手数","三分命中数",
			"三分出手数","罚球命中数","罚球出手数","进攻篮板数","防守篮板数","篮板数","助攻数","抢断数","盖帽数"
			,"失误数","犯规数","比赛得分","投篮命中率","三分命中率","罚球命中率","进攻回合","进攻效率","防守效率"
			,"篮板效率","抢断效率","助攻率"}; 
	private String[] numTableHeader=new String[]{"名字","比赛场数","投篮命中","投篮出手","三分命中",
			"三分出手","罚球命中","罚球出手","进攻篮板","防守篮板","篮板","助攻","抢断","盖帽"
			,"失误","犯规","得分"};
	private String rateTableHeader[]=new String[]{"名字","投篮命中率","三分命中率","罚球命中率","胜率",
			"进攻回合","进攻效率","防守效率","篮板效率","抢断效率","助攻率"};
	public StaticsTeamPanel(){
		initComponent();
		initPanel();
		addComponent();
		setListener();
		
	}
public void initComponent(){
	nummodel=new DefaultTableModel(null, numTableHeader){
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int row,int column){
			return false;
		}
	};
	numTable=new MyTable(nummodel);
	numjsp=new MyScrollPane(numTable);
	for(int i=0;i<30;i++){
		nummodel.addRow(new String[]{"as","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1"});
	}
	numjsp.setBounds(0, 175, 900, 445);
	  TableColumnModel tcm1 = numTable.getColumnModel();
	     tcm1.getColumn(0).setPreferredWidth(120);
	  for(int i=1;i<10;i++){
		     tcm1.getColumn(i).setPreferredWidth(50);
	  }
	  for(int i=10;i<17;i++){
		     tcm1.getColumn(i).setPreferredWidth(40);
	  }
	ratemodel=new DefaultTableModel(null,rateTableHeader){
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int row,int column){
			return false;
		}
	};
	rateTable=new MyTable(ratemodel);
	ratejsp=new MyScrollPane(rateTable);
	ratejsp.setBounds(0, 175, 900, 445);
	 TableColumnModel tcm2 = rateTable.getColumnModel();
     tcm2.getColumn(0).setPreferredWidth(120);
	for(int i=0;i<30;i++){
		ratemodel.addRow(new String[]{"as","1","1","1","1","1","1","1","1","1","1"});
	}
	
	num=new JLabel("数字");
	num.setForeground(MyColor.BLUE.getColor());
	num.setOpaque(true);
	num.setBackground(MyColor.WHITE.getColor());
	num.setHorizontalAlignment(SwingConstants.CENTER);
	num.setFont(new Font("黑体",Font.PLAIN,14));
	num.setBounds(10, 130, 40, 40);
	
	rate=new JLabel("%");
	rate.setForeground(MyColor.BLUE.getColor());
	rate.setOpaque(true);
	rate.setBackground(MyColor.LIGHTBLUE.getColor());
	rate.setHorizontalAlignment(SwingConstants.CENTER);
	rate.setFont(new Font("黑体",Font.PLAIN,14));
	rate.setBounds(60, 130, 40, 40);

	season=new JLabel("赛季");
	season.setForeground(MyColor.BLUE.getColor());
	season.setFont(new Font("黑体",Font.PLAIN,14));
	season.setBounds(10, 0, 60, 40);
	
	String year[]=new String[3];
	for(int i=0;i<year.length;i++){
		year[i]=i+2012+"-"+(i+2013);
	}
	seasonbox=new MyComboBox(year);
	seasonbox.setBounds(70, 8, 100, 25);
	
	aver=new JLabel("平均");
	aver.setForeground(MyColor.BLUE.getColor());
	aver.setFont(new Font("黑体",Font.PLAIN,14));
	aver.setOpaque(true);
	aver.setBackground(MyColor.LIGHTBLUE.getColor());
	aver.setHorizontalAlignment(SwingConstants.CENTER);
	aver.setBounds(200, 5, 60, 30);
	
	all=new JLabel("总赛季");
	all.setForeground(MyColor.BLUE.getColor());
	all.setFont(new Font("黑体",Font.PLAIN,14));
	all.setHorizontalAlignment(SwingConstants.CENTER);
	all.setBounds(265, 5, 60, 30);
	all.setOpaque(true);
	all.setBackground(MyColor.WHITE.getColor());
	
	current=new JLabel("常规赛");
	current.setForeground(MyColor.BLUE.getColor());
	current.setFont(new Font("黑体",Font.PLAIN,14));
	current.setOpaque(true);
	current.setBackground(MyColor.LIGHTBLUE.getColor());
	current.setHorizontalAlignment(SwingConstants.CENTER);
	current.setBounds(365, 5, 60, 30);
	current.setOpaque(true);
	
	after=new JLabel("季后赛");
	after.setForeground(MyColor.BLUE.getColor());
	after.setHorizontalAlignment(SwingConstants.CENTER);
	after.setFont(new Font("黑体",Font.PLAIN,14));
	after.setBounds(430, 5, 60, 30);
	after.setOpaque(true);
	after.setBackground(MyColor.WHITE.getColor());
			
	choose=new JLabel("排序依据");
	choose.setForeground(MyColor.BLUE.getColor());
	choose.setFont(new Font("黑体",Font.PLAIN,14));
	choose.setBounds(0, 0, 60, 40);
	
	for(int i=0;i<12;i++){
		option[i]=new JLabel(optionName[i]);
		option[i].setForeground(MyColor.BLACK.getColor());
		option[i].setFont(new Font("微软雅黑",Font.PLAIN,12));
		option[i].setOpaque(true);
		option[i].setBackground(MyColor.WHITE.getColor());
		option[i].setBounds(60+i*70, 0, 60, 40);
		option[i].setHorizontalAlignment(SwingConstants.CENTER);
	}
	for(int i=0;i<13;i++){
		option[i+12]=new JLabel(optionName[i+12]);
		option[i+12].setForeground(MyColor.BLACK.getColor());
		option[i+12].setFont(new Font("微软雅黑",Font.PLAIN,12));
		option[i+12].setOpaque(true);
		option[i+12].setBackground(MyColor.WHITE.getColor());
		option[i+12].setBounds(60+i*70, 40, 60, 40);
		option[i+12].setHorizontalAlignment(SwingConstants.CENTER);
	}
	
}
public void initPanel(){

	rateOption=new JPanel();
	rateOption.setBackground(MyColor.WHITE.getColor());
	rateOption.setBounds(0, 40, 900, 80);
	rateOption.setLayout(null);
	
	this.setLayout(null);
	this.setBackground(MyColor.WHITE.getColor());
}

public void addComponent(){
	rateOption.add(choose);
	for(int i=0;i<option.length;i++){
		rateOption.add(option[i]);
	}
	this.add(ratejsp);
	this.add(rate);
	this.add(num);
	this.add(aver);
	this.add(all);
	this.add(current);
	this.add(after);
	this.add(season);
	this.add(seasonbox);
	this.add(rateOption);
}
public void setListener(){
	num.addMouseListener(new MouseAdapter(){
        public void mouseClicked(MouseEvent e){
        	num.setBackground(MyColor.LIGHTBLUE.getColor());
        	rate.setBackground(MyColor.WHITE.getColor());
        	if(getComponentAt(180,300).equals(numjsp)){
        		
        	}else{
            	remove(getComponentAt(180,300));
            	add(numjsp);
            	repaint();
        	}
		}
	});
	rate.addMouseListener(new MouseAdapter(){
        public void mouseClicked(MouseEvent e){
        	rate.setBackground(MyColor.LIGHTBLUE.getColor());
        	num.setBackground(MyColor.WHITE.getColor());
            if(getComponentAt(180,300).equals(ratejsp)){
        		
        	}else{
            	remove(getComponentAt(180,300));
            	add(ratejsp);
            	repaint();
        	}
		}
	});
	aver.addMouseListener(new MouseAdapter(){
        public void mouseClicked(MouseEvent e){
        	aver.setBackground(MyColor.LIGHTBLUE.getColor());
        	all.setBackground(MyColor.WHITE.getColor());
        	average=true;
		}
	});
	all.addMouseListener(new MouseAdapter(){
		  public void mouseClicked(MouseEvent e){
			   aver.setBackground(MyColor.WHITE.getColor());
	        	all.setBackground(MyColor.LIGHTBLUE.getColor());
	        	average=false;
	        	
			}
	});
	current.addMouseListener(new MouseAdapter(){
		  public void mouseClicked(MouseEvent e){
			  current.setBackground(MyColor.LIGHTBLUE.getColor());
			  after.setBackground(MyColor.WHITE.getColor());
			  now=true;
			}
	});
	after.addMouseListener(new MouseAdapter(){
		  public void mouseClicked(MouseEvent e){
			  current.setBackground(MyColor.WHITE.getColor());
			  after.setBackground(MyColor.LIGHTBLUE.getColor());
			  now=false;
			}
	});
	for(int i=0;i<option.length;i++){
		option[i].addMouseListener(new MouseAdapter(){
			
			public void mouseClicked(MouseEvent e){
				   JLabel tmp=(JLabel)e.getSource();
				   for(int i=0;i<optionName.length;i++){
					   option[i].setBackground(MyColor.WHITE.getColor());
				   }
			       tmp.setBackground(MyColor.LIGHTBLUE.getColor());
			}
		});
	}
}
}
