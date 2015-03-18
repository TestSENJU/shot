package data.player;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileReaderForTeams {
private String path;
public FileReaderForTeams(String pathName){
	this.path=pathName;
}
@SuppressWarnings("resource")
public String getTeamArea(String teamName){
	String result="";
BufferedReader br;
	try {
		br = new BufferedReader(
					new InputStreamReader(new FileInputStream(path)));
		 String str;
		try {
			while((str=br.readLine())!=null){
				  if(str.contains(teamName)){
					  String strs[]=str.split("│");
//					  if(strs[3]+"-"+strs[4]==null){System.out.print(1);}
					  result= strs[3]+"-"+strs[4];
					 
				  }
			   }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.print("io");
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		System.out.print("filenotfound");
	}
	return result;
}
}