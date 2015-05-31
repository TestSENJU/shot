package UIComponent.Team;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;
import javax.swing.table.TableColumnModel;

import UIComponent.MyColor;
import UIComponent.MyScrollPane;
import UIComponent.MyTable;

public class TeamExplorerPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
JLabel west,east;
JPanel right;
MyScrollPane left;
JPanel jp;
//���Ϸ����� ������� ��������� �� ���Ϸ��� �������� ̫ƽ����� 

MyTable westtable;
MyTable easttable;
private String[]header=new String[]{"��Ӷӻ�","������","Ӣ����","Ӣ����д"};
private String[] weststring=new String[]{"�������Ȼ��","������ħ����","����������ӥ��","��ʢ����Ŷ�","�����ػƷ��",
		"�����ɻ�����","ӡ�ڰ��ɲ����߶�","���������ʿ��","֥�Ӹ繫ţ��","�ܶ��ֻ���¹��",
		"��ʿ�ٿ������˶�","�ѳ�76�˶�","ŦԼ���˹��","��³����������","���׶�������"};
private String[] eaststring=new String[]{"ʥ���������̶�","�Ϸ�˹���ܶ�","����˹Сţ��","��˹�ػ����","�°¶������ɶ�",
		"�����մ�ɭ���Ƕ�","�������","������ʿ��","�����������߶�","���������������",
		"���������й�����","�����˹̫����","��ɼ���˶�","��ɼ�촬�� ","������ʿ��"
};
public TeamExplorerPanel(){   
    initComponent();
    addComponent();
}
public void initComponent(){
	this.setBounds(0, 0, 900, 600);
	this.setBackground(MyColor.WHITE.getColor());
	this.setBorder(new MatteBorder(1,1,1,1,MyColor.GREY.getColor()));
	this.setLayout(null);

	right=new JPanel();
	right.setLayout(null);
	right.setBounds(400,0,500, 600);
	right.setBackground(MyColor.WHITE.getColor());
	right.setBorder(new MatteBorder(1,1,1,1,MyColor.GREY.getColor()));
	
	west=new JLabel("��������");
	west.setBackground(MyColor.WHITE.getColor());
	west.setOpaque(false);
	west.setForeground(MyColor.BLUE.getColor());
	west.setFont(new Font("����",Font.PLAIN,20));
	west.setBounds(30,10,370,50);
	
	east=new JLabel("��������");
	east.setForeground(MyColor.BLUE.getColor());
	east.setFont(new Font("����",Font.PLAIN,20));
	
	Object[][]teams=new Object[15][4];
	for(int i=0;i<15;i++){
		teams[i][0]=new ImageIcon("myimg/search.png");
		teams[i][1]=weststring[i];
		teams[i][2]="saf";
		teams[i][3]="asdc";
	}
	westtable=new MyTable(teams,header) {  

		private static final long serialVersionUID = 1L;

		@SuppressWarnings({ "unchecked", "rawtypes" })
		public Class getColumnClass(int column) {
			
			return getValueAt(0, column).getClass();  
			} 
		public boolean isCellEditable(int row,int column){
			return false;
		}
		};
		westtable.setRowHeight(60);
		westtable.setBounds(0,80, 390, 900);
		westtable.setPreferredSize(new Dimension(400,900));
		
		jp=new JPanel();
		jp.setPreferredSize(new Dimension(400,1800));
		jp.setVisible(true);
		jp.setLayout(null);
		jp.add(west);
		jp.add(westtable.getTableHeader());
		jp.add(westtable);
		
		left=new MyScrollPane(jp);
		left.setBounds(0, 0, 400, 600);
		left.getViewport().setOpaque(false);
		left.setOpaque(false);
		left.getHorizontalScrollBar().setVisible(false);
	//	left.setPreferredSize(new Dimension(400,600));
		left.setBorder(new MatteBorder(0,1,1,1,MyColor.GREY.getColor()));
}
public void addComponent(){
	
	this.add(left,0);
	this.add(right);
}
}
