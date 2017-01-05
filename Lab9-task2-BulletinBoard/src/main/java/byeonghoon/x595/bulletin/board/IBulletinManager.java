package byeonghoon.x595.bulletin.board;

import java.util.UUID;

public interface IBulletinManager {

	public void addMessage(Message e);
	
	public Message getMessageById(UUID uuid);
	
	public java.util.List<Message> getMessagesByAuthor(String authorName);
	
	public java.util.List<Message> getAllMessages();
	
}
