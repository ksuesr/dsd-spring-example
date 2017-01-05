package byeonghoon.x595.contactbookdb;

public interface IContactRepository {

	public boolean create(Contact c);
	
	public boolean delete(Contact c);
	
	public boolean update(Contact c);
	
	public java.util.List<Contact> all();
	
	public Contact byId(java.util.UUID id);
	
	public java.util.List<Contact> byLastName(String lastName);
}
