package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import sound.PlayWave;
import ui.statistic.StatisticPanel;

public class MyDialog implements Runnable, MouseListener, MouseMotionListener {

	/** serialVersionUID */
	public static final long serialVersionUID = 1L;
	//protected DialogPanel dPanel;
	/** 窗体透明值 */
	protected float hyalineValue = 0f;
	protected DialogWindow dialog = null;
	//protected DataAnalyse dataAnalyse = null;
	protected JButton sure;
	protected JButton cancel;
	protected JLabel choose;
	protected JRadioButton ascend;
	protected JRadioButton descend;
	private ButtonGroup group;

	public MyDialog () {
	}
	
	
	public DialogWindow init (int width, int height, DialogPanel dPanel) {
		/*dPanel = new DialogPanel(AllImages.IMG_DIALOG_BG);
		dPanel.setLayout(null);
		dPanel.setSize(width, height);
		dPanel.setDragable();
		// 设置panel为透明
		dPanel.setOpaque(false);
		// 设置布局管理为绝对布局
		dPanel.setLayout(null);
		// 注册鼠标监听器
		dPanel.addMouseListener(this);
		// 注册鼠标移动监听器
		dPanel.addMouseMotionListener(this);*/
		//new Thread(dPanel).start();
		
/*		//TODO
		choose = new JLabel();
		choose.setOpaque(false);
		choose.setText("请选择升序 or 降序：");
		choose.setBounds(30, 50, 200, 30);
		choose.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		choose.setForeground(Color.WHITE);
		dPanel.add(choose, 0);
		
		ascend = new JRadioButton("升序", AllImages.IMG_RIGHT_RADIO, true);
		ascend.setBounds(60, 80, 80, 25);
		ascend.setOpaque(false);
		ascend.setForeground(Color.WHITE);
		ascend.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		ascend.addItemListener(new ItemListener());
		dPanel.add(ascend, 0);
		
		descend = new JRadioButton("降序",AllImages.IMG_FALSE_RADIO, false);
		descend.setBounds(180, 80, 80, 25);
		descend.setForeground(Color.WHITE);
		descend.setOpaque(false);
		descend.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		descend.addItemListener(new ItemListener());
		dPanel.add(descend, 0);
		
		group = new ButtonGroup();
		group.add(ascend);
		group.add(descend);
		
		sure = new JButton();
		sure.setBounds(80, 150, 80, 40);
		sure.setContentAreaFilled(false);
		sure.setBorderPainted(false);
		sure.setOpaque(false);
		sure.setIcon(AllImages.IMG_SURE);
		sure.addMouseListener(new SureListener());
		dPanel.add(sure, 0);
		
		cancel = new JButton();
		cancel.setBounds(200, 150, 80, 30);
		cancel.setContentAreaFilled(false);
		cancel.setBorderPainted(false);
		cancel.setIcon(AllImages.IMG_CANCEL);
		cancel.setOpaque(false);
		cancel.addMouseListener(new CancelListener());
		dPanel.add(cancel, 0);*/
		
		dialog = new DialogWindow();
		dialog.add(dPanel, 0);
		return dialog;
	}
	

	/**
	 * @author cylong
	 * @version May 24, 2014 6:05:56 PM
	 */
	public void run () {
		while (true) {
			Sleep.sleep(20);
			//dPanel.repaint();
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
		public int maxWidth = 400;
		public int height = 300;

		public DialogWindow () {
			this.setUndecorated(true);
			this.setLayout(null);
			this.setLocationRelativeTo(Controller.f);
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
