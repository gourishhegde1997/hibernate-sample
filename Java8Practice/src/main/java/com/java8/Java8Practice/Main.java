package com.java8.Java8Practice;

import java.util.List;

import org.apache.log4j.Logger;

import com.hibernate.dao.PracticeApplicationDAO;
import com.hibernate.dao.PracticeApplicationDAOImpl;
import com.hibernate.entity.LockerEntity;
import com.hibernate.entity.StudentEntity;

public class Main {

	final static Logger logger = Logger.getLogger(Main.class);

	public static void main(String[] args) {

//		if(logger.isDebugEnabled()) {
//			logger.debug("===> DEBUG");
//		}
//		
//		if(logger.isInfoEnabled()) {
//			logger.info("===> INFO");
//		}
//		
//		logger.warn("===> WARN");
//		logger.error("===> ERROR");
//		logger.fatal("===> FATAL");

		PracticeApplicationDAO dao = new PracticeApplicationDAOImpl();

//		StudentEntity student = new StudentEntity(104, "Vikas Hegde", 'A');
//		dao.addNewStudent(student);

//		LockerEntity locker = new LockerEntity("Permanent", 18.50);
//		LockerEntity locker = null;
//		StudentEntity student2 = new StudentEntity("Jessy Pink", 'C', locker);
//		dao.addNewStudent(student2);
//		System.out.println(student2.toString());
//
//		List<StudentEntity> studentList = dao.filterStudentsByGrade('B');
//		if (studentList != null && !studentList.isEmpty()) {
//			for (StudentEntity std : studentList) {
//				System.out.println(std);
//			}
//		} else {
//			System.out.println("No students are there with such grade");
//		}
		dao.deleteStudentById(2);
//		dao.deleteStudentByIdHQL(3);

//		dao.updateStudentName(102,"Gourisha Hegde");
//		
//		dao.deleteStudentById(104);

	}
}
