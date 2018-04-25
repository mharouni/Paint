/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.util.ArrayList;
import view.Canvas;
/**
 *
 * @author harouni
 */
public class Caretaker {
   public ArrayList<Memento> savedcans= new ArrayList<>();
   
   public void addMemento(Memento m)
   {
       savedcans.add(m);
   }
   public Memento getMemento(int index) 
   { 
       return savedcans.get(index);
   }
    
}
