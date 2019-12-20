package graduateManage.entity;
/**
 * @author chl
 */
public class Admin extends Individual{
	/**
	 * 管理员类的构造方法
	 * @param username 管理员姓名
	 * @param ID 管理员学工号
	 * @param pwd 管理员密码
	 * @param phoneNumber 管理员联系方式
	 */
	public Admin(String username, String ID, String pwd,String phoneNumber) {
		super(username,ID,pwd,phoneNumber);
	}
	public Admin() {
	}
}
