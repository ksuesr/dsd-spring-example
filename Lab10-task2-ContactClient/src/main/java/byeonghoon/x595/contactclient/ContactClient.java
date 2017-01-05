package byeonghoon.x595.contactclient;

import org.springframework.web.client.RestTemplate;

public class ContactClient {
	
	private static RestTemplate template;
	private static String host = "http://localhost:8080/contactbookdb";
	
	public static void main(String... args) {
		System.out.println("Testing contact book");
		template = new RestTemplate();
		
		System.out.println("1. Add some contacts");
		Contact c1 = new Contact("A", "Rod", "12345", "a@me.com");
		System.out.println("Contact c1: " + c1);
		Contact c2 = new Contact("B", "James", "445566", "b@me.com");
		System.out.println("Contact c2: " + c2);
		Contact c3 = new Contact("C", "Jane", "142857", "c@me.com");
		System.out.println("Contact c3: " + c3);
		Contact c4 = new Contact("D", "Alex", "1212121", "d@me.com");
		System.out.println("Contact c4: " + c4);
		
		template.postForLocation(host + "/add", c1);
		template.postForLocation(host + "/add", c2);
		template.postForLocation(host + "/add", c3);
		template.postForLocation(host + "/add", c4);
		
		System.out.println("2. Delete contact 2");
		boolean isSucceed = template.postForObject(host + "/del", c2, Boolean.class);
		System.out.println("Deletion of contact 2: " + isSucceed);
		
		System.out.println("3. Get all contacts");
		Contact[] contacts = template.getForObject(host + "/all", Contact[].class);
		int i = 1;
		for(Contact c : contacts) {
			System.out.print("Contact #" + (i++) + ": ");
			System.out.println(c);
		}
		
		System.out.println("4. Get contact c3");
		
		Contact target = template.getForObject(host + "/get/{id}", Contact.class, c3.getId());
		System.out.println("Received contact: " + target);
		System.out.println("And is equal to c3: " + (target.equals(c3)));
		
		System.out.println("5. Edit contact #1");
		c1.setFirstName("F");
		c1.setEmail("me@ajou.ac.kr");
		c1.setPhone("0000111");
		
		isSucceed = template.postForObject(host + "/edit", c1, Boolean.class);
		System.out.println("Editing of contact 1: " + isSucceed);
		target = template.getForObject(host + "/get/{id}", Contact.class, c1.getId());
		System.out.println("Edited contact: " + target);
		
		System.out.println("6. FindByLastName Alex");
		contacts = template.getForObject(host + "/lastname?name=Alex", Contact[].class);
		System.out.println("What I found: ");
		i = 1;
		for(Contact c : contacts) {
			System.out.print("Contact #" + (i++) + ": ");
			System.out.println(c);
		}
		
	}

}
