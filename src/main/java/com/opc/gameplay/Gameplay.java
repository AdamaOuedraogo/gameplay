package com.opc.gameplay;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.opc.gameplay.properties.MyProperties;
import com.opc.gameplay.properties.PropertiesLoader;

public class Gameplay {
	
	private static Logger logger = LogManager.getLogger(Gameplay.class);
	Properties prop = new Properties();

	public static void main(String[] args) throws FileNotFoundException, IOException {
		PropertiesLoader p = new PropertiesLoader();
		p.displayProperties(p.loadProperties());
		logger.error("juste un test");
		
		
	
	}

}
