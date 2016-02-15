/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rollercoaster;

import java.util.Scanner;
import rollercoaster.exception.NegativeFunException;
import rollercoaster.exception.NoMoneyException;
import rollercoaster.exception.NoTimeException;

/**
 * Cette classe représente un des Clients du parc : l'enfant
 * @author isen
 */
public class Kid extends Client {

	/**
	* constructeur de la classe Kid
	*/
    public Kid() {
        super();
        time = 400;
        money = 90;
        health = 40;
        fun = 0;
        height = 120;
        size = "kid";
        
    }
	
	/**
	* Methode permettant à l'enfant de faire une attraction
	* ses capitaux varient, et un commentaire spécifique à l'enfant s'affiche
	* @param attraction l'attraction choisie par l'enfant
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
                System.out.print("\"OOOOH !! pk vous m'avez pas fait plus grand !!\"\n");

                break;

            case "MaisonHantée":
                System.out.print(" \"Haha t'as vu j'ai quasiment pas eu peur !\" \n");
                attraction.setFun(7);
                attraction.setHealthLost(4);
                break;

            case "Tasses":
                System.out.print("\"on a tourné à fond, ca muscle les bras\"\n");
                attraction.setFun(6);
                attraction.setHealthLost(7);
                break;

            case "RailRoad":
                System.out.print("\"je préfère faire des vrais attractions !\"\n");
                attraction.setFun(5);
                attraction.setHealthLost(3);
                break;

            case "StarTour":
                System.out.print("\"Yes! Ca c'est stylé !\"\n");
                attraction.setFun(7);
                attraction.setHealthLost(3);
                break;

            case "Pechecanards":
                System.out.print("\"j'en peche encore plus avec papi !\"\n");
                attraction.setFun(4);
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
    fallOnTheGround();
    }
	
	/**
	* Methode permettant à l'enfant de manger un Meals
	* @param food le repas choisi par l'enfant
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
	* Lorsque le Kid fait une attraction, il a une chance sur 4 de tomber en sortant de l'attraction
	* Si cela arrive, son fun et la santé baissent
	*/
    public void fallOnTheGround(){
    int proba;
    proba = (int) (Math.random() * 4);
    if(proba == 0){
        System.out.println("Aiiiie je suis tombé !!!");
        System.out.println("vous perdez en fun et en santé, il ne fallait pas courir aussi vite");
        fun = fun - 3;
        health = health - 3;
    }
    }
}
