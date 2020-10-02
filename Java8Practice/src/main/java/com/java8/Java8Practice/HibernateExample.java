package com.java8.Java8Practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.hibernate.entity.MovieEntity;
import com.hibernate.entity.StudentEntity;

public class HibernateExample {

	public static void main(String[] args) {
		
		StudentEntity student = new StudentEntity();
		student.setStudentId(101);
		student.setStudentName("Sanmati Hegde");
		student.setGrade('A');
		
		MovieEntity movie = new MovieEntity("M01", "Movie1", "English", 100, 8000);
		
		Configuration config = new Configuration().configure("/com/java8/config/hibernate.cfg.xml"); //.addAnnotatedClass(StudentEntity.class);
//		config.addResource("com/hibernate/entity/MovieEntity.hbm.xml");
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		session.save(student);
		session.save(movie);
		transaction.commit();
		session.close();
		
	}

}
