package graduateManage.ui;

import java.util.Map.Entry;
import graduateManage.domain.AdminOptDao;
import graduateManage.entity.Graduate;
/**
 * ����Ա��������
 * @author chl
 */
public class AdminOpt {
	/**
	  ����Աѡ�����
	 * @param ID ����Աѧ����
	 * @throws InterruptedException
	 */
	public static void operate_page(String ID) throws InterruptedException {
		System.out.println("*****************************************************************************");
		System.out.println("��ǰ�����ǡ�����Ա�������桿");
		System.out.println("��ѡ��Ҫ���еĲ�����");
		System.out.println("1.���ӱ�ҵ���˺�");
		System.out.println("2.ɾ����ҵ���˺�");
		System.out.println("3.�༭��ҵ����Ϣ");
		System.out.println("4.��ѯ��ҵ����Ϣ");
		System.out.println("5.�༭������Ϣ");
		System.out.println("6.��Ϣ����ƽ̨");
		System.out.println("0.���ص�¼����");
		System.out.println("����e��ֱ���˳�ϵͳ");
		String choice = Login.in.next();
		switch(choice) {
		case "1":
			System.out.println("*****************************************************************************");
			System.out.println("��ǰλ���ǣ�����Ա��������������ӱ�ҵ���˺š�");
			AdminOptDao.add_graduate(ID);
			break;
		case "2":
			System.out.println("*****************************************************************************");
			System.out.println("��ǰλ���ǣ�����Ա�����������ɾ����ҵ���˺š�");
			AdminOptDao.del_graduate(ID);
			break;
		case "3":
			System.out.println("*****************************************************************************");
			System.out.println("��ǰλ���ǣ�����Ա������������༭��ҵ����Ϣ��");
			AdminOptDao.modify_gradu_info(ID);
			break;
		case "4":
			System.out.println("*****************************************************************************");
			System.out.println("��ǰλ���ǣ�����Ա�������������ѯ��ҵ����Ϣ��");
			for(Entry<String, Graduate> entry: Login.init.graduateList.entrySet()) { // ��ʾ��ǰ���б�ҵ��
				System.out.print(Login.init.graduateList.get(entry.getKey()).getID()+"."+
						Login.init.graduateList.get(entry.getKey()).getUsername()+" "
						);
			 }
			System.out.println();
			AdminOptDao.check_gradu_info(ID);
			break;
		case "5":
			System.out.println("*****************************************************************************");
			System.out.println("��ǰλ���ǣ�����Ա������������༭������Ϣ��");
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
			System.out.println("�����������������������������");
			Thread.sleep(1000);
			operate_page(ID); // �������������������ҳ
		}
		operate_page(ID);
	}
	
}
