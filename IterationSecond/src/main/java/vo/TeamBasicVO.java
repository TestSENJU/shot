package vo;

import po.TeamBasicPO;

public class TeamBasicVO {
	String teamName;
	private String usedName;
	private String longName;

	private String usedLongName;
	private String teamInfo[]=new String[6];
	
	public TeamBasicVO(String name){
		this.teamName=name;
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
