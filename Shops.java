/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rollercoaster;

import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe représente une des activités du parc : le Shopping
 * On peut acheter des articles dans différents Shops, afin d'augmenter le fun
 * @author isen
 */
public class Shops extends Activities {    
    public int howFun, healthLost;
    
    
    private final List<Gifts> gifts = new ArrayList();
    private final List<Deguisements> deguisements = new ArrayList();
    
	/**
	* Cette méthode charge l'ensemble des items crées dans les Shops
	*
	*/
    public void setUpArticles(){
        
    Deguisements princessDress = new Deguisements("princessDress",5,7, "kid", "");
    addDeguisements(princessDress);
    
    Deguisements cowBoyHat = new Deguisements ("cowBoyHat",6, 9, "adult", "kid");
    addDeguisements(cowBoyHat);
    
    Deguisements mickeyEars = new Deguisements ("mickeyEars",4, 6, "adult", "");
    addDeguisements(mickeyEars);
    
    
    Gifts picture = new Gifts ("picture",10, 6);
    addGifts(picture);
    
    Gifts mug = new Gifts ("mug",10, 6);
    addGifts(mug);
    
    Gifts plush = new Gifts ("plush",10, 6);
    addGifts(plush);   
    
    Gifts snowGlobe = new Gifts ("snowGlobe Disneyland",10, 6);
    addGifts(snowGlobe);  
    }
    
    public void addGifts(Gifts gift) {
        gifts.add(gift);
    }

    public void addDeguisements(Deguisements deguisement) {
        deguisements.add(deguisement);
    }
    
    
    public List<Gifts> getListOfGifts() {
        return gifts;
    }
    
     public List<Deguisements> getListOfDeguisements() {
        return deguisements;
    }
     
     public int getGiftsPrice(int i){
        return getListOfGifts().get(i).getPrice();
    }
    
    public int getDeguisementsPrice(int i){
        return getListOfDeguisements().get(i).getPrice();
    }
    
    public String getDeguisementSize1(int i){
        return getListOfDeguisements().get(i).getSize1();
    }
    
     public String getDeguisementSize2(int i){
        return getListOfDeguisements().get(i).getSize2();
    }
        

	/**
	* Cette méthode affiche la liste des Gifts de la boutique gift
	* @param shop le Shops dans lequel on est
	*/		
    public void showGifts(Shops shop){
        System.out.println("\n \n *** voici les souvenirs de la boutique : ***");
        int i;
        for(i=0; i< getListOfGifts().size(); i++)
        {
            System.out.println(getListOfGifts().get(i).getName() + " (" +i+ ")  |  " + getGiftsPrice(i) + "€ " );
        }
    }
      
	/**
	* Cette méthode affiche la liste des Deguisements de la boutique deguisements
	* @param shop le Shops dans lequel on est
	*/	  
    public void showDeguisements(Shops shop){
        System.out.println("\n \n *** voici les deguisements de la boutique : ***");
        int i;
        for(i=0; i< getListOfDeguisements().size(); i++)
        {
            System.out.println(getListOfDeguisements().get(i).getName() + " (" +i+ ")  |  " + getDeguisementsPrice(i) + "€   |   " + getDeguisementSize1(i) +" " + getDeguisementSize2(i));
        }
    }
    
    public Shops(){}
    
    /**constructeur de la classe Shops
     *@param name nom de la boutique
     * @param waiting temps d'attente à la caisse
     * @param hLost la santé perdue à aller dans la boutique
     * 
     */
    public Shops(String name, int waiting, int hLost){
    setName(name);
    this.waiting = waiting;
    healthLost=hLost;    
    }
    
    public int getFun(){
        return howFun;
    }
    
    public void setFun(int howFun){
        this.howFun = howFun;
    }
    
    public void setHealthLost(int hlost){
        healthLost = hlost;
    }
    
}
