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
import cs544.domain.Movie;

@Transactional
public class ArtistDAO {
	private SessionFactory sf;
	public ArtistDAO(SessionFactory sf){
		this.sf = sf;
	}
	
	public List<Artist> getAllArtist() {
//		Session sf = HibernateUtil.getSessionFactory().getCurrentSession();
		List<Artist> artists = new ArrayList<Artist>();
//		Transaction tx = null;
		try {
//			tx = sf.beginTransaction();
			Query criteria = sf.getCurrentSession().createQuery("From Artist art");
			artists = criteria.list();
			
//			sf.getTransaction().commit();
			//			tx.commit();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return artists;
	}

	public void addArtist(Artist artist) throws Exception {
//		Session sf = HibernateUtil.getSessionFactory().getCurrentSession();
//		Transaction tx = sf.getTransaction();

		try {
//			tx.begin();
			sf.getCurrentSession().persist(artist);

		} catch (Exception e) {
//			if (tx != null)
//				tx.rollback();
			e.printStackTrace();
//			throw new Exception(e);
		}
	}

	public Artist getArtist(int id) throws Exception {

//		Session sf = HibernateUtil.getSessionFactory().getCurrentSession();
//		Transaction tx = null;
		Artist artist = new Artist();
		try {

//			tx = sf.beginTransaction();
			 artist = (Artist) sf.getCurrentSession().get(Artist.class, id);
			

		} catch (Exception e) {
//			if (tx != null)
				e.printStackTrace();
//			throw new Exception(e);
		}
		return artist;
	}

	public void modifyArtist(Artist art) throws Exception {

//		Session sf = HibernateUtil.getSessionFactory().getCurrentSession();
//		Transaction tx = null;

		try {

//			tx = sf.beginTransaction();
			sf.getCurrentSession().merge(art);
//			tx.commit();
		} catch (Exception e) {

//			if (tx != null)
//				tx.rollback();
//			e.printStackTrace();
//			throw new Exception(e);
		}
	}

	public void deleteArtist(Artist art) throws Exception {

//		Session sf = HibernateUtil.getSessionFactory().getCurrentSession();
//		Transaction tx = null;
		try {
//			tx = sf.beginTransaction();
			sf.getCurrentSession().delete(art);
//			tx.commit();
		} catch (Exception e) {
//			if (tx != null)
//				tx.rollback();
			e.printStackTrace();
//			throw new Exception(e);
		}
	}

}
