package graduateManage.entity;
/**
 * �о����࣬��Ϊ��ҵ���ľ�ҵ״̬֮һ
 * @author chl
 */
public class Postgraduate extends CurrentStatus{
	private String furtherSchool; // ����ѧУ
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
