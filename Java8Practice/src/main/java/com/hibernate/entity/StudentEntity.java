package com.hibernate.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "student")
@GenericGenerator(name = "id_gen", strategy = "increment")
public class StudentEntity {
	@Id
	@GeneratedValue(generator = "id_gen")
	@Column(name = "student_id")
	private int studentId;
	
	@Column(name = "student_name")
	private String studentName;
	
	private char grade;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "lockerId", unique = true)
	private LockerEntity locker;

	public LockerEntity getLocker() {
		return locker;
	}

	public void setLocker(LockerEntity locker) {
		this.locker = locker;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public char getGrade() {
		return grade;
	}

	public void setGrade(char grade) {
		this.grade = grade;
	}

	public StudentEntity(int studentId, String studentName, char grade) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.grade = grade;
		this.locker = null;
	}
	
	public StudentEntity(int studentId, String studentName, char grade, LockerEntity locker) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.grade = grade;
		this.locker = locker;
	}

	public StudentEntity(String studentName, char grade) {
		super();
		this.studentName = studentName;
		this.grade = grade;
		this.locker = null;
	}

	public StudentEntity(String studentName, char grade, LockerEntity locker) {
		super();
		this.studentName = studentName;
		this.grade = grade;
		this.locker = locker;
	}
	
	public StudentEntity() {
		super();
	}

	@Override
	public String toString() {
		return "StudentEntity [studentId=" + studentId + ", studentName=" + studentName + ", grade=" + grade
				+ ", locker=" + locker + "]";
	}

}
