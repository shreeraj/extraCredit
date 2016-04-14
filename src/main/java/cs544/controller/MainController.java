package cs544.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cs544.domain.Artist;
import cs544.domain.Director;
import cs544.domain.Genere;
import cs544.domain.Movie;
import cs544.domain.Rating;
import cs544.model.ArtistDAO;
import cs544.model.DirectorDAO;
import cs544.model.MovieDAO;

@Controller
public class MainController {
	@Resource
	private MovieDAO movieDAO;
	@Resource
	private ArtistDAO artistDAO;
	@Resource
	private DirectorDAO directorDAO;

	@RequestMapping("/")
	public String redirectRoot() {
		return "redirect:/home";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("movies", movieDAO.getAllMovie());
		model.addAttribute("artists",artistDAO.getAllArtist());
		model.addAttribute("directors",directorDAO.getAllDirectors());
		return "index";
	}

	@RequestMapping(value = "/movie/add", method = RequestMethod.GET)
	public String addMovie(Model model) {
		Movie movie = new Movie();
	
		model.addAttribute("movieForm", movie);
		

		return "addMovie";
	}

	@RequestMapping(value = "/movie/add", method = RequestMethod.POST)
	public String saveMovie(@ModelAttribute("movieForm") Movie movie, BindingResult result, Model model) {
		try {
			movieDAO.addMovie(movie);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return "redirect:/home";
	}

	@RequestMapping(value = "/home/addMovie", method = RequestMethod.POST)
	public String addMov(Model model) {
		return "redirect:/home";
	}

	@RequestMapping(value = "/movie/delete/{id}", method = RequestMethod.GET)
	public String deleteMovie(Model model, @PathVariable int id, final RedirectAttributes redirectAttributes)
			throws Exception {

		movieDAO.deleteMovie(movieDAO.retriveMovie(id));
		redirectAttributes.addFlashAttribute("message", "Movie Deleted Successfully..");
		return "redirect:/home";
	}



	@RequestMapping(value = "/movie/edit/{id}", method = RequestMethod.GET)
	public String editMovie(Model model, @PathVariable int id) throws Exception {
		
		Movie mov = movieDAO.retriveMovie(id);
		model.addAttribute("movieForm",mov);
		return "addMovie";
	}
	
	@RequestMapping(value = "/movie/edit/update/{id}", method = RequestMethod.POST)
	public String updateMovie(@PathVariable int id,  @ModelAttribute("movieForm") Movie movie, BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		try {
			movie.setId(id);
			movieDAO.modifyMovie(movie);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		redirectAttributes.addFlashAttribute("message", "Movie Updated Successfully..");
		return "redirect:/home";
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
