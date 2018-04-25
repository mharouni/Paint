/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import controller.Factory;
import controller.Parser;
import java.awt.Point;
import model.*;

public class LineSegmentActions {
    Factory f = new Factory();
    
    public void resize(Shape e, double x, double y) throws CloneNotSupportedException
    {
        LineSegment newLS = (LineSegment)e.clone();
        
        f.factoryProp(newLS, x, y);
        
        Parser.getInstance().updateShape(e, newLS);
    }
    
    public void move(Shape e, Point p) throws CloneNotSupportedException
    {
        int dx=e.getPosition().x-p.x;
        int dy=e.getPosition().y-p.y;
        LineSegment newT= (LineSegment)e.clone();
        newT.setPosition(p);
        f.factoryProp(newT,newT.getProperties().get("X2")+dx,newT.getProperties().get("Y2")+dy);
        Parser.getInstance().updateShape(e, newT);
    }
    
    public void copy(Shape e) throws CloneNotSupportedException
    {
        LineSegment newT = (LineSegment)e.clone();
        Point p= new Point(newT.getPosition().x+10,newT.getPosition().y-10);
        move(newT,p);
        Parser.getInstance().addShape(newT);
    }
    
    public void delete(Shape e)
    {
        Parser.getInstance().removeShape(e);
    }
}