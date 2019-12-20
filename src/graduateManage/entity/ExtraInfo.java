package graduateManage.entity;
/**
 * 毕业生的其他信息类
 * @author chl
 */
public class ExtraInfo {
	private String institute = ""; // 毕业生的原属学院
	private String sex = ""; // 毕业生性别
	private String yearOfGradu = ""; // 毕业年份
	public ExtraInfo (){
	}
	public ExtraInfo(String studentID, String institute, String sex,String yearOfGradu) {
		this.institute=institute;
		this.sex = sex;
		this.yearOfGradu = yearOfGradu;
	}
	public String getInstitute() {
		return institute;
	}
	public void setInstitute(String institute) {
		this.institute = institute;
	}
	public String getSex() {
		return sex;
	}
	public String getYearOfGradu() {
		return yearOfGradu;
	}
	public void setYearOfGradu(String yearOfGradu) {
		this.yearOfGradu = yearOfGradu;
	}
	
}
