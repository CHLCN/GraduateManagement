package graduateManage.domain;

import java.util.Map.Entry;

import graduateManage.entity.Employed;
import graduateManage.entity.Postgraduate;
import graduateManage.entity.Unemployed;
import graduateManage.ui.AdminOpt;
import graduateManage.ui.Login;
/**
  管理员操作的具体实现
 * @author chl
 */
public class AdminOptDao {
	/**
	 添加毕业生
	 * @param ID
	 * @throws InterruptedException
	 */
	public static void add_graduate(String ID) throws InterruptedException {
		String num;
		String name;
		String studentID;
		String sex;
		String gender;
		String pwd = "123"; // 默认密码
		String phoneNumber;
		String institute;
		String yearOfGradu;
		String keyboard;
		boolean isContinue = true;
		
		System.out.println("请输入您要添加的账号个数（单次添加上限为5个/或按【q】退出）");
		num = Login.in.next();
		while(true) {
			if(num.equals("q")) { // 输入q退出
				AdminOpt.operate_page(ID);
			}
			if(!Character.isDigit(num.charAt(0))) { // 检测输入内容是否为数字
				System.out.println("您的输入有误，请重新输入（或按【q】退出）！");
			}else {
				if(Integer.parseInt(num)>5) { // 检测输入数字是否超限
					System.out.println("您要添加的账号个数超限！单次添加上限为5个，请重新输入（或按【q】退出）：");
				}else {
					break;
				}
			}
			num = Login.in.next(); // 循环输入
		}
		for(int i = 0; i < Integer.parseInt(num); i++) {
			while(true) {
				System.out.println("请输入您要添加的毕业生的学号：");
				while(true) {
					studentID = Login.in.next();
					if(studentID.toCharArray()[0]=='1'||!studentID.matches("^[0-9]*$")) { // 检测账号是否合法，毕业生账号不可以1开头
						System.out.println("此账号非法，请重新输入（毕业生账号不可以1开头）");
					}else {
						break;
					}
				}
				if(Login.init.graduateList.containsKey(studentID)) { // 检测系统中是否存在该毕业生
					System.out.println("该毕业生已存在，请重新输入：");
				}else {
					break;
				}
			}

			System.out.println("请输入您要添加的毕业生的姓名：");
			name = Login.in.next();
			System.out.println("请输入您要添加的毕业生所在的学院：");
			institute = Login.in.next();
			System.out.println("请选择您要添加的毕业生的性别：");
			System.out.println("1.【女】");
			System.out.println("2.【男】");
			while(true) {
				gender = Login.in.next();
				if(gender.equals("1")) {
					sex = "女";
					break;
				}else if(gender.equals("2")) {
					sex = "男";
					break;
				}else {
					System.out.println("您输入了非法字符，请重新输入：");
				}
			}
			System.out.println("请输入您要添加的毕业生的联系方式：");
			while(true) {
				phoneNumber = Login.in.next();
				if(phoneNumber.length()<3||!phoneNumber.matches("^[0-9]*$")) { // 检测电话号码是否合法
					System.out.println("此号码不合法，请输入正确的电话号码");
				}else {
					break;
				}
			}
			System.out.println("请输入您要添加的毕业生的毕业年份：");
			while(true) { // 检测输入年份是否合法
				yearOfGradu = Login.in.next();
				if(!yearOfGradu.matches("^[0-9]*$")||(yearOfGradu.length()!=4)||yearOfGradu.toCharArray()[0]!='2') {
					System.out.println("您的输入不合法，请重新输入年份！");
				}else {
					break;
				}
			}
			
			Login.init.add_graduate(studentID, name, pwd, phoneNumber, institute, sex, yearOfGradu);
			// 将新的毕业生信息加入系统
			System.out.println("添加成功！");
			Thread.sleep(800);
			if(i<Integer.parseInt(num)-1) {
				// 当添加多个学生时，每添加一个，可选择终止
				System.out.println("是否继续添加<Y/N>?");	
				while(true) {
					keyboard = Login.in.next();
					if(keyboard.equals("Y")||keyboard.equals("y")) {
						break;
					}
					else if(!keyboard.equals("N")&&!keyboard.equals("n")) { // 检测是否输入非法字符
						System.out.println("您输入了非法字符，请重新输入！");
					}else {
						isContinue = false;
						break;
					}
				}
				if(!isContinue) {
					break;
				}
			}
				
		}
		
	}
	/**
	  删除毕业生
	 * @param ID
	 * @throws InterruptedException
	 */
	public static void del_graduate(String ID) throws InterruptedException {
		String num;
		String studentID;
		String keyboard;
		boolean isContinue = true;
		
		System.out.println("请输入您要删除的账号个数（单次添加上限为5个/或按【q】退出）");
		num = Login.in.next();
		
		while(true) {
			if(num.equals("q")) {
				AdminOpt.operate_page(ID);
			}else if(!Character.isDigit(num.charAt(0))) {
				System.out.println("您的输入有误，请重新输入（或按【q】退出）！");
			}else {
				if(Integer.parseInt(num)>5) {
					System.out.println("您要删除的账号个数超限！单词添加上限为5个，请重新输入（或按【q】退出）：");
				}else {
					break;
				}
			}
			num = Login.in.next();
		}
		for(int i = 0; i < Integer.parseInt(num); i++) {
			while(true) {
				System.out.println("请输入您要删除的毕业生的学号：");
				while(true) {
					studentID = Login.in.next();
					if(studentID.toCharArray()[0]=='1'||!studentID.matches("^[0-9]*$")) { // 检测账号否全为数字
						System.out.println("此账号非法，请重新输入");
					}else {
						break;
					}
				}
				if(!Login.init.graduateList.containsKey(studentID)) {
					System.out.println("该毕业生账号不存在，请重新输入：");
				}else {
					break;
				}
			}
			Login.init.graduateList.remove(studentID); // 删除毕业生个人信息
			Login.init.graduExtraList.remove(studentID); // 删除毕业生其他信息
			if(Login.init.employList.containsKey(studentID)) // 删除毕业生就业信息
				Login.init.employList.remove(studentID);
			if(Login.init.postgraList.containsKey(studentID))
				Login.init.postgraList.remove(studentID);
			if(Login.init.unemployList.containsKey(studentID))
				Login.init.unemployList.remove(studentID);
			
			System.out.println("删除成功！");
			Thread.sleep(800);
			if(i<Integer.parseInt(num)-1) {
				System.out.println("是否继续删除<Y/N>?");	
				while(true) {
					keyboard = Login.in.next();
					if(keyboard.equals("Y")||keyboard.equals("y")) {
						break;
					}
					else if(!keyboard.equals("N")&&!keyboard.equals("n")) {
						System.out.println("您输入了非法字符，请重新输入！");
					}else {
						isContinue = false;
						break;
					}
				}
				if(!isContinue) {
					break;
				}
			}
				
		}
		
	}
	/**
	 查询毕业生所有信息
	 * @param ID
	 * @throws InterruptedException
	 */
	public static void check_gradu_info(String ID) throws InterruptedException {
		String studentID;
		String keyboard;
		System.out.println("请输入您要查询的毕业生的学号（或按【q】退出）：");
		while(true) {
			studentID = Login.in.next();
			if(studentID.contains("q")) {
				AdminOpt.operate_page(ID);
			}
			if(studentID.toCharArray()[0]=='1'||!studentID.matches("^[0-9]*$")) {
				System.out.println("此账号非法，请重新输入，或按【q】退出");
			
			}else if(!Login.init.graduateList.containsKey(studentID)) {
				System.out.println("该毕业生账号不存在，请重新输入，或按【q】退出：");
			}else {
				break;
			}
		}
		System.out.print("姓名：");
		System.out.println(Login.init.graduateList.get(studentID).getUsername());
		System.out.print("性别：");
		System.out.println(Login.init.graduExtraList.get(studentID).getSex());
		System.out.print("学号：");
		System.out.println(Login.init.graduateList.get(studentID).getID());
		System.out.print("联系方式：");
		System.out.println(Login.init.graduateList.get(studentID).getPhoneNumber());
		System.out.print("原所属学院：");
		System.out.println(Login.init.graduExtraList.get(studentID).getInstitute());
		if(Login.init.employList.containsKey(studentID)) {
			System.out.println("就业状态【从业】");
			System.out.print("公司：");
			System.out.println(Login.init.employList.get(studentID).getCompanyName());
			System.out.print("岗位：");
			System.out.println(Login.init.employList.get(studentID).getPosition());
		}else if(Login.init.unemployList.containsKey(studentID)){
			System.out.println("就业状态【待业】");
			System.out.print("所在地：");
			System.out.println(Login.init.unemployList.get(studentID).getPlace());
		}else if(Login.init.postgraList.containsKey(studentID)) {
			System.out.println("就业状态【研究生】");
			System.out.print("深造学校：");
			System.out.println(Login.init.postgraList.get(studentID).getFurtherSchool());
		}else {
			System.out.println("尚未登记就业信息");
		}
		System.out.println("按【0】返回上一级");
		while(true) { // 若输入其他字符，则重新输入，或按0退出循环
			keyboard = Login.in.next();
			if(keyboard.equals("0")) {
				AdminOpt.operate_page(ID);
				break;
			}else {
				System.out.println("您的输入有误，请再输一次");
			}
		}
	
	}
	/**
	  修改毕业生的其他信息（如原属学院/毕业年份）
	 * @param ID
	 * @throws InterruptedException
	 */
	public static void modify_gradu_info(String ID) throws InterruptedException{
		String keyboard;
		String yearOfGradu;
		String institute;
		String studentID;
		String confirm;
		boolean isContinue = true;
		System.out.println("请输入您要编辑的毕业生学号（或按【q】退出）");
		while(true) {
			studentID = Login.in.next();
			if(studentID.equals("q")) {
				AdminOpt.operate_page(ID);
			}
			if(!Login.init.graduateList.containsKey(studentID))
				System.out.println("您输入的账号不存在，请重新输入，或按【q】退出");
			else
				break;
		}
		while(true) {
			System.out.println("您选择编辑的毕业生是:"+"【"+Login.init.graduateList.get(studentID).getUsername()+"】");
			System.out.println("请选择您要编辑的信息：");
			System.out.println("1.毕业年份");
			System.out.println("2.原属学院");
			System.out.println("按【0】返回上一级");
			keyboard = Login.in.next();
			if(keyboard.equals("1")) {
				System.out.println("当前位置是：管理员操作界面→编辑毕业生信息→【修改毕业年份】");
				System.out.println("当前毕业生的毕业年份是：");
				System.out.println(Login.init.graduExtraList.get(studentID).getYearOfGradu());
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
					continue;
				}
				System.out.println("请输入修改后的毕业年份：");
				while(true) { // 检测输入年份是否合法
					yearOfGradu = Login.in.next();
					if(!yearOfGradu.matches("^[0-9]*$")) {
						System.out.println("您的输入不合法，请重新输入年份！");
					}else {
						break;
					}
				}
				Login.init.graduExtraList.get(studentID).setYearOfGradu(yearOfGradu);
				System.out.println("修改成功！");
				Thread.sleep(800);
				continue;
				
			}else if(keyboard.equals("2")) {
				System.out.println("当前位置是：管理员操作界面→编辑毕业生信息→【修改原属学院】");
				System.out.println("当前毕业生的所属学院为：");
				System.out.println(Login.init.graduExtraList.get(studentID).getInstitute());
				System.out.println("是否确认修改？<Y/N>");
				while(true) {
					isContinue = true;
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
					continue;
				}
				System.out.println("请输入修改后的学院名称：");
				institute = Login.in.next();
				Login.init.graduExtraList.get(studentID).setInstitute(institute);
				System.out.println("修改成功！");
				Thread.sleep(800);
				continue;
			}else {
				AdminOpt.operate_page(ID);
			}
		}
	}
	/**
	 修改管理员的个人信息
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
			System.out.println("当前位置是：管理员操作界面→编辑个人信息→【修改密码】");
			System.out.println(Login.init.adminList.get(ID).getUsername());
			System.out.println("请输入您的原密码（默认密码为123/输入【q】取消修改）");
			opwd = Login.in.next();
			if(opwd.equals("q")) {
				modify_info(ID);
			}
			while(true) {
				if(opwd.length()<=1||!opwd.equals(Login.init.adminList.get(ID).getPwd())) {
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
			Login.init.adminList.get(ID).setPwd(npwd);
			System.out.println("修改成功！");
			Thread.sleep(800);
			modify_info(ID);
		}else if(keyboard.equals("2")) {
			System.out.println("当前位置是：管理员操作界面→编辑个人信息→【修改联系方式】");
			String nphoneNum;
			System.out.println(Login.init.adminList.get(ID).getUsername());
			System.out.println("您当前的联系方式是：");
			System.out.println(Login.init.adminList.get(ID).getPhoneNumber());
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
			System.out.println("请输入您的新联系方式：");
			
			while(true) {
				nphoneNum = Login.in.next();
				if(nphoneNum.length()<=3||!nphoneNum.matches("^[0-9]*$")) {
					System.out.println("您输入的电话号码不合法，请再输一次，或按【0】返回上一级");
					if(nphoneNum.equals("0")) {
						modify_info(ID);
					}else if(nphoneNum.length()>3&&(nphoneNum.matches("^[0-9]*$"))){
						Login.init.adminList.get(ID).setPhoneNumber(nphoneNum);
						break;
					}
				}else {
					Login.init.adminList.get(ID).setPhoneNumber(nphoneNum);
					break;
				}
			}
			
			System.out.println("修改成功！");
			Thread.sleep(800);
			modify_info(ID);
			
		}else if(keyboard.equals("0")){
			AdminOpt.operate_page(ID);
		}else {
			System.out.println("您输入了非法字符，请重新输入！");
			modify_info(ID);
		}
	}
	/**
	 查看所有毕业生的就业信息
	 * @param ID
	 * @throws InterruptedException
	 */
	public static void check_total_info(String ID) throws InterruptedException {
		String keyboard;
		System.out.println("当前位置是：管理员操作界面→【信息管理平台】");
		System.out.println("请选择您要进行的操作:");
		System.out.println("1.按就业状态查看就业信息");
		System.out.println("2.按性别查看就业信息");
		System.out.println("0.返回上一级");
		keyboard = Login.in.next();
		switch(keyboard) {
		case "1":
			System.out.println("当前位置是：管理员操作界面→信息管理平台→【查看信息（按就业状态）】");
			System.out.println("以下为所有已登记毕业生的就业情况：");
			System.out.println("【创业/就业】");
			for(Entry<String, Employed> entry: Login.init.employList.entrySet()) {
				System.out.print(Login.init.graduateList.get(entry.getKey()).getID()+" ");
				System.out.println(Login.init.graduateList.get(entry.getKey()).getUsername());
				System.out.print("职位：");
				System.out.println(entry.getValue().getPosition());
				System.out.print("所属公司：");
				System.out.println(entry.getValue().getCompanyName());
			 }
			
			for(Entry<String, Unemployed> entry: Login.init.unemployList.entrySet()) {
				System.out.println("【待业】");
				System.out.print(Login.init.graduateList.get(entry.getKey()).getID()+" ");
				System.out.println(Login.init.graduateList.get(entry.getKey()).getUsername());
				System.out.print("所在省市：");
				System.out.println(entry.getValue().getPlace());
			 }
			
			for(Entry<String, Postgraduate> entry: Login.init.postgraList.entrySet()) {
				System.out.println("【研究生】");
				System.out.print(Login.init.graduateList.get(entry.getKey()).getID()+" ");
				System.out.println(Login.init.graduateList.get(entry.getKey()).getUsername());
				System.out.print("深造学校：");
				System.out.println(entry.getValue().getFurtherSchool());
			 }
			System.out.println("按【0】返回上一级");
			while(true) {
				keyboard = Login.in.next();
				if(keyboard.equals("0")) {
					check_total_info(ID);
					break;
				}else {
					System.out.println("您的输入有误，请再输一次");
				}
			}
			
			break;
		case "2":
			System.out.println("当前位置是：管理员操作界面→信息管理平台→【查看信息（按性别）】");
			System.out.println("以下为不同性别的就业情况分布：");
			
			System.out.println("【女】");
			for(Entry<String, Employed> entry: Login.init.employList.entrySet()) {
				if(Login.init.graduExtraList.get(entry.getKey()).getSex().equals("女")){
					System.out.print(Login.init.graduateList.get(entry.getKey()).getID()+" ");
					System.out.println(Login.init.graduateList.get(entry.getKey()).getUsername());
					System.out.print("职位：");
					System.out.println(entry.getValue().getPosition());
					System.out.print("所属公司：");
					System.out.println(entry.getValue().getCompanyName());
				}
			 }
			

			for(Entry<String, Unemployed> entry: Login.init.unemployList.entrySet()) {
				if(Login.init.graduExtraList.get(entry.getKey()).getSex().equals("女")) {
					System.out.print(Login.init.graduateList.get(entry.getKey()).getID()+" ");
					System.out.println(Login.init.graduateList.get(entry.getKey()).getUsername());
					System.out.print("所在省市：");
					System.out.println(entry.getValue().getPlace());
				}
			 }
			

			for(Entry<String, Postgraduate> entry: Login.init.postgraList.entrySet()) {
				if(Login.init.graduExtraList.get(entry.getKey()).getSex().equals("女")) {
					System.out.print(Login.init.graduateList.get(entry.getKey()).getID()+" ");
					System.out.println(Login.init.graduateList.get(entry.getKey()).getUsername());
					System.out.print("深造学校：");
					System.out.println(entry.getValue().getFurtherSchool());
				}
			 }
			
			System.out.println("【男】");
			for(Entry<String, Employed> entry: Login.init.employList.entrySet()) {
				if(Login.init.graduExtraList.get(entry.getKey()).getSex().equals("男")){
					System.out.print(Login.init.graduateList.get(entry.getKey()).getID()+" ");
					System.out.println(Login.init.graduateList.get(entry.getKey()).getUsername());
					System.out.print("职位：");
					System.out.println(entry.getValue().getPosition());
					System.out.print("所属公司：");
					System.out.println(entry.getValue().getCompanyName());
				}
			 }
			
			for(Entry<String, Unemployed> entry: Login.init.unemployList.entrySet()) {
				if(Login.init.graduExtraList.get(entry.getKey()).getSex().equals("男")) {
					System.out.print(Login.init.graduateList.get(entry.getKey()).getID()+" ");
					System.out.println(Login.init.graduateList.get(entry.getKey()).getUsername());
					System.out.print("所在省市：");
					System.out.println(entry.getValue().getPlace());
				}
			 }
			
			for(Entry<String, Postgraduate> entry: Login.init.postgraList.entrySet()) {
				if(Login.init.graduExtraList.get(entry.getKey()).getSex().equals("男")) {
					System.out.print(Login.init.graduateList.get(entry.getKey()).getID()+" ");
					System.out.println(Login.init.graduateList.get(entry.getKey()).getUsername());
					System.out.print("深造学校：");
					System.out.println(entry.getValue().getFurtherSchool());
				}
			 }
			System.out.println("按【0】返回上一级");
			while(true) {
				keyboard = Login.in.next();
				if(keyboard.equals("0")) {
					check_total_info(ID);
					break;
				}else {
					System.out.println("您的输入有误，请再输一次");
				}
			}
			break;
		case "0":
			AdminOpt.operate_page(ID);
			break;
		default:
			System.out.println("您的输入有误，请重新选择操作");
			Thread.sleep(1000);
			check_total_info(ID);
		}
		System.out.println("按【0】返回上一级");
		while(true) { // 若输入其他字符，则重新输入，或按0退出循环
			keyboard = Login.in.next();
			if(keyboard.equals("0")) {
				AdminOpt.operate_page(ID);
				break;
			}else {
				System.out.println("您的输入有误，请再输一次");
			}
		}
	}
}
