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
public class TriangleActions {
    Factory f = new Factory();
    
    public void resize(Triangle e, double x, double y) throws CloneNotSupportedException
    {
        Triangle newT = (Triangle)e.clone();
        
        f.factoryProp(newT, x, y);
        
        Parser.getInstance().updateShape(e, newT);
    }
    
}
