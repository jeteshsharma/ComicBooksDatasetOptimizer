package com.dell.projects.comicBooksDatasetOptimiser.config;

import java.util.Properties;

public class PropertiesSetter {

	private final static String dbName = "database_logparser";
	public Properties initializeProperties() {
		 Properties properties=new Properties();
//		 	properties.setProperty("hibernate.hbm2dml.auto","delete");
//		 	properties.setProperty("hibernate.hbm2ddl.auto","create");
		 	properties.setProperty("hibernate.hbm2ddl.auto","update");
	        
		 	properties.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
	        //properties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/monitor_oops");

//	        properties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/"+dbName);
		properties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3307/"+dbName);

		properties.setProperty("hibernate.connection.username", "root");
	        properties.setProperty("hibernate.connection.password", "12345");
	        properties.setProperty("hibernate.show_sql", "true");
	        properties.setProperty("hibernate.current_session_context_class","thread");
	        properties.setProperty("hibernate.format_sql","TRUE");
	        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL57InnoDBDialect");
	        properties.setProperty("hibernate.cache.use_second_level_cache", "false");
	       // properties.setProperty("hibernate.jdbc.batch_size", "100");
	        properties.setProperty("hibernate.connection.autocommit","false");
	        
		
		return properties;
		
	}
	
	

}
