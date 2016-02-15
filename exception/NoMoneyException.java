/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rollercoaster.exception;

/**
 *
 * @author isen
 */
public class NoMoneyException extends Exception {
    
    /**
     * annonce au joueur qu'il n'a plus d'argent : fin du jeu
     *
     * @param message le message affiché
     */
    public NoMoneyException(String message) {
        super(message);
    }
}
