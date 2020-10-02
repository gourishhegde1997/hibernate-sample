package com.hibernate.dao;

import java.util.List;

import com.hibernate.entity.StudentEntity;

public interface PracticeApplicationDAO {

	public void addNewStudent(StudentEntity student);

	public StudentEntity getStudentById(Integer studentId);

	public void updateStudentName(Integer studentId, String studentName);

	public void deleteStudentById(Integer studentId);

	public List<StudentEntity> filterStudentsByGrade(char grade);

	public void deleteStudentByIdHQL(Integer id);

}
