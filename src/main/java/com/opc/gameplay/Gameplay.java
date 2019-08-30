package com.opc.gameplay;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Gameplay {
	
	private static Logger logger = LogManager.getLogger(Gameplay.class);
	public static void main(String[] args) {
		
		//Chargement du menu principal du Jeux
			Menu monMenu = new Menu();
			monMenu.run();

			
		
	
	}

}
