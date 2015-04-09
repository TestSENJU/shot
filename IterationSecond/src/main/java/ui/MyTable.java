package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.Enumeration;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class MyTable extends JTable {
	   private static final long serialVersionUID = 1L;
	   //用于设定颜色的数组
	   private String[] color = null;
	   Object[][] Data = {};
	    
	    public MyTable()
	    {
	        
	    }
	    
	    public MyTable( String[][] rowData , String[] columnNames)
	    {
	        super(rowData,columnNames);
	        System.out.println("string");
	        //paintRow();//将奇偶行分别设置为不同颜色
	        setFixColumnWidth(this);//固定表格的列宽
	    }
	   public MyTable( Object[][] rowData , String[] columnNames)
	    {
		  
	        super(rowData,columnNames);
	        System.out.println("object");
	    	Data = rowData;
	        //paintRow();//将奇偶行分别设置为不同颜色
	        setFixColumnWidth(this);//固定表格的列宽
	    }
	    public MyTable(Object[][] rowData, Object[] columnNames, String[] color) 
	    {
	        super(rowData, columnNames);
	        this.color = color;
	        paintColorRow();
	        
	        setFixColumnWidth(this);
	        
	        RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(this.getModel());
	        this.setRowSorter(sorter);
	        
	        this.setIntercellSpacing(new Dimension(5,5));
	        
	        fitTableColumns(this);
	    }
	    
	    //TODO picture test
	   public Object getValueAt(int rowIndex, int columnIndex){
		   if (columnIndex==0){
			   return super.getValueAt(rowIndex, columnIndex);
			   //return new ImageIcon("img/a.jpg");
		   } else {
			   return super.getValueAt(rowIndex, columnIndex);
		   }
		   //return super.getValueAt(rowIndex, columnIndex);
	   }
	    // TODO 
		public void setValueAt(Object value, int rowIndex, int columnIndex) {
			Data[rowIndex][columnIndex] = value;
			//
		}
		
	    public JTableHeader getTableHeader()
	    {
	    	Dimension viewSize = new Dimension();
	    	viewSize.width = super.getColumnModel().getTotalColumnWidth();
	    	viewSize.height = 10 * super.getRowHeight();   
	    	super.setPreferredScrollableViewportSize(viewSize);
	    	
	        JTableHeader tableHeader = super.getTableHeader();
	        //tableHeader.setPreferredSize(new Dimension(tableHeader.getWidth(), 46));
	        //tableHeader.getTable().setFont(fo);
	        
	        tableHeader.setOpaque(false);
	        tableHeader.getTable().setOpaque(false);
	        tableHeader.setReorderingAllowed(false);   //设置表格列不可重排
	        DefaultTableCellRenderer hr =(DefaultTableCellRenderer)tableHeader.getDefaultRenderer();  //获得表格头的单元格对象
	        hr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);  //列名居中
	        tableHeader.setDefaultRenderer(super.getDefaultRenderer(getClass()));
	        TableCellRenderer headerRenderer = tableHeader.getDefaultRenderer();
	        if (headerRenderer instanceof JLabel) {
	        	((JLabel) headerRenderer).setHorizontalAlignment(JLabel.CENTER);   
	            ((JLabel) headerRenderer).setOpaque(false);  
	        }
	        return tableHeader;
	        
	    }
	    /**
	     * @Override
	     */
	    public TableCellRenderer getDefaultRenderer(Class<?>columnClass)
	    {
	        DefaultTableCellRenderer cr =(DefaultTableCellRenderer)super.getDefaultRenderer(columnClass);
	        cr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);  //单元格内容居中
	        cr.setOpaque(false);
	      //TODO super.setDefaultRenderer(Object.class, cr);//被这句搞死了！加上表格就没内容了！
	        return cr;
	    }
	    /**
	     * @Override
	     */
	    public boolean isCellEditable(int row,int column)
	    {
	        return false;   //单元格不可修改
	    }
	    
	    //TODO
	    public TableColumnModel setFixColumnWidth(JTable table)
	    {
	        //this.setRowHeight(30);
	        this.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	       
	        //The following code can be used to fix table column width
	        TableColumnModel tcm = table.getTableHeader().getColumnModel();
	        for (int i = 0; i < tcm.getColumnCount(); i++) 
	        {
	            TableColumn tc = tcm.getColumn(i);
	            tc.setPreferredWidth(100);
	            // tc.setMinWidth(100);
	            tc.setMaxWidth(100);
	        }
	        return tcm;
	    }
	    
	    //TODO
	    public void paintRow(){
	    	TableColumnModel tcm = this.getColumnModel();
	    	for (int i=0;i < tcm.getColumnCount();i++) {
	    		TableColumn tc = tcm.getColumn(i);
	    		tc.setCellRenderer(new RowRenderer());
	    	}
	    }
	    
	    //TODO
	    public void paintColorRow(){
	    	TableColumnModel tcm = this.getColumnModel();
	        for (int i = 0, n = tcm.getColumnCount(); i < n; i++) 
	        {
	            TableColumn tc = tcm.getColumn(i);
	            tc.setCellRenderer(new RowColorRenderer());
	        }
	    }
	    //TODO
	    public void fitTableColumns(JTable myTable)
	    {
	         myTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	         JTableHeader header = myTable.getTableHeader();
	         int rowCount = myTable.getRowCount();
	         Enumeration<TableColumn> columns = myTable.getColumnModel().getColumns();
	         while(columns.hasMoreElements())
	         {
	             TableColumn column = columns.nextElement();
	             int col = header.getColumnModel().getColumnIndex(column.getIdentifier());
	             int width = (int)header.getDefaultRenderer().getTableCellRendererComponent
	             (myTable, column.getIdentifier(), false, false, -1, col).getPreferredSize().getWidth();
	             for(int row = 0; row < rowCount; row++)
	             {
	                 int preferedWidth = (int)myTable.getCellRenderer(row, col).getTableCellRendererComponent
	                 (myTable, myTable.getValueAt(row, col), false, false, row, col).getPreferredSize().getWidth();
	                 width = Math.max(width, preferedWidth);
	             }
	             header.setResizingColumn(column); // 此行很重要
	             column.setWidth(width+myTable.getIntercellSpacing().width);
	         }
	    }
	    public Class<?> getColumnClass(int columnIndex){
	    	if(columnIndex==0){
	    		return Icon.class;
	    	} else {
	    		return String.class;
	    	}
	    }
	    
	    //TODO
	    private class RowRenderer extends DefaultTableCellRenderer {
			private static final long serialVersionUID = 1L;

			public Component getTableCellRendererComponent(JTable t, Object value,
	                    boolean isSelected, boolean hasFocus, int row, int column) {
				super.getTableCellRendererComponent(t, value, isSelected,
	                    hasFocus, row, column);
				//TODO picture test
				if(value instanceof Icon){
					this.setIcon((Icon) value);					
				} else if (value instanceof String){
					setText((String) value);
				} else {
					this.setText("");
				}
				
	            //设置奇偶行的背景色，可在此根据需要进行修改
	            if (row % 2 == 0)
	                this.setBackground(new Color(0,191,255));
	            else
	                this.setBackground(new Color(95, 158, 160));
	   
	            return this;
	        }
	    }
	    //TODO
	    private class RowColorRenderer extends DefaultTableCellRenderer 
	    {
	        /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public Component getTableCellRendererComponent(JTable t, Object value,
	                    boolean isSelected, boolean hasFocus, int row, int column) 
	        {
	            //分支判断条件可根据需要进行修改
	            if (color[row].trim().equals("E")) 
	            {
	                setBackground(Color.RED);
	            } 
	            else if (color[row].trim().equals("H")) 
	            {
	                setBackground(Color.CYAN);
	            } 
	            else if (color[row].trim().equals("A")) 
	            {
	                setBackground(Color.BLUE);
	            } 
	            else if (color[row].trim().equals("F")) 
	            {
	                setBackground(Color.ORANGE);
	            } 
	            else 
	            {
	                setBackground(Color.WHITE);
	            }
	   
	            return super.getTableCellRendererComponent(t, value, isSelected,
	                    hasFocus, row, column);
	        }
	    }
}
