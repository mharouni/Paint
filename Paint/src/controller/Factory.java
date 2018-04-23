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
    
    Shape shape;
    Map<String, Double> prop = new HashMap<>();
    
    public Shape factoryMethod(String s)
    {
        if(s == null)
            return null;
        if(s.equalsIgnoreCase("Circle"))
            return new Circle();
        else if(s.equalsIgnoreCase("Ellipse"))
            return new Ellipse();
        else if(s.equalsIgnoreCase("Rectangle"))
            return new Rectangle();
        else if(s.equalsIgnoreCase("Square"))
            return new Square();
        else if(s.equalsIgnoreCase("LineSegment"))
            return new LineSegment();
        else if(s.equalsIgnoreCase("Triangle"))
            return new Triangle();

        
        
       return null;
            
    }
    
    public void factoryProp(Shape s, double x, double y)
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
        else if ( s instanceof Triangle){
                prop.put("x2",x);
                 prop.put("y2",(double)s.getPosition().y);
                 prop.put("x3",Math.abs(s.getPosition().x+x)/2);
                 prop.put("y3",y);}
        s.setProperties(prop);
        
        }
    
                 
        
    }
    

