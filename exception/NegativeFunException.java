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
public class NegativeFunException extends Exception {
     
    /**
     * annonce au joueur que son fun est négatif
     *
     * @param message le message affiché
     */
    public NegativeFunException(String message) {
        super(message);
    }
}
