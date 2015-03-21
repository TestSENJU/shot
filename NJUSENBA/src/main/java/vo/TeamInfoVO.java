package vo;

public class TeamInfoVO {
	String teamFullName;// 球队全名
	String location;// 所在地
	String cluster;// 赛区
	String partition;// 分区
	String homeCourt;// 主场
	String settingTime;// 建立时间

	public TeamInfoVO(String teamFullName, String location, String cluster,
			String partition, String homeCourt, String settingTime) {
		this.teamFullName = teamFullName;
		this.location = location;
		this.cluster = cluster;
		this.partition = partition;
		this.homeCourt = homeCourt;
		this.settingTime = settingTime;
	}
	
	public TeamInfoVO(){}
	
	public String getTeamFullName(){
		return teamFullName;
	}
	public void setTeamFullName(String teamFullName){
		this.teamFullName = teamFullName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCluster() {
		return cluster;
	}

	public void setCluster(String cluster) {
		this.cluster = cluster;
	}

	public String getPartition() {
		return partition;
	}

	public void setPartition(String partition) {
		this.partition = partition;
	}

	public String getHomeCourt() {
		return homeCourt;
	}

	public void setHomeCourt(String homeCourt) {
		this.homeCourt = homeCourt;
	}

	public String getSettingTime() {
		return settingTime;
	}

	public void setSettingTime(String settingTime) {
		this.settingTime = settingTime;
	}
	
}
