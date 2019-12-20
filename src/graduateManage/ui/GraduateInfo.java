package graduateManage.ui;

import graduateManage.domain.GraduateInfoDao;
/**
 * ��ҵ����ѡ���������
 * @author chl
 */
public class GraduateInfo {
	/**
	 * ��ҵ��ѡ�����
	 * @param ID ��ҵ����ѧ����
	 * @throws InterruptedException
	 */
	public static void info_page(String ID) throws InterruptedException {
		
		System.out.println("*****************************************************************************");
		System.out.println("��ǰ�����ǡ�ѧ���������桿");
		System.out.println("��ѡ��Ҫ���еĲ�����");
		System.out.println("1.�鿴������Ϣ");
		System.out.println("2.�༭������Ϣ");
		System.out.println("3.�鿴���˾�ҵ��Ϣ");
		System.out.println("4.�༭���˾�ҵ��Ϣ");
		System.out.println("0.���ص�¼����");
		System.out.println("����e��ֱ���˳�ϵͳ");
		String choice = Login.in.next();
		switch(choice) {
		case "1":
			System.out.println("*****************************************************************************");
			System.out.println("��ǰλ���ǣ�ѧ��������������鿴������Ϣ��");
			GraduateInfoDao.check_info(ID);
			break;
		case "2":
			System.out.println("*****************************************************************************");
			System.out.println("��ǰλ���ǣ�ѧ��������������༭������Ϣ��");
			GraduateInfoDao.modify_info(ID);
			break;
		case "3":
			System.out.println("*****************************************************************************");
			System.out.println("��ǰλ���ǣ�ѧ��������������鿴���˾�ҵ��Ϣ��");
			GraduateInfoDao.check_em_info(ID);
			break;
		case "4":
			System.out.println("*****************************************************************************");
			System.out.println("��ǰλ���ǣ�ѧ��������������༭���˾�ҵ��Ϣ��");
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
			System.out.println("������������������ѡ��");
			Thread.sleep(800);
			info_page(ID); // ���������������������ҳ
		}
	}
	
}
