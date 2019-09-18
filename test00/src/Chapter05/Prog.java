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
		System.out.println("名字是:"+name);
		System.out.print("我会的技能有:");
		for(String x :skills){
			System.out.print(x);
		}
		System.out.println();
	}
}
