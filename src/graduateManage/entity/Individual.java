package graduateManage.entity;
/**
 * 个人类，用于作为毕业生类和管理员类的基类
 * @author chl
 * @date 2019/12/3 22:20
 *
 */
public class Individual {
	protected String username;
	protected String ID;
	protected String pwd;
	protected String phoneNumber;

	public Individual(String username, String ID, String pwd ,String phoneNumber){
		this.username=username; // 用户名为真实姓名
		this.ID=ID;
		this.pwd=pwd;
		this.phoneNumber = phoneNumber;
	}
	public Individual() {
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
