package Chapter05;

public class Prog {
	private String name;
	private String [] skills;
	
	public void setName(String name){
		this.name=name;
	}
	public void setSkills(String [] skills){
		this.skills=skills;
	}
	
	public void introduce(){
		System.out.println("������:"+name);
		System.out.print("�һ�ļ�����:");
		for(String x :skills){
			System.out.print(x);
		}
		System.out.println();
	}
}
