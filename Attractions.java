/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rollercoaster;

/**
 * Cette classe représente les différentes Attractions du parc
 * Une attraction permet au joueur de gagner en fun, mais de faire varier d'autres parametres
 * tels que la nausée, le prix, le temps restant et la santé
 * @author isen
 */
public class Attractions extends Activities {

    private int howFun, necessaryHealth, necessarySize, nausea, healthLost, price;

    public Attractions() {
    }

    /**
     * Constructeur de la classe Attraction
     *
     * @param name le nom de l'attraction
     * @param fun le fun procuré par l'attraction
     * @param minHealth la santé minimale pour pouvoir faire l'attraction, sinon
     * il faut se restaurer
     * @param waiting le temps d'attente pour faire l'attraction
     * @param price le prix de l'attraction
     * @param minSize la taille minimale pour faire l'attraction
     * @param nausea la nausée créee par l'attraction
     * @param hLost la santé/faim perdue lors de l'attraction
     */
    public Attractions(String name, int fun, int minHealth, int waiting, int price, int minSize, int nausea, int hLost) {
        this.price = price;
        this.waiting = waiting;
        howFun = fun;
        necessaryHealth = minHealth;
        necessarySize = minSize;
        this.nausea = nausea;
        healthLost = hLost;
        setName(name);
    }

    public int getFun() {
        return howFun;
    }

    public int getNecessaryHealth() {
        return necessaryHealth;
    }

    public int getNecessarySize() {
        return necessarySize;
    }

    public int getNausea() {
        return nausea;
    }

    public int getHealthLost() {
        return healthLost;
    }

    public void setFun(int howFun) {
        this.howFun = howFun;

    }

    public int getPrice() {
        return price;
    }

    public void setHealthLost(int hlost) {
        healthLost = hlost;
    }
}
