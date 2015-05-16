package launch;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Change extends Thread {

	public static void startChange() {
		new Change().start();
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				File file = new File("E:/test.txt");

				if (file.isFile() && file.exists()) {
					BufferedWriter bw = new BufferedWriter(new FileWriter(file));
					bw.write("0");
					bw.close();
				} else {
					file.createNewFile();
				}
			} catch (Exception e) {
				System.out.println("写入文件内容操作出错！");
				e.printStackTrace();
			}
		}
	}
}
