package hibernate_student_pejm17.controller;
import java.util.Scanner;
import javax.persistence.Persistence;
import hibernate_student_pejm17.dao.StudentDao;
import hibernate_student_pejm17.dto.Student;
public class MainController {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Choice \n1.Save Student \n2.Fetch Student By Id \n3.Find ALL STUDENT \n4.Find Student By Phone no \n5.Update Student \n6.Delete Student ");
		int choice = scanner.nextInt();
		Student student = new Student();
		StudentDao dao = new StudentDao();
		switch(choice)
		{
		case 1:{
			    System.out.println("Enter id");
			    int id = scanner.nextInt();
			    System.out.println("Enter name");
			    String name = scanner.next();
			    System.out.println("Enter age");
			    int age = scanner.nextInt();
			    System.out.println("Enter marks");
			    int marks = scanner.nextInt();
			    System.out.println("Enter percentage");
			    double percentage= scanner.nextDouble();
			    System.out.println("Enter phone");
			    long phone = scanner.nextLong();
                
			    student.setId(id);
			    student.setName(name);
			    student.setAge(age);
			    student.setMarks(marks);
			    student.setPercentage(percentage);
			    student.setPhone(phone);
                dao.saveStudent(student);
			
		     }
		     break;
		     
		case 2:{
				System.out.println("Enter id");
				int id = scanner.nextInt();
				dao.findStudent(id);
		}   
		break;
		
		case 3:{
			System.out.println("The list of all Students:");
			dao.findAll();
		}
		break;
		case 4:{
			System.out.println("The list of all Students:");
			long phone = scanner.nextLong();
			dao.findByPhone(phone);
		}break;
		case 5:{
			
		System.out.println("Enter id");
	    int id = scanner.nextInt();
	    System.out.println("Enter name");
	    String name = scanner.next();
	    System.out.println("Enter age");
	    int age = scanner.nextInt();
	    System.out.println("Enter marks");
	    int marks = scanner.nextInt();
	    System.out.println("Enter percentage");
	    double percentage= scanner.nextDouble();
	    System.out.println("Enter phone");
	    long phone = scanner.nextLong();
        
	    student.setId(id);
	    student.setName(name);
	    student.setAge(age);
	    student.setMarks(marks);
	    student.setPercentage(percentage);
	    student.setPhone(phone);
        dao.updateStudent(id,student);
		
	}
		}
		

	}

}
