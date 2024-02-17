package com.spring.jdbc;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.jdbc.dao.StudentDaoImplement;
import com.spring.jdbc.entities.Student;

/**
 * Main app class
 *
 */
public class App {
	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(config.class);
		StudentDaoImplement studentDao = context.getBean("studentDao", StudentDaoImplement.class);

		System.out.println("Enter your choice");
		System.out.println(
				"1. Insert new data \n 2. Update data \n 3. Delete data \n 4. Get single data \n 5. Get all the data");
		int choice = inputScanner.nextInt();
		Student student = new Student();

//		****************************Inserting data*****************************************
		if(choice==1) {
			student.setId(3);
			student.setName("Raman");
			student.setCity("mumbai");
			
			int numberOfrecord=studentDao.insert(student);
			System.out.println("number of record inserted was.." + numberOfrecord);
		}
		else if (choice==2) {

//			**********************************updating data***************************************

			student.setId(4);
			student.setName("mohit");
			student.setCity("patna");
			int numberOfrecord = studentDao.change(student);

			System.out.println("number of record updated was.." + numberOfrecord);
		}
		
		else if (choice==3) {
//			*************************deleting data******************************

			System.out.println("Enter the ID you want to delete");
				int studentId = inputScanner.nextInt();
				int numberOfrecord = studentDao.delete(studentId);
				System.out.println("number of record deleted was.." + numberOfrecord);
		}
		else if (choice==4) {
//			Fetching single data

			Student student1 = studentDao.getStudent(1);		
			System.out.println(student1);
		}
		else {

			List<Student> students = studentDao.getStuedents();

			for (Student s : students) {

				System.out.println(s);
			}
		}
		
		
		inputScanner.close();
		context.close();
	}
}
