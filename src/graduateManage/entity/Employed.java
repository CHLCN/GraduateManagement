package graduateManage.entity;
/**
 * 已就业的毕业生类，毕业生就业状态之一
 * @author chl
 */
public class Employed extends CurrentStatus{
	private String position=null; //公司职位
	private String companyName=null; // 公司名称
	
	public Employed() {
	}
	public Employed(String studentID, String position, String companyName) {
		this.position = position;
		this.companyName = companyName;
		
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	
	
}
