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
public class EllipseActions {
    Factory f = new Factory();
    
    public void resize(Ellipse e, double x, double y) throws CloneNotSupportedException
    {
        Ellipse newEllipse = (Ellipse)e.clone();
        
        f.factoryProp(newEllipse, x, y);
        
        Parser.getInstance().updateShape(e, newEllipse);
    }
    
}
