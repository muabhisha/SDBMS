package sdbms;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		System.out.println("WELCOME TO STUDENT DATABASE MANAGEMENT SYSTEM");
		System.out.println("----------------------------------------------");
		
		Scanner scn=new Scanner(System.in);
		StudentManagementSystem sms=new StudentManagementSystemImp();
		
		while(true) {
			System.out.println("enter the choice:\n 1--> add student\n 2-->display student\n 3-->display all students\n "
					+ "4-->remove student\n 5-->remove all students\n 6-->update student\n 7-->count students\n 8-->sort students\n "
					+ "9-->find student with highest marks\n 10-->find student with lowest marks\n 11-->exit");
			
			int choice=scn.nextInt();
			
			switch(choice) {
			case 1: sms.addStudent();
					break;
					
			case 2: sms.displayStudent();
					break;
					
			case 3: sms.displayAllStudents();
					break;
					
			case 4: sms.removeStudent();
					break;
					
			case 5: sms.removeAllStudents();
					break;
					
			case 6: sms.updateStudent();
			        break;
			        
			case 7: sms.countStudents();
					break;
					
			case 8: sms.sortStudents();
					break;
					
			case 9: sms.findStudentWithHighestMarks();
					break;
					
			case 10: sms.findStudentWithLowestMarks();
					 break;
					
			case 11: System.out.println("THANK YOU");
					 System.exit(0);
					
			default: System.out.println("INVALID CHOICE");
				
				
			}
			System.out.println("-----------------------------------------");
		}
	}

}
