package Chapter05;

public class TestProg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] java={"C����","Java","C++","python"};
		String [] python={"�й�","����","����"};
		
		Prog a=new Prog();
		a.setSkills(java);
		a.introduce();
		
		a.setSkills(python);
		a.introduce();
		
	}

}
