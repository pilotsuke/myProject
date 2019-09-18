package fuxiceshi;

public class KungFu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Integer x=400;
//		Integer y=x;
//		x++;
//		StringBuilder sb1=new StringBuilder("123");
//		StringBuilder sb2=sb1;
//		sb1.append("5");
//		System.out.println((x==y)+" "+(sb1==sb2));
		
		int x=0;
		int y=10;
		do{
			System.out.print("y"+y);
			y--;
			System.out.println("y"+y);
			System.out.println("++++++++++++++");
			System.out.print(",x "+x);
			++x;
			System.out.println(",x "+x);
			System.out.println("++++++++++++++");
		}while(x<5);
		System.out.println("½á¹ûÊÇ:"+x+" "+y);
	}

}
