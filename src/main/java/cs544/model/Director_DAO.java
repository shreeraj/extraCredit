package cs544.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import cs544.controller.HibernateUtil;
import cs544.domain.Artist;
import cs544.domain.Director;



public class Director_DAO {
	private SessionFactory sf;
	
	public Director_DAO(SessionFactory sf){
		this.sf = sf;
	}
	
	public List<Director> getAllDirectors() {
		Session sf = HibernateUtil.getSessionFactory().getCurrentSession();
		List<Director> directors = new ArrayList<Director>();
		Transaction tx = null;
		try {
			tx = sf.beginTransaction();
			Query criteria = sf.createQuery("From Director dir");
			directors = criteria.list();
			tx.commit();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return directors;
	}
	
	public void addDirector(Director director) throws Exception {

		Session sf = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = sf.getTransaction();

		try {
			tx.begin();
			sf.persist(director);

		} catch (Exception e) {
			if (tx != null)
			{
				tx.rollback(); e.printStackTrace();
			throw new Exception(e);
			}
		}
	}
    public Director retriveMovie(int id) throws Exception{
		
		Session sf = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;

		try {
			
			tx = sf.beginTransaction();
			Director direct = (Director) sf.get(Director.class, id);
			return direct;
			
		} catch (Exception e) {
			if(tx != null)
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	
		
	public void modifyMovie(Director direct) throws Exception{
		
		Session sf = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		
		try {
			
			tx = sf.beginTransaction();			
			sf.merge(direct);			
			tx.commit();			
		} catch (Exception e) {

			if(tx != null) tx.rollback();
			e.printStackTrace();
			throw new Exception(e);			
		}	
	}
	
	public void deleteMovie(Director direct)throws Exception{
		
		Session sf = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;		
		try {			
			tx = sf.beginTransaction();			
			sf.delete(direct);			
			tx.commit();		
		} catch (Exception e) {
			if(tx != null) tx.rollback();
			e.printStackTrace();
			throw new Exception(e);			
		}
	}
}
