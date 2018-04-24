/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;
import controller.Factory;
import controller.Parser;
import model.*;
/**
 *
 * @author google
 */
public class CircleAction {
    Factory f = new Factory();
    
    public void resize(Circle c, double x, double y) throws CloneNotSupportedException
    {
        Circle newCircle = (Circle)c.clone();
        
        f.factoryProp(newCircle, x, y);
        
        Parser.getInstance().updateShape(c, newCircle);
    }
}
