package com.opc.gameplay;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Mode {

	private static Logger logger = LogManager.getLogger(Mode.class);
	public PropertiesReader propsReader = null;
	public Menu menu = null;
	public static int NUMBER_TO_DETERMINE = 0;
	public static int COMBINAISON = 0;
	public static int ESSAI = 0;
	public static int RANDOM_NUMBER = 0;
	public  String mode = null;
	public String modeName = null;


	public void setModeName(String modeName) {
		this.modeName = modeName;
	}
	Scanner sc = new Scanner(System.in);




	public void  defenseur() {
		
		
		 int DEF_COMBINAISON;
		 int DEF_ESSAI;
		 int DEF_NUMBER_TO_DETERMINE;
		

		propsReader = new PropertiesReader();
		try {
			propsReader.loadProperties("app.properties");

		} catch (IOException e) {
			logger.error("Threw a IOException in " + this.getClass()+"::"+ this.getClass().getMethods() + " full stack trace follows:", e);
		}	
		//Recuperation de la combinaison 
		COMBINAISON = Integer.parseInt(propsReader.get("gameplay.combinaion.number"));
		//Recuperation du nombre d'essai 
		ESSAI = Integer.parseInt(propsReader.get("gameplay.essaie.number"));
		
		//generer la combinaison secrète
		NUMBER_TO_DETERMINE = this.generateRandomNumer(COMBINAISON);
		
		//recuperation du mode 
		 mode = propsReader.get("gameplay.mode.developpeur");
		 
			
			if(this.isDevelopper(mode)==true) {
				//Affichage de la combinaison à determiner
				System.out.println("voici la combinaison a determiner " + NUMBER_TO_DETERMINE);	
				
			}
			
		
		System.out.print(NUMBER_TO_DETERMINE);
		int COMPUTER_ESSAI = this.generateRandomNumer(COMBINAISON);
	
		

		String nbToDetermine = Integer.toString(NUMBER_TO_DETERMINE);
		String computerProp = Integer.toString(COMPUTER_ESSAI);

		for(int i = 1; i <= ESSAI; i++) {	

			//int nb = sc.nextInt();
			System.out.println(computerProp);
			//String userEssai = Integer.toString(nb);	
			
			
			/*
			boolean isWin = compareTwoString(userEssai, nbToDetermine);




			if((ESSAI-1) > 0 && !isWin) {
				System.out.println("Votre combinaison n'est pas gagnante il vous reste " + (ESSAI-i) + " essai(s)" );

			}else {
				menu = new Menu();
				menu.displayMenuFin();
				String finMenu =  sc.next();
				menu.displaySelectedMenuFin(finMenu);

			}
			*/

		}

	}
	

	public void duel() {

	}



	public void challenger() {	
		
		
		propsReader = new PropertiesReader();
		try {
			propsReader.loadProperties("app.properties");

		} catch (IOException e) {
			logger.error("Threw a IOException in " + this.getClass()+"::"+ this.getClass().getMethods() + " full stack trace follows:", e);
		}	
		//Recuperation de la combinaison 
		COMBINAISON = Integer.parseInt(propsReader.get("gameplay.combinaion.number"));
		
		//recuperation du mode 
		 mode = propsReader.get("gameplay.mode.developpeur");
		
		//Recuperation du nombre d'essai 
		ESSAI = Integer.parseInt(propsReader.get("gameplay.essaie.number"));	
		//generer la combinaison secrète
		NUMBER_TO_DETERMINE = this.generateRandomNumer(COMBINAISON);
		
		
		if(this.isDevelopper(mode)==true) {
			//Affichage de la combinaison à determiner
			System.out.println("voici la combinaison a determiner " + NUMBER_TO_DETERMINE);	
			
		}
		
		
		//Demande a l'utilisateurd de rentrer un mot de x chiffres	
		System.out.println("Entrez une combinaison de " + COMBINAISON + " chiffres");
		//System.out.println(this.win());

		String nbToDetermine = Integer.toString(NUMBER_TO_DETERMINE);

		for(int i = 1; i <= ESSAI; i++) {	

			int nb = sc.nextInt();	       
			String userEssai = Integer.toString(nb);		
			boolean isWin = compareTwoString(userEssai, nbToDetermine);

			if((ESSAI-i) > 0 && !isWin) {
				System.out.println("Votre combinaison n'est pas gagnante il vous reste " + (ESSAI-i) + " essai(s)" );

			}
			else {
				System.out.println("La partie est terminée, le nombre recherchée est "+ NUMBER_TO_DETERMINE );
				menu = new Menu();
				menu.displayMenuFin();
				int finMenu =  sc.nextInt();
				this.setModeName("challenger");
				menu.displaySelectedMenuFin(finMenu,"challenger");

			}



		}





	}




	public ArrayList<String> win(){
		ArrayList<String> win = new ArrayList<>();
		for(int i = 1; i <=COMBINAISON; i++) {

			win.add("=");		
		}
		return win;
	}
	
	
	
	public String getModeName() {
		return modeName;
		
	}




	public boolean compareTwoString(String s1, String s2) {

		boolean isWin = false;
		ArrayList<String> temp = new ArrayList<>();

		for (int i = 0; i < s1.length(); i++) {	

			if(s1.charAt(i) == s2.charAt(i)) {

				//System.out.println(s1.charAt(i) + " est identique à " + s2.charAt(i));
				temp.add("=");

			}else if (s1.charAt(i) > s2.charAt(i)) {
				temp.add(">");
				//System.out.println(s1.charAt(i) + " est superieur à " + s2.charAt(i));

			}else if (s1.charAt(i) < s2.charAt(i)) {
				temp.add("<");
				//System.out.println(s1.charAt(i) + " est inferieur à " + s2.charAt(i));

			}

		}

		if(temp.equals(this.win())){

			System.out.println("Vous avez gagnez la partie");
			isWin = true;

		}else {
			System.out.println("Perdu");
		}
		System.out.println(temp);
		return isWin;


	}





	public static int generateRandomNumer(int x) {
		Random rand = new Random(); 
		switch (x) {
		case 1:
			RANDOM_NUMBER  = rand.nextInt(10 - 1 + 1) + 1;
			break;		
		case 2:
			RANDOM_NUMBER  = rand.nextInt(100 - 10 + 1) + 10;
			break;		
		case 3:	
			RANDOM_NUMBER  = rand.nextInt(1000 - 100 + 1) + 100;
			break;
		case 4:
			RANDOM_NUMBER  = rand.nextInt(10000 - 1000 + 1) + 1000;
			break;		
		}
		return  RANDOM_NUMBER ;	
	}

	
	
	
	public boolean isDevelopper(String value) {
		
		boolean dev = false;
		
		if(value.equals("true")) {
			dev = true;
			
			
		}
		
		
		return dev;
	}






	public void  quitter() {
		Menu monMenu = new Menu();
		monMenu.closeMenu();

	}
	public void  rejouer() {

		Menu monMenu = new Menu();
		monMenu.run();


	}


}
