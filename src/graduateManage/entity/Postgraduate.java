package graduateManage.entity;
/**
 * 研究生类，作为毕业生的就业状态之一
 * @author chl
 */
public class Postgraduate extends CurrentStatus{
	private String furtherSchool; // 深造学校
	public Postgraduate(){
	}
	public Postgraduate(String studentID,String furtherSchool) {
		this.furtherSchool = furtherSchool;
	}
	public String getFurtherSchool() {
		return furtherSchool;
	}
	public void setFurtherSchool(String furtherSchool) {
		this.furtherSchool = furtherSchool;
	}
	
}
