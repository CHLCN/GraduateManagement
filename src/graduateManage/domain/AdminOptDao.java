package graduateManage.domain;

import java.util.Map.Entry;

import graduateManage.entity.Employed;
import graduateManage.entity.Postgraduate;
import graduateManage.entity.Unemployed;
import graduateManage.ui.AdminOpt;
import graduateManage.ui.Login;
/**
  ����Ա�����ľ���ʵ��
 * @author chl
 */
public class AdminOptDao {
	/**
	 ��ӱ�ҵ��
	 * @param ID
	 * @throws InterruptedException
	 */
	public static void add_graduate(String ID) throws InterruptedException {
		String num;
		String name;
		String studentID;
		String sex;
		String gender;
		String pwd = "123"; // Ĭ������
		String phoneNumber;
		String institute;
		String yearOfGradu;
		String keyboard;
		boolean isContinue = true;
		
		System.out.println("��������Ҫ��ӵ��˺Ÿ����������������Ϊ5��/�򰴡�q���˳���");
		num = Login.in.next();
		while(true) {
			if(num.equals("q")) { // ����q�˳�
				AdminOpt.operate_page(ID);
			}
			if(!Character.isDigit(num.charAt(0))) { // ������������Ƿ�Ϊ����
				System.out.println("���������������������루�򰴡�q���˳�����");
			}else {
				if(Integer.parseInt(num)>5) { // ������������Ƿ���
					System.out.println("��Ҫ��ӵ��˺Ÿ������ޣ������������Ϊ5�������������루�򰴡�q���˳�����");
				}else {
					break;
				}
			}
			num = Login.in.next(); // ѭ������
		}
		for(int i = 0; i < Integer.parseInt(num); i++) {
			while(true) {
				System.out.println("��������Ҫ��ӵı�ҵ����ѧ�ţ�");
				while(true) {
					studentID = Login.in.next();
					if(studentID.toCharArray()[0]=='1'||!studentID.matches("^[0-9]*$")) { // ����˺��Ƿ�Ϸ�����ҵ���˺Ų�����1��ͷ
						System.out.println("���˺ŷǷ������������루��ҵ���˺Ų�����1��ͷ��");
					}else {
						break;
					}
				}
				if(Login.init.graduateList.containsKey(studentID)) { // ���ϵͳ���Ƿ���ڸñ�ҵ��
					System.out.println("�ñ�ҵ���Ѵ��ڣ����������룺");
				}else {
					break;
				}
			}

			System.out.println("��������Ҫ��ӵı�ҵ����������");
			name = Login.in.next();
			System.out.println("��������Ҫ��ӵı�ҵ�����ڵ�ѧԺ��");
			institute = Login.in.next();
			System.out.println("��ѡ����Ҫ��ӵı�ҵ�����Ա�");
			System.out.println("1.��Ů��");
			System.out.println("2.���С�");
			while(true) {
				gender = Login.in.next();
				if(gender.equals("1")) {
					sex = "Ů";
					break;
				}else if(gender.equals("2")) {
					sex = "��";
					break;
				}else {
					System.out.println("�������˷Ƿ��ַ������������룺");
				}
			}
			System.out.println("��������Ҫ��ӵı�ҵ������ϵ��ʽ��");
			while(true) {
				phoneNumber = Login.in.next();
				if(phoneNumber.length()<3||!phoneNumber.matches("^[0-9]*$")) { // ���绰�����Ƿ�Ϸ�
					System.out.println("�˺��벻�Ϸ�����������ȷ�ĵ绰����");
				}else {
					break;
				}
			}
			System.out.println("��������Ҫ��ӵı�ҵ���ı�ҵ��ݣ�");
			while(true) { // �����������Ƿ�Ϸ�
				yearOfGradu = Login.in.next();
				if(!yearOfGradu.matches("^[0-9]*$")||(yearOfGradu.length()!=4)||yearOfGradu.toCharArray()[0]!='2') {
					System.out.println("�������벻�Ϸ���������������ݣ�");
				}else {
					break;
				}
			}
			
			Login.init.add_graduate(studentID, name, pwd, phoneNumber, institute, sex, yearOfGradu);
			// ���µı�ҵ����Ϣ����ϵͳ
			System.out.println("��ӳɹ���");
			Thread.sleep(800);
			if(i<Integer.parseInt(num)-1) {
				// ����Ӷ��ѧ��ʱ��ÿ���һ������ѡ����ֹ
				System.out.println("�Ƿ�������<Y/N>?");	
				while(true) {
					keyboard = Login.in.next();
					if(keyboard.equals("Y")||keyboard.equals("y")) {
						break;
					}
					else if(!keyboard.equals("N")&&!keyboard.equals("n")) { // ����Ƿ�����Ƿ��ַ�
						System.out.println("�������˷Ƿ��ַ������������룡");
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
	  ɾ����ҵ��
	 * @param ID
	 * @throws InterruptedException
	 */
	public static void del_graduate(String ID) throws InterruptedException {
		String num;
		String studentID;
		String keyboard;
		boolean isContinue = true;
		
		System.out.println("��������Ҫɾ�����˺Ÿ����������������Ϊ5��/�򰴡�q���˳���");
		num = Login.in.next();
		
		while(true) {
			if(num.equals("q")) {
				AdminOpt.operate_page(ID);
			}else if(!Character.isDigit(num.charAt(0))) {
				System.out.println("���������������������루�򰴡�q���˳�����");
			}else {
				if(Integer.parseInt(num)>5) {
					System.out.println("��Ҫɾ�����˺Ÿ������ޣ������������Ϊ5�������������루�򰴡�q���˳�����");
				}else {
					break;
				}
			}
			num = Login.in.next();
		}
		for(int i = 0; i < Integer.parseInt(num); i++) {
			while(true) {
				System.out.println("��������Ҫɾ���ı�ҵ����ѧ�ţ�");
				while(true) {
					studentID = Login.in.next();
					if(studentID.toCharArray()[0]=='1'||!studentID.matches("^[0-9]*$")) { // ����˺ŷ�ȫΪ����
						System.out.println("���˺ŷǷ�������������");
					}else {
						break;
					}
				}
				if(!Login.init.graduateList.containsKey(studentID)) {
					System.out.println("�ñ�ҵ���˺Ų����ڣ����������룺");
				}else {
					break;
				}
			}
			Login.init.graduateList.remove(studentID); // ɾ����ҵ��������Ϣ
			Login.init.graduExtraList.remove(studentID); // ɾ����ҵ��������Ϣ
			if(Login.init.employList.containsKey(studentID)) // ɾ����ҵ����ҵ��Ϣ
				Login.init.employList.remove(studentID);
			if(Login.init.postgraList.containsKey(studentID))
				Login.init.postgraList.remove(studentID);
			if(Login.init.unemployList.containsKey(studentID))
				Login.init.unemployList.remove(studentID);
			
			System.out.println("ɾ���ɹ���");
			Thread.sleep(800);
			if(i<Integer.parseInt(num)-1) {
				System.out.println("�Ƿ����ɾ��<Y/N>?");	
				while(true) {
					keyboard = Login.in.next();
					if(keyboard.equals("Y")||keyboard.equals("y")) {
						break;
					}
					else if(!keyboard.equals("N")&&!keyboard.equals("n")) {
						System.out.println("�������˷Ƿ��ַ������������룡");
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
	 ��ѯ��ҵ��������Ϣ
	 * @param ID
	 * @throws InterruptedException
	 */
	public static void check_gradu_info(String ID) throws InterruptedException {
		String studentID;
		String keyboard;
		System.out.println("��������Ҫ��ѯ�ı�ҵ����ѧ�ţ��򰴡�q���˳�����");
		while(true) {
			studentID = Login.in.next();
			if(studentID.contains("q")) {
				AdminOpt.operate_page(ID);
			}
			if(studentID.toCharArray()[0]=='1'||!studentID.matches("^[0-9]*$")) {
				System.out.println("���˺ŷǷ������������룬�򰴡�q���˳�");
			
			}else if(!Login.init.graduateList.containsKey(studentID)) {
				System.out.println("�ñ�ҵ���˺Ų����ڣ����������룬�򰴡�q���˳���");
			}else {
				break;
			}
		}
		System.out.print("������");
		System.out.println(Login.init.graduateList.get(studentID).getUsername());
		System.out.print("�Ա�");
		System.out.println(Login.init.graduExtraList.get(studentID).getSex());
		System.out.print("ѧ�ţ�");
		System.out.println(Login.init.graduateList.get(studentID).getID());
		System.out.print("��ϵ��ʽ��");
		System.out.println(Login.init.graduateList.get(studentID).getPhoneNumber());
		System.out.print("ԭ����ѧԺ��");
		System.out.println(Login.init.graduExtraList.get(studentID).getInstitute());
		if(Login.init.employList.containsKey(studentID)) {
			System.out.println("��ҵ״̬����ҵ��");
			System.out.print("��˾��");
			System.out.println(Login.init.employList.get(studentID).getCompanyName());
			System.out.print("��λ��");
			System.out.println(Login.init.employList.get(studentID).getPosition());
		}else if(Login.init.unemployList.containsKey(studentID)){
			System.out.println("��ҵ״̬����ҵ��");
			System.out.print("���ڵأ�");
			System.out.println(Login.init.unemployList.get(studentID).getPlace());
		}else if(Login.init.postgraList.containsKey(studentID)) {
			System.out.println("��ҵ״̬���о�����");
			System.out.print("����ѧУ��");
			System.out.println(Login.init.postgraList.get(studentID).getFurtherSchool());
		}else {
			System.out.println("��δ�ǼǾ�ҵ��Ϣ");
		}
		System.out.println("����0��������һ��");
		while(true) { // �����������ַ������������룬��0�˳�ѭ��
			keyboard = Login.in.next();
			if(keyboard.equals("0")) {
				AdminOpt.operate_page(ID);
				break;
			}else {
				System.out.println("������������������һ��");
			}
		}
	
	}
	/**
	  �޸ı�ҵ����������Ϣ����ԭ��ѧԺ/��ҵ��ݣ�
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
		System.out.println("��������Ҫ�༭�ı�ҵ��ѧ�ţ��򰴡�q���˳���");
		while(true) {
			studentID = Login.in.next();
			if(studentID.equals("q")) {
				AdminOpt.operate_page(ID);
			}
			if(!Login.init.graduateList.containsKey(studentID))
				System.out.println("��������˺Ų����ڣ����������룬�򰴡�q���˳�");
			else
				break;
		}
		while(true) {
			System.out.println("��ѡ��༭�ı�ҵ����:"+"��"+Login.init.graduateList.get(studentID).getUsername()+"��");
			System.out.println("��ѡ����Ҫ�༭����Ϣ��");
			System.out.println("1.��ҵ���");
			System.out.println("2.ԭ��ѧԺ");
			System.out.println("����0��������һ��");
			keyboard = Login.in.next();
			if(keyboard.equals("1")) {
				System.out.println("��ǰλ���ǣ�����Ա����������༭��ҵ����Ϣ�����޸ı�ҵ��ݡ�");
				System.out.println("��ǰ��ҵ���ı�ҵ����ǣ�");
				System.out.println(Login.init.graduExtraList.get(studentID).getYearOfGradu());
				System.out.println("�Ƿ�ȷ���޸ģ�<Y/N>");
				while(true) {
					confirm = Login.in.next();
					if(confirm.equals("n")||confirm.equals("N")) {
						isContinue = false;
						break;
					}else if(!confirm.equals("Y")&&!confirm.equals("y")) {
						System.out.println("�������˷Ƿ��ַ������������룡");
					}else {
						break;
					}
				}
				if(!isContinue) {
					continue;
				}
				System.out.println("�������޸ĺ�ı�ҵ��ݣ�");
				while(true) { // �����������Ƿ�Ϸ�
					yearOfGradu = Login.in.next();
					if(!yearOfGradu.matches("^[0-9]*$")) {
						System.out.println("�������벻�Ϸ���������������ݣ�");
					}else {
						break;
					}
				}
				Login.init.graduExtraList.get(studentID).setYearOfGradu(yearOfGradu);
				System.out.println("�޸ĳɹ���");
				Thread.sleep(800);
				continue;
				
			}else if(keyboard.equals("2")) {
				System.out.println("��ǰλ���ǣ�����Ա����������༭��ҵ����Ϣ�����޸�ԭ��ѧԺ��");
				System.out.println("��ǰ��ҵ��������ѧԺΪ��");
				System.out.println(Login.init.graduExtraList.get(studentID).getInstitute());
				System.out.println("�Ƿ�ȷ���޸ģ�<Y/N>");
				while(true) {
					isContinue = true;
					confirm = Login.in.next();
					if(confirm.equals("n")||confirm.equals("N")) {
						isContinue = false;
						break;
					}else if(!confirm.equals("Y")&&!confirm.equals("y")) {
						System.out.println("�������˷Ƿ��ַ������������룡");
					}else {
						break;
					}
				}
				if(!isContinue) {
					continue;
				}
				System.out.println("�������޸ĺ��ѧԺ���ƣ�");
				institute = Login.in.next();
				Login.init.graduExtraList.get(studentID).setInstitute(institute);
				System.out.println("�޸ĳɹ���");
				Thread.sleep(800);
				continue;
			}else {
				AdminOpt.operate_page(ID);
			}
		}
	}
	/**
	 �޸Ĺ���Ա�ĸ�����Ϣ
	 * @param ID
	 * @throws InterruptedException
	 */
	public static void modify_info(String ID) throws InterruptedException {
		String keyboard;
		String opwd;
		String npwd;
		String confirm;
		boolean isContinue = true;
		System.out.println("��ѡ����Ҫ�༭����Ϣ��");
		System.out.println("1.����");
		System.out.println("2.��ϵ��ʽ");
		System.out.println("0.������һ��");
		keyboard = Login.in.next();
		if(keyboard.equals("1")) {
			System.out.println("��ǰλ���ǣ�����Ա����������༭������Ϣ�����޸����롿");
			System.out.println(Login.init.adminList.get(ID).getUsername());
			System.out.println("����������ԭ���루Ĭ������Ϊ123/���롾q��ȡ���޸ģ�");
			opwd = Login.in.next();
			if(opwd.equals("q")) {
				modify_info(ID);
			}
			while(true) {
				if(opwd.length()<=1||!opwd.equals(Login.init.adminList.get(ID).getPwd())) {
					System.out.println("ԭ���벻��ȷ,������һ��,�򰴡�q��������һ��");
					opwd = Login.in.next();
					if(opwd.equals("q")) {
						modify_info(ID);
					}
				}else {
					break;
				}
			}
			System.out.println("�����������룺");
			npwd = Login.in.next();
			Login.init.adminList.get(ID).setPwd(npwd);
			System.out.println("�޸ĳɹ���");
			Thread.sleep(800);
			modify_info(ID);
		}else if(keyboard.equals("2")) {
			System.out.println("��ǰλ���ǣ�����Ա����������༭������Ϣ�����޸���ϵ��ʽ��");
			String nphoneNum;
			System.out.println(Login.init.adminList.get(ID).getUsername());
			System.out.println("����ǰ����ϵ��ʽ�ǣ�");
			System.out.println(Login.init.adminList.get(ID).getPhoneNumber());
			System.out.println("�Ƿ�ȷ���޸ģ�<Y/N>");
			while(true) {
				confirm = Login.in.next();
				if(confirm.equals("n")||confirm.equals("N")) {
					isContinue = false;
					break;
				}else if(!confirm.equals("Y")&&!confirm.equals("y")) {
					System.out.println("�������˷Ƿ��ַ������������룡");
				}else {
					break;
				}
			}
			if(!isContinue) {
				modify_info(ID);
			}
			System.out.println("��������������ϵ��ʽ��");
			
			while(true) {
				nphoneNum = Login.in.next();
				if(nphoneNum.length()<=3||!nphoneNum.matches("^[0-9]*$")) {
					System.out.println("������ĵ绰���벻�Ϸ���������һ�Σ��򰴡�0��������һ��");
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
			
			System.out.println("�޸ĳɹ���");
			Thread.sleep(800);
			modify_info(ID);
			
		}else if(keyboard.equals("0")){
			AdminOpt.operate_page(ID);
		}else {
			System.out.println("�������˷Ƿ��ַ������������룡");
			modify_info(ID);
		}
	}
	/**
	 �鿴���б�ҵ���ľ�ҵ��Ϣ
	 * @param ID
	 * @throws InterruptedException
	 */
	public static void check_total_info(String ID) throws InterruptedException {
		String keyboard;
		System.out.println("��ǰλ���ǣ�����Ա�������������Ϣ����ƽ̨��");
		System.out.println("��ѡ����Ҫ���еĲ���:");
		System.out.println("1.����ҵ״̬�鿴��ҵ��Ϣ");
		System.out.println("2.���Ա�鿴��ҵ��Ϣ");
		System.out.println("0.������һ��");
		keyboard = Login.in.next();
		switch(keyboard) {
		case "1":
			System.out.println("��ǰλ���ǣ�����Ա�����������Ϣ����ƽ̨�����鿴��Ϣ������ҵ״̬����");
			System.out.println("����Ϊ�����ѵǼǱ�ҵ���ľ�ҵ�����");
			System.out.println("����ҵ/��ҵ��");
			for(Entry<String, Employed> entry: Login.init.employList.entrySet()) {
				System.out.print(Login.init.graduateList.get(entry.getKey()).getID()+" ");
				System.out.println(Login.init.graduateList.get(entry.getKey()).getUsername());
				System.out.print("ְλ��");
				System.out.println(entry.getValue().getPosition());
				System.out.print("������˾��");
				System.out.println(entry.getValue().getCompanyName());
			 }
			
			for(Entry<String, Unemployed> entry: Login.init.unemployList.entrySet()) {
				System.out.println("����ҵ��");
				System.out.print(Login.init.graduateList.get(entry.getKey()).getID()+" ");
				System.out.println(Login.init.graduateList.get(entry.getKey()).getUsername());
				System.out.print("����ʡ�У�");
				System.out.println(entry.getValue().getPlace());
			 }
			
			for(Entry<String, Postgraduate> entry: Login.init.postgraList.entrySet()) {
				System.out.println("���о�����");
				System.out.print(Login.init.graduateList.get(entry.getKey()).getID()+" ");
				System.out.println(Login.init.graduateList.get(entry.getKey()).getUsername());
				System.out.print("����ѧУ��");
				System.out.println(entry.getValue().getFurtherSchool());
			 }
			System.out.println("����0��������һ��");
			while(true) {
				keyboard = Login.in.next();
				if(keyboard.equals("0")) {
					check_total_info(ID);
					break;
				}else {
					System.out.println("������������������һ��");
				}
			}
			
			break;
		case "2":
			System.out.println("��ǰλ���ǣ�����Ա�����������Ϣ����ƽ̨�����鿴��Ϣ�����Ա𣩡�");
			System.out.println("����Ϊ��ͬ�Ա�ľ�ҵ����ֲ���");
			
			System.out.println("��Ů��");
			for(Entry<String, Employed> entry: Login.init.employList.entrySet()) {
				if(Login.init.graduExtraList.get(entry.getKey()).getSex().equals("Ů")){
					System.out.print(Login.init.graduateList.get(entry.getKey()).getID()+" ");
					System.out.println(Login.init.graduateList.get(entry.getKey()).getUsername());
					System.out.print("ְλ��");
					System.out.println(entry.getValue().getPosition());
					System.out.print("������˾��");
					System.out.println(entry.getValue().getCompanyName());
				}
			 }
			

			for(Entry<String, Unemployed> entry: Login.init.unemployList.entrySet()) {
				if(Login.init.graduExtraList.get(entry.getKey()).getSex().equals("Ů")) {
					System.out.print(Login.init.graduateList.get(entry.getKey()).getID()+" ");
					System.out.println(Login.init.graduateList.get(entry.getKey()).getUsername());
					System.out.print("����ʡ�У�");
					System.out.println(entry.getValue().getPlace());
				}
			 }
			

			for(Entry<String, Postgraduate> entry: Login.init.postgraList.entrySet()) {
				if(Login.init.graduExtraList.get(entry.getKey()).getSex().equals("Ů")) {
					System.out.print(Login.init.graduateList.get(entry.getKey()).getID()+" ");
					System.out.println(Login.init.graduateList.get(entry.getKey()).getUsername());
					System.out.print("����ѧУ��");
					System.out.println(entry.getValue().getFurtherSchool());
				}
			 }
			
			System.out.println("���С�");
			for(Entry<String, Employed> entry: Login.init.employList.entrySet()) {
				if(Login.init.graduExtraList.get(entry.getKey()).getSex().equals("��")){
					System.out.print(Login.init.graduateList.get(entry.getKey()).getID()+" ");
					System.out.println(Login.init.graduateList.get(entry.getKey()).getUsername());
					System.out.print("ְλ��");
					System.out.println(entry.getValue().getPosition());
					System.out.print("������˾��");
					System.out.println(entry.getValue().getCompanyName());
				}
			 }
			
			for(Entry<String, Unemployed> entry: Login.init.unemployList.entrySet()) {
				if(Login.init.graduExtraList.get(entry.getKey()).getSex().equals("��")) {
					System.out.print(Login.init.graduateList.get(entry.getKey()).getID()+" ");
					System.out.println(Login.init.graduateList.get(entry.getKey()).getUsername());
					System.out.print("����ʡ�У�");
					System.out.println(entry.getValue().getPlace());
				}
			 }
			
			for(Entry<String, Postgraduate> entry: Login.init.postgraList.entrySet()) {
				if(Login.init.graduExtraList.get(entry.getKey()).getSex().equals("��")) {
					System.out.print(Login.init.graduateList.get(entry.getKey()).getID()+" ");
					System.out.println(Login.init.graduateList.get(entry.getKey()).getUsername());
					System.out.print("����ѧУ��");
					System.out.println(entry.getValue().getFurtherSchool());
				}
			 }
			System.out.println("����0��������һ��");
			while(true) {
				keyboard = Login.in.next();
				if(keyboard.equals("0")) {
					check_total_info(ID);
					break;
				}else {
					System.out.println("������������������һ��");
				}
			}
			break;
		case "0":
			AdminOpt.operate_page(ID);
			break;
		default:
			System.out.println("������������������ѡ�����");
			Thread.sleep(1000);
			check_total_info(ID);
		}
		System.out.println("����0��������һ��");
		while(true) { // �����������ַ������������룬��0�˳�ѭ��
			keyboard = Login.in.next();
			if(keyboard.equals("0")) {
				AdminOpt.operate_page(ID);
				break;
			}else {
				System.out.println("������������������һ��");
			}
		}
	}
}
