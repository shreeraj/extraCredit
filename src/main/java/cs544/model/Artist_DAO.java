package cs544.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import cs544.controller.HibernateUtil;
import cs544.domain.Artist;
import cs544.domain.Movie;

public class Artist_DAO {
	private SessionFactory sf;
	public Artist_DAO(SessionFactory sf){
		this.sf = sf;
	}
	
	public List<Artist> getAllArtist() {
		Session sf = HibernateUtil.getSessionFactory().getCurrentSession();
		List<Artist> artists = new ArrayList<Artist>();
		Transaction tx = null;
		try {
			tx = sf.beginTransaction();
			Query criteria = sf.createQuery("From Artist art");
			artists = criteria.list();
			sf.getTransaction().commit();
			//			tx.commit();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return artists;
	}

	public void addArtist(Artist artist) throws Exception {
		Session sf = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = sf.getTransaction();

		try {
			tx.begin();
			sf.persist(artist);

		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	public Artist retriveartist(int id) throws Exception {

		Session sf = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;

		try {

			tx = sf.beginTransaction();
			Artist artist = (Artist) sf.get(Artist.class, id);
			return artist;

		} catch (Exception e) {
			if (tx != null)
				e.printStackTrace();
			throw new Exception(e);
		}
	}

	public void modifyArtist(Artist art) throws Exception {

		Session sf = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;

		try {

			tx = sf.beginTransaction();
			sf.merge(art);
			tx.commit();
		} catch (Exception e) {

			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	public void deleteArtist(Artist art) throws Exception {

		Session sf = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = sf.beginTransaction();
			sf.delete(art);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			throw new Exception(e);
		}
	}

}
