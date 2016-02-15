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
public class EmptyBagException extends Exception {
    /**
     * annonce au joueur que son sac est vide
     *
     * @param message le message affiché
     */
    public EmptyBagException(String message) {
        super(message);
    }
}
