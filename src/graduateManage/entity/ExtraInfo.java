package graduateManage.entity;
/**
 * ��ҵ����������Ϣ��
 * @author chl
 */
public class ExtraInfo {
	private String institute = ""; // ��ҵ����ԭ��ѧԺ
	private String sex = ""; // ��ҵ���Ա�
	private String yearOfGradu = ""; // ��ҵ���
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
