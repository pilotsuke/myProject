package ThisAndSuper;

public class Dog {
	String name;
	int age;
	int id;
	
//	this用法: 方法中的变量与属性同名
	public Dog(String name){
		this.name=name;
	}
	public Dog(){
		
	}
	
//	this用法: 在一个构造方法中, 调用其他重载的构造方法
	public Dog(String name, int age){
		this(name);
		this.age=age;
	}
	
//	this用法: 把this作为一个局部变量, 它的值是当前对象的引用
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
