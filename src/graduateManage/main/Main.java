package graduateManage.main;

import graduateManage.ui.Login;
/**
 * @author chl
 */
public class Main {
	public static void main(String[] args) {
        try { // ������������жϣ����׳��쳣
			Login.welcome();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
}
