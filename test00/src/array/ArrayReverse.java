package array;

public class ArrayReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={1,2,3,4,5};
//		for(int i=0;i<a.length/2;i++){
//			int temp=a[i];
//			a[i]=a[a.length-1-i];
//			a[a.length-1-i]=temp;
//		}
		int b[]=new int[a.length];
		int c=0;
		for(int i=a.length-1;i>=0;i--){
			b[c]=a[i];
			c++;
		}
		
		
		for (int e:b){
			System.out.println(e);
		}
	}

}
