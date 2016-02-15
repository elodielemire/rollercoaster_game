/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rollercoaster;

/**
 * Cette classe contient les différents types de repas proposés
 * Ils permettent de restaurer de la santé au joueur car elle baisse au fur et à mesure de la journée (comme la faim)
 * @author isen
 */
public class Meals extends Activities {
    protected int foodHealth, price;
    
    /**
     * Constructeur de la classe Meals
     * @param name le nom du repas
     * @param waiting le temps d'attente pour manger
     * @param price le prix du repas
     * @param foodHealth la santé que le repas apporte
     */
    public Meals(String name,int waiting,int price, int foodHealth){
    super();
    this.price = price;
    this.waiting = waiting;
    this.foodHealth=foodHealth;
    this.name=name;
    }
    
    /**
     * Getter du prix des repas de la classe Meals
     * @return le prix du repas
     */
  public int getPrice(){
        return price;
    }
   
}
