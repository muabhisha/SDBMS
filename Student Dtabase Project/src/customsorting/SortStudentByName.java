package customsorting;
import java.util.Comparator;
import sdbms.Student;

public class SortStudentByName implements Comparator<Student>{
	@Override
	public int compare(Student x,Student y) {
		return x.getName().compareTo(y.getName());
	}
}


//x-->object to be inserted
//y-->already existing object
//for String comparison, we are using compareTo() present in String class