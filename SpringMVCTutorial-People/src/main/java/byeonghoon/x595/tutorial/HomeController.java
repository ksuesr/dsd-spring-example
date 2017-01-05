package byeonghoon.x595.tutorial;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
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
	
	
	
	private List<Person> people;
	
	
	@PostConstruct 
	public void initPeople() {
		people = new ArrayList<Person>();
		
		people.add(new Person("John", 12, "Male"));
		people.add(new Person("Sharon", 23, "Female"));
		people.add(new Person("Jane", 25, "Female"));
		people.add(new Person("Peter", 34, "Male"));
		people.add(new Person("Betty", 47, "Female"));
		people.add(new Person("James", 52, "Male"));
	}
	
	@RequestMapping(value="/people", method=RequestMethod.GET) 
	public String getPeople(Model model) {
		
		
		model.addAttribute("people", people);
		
		return "people";
	}
	
	@RequestMapping(value="/people/check/{name}", method=RequestMethod.GET)
	public String checkAge(@PathVariable String name, Model model) {
		
		
		for(Person p : people) {
			if(p.getName().equalsIgnoreCase(name)) {
				model.addAttribute("person", p);
			}
		}
		if(!model.containsAttribute("person")) {
			model.addAttribute("person", new Person("null", -1, "abc"));
		}
		
		return "check";
	}
	
}
