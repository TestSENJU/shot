package vo;

public class PlayerPersonalInfoVO {
	String name;// 球员姓名
	String jerseyNum;// 球衣号码
	String height;// 身高
	String weight;// 体重
	String birthday;// 生日
	String age;// 年龄
	String lengthOfPlayer;// 球龄
	String graduateSchool;// 毕业学校

	public PlayerPersonalInfoVO(String name, String jerseyNum, String height,
			String weight, String birthday, String age, String lengthOfPlayer,
			String graduateSchool) {
		this.name = name;
		this.jerseyNum = jerseyNum;
		this.height = height;
		this.weight = weight;
		this.birthday = birthday;
		this.age = age;
		this.lengthOfPlayer = lengthOfPlayer;
		this.graduateSchool = graduateSchool;
	}
	
	public PlayerPersonalInfoVO(){}
	
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}

	public String getJerseyNum() {
		return jerseyNum;
	}

	public void setJerseyNum(String jerseyNum) {
		this.jerseyNum = jerseyNum;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getLengthOfPlayer() {
		return lengthOfPlayer;
	}

	public void setLengthOfPlayer(String lengthOfPlayer) {
		this.lengthOfPlayer = lengthOfPlayer;
	}

	public String getGraduateSchool() {
		return graduateSchool;
	}

	public void setGraduateSchool(String graduateSchool) {
		this.graduateSchool = graduateSchool;
	}
	
}
