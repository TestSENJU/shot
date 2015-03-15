package po;


import java.util.Date;

public class PlayerPO {

	String name;//球员名称
	private String team;//当前球员所属队伍
	private String number;//球衣号码
	

	private String location;//球员位置
	private String area;//所属联盟
	private String height;//身高
	private int weight;//体重
	private int age;	//年龄
	private  int exp;//球龄
	private  String school;//毕业学校
	private  Date birth;//出生日期
	private int numOfFirstMatches;//先发场数
	private int numOfMatches;//参赛场数
	
	private Player_AllScorePO scoresInAll;//赛季总数据
	private Player_AverageScorePO scoresAverage;//平均数据
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public int getNumOfFirstMatches() {
		return numOfFirstMatches;
	}

	public void setNumOfFirstMatches(int numOfFirstMatches) {
		this.numOfFirstMatches = numOfFirstMatches;
	}

	public int getNumOfMatches() {
		return numOfMatches;
	}

	public void setNumOfMatches(int numOfMatches) {
		this.numOfMatches = numOfMatches;
	}

	public Player_AllScorePO getScoresInAll() {
		return scoresInAll;
	}

	public void setScoresInAll(Player_AllScorePO scoresInAll) {
		this.scoresInAll = scoresInAll;
	}


	public Player_AverageScorePO getScoresAverage() {
		return scoresAverage;
	}

	public void setScoresAverage(Player_AverageScorePO scoresAverage) {
		this.scoresAverage = scoresAverage;
	}
    
}
