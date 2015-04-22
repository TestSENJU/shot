package countLine;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Count {
	public static void main(String[] args) throws FileNotFoundException {
		final String path = "src/main/java";
		final Count count = new Count(path);
		JFrame frame = new JFrame();
		frame.add(new JPanel() {

			private static final long serialVersionUID = 1L;

			public void paint(Graphics g) {
				g.setColor(new Color(0xd506fb));
				g.setFont(new Font("", Font.PLAIN, 30));
				g.drawString("codeSum: " + count.codeSum, 40, 60);
				g.drawString("blankSum: " + count.blankSum, 40, 110);
				g.drawString("commentSum: " + count.commentSum, 40, 160);
				g.drawString("Sum: " + (count.codeSum + count.blankSum + count.commentSum), 40, 210);
			}

		});
		frame.setTitle("count");
		frame.setSize(400, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	/** �������� */
	int codeSum = 0;
	/** �հ����� */
	int blankSum = 0;
	/** ע������ */
	int commentSum = 0;

	public Count(String filePath) {
		try {
			getAllLines(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public int getAllLines(String filePath) throws FileNotFoundException {
		try {
			File file = new File(filePath);
			if (file.isDirectory()) {// �ж��Ƿ����ļ���
				File[] codeFiles = file.listFiles();
				int s = codeFiles.length;
				for (int i = 0; i < s; i++) {
					getAllLines(codeFiles[i].getPath());
				}
			} else {
				if (file.getName().endsWith(".java")) {// �ж��Ƿ���java�ļ�
					// ���java�ļ�����
					System.out.println(file.getName());
					codeSum += getOneFileLines(file)[0];
					blankSum += getOneFileLines(file)[1];
					commentSum += getOneFileLines(file)[2];
				}
			}
		} catch (FileNotFoundException e4) {
			e4.printStackTrace();
		} catch (@SuppressWarnings("hiding") IOException e1) {
			e1.printStackTrace();
		}
		return codeSum;
	}

	public int[] getOneFileLines(File file) {
		int codeSum = 0;// ��������
		int blankSum = 0;// �հ�����
		int commentSum = 0;// ע������
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = br.readLine()) != null) {
				line = line.trim();
				if (line.matches("^[\\s&&[^\\n]]*$")) {
					blankSum++;
				} else if (line.startsWith("//")) {
					commentSum++;
				} else if (line.startsWith("/*")) {
					commentSum++;
				} else if (line.startsWith("*")) {
					commentSum++;
				} else if (line.endsWith("*/")) {
					commentSum++;
				} else {
					codeSum++;
				}
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new int[] { codeSum, blankSum, commentSum };
	}

}
