package byeonghoon.x595.contactbookdb;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
public class Config {

	@Bean public DataSource datasource() {
		return new EmbeddedDatabaseBuilder()
				       .setType(EmbeddedDatabaseType.H2)
				       .addScript("contact_schema.sql")
				       .build();
	}
	
	@Bean public JdbcOperations jdbctemplate(DataSource datasource) {
		return new JdbcTemplate(datasource);
	}
}
