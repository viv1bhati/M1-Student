package com.cg.sms.service;

import java.util.ArrayList;

import com.cg.sms.dto.Student;

public interface StudentService {

	int addStudent(Student student);
	
	Student getStudent(int rn);
	
	public Student updateStudent(Student student);
	
	public ArrayList<Student> getStudentList(String coursename);
	
	public Student delStudent(int rn);
	
	

}
