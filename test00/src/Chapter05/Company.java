package Chapter05;

public class Company {
	private String name;
	private Prog Boss;
	private Prog [] emps;
	
	public void setName(String name){
		this.name=name;
	}
	public void setBoss(Prog Boss){
		this.Boss=Boss;
	}
	public void setEmps(Prog [] emps){
		this.emps=emps;
	}
	
	void showInfo(){
		System.out.println("��˾��������:"+name);
		System.out.println("��ʾ�ϰ���Ϣ");
		Boss.introduce();
		System.out.println("��ʾԱ����Ϣ");
		for(Prog emp:emps){
			emp.introduce();
		}
		
	}
}
