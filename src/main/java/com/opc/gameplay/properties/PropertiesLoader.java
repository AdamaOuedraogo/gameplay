package com.opc.gameplay.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;

public class PropertiesLoader {
	

	  private final String propertiesFileName = "src/main/resources/app.properties";

	  /**
	   * Cette methode stoque le fichier Properties l'emplacement specifi
	   *
	   * @param props Le fichier stocker
	   * @param fileLocation L'emplacement ou le fichier est situé
	   * @param comments Commentaires
	   * @throws FileNotFoundException
	   * @throws IOException si une erreur est survenue lors de l'ecriture du fichier
	   */
	  public void saveProperties(final Properties props, final String fileLocation, final String comments)
	      throws FileNotFoundException, IOException {

	    final OutputStream out = new FileOutputStream(fileLocation);
	    props.store(out, comments);
	    out.flush();
	    out.close();
	  }

	  /**
	   * Cette m�thode lit un fichier Properties � l'emplacement sp�cifi�
	   *
	   * @param propertiesFileLocation L'emplacemnt du fichier
	   * @return Le fichier Properties charg�
	   * @throws FileNotFoundException si le fichier n'a pas �t� trouv�
	   * @throws IOException si une erreur est survenue durant la lecture
	   */
	public Properties loadProperties() throws FileNotFoundException, IOException {

	    final Properties props = new Properties();

	    props.load(new FileInputStream(this.getBasedir().concat(this.propertiesFileName)));

	    return props;
	  }

	  private String getBasedir() {

	    String basedir = System.getProperty("basedir");
	    if (basedir != null && !basedir.isEmpty()) {
	      final String normalizedBasedir = basedir.replace('\\', '/');
	      if (!normalizedBasedir.endsWith("/")) {
	        basedir = normalizedBasedir.concat("/");
	      } else {
	        basedir = normalizedBasedir;
	      }
	    } else {
	      basedir = "";
	    }
	    return basedir;
	  }

	  /**
	   * Cette methode affiche cahque paire [cle,valuer] d'un fichier Properties
	   *
	   * @param props Le fichier a afficher
	   */
	  public void displayProperties(final Properties props) {

	    String propertyValue = null;
	    String propertyName = null;
	    final Iterator<Object> it = props.keySet().iterator();
	    while (it.hasNext()) {
	      propertyName = (String) it.next();
	      propertyValue = props.getProperty(propertyName);
	      System.out.println(propertyName + "=" + propertyValue);
	    }
	  }

	  public MyProperties getProperties() throws FileNotFoundException, IOException {

	    final MyProperties myProperties = new MyProperties();
	    final Properties properties = this.loadProperties();
	    for (final Entry<Object, Object> entry : properties.entrySet()) {
	      final String propertyName = (String) entry.getKey();
	      final String propertyValue = (String) entry.getValue();
	      if (propertyName.equals("gameplay.mode.developpeur")) {
	        myProperties.setIsDefenseur(propertyValue);
	      } else if (propertyName.equals("gameplay.mode.challengeur")) {
	        myProperties.setIsChallengeur(propertyValue);
	      } else if (propertyName.equals("gameplay.mode.defenseur")) {
	        myProperties.setIsDefenseur(propertyValue);
	      } else if (propertyName.equals("gameplay.combinaion.number")) {
	        myProperties.setCombinaisonNumber(propertyValue);
	      } else if (propertyName.equals("gameplay.essaie.numbber")) {
	          myProperties.setEssaieNumber(propertyValue);
	       
	      } 

	    }
	    return myProperties;
	  }
	}



