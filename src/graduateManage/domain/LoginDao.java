package graduateManage.domain;

import java.util.HashMap;
import java.util.Map;
import graduateManage.entity.*;

public class LoginDao {
	/**
	 检查账号是否存在于系统中
	 * @param ID
	 * @param graduate
	 * @param admin
	 * @return
	 */
	public boolean ifExist(String ID,HashMap<String, Graduate> graduate,HashMap<String, Admin> admin) {
		if (!graduate.containsKey(ID) && !admin.containsKey(ID)) {
			return false;
		}
		return true;
	}
	/**
	 检查毕业生账号是否存在
	 * @param ID
	 * @param pwd
	 * @param obj
	 * @return
	 */
	public boolean ifMatch_G(String ID ,String pwd, HashMap<String, Graduate> obj) {
		 for(Map.Entry<String, Graduate> entry: obj.entrySet()) {
			 if (ID.equals(entry.getKey()) && pwd.equals(entry.getValue().getPwd())) {
				 
				 return true;
		     }
		 }
		 return false;
	}
	/**
	 检查管理员账号是否存在
	 * @param ID
	 * @param pwd
	 * @param obj
	 * @return
	 */
	public boolean ifMatch_A(String ID ,String pwd, HashMap<String, Admin> obj) {
		 for(Map.Entry<String, Admin> entry: obj.entrySet()) {
			 if (ID.equals(entry.getKey()) && pwd.equals(entry.getValue().getPwd())) {
				 
				 return true;
		     }
		 }
		 return false;
	}
}
