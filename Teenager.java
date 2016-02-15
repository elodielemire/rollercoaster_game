/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rollercoaster;

import java.util.Scanner;
import rollercoaster.exception.NegativeFunException;
import rollercoaster.exception.NoTimeException;
import rollercoaster.exception.NoMoneyException;

/**
 * Cette classe représente un des Clients du parc : l'ado
 * @author isen
 */
public class Teenager extends Client {

    public Teenager() {
        super();
        time = 400;
        money = 120;
        health = 45;
        fun = 0;
        height = 185;
        size = "adult";
    }

	/**
	* Methode permettant à l'ado de faire une attraction
	* ses capitaux varient, et un commentaire spécifique à l'enfant s'affiche
	* @param attraction l'attraction choisie par l'ado
	*/
    @Override
    public void doAttraction(Attractions attraction) {

        String name = attraction.getName();

        try {
            manageWallet(attraction);
        } catch (NoMoneyException e) {
            System.out.println(e.getMessage());
            youLoose();
        }
        haveNausea(attraction);

        switch (name) {

            case "Spacemountain":
                System.out.print("\"YOUHOU  !!\"\n");
                attraction.setFun(11);
                attraction.setHealthLost(8);
                break;

            case "MaisonHantée":
                System.out.print("\"mouais, j'ai connu plus réaliste\" \n");
                attraction.setFun(4);
                attraction.setHealthLost(3);
                break;

            case "Tasses":
                System.out.print("\"toujours rigolo\"\n");
                attraction.setFun(6);
                attraction.setHealthLost(6);
                break;

            case "RailRoad":
                System.out.print("\"reposant, mais un peu ******\"\n");
                attraction.setFun(5);
                attraction.setHealthLost(3);
                break;

            case "StarTour":
                System.out.print("\"Ca m'a bien secoué\"\n");
                attraction.setFun(7);
                attraction.setHealthLost(5);
                break;

            case "Pechecanards":
                System.out.print("\" plus jamais de la vie !\"\n");
                attraction.setFun(2);
                attraction.setHealthLost(2);
                break;

            default:
        }
        spendHealth(attraction);
        try {
            howFunny(attraction);
        } catch (NegativeFunException e) {
            System.out.println(e.getMessage());
        }
        looseMyPhone();
    }
	
	/**
	* Methode permettant à l'ado de manger un Meals
	* @param food le repas choisi par l'ado
	*/
    @Override
    public void eat(Meals food) {
        health = health + food.foodHealth;
        System.out.println("santé : " + health);

        try {
            manageWallet(food);
        } catch (NoMoneyException e) {
            System.out.println(e.getMessage());
            youLoose();
        }
        try {
            spendTime(food);
        } catch (NoTimeException e) {
            System.out.println(e.getMessage());
            youLoose();
        }
    }

	/**
	* méthode permettant d'acheter un item dans le Shop choisi
	*@param gift le Shop choisi
	*/
    @Override
    public void buyGifts(Shops gift) {
        String indice;
        gift.showGifts(gift);

        Scanner input = new Scanner(System.in);
        indice = input.nextLine();
        switch (indice) {
            case "0":
                Gifts picture = gift.getListOfGifts().get(Integer.parseInt(indice));
                try {
                    manageWallet(picture);
                } catch (NoMoneyException e) {
                    System.out.println(e.getMessage());
                    youLoose();
                }
                try {
                    howFunny(picture);
                } catch (NegativeFunException e) {
                    System.out.println(e.getMessage());
                }
                bag.addItem(picture);
                break;
            case "1":
                Gifts mug = gift.getListOfGifts().get(Integer.parseInt(indice));
                try {
                    manageWallet(mug);
                } catch (NoMoneyException e) {
                    System.out.println(e.getMessage());
                    youLoose();
                }
                try {
                    howFunny(mug);
                } catch (NegativeFunException e) {
                    System.out.println(e.getMessage());
                }
                bag.addItem(mug);
                break;
            case "2":
                Gifts plush = gift.getListOfGifts().get(Integer.parseInt(indice));
                try {
                    manageWallet(plush);
                } catch (NoMoneyException e) {
                    System.out.println(e.getMessage());
                    youLoose();
                }
                try {
                    howFunny(plush);
                } catch (NegativeFunException e) {
                    System.out.println(e.getMessage());
                }
                bag.addItem(plush);
                break;
            case "3":
                Gifts snowGlobe = gift.getListOfGifts().get(Integer.parseInt(indice));
                try {
                    manageWallet(snowGlobe);
                } catch (NoMoneyException e) {
                    System.out.println(e.getMessage());
                    youLoose();
                }
                try {
                    howFunny(snowGlobe);
                } catch (NegativeFunException e) {
                    System.out.println(e.getMessage());
                }
                bag.addItem(snowGlobe);
                break;

            default:
                System.out.println("\nVotre réponse ne correspond pas aux réponses proposées...");
                buyGifts(gift);
        }
    }
	
	/**
	* méthode permettant d'acheter un item dans le Shop choisi
	*@param deguisement le Shop choisi
	*/
    @Override
    public void buyDeguisements(Shops deguisement) {
        String indice;
        deguisement.showDeguisements(deguisement);

        Scanner input = new Scanner(System.in);
        indice = input.nextLine();
        switch (indice) {
            case "0":
                Deguisements princessDress = deguisement.getListOfDeguisements().get(Integer.parseInt(indice));
                if(checkSize(princessDress)){
                try {
                    manageWallet(princessDress);
                } catch (NoMoneyException e) {
                    System.out.println(e.getMessage());
                    youLoose();
                }
                try {
                    howFunny(princessDress);
                } catch (NegativeFunException e) {
                    System.out.println(e.getMessage());
                }
                bag.addItem(princessDress);}
                
                break;
            case "1":
                Deguisements cowBoyHat = deguisement.getListOfDeguisements().get(Integer.parseInt(indice));
                if(checkSize(cowBoyHat)){
                try {
                    manageWallet(cowBoyHat);
                } catch (NoMoneyException e) {
                    System.out.println(e.getMessage());
                    youLoose();
                }
                try {
                    howFunny(cowBoyHat);
                } catch (NegativeFunException e) {
                    System.out.println(e.getMessage());
                }
                bag.addItem(cowBoyHat);}
                break;
            case "2":
                Deguisements mickeyEars = deguisement.getListOfDeguisements().get(Integer.parseInt(indice));
                if(checkSize(mickeyEars)){
                try {
                    manageWallet(mickeyEars);
                } catch (NoMoneyException e) {
                    System.out.println(e.getMessage());
                    youLoose();
                }
                try {
                    howFunny(mickeyEars);
                } catch (NegativeFunException e) {
                    System.out.println(e.getMessage());
                }
                bag.addItem(mickeyEars);}
                break;

            default:
                System.out.println("\nVotre réponse ne correspond pas aux réponses proposées...");
                buyGifts(deguisement);
        }
    }
	
    /**
	* une méthode permettant de générer un evenement aléatoire :
	* Lorsque l'ado fait une attraction, il a une chance sur 7 d'y laisser son telephone
	* Si cela arrive, son fun baisse, mais cela ne peut pas arriver une seconde fois
	*/
    public void looseMyPhone(){
    int proba;
    proba = (int) (Math.random() * 7);
    if(proba == 0){
        System.out.println("Oh non j'ai perdu mon telephone dans l'attraction !!!");
        System.out.println("vous perdez en fun, il fallait faire plus attention");
        fun = fun - 5;
        proba = 1;
    }
    
    }
}
