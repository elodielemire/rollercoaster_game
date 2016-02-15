/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rollercoaster;

import java.util.Scanner;
import rollercoaster.exception.NoMoneyException;
import rollercoaster.exception.NoTimeException;
import rollercoaster.exception.NegativeFunException;

/**
 * Cette classe représente un des Clients du parc : la vieille dame
 * @author isen
 */
public class OldWoman extends Client {

    public OldWoman() {
        super();
        time = 480;
        money = 100;
        health = 35;
        fun = 0;
        height = 165;
        size = "adult";
    }
	
	/**
	* Methode permettant à la dame de faire une attraction
	* ses capitaux varient, et un commentaire spécifique à l'enfant s'affiche
	* @param attraction l'attraction choisie par la dame
	*/
    @Override
    public void doAttraction(Attractions attraction) {

        String name = attraction.getName();

        try {
            manageWallet(attraction);
        } catch (NoMoneyException e) {
            System.out.println(e.getMessage());
        }
        haveNausea(attraction);

        switch (name) {

            case "Spacemountain":
                System.out.print("\"ca n'est plus de mon age !\"\n");
                attraction.setFun(-10);
                attraction.setHealthLost(9);
                break;

            case "MaisonHantée":
                System.out.print("\"J'ai failli faire une crise tellement c'etait bien fait \"\n");
                attraction.setFun(8);
                attraction.setHealthLost(4);
                break;

            case "Tasses":
                System.out.print("\"Haha bonne activité familiale\"\n");
                attraction.setFun(6);
                attraction.setHealthLost(6);
                break;

            case "StarTour":
                System.out.print("\"Le film et les secousses étaient bien faits\"\n");
                attraction.setFun(6);
                attraction.setHealthLost(6);
                break;

            case "RailRoad":
                System.out.print("\"Géniale cette petite balade\"\n");
                attraction.setFun(7);
                attraction.setHealthLost(3);
                break;

            case "Pechecanards":
                System.out.print("\"ca me rappelle mon enfance\"\n");
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
        heartAttack();
    }

	/**
	* Methode permettant à la dame de manger un Meals
	* @param food le repas choisi par la dame
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
	* Lorsque la dame sort d'une attraction, elle a une chance sur 9 de faire une crise cardiaque
	* Si cela arrive, la partie se termine
	*/
    public void heartAttack(){
    int proba, missingFun;
    proba = (int) (Math.random() * 9);
    if(proba == 0){
        System.out.println("zehsyhfgsehkfseg !!!");
        System.out.println("Vous faites une crise cardiaque... ");
        System.out.println("Fun : ");
                for (int i = 0; i < fun; i++) {
                System.out.print("☻");
            }
            missingFun = 65 - fun;
            for (int i = 0; i < missingFun; i++) {
                System.out.print("☺");
            }
                
                System.exit(0);
    }
    }
}
