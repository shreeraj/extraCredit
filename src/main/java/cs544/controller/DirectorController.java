package cs544.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cs544.domain.Artist;
import cs544.domain.Director;
import cs544.domain.Movie;
import cs544.model.Artist_DAO;
import cs544.model.Director_DAO;
import cs544.model.MovieDAO;

@Controller
public class DirectorController {
	@Resource
	private MovieDAO moviedDAO;
	@Resource
	private Artist_DAO artistDAO;
	@Resource
	private Director_DAO directorDAO;

	@RequestMapping(value = "/director/edit/{id}", method = RequestMethod.GET)
	public String editDirector(Model model, @PathVariable int id) throws Exception {
		Director director = directorDAO.getDirector(id);
		model.addAttribute("directorForm", director);
		return "directorForm";
	}

	@RequestMapping(value = "/director/edit/{id}", method = RequestMethod.POST)
	public String updateDirector(@ModelAttribute("directorForm") Director director, @PathVariable int id, final RedirectAttributes redirectAttributes) throws Exception {
		director.setId(id);
		directorDAO.modifyDirector(director);
		redirectAttributes.addFlashAttribute("message", "Director Updated Successfully..");
		return "redirect:/home";
	}
	@RequestMapping(value = "/director/delete/{id}", method = RequestMethod.GET)
	public String deleteDirector(@PathVariable int id, final RedirectAttributes redirectAttributes) throws Exception {
		directorDAO.deleteDirector(directorDAO.getDirector(id));
		redirectAttributes.addFlashAttribute("message", "Director Deleted Successfully..");
		return "redirect:/home";
	}
	
	
}
