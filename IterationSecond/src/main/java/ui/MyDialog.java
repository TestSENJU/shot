package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JDialog;
import javax.swing.JPanel;

public class MyDialog extends JPanel implements Runnable, MouseListener, MouseMotionListener {

	/** serialVersionUID */
	public static final long serialVersionUID = 1L;
	/** 窗体透明值 */
	protected float hyalineValue = 0f;
	protected DialogWindow dialog = null;
	//protected DataAnalyse dataAnalyse = null;

	public MyDialog (int width, int height) {
		this.setLayout(null);
		this.setSize(width, height);
		this.setDragable();
		// 设置panel为透明
		this.setOpaque(false);
		// 设置布局管理为绝对布局
		this.setLayout(null);
		// 注册鼠标监听器
		this.addMouseListener(this);
		// 注册鼠标移动监听器
		this.addMouseMotionListener(this);
		new Thread(this).start();
		dialog = new DialogWindow();
		dialog.add(this);
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
				tmp = new Point(e.getX(), e.getY());
				isDragged = true;
			}

		});

		this.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {

			public void mouseDragged (java.awt.event.MouseEvent e) {
				if (isDragged) {
					loc = new Point(dialog.getLocation().x + e.getX() - tmp.x, dialog.getLocation().y + e.getY() - tmp.y);
					dialog.setLocation(loc);
				}
			}
		});
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

	/**
	 * @author cylong
	 * @version May 24, 2014 6:05:56 PM
	 */
	public void run () {
		while (true) {
			Sleep.sleep(20);
			this.repaint();
		}
	}

	/**
	 * @author cylong
	 * @version May 24, 2014 6:48:18 PM
	 */
	public void mouseDragged (MouseEvent e) {
	}

	public void mousePressed (MouseEvent e) {
	}

	public void mouseReleased (MouseEvent e) {
	}

	public void mouseEntered (MouseEvent e) {
	}

	public void mouseExited (MouseEvent e) {
	}

	public class DialogWindow extends JDialog {

		/** serialVersionUID */
		public static final long serialVersionUID = 1L;
		public int width = 0;
		public int maxWidth = MyDialog.this.getWidth();
		public int height = MyDialog.this.getHeight();

		public DialogWindow () {
			this.setUndecorated(true);
			this.setLayout(null);
			this.setLocationRelativeTo(null);
			this.setAlwaysOnTop(true);
			this.setVisible(true);
			new ExtendFrame().start();
			new HyalineValue().start();
		}

		/**
		 * 改变dialog的透明度
		 * 
		 * @author cylong
		 * @version 2014年6月7日 上午5:37:34
		 */
		private class HyalineValue extends Thread {

			public void run () {
				while (true) {
					Sleep.sleep(20);
					hyalineValue += 0.025f;
					if (hyalineValue > 1) {
						hyalineValue = 1;
					}
					setOpacity(hyalineValue);
					if (hyalineValue == 1) {
						break;
					}

				}
			}
		}

		public class ExtendFrame extends Thread {

			public void run () {
				while (true) {
					Sleep.sleep(10);
					if (width < maxWidth) {
						width += 10;
					} else {
						width = maxWidth;
					}
					DialogWindow.this.setSize(width, height);
					DialogWindow.this.setLocationRelativeTo(null);
					if (width == maxWidth) {
						break;
					}
				}
			}
		}

	}

	public void mouseMoved (MouseEvent e) {
	}

	public void mouseClicked (MouseEvent e) {
	}
}
