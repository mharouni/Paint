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


/**
 *
 * @author google
 */
public class TriangleActions implements Actions {
    Factory f = new Factory();
    
    public void resize(Shape e, double x, double y) throws CloneNotSupportedException
    {
        Triangle newT = (Triangle)e.clone();
        
        f.factoryProp(newT, x, y);
        
        Parser.getInstance().updateShape(e, newT);
    
    }
    
    public void move(Shape e, Point p) throws CloneNotSupportedException
    {
        int dx=e.getPosition().x-p.x;
        int dy=e.getPosition().y-p.y;
        Triangle newT= (Triangle)e.clone();
        newT.setPosition(p);
        f.factoryProp(newT,newT.getProperties().get("x2")+dx,newT.getProperties().get("y3")+dy);
        Parser.getInstance().updateShape(e, newT);
    }
    
    public void copy(Shape e,Point p) throws CloneNotSupportedException
    {
        Triangle newT = (Triangle)e.clone();
       // Point p= new Point(newT.getPosition().x+10,newT.getPosition().y-10);
        move(newT,p);
        Parser.getInstance().addShape(newT);
    }
    
    public void delete(Shape e)
    {
        Parser.getInstance().removeShape(e);
    }
}
