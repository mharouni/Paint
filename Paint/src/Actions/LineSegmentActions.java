/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import controller.Factory;
import controller.Parser;
import model.*;

public class LineSegmentActions {
    Factory f = new Factory();
    
    public void resize(LineSegment e, double x, double y) throws CloneNotSupportedException
    {
        LineSegment newLS = (LineSegment)e.clone();
        
        f.factoryProp(newLS, x, y);
        
        Parser.getInstance().updateShape(e, newLS);
    }
