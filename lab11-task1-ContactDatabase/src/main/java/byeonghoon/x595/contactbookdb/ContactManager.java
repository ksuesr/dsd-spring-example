package byeonghoon.x595.contactbookdb;


import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactManager implements IContactManager {
	
	
	@Autowired
	private IContactRepository repo;
	
	public ContactManager() {
	}
	
	
	@Override
	public boolean addContact(Contact c) {
		return repo.create(c);
	}

	@Override
	public boolean deleteContact(Contact c) {
		return repo.delete(c);
	}

	@Override
	public boolean editContact(Contact c) {
		return repo.update(c);
	}

	@Override
	public List<Contact> getContacts() {
		return repo.all();
	}

	@Override
	public Contact getContactById(UUID uuid) {
		return repo.byId(uuid);
	}

	@Override
	public List<Contact> getContactsByLastName(String lastname) {
		return repo.byLastName(lastname);
	}

}
