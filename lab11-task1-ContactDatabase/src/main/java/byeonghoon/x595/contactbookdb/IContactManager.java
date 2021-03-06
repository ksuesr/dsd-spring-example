package byeonghoon.x595.contactbookdb;

public interface IContactManager {

	public boolean addContact(Contact c);
	
	public boolean deleteContact(Contact c);
	
	public boolean editContact(Contact c);
	
	public java.util.List<Contact> getContacts();
	
	public Contact getContactById(java.util.UUID uuid);
	
	public java.util.List<Contact> getContactsByLastName(String lastname);
	
}
