package UIComponent;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
//��д�˱��
public class MyTable extends JTable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyTable(DefaultTableModel model){
		super(model);
		init();
	}
	public MyTable(Object[][] contents,Object[] header){
		super(contents,header);
		init();
	}
	 public JTableHeader getTableHeader() {  
           JTableHeader tableHeader = super.getTableHeader();  
           tableHeader.setOpaque(false);
           tableHeader.setBorder(new MatteBorder(1,1,1,1,MyColor.GREY.getColor()));
           
           tableHeader.setBackground(MyColor.WHITE.getColor());
           tableHeader.setReorderingAllowed(false);//����в����ƶ�  
           DefaultTableCellRenderer hr = (DefaultTableCellRenderer) tableHeader.getDefaultRenderer();  
           hr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);//��������  
           return tableHeader;  
	 }  

	public void init(){
		this.setBackground(MyColor.WHITE.getColor());
		this.setForeground(MyColor.BLACK.getColor());
		this.setSelectionBackground(MyColor.BLUE.getColor());
		this.setSelectionForeground(MyColor.DARKWHITE.getColor());

		this.setGridColor(MyColor.GREY.getColor());
		
        DefaultTableCellRenderer render = new DefaultTableCellRenderer();
        render.setHorizontalAlignment(SwingConstants.CENTER);//���ݾ���
        this.setDefaultRenderer(Object.class, render);
        
    	this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  //���ֻ����ѡ
	}
	 
}
