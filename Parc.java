/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rollercoaster;

import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe représente l'ensemble du Parc
 * Elle permet de gérer l'ensemble des activités : en rajouter, supprimer, renomer, changer les valeurs...
 * @author isen
 */
public class Parc {
	/**nom du parc */
    String name="Disneyland";
    
    private final List<Attractions> attractions = new ArrayList();
    private final List<Meals> meals = new ArrayList();
    private final List<Shops> shops = new ArrayList();
      
    /**
	* Cette méthode charge l'ensemble des activités crées : Attractions, Meals et Shops
	*/
    public void setUpParc() {

        Attractions spaceMountain = new Attractions("Spacemountain",10, 20, 60, 12, 130, 5, 8);
        addAttractions(spaceMountain);

        Attractions house = new Attractions("MaisonHantée",8, 12, 30, 7, 100, 2, 3);
        addAttractions(house);

        Attractions cups = new Attractions("Tasses",6, 14, 20, 5, 100, 3, 5);
        addAttractions(cups);       
        
        Attractions ducks = new Attractions("Pechecanards",5, 5, 10, 3, 60, 0, 2);
        addAttractions(ducks);
        
        Attractions railRoad = new Attractions("RailRoad",5, 8, 40, 8, 100, 0, 3);
        addAttractions(railRoad);
        
        Attractions starTour= new Attractions("StarTour",5, 8, 40, 8, 100, 0, 3);
        addAttractions(starTour);

        
        Meals churros = new Meals("Churros",10, 8, 8);
        addMeals(churros);

        Meals chips = new Meals("Chips",16, 13, 13);
        addMeals(chips);

        Meals candies = new Meals("Candies",7, 6, 6);
        addMeals(candies);
        
        Meals restaurant = new Meals("Restaurant",30, 30, 20);
        addMeals(restaurant);
        
        
        Shops gifts = new Shops("Souvenirs", 10, 10);
        addShops(gifts);
        gifts.setUpArticles();
        
        Shops deguisements = new Shops("Deguisements", 20, 10);
        addShops(deguisements);
        deguisements.setUpArticles();
    }

    public void addAttractions(Attractions attraction) {
        attractions.add(attraction);
    }

    public void addMeals(Meals meal) {
        meals.add(meal);
    }

    public void addShops(Shops shop) {
        shops.add(shop);
    }
    
    public List<Attractions> getListOfAttractions() {
        return attractions;
    }
    
     public List<Meals> getListOfMeals() {
        return meals;
    }
     
     public List<Shops> getListOfShops() {
        return shops;
    }
     
    public String getName() {
        return this.name;
    }
    
    public int getAttractionsPrice(int i){
        return getListOfAttractions().get(i).getPrice();
    }
    
    public int getAttractionsWaiting(int i){
        return getListOfAttractions().get(i).getWaiting();
    }
    
    
    public int getMealsPrice(int i){
        return getListOfMeals().get(i).getPrice();
    }
    
    public int getMealsWaiting(int i){
        return getListOfMeals().get(i).getWaiting();
    }
    
       
    public int getShopsWaiting(int i){
        return getListOfShops().get(i).getWaiting();
    }
    
	/**
	* Cette méthode affiche la liste des Attractions du parc
	* @param myParc le parc dans lequel on est
	*/
    public void showAttractions(Parc myParc){
        System.out.println("\n \n *** voici les attractions du parc : ***");
        int i;
        for(i=0; i< getListOfAttractions().size(); i++)
        {
            System.out.println(getListOfAttractions().get(i).getName() + " (" +i+ ")  |  " + getAttractionsPrice(i) + "€  | " + getAttractionsWaiting(i) +"mn" );
        }
    }
     
	/**
	* Cette méthode affiche la liste des Meals du parc
	* @param myParc le parc dans lequel on est
	*/	 
    public void showMeals(Parc myParc){
        System.out.println("\n \n *** voici les restaurants du parc : ***");
        int i;
        for(i=0; i< getListOfMeals().size(); i++)
        {
            System.out.println(getListOfMeals().get(i).getName() + " (" +i+ ")  |  " + getMealsPrice(i) + "€  | " + getMealsWaiting(i) + "mn");
        }
    }
    
	/**
	* Cette méthode affiche la liste des Shops du parc
	* @param myParc le parc dans lequel on est
	*/
    public void showShops(Parc myParc){
        System.out.println("\n \n*** voici les boutiques du parc : ***");
        int i;
        for(i=0; i< getListOfShops().size(); i++)
        {
            System.out.println(getListOfShops().get(i).getName() + " (" +i+ ")   |  " + getShopsWaiting(i) + "mn");
        }
    }
}
