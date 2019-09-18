package EX03;

public class Test {

	public static void main(String[] args) {
		// TODO Autol-generated method stub
		String a="";
		z:for(int x=2;x<7;x++){
			if(x==3) continue;
			if(x==5) break z;
			a=a+x;
			
		}
		System.out.println(a);
	}

}
