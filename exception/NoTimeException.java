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
public class NoTimeException extends Exception {
    
    /**
     * annonce au joueur que sa journée est écoulée : fin du jeu
     *
     * @param message le message affiché
     */
    public NoTimeException(String message) {
        super(message);
    }
}
