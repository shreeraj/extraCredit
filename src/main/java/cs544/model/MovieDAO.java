package cs544.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import cs544.controller.HibernateUtil;
import cs544.domain.Genere;
import cs544.domain.Movie;
import cs544.domain.Rating;
@Transactional
public class MovieDAO {
	private SessionFactory sf;

	public MovieDAO(SessionFactory sf) {
		this.sf = sf;
	}

	public void addMovie(Movie movie) throws Exception {
		// Session sf = HibernateUtil.getSessionFactory().getCurrentSession();
		// Transaction tx = null;

		try {
			// tx = sf.beginTransaction();
			sf.getCurrentSession().persist(movie);
			// tx.commit();

		} catch (Exception e) {
			// if (tx != null)
			// tx.rollback();
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	public List<Movie> getAllMovie() {
		// Session sf = HibernateUtil.getSessionFactory().getCurrentSession();
		List<Movie> movies = new ArrayList<Movie>();
		// Transaction tx = null;
		try {
			// tx = sf.beginTransaction();
			Query criteria = sf.getCurrentSession().createQuery("From Movie mov");
			movies = criteria.list();
			// tx.commit();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return movies;
	}

	@SuppressWarnings("unchecked")
	public List<Movie> searchMovie(String movie_name) {
		// Session sf = HibernateUtil.getSessionFactory().getCurrentSession();
		@SuppressWarnings("unused")
		// Transaction tx = null;
		List<Movie> movies = new ArrayList<Movie>();
		// System.out.println(movie_name);
		try {

			// tx = sf.beginTransaction();
			Query criteria = sf.getCurrentSession().createQuery("From Movie mov where mov.title like :movie_name");
			criteria.setParameter("movie_name", "%" + movie_name + "%");

			movies = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return movies;
	}

	@SuppressWarnings("unchecked")
	public List<Movie> searchMovieByGenere(Genere movie_genere) {
		// Session sf = HibernateUtil.getSessionFactory().getCurrentSession();
		@SuppressWarnings("unused")
		// Transaction tx = null;
		List<Movie> movies = new ArrayList<Movie>();

		try {

			// tx = sf.beginTransaction();
			Query criteria = sf.getCurrentSession().createQuery("FROM Movie m WHERE :genere in elements(m.genere)");
			criteria.setParameter("genere", movie_genere);

			movies = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return movies;
	}

	@SuppressWarnings("unchecked")
	public List<Movie> searchMovieByRating(Rating movie_rating) {
		// Session sf = HibernateUtil.getSessionFactory().getCurrentSession();
		@SuppressWarnings("unused")
		// Transaction tx = null;
		List<Movie> movies = new ArrayList<Movie>();

		try {

			// tx = sf.beginTransaction();
			Query criteria = sf.getCurrentSession().createQuery("FROM Movie m WHERE m.rating = :rating");
			criteria.setParameter("rating", movie_rating);

			movies = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return movies;
	}

	@SuppressWarnings("unchecked")
	public List<Movie> searchMovieByYear(String year) {
		// Session sf = HibernateUtil.getSessionFactory().getCurrentSession();
		@SuppressWarnings("unused")
		// Transaction tx = null;
		List<Movie> movies = new ArrayList<Movie>();

		try {

			// tx = sf.beginTransaction();
			Query criteria = sf.getCurrentSession().createQuery("From Movie mov where mov.year like :movie_name");
			criteria.setParameter("movie_name", "%" + year + "%");
			;

			movies = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return movies;
	}

	public List<Movie> searchMovieByArtistName(String artist_name) {
		// Session sf = HibernateUtil.getSessionFactory().getCurrentSession();
		@SuppressWarnings("unused")
		// Transaction tx = null;
		List<Movie> movies = new ArrayList<Movie>();

		try {

			// tx = sf.beginTransaction();
			Query criteria = sf.getCurrentSession()
					.createQuery("SELECT m FROM Movie m JOIN m.artist a where a.name = :artist_name");
			criteria.setParameter("artist_name", artist_name);

			movies = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return movies;
	}

	public List<Movie> searchMovieByDirector(String director_name) {
		// Session sf = HibernateUtil.getSessionFactory().getCurrentSession();
		@SuppressWarnings("unused")
		// Transaction tx = null;
		List<Movie> movies = new ArrayList<Movie>();

		try {

			// tx = sf.beginTransaction();
			Query criteria = sf.getCurrentSession()
					.createQuery("SELECT m FROM Movie m JOIN m.director d where d.name = :director_name");
			criteria.setParameter("director_name", director_name);

			movies = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return movies;
	}

	public Movie retriveMovie(int id) throws Exception {

		// Session sf = HibernateUtil.getSessionFactory().getCurrentSession();
		// Transaction tx = null;
		Movie movie = new Movie();
		try {

			// tx = sf.beginTransaction();
			movie = (Movie) sf.getCurrentSession().get(Movie.class, id);
			// tx.commit();

		} catch (Exception e) {
			// if (tx != null)
			e.printStackTrace();
			// throw new Exception(e);
		}
		return movie;
	}

	public void modifyMovie(Movie mov) throws Exception {

//		Session sf = HibernateUtil.getSessionFactory().getCurrentSession();
//		Transaction tx = null;

		try {

//			tx = sf.beginTransaction();
			sf.getCurrentSession().merge(mov);
//			tx.commit();
		} catch (Exception e) {

			
			e.printStackTrace();
		
		}
	}

	public void deleteMovie(Movie mov) throws Exception {

//		Session sf = HibernateUtil.getSessionFactory().getCurrentSession();
//		Transaction tx = null;
		try {
//			tx = sf.beginTransaction();
			sf.getCurrentSession().delete(mov);
//			tx.commit();
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
	}
}
