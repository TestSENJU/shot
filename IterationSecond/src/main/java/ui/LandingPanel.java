package ui;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LandingPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon im;
	private JLabel backGround;
	
	
	public LandingPanel(ImageIcon im) {
		this.setLayout(null);
		
		//im = new ImageIcon(l);
		backGround = new JLabel(im);
		backGround.setBounds(0, 0, 1000, 700);
		
		this.add(backGround,-1);
	}
	
	public void paintCompnent(Graphics g) {
		g.drawImage(im.getImage(), 0, 0, this);
		//g.drawImage(im.getImage(), this.getSize().width,this.getSize().height,this);
		super.paintComponent(g);
	}
}
