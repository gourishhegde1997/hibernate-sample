package com.hibernate.config;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	private static String CONFIGURATION_XML_PATH = "com/hibernate/config/hibernate.cfg.xml";
	
	final static Logger logger = Logger.getLogger(HibernateUtil.class);
	
	public static SessionFactory getSessionFactory() {
		try {
			if(sessionFactory == null) {
				Configuration config = new Configuration().configure(CONFIGURATION_XML_PATH);
				ServiceRegistry builder = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
				sessionFactory = config.buildSessionFactory(builder);
			}
		} catch (Exception e) {
			logger.error("Exception occured at the time of session factory creation");
			logger.fatal(e.getMessage(), e);
		}
		return sessionFactory;
	}
	
	public static void closeSessionFactory() {
		if(sessionFactory != null) {
			sessionFactory.close();
		}
	}
}
