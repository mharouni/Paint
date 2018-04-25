/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import java.awt.Point;
import model.Shape;

/**
 *
 */
public interface Actions {
    
    public void resize(Shape s,double x, double y) throws CloneNotSupportedException;
    
    public void move(Shape s, Point p) throws CloneNotSupportedException;
    
    public void copy(Shape s,Point p) throws CloneNotSupportedException;
    
    public void delete(Shape s);
}
