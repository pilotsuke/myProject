package Chapter05;

public class TestCompany {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String [] java={"MySQL","Java基础","java高级","Java框架"};
		String [] python={"mysql","python基础","python高级"};
		String [] cpp={"C语言","C++"};
		String [] bskills={"Java","python"};
		
		Company king=new Company();
		Prog boss=new Prog();
		
//		设置员工信息
		Prog p1=new Prog();
		p1.setName("张三");
		p1.setSkills(java);
		Prog p2=new Prog();
		p2.setName("李四");
		p2.setSkills(python);
		
		Prog emps[]={p1,p2};
		
		king.setName("网易");
		boss.setSkills(bskills);
		boss.setName("这里是老板的名字");
		king.setBoss(boss);
		king.setEmps(emps);
		king.showInfo();
	}

}
