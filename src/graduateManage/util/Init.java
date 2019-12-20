package graduateManage.util;

import java.util.HashMap;

import graduateManage.entity.*;
/**
 * �����г�ʼ��������Ա�˺���Ϣ
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
	 * ����Ա��ʼ��
	 */
	public void adminInit() {
		Admin a1 = new Admin("Harry","100","123","1323123");
		Admin a2 = new Admin("Root","101","123","1234332");
		adminList.put("100",a1);
		adminList.put("101",a2);
	}
	/**
	 * ��ҵ����ʼ��
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
	 * ��ʼ����ҵ������������Ϣ
	 */
	public void graduExtraInit() {
		ExtraInfo gx1 = new ExtraInfo("001","����ѧԺ","Ů","2018");
		ExtraInfo gx2 = new ExtraInfo("002","����ѧԺ","Ů","2019");
		ExtraInfo gx3 = new ExtraInfo("003","�Ĵ�ѧԺ","Ů","2018");
		ExtraInfo gx4 = new ExtraInfo("004","����ѧԺ","��","2019");
		ExtraInfo gx5 = new ExtraInfo("005","����ѧԺ","��","2017");
		graduExtraList.put("001",gx1);
		graduExtraList.put("002",gx2);
		graduExtraList.put("003",gx3);
		graduExtraList.put("004",gx4);
		graduExtraList.put("005",gx5);
	}
	/**
	 * ��ʼ����ҵ��Ա��Ϣ
	 */
	public void unemployInit() {
		Unemployed ug1 = new Unemployed("001","����");
		unemployList.put("001",ug1);
	}
	/**
	 * ��ʼ���о���
	 */
	public void postgraInit() {
		Postgraduate pg1 = new Postgraduate("002","������ѧ");
		postgraList.put("002",pg1);
	}
	/**
	 * ��ʼ����ҵ��Ա��Ϣ
	 */
	public void employInit() {
		Employed e1 = new Employed("003","�����ܼ�","��������Сħ�ɹ�˾");
		Employed e2 = new Employed("004","���۾���","����ʲô��˾");
		employList.put("003",e1);
		employList.put("004",e2);
	}
	/**
	 * �˺������ⲿ����о���
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
	 * �˺������ⲿ����Ѿ�ҵ��ҵ���ľ�ҵ��Ϣ
	 * @param ID student ID
	 * @param comN the name of graduate's company
	 * @param pos the position of graduate in company
	 */
	public void add_employed(String ID, String comN, String pos) {
		Employed e = new Employed(ID,pos,comN);
		employList.put(ID, e);
	}
	/**
	 * ���ⲿ��Ӵ�ҵ��ҵ���ľ�ҵ��Ϣ
	 * @param ID
	 * @param place 
	 */
	public void add_unemployed(String ID,String place) {
		Unemployed up = new Unemployed(ID,place);
		unemployList.put(ID, up);
	}
	/**
	 * ���ⲿ����о�����Ϣ
	 * @param ID
	 * @param school
	 */
	public void add_postgraduate(String ID,String school) {
		Postgraduate pg = new Postgraduate(ID,school);
		postgraList.put(ID,pg);
	}
}
