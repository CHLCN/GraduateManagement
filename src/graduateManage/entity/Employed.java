package graduateManage.entity;
/**
 * �Ѿ�ҵ�ı�ҵ���࣬��ҵ����ҵ״̬֮һ
 * @author chl
 */
public class Employed extends CurrentStatus{
	private String position=null; //��˾ְλ
	private String companyName=null; // ��˾����
	
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
