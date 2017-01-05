package byeonghoon.x595.translate;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	
	@RequestMapping(value = "/piglatinmvc/translate", method = RequestMethod.GET)
	public String translateParam(@RequestParam(value="word", defaultValue="hello") String toTranslate, Model model) {
		
		String res = Translator.translate(toTranslate);
		
		model.addAttribute("target", toTranslate );
		model.addAttribute("result", res);
		
		return "result";
	}
	
	@RequestMapping(value = "/piglatinmvc/translate/{word}", method = RequestMethod.GET)
	public String translatePath(@PathVariable String word, Model model) {
		
		String res = Translator.translate(word);
		
		model.addAttribute("target", word );
		model.addAttribute("result", res);
		
		return "result";
	}
	
	@RequestMapping(value="/piglatinmvc/form", method = RequestMethod.GET)
	public String getInputForm(Model model) {
		return "form";
	}
	
	@RequestMapping(value = "/piglatinmvc/form", method = RequestMethod.POST)
	public String translateForm(String word, Model model) {
		
		String res = Translator.translate(word);
		
		model.addAttribute("target", word );
		model.addAttribute("result", res);
		
		return "result";
	}
	
	
}
