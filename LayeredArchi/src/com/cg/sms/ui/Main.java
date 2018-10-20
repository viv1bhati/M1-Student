package com.cg.sms.ui;

import java.util.ArrayList;
import java.util.Scanner;

import com.cg.sms.dto.Student;
import com.cg.sms.service.StudentService;
import com.cg.sms.service.StudentServiceImpl;

public class Main {

	public static void main(String[] args) {

	
		StudentService service = new StudentServiceImpl();

		Scanner s = new Scanner(System.in);
		int ch= 0;
		
		do{
		
		System.out.println(" 1. Add Student ");
		System.out.println(" 2. Display Student Details ");
		System.out.println(" 3. Update Details ");
		System.out.println(" 4. Display Student List ");
		System.out.println(" 5. Delete Student Record ");
		System.out.println("Enter your choice : ");
		ch = s.nextInt();
		switch (ch) {
		case 1:
			
		
			
			
			System.out.println("Enter Name : ");
			String name = s.next();

			System.out.println("Enter Course Name : ");
			String cname = s.next();

			System.out.println("Enter Age : ");
			int age = s.nextInt();

			System.out.println("Enter Mobile Number : ");
			String mob = s.next();

			Student  student = new Student();
			
			student.setName(name);
			student.setCourseName(cname);
			student.setAge(age);
			student.setMobileNo(mob);
			int rn = service.addStudent(student);
			System.out.println("Student record added.. " + rn);
			
		break;

		case 2:
			System.out.println("Enter Roll No : ");
			rn = s.nextInt();
			student = service.getStudent(rn);
			if(student==null)
				System.out.println("Record Not Found....");
			else{
			
			System.out.println(student.getName());
			System.out.println(student.getAge());
			System.out.println(student.getCourseName());
			System.out.println(student.getMobileNo());
		
		
			}
			break;
			
		case 3:
			System.out.println("Enter Roll No : ");
			rn = s.nextInt();
			student = service.getStudent(rn);
			if(student==null)
				System.out.println("Record Not Found....");
			else{
				System.out.println("Enter Mobile No : ");
				String mobno = s.next();
				student.setMobileNo(mobno);
				student = service.updateStudent(student);
				System.out.println("Record Updated .");
				System.out.println(student.getName());
				System.out.println(student.getMobileNo());
				
				
				
			}
			
			
		case 4:
			System.out.println("Enter Course Name : ");
			cname = s.next();
			
			ArrayList<Student> list = service.getStudentList(cname);
			
			if(list.size()==0)
				System.out.println("No student enrolled to this course");
			
			else{
				
				for(Student sc : list){
					System.out.println(sc.getName()+" "+sc.getMobileNo());
				}
			}
			break;
			
		case 5:
			System.out.println("Enter Roll No of the Record to be deleted..");
			rn= s.nextInt();
			student = service.delStudent(rn);
			if(student==null)
				System.out.println("Record Not Found....");
			else{
			
			System.out.println("Record deleted successfully..");
		
			
		
		
			}
			break;
			
			
			
		
		
		
		
		}//end of switch
		

		
		
		}while (ch!=6);
		System.out.println("End Of Application");
		
		
	}


}
