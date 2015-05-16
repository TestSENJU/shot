package ui;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Write {
	public void writeTxtFile(){
		try {
			File file = new File("newFile.txt");

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
