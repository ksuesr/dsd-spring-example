package byeonghoon.x595.bulletin.board;

import java.util.UUID;

public class Message {
	
	private UUID id;
	
	private String author;
	
	private String subject;
	
	private String body;
	
	
	//Ctors.
	
	public Message() {this("a", "b", "c");}
	
	public Message(String author, String subject, String body) {
		id = UUID.randomUUID();
		this.author = author;
		this.subject = subject;
		this.body = body;
	}

	public UUID getId() {
		return id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

}
