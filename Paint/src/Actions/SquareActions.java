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
public class SquareActions {
    Factory f = new Factory();
    
    public void resize(Square e, double x, double y) throws CloneNotSupportedException
    {
        Square newS = (Square)e.clone();
        
        f.factoryProp(newS, x, y);
        
        Parser.getInstance().updateShape(e, newS);
    }
}