package BL;

import java.util.ArrayList;

import vo.PlayerAllVO;
import vo.PlayerAverageVO;
import vo.PlayerBasicVO;

public interface PlayerBL {

	public ArrayList<String> getPlayerNames();
	
	public ArrayList<String> getPlayerNamesByStr(String str);
	
	public ArrayList<PlayerAverageVO>getTodayHotPlayerRankingByNum(int num,String time);
	
	public ArrayList<PlayerAverageVO> getHotPlayerRankingByNum(int num);
	
	public ArrayList<PlayerAverageVO>getMostImprovedPlayerByNum(int num);
	
	public ArrayList<PlayerAllVO> getPlayerAll();
	
	public ArrayList<PlayerAverageVO> getPlayerAverage();
	
	public ArrayList<PlayerBasicVO> getPlayerBasic();
	
	public PlayerBasicVO getPlayerBasicByName(String name);
	
	public PlayerAllVO getPlayerAllByName(String name);
	
	public PlayerAverageVO getPlayerAverageByName(String name);
	
	public ArrayList<PlayerAllVO> getPlayerAllRankingByNum(int num);
	
	public ArrayList<PlayerAverageVO> getPlayerAvergaeRankingByNum(int num);
	
}
