/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rollercoaster;

/**
 * Cette classe représente une partie des Articles : les souvenirs
 *
 * @author isen
 */
public class Gifts extends Articles implements Purchasables {
    
    public Gifts(){}
    
	/**
	* Constructeur de la classe gifts
	* @param name le nom du gift
	* @param fun le fun que l'achat du gift procure
	* @param price le prix du gift
	*/
     public Gifts(String name, int fun, int price){
        this.name = name;
        this.fun = fun;
        this.price = price;
    }
     
    @Override    
    public int getPrice() {

        return price;
    }

    @Override
    public String getName() {

        return name;
    }
    
    @Override
    public int getFun() {

        return fun;
    }
    
}
