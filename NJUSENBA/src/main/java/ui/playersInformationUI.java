package ui;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.WindowConstants;

public class playersInformationUI {
    JFrame jFrame=new JFrame("球员信息查看");
    JLabel jLabel1=new JLabel("选择查看赛季总数据或场均数据：");
    JLabel jLabel2=new JLabel("background");
    ImageIcon background=new ImageIcon("C://nba/picture/player2.jpg");
    String[] data={"赛季总数据","赛季平均数据"};
    JComboBox jComboBox=new JComboBox(data);
    public void playerInformationUI(){
    	jFrame.setVisible(true);
    	jFrame.setSize(900, 600);
    	jFrame.setLayout(null);
    	jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    	jFrame.setLocationRelativeTo(null);
    	String[] columnNames={"球员名称","所属球队","参赛场数","先发场数","篮板数","助攻数","在场时间","投篮命中率","三分命中率","罚球命中率","进攻数","防守数","抢断数","盖帽数","失误数"};
        String[][] tableValues={{"球员名称","所属球队","参赛场数","先发场数","篮板数","助攻数","在场时间","投篮命中率","三分命中率","罚球命中率","进攻数","防守数","抢断数","盖帽数","失误数"},{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15"},{"犯规数","得分","效率","GmSc效率值","真实命中率","投篮效率","篮板率","进攻篮板率","防守篮板率","助攻率","抢断率","盖帽率","失误率","使用率"," "}};
        JTable table1=new JTable(tableValues,columnNames);
        jLabel2.setBounds(0, 0, 900, 600);
        jLabel2.setIcon(background);
        jFrame.add(jLabel2);
    	table1.setBounds(0, 100, 900, 100);
    	jLabel2.add(table1);
    	jLabel1.setBounds(200, 20, 250, 80);
    	jLabel2.add(jLabel1);
    	jComboBox.setBounds(500, 20, 200, 70);
    	jLabel2.add(jComboBox);
    }
}
