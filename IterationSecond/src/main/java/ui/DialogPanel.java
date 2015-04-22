package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DialogPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon im;
	private JLabel backGround;
	
	
	public DialogPanel(ImageIcon im) {
		this.setLayout(null);
		
		//im = new ImageIcon(l);
		backGround = new JLabel(im);
		backGround.setBounds(0, 0, 400, 300);
		
		this.add(backGround,-1);
	}
	
	public void paintCompnent(Graphics g) {
		g.drawImage(im.getImage(), 0, 0, this);
		//g.drawImage(im.getImage(), this.getSize().width,this.getSize().height,this);
		super.paintComponent(g);
	}

		protected Point loc = null;
	protected Point tmp = null;
	protected boolean isDragged = false;

	/**
	 * 设置可以拖动窗体
	 */
	protected void setDragable () {
		this.addMouseListener(new MouseAdapter() {

			public void mouseReleased (java.awt.event.MouseEvent e) {
				isDragged = false;
			}

			public void mousePressed (java.awt.event.MouseEvent e) {
				//tmp = new Point(e.getX(), e.getY());
				//isDragged = true;
				isDragged = false;
			}

		});

		/*this.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {

			public void mouseDragged (java.awt.event.MouseEvent e) {
				if (isDragged) {
					loc = new Point(this.getLocation().x + e.getX() - tmp.x, this.getLocation().y + e.getY() - tmp.y);
					this.setLocation(loc);
				}
			}
		});*/
	}
	/**
	 * 画出数字方法，实际位数不足则用0代替
	 * 
	 * @param x
	 *            左上角x坐标
	 * @param y
	 *            左上角y坐标
	 * @param num
	 *            需要显示的数字
	 * @param maxBit
	 *            最大位数
	 * @param g
	 *            画笔
	 */
	public void drawNumber (int x, int y, int num, int maxBit, Image number, int w, int h, Graphics g) {
		String strNum = Integer.toString(num);
		for (int i = strNum.length(); i < maxBit; i++) {
			strNum = "0" + strNum;
		}
		for (int i = 0; i < strNum.length(); i++) {
			int index = strNum.length() - (maxBit - i);
			int bit = strNum.charAt(index) - '0';
			g.drawImage(number, x + w * i, y, x + w * (i + 1), y + h, bit * w, 0, (bit + 1) * w, h, null);
		}
	}
}