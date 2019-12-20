package graduateManage.domain;
import graduateManage.ui.*;

public class GraduateInfoDao {
	/**
	 �鿴������Ϣ
	 * @param ID
	 * @throws InterruptedException
	 */
	public static void check_info(String ID) throws InterruptedException {
		String keyboard;
		System.out.print("������");
		System.out.println(Login.init.graduateList.get(ID).getUsername());
		System.out.print("�Ա�");
		System.out.println(Login.init.graduExtraList.get(ID).getSex());
		System.out.print("ѧ�ţ�");
		System.out.println(Login.init.graduateList.get(ID).getID());
		System.out.print("��ϵ��ʽ��");
		System.out.println(Login.init.graduateList.get(ID).getPhoneNumber());
		System.out.print("ԭ����ѧԺ��");
		System.out.println(Login.init.graduExtraList.get(ID).getInstitute());	
		System.out.println("����0��������һ��");
		while(true) { // �����������ַ������������룬��0�˳�ѭ��
			keyboard = Login.in.next();
			if(keyboard.equals("0")) {
				GraduateInfo.info_page(ID);
				break;
			}else {
				System.out.println("������������������һ��");
			}
		}
	}
	/**
	 �༭������Ϣ
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
			System.out.println("��ǰλ���ǣ�ѧ������������༭������Ϣ�����޸����롿");
			System.out.println(Login.init.graduateList.get(ID).getUsername());
			System.out.println("����������ԭ���루Ĭ������Ϊ123/���롾q��ȡ���޸ģ���");
			opwd = Login.in.next();
			if(opwd.equals("q")) {
				modify_info(ID);
			}
			while(true) {
				if(opwd.length()<=1||!opwd.equals(Login.init.graduateList.get(ID).getPwd())) { // ��������Ƿ�Ϸ�
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
			Login.init.graduateList.get(ID).setPwd(npwd);
			System.out.println("�޸ĳɹ���");
			Thread.sleep(800);
			modify_info(ID);
		}else if(keyboard.equals("2")) {
			System.out.println("��ǰλ���ǣ�ѧ������������༭������Ϣ�����޸���ϵ��ʽ��");
			String nphoneNum;
			System.out.println(Login.init.graduateList.get(ID).getUsername());
			System.out.println("����ǰ����ϵ��ʽ�ǣ�");
			System.out.println(Login.init.graduateList.get(ID).getPhoneNumber());
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
			System.out.println("��������������ϵ��ʽ�����롾q��ȡ���޸ģ���");
			nphoneNum = Login.in.next();
			if(nphoneNum.equals("q")) {
				modify_info(ID);
			}
			while(true) {
				if(nphoneNum.length()<=3||!nphoneNum.matches("^[0-9]*$")) {
					System.out.println("������ĵ绰���벻�Ϸ���������һ�Σ��򰴡�0��������һ��");
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
			
			System.out.println("�޸ĳɹ���");
			Thread.sleep(800);
			modify_info(ID);
			
		}else if(keyboard.equals("0")){
			GraduateInfo.info_page(ID);
		}else {
			System.out.println("�������˷Ƿ��ַ������������룡");
			modify_info(ID);
		}
	
	}
	/**
	 �鿴���˾�ҵ��Ϣ
	 * @param ID
	 * @throws InterruptedException
	 */
	public static void check_em_info(String ID) throws InterruptedException {
		String keyboard;
		System.out.println("������");
		System.out.println(Login.init.graduateList.get(ID).getUsername()+"\n");
		if(Login.init.employList.containsKey(ID)) {
			System.out.println("�����ڵľ�ҵ״̬Ϊ����ҵ��");
			System.out.print("��˾��");
			System.out.println(Login.init.employList.get(ID).getCompanyName()+"\n");
			System.out.print("��λ��");
			System.out.println(Login.init.employList.get(ID).getPosition()+"\n");
		}else if(Login.init.unemployList.containsKey(ID)){
			System.out.println("�����ڵľ�ҵ״̬Ϊ����ҵ��");
			System.out.print("���ڵأ�");
			System.out.println(Login.init.unemployList.get(ID).getPlace()+"\n");
		}else if(Login.init.postgraList.containsKey(ID)) {
			System.out.println("�����ڵľ�ҵ״̬Ϊ���о�����");
			System.out.print("����ѧУ��");
			System.out.println(Login.init.postgraList.get(ID).getFurtherSchool()+"\n");
		}else {
			System.err.println("����δ�ǼǾ�ҵ��Ϣ,��ǼǾ�ҵ��Ϣ");
			Thread.sleep(1000);
			register_em_info(ID);
		}
		System.out.println("����0��������һ��");
		while(true) { // �����������ַ������������룬��0�˳�ѭ��
			keyboard = Login.in.next();
			if(keyboard.equals("0")) {
				GraduateInfo.info_page(ID);
				break;
			}else {
				System.out.println("������������������һ��");
			}
		}
	}
	/**
	 �༭���˾�ҵ��Ϣ
	 * @param ID
	 * @throws InterruptedException
	 */
	public static void modify_em_info(String ID) throws InterruptedException{
		
		String keyboard;
		String status;
		System.out.println(Login.init.graduateList.get(ID).getUsername());
		if(Login.init.employList.containsKey(ID)) {
			System.out.println("�����ڵľ�ҵ״̬Ϊ����ҵ��");
			System.out.print("��˾��");
			System.out.println(Login.init.employList.get(ID).getCompanyName());
			System.out.print("��λ��");
			System.out.println(Login.init.employList.get(ID).getPosition());
		}else if(Login.init.unemployList.containsKey(ID)){
			System.out.println("�����ڵľ�ҵ״̬Ϊ����ҵ��");
			System.out.print("���ڵأ�");
			System.out.println(Login.init.unemployList.get(ID).getPlace());
		}else if(Login.init.postgraList.containsKey(ID)) {
			System.out.println("�����ڵľ�ҵ״̬Ϊ���о�����");
			System.out.print("����ѧУ��");
			System.out.println(Login.init.postgraList.get(ID).getFurtherSchool());
		}else {
			System.err.println("����δ�ǼǾ�ҵ��Ϣ,��ǼǾ�ҵ��Ϣ");
			Thread.sleep(1000);
			register_em_info(ID);
		}
		System.out.println("��ȷ��Ҫ�޸���<Y/N>");
		while(true) {
			keyboard = Login.in.next();
			if(keyboard.equals("Y")||keyboard.equals("y")) {
				System.out.println("��ѡ�������ڵĴ�ҵ״̬��");
				System.out.println("1.��ҵ");
				System.out.println("2.��ҵ����ҵ���ҵ��");
				System.out.println("3.�о���");
				System.out.println("0.������һ��");
				status = Login.in.next();
				while(true) {
					if(status.equals("1")) {
						System.out.println("�������������ڵأ�");
						String place = Login.in.next();
						if(Login.init.unemployList.containsKey(ID)) {
							Login.init.unemployList.get(ID).setPlace(place);
						}else {
							Login.init.add_unemployed(ID, place);
						}
						System.out.println("�޸ĳɹ���");
						Thread.sleep(800);
						GraduateInfo.info_page(ID);
						break;
					}else if(status.equals("2")) {
						System.out.println("���������Ĺ�˾���ƣ�");
						String comN = Login.in.next();
						System.out.println("����������ְλ");
						String pos = Login.in.next();
						if(Login.init.employList.containsKey(ID)) {
							Login.init.employList.get(ID).setCompanyName(comN);
							Login.init.employList.get(ID).setPosition(pos);
						}else {
							Login.init.add_employed(ID, pos, comN);
						}
						System.out.println("�޸ĳɹ���");
						Thread.sleep(800);
						GraduateInfo.info_page(ID);
						break;
					}else if(status.equals("3")) {
						System.out.println("����������ѧУ����");
						String schN = Login.in.next();
						if(Login.init.postgraList.containsKey(ID)) {
							Login.init.postgraList.get(ID).setFurtherSchool(schN);
							
						}else {
							Login.init.add_postgraduate(ID, schN);
						}
						System.out.println("�޸ĳɹ���");
						Thread.sleep(800);
						GraduateInfo.info_page(ID);
						break;
					}else if(status.equals("0")) {
						GraduateInfo.info_page(ID);
						break;
					}else {
						System.out.println("�������˷Ƿ��ַ������������룺");
						status = Login.in.next();
					}
				}
				break;
			}else if(keyboard.equals("N")||keyboard.equals("n")) {
				GraduateInfo.info_page(ID);
				break;
			}else {
				System.out.println("���������������������룺");
			}
		}
		
	}
	/**
	 �ǼǾ�ҵ��Ϣ
	 * @param ID
	 * @throws InterruptedException
	 */
	public static void register_em_info(String ID) throws InterruptedException {
		String status;
		System.out.println("��ѡ�������ڵĴ�ҵ״̬��");
		System.out.println("1.��ҵ");
		System.out.println("2.��ҵ����ҵ���ҵ��");
		System.out.println("3.�о���");
		System.out.println("0.������һ��");
		status = Login.in.next();
		while(true) {
			if(status.equals("1")) {
				System.out.println("�������������ڵأ�");
				String place = Login.in.next();
				Login.init.add_unemployed(ID, place);
				System.out.println("�ѱ��棡");
				Thread.sleep(1000);
				break;
			}else if(status.equals("2")) {
				System.out.println("���������Ĺ�˾���ƣ�");
				String comN = Login.in.next();
				System.out.println("����������ְλ");
				String pos = Login.in.next();
				Login.init.add_employed(ID, pos, comN);
				System.out.println("�ѱ��棡");
				Thread.sleep(1000);
				break;
			}else if(status.equals("3")) {
				System.out.println("����������ѧУ����");
				String schN = Login.in.next();
				Login.init.add_postgraduate(ID, schN);
				System.out.println("�ѱ��棡");
				Thread.sleep(1000);
				break;
			}else if(status.equals("0")) {
				GraduateInfo.info_page(ID);
				break;
			}else {
				System.err.println("�������˷Ƿ��ַ������������룺");
				status = Login.in.next();
			}
		}
		GraduateInfo.info_page(ID);
	}
}
