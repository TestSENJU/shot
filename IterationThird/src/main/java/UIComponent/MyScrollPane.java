package UIComponent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;
//��д��jscrollpane�������˰�ɫ�ı�����ɫ���������µĹ������������˱߿�,�������µ�corner
public class MyScrollPane extends JScrollPane{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MyScrollPane(MyTable table){
		super(table);
		init();
	}
	public MyScrollPane(){
		super();
		init();
	}
	public MyScrollPane(JPanel jp){
		super(jp);
		init();
	}
	public void init(){

		JScrollBar scroll=new JScrollBar();
		scroll.setUI(new MyScrollBarThinUI());
		this.setBorder(new MatteBorder(1,1,1,1,MyColor.GREY.getColor()));
		this.getViewport().setBackground(MyColor.WHITE.getColor());
		this.setVerticalScrollBar(scroll);//
		JLabel jl=new JLabel();
		jl.setBackground(MyColor.WHITE.getColor());
		jl.setOpaque(true);
		this.setCorner(UPPER_RIGHT_CORNER, jl);

	}

}
