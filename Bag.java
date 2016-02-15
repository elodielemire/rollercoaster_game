/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rollercoaster;

import java.util.ArrayList;
import java.util.List;
import rollercoaster.exception.EmptyBagException;

/**
 * Cette classe représente le sac à dos du joueur
 * lorsqu'il achète un article aux Shops, il se trouve dans son sac
 * @author isen
 */
public class Bag {
    
    private List<Articles> bag = new ArrayList();
    
    public Bag(){}

    public Bag(List<Articles> bag) {
        this.bag = bag;
    }

    public List<Articles> getListOfItem() {
        return this.bag;
    }
	
    /**
	* permet d'ajouter les articles achetés à la liste bag
	*/
     public void addItem(Articles article) {
        bag.add(article);
    }
    
    /**
     * Montre le contenu du sac a l'utilisateur.
     *
     * @throws EmptyBagException verifie que le sac n'est pas vide.
     */
    public void showBag() throws EmptyBagException {

        if (bag.isEmpty()) {
            throw new EmptyBagException("\nVotre sac à dos est vide, allez dans les boutiques pour le remplir !");
        } else {
            int i;
            System.out.println("Voici votre sac : ");
            System.out.println("______________________");
            for (i = 0; i < bag.size(); i++) {
                System.out.println(bag.get(i).getName());
            }
            System.out.println("______________________");
            }
    }
    
}
