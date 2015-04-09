package ui;

import java.awt.Dimension;
//import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class MyFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	private Point lastPosition;

	public MyFrame(int width,int height) {
		this.init(width,height);
	}
	
	private void init(int width,int height) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		this.setLayout(null); 
		this.setResizable(false);
		this.setSize(width, height);
		this.setLocation(screenSize.width/2-width/2,screenSize.height/2-height/2);
		
//		this.lastPosition = this.getLocation();
/*		this.addComponentListener(new ComponentAdapter() {
			public void componentMoved(ComponentEvent e) {
				Component c = e.getComponent();
				c.setLocation(lastPosition);
			}
		});*/
		
	}
	
	
}
