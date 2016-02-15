/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rollercoaster;

/**
 *  Cette classe représente l'ensemble des activités du parc
 * Elle possède 3 classes filles : Attractions, Meals, Shops
 * @author isen
 */
public class Activities {
    protected int waiting;   
    protected String name;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
  
    public int getWaiting(){
        return waiting;
    }
    

}
