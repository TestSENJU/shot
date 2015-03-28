package data.player;

import java.io.EOFException;
import java.util.Hashtable;

import data.FileReadAndWriteBuffer;
import data.FileSerialization;
import po.Player_AllScorePO;
import po.Player_AverageScorePO;
import po.Player_BasicInfoPO;

public class PlayerData_Impl implements PlayerData{
	static Hashtable<String,Player_AverageScorePO> averScoreTable=new Hashtable<String,Player_AverageScorePO>();
	static Hashtable<String,Player_AllScorePO> allScoreTable=new Hashtable<String,Player_AllScorePO>();  
	static Hashtable<String,Player_BasicInfoPO> basicinfoTable=new Hashtable<String,Player_BasicInfoPO>(); 
	private static String playerAll_serialpath="serialization/playerAllScore";
	private static String playerAver_serialpath="serialization/playerAverageScore";
	private static String playerBasic_serialpath="serialization/playerBasicInfo";
	public static PlayerData_Impl pdi;

	public static synchronized PlayerData_Impl getInstance() {
		if (pdi == null)
			pdi = new PlayerData_Impl();
		return pdi;
	}
	public PlayerData_Impl(){
		@SuppressWarnings("unused")
		FileSerialization fs = FileSerialization.getInstance();
	}
	@SuppressWarnings("unchecked")
	@Override
	public Hashtable<String, Player_BasicInfoPO> getPlayerBasic() {
		// TODO Auto-generated method stub
		try {
			basicinfoTable = (Hashtable<String, Player_BasicInfoPO>) FileReadAndWriteBuffer
					.read_from_file(playerBasic_serialpath);
		} catch (EOFException e) {
			e.printStackTrace();
		}
		return basicinfoTable;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Hashtable<String, Player_AllScorePO> getPlayerAll() {
		// TODO Auto-generated method stub
		try {
			allScoreTable = (Hashtable<String, Player_AllScorePO>) FileReadAndWriteBuffer
					.read_from_file(playerAll_serialpath);
		} catch (EOFException e) {
			System.out.println("getPlayerAll ");
		}
		return allScoreTable;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Hashtable<String, Player_AverageScorePO> getPlayerAverage() {
		// TODO Auto-generated method stub
		try {
			averScoreTable = (Hashtable<String, Player_AverageScorePO>) FileReadAndWriteBuffer
					.read_from_file(playerAver_serialpath);
		} catch (EOFException e) {
			System.out.println("getPlayerAll ");
		}
		return averScoreTable;
	}

}