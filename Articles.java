/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rollercoaster;

/**
 * Cette classe représente l'ensemble des articles proposés par les Shops
 * Elle a deux filles : les souvenirs et les déguisements
 * Chaque article permet au joueur d'augmenter son fun, mais cela a un prix !
 * @author isen
 */

public abstract class Articles {
    
    protected int price, fun;
    String name;

    abstract public String getName();
}
