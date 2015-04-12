package ui;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;

public class MyFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	private Point lastPosition;
//	private int fx,fy;//实时坐标位置
	private Point origin;

	public MyFrame(int width,int height) {
		this.init(width,height);
	}
	
	private void init(int width,int height) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		this.setLayout(null); 
		this.setResizable(false);
		this.setSize(width, height);
		this.setLocation(screenSize.width/2-width/2,screenSize.height/2-height/2);
		
/*		this.lastPosition = this.getLocation();
		this.addComponentListener(new ComponentAdapter() {
			public void componentMoved(ComponentEvent e) {
				Component c = e.getComponent();
				c.setLocation(lastPosition);
			}
		});*/
		this.origin=new Point();
		
		 //由于取消了默认的窗体结构，所以我们要手动设置一下移动窗体的方法
		  this.addMouseListener( 
		        new MouseAdapter(){
		          public void mousePressed(MouseEvent e){
		            origin.x = e.getX();
		            origin.y = e.getY();
		          }
		          //窗体上单击鼠标右键关闭程序
		          public void mouseClicked(MouseEvent e) {
		            if(e.getButton()==MouseEvent.BUTTON3)
		              System.exit(0);
		          }
		          public void mouseReleased(MouseEvent e) {
		            super.mouseReleased(e);
		          }
		          @Override
		          public void mouseEntered(MouseEvent e) {
		            repaint();              
		          }            
		        }
		    );

		    addMouseMotionListener(
		        new MouseMotionAdapter(){
		          public void mouseDragged(MouseEvent e){
		            Point p = getLocation();
		          //  fx=p.x + e.getX() - origin.x;
		           // fy=p.y + e.getY() - origin.y;
		            setLocation(p.x + e.getX() - origin.x, p.y + e.getY() - origin.y );
		          }          
		        }
		    );  
	}
}
