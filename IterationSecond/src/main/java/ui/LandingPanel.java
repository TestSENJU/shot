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
	
	
	public LandingPanel(String l) {
		this.setLayout(null);
		
		im = new ImageIcon(l);
		backGround = new JLabel(im);
		backGround.setBounds(0, 0, 900, 618);
		
		this.add(backGround,-1);
	}
	
	public void paintCompnent(Graphics g) {
		g.drawImage(im.getImage(), 0, 0, this);
		super.paintComponent(g);
	}
}
