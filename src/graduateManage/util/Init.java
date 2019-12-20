package graduateManage.util;

import java.util.HashMap;

import graduateManage.entity.*;
/**
 * 此类中初始化所有人员账号信息
 * @author chl
 */
public class Init {
	public HashMap<String,Graduate> 	graduateList   = new HashMap<String,Graduate>();
	public HashMap<String,ExtraInfo> 	graduExtraList = new HashMap<String,ExtraInfo>();
	public HashMap<String,Admin> 		adminList 	   = new HashMap<String,Admin>();
	public HashMap<String,Unemployed> 	unemployList   = new HashMap<String,Unemployed>();
	public HashMap<String,Employed> 	employList 	   = new HashMap<String,Employed>();
	public HashMap<String,Postgraduate> postgraList    = new HashMap<String,Postgraduate>();
	public Init() {
		adminInit();
		graduateInit();
		unemployInit();
		postgraInit();
		employInit();
		graduExtraInit();
	}
	/**
	 * 管理员初始化
	 */
	public void adminInit() {
		Admin a1 = new Admin("Harry","100","123","1323123");
		Admin a2 = new Admin("Root","101","123","1234332");
		adminList.put("100",a1);
		adminList.put("101",a2);
	}
	/**
	 * 毕业生初始化
	 */
	public void graduateInit() {
		Graduate grd1 = new Graduate("Amy","001","123","1234132");
		Graduate grd2 = new Graduate("Emma","002","123","12342343");
		Graduate grd3 = new Graduate("Sarah","003","123","4567891");
		Graduate grd4 = new Graduate("John","004","123","45645123");
		Graduate grd5 = new Graduate("Lionel","005","123","1232154");
		graduateList.put("001",grd1);
		graduateList.put("002",grd2);
		graduateList.put("003",grd3);
		graduateList.put("004",grd4);
		graduateList.put("005",grd5);
	}
	/**
	 * 初始化毕业生其他个人信息
	 */
	public void graduExtraInit() {
		ExtraInfo gx1 = new ExtraInfo("001","机电学院","女","2018");
		ExtraInfo gx2 = new ExtraInfo("002","国服学院","女","2019");
		ExtraInfo gx3 = new ExtraInfo("003","文创学院","女","2018");
		ExtraInfo gx4 = new ExtraInfo("004","教育学院","男","2019");
		ExtraInfo gx5 = new ExtraInfo("005","中文学院","男","2017");
		graduExtraList.put("001",gx1);
		graduExtraList.put("002",gx2);
		graduExtraList.put("003",gx3);
		graduExtraList.put("004",gx4);
		graduExtraList.put("005",gx5);
	}
	/**
	 * 初始化待业人员信息
	 */
	public void unemployInit() {
		Unemployed ug1 = new Unemployed("001","北京");
		unemployList.put("001",ug1);
	}
	/**
	 * 初始化研究生
	 */
	public void postgraInit() {
		Postgraduate pg1 = new Postgraduate("002","北京大学");
		postgraList.put("002",pg1);
	}
	/**
	 * 初始化从业人员信息
	 */
	public void employInit() {
		Employed e1 = new Employed("003","财务总监","巴拉巴拉小魔仙公司");
		Employed e2 = new Employed("004","销售经理","这是什么公司");
		employList.put("003",e1);
		employList.put("004",e2);
	}
	/**
	 * 此函数供外部添加研究生
	 * @param ID
	 * @param name
	 * @param pwd
	 * @param phoneNumber
	 * @param institute
	 * @param sex
	 * @param yearOfGradu
	 */
	public void add_graduate(String ID,String name,
			String pwd,String phoneNumber,String institute,String sex,String yearOfGradu) {
		Graduate grd = new Graduate(name,ID,pwd,phoneNumber);
		ExtraInfo gx = new ExtraInfo(ID,institute,sex,yearOfGradu);
		graduateList.put(ID, grd);
		graduExtraList.put(ID,gx);
	}
	/**
	 * 此函数在外部添加已就业毕业生的就业信息
	 * @param ID student ID
	 * @param comN the name of graduate's company
	 * @param pos the position of graduate in company
	 */
	public void add_employed(String ID, String comN, String pos) {
		Employed e = new Employed(ID,pos,comN);
		employList.put(ID, e);
	}
	/**
	 * 在外部添加待业毕业生的就业信息
	 * @param ID
	 * @param place 
	 */
	public void add_unemployed(String ID,String place) {
		Unemployed up = new Unemployed(ID,place);
		unemployList.put(ID, up);
	}
	/**
	 * 在外部添加研究生信息
	 * @param ID
	 * @param school
	 */
	public void add_postgraduate(String ID,String school) {
		Postgraduate pg = new Postgraduate(ID,school);
		postgraList.put(ID,pg);
	}
}
