package BL;

import java.util.ArrayList;

import Data.ReadFileThread;
import vo.PlayerShortVO;

public class playerBL_Drive {
public static void main(String args[]){	
	ReadFileThread rft=new ReadFileThread("E://newData");
	rft.start();

	PlayerBL playerbl=new PlayerBL_Impl();
	ArrayList<PlayerShortVO> polist1=playerbl.getHotPlayerByNum(0);
	ArrayList<PlayerShortVO> polist2=playerbl.getTodayHotPlayerByNum(0);
//	for(int i=0;i<polist1.size();i++){
//		System.out.println(polist1.get(i).getPlayerName()+polist1.get(i).getNum());
//	}
	for(int i=0;i<polist2.size();i++){
		System.out.println(polist2.get(i).getPlayerName()+polist2.get(i).getNum());
	}
//	for(int i=0;i<polist1.size();i++){
//		System.out.println(polist1.get(i).getNum());
//	}
//	for(int i=0;i<polist2.size();i++){
//		System.out.println(polist2.get(i).getNum());
//	}
}
}