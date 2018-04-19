/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import view.Canvas;

/**
 *
 * @author harouni
 */
public class Memento {
    private Canvas can;

    public Memento(Canvas can) {
        this.can = can;
    }

    public Canvas getCan() {
        return can;
    }
    
    
    
}
