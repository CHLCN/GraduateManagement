package graduateManage.entity;
/**
 * 待业的毕业生类，毕业生就业状态之一
 * @author lenovo
 */
public class Unemployed extends CurrentStatus{
	private String place=null; // 所在省份
	
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
