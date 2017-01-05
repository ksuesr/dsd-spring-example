package byeonghoon.x595.contactclient;

import java.util.UUID;

public class Contact {

	private UUID id;
	
	private String firstName;
	
	private String lastName;
	
	private String phone;
	
	private String email;
	
	
	//Ctors
	public Contact() {
		this("a", "b", "c", "d");
	}
	
	public Contact(String f, String l, String p, String e) {
		this.id = UUID.randomUUID();
		this.firstName = f;
		this.lastName = l;
		this.phone = p;
		this.email = e;
	}
	
	//Getter/Setter
	
	public UUID getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString() {
		return id.toString() + ": " + firstName + " " + lastName + " (" + phone + ", " + email + ")";
	}
	
	public boolean equals(Object other) {
		if(other instanceof Contact) {
			Contact o = (Contact) other;
			return this.id.equals(o.id);
		}
		//CANNOT compare
		return false;
	}
	
}
