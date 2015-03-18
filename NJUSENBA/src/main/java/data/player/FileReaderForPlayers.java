package data.player;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class FileReaderForPlayers {
private String playerpath;
public FileReaderForPlayers(String pathname){
	this.playerpath=pathname;
}
@SuppressWarnings("resource")
public String[] getPlayerInfo(String playerName){
	String info[]=new String[9];
	String basicInfo[]=new String[8];
	int i=0;
	BufferedReader br;
	try {
		br = new BufferedReader(
				new InputStreamReader(new FileInputStream(playerpath+playerName),"UTF-8"));
		String str;
    	try {
			while((str=br.readLine())!=null){
				if(str.contains("│")){
					String strs[]=str.split("│");
					info[i]=(strs[1].substring(0, strs[1].length()-1));
					i++;
				}
			}
			
			for(int j=0;j<8;j++){
				basicInfo[j]=info[j+1];
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.print("ioexception");
		}
	} catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
	System.out.print("unspportedencoding");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		System.out.print("filenotfound");
	} 
	

	return basicInfo;
}
}
