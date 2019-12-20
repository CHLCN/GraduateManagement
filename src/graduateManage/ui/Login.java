package graduateManage.ui;

import java.util.Scanner;
import graduateManage.util.Init;
import graduateManage.domain.*;
/**
 * ��¼����
 * @author chl
 */
public class Login {
	public static final Scanner in = new Scanner(System.in); // ��������
	static {
		init = new Init();
	}
	public static Init init; // ������Ա�б�
	/**
	 * ����¼��Ա��ݲ�У�������Ƿ���ȷ
	 * @throws InterruptedException ��������;��������ֹ���׳����쳣
	 */
	public static void welcome() throws InterruptedException {
		final String ID;
		String pwd;
		System.out.println("\t\t\t��ӭ������ҵ������ϵͳ");
		System.out.println("*****************************************************************************");
		System.out.println("\t\t\t��ʹ��ѧ���ŵ�¼");
		System.out.println("ʾ���û���");
		System.out.println("������Ա��");
		System.out.println("ѧ���ţ�100/101");
		System.out.println("��ʼ����Ϊ��123");
		System.out.println("����ҵ����");
		System.out.println("ѧ���ţ�001/002/003/004���ѵǼǾ�ҵ��Ϣ��/005��δ�ǼǾ�ҵ��Ϣ��");
		System.out.println("��ʼ����Ϊ��123"+"\n");
		System.out.print("ѧ���ţ�����exit�˳�ϵͳ����");
		ID = in.next();
		if(ID.equals("exit")) {
			exit();
		}
		if (!new LoginDao().ifExist(ID,init.graduateList,init.adminList)) {
			System.err.println("ϵͳ�����ڴ��˺ţ�����ϵ����Ա����û���");
			welcome();
		}else {
			System.out.print("���룺");
			while(true) {
				pwd = in.next();
				if (new LoginDao().ifMatch_G(ID, pwd, init.graduateList)) {
					System.out.println("�Ѽ�⵽������ݣ�����ҵ����");
					System.out.println("��ӭ!"+init.graduateList.get(ID).getUsername());
					Thread.sleep(800); // �ڻ�ӭ����ͣ��0.8��
					GraduateInfo.info_page(ID);
					break;
				}else if (new LoginDao().ifMatch_A(ID, pwd, init.adminList)) {
					System.out.println("�Ѽ�⵽������ݣ�������Ա��");
					System.out.println("��ӭ!"+init.adminList.get(ID).getUsername());
					Thread.sleep(800);
					AdminOpt.operate_page(ID);// �������ҳ��
					break;
				} else {
					System.out.println("���벻��ȷ�����������룡");
				}
			}
		}
	}
	/**
	 * �˳�����
	 */
	public static void exit() {
		System.out.println("��л����ʹ��!");
		System.out.println("*****************************************************************************");
		System.exit(0);
	}
}
