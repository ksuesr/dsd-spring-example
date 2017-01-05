package byeonghoon.x595.bulletin.board;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class BulletinManager implements IBulletinManager {
	
	
	private List<Message> message_list;
	
	public BulletinManager() {
		message_list = new ArrayList<Message>();
	}

	@Override
	public void addMessage(Message e) {
		// TODO Auto-generated method stub
		message_list.add(e);
	}

	@Override
	public Message getMessageById(UUID uuid) {
		// TODO Auto-generated method stub
		
		for(Message e : message_list) {
			if(uuid.compareTo(e.getId()) == 0) {
				return e;
			}
		}
		
		return null;
	}

	@Override
	public List<Message> getMessagesByAuthor(String authorName) {
		// TODO Auto-generated method stub
		ArrayList<Message> list = new ArrayList<Message>();
		
		for(Message e : message_list) {
			if(authorName.equalsIgnoreCase(e.getAuthor())) {
				list.add(e);
			}
		}
		
		return list;
	}

	@Override
	public List<Message> getAllMessages() {
		// TODO Auto-generated method stub
		ArrayList<Message> list = new ArrayList<Message>();
		list.addAll(message_list);
		
		return list;
	}

}
