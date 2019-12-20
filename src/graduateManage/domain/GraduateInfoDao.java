package graduateManage.domain;
import graduateManage.ui.*;

public class GraduateInfoDao {
	/**
	 查看个人信息
	 * @param ID
	 * @throws InterruptedException
	 */
	public static void check_info(String ID) throws InterruptedException {
		String keyboard;
		System.out.print("姓名：");
		System.out.println(Login.init.graduateList.get(ID).getUsername());
		System.out.print("性别：");
		System.out.println(Login.init.graduExtraList.get(ID).getSex());
		System.out.print("学号：");
		System.out.println(Login.init.graduateList.get(ID).getID());
		System.out.print("联系方式：");
		System.out.println(Login.init.graduateList.get(ID).getPhoneNumber());
		System.out.print("原所属学院：");
		System.out.println(Login.init.graduExtraList.get(ID).getInstitute());	
		System.out.println("按【0】返回上一级");
		while(true) { // 若输入其他字符，则重新输入，或按0退出循环
			keyboard = Login.in.next();
			if(keyboard.equals("0")) {
				GraduateInfo.info_page(ID);
				break;
			}else {
				System.out.println("您的输入有误，请再输一次");
			}
		}
	}
	/**
	 编辑个人信息
	 * @param ID
	 * @throws InterruptedException
	 */
	public static void modify_info(String ID) throws InterruptedException {
		String keyboard;
		String opwd;
		String npwd;
		String confirm;
		boolean isContinue = true;
		System.out.println("请选择您要编辑的信息：");
		System.out.println("1.密码");
		System.out.println("2.联系方式");
		System.out.println("0.返回上一级");
		keyboard = Login.in.next();
		if(keyboard.equals("1")) {
			System.out.println("当前位置是：学生操作界面→编辑个人信息→【修改密码】");
			System.out.println(Login.init.graduateList.get(ID).getUsername());
			System.out.println("请输入您的原密码（默认密码为123/输入【q】取消修改）：");
			opwd = Login.in.next();
			if(opwd.equals("q")) {
				modify_info(ID);
			}
			while(true) {
				if(opwd.length()<=1||!opwd.equals(Login.init.graduateList.get(ID).getPwd())) { // 检查密码是否合法
					System.out.println("原密码不正确,请再输一次,或按【q】返回上一级");
					opwd = Login.in.next();
					if(opwd.equals("q")) {
						modify_info(ID);
					}
				}else {
					break;
				}
			}
			System.out.println("请输入新密码：");
			npwd = Login.in.next();
			Login.init.graduateList.get(ID).setPwd(npwd);
			System.out.println("修改成功！");
			Thread.sleep(800);
			modify_info(ID);
		}else if(keyboard.equals("2")) {
			System.out.println("当前位置是：学生操作界面→编辑个人信息→【修改联系方式】");
			String nphoneNum;
			System.out.println(Login.init.graduateList.get(ID).getUsername());
			System.out.println("您当前的联系方式是：");
			System.out.println(Login.init.graduateList.get(ID).getPhoneNumber());
			System.out.println("是否确认修改？<Y/N>");
			while(true) {
				confirm = Login.in.next();
				if(confirm.equals("n")||confirm.equals("N")) {
					isContinue = false;
					break;
				}else if(!confirm.equals("Y")&&!confirm.equals("y")) {
					System.out.println("您输入了非法字符，请重新输入！");
				}else {
					break;
				}
			}
			if(!isContinue) {
				modify_info(ID);
			}
			System.out.println("请输入您的新联系方式（输入【q】取消修改）：");
			nphoneNum = Login.in.next();
			if(nphoneNum.equals("q")) {
				modify_info(ID);
			}
			while(true) {
				if(nphoneNum.length()<=3||!nphoneNum.matches("^[0-9]*$")) {
					System.out.println("您输入的电话号码不合法，请再输一次，或按【0】返回上一级");
					nphoneNum = Login.in.next();
					if(nphoneNum.equals("0")) {
						modify_info(ID);
					}else if(nphoneNum.length()>3&&(nphoneNum.matches("^[0-9]*$"))){
						Login.init.graduateList.get(ID).setPhoneNumber(nphoneNum);
						break;
					}
				}else {
					Login.init.graduateList.get(ID).setPhoneNumber(nphoneNum);
					break;
				}
			}
			
			System.out.println("修改成功！");
			Thread.sleep(800);
			modify_info(ID);
			
		}else if(keyboard.equals("0")){
			GraduateInfo.info_page(ID);
		}else {
			System.out.println("您输入了非法字符，请重新输入！");
			modify_info(ID);
		}
	
	}
	/**
	 查看个人就业信息
	 * @param ID
	 * @throws InterruptedException
	 */
	public static void check_em_info(String ID) throws InterruptedException {
		String keyboard;
		System.out.println("姓名：");
		System.out.println(Login.init.graduateList.get(ID).getUsername()+"\n");
		if(Login.init.employList.containsKey(ID)) {
			System.out.println("您现在的就业状态为【从业】");
			System.out.print("公司：");
			System.out.println(Login.init.employList.get(ID).getCompanyName()+"\n");
			System.out.print("岗位：");
			System.out.println(Login.init.employList.get(ID).getPosition()+"\n");
		}else if(Login.init.unemployList.containsKey(ID)){
			System.out.println("您现在的就业状态为【待业】");
			System.out.print("所在地：");
			System.out.println(Login.init.unemployList.get(ID).getPlace()+"\n");
		}else if(Login.init.postgraList.containsKey(ID)) {
			System.out.println("您现在的就业状态为【研究生】");
			System.out.print("深造学校：");
			System.out.println(Login.init.postgraList.get(ID).getFurtherSchool()+"\n");
		}else {
			System.err.println("您尚未登记就业信息,请登记就业信息");
			Thread.sleep(1000);
			register_em_info(ID);
		}
		System.out.println("按【0】返回上一级");
		while(true) { // 若输入其他字符，则重新输入，或按0退出循环
			keyboard = Login.in.next();
			if(keyboard.equals("0")) {
				GraduateInfo.info_page(ID);
				break;
			}else {
				System.out.println("您的输入有误，请再输一次");
			}
		}
	}
	/**
	 编辑个人就业信息
	 * @param ID
	 * @throws InterruptedException
	 */
	public static void modify_em_info(String ID) throws InterruptedException{
		
		String keyboard;
		String status;
		System.out.println(Login.init.graduateList.get(ID).getUsername());
		if(Login.init.employList.containsKey(ID)) {
			System.out.println("您现在的就业状态为【从业】");
			System.out.print("公司：");
			System.out.println(Login.init.employList.get(ID).getCompanyName());
			System.out.print("岗位：");
			System.out.println(Login.init.employList.get(ID).getPosition());
		}else if(Login.init.unemployList.containsKey(ID)){
			System.out.println("您现在的就业状态为【待业】");
			System.out.print("所在地：");
			System.out.println(Login.init.unemployList.get(ID).getPlace());
		}else if(Login.init.postgraList.containsKey(ID)) {
			System.out.println("您现在的就业状态为【研究生】");
			System.out.print("深造学校：");
			System.out.println(Login.init.postgraList.get(ID).getFurtherSchool());
		}else {
			System.err.println("您尚未登记就业信息,请登记就业信息");
			Thread.sleep(1000);
			register_em_info(ID);
		}
		System.out.println("您确定要修改吗？<Y/N>");
		while(true) {
			keyboard = Login.in.next();
			if(keyboard.equals("Y")||keyboard.equals("y")) {
				System.out.println("请选择您现在的从业状态：");
				System.out.println("1.待业");
				System.out.println("2.从业（创业或就业）");
				System.out.println("3.研究生");
				System.out.println("0.返回上一级");
				status = Login.in.next();
				while(true) {
					if(status.equals("1")) {
						System.out.println("请输入您的所在地：");
						String place = Login.in.next();
						if(Login.init.unemployList.containsKey(ID)) {
							Login.init.unemployList.get(ID).setPlace(place);
						}else {
							Login.init.add_unemployed(ID, place);
						}
						System.out.println("修改成功！");
						Thread.sleep(800);
						GraduateInfo.info_page(ID);
						break;
					}else if(status.equals("2")) {
						System.out.println("请输入您的公司名称：");
						String comN = Login.in.next();
						System.out.println("请输入您的职位");
						String pos = Login.in.next();
						if(Login.init.employList.containsKey(ID)) {
							Login.init.employList.get(ID).setCompanyName(comN);
							Login.init.employList.get(ID).setPosition(pos);
						}else {
							Login.init.add_employed(ID, pos, comN);
						}
						System.out.println("修改成功！");
						Thread.sleep(800);
						GraduateInfo.info_page(ID);
						break;
					}else if(status.equals("3")) {
						System.out.println("请输入您的学校名称");
						String schN = Login.in.next();
						if(Login.init.postgraList.containsKey(ID)) {
							Login.init.postgraList.get(ID).setFurtherSchool(schN);
							
						}else {
							Login.init.add_postgraduate(ID, schN);
						}
						System.out.println("修改成功！");
						Thread.sleep(800);
						GraduateInfo.info_page(ID);
						break;
					}else if(status.equals("0")) {
						GraduateInfo.info_page(ID);
						break;
					}else {
						System.out.println("您输入了非法字符，请重新输入：");
						status = Login.in.next();
					}
				}
				break;
			}else if(keyboard.equals("N")||keyboard.equals("n")) {
				GraduateInfo.info_page(ID);
				break;
			}else {
				System.out.println("您的输入有误，请重新输入：");
			}
		}
		
	}
	/**
	 登记就业信息
	 * @param ID
	 * @throws InterruptedException
	 */
	public static void register_em_info(String ID) throws InterruptedException {
		String status;
		System.out.println("请选择您现在的从业状态：");
		System.out.println("1.待业");
		System.out.println("2.从业（创业或就业）");
		System.out.println("3.研究生");
		System.out.println("0.返回上一级");
		status = Login.in.next();
		while(true) {
			if(status.equals("1")) {
				System.out.println("请输入您的所在地：");
				String place = Login.in.next();
				Login.init.add_unemployed(ID, place);
				System.out.println("已保存！");
				Thread.sleep(1000);
				break;
			}else if(status.equals("2")) {
				System.out.println("请输入您的公司名称：");
				String comN = Login.in.next();
				System.out.println("请输入您的职位");
				String pos = Login.in.next();
				Login.init.add_employed(ID, pos, comN);
				System.out.println("已保存！");
				Thread.sleep(1000);
				break;
			}else if(status.equals("3")) {
				System.out.println("请输入您的学校名称");
				String schN = Login.in.next();
				Login.init.add_postgraduate(ID, schN);
				System.out.println("已保存！");
				Thread.sleep(1000);
				break;
			}else if(status.equals("0")) {
				GraduateInfo.info_page(ID);
				break;
			}else {
				System.err.println("您输入了非法字符，请重新输入：");
				status = Login.in.next();
			}
		}
		GraduateInfo.info_page(ID);
	}
}
