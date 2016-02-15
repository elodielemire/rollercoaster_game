/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rollercoaster;

/**
 * Cette classe représente l'ensemble des déguisements proposés dans le Shop déguisement
 * @author isen
 */
public class Deguisements extends Articles implements Purchasables {
    protected String size1, size2;
    
    public Deguisements(){}
    /**
	* Constructeur de la classe déguisement
	* @param name le nom du déguisement
	*@param fun le fun procuré par l'achat du déguisement
	*@param price le prix du déguisement
	*@param size1 une des tailles proposée pour le déguisement
	*@param size2 une autre taille proposée pour le déguisement
	*/
    public Deguisements(String name, int fun, int price, String size1, String size2){
        this.name = name;
        this.fun = fun;
        this.price = price;
        this.size1 = size1;
        this.size2 = size2;
    }
    
    public String getSize1(){
        return size1;
    }
    
    public String getSize2(){
        return size2;
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
