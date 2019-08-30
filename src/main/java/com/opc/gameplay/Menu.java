package com.opc.gameplay;

import java.io.IOException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Menu {
	
	public Mode modeDeJeu = new Mode();;
	

	 public void displayAvaillableMenu() {
	        System.out.println("Choisissez votre mode de jeux");
	        System.out.println("Tapez 1 - Pour le Mode Chalengeur");
	        System.out.println("Tapez 2 - Pour le mode Defenseur");
	        System.out.println("Tapez 3 - Pour le mode Duel");
	        System.out.println("Entrez votre reponse ici");
	    }
	 
	 

	    /*
	    /**
	     * Display a selected menu.
	     * @param nbMenu The selected menu.
	     */
	    public void displaySelectedMenu(int nbMenu) {
	    	 switch (nbMenu) {
	            case 1:
	            	modeDeJeu = new Mode();
	                System.out.println("Vous avez choisi Le mode de jeu : Chalenger");
	                 modeDeJeu.challenger();
	                break;
	            case 2:
	                System.out.println("Vous avez choisi Le mode de jeu : Defenseur");
	                break;
	            case 3:
	                System.out.println("Vous avez choisi Le mode de jeu  : Duel");
	                break;
	            default:
	                System.out.println("Vous n'avez pas choisi de Mode de jeu");
	                break;
	        }
	    }
	    
	    public void displayMenuFin() {
	        //System.out.println("Sous Menu");
	        System.out.println("Tapez X - Pour Quitter la partie");
	        System.out.println("Tapez R - Pour Rejouer");
	        System.out.println("Tapez M - Pour revenir au menu Principal");
	    		
	       
	    }
	    public void displaySelectedMenuFin(String finMenu) {
	    	 switch (finMenu) {
	            case "X":
	                System.out.println("Vous avez choisi de partir");
	                 modeDeJeu.quitter();
	                break;
	            case "R":
	                System.out.println("Vous avez choisi de Rejouer");
	                this.run();
	                
	                break;
	            case "M":
	                System.out.println("Vous avez choisi de revenir menu Principal");
	                this.run();
	                break;
	            default:
	                System.out.println("Vous n'avez Pas choisi une option");
	                this.closeMenu();
	                break;
	        }
	    }

	    public void run(){
	        this.displayAvaillableMenu();
	        Scanner sc = new Scanner(System.in);
	        int nb = sc.nextInt();
	        this.displaySelectedMenu(nb);

	    }

	    /**`
	     *
	     * @param nbSide
	     * @param allSidesEnable
	     */

	    public void displaySelectedSide(int nbSide, boolean allSidesEnable) {

	    }
	    
	    public void closeMenu() {
	    	
	      System.out.println("BYE  BYE");
	      
		        
	    	
	    	
	    }

}
