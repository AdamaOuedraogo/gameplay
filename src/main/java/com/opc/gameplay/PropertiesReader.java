package com.opc.gameplay;
import java.io.IOException;

import java.io.InputStream;

import java.util.Properties;

public class PropertiesReader {

	private Properties props = new Properties();

	/**

	 * This function will load fileProps into a Properties

	 *

	 * @param fileProps

	 * @throws IOException

	 */

	public void loadProperties(String fileProps) throws IOException {

		InputStream inpStream = null;

		try {

			inpStream = this.getClass().getClassLoader().getResourceAsStream(

					fileProps);

			this.props.load(inpStream);

		} finally {

			inpStream.close();

		}

	}

	/**

	 * This function return value from the 'key'

	 *

	 * @param key

	 * @return properties value

	 */

	public String get(String key) {

		return this.props.getProperty(key);

	}

	
}