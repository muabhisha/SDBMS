package example;

public class Person {
	String id;
	static int count=101;
	
	Person(){
		this.id="XYZ"+count++;
	}
	
	public static void main(String[] args) {
		Person p1=new Person();
		Person p2=new Person();
		Person p3=new Person();
		
		System.out.println(p1.id);
		System.out.println(p2.id);
		System.out.println(p3.id);
	}

}

//Rules to auto generate id:
//1. consider a count variable (static)
//2. initialize the count variable
//3. increment the count variable
