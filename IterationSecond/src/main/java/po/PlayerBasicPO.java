package po;
/**
 * 
 * @author wyt
 * 
 *@param playerName
 *   球员姓名
 *@param team
 *   当前球员所属队伍
 * @param basicInfo
 * 0 Number
 * 1 Position
 * 2 height
 * 3 weight
 * 4 birth
 * 5 age
 * 6 exp
 * 7 school
 * @category
 * 初始值不管是字符串还是数字全是0
 */
public class PlayerBasicPO {

	String playerName;
	private String[] basicInfo=new String[8];//球员基本信息，可以从player文件夹中读取的内容
	
	public PlayerBasicPO(String Name){
		this.playerName=Name;
		for(int i=0;i<this.basicInfo.length;i++){
			this.basicInfo[i]="0";
		}
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String[] getBasicInfo() {
		return basicInfo;
	}
	public void setBasicInfo(String[] basicInfo) {
		this.basicInfo = basicInfo;
	}
    
}
