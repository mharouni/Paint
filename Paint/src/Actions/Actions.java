/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import model.Shape;

/**
 *
 * @author omarahmedheshamaziz
 */
public interface Actions {
    
    public void resize(Shape s,double x, double y);
    
    public void move(Shape s, double x, double y);
    
    public void copy(Shape s);
    
    public void delete(Shape s);
    
    
    
}
