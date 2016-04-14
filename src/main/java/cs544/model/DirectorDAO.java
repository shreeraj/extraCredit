package cs544.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import cs544.controller.HibernateUtil;
import cs544.domain.Artist;
import cs544.domain.Director;


@Transactional
public class DirectorDAO {
	private SessionFactory sf;
	
	public DirectorDAO(SessionFactory sf){
		this.sf = sf;
	}
	
	public List<Director> getAllDirectors() {
//		Session sf = HibernateUtil.getSessionFactory().getCurrentSession();
		List<Director> directors = new ArrayList<Director>();
		Transaction tx = null;
		try {
//			tx = sf.beginTransaction();
			Query criteria = sf.getCurrentSession().createQuery("From Director dir");
			directors = criteria.list();
//			tx.commit();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return directors;
	}
	
	public void addDirector(Director director) throws Exception {

//		Session sf = HibernateUtil.getSessionFactory().getCurrentSession();
//		Transaction tx = sf.getTransaction();

		try {
//			tx.begin();
			sf.getCurrentSession().persist(director);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
    public Director getDirector(int id) throws Exception{
		
//		Session sf = HibernateUtil.getSessionFactory().getCurrentSession();
//		Transaction tx = null;
    	Director director = new Director();
		try {
			
//			tx = sf.getCurrentSession()beginTransaction();
			 director = (Director) sf.getCurrentSession().get(Director.class, id);
			
			
		} catch (Exception e) {
//			if(tx != null)
			e.printStackTrace();
//			throw new Exception(e);
		}
		return director;
	}
	
		
	public void modifyDirector(Director direct) throws Exception{
		
//		Session sf = HibernateUtil.getSessionFactory().getCurrentSession();
//		Transaction tx = null;
		
		try {
			
//			tx = sf.beginTransaction();			
			sf.getCurrentSession().merge(direct);			
//			tx.commit();			
		} catch (Exception e) {

//			if(tx != null) tx.rollback();
			e.printStackTrace();
//			throw new Exception(e);			
		}	
	}
	
	public void deleteDirector(Director direct)throws Exception{
		
//		Session sf = HibernateUtil.getSessionFactory().getCurrentSession();
//		Transaction tx = null;		
		try {			
//			tx = sf.beginTransaction();			
			sf.getCurrentSession().delete(direct);			
//			tx.commit();		
		} catch (Exception e) {
//			if(tx != null) tx.rollback();
			e.printStackTrace();
//			throw new Exception(e);			
		}
	}
}
