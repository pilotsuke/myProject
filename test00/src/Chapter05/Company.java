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
		System.out.println("公司的名字是:"+name);
		System.out.println("显示老板信息");
		Boss.introduce();
		System.out.println("显示员工信息");
		for(Prog emp:emps){
			emp.introduce();
		}
		
	}
}
