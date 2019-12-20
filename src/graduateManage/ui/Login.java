package graduateManage.ui;

import java.util.Scanner;
import graduateManage.util.Init;
import graduateManage.domain.*;
/**
 * 登录界面
 * @author chl
 */
public class Login {
	public static final Scanner in = new Scanner(System.in); // 公用输入
	static {
		init = new Init();
	}
	public static Init init; // 公用人员列表
	/**
	 * 检测登录人员身份并校验密码是否正确
	 * @throws InterruptedException 若程序中途非正常终止则抛出此异常
	 */
	public static void welcome() throws InterruptedException {
		final String ID;
		String pwd;
		System.out.println("\t\t\t欢迎来到毕业生管理系统");
		System.out.println("*****************************************************************************");
		System.out.println("\t\t\t请使用学工号登录");
		System.out.println("示例用户：");
		System.out.println("【管理员】");
		System.out.println("学工号：100/101");
		System.out.println("初始密码为：123");
		System.out.println("【毕业生】");
		System.out.println("学工号：001/002/003/004（已登记就业信息）/005（未登记就业信息）");
		System.out.println("初始密码为：123"+"\n");
		System.out.print("学工号（输入exit退出系统）：");
		ID = in.next();
		if(ID.equals("exit")) {
			exit();
		}
		if (!new LoginDao().ifExist(ID,init.graduateList,init.adminList)) {
			System.err.println("系统不存在此账号，请联系管理员添加用户！");
			welcome();
		}else {
			System.out.print("密码：");
			while(true) {
				pwd = in.next();
				if (new LoginDao().ifMatch_G(ID, pwd, init.graduateList)) {
					System.out.println("已检测到您的身份：【毕业生】");
					System.out.println("欢迎!"+init.graduateList.get(ID).getUsername());
					Thread.sleep(800); // 在欢迎界面停留0.8秒
					GraduateInfo.info_page(ID);
					break;
				}else if (new LoginDao().ifMatch_A(ID, pwd, init.adminList)) {
					System.out.println("已检测到您的身份：【管理员】");
					System.out.println("欢迎!"+init.adminList.get(ID).getUsername());
					Thread.sleep(800);
					AdminOpt.operate_page(ID);// 进入操作页面
					break;
				} else {
					System.out.println("密码不正确，请重新输入！");
				}
			}
		}
	}
	/**
	 * 退出界面
	 */
	public static void exit() {
		System.out.println("感谢您的使用!");
		System.out.println("*****************************************************************************");
		System.exit(0);
	}
}
