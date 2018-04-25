/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.awt.Canvas;
import model.AbstractShape;
import java.util.ArrayList;

/**
 *
 * @author harouni
 */
public class Memento {
private ArrayList<AbstractShape> array = new ArrayList<AbstractShape>();

public Memento(ArrayList<AbstractShape> arr)
{
    this.array=arr;
}

    public ArrayList<AbstractShape> getArray() {
        return array;
    }

     
}

