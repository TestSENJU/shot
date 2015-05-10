package BL;


import java.util.ArrayList;

import vo.PlayerAllVO;
import Data.ReadFileThread;

public class playerBL_Drive {
public static void main(String args[]){	
	ReadFileThread rft=new ReadFileThread("D://newData");
	rft.start();

	PlayerBL playerbl=new PlayerBL_Impl();
	ArrayList<Integer> nums=new ArrayList<Integer>();
	nums.add(11);
	nums.add(1);
	ArrayList<PlayerAllVO>list=playerbl.getPlayerAllByMultipleConRaising("F", "E", "22",nums , 50);
//	ArrayList<PlayerShortVO> polist1=playerbl.getHotPlayerByNum(0);
//	ArrayList<PlayerShortVO> polist2=playerbl.getTodayHotPlayerByNum(0);
//	for(int i=0;i<polist1.size();i++){
//		System.out.println(polist1.get(i).getPlayerName()+polist1.get(i).getNum());
//	}
//	for(int i=0;i<polist2.size();i++){
	//	System.out.println(polist2.get(i).getPlayerName()+polist2.get(i).getNum());
//	}
//	for(int i=0;i<polist1.size();i++){
//		System.out.println(polist1.get(i).getNum());
//	}
//	for(int i=0;i<polist2.size();i++){
//		System.out.println(polist2.get(i).getNum());
//	}
}
}