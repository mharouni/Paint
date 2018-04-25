/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.awt.Canvas;
import java.util.ArrayList;
import model.AbstractShape;
/**
 *
 * @author harouni
 */
public class Originator {
    private ArrayList<AbstractShape> array = new ArrayList<AbstractShape>();

    public void setCan(ArrayList array) {
        this.array =array ;
    }
    public Memento createMemento()
    {
        System.out.println("originator created a memento");
        return new Memento(array);
    }
    public ArrayList returnMemento(Memento memento)
    {
        System.out.println("Originator retrieved a memento");
        return memento.getArray();
    }


}