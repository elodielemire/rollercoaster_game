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
import rollercoaster.exception.EmptyBagException;

/**
 * Client est la classe qui représente le joueur dans notre parc d'attraction
 *
 * @author isen
 */
public class Client {

    protected int health, money, time;
    protected int nausea, height;
    protected int fun;
    protected String size;

    Bag bag = new Bag();

    /**
     * Choix du type de personnage
     *
     * @return le personnage choisi : oldWoman, Teenager ou Kid
     */
    public Client chooseClient() {// on pourrait mettre cette methode ailleurs, et rendre la classe Client abstraite

        String indice;
        System.out.println("choisissez votre personnage: oldWoman (0), teen (1), kid (2)");

        Scanner input = new Scanner(System.in);
        indice = input.nextLine();
        Client player = null;

        switch (indice) {
            case "0":
                player = new OldWoman();

                break;

            case "1":
                player = new Teenager();

                break;

            case "2":
                player = new Kid();

                break;

            default:
                System.out.println("\nVotre réponse ne correspond pas aux réponses proposées...");
                chooseClient();
        }
        return player;

    }

    /**
     * Méthode permettant d'orienter le joueur vers les 3 différents types
     * d'activités : les attractions, les restaurants, ou les boutiques.
     * il peut également voir son sac ou sortir du parc pour mettre fin à la partie
     *
     * @param myParc le parc dans lequel le joueur se ballade
     */
    public void move(Parc myParc) {
        String indice;
        int missingFun;
        System.out.println("\n où voulez vous aller: Attraction (0), Restauration (1), Boutiques (2), voir mon sac (3), sortir du parc (4)");

        Scanner input = new Scanner(System.in);
        indice = input.nextLine();

        switch (indice) {
            case "0":
                chooseAttractions(myParc);

                break;

            case "1":
                chooseMeal(myParc);
                break;

            case "2":
                chooseShop(myParc);
                break;

            case "3":
                try {
                    bag.showBag();
                } catch (EmptyBagException e) {
                    System.out.println(e.getMessage());
                    move(myParc);
                }
                break;

            case "4":
                System.out.println("Vous quittez le parc avec :");
                System.out.println("Fun : ");
                for (int i = 0; i < fun; i++) {
                    System.out.print("☻");
                }
                missingFun = 65 - fun;
                for (int i = 0; i < missingFun; i++) {
                    System.out.print("☺");
                }
                System.out.println("\n A bientot !");
                System.exit(0);
                break;
            default:
                System.out.println("\nVotre réponse ne correspond pas aux réponses proposées...");
                move(myParc);
        }
    }

    /**
     * Méthode permettant d'orienter le joueur vers les différentes
     * attractions : space moutain, maison hantée, tasses, peche aux canards, rail road, star tour
     *
     * @param myParc le parc dans lequel le joueur se ballade
     */
    @SuppressWarnings("InfiniteRecursion")
    public void chooseAttractions(Parc myParc) {
        String indice;

        myParc.showAttractions(myParc);
        System.out.println("changer d'activité (6)");

        Scanner input = new Scanner(System.in);
        indice = input.nextLine();

        switch (indice) {
            case "0":
                Attractions mountain = myParc.getListOfAttractions().get(Integer.parseInt(indice));
                if (checkHeight(mountain) && checkHealth(mountain) && checkTime(mountain) && checkMoney(mountain)) {
                    standInLine(mountain);
                    doAttraction(mountain);
                } else {
                    chooseAttractions(myParc);
                }
                break;

            case "1":

                Attractions house = myParc.getListOfAttractions().get(Integer.parseInt(indice));
                if (checkHeight(house) && checkHealth(house) && checkTime(house) && checkMoney(house)) {
                    standInLine(house);
                    doAttraction(house);
                } else {
                    chooseAttractions(myParc);
                }
                break;

            case "2":
                Attractions cups = myParc.getListOfAttractions().get(Integer.parseInt(indice));
                if (checkHeight(cups) && checkHealth(cups) && checkTime(cups) && checkMoney(cups)) {
                    try {
                        spendTime(cups);
                    } catch (NoTimeException e) {
                        System.out.println(e.getMessage());
                        youLoose();
                    } // on ne peut pas doubler dans la file du railroad donc on n'appelle pas standInLine
                    doAttraction(cups);
                } else {
                    chooseAttractions(myParc);
                }
                break;

            case "3":
                Attractions duck = myParc.getListOfAttractions().get(Integer.parseInt(indice));
                if (checkHeight(duck) && checkHealth(duck) && checkTime(duck) && checkMoney(duck)) {
                    try {
                        spendTime(duck);
                    } catch (NoTimeException e) {
                        System.out.println(e.getMessage());
                        youLoose();
                    } // on ne peut pas doubler dans la file des canards donc on n'appelle pas standInLine
                    doAttraction(duck);
                } else {
                    chooseAttractions(myParc);
                }

                break;
            case "4":
                Attractions railRoad = myParc.getListOfAttractions().get(Integer.parseInt(indice));
                if (checkHeight(railRoad) && checkHealth(railRoad) && checkTime(railRoad) && checkMoney(railRoad)) {
                    try {
                        spendTime(railRoad);
                    } catch (NoTimeException e) {
                        System.out.println(e.getMessage());
                        youLoose();
                    } // on ne peut pas doubler dans la file du railroad donc on n'appelle pas standInLine
                    doAttraction(railRoad);
                } else {
                    chooseAttractions(myParc);
                }

                break;
            case "5":
                Attractions starTour = myParc.getListOfAttractions().get(Integer.parseInt(indice));
                if (checkHeight(starTour) && checkHealth(starTour) && checkTime(starTour) && checkMoney(starTour)) {
                    standInLine(starTour);
                    doAttraction(starTour);
                } else {
                    chooseAttractions(myParc);
                }

                break;
            case "6":
                move(myParc);
                break;

            default:
                System.out.println("\nVotre réponse ne correspond pas aux réponses proposées...");
                chooseAttractions(myParc);
        }
        chooseAttractions(myParc);
    }

    /**
     * Faire l'attraction choisie : entraine la variation des différents capitaux
     * @param attraction l'attraction choisie par le joueur
     */
    public void doAttraction(Attractions attraction) {

    }

    /**
     * Méthode permettant d'orienter le joueur vers les différents repas :
     * restaurants, churros, frites, confiseries, restaurant
     *
     * @param myParc le parc dans lequel le joueur se ballade
     */
    public void chooseMeal(Parc myParc) {
        String indice;
        myParc.showMeals(myParc);
        System.out.println("changer d'activité (4)");
        Scanner input = new Scanner(System.in);
        indice = input.nextLine();

        switch (indice) {
            case "0":
                Meals churros = myParc.getListOfMeals().get(Integer.parseInt(indice));
                if (checkTime(churros) && checkMoney(churros)) {
                    eat(churros);
                } else {
                    chooseMeal(myParc);
                }

                break;

            case "1":
                Meals chips = myParc.getListOfMeals().get(Integer.parseInt(indice));
                if (checkTime(chips) && checkMoney(chips)) {
                    eat(chips);
                } else {
                    chooseMeal(myParc);
                }
                break;

            case "2":
                Meals candies = myParc.getListOfMeals().get(Integer.parseInt(indice));
                if (checkTime(candies) && checkMoney(candies)) {
                    eat(candies);
                } else {
                    chooseMeal(myParc);
                }
                break;

            case "3":
                Meals restaurant = myParc.getListOfMeals().get(Integer.parseInt(indice));
                if (checkTime(restaurant) && checkMoney(restaurant)) {
                    eat(restaurant);
                } else {
                    chooseMeal(myParc);
                }
                break;

            case "4":
                move(myParc);
                break;

            default:
                System.out.println("\nVotre réponse ne correspond pas aux réponses proposées...");
                chooseMeal(myParc);
        }
        move(myParc);
    }

    /**
     * manger le repas choisi : entraine la variation des différents capitaux
     * @param food le repas choisi
     */
    public void eat(Meals food) {
    }

    /**
     * Méthode permettant d'orienter le joueur vers les différentes boutiques
     * : celle des souvenirs ou celle des déguisements
     *
     * @param myParc le parc dans lequel le joueur se ballade
     */
    @SuppressWarnings("InfiniteRecursion")
    public void chooseShop(Parc myParc) {
        String indice;

        myParc.showShops(myParc);
        System.out.println("changer d'activité (2)");
        System.out.println("voir mon sac (3)");
        Scanner input = new Scanner(System.in);
        indice = input.nextLine();
        switch (indice) {
            case "0":
                Shops gifts = myParc.getListOfShops().get(Integer.parseInt(indice));
                if (checkTime(gifts)) {
                    buyGifts(gifts);
                    try {
                        spendTime(gifts);
                    } catch (NoTimeException e) {
                        System.out.println(e.getMessage());
                        youLoose();
                    }

                } else {
                    chooseShop(myParc);
                }
                break;

            case "1":
                Shops deguisements = myParc.getListOfShops().get(Integer.parseInt(indice));
                if (checkTime(deguisements)) {
                    buyDeguisements(deguisements);
                    try {
                        spendTime(deguisements);
                    } catch (NoTimeException e) {
                        System.out.println(e.getMessage());
                        youLoose();
                    }

                } else {
                    chooseShop(myParc);
                }
                break;

            case "2":
                move(myParc);
                break;

            case "3":
                try {
                    bag.showBag();
                } catch (EmptyBagException e) {
                    System.out.println(e.getMessage());
                    chooseShop(myParc);
                }
                break;

            default:
                System.out.println("\nVotre réponse ne correspond pas aux réponses proposées...");
                chooseShop(myParc);
        }
        chooseShop(myParc);
    }

    /**
     *  acheter le souvenir choisi
     * @param gift le souvenir choisi
     */
    public void buyGifts(Shops gift) {
    }

    /**
     * acheter le déguisement choisi
     * @param deguisement le déguisement choisi
     */
    public void buyDeguisements(Shops deguisement) {
    }

// ************* FONCTIONS UTILISEES POUR FAIRE VARIER LES DIFFERENTS PARAMETRES ************
    /**
     * Vérification de la taille, true si le joueur est assez grand, false s'il
     * est trop petit
     *
     * @param attraction l'attraction que le joueur veut faire
     * @return si le joueur est assez grand pour l'attraction
     */
    public boolean checkHeight(Attractions attraction) {
        if (attraction.getNecessarySize() > height) {
            System.out.println("vous mesurez " + height + "cm, vous êtes trop petit pour faire cette attraction");
            return false;
        } else {
            return true;
        }
    }

    /**
     * Vérification de la taille, true si sa taille existe, false sinon
     *
     * @param deguisement le deguisement que le joueur essaye
     * @return si la taille correspond au joueur
     */
    public boolean checkSize(Deguisements deguisement) {
        if (deguisement.size1.equalsIgnoreCase(size) || deguisement.size2.equalsIgnoreCase(size)) {
            return true;
        } else {
            System.out.println("il n'y a pas votre taille, vous ne pouvez pas acheter ce déguisement");
            return false;
        }
    }

    /**
     * Vérification que la santé nécessaire est suffisante, true si oui, false
     * si non
     *
     * @param attraction l'attraction que le joueur veut faire
     * @return si le joueur est en assez bonne forme pour l'attraction
     */
    public boolean checkHealth(Attractions attraction) {
        if (attraction.getNecessaryHealth() > health) {
            System.out.println("n'avez que " + health + " de santé, vous devez manger pour faire cette attraction");
            return false;
        } else {
            return true;
        }
    }

    /**
     * Vérification qu'il reste assez de temps pour faire l'activité, true si
     * oui, false si non
     *
     * @param activity l'activité que le joueur veut faire
     * @return si le joueur a encore assez de temps
     */
    public boolean checkTime(Activities activity) {
        if (activity.waiting > time) {
            System.out.println("désolé vous n'avez plus assez de temps pour faire cette attraction");
            return false;
        } else {
            return true;
        }
    }

    /**
     * Vérification que le joueur a assez d'argent pour l'attraction true si oui,
     * false si non
     *
     * @param attraction l'activité que le joueur veut faire
     * @return si il reste assez d'argent au joueur
     */
    public boolean checkMoney(Attractions attraction) {
        if (attraction.getPrice() > money) {
            System.out.println("désolé vous n'avez plus assez d'argent pour faire cette attraction");
            return false;
        } else {
            return true;
        }
    }

    /**
     * Vérification que le joueur a assez d'argent pour l'activité true si oui,
     * false si non
     *
     * @param meal le repas que le joueur choisi
     * @return si il reste assez d'argent au joueur
     */
    public boolean checkMoney(Meals meal) {
        if (meal.getPrice() > money) {
            System.out.println("désolé vous n'avez plus assez d'argent pour faire cette attraction");
            return false;
        } else {
            return true;
        }
    }

    /**
     * Vérification que le joueur a assez d'argent pour l'activité true si oui,
     * false si non
     *
     * @param article l'article que le joueur veut faire
     * @return si il reste assez d'argent au joueur
     */
    public boolean checkMoney(Articles article) {
        if (article.price > money) {
            System.out.println("désolé vous n'avez plus assez d'argent pour faire cette attraction");
            return false;
        } else {
            return true;
        }
    }

    /**
     * Déduit la perte de santé provoquée par l'attraction sur le joueur
     *
     * @param attraction l'attraction que le joueur a fait
     *
     */
    public void spendHealth(Attractions attraction) {
        health -= attraction.getHealthLost();
        System.out.println("santé restante : " + health);
    }

    /**
     * Méthode pour faire la queue : on peut essayer de doubler ou faire la
     * queue cas 1 : faire la queue, le temps d'attente est soustrait cas 2 :
     * doubler et se faire tabasser, cf méthode hitInLine cas 3 : réussir à
     * doubler, on n'a pas fait la queue
     *
     * @param attraction l'attraction pour laquelle il fait la queue
     *
     */
    public void standInLine(Attractions attraction) {
        String indice;
        int proba;
        System.out.println("\n voulez vous faire la queue ?(0) ou essayer de doubler ? (1)");

        Scanner input = new Scanner(System.in);
        indice = input.nextLine();
        switch (indice) {
            case "0":
                try {
                    spendTime(attraction);
                } catch (NoTimeException e) {
                    System.out.println(e.getMessage());
                    youLoose();
                }
                break;
            case "1":
                proba = (int) (Math.random() * 3); // on a 1 chance sur 3 de se faire tabasser
                if (proba == 0) {
                    System.out.println("C'est un échec ! Vous vous faites tabasser !");
                    try {hitInLine(attraction);}
                    catch (NoTimeException e){
                        System.out.println(e.getMessage());}
                } else {
                    System.out.println("vous avez réussi à doubler, vous n'avez pas perdu de temps !");
                    System.out.println("temps restant : " + minutesInHour(time));
                }
                break;
        }
    }

    /**
     * Cas où le joueur essaye de doubler et qu'il se fait frapper : il perd le
     * double du temps car il refait la queue, et son fun baisse
     *
     * @param attraction l'attraction pour laquelle il fait la queue
     *  @throws NoTimeException permet d'indiquer à l'utilisateur qu'il n'a plus assez de temps
     */
    public void hitInLine(Attractions attraction) throws NoTimeException {        
        time = time - 2 * attraction.waiting;
        if (time <= 0) {
            throw new NoTimeException("désolé vous n'avez plus de temps, la journée est finie");
        } else {
        System.out.println("temps restant : " + minutesInHour(time));
        fun = fun - 9;
        }
    }

    /**
     * Cette methode permet de déduire l'argent de l'attraction choisie du porte
     * monnaie du joueur
     *
     * @param attraction l'attraction pour laquelle il dépense de l'argent
     *
     * @throws NoMoneyException permet d'indiquer à l'utilisateur qu'il n'a plus
     * d'argent dans son porte monnaie
     *
     */
    public void manageWallet(Attractions attraction) throws NoMoneyException {
        if (money <= 0) {
            throw new NoMoneyException("désolé vous n'avez plus d'argent");
        } else {
            money = money - attraction.getPrice();
            System.out.println("argent restant : " + money + "€");
        }
    }

    /**
     * Cette methode permet de déduire le prix du repas choisi du porte monnaie
     * du joueur
     *
     * @param meal le repas pour lequel il dépense de l'argent
     *
     * @throws NoMoneyException permet d'indiquer à l'utilisateur qu'il n'a plus
     * d'argent dans son porte monnaie
     *
     */
    public void manageWallet(Meals meal) throws NoMoneyException {
        if (money <= 0) {
            throw new NoMoneyException("désolé vous n'avez plus d'argent");
        } else {
            money = money - meal.getPrice();
            System.out.println("argent restant : " + money + "€");
        }
    }

    /**
     * Cette methode permet de déduire le prix de l'article choisi du porte
     * monnaie du joueur
     *
     * @param article l'article pour lequel il dépense de l'argent
     *
     * @throws NoMoneyException permet d'indiquer à l'utilisateur qu'il n'a plus
     * d'argent dans son porte monnaie
     *
     */
    public void manageWallet(Articles article) throws NoMoneyException {
        if (money <= 0) {
            throw new NoMoneyException("désolé vous n'avez plus d'argent");
        } else {
            money = money - article.price;
            System.out.println("argent restant : " + money + "€");
        }
    }

    /**
     * Cette methode permet de convertir les minutes restantes au joueur en
     * heure-minute
     *
     * @param time le temps qu'il reste au joueur
     * @return le temps qu'il reste au joueur au format heure-minute
     */
    public String minutesInHour(int time) {
        int hours, minutes;
        String result;

        hours = time / 60;
        minutes = time - (hours * 60);
        result = hours + "h" + minutes + "mn";
        return result;
    }

    /**
     * Cette methode permet de déduire le temps de la file des activités de la
     * journée du joueur
     *
     * @param activity l'activité pour laquelle il fait la queue
     *
     * @throws NoTimeException permet d'indiquer à l'utilisateur qu'il n'a plus
     * de temps dans sa journée
     *
     */
    public void spendTime(Activities activity) throws NoTimeException {
        if (time <= 0) {
            throw new NoTimeException("désolé vous n'avez plus de temps, la journée est finie");
        } else {
            time = time - activity.waiting;
            System.out.println("temps restant: " + minutesInHour(time));
        }
    }

    /**
     * Cette methode permet d'incrémenter le fun du joueur en fonction du fun
     * procuré par l'attraction
     *
     * @param attraction l'attraction effectuée par le joueur
     * @throws rollercoaster.exception.NegativeFunException
     *
     */
    public void howFunny(Attractions attraction) throws NegativeFunException {
        int missingFun;
        System.out.print("fun :");
        fun += attraction.getFun();

        if (fun < 0) {
            fun = 0;
            throw new NegativeFunException("votre fun est négatif, il faut plutot faire les attractions favorites !");

        } else {

            for (int i = 0; i < fun; i++) {
                System.out.print("☻");
            }
            missingFun = 65 - fun;
            for (int i = 0; i < missingFun; i++) {
                System.out.print("☺");
            }
            if (missingFun <= 0) {
                youWin();
            }
        }
        System.out.println();
    }

    /**
     * Cette methode permet d'incrémenter le fun du joueur en fonction du fun
     * procuré par l'article acheté
     *
     * @param article l'article choisie par le joueur
     * @throws rollercoaster.exception.NegativeFunException
     *
     */
    public void howFunny(Articles article) throws NegativeFunException {
        int missingFun;
        System.out.print("fun :");
        fun += article.fun;

        if (fun < 0) {
            fun = 0;
            throw new NegativeFunException("votre fun est négatif, il faut plutot faire les attractions favorites !");
        } else {

            for (int i = 0; i < fun; i++) {
                System.out.print("☻");
            }
            missingFun = 50 - fun;
            for (int i = 0; i < missingFun; i++) {
                System.out.print("☺");
            }
            if (missingFun <= 0) {
                youWin();
            }
        }
    }

    /**
     * Lorsque le joueur a fait trop d'attractions qui tournent il va vomir, ce
     * qui diminue son fun la nausée est ensuite réinitialisée
     *
     * @param attraction l'attraction effectuée par le joueur
     *
     */
    public void haveNausea(Attractions attraction) {
        nausea += attraction.getNausea();
        if (nausea > 17) {
            System.out.println("vous avez fait trop d'attractions qui tournent, vous allez aux toilettes");
            fun -= 17;
            nausea = 0;
        }
    }

    /**
     * Fin de la partie : perdu
     */
    public void youLoose() {
        System.out.println("\n *** YOU LOOOSE ***");
        System.exit(0);
    }

    /**
     * Fin de la partie : gagné
     */
    public void youWin() {
        System.out.println("\n *** YOU WIN ! CONGRATS ! ***");
        System.exit(0);
    }

}
