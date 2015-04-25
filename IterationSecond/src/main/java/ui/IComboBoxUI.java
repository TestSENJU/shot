package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;

public class IComboBoxUI extends BasicComboBoxUI {

	private JButton arrow;
	private boolean boundsLight = false;
	private static final int ARCWIDTH = 15;
	private static final int ARCHEIGHT = 15;

	public IComboBoxUI() {
		super();
	}

	protected JButton createArrowButton() {
		arrow = new JButton();
		arrow.setIcon(AllImages.IMG_COMBO);//XUtil.defaultComboBoxArrowIcon
		arrow.setRolloverEnabled(true);
		arrow.setRolloverIcon(AllImages.IMG_COMBO);//XUtil.defaultComboBoxArrowIcon_Into
		arrow.setBorder(null);
		arrow.setBackground(Color.BLUE);//XUtil.defaultComboBoxColor
		arrow.setOpaque(false);
		arrow.setContentAreaFilled(false);
		return arrow;
	}

	public void paint(Graphics g, JComponent c) {
		hasFocus = comboBox.hasFocus();
		Graphics2D g2 = (Graphics2D) g;
		if (!comboBox.isEditable()) {
			Rectangle r = rectangleForCurrentValue();
			paintCurrentValueBackground(g2, r, hasFocus);
			paintCurrentValue(g2, r, hasFocus);
		}

		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		int width = (int) this.getPreferredSize(c).getWidth()
				+ arrow.getWidth() - 2;
		int height = 0;
		int heightOffset = 0;
		if (comboBox.isPopupVisible()) {
			heightOffset = 5;
			height = (int) this.getPreferredSize(c).getHeight();
			arrow.setIcon(AllImages.IMG_COMBO);//XUtil.defaultComboBoxArrowIcon_Into
		} else {
			heightOffset = 0;
			height = (int) this.getPreferredSize(c).getHeight() - 1;
			arrow.setIcon(AllImages.IMG_COMBO);//XUtil.defaultComboBoxArrowIcon
		}
		if (comboBox.isFocusable()) {
			//g2.setColor(Color.WHITE);
			g2.setColor(new Color(1, 1, 1, 0.8f));
		}
		g2.drawRoundRect(0, 0, width, height + heightOffset, ARCWIDTH,
				ARCHEIGHT);
	}

	public void paintCurrentValue(Graphics g, Rectangle bounds, boolean hasFocus) {
		Font oldFont = comboBox.getFont();
		comboBox.setFont(new Font("微软雅黑", Font.PLAIN, 12));//TODO XUtil.defaultComboBoxFont

		super.paintCurrentValue(g, bounds, hasFocus);
		comboBox.setFont(oldFont);
	}

	public Dimension getPreferredSize(JComponent c) {
		return super.getPreferredSize(c);
	}

	public boolean isBoundsLight() {
		return boundsLight;
	}

	public void setBoundsLight(boolean boundsLight) {
		this.boundsLight = boundsLight;
	}

	protected ComboPopup createPopup() {
		ComboPopup popup = new BasicComboPopup(comboBox) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			protected JScrollPane createScroller() {
				/*String lookAndFeel = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
				try {
					UIManager.setLookAndFeel(lookAndFeel);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (UnsupportedLookAndFeelException e) {
					e.printStackTrace();
				}*/
				JScrollPane sp = new JScrollPane(list,
						ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
						ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				sp.setHorizontalScrollBar(null);//IScrollPane to JScrollPane
				return sp;
			}

			// 
			public void paintBorder(Graphics g) {
				Graphics2D g2 = (Graphics2D) g;
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
						RenderingHints.VALUE_ANTIALIAS_ON);
				//g2.setColor(new Color(150, 207, 254));
				g2.setColor(Color.BLACK);
				g2.drawRoundRect(0, -arrow.getHeight(), getWidth() - 1,
						getHeight() + arrow.getHeight() - 1, 0, 0);
			}
		};
		return popup;
	}
}
