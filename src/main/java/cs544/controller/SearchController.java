package cs544.controller;



import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cs544.domain.Genere;
import cs544.domain.Movie;
import cs544.domain.Rating;
import cs544.model.MovieDAO;

@Controller
public class SearchController {
	@Resource
	private MovieDAO movieDAO;
	
	@RequestMapping(value = "movie/search", method = RequestMethod.GET)
	public String searchMovie(Model model) {
		Movie movie = new Movie();
	
		return "searchMovie";
	}
	
	@RequestMapping(value = "movie/searchByTitle", method = RequestMethod.GET)
	public String searchByTitle(@RequestParam("title") String title, Model model) {
		List<Movie> searchMovies = movieDAO.searchMovie(title);
		model.addAttribute("movies",searchMovies);
		return "searchResult";
	}
	
	@RequestMapping(value = "movie/searchByYear", method = RequestMethod.GET)
	public String searchByYear(@RequestParam("year") String year, Model model) {
		List<Movie> searchMovies = movieDAO.searchMovieByYear(year);
		model.addAttribute("movies",searchMovies);
		return "searchResult";
	}
	
	@RequestMapping(value = "movie/searchByArtist", method = RequestMethod.GET)
	public String searchByArtist(@RequestParam("artist") String artist, Model model) {
		List<Movie> searchMovies = movieDAO.searchMovieByArtistName(artist);
		model.addAttribute("movies",searchMovies);
		return "searchResult";
	}
	
	@RequestMapping(value = "movie/searchByDirector", method = RequestMethod.GET)
	public String searchByDirector(@RequestParam("director") String director, Model model) {
		List<Movie> searchMovies = movieDAO.searchMovieByDirector(director);
		model.addAttribute("movies",searchMovies);
		return "searchResult";
	}
	
	@RequestMapping(value = "movie/searchByRating", method = RequestMethod.GET)
	public String searchByRating(@RequestParam("rating") Rating rating, Model model) {
		List<Movie> searchMovies = movieDAO.searchMovieByRating(rating);
		model.addAttribute("movies",searchMovies);
		return "searchResult";
	}
	
	@RequestMapping(value = "movie/searchByGenere", method = RequestMethod.GET)
	public String searchByGenere(@RequestParam("genere") Genere genere, Model model) {
		List<Movie> searchMovies = movieDAO.searchMovieByGenere(genere);
		model.addAttribute("movies",searchMovies);
		return "searchResult";
	}
	
	@ModelAttribute("genere")
	public Genere[] getGenere() {
		return Genere.values();
	}

	@ModelAttribute("rating")
	public Rating[] getRating() {
		return Rating.values();
	}
}
