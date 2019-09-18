package ThisAndSuper;

public class Dog {
	String name;
	int age;
	int id;
	
//	this�÷�: �����еı���������ͬ��
	public Dog(String name){
		this.name=name;
	}
	public Dog(){
		
	}
	
//	this�÷�: ��һ�����췽����, �����������صĹ��췽��
	public Dog(String name, int age){
		this(name);
		this.age=age;
	}
	
//	this�÷�: ��this��Ϊһ���ֲ�����, ����ֵ�ǵ�ǰ���������
	public Dog clone(){
		id++;
		return this;
	}
	
	public void print(){
		System.out.println("it is "+name+" , number "+id);
	}
	
	public static void main(String [] args){
		Dog wangcai=new Dog("Cai Wang");
		Dog wangwang=new Dog("Wang Wang");
		wangcai.print();
		wangwang.print();
		Dog wangcai1=wangcai.clone();
		wangcai1.print();
		wangwang.clone().clone().print();
		
	}
}
