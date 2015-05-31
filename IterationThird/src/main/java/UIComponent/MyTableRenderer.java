package UIComponent;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class MyTableRenderer implements TableCellRenderer{
	DefaultTableCellRenderer dtcr =new DefaultTableCellRenderer();
	public MyTableRenderer(){
super();
		}
	public Component getTableCellRendererComponent(JTable table, Object value,boolean isSelected, boolean hasFocus, int row, int column) {
		Component renderer =dtcr.getTableCellRendererComponent(table, value,isSelected, hasFocus, row, column);
		renderer.setBackground(MyColor.WHITE.getColor());
		return renderer;
		}
}
