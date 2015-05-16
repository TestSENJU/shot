package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class DateChooserJButton extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private DateChooser dateChooser = null;
	//private String preLabel = "";

	public DateChooserJButton() {
		this(getNowDate());
	}

	public DateChooserJButton(SimpleDateFormat df, String dateString) {
		this();
		setText(df, dateString);
	}

	public DateChooserJButton(Date date) {
		this("", date);
	}

	public DateChooserJButton(String preLabel, Date date) {
		/*if (preLabel != null)
			this.preLabel = preLabel;*/
		setDate(date);
		setBorder(null);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		super.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (dateChooser == null)
					try {
						dateChooser = new DateChooser();
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				Point p = getLocationOnScreen();
				p.y = p.y + 30;
				try {
					dateChooser.showDateChooser(p);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}

	private static Date getNowDate() {
		return Calendar.getInstance().getTime();
	}

	private static SimpleDateFormat getDefaultDateFormat() {
		return new SimpleDateFormat("yyyy-MM-dd"); //TODO change 按钮显示的日期格式
	}

	// 覆盖父类的方法
	public void setText(String s) {
		Date date;
		try {
			date = getDefaultDateFormat().parse(s);
		} catch (ParseException e) {
			date = getNowDate();
		}
		setDate(date);
	}

	public void setText(SimpleDateFormat df, String s) {
		Date date;
		try {
			date = df.parse(s);
		} catch (ParseException e) {
			date = getNowDate();
		}
		setDate(date);
	}

	public void setDate(Date date) {
		//super.setText(preLabel + getDefaultDateFormat().format(date));
		super.setText(getDefaultDateFormat().format(date));
	}

	public String getDate() {
		return getText();
	}

	// 覆盖父类的方法使之无效
	public void addActionListener(ActionListener listener) {
	}

	private class DateChooser extends JPanel implements ActionListener,
			ChangeListener {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		int startYear = 2000; // 默认【最小】显示年份
		int lastYear = 2015; // 默认【最大】显示年份
		int width = 400; // 界面宽度
		int height = 350; // 界面高度
		Color backGroundColor = Color.gray; // 底色
		// 月历表格配色----------------//
		Color palletTableColor = Color.WHITE; // 日历表底色
		Color todayBackColor = Color.RED; // 今天背景色
		Color dateFontColor = Color.black; // 日期文字色
		Color weekendFontColor = Color.DARK_GRAY; // 周末文字色
		// 控制条配色------------------//
		Color controlLineColor = Color.DARK_GRAY; // 控制条底色
		Color controlTextColor = Color.white; // 控制条标签文字色
		JDialog dialog;
		JButton closeDialog;
		JSpinner yearSpin;
		JSpinner monthSpin;
		JButton[][] daysButton = new JButton[6][7];

		DateChooser() throws ParseException {
			setLayout(new BorderLayout());
			setBorder(new LineBorder(backGroundColor, 2));
			setBackground(backGroundColor);
			JPanel topYearAndMonth = createYearAndMonthPanal();
			add(topYearAndMonth, BorderLayout.NORTH);
			JPanel centerWeekAndDay = createWeekAndDayPanal();
			add(centerWeekAndDay, BorderLayout.CENTER);
		}

		private JPanel createYearAndMonthPanal() throws ParseException {
			Calendar c = getCalendar();
			int currentYear = c.get(Calendar.YEAR);
			int currentMonth = c.get(Calendar.MONTH) + 1;
			JPanel result = new JPanel();
			result.setLayout(new FlowLayout());
			result.setBackground(controlLineColor);
			
			JLabel beginTime = new JLabel();
			beginTime.setText("开始时间");
			beginTime.setForeground(controlTextColor);
			beginTime.setFont(new Font("微软雅黑",Font.PLAIN, 13));
			result.add(beginTime);

			yearSpin = new JSpinner(new SpinnerNumberModel(currentYear,
					startYear, lastYear, 1));
			yearSpin.setPreferredSize(new Dimension(60, 30));
			yearSpin.setName("Year");
			yearSpin.setEditor(new JSpinner.NumberEditor(yearSpin, "####"));
			//yearSpin.setUI(new MySpinnerUI(yearSpin));
			yearSpin.addChangeListener(this);
			result.add(yearSpin);
			
			JLabel yearLabel = new JLabel("年");
			yearLabel.setForeground(controlTextColor);
			yearLabel.setFont(new Font("微软雅黑",Font.PLAIN, 13));
			yearLabel.setPreferredSize(new Dimension(30, 30));
			result.add(yearLabel);
			
			monthSpin = new JSpinner(new SpinnerNumberModel(currentMonth, 1,
					12, 1));
			monthSpin.setPreferredSize(new Dimension(50, 30));
			monthSpin.setName("Month");
			monthSpin.addChangeListener(this);
			result.add(monthSpin);
			
			JLabel monthLabel = new JLabel("月");
			monthLabel.setFont(new Font("微软雅黑",Font.PLAIN, 13));
			monthLabel.setForeground(controlTextColor);
			monthLabel.setPreferredSize(new Dimension(30, 30));
			result.add(monthLabel);
			
			closeDialog = new JButton();
			closeDialog.setOpaque(false);
			closeDialog.setContentAreaFilled(false);
			closeDialog.setBorderPainted(false);
			closeDialog.setIcon(AllImages.IMG_CLOSE);
			closeDialog.setPreferredSize(new Dimension(30, 30));
			closeDialog.addMouseListener(new CloseDialog());
			result.add(closeDialog);
			
			return result;
		}
		
		class CloseDialog implements MouseListener{
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				dialog.dispose();
			}
			public void mouseEntered(MouseEvent arg0) {
				closeDialog.setIcon(AllImages.IMG_CLOSE_RED);
			}
			public void mouseExited(MouseEvent arg0) {
				closeDialog.setIcon(AllImages.IMG_CLOSE);
			}
			public void mousePressed(MouseEvent arg0) {
			}
			public void mouseReleased(MouseEvent arg0) {
			}
		}
		private JPanel createWeekAndDayPanal() {
			String colname[] = { "日", "一", "二", "三", "四", "五", "六" };
			JPanel result = new JPanel();
			result.setLayout(new GridLayout(7, 7, 5, 5));
			result.setBackground(Color.GRAY);
			JLabel cell;
			for (int i = 0; i < 7; i++) {
				cell = new JLabel(colname[i]);
				cell.setFont(new Font("微软雅黑", Font.PLAIN, 13));
				cell.setHorizontalAlignment(JLabel.CENTER);
				if (i == 0 || i == 6)
					cell.setForeground(Color.WHITE);
				else
					cell.setForeground(Color.BLACK);
				result.add(cell);
			}
			int actionCommandId = 0;
			for (int i = 0; i < 6; i++)
				for (int j = 0; j < 7; j++) {
					JButton numberButton = new JButton();
					numberButton.setBorderPainted(false);
					numberButton.setHorizontalAlignment(SwingConstants.CENTER);
					numberButton.setActionCommand(String
							.valueOf(actionCommandId));
					numberButton.addActionListener(this);
					numberButton.setBackground(palletTableColor);
					numberButton.setFont(new Font("Arial", Font.PLAIN, 15));
					//numberButton.setSize(30, 30);//TODO
					numberButton.setForeground(dateFontColor);
					if (j == 0 || j == 6)
						numberButton.setForeground(weekendFontColor);
					else
						numberButton.setForeground(dateFontColor);
					daysButton[i][j] = numberButton;
					result.add(numberButton);
					actionCommandId++;
				}
			return result;
		}

		private JDialog createDialog(Frame owner) {
			JDialog result = new JDialog(owner, "日期时间选择", true);
			//result.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
			result.setUndecorated(true);
			result.getContentPane().add(this, BorderLayout.CENTER);
			result.setLocationRelativeTo(owner);
			result.pack();
			result.setSize(width, height);
			return result;
		}

		void showDateChooser(Point position) throws ParseException {
			Frame owner = (Frame) SwingUtilities
					.getWindowAncestor(DateChooserJButton.this);
			if (dialog == null || dialog.getOwner() != owner)
				dialog = createDialog(owner);
			dialog.setLocation(getAppropriateLocation(owner, position));
			flushWeekAndDay();
			dialog.setVisible(true);
			//TODO origin dialog.show();
		}

		Point getAppropriateLocation(Frame owner, Point position) {
			Point result = new Point(position);
			Point p = owner.getLocation();
			int offsetX = (position.x + width) - (p.x + owner.getWidth());
			int offsetY = (position.y + height) - (p.y + owner.getHeight());
			if (offsetX > 0) {
				result.x -= offsetX;
			}
			if (offsetY > 0) {
				result.y -= offsetY;
			}
			return result;
		}

		private Calendar getCalendar() throws ParseException {
			Calendar result = Calendar.getInstance();
			//result.setTime(getDate());
			result.setTime(getDefaultDateFormat().parse(getDate()));
			return result;
		}

		private int getSelectedYear() {
			return ((Integer) yearSpin.getValue()).intValue();
		}

		private int getSelectedMonth() {
			return ((Integer) monthSpin.getValue()).intValue();
		}

		private void dayColorUpdate(boolean isOldDay) throws ParseException {
			Calendar c = getCalendar();
			int day = c.get(Calendar.DAY_OF_MONTH);
			c.set(Calendar.DAY_OF_MONTH, 1);
			int actionCommandId = day - 2 + c.get(Calendar.DAY_OF_WEEK);
			int i = actionCommandId / 7;
			int j = actionCommandId % 7;
			if (isOldDay)
				daysButton[i][j].setForeground(dateFontColor);
			else
				daysButton[i][j].setForeground(todayBackColor);
		}

		private void flushWeekAndDay() throws ParseException {
			Calendar c = getCalendar();
			c.set(Calendar.DAY_OF_MONTH, 1);
			int maxDayNo = c.getActualMaximum(Calendar.DAY_OF_MONTH);
			int dayNo = 2 - c.get(Calendar.DAY_OF_WEEK);
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 7; j++) {
					String s = "";
					if (dayNo >= 1 && dayNo <= maxDayNo)
						s = String.valueOf(dayNo);
					daysButton[i][j].setText(s);
					dayNo++;
				}
			}
			dayColorUpdate(false);
		}

		public void stateChanged(ChangeEvent e) {
			JSpinner source = (JSpinner) e.getSource();
			Calendar c;
			try {
				c = getCalendar();
				dayColorUpdate(true);
				if (source.getName().equals("Year"))
					c.set(Calendar.YEAR, getSelectedYear());
				else
					// (source.getName().equals("Month"))
					c.set(Calendar.MONTH, getSelectedMonth() - 1);
				setDate(c.getTime());
				flushWeekAndDay();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}

		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton) e.getSource();
			if (source.getText().length() == 0)
				return;
			try {
				dayColorUpdate(true);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			source.setForeground(todayBackColor);
			int newDay = Integer.parseInt(source.getText());
			Calendar c;
			try {
				c = getCalendar();
				c.set(Calendar.DAY_OF_MONTH, newDay);
				setDate(c.getTime());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}		
		}
	}// end class DateChooser

	/*public static void main(String args[]) {
		DateChooserJButton d = new DateChooserJButton();
	}*/
}