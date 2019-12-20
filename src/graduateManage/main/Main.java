package graduateManage.main;

import graduateManage.ui.Login;
/**
 * @author chl
 */
public class Main {
	public static void main(String[] args) {
        try { // 若程序非正常中断，则抛出异常
			Login.welcome();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
}
