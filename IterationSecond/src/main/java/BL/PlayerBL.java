package BL;

import java.util.ArrayList;

import po.PlayerAllPO;
import po.PlayerBasicPO;
import vo.PlayerAllVO;
import vo.PlayerAverageVO;

public interface PlayerBL {

	public ArrayList<String> getPlayerNames();
	
	public ArrayList<PlayerAllVO> getPlayerAll();
	
	public ArrayList<PlayerAverageVO> getPlayerAverage();
	
	public ArrayList<PlayerBasicPO> getPlayerBasic();
	
	public PlayerBasicPO getPlayerBasicByName(String name);
	
	public PlayerAllPO getPlayerAllByName(String name);
	
	public PlayerAverageVO getPlayerAverageByName(String name);
}
