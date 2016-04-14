package cs544.controller;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import cs544.domain.Artist;
import cs544.domain.Director;
import cs544.domain.Movie;
import cs544.domain.Picture;



public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	
	static{
		try {
			
			Configuration configuration = new Configuration();
			configuration.addAnnotatedClass(Director.class);
			configuration.addAnnotatedClass(Artist.class);
			configuration.addAnnotatedClass(Movie.class);
			configuration.addAnnotatedClass(Picture.class);
			configuration.configure();
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			
			
		} catch (Throwable e) {
			
			e.printStackTrace();	
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}

}
