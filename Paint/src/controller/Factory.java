/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import model.*;

/**
 *
 * @author MaramH
 */
public class Factory {
    
    AbstractShape shape;
    Map<String, Double> prop = new HashMap<>();
    
    public AbstractShape factoryMethod(String s)
    {
        if(s == null)
            return null;
        if(s.equalsIgnoreCase("Circle"))
            return new Circle();
        else if(s.equalsIgnoreCase("Ellipse"))
            return new Ellipse();
        else if(s.equalsIgnoreCase("Recatngle"))
            return new Rectangle();
        else if(s.equalsIgnoreCase("Square"))
            return new Square();
        else if(s.equalsIgnoreCase("LineSegment"))
            return new LineSegment();
        else if(s.equalsIgnoreCase("Triangle"))
            return new Triangle();

        
        
       return null;
            
    }
    
    public void factoryProp(AbstractShape s, double x, double y)
    {
        if(s instanceof Circle )
            prop.put("radius",x-s.getPosition().x);
        else if(s instanceof Ellipse){
            prop.put("width",x-s.getPosition().x);
            prop.put("height", y-s.getPosition().y);}
        else if(s instanceof Square)
            prop.put("side",x-s.getPosition().x);
        else if(s instanceof Rectangle){
            prop.put("width",x-s.getPosition().x);
            prop.put("height",y-s.getPosition().y);}
        else if(s instanceof LineSegment){
            prop.put("x2", x);
            prop.put("y2", y);}
        s.setProperties(prop);
        
        }
    
             public void factoryProp(AbstractShape s,Point y,Point z)
             {
                 prop.put("x2",(double)y.x);
                 prop.put("y2",(double)y.y);
                 prop.put("x3",(double)z.x);
                 prop.put("y3",(double)z.y);
                 s.setProperties(prop);
             }
                 
        
    }
    

