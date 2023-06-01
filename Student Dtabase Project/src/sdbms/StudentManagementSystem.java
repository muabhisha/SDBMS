package sdbms;

public interface StudentManagementSystem {
	
	void addStudent();
	void displayStudent();
	void displayAllStudents();
	void removeStudent();
	void removeAllStudents();
	void updateStudent();
	void countStudents();
	void sortStudents();
	void findStudentWithHighestMarks();
	void findStudentWithLowestMarks();

}

// all methods in interface are public and abstract by default
