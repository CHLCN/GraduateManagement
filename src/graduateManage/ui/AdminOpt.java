package graduateManage.ui;

import java.util.Map.Entry;
import graduateManage.domain.AdminOptDao;
import graduateManage.entity.Graduate;
/**
 * 管理员操作界面
 * @author chl
 */
public class AdminOpt {
	/**
	  管理员选择操作
	 * @param ID 管理员学工号
	 * @throws InterruptedException
	 */
	public static void operate_page(String ID) throws InterruptedException {
		System.out.println("*****************************************************************************");
		System.out.println("当前界面是【管理员操作界面】");
		System.out.println("请选择要进行的操作：");
		System.out.println("1.增加毕业生账号");
		System.out.println("2.删除毕业生账号");
		System.out.println("3.编辑毕业生信息");
		System.out.println("4.查询毕业生信息");
		System.out.println("5.编辑个人信息");
		System.out.println("6.信息汇总平台");
		System.out.println("0.返回登录界面");
		System.out.println("按【e】直接退出系统");
		String choice = Login.in.next();
		switch(choice) {
		case "1":
			System.out.println("*****************************************************************************");
			System.out.println("当前位置是：管理员操作界面→【增加毕业生账号】");
			AdminOptDao.add_graduate(ID);
			break;
		case "2":
			System.out.println("*****************************************************************************");
			System.out.println("当前位置是：管理员操作界面→【删除毕业生账号】");
			AdminOptDao.del_graduate(ID);
			break;
		case "3":
			System.out.println("*****************************************************************************");
			System.out.println("当前位置是：管理员操作界面→【编辑毕业生信息】");
			AdminOptDao.modify_gradu_info(ID);
			break;
		case "4":
			System.out.println("*****************************************************************************");
			System.out.println("当前位置是：管理员操作界面→【查询毕业生信息】");
			for(Entry<String, Graduate> entry: Login.init.graduateList.entrySet()) { // 显示当前所有毕业生
				System.out.print(Login.init.graduateList.get(entry.getKey()).getID()+"."+
						Login.init.graduateList.get(entry.getKey()).getUsername()+" "
						);
			 }
			System.out.println();
			AdminOptDao.check_gradu_info(ID);
			break;
		case "5":
			System.out.println("*****************************************************************************");
			System.out.println("当前位置是：管理员操作界面→【编辑个人信息】");
			AdminOptDao.modify_info(ID);
			break;
		case "6":
			AdminOptDao.check_total_info(ID);
			break;
		case "0":
			Login.welcome();
			break;
		case "e":
			Login.exit();
		case "E":
			Login.exit();
		default:
			System.out.println("您的输入有误，请重新输入操作代码");
			Thread.sleep(1000);
			operate_page(ID); // 输入有误，则重新载入此页
		}
		operate_page(ID);
	}
	
}
