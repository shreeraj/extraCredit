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
import cs544.domain.Movie;
import cs544.model.Artist_DAO;
import cs544.model.MovieDAO;

@Controller
public class ArtistController {
	@Resource
	private MovieDAO moviedDAO;
	@Resource
	private Artist_DAO artistDAO;

	@RequestMapping(value = "/artist/edit/{id}", method = RequestMethod.GET)
	public String editArtist(Model model, @PathVariable int id) throws Exception {
		Artist artist = artistDAO.getArtist(id);
		model.addAttribute("artistForm", artist);
		return "artistForm";
	}

	@RequestMapping(value = "/artist/edit/{id}", method = RequestMethod.POST)
	public String updateArtist(@ModelAttribute("artistForm") Artist artist, @PathVariable int id, final RedirectAttributes redirectAttributes) throws Exception {
		artist.setId(id);
		artistDAO.modifyArtist(artist);
		redirectAttributes.addFlashAttribute("message", "Artist Updated Successfully..");
		return "redirect:/home";
	}
	
	@RequestMapping(value = "/artist/delete/{id}", method = RequestMethod.GET)
	public String deleteArtist(@PathVariable int id, final RedirectAttributes redirectAttributes) throws Exception {
		artistDAO.deleteArtist(artistDAO.getArtist(id));
		redirectAttributes.addFlashAttribute("message", "Artist Deleted Successfully..");
		return "redirect:/home";
	}
}
