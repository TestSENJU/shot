package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Read {
	public void readTxtFile(String filePath){
        try {
                String encoding="UTF-8";
                File file=new File(filePath);
                if(file.isFile() && file.exists()){ //判断文件是否存在
                    InputStreamReader read = new InputStreamReader(
                    new FileInputStream(file),encoding);//考虑到编码格式
                    BufferedReader bufferedReader = new BufferedReader(read);
                    String lineTxt = null;
                    while((lineTxt = bufferedReader.readLine()) != null){
                       System.out.println(lineTxt);
                       if (lineTxt.equals("0")) {
                    	   InitailizePanel.refresh.setIcon(AllImages.IMG_REFRESH);
                    	   InitailizePanel.land.repaint();
                    	   writeTxtFile();
                       } else {
                    	   InitailizePanel.refresh.setIcon(AllImages.IMG_REFRESH_RED);
                    	   InitailizePanel.land.repaint();
                       }
                    }
                    read.close();
        }else{
            System.out.println("找不到指定的文件");
        }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
     
    }
	public void writeTxtFile(){
		try {
			File file = new File("E:/test.txt");

			if (file.isFile() && file.exists()) {
				BufferedWriter bw = new BufferedWriter(new FileWriter(file));
				bw.write("1");
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
