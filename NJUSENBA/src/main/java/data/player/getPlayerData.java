package data.player;

import java.util.ArrayList;

import po.PlayerPO;

public interface getPlayerData {

	public PlayerPO getPlayer(String playerName);
	
	public ArrayList<PlayerPO> getAllPlayer();
	
	
}
