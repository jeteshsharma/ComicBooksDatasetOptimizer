package com.dell.projects.comicBooksDatasetOptimiser.config;

import com.dell.projects.comicBooksDatasetOptimiser.entity.*;
import com.dell.projects.comicBooksDatasetOptimiser.entity.ComicCharacter;
import org.hibernate.cfg.Configuration;

import java.util.Properties;



public class Configurer {
	public Configuration startConfigurationAndAddClasses(Properties properties) {
		Configuration configuration = new Configuration().setProperties(properties);
	    configuration.addAnnotatedClass(Category.class);
	    configuration.addAnnotatedClass(Power.class);
	    configuration.addAnnotatedClass(Planet.class);
	    configuration.addAnnotatedClass(ComicCharacter.class);
		return configuration;
	}

}
