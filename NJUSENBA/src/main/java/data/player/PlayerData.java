package data.player;

import java.util.Hashtable;

import po.Player_AllScorePO;
import po.Player_AverageScorePO;
import po.Player_BasicInfoPO;

public interface PlayerData {
	
	
    public Hashtable<String,Player_BasicInfoPO> getPlayerBasic();
    
    public Hashtable<String,Player_AllScorePO> getPlayerAll();
    
    public Hashtable<String,Player_AverageScorePO> getPlayerAverage();
    
}
