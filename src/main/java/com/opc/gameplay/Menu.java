package com.opc.gameplay;

import java.io.IOException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Menu {
	
	public Mode modeDeJeu = new Mode();
	

	 public void displayAvaillableMenu() {
	        System.out.println("Choisissez votre mode de jeux");
	        System.out.println("Tapez 1 - Pour le Mode Chalengeur");
	        System.out.println("Tapez 2 - Pour le mode Defenseur");
	        System.out.println("Tapez 3 - Pour le mode Duel");
	        System.out.println("Tapez 4 - Pour quitter");
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
	                modeDeJeu.defenseur();
	                break;
	            case 3:
	                System.out.println("Vous avez choisi Le mode de jeu  : Duel");
	                break;
	            default:
	                System.out.println("Vous n'avez pas choisi de Mode de jeu");
	                modeDeJeu = new Mode();
	                modeDeJeu.rejouer();
	                break;
	        }
	    }
	    
	    public void displayMenuFin() {
	        //System.out.println("Sous Menu");
	        System.out.println("Tapez 5 - Pour Quitter la partie");
	        System.out.println("Tapez 6 - Pour Rejouer");
	        System.out.println("Tapez 7 - Pour revenir au menu Principal");
	    		
	       
	    }
	    public void displaySelectedMenuFin(int finMenu, String mode) {
	    	  switch (finMenu) {
	            case 5:
	                System.out.println("Vous avez choisi de partir"); 
	                //Runtime.getRuntime().exit(0);
	               //System.exit(0);
	                this.closeMenu();
	                
	                break;
	            case 6:
	                System.out.println("Vous avez choisi de Rejouer");
	                if(mode=="Challenger") {
	                	modeDeJeu.challenger();
	                }else if (mode=="defenseur") {
	                	modeDeJeu.defenseur();
	                }else if (mode=="duel") {
	                	modeDeJeu.duel();
	                }
	                
	                break;
	            case 7:
	                System.out.println("Vous avez choisi de revenir menu Principal");
	                this.run();
	                break;
	            default:
	                System.out.println("Vous n'avez Pas choisi une option");
	                this.displayAvaillableMenu();
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
	      System.exit(0);
	      
		        
	    	
	    	
	    }

}
