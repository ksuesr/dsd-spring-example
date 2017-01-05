package byeonghoon.x595.bulletin;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import byeonghoon.x595.bulletin.board.IBulletinManager;
import byeonghoon.x595.bulletin.board.Message;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BBController {
	
	private static final Logger logger = LoggerFactory.getLogger(BBController.class);
	
	@Autowired
	private IBulletinManager manager;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/msg", method = RequestMethod.GET)
	public ModelAndView getById(@RequestParam(value="id", defaultValue="1") String id) {
		
		ModelAndView mv = new ModelAndView("show");
		Message message = manager.getMessageById(UUID.fromString(id));
		
		ArrayList<Message> dummy = new ArrayList<Message>();
		dummy.add(message);
		mv.addObject("list", dummy);
		
		return mv;
	}
	
	@RequestMapping(value = "/msg/{author}", method = RequestMethod.GET)
	public ModelAndView getByAuthor(@PathVariable String author) {
		
		ModelAndView mv = new ModelAndView("show");
		List<Message> messages = manager.getMessagesByAuthor(author);
		
		mv.addObject("list", messages);
		
		return mv;
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ModelAndView getAllMessages() {
		
		ModelAndView mv = new ModelAndView("show");
		List<Message> messages = manager.getAllMessages();
		
		mv.addObject("list", messages);
		
		return mv;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView showForm() {
		
		return new ModelAndView("form");
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView addMessage(Message msg) {
		
		manager.addMessage(msg);
		
		ModelAndView mv = new ModelAndView("show");
		ArrayList<Message> dummy = new ArrayList<Message>();
		dummy.add(msg);
		mv.addObject("list", dummy);
		
		return mv;
	}
	
}
