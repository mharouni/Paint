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
public class RectangleActions {
    Factory f = new Factory();
    
    public void resize(Rectangle e, double x, double y) throws CloneNotSupportedException
    {
        Rectangle newR = (Rectangle)e.clone();
        
        f.factoryProp(newR, x, y);
        
        Parser.getInstance().updateShape(e, newR);
    }
}