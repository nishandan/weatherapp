/**
 * 
 */
package com.nishan.dbs.config;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author nishandan.gobalakris
 *
 */	

@Component
//@Log4j2
@PropertySource("classpath:application.properties")
public class DBConnection {

	//@Value("${mongodb.uri}")
	//private static String dbUrl;

	public static void main(String[] args) {

		//log.info("DBConnection");
		
		/*
		
		String connectionString = "mongodb+srv://nishan:nishan123@nishandan-mongodb.totsm.mongodb.net/nishang?retryWrites=true&w=majority";
		try {
			MongoClient mongoClient = MongoClients.create(connectionString);
			List databases = mongoClient.listDatabases().into(new ArrayList<>());
			databases.forEach(db -> System.out.println(db.toString()));
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		*/
	
	}

}
