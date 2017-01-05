package byeonghoon.x595.contactbook;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class ContactManager implements IContactManager {
	
	private ArrayList<Contact> contact_list;
	
	public ContactManager() {
		init();
	}
	
	private void init() {
		contact_list = new ArrayList<Contact>();
	}

	@Override
	public boolean addContact(Contact c) {
		return contact_list.add(c);
	}

	@Override
	public boolean deleteContact(Contact c) {
		return contact_list.remove(c);
	}

	@Override
	public boolean editContact(Contact c) {
		UUID oldID = c.getId();
		Contact toEdit = getContactById(oldID);
		if(toEdit == null) {
			return false;
		}
		toEdit.setEmail(c.getEmail());
		toEdit.setFirstName(c.getFirstName());
		toEdit.setLastName(c.getLastName());
		toEdit.setPhone(c.getPhone());
		return true;
	}

	@Override
	public List<Contact> getContacts() {
		List<Contact> contacts = new ArrayList<Contact>();
		contacts.addAll(contact_list);
		return contacts;
	}

	@Override
	public Contact getContactById(UUID uuid) {
		Iterator<Contact> it = contact_list.iterator();
		while(it.hasNext()) {
			Contact c = it.next();
			
			if(uuid.equals(c.getId())) {
				return c;
			}
		}
		return null;
	}

}
