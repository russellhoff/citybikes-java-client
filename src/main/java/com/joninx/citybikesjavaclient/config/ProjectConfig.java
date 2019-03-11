package com.joninx.citybikesjavaclient.config;

import java.io.File;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import lombok.Getter;

@Getter
public class ProjectConfig {

	private static final Logger log = LogManager.getLogger(ProjectConfig.class);
	
	private static final ProjectConfig INSTANCE = new ProjectConfig();
	private Configurations configs = null;
	
	private String baseUrl;
	
	private ProjectConfig() {
		configs = new Configurations();
		try{
		    Configuration config = configs.properties(new File("application.properties"));
		    // access configuration properties
		    baseUrl = config.getString("citybikes.baseurl");
		}catch (ConfigurationException e){
			log.error("Error ConfigurationException. ", e);
		}
	}
	
	public static ProjectConfig getInstance() {
		return INSTANCE;
	}
	
}
