package byeonghoon.x595.contactbookdb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ContactRepositoryImpl implements IContactRepository {
	
	@Autowired
	private JdbcOperations jdbc;
	
	//some common queries
	private static final String SQL_INSERT = "insert into contact (id, firstName, lastName, phone, email) values (?, ?, ?, ?, ?)";
	private static final String SQL_DELETE = "delete from contact where id = ?";
	private static final String SQL_UPDATE = "update contact set firstName = ?, lastName = ?, phone = ?, email = ? where id = ?";
	private static final String SQL_QUERY_SELECT_BASE = "select * from contact ";
	
	///IContactRepository implementation

	@Override
	public boolean create(Contact c) {
		int rows = jdbc.update(SQL_INSERT, c.getId().toString(), c.getFirstName(), c.getLastName(), c.getPhone(), c.getEmail());
		
		return rows > 0;
	}

	@Override
	public boolean delete(Contact c) {
		int rows = jdbc.update(SQL_DELETE, c.getId().toString());
		
		return rows > 0;
	}

	@Override
	public boolean update(Contact c) {
		int rows = jdbc.update(SQL_UPDATE, c.getFirstName(), c.getLastName(), c.getPhone(), c.getEmail(), c.getId().toString());
		return rows > 0;
	}

	@Override
	public List<Contact> all() {
		
		return jdbc.query(SQL_QUERY_SELECT_BASE, new ContactRowMapper());
	}

	@Override
	public Contact byId(UUID id) {
		return jdbc.queryForObject(SQL_QUERY_SELECT_BASE + "where id = ?", new ContactRowMapper(), id.toString());
	}

	@Override
	public List<Contact> byLastName(String lastName) {
		return jdbc.query(SQL_QUERY_SELECT_BASE + "where lastName = ?", new ContactRowMapper(), lastName);
	}

}


class ContactRowMapper implements RowMapper<Contact> {

	@Override
	public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Contact(UUID.fromString(rs.getString("id"))
				         , rs.getString("firstName")
				         , rs.getString("lastName")
				         , rs.getString("phone")
				         , rs.getString("email"));
	}
	
}
