package Chapter05;

public class TestCompany {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String [] java={"MySQL","Java����","java�߼�","Java���"};
		String [] python={"mysql","python����","python�߼�"};
		String [] cpp={"C����","C++"};
		String [] bskills={"Java","python"};
		
		Company king=new Company();
		Prog boss=new Prog();
		
//		����Ա����Ϣ
		Prog p1=new Prog();
		p1.setName("����");
		p1.setSkills(java);
		Prog p2=new Prog();
		p2.setName("����");
		p2.setSkills(python);
		
		Prog emps[]={p1,p2};
		
		king.setName("����");
		boss.setSkills(bskills);
		boss.setName("�������ϰ������");
		king.setBoss(boss);
		king.setEmps(emps);
		king.showInfo();
	}

}
