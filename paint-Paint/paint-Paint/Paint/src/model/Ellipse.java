/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.Factory;
import controller.Parser;
import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author MaramH
 */
public class Ellipse extends AbstractShape{
    
    public Ellipse()
    {
        properties=new HashMap<>();
        properties.put("width",0.0);
        properties.put("height",0.0);
        
    }
    
    
    public void draw(Object canvas)
    {
      //  Graphics g = (Graphics)canvas;
        ((Graphics2D)canvas).setColor(getFillColor());
        ((Graphics2D)canvas).fillOval((int)position.x,(int)position.y,(int)properties.get("width").intValue(),(int)properties.get("height").intValue());
        ((Graphics2D)canvas).setStroke(new BasicStroke(2));
        ((Graphics2D)canvas).setColor(getColor());
        ((Graphics2D)canvas).drawOval((int)position.x,(int)position.y,(int)properties.get("width").intValue(),(int)properties.get("height").intValue());
        
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException{
        Shape s=new Ellipse();
        s.setColor(color);
        s.setFillColor(fillColor);
        s.setPosition(position);
        Map newP = new HashMap<>();
        for(Map.Entry k: properties.entrySet())
            newP.put(k.getKey(),k.getValue());
        s.setProperties(newP);
        return s;
        
    }


    //@Override
     public boolean Contains(Point p)
    {
        double i,j;
        double mag;
        i = Math.abs((double)position.x - (double)p.x);
        j = Math.abs((double)position.y - (double)p.y);
       //mag = Math.sqrt(Math.pow(i,2) + Math.pow(j,2));
        if (i <= this.getProperties().get("width") && j <= this.getProperties().get("height"))
            return true;
        else return false;


    }
     
     public void resize(Shape e, double x, double y) throws CloneNotSupportedException
    {
        Factory f = new Factory();
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
    
    public void copy(Shape e,Point p) throws CloneNotSupportedException
    {
        Ellipse newT = (Ellipse)e.clone();
      //  Point p= new Point(newT.getPosition().x+10,newT.getPosition().y-10);
                newT.setPosition(p);

        Parser.getInstance().addShape(newT);
    }
    
    public void delete(Shape e)
    {
        Parser.getInstance().removeShape(e);
    }
   
    
}
