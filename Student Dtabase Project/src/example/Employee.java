package example;

public class Employee {
	String id;
	
	static int count=101;
	
	Employee(){
		this.id="JSP"+count;
		count++;
	}
	
	public static void main(String[] args) {
		Employee e1=new Employee();
		Employee e2=new Employee();
		Employee e3=new Employee();
		Employee e4=new Employee();
		
		System.out.println(e1.id);
		System.out.println(e2.id);
		System.out.println(e3.id);
		System.out.println(e4.id);
	}

}
