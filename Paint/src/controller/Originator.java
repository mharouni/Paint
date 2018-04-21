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
public class Originator {
    private Canvas can;

    public void setCan(Canvas can) {
        this.can = can;
    }
    public Memento createMemento()
    {
        System.out.println("originator created a memento");
        return new Memento(can);
    }
    public Canvas returnMemento(Memento memento)
    {
        System.out.println("Originator retrieved a memento");
        return memento.getCan();
    }
                
    
}