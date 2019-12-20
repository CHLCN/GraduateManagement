package graduateManage.ui;

import graduateManage.domain.GraduateInfoDao;
/**
 * 毕业生的选择操作界面
 * @author chl
 */
public class GraduateInfo {
	/**
	 * 毕业生选择操作
	 * @param ID 毕业生的学工号
	 * @throws InterruptedException
	 */
	public static void info_page(String ID) throws InterruptedException {
		
		System.out.println("*****************************************************************************");
		System.out.println("当前界面是【学生操作界面】");
		System.out.println("请选择要进行的操作：");
		System.out.println("1.查看个人信息");
		System.out.println("2.编辑个人信息");
		System.out.println("3.查看个人就业信息");
		System.out.println("4.编辑个人就业信息");
		System.out.println("0.返回登录界面");
		System.out.println("按【e】直接退出系统");
		String choice = Login.in.next();
		switch(choice) {
		case "1":
			System.out.println("*****************************************************************************");
			System.out.println("当前位置是：学生操作界面→【查看个人信息】");
			GraduateInfoDao.check_info(ID);
			break;
		case "2":
			System.out.println("*****************************************************************************");
			System.out.println("当前位置是：学生操作界面→【编辑个人信息】");
			GraduateInfoDao.modify_info(ID);
			break;
		case "3":
			System.out.println("*****************************************************************************");
			System.out.println("当前位置是：学生操作界面→【查看个人就业信息】");
			GraduateInfoDao.check_em_info(ID);
			break;
		case "4":
			System.out.println("*****************************************************************************");
			System.out.println("当前位置是：学生操作界面→【编辑个人就业信息】");
			GraduateInfoDao.modify_em_info(ID);
			break;
		case "0":
			Login.welcome();
			break;
		case "e":
			Login.exit();
		case "E":
			Login.exit();
		default:
			System.out.println("您的输入有误，请重新选择");
			Thread.sleep(800);
			info_page(ID); // 若输入有误，则重新载入此页
		}
	}
	
}
