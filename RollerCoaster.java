/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rollercoaster;

/**
 * Bienvenue dans le programme de gestion d'un parc d'attraction Vous pouvez
 * faire différentes activités telles que des Attractions, vous restaurer avec
 * des Meals, ou faire les boutiques aux Shops.
 * Amusez-vous bien et repartez avec 50 smileys de fun pour remporter la partie. 
 * Mais attention, vous avez des capitaux temps, argent et santé à gérer !
 *
 * @author isen
 */
public class RollerCoaster {

    /**
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Parc myParc = new Parc();
        myParc.setUpParc();
        System.out.println("____________ Bienvenue à " + myParc.getName() + " !!! ____________ \n");
        Client player = new Client();
        player = player.chooseClient();
        player.move(myParc);

    }

}
