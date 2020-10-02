package com.hibernate.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.config.HibernateUtil;
import com.hibernate.entity.StudentEntity;

public class PracticeApplicationDAOImpl implements PracticeApplicationDAO {

	final static Logger logger = Logger.getLogger(PracticeApplicationDAOImpl.class);

	@Override
	public void addNewStudent(StudentEntity student) {
		System.out.println("Inside PracticeApplicationDAOImpl::addNewStudent(StudentEntity student) method");
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(student);
		transaction.commit();
		session.close();
	}

	@Override
	public StudentEntity getStudentById(Integer studentId) {
		System.out.println("Inside PracticeApplicationDAOImpl::getStudentById(Integer studentId) method");
		Session session = HibernateUtil.getSessionFactory().openSession();
//		Transaction txn = session.beginTransaction();
		StudentEntity student = (StudentEntity) session.get(StudentEntity.class, studentId);
//		or load() method can also be used as below
//		StudentEntity student = (StudentEntity) session.load(StudentEntity.class, studentId);
//		System.out.println(student.toString());
		session.close();
		return student;
	}

	@Override
	public void updateStudentName(Integer studentId, String studentName) {
		System.out.println(
				"Inside PracticeApplicationDAOImpl::updateStudentName(Integer studentId, String studentName) method");
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			StudentEntity student = (StudentEntity) session.get(StudentEntity.class, studentId);
			session.getTransaction().begin();
			student.setStudentName(studentName);
			session.saveOrUpdate(student);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			logger.fatal(e.getMessage(), e);
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteStudentById(Integer studentId) {
		System.out.println("Inside PracticeApplicationDAOImpl::deleteStudentById(Integer studentId) method");
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = null;
		try {
			session = sessionFactory.openSession();
			StudentEntity student = (StudentEntity) session.load(StudentEntity.class, studentId);
			session.beginTransaction();
			session.delete(student);
			session.getTransaction().commit();
			session.clear();
		} catch (ObjectNotFoundException e) {
			System.out.println("Data not found");
			logger.warn("Data to be deleted doesnot exits in database");
			logger.error(e.getMessage(), e);
			session.getTransaction().rollback();
		} catch (HibernateException e) {
			e.printStackTrace();
			logger.fatal(e.getMessage(), e);
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StudentEntity> filterStudentsByGrade(char grade) {
		System.out.println("Inside PracticeApplicationDAOImpl::filterStudentsByGrade(char grade) method");
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = null;
		List<StudentEntity> studentList = null;
		try {
			session = sessionFactory.openSession();
			Query query = session.createQuery("from StudentEntity se where se.grade=:grade");
			query.setParameter("grade", grade);
			studentList = query.list();
		} catch (Exception e) {
			logger.fatal(e.getMessage());
			e.printStackTrace();
		} finally {
			session.clear();
		}
		return studentList;
	}

	@Override
	public void deleteStudentByIdHQL(Integer id) {
		System.out.println("Inside PracticeApplicationDAOImpl::deleteStudentByIdHQL(Integer id) method");
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Query selectQuery = session.createQuery("from StudentEntity where studentId = :id");
			selectQuery.setParameter("id", id);
			session.beginTransaction();
			StudentEntity student = (StudentEntity) selectQuery.uniqueResult();
			Query query = session.createQuery("delete from StudentEntity where studentId = :id");
			query.setParameter("id", id);
			int count = query.executeUpdate();
			System.out.println("No. of records deleted : " + count);
			if (student.getLocker() != null) {
				int lockerId = student.getLocker().getLockerId();
				Query deleteQuery = session.createQuery("delete from LockerEntity where lockerId = :lockerId");
				deleteQuery.setParameter("lockerId", lockerId);
				deleteQuery.executeUpdate();
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
