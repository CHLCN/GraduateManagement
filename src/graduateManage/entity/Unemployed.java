package graduateManage.entity;
/**
 * ��ҵ�ı�ҵ���࣬��ҵ����ҵ״̬֮һ
 * @author lenovo
 */
public class Unemployed extends CurrentStatus{
	private String place=null; // ����ʡ��
	
	public Unemployed(){
	}
	public Unemployed(String studentID,String place){
		this.place = place;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	
	
	
}
