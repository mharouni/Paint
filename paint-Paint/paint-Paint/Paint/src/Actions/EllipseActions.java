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
public class EllipseActions {
    Factory f = new Factory();
    
    public void resize(Shape e, double x, double y) throws CloneNotSupportedException
    {
        Ellipse newEllipse = (Ellipse)e.clone();
        
        f.factoryProp(newEllipse, x, y);
        
        Parser.getInstance().updateShape(e, newEllipse);
    }
    
    public void move(Shape e, Point p) throws CloneNotSupportedException
    {
        Ellipse newT= (Ellipse)e.clone();
        newT.setPosition(p);
        Parser.getInstance().updateShape(e, newT);
    }
    
    public void copy(Shape e) throws CloneNotSupportedException
    {
        Ellipse newT = (Ellipse)e.clone();
        Point p= new Point(newT.getPosition().x+10,newT.getPosition().y-10);
        move(newT,p);
        Parser.getInstance().addShape(newT);
    }
    
    public void delete(Shape e)
    {
        Parser.getInstance().removeShape(e);
    }
}
