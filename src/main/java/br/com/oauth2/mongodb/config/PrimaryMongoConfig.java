package br.com.oauth2.mongodb.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author Nataniel Paiva
 */
@Configuration
@EnableMongoRepositories(basePackages = "br.com.oauth2.mongodb.repository",
		mongoTemplateRef = PrimaryMongoConfig.MONGO_TEMPLATE)
public class PrimaryMongoConfig {

	protected static final String MONGO_TEMPLATE = "primaryMongoTemplate";
}