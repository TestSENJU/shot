package vo;

import po.TeamBasicPO;

public class TeamBasicVO {
	//球队缩写名
	String teamName;
	//球队曾用缩写名
	private String usedName;
	//球队全名
	private String longName;
    //球队曾用全名
	private String usedLongName;
	/*
	 *  * 0球队全名
 * 1所在地
 * 2 赛区
 * 3分区
 * 4主场
 * 5建立时间
	 */
	private String teamInfo[]=new String[6];
	
	public TeamBasicVO(String name){
		this.teamName=name;
	}
    public String getTeamName() {
		return teamName;
	}
	public TeamBasicVO(TeamBasicPO po){
    	this.teamName=po.getTeamName();
    	this.usedName=po.getUsedName();
    	this.usedLongName=po.getUsedLongName();
    	this.longName=po.getLongName();
    	this.teamInfo=po.getTeamInfo();
    }
	public String getUsedName() {
		return usedName;
	}

	public void setUsedName(String usedName) {
		this.usedName = usedName;
	}

	public String getLongName() {
		return longName;
	}

	public void setLongName(String longName) {
		this.longName = longName;
	}

	public String getUsedLongName() {
		return usedLongName;
	}

	public void setUsedLongName(String usedLongName) {
		this.usedLongName = usedLongName;
	}

	public String[] getTeamInfo() {
		return teamInfo;
	}

	public void setTeamInfo(String[] teamInfo) {
		this.teamInfo = teamInfo;
	}
	
}
