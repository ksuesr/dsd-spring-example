package byeonghoon.x595.contactbookdb;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Handles requests for the application home page.
 */
@RestController
public class ContactController {
	
	private static final Logger logger = LoggerFactory.getLogger(ContactController.class);
	
	@Autowired
	private IContactManager manager;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json")
	public boolean add(@RequestBody Contact c) {
		logger.info("Add contact " + c.getId());
		return manager.addContact(c);
	}
	
	@RequestMapping(value = "/del", method = RequestMethod.POST, consumes = "application/json")
	public boolean delete(@RequestBody Contact c) {
		logger.info("Delete contact " + c.getId());
		return manager.deleteContact(c);
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
	public List<Contact> all() {
		logger.info("Fetch all contacts");
		return manager.getContacts();
	}
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json")
	public Contact getById(@PathVariable UUID id) {
		logger.info("Select contact " + id);
		return manager.getContactById(id);
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST, consumes = "application/json")
	public boolean edit(@RequestBody Contact c) {
		logger.info("Edit contact " + c.getId());
		return manager.editContact(c);
	}
	
	@RequestMapping(value = "/lastname", method = RequestMethod.GET, produces = "application/json")
	public List<Contact> byLastName(@RequestParam(value = "name", defaultValue = "Doe") String lastName) {
		logger.info("Search contact with last name:  " + lastName);
		return manager.getContactsByLastName(lastName);
	}
	
}
