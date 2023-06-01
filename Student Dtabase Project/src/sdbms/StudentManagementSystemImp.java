package sdbms;
import customexception.StudentNotFoundException;
import customsorting.SortStudentByAge;
import customsorting.SortStudentById;
import customsorting.SortStudentByMarks;
import customsorting.SortStudentByName;
import customexception.InvalidChoiceException;
import java.util.*;

public class StudentManagementSystemImp implements StudentManagementSystem{

	//Scanner object
	//Collection Database--->Map (LinkedHashMap)
	//Map reference Variable and LinkedHashMap object
	//Generics-->key is Student id and value is Student object

	Scanner scn=new Scanner(System.in);

	Map<String,Student> db=new LinkedHashMap<String,Student>();

	@Override
	public void addStudent() {

		//Accept age,name,marks 
		//create a student object
		//add student id as key and student object as value in database
		//we should use put()
		//display the student id

		System.out.println("Enter student age: ");
		int age=scn.nextInt();
		System.out.println("Enter student name: ");
		String name=scn.next();
		System.out.println("Enter student marks: ");
		int marks=scn.nextInt();

		Student std=new Student(age,name,marks);

		db.put(std.getId(), std);
		System.out.println("Student record inserted successfully!!!");
		System.out.println("Student id is: "+std.getId());

	}


	@Override
	public void displayStudent() {
		//accept the student id
		//convert into uppercase -- toUpperCase()
		//check if the student id is present
		//get the value(Student object) and invoke get(id)...get(marks)   
		//else StudentNotFoundException

		System.out.println("Enter the student id: ");
		String id=scn.next(); //scn.next().toUpperCse();
		id=id.toUpperCase();

		if(db.containsKey(id)) {
			Student std=db.get(id);

			System.out.println("Student details: ");
			//System.out.println(std);

			System.out.println("Student id: "+std.getId());
			System.out.println("Student age: "+std.getAge());
			System.out.println("Student name: "+std.getName());
			System.out.println("Student marks: "+std.getMarks());

		}
		else {
			try {
				String message="STUDENT WITH THE "+id+" IS NOT FOUND";
				throw new StudentNotFoundException(message);		
			}catch(Exception e) {
				System.out.println(e.getMessage());

			}
		}
	}


	@Override
	public void displayAllStudents() {
		if(db.size()>0) {
			System.out.println("Student records are as follows: ");
			System.out.println("-------------------------------------");
			Set<String> keys=db.keySet(); // JSP101 JSP102 JSP103...
			for(String key : keys) {
				Student stud = db.get(key);
				System.out.println(stud);
			}
		}

		else {
			try {
				String message="NO SUFFICIENT STUDENT RECORDS TO DISPLAY";
				throw new StudentNotFoundException(message);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}


	@Override
	public void removeStudent() {
		//accept student id 
		//convert to uppercase
		//check if the student id is present remove the student object
		//else StudentNotFoundException

		System.out.println("Enter the Student id: ");
		String id=scn.next().toUpperCase();

		if(db.containsKey(id)) {
			System.out.println("Student record found");
			System.out.println(db.get(id));
			db.remove(id);
			System.out.println("Student record removed successfully!!");
		}

		else {
			try {
				String message="STUDENT WITH THE "+id+" IS NOT FOUND TO REMOVE";
				throw new StudentNotFoundException(message);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}


	@Override
	public void removeAllStudents() {
		if(db.size()>0) { //if(isEmpty()){
			System.out.println("Number of student records: "+db.size());
			db.clear();
			System.out.println("All student records deleted successfully!!!");
		}
		else {
			try {
				String message="NO STUDENT RECORD FOUND TO DELETE";
				throw new StudentNotFoundException(message);	
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}	
	}
	
	
	@Override
	public void updateStudent() {
		System.out.println("Enter student id: ");
		String id=scn.next().toUpperCase();
		
		if(db.containsKey(id)) {
			Student std=db.get(id);
			System.out.println(" 1-->update age\n 2-->update name\n 3-->update marks\n  ");
			System.out.println("Enter the choice to update: ");
			int choice=scn.nextInt();
			
			switch(choice) {
			case 1: System.out.println("Enter the age: ");
			        int age=scn.nextInt();
			        std.setAge(age);
			        System.out.println("Age updated successfully!!");
			        break;
				
			case 2: System.out.println("Enter the name: ");
		       		String name=scn.next();
		       		std.setName(name);
		       		System.out.println("Name updated successfully!!");
		       		break;
				
			case 3: System.out.println("Enter the marks: ");
		       		int marks=scn.nextInt();
		       		std.setMarks(marks);
		       		System.out.println("Marks updated successfully!!");
		       		break;
				
				
			default: try{
				     String message="INVALID CHOICE,KINFLY ENTER VALID CHOICE";
				     throw new InvalidChoiceException(message);
			         }catch(Exception e) {
				     System.out.println(e.getMessage());
			         }
			}
		}

		else {
			try {
				String message="STUDENT WITH THE "+id+" IS NOT FOUND TO UPDATE";
				throw new StudentNotFoundException(message);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
	
	
	@Override
	public void countStudents() {
		System.out.println("Number of Student Records added: "+db.size());
		
	}
	
	
	@Override
	public void sortStudents() {
		
		if(!db.isEmpty()) {
			
		//converting map into set using keYSet()
		Set<String> keys=db.keySet();
		
		//reference of list and object of array list storing student objects
		List<Student> list=new ArrayList<Student>();
		
		for(String key:keys) {
			list.add(db.get(key)); //getting student object and adding it to list
			
		}
		
		System.out.println(" 1:id Sorting\n 2:Name Sorting\n 3:Age Sorting\n 4:Marks Sorting\n");
		System.out.println("Enter the choice: ");
		int choice=scn.nextInt();
		
		switch(choice) {
		case 1: Collections.sort(list,new SortStudentById());
		display(list);
		break;
		
		case 2: Collections.sort(list,new SortStudentByName());
		display(list);
		break;
		
		case 3: Collections.sort(list,new SortStudentByAge());
		display(list);
		break;
		
		case 4: Collections.sort(list,new SortStudentByMarks());
		display(list);
		break;
		
		default: try {
			String message="INVALID CHOICE,KINFLY ENTER VALID CHOICE";
			throw new InvalidChoiceException(message);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}			
	  }
	}
		else {
			try {
				String message="NO SUFFICIENT STUDENT TO SORT";
				throw new StudentNotFoundException(message);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
	}
	
	//traversing a list of student object to avoid redundancy
	private static void display(List<Student> list){ 
		for(Student std:list) {
			System.out.println(std);
		}
	}
	
	
	@Override
	public void findStudentWithHighestMarks() {
		if(!db.isEmpty()) {
		Set<String> keys=db.keySet();
		List<Student> list=new ArrayList<Student>();
		
		for(String key:keys) {
			list.add(db.get(key));
		}
		Collections.sort(list,new SortStudentByMarks());
		System.out.println("Student with highest marks: ");
		System.out.println(list.get(list.size()-1));
		}
		
		else {
			try {
				String message="NO SUFFICIENT STUDENT TO SORT";
				throw new StudentNotFoundException(message);
				
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	
	@Override
	public void findStudentWithLowestMarks() {
		if(!db.isEmpty()) {
		Set<String> keys=db.keySet();
		List<Student> list=new ArrayList<Student>();
		
		for(String key:keys) {
			list.add(db.get(key));
		}
		Collections.sort(list,new SortStudentByMarks());
		System.out.println("Student with lowest marks: ");
		System.out.println(list.get(0));
		}
		else {
			try {
				String message="NO SUFFICIENT STUDENT TO SORT";
				throw new StudentNotFoundException(message);
				
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}	
	}

}
