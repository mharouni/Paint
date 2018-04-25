/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author MaramH
 */
public class Circle extends Ellipse{
    
    
    public Circle()
    {
        properties=new HashMap<>();
        properties.put("radius",0.0);
    }
    
    
    @Override
    public void draw(Object canvas)
    {
        Graphics g = (Graphics)canvas;
        ((Graphics2D)canvas).setColor(getFillColor());
        ((Graphics2D)canvas).fillOval((int)position.x,(int)position.y,(int)properties.get("radius").intValue(),(int)properties.get("radius").intValue());
        ((Graphics2D)canvas).setStroke(new BasicStroke(2));
        ((Graphics2D)canvas).setColor(getColor());
        ((Graphics2D)canvas).drawOval((int)position.x,(int)position.y,(int)properties.get("radius").intValue(),(int)properties.get("radius").intValue());
        
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException{
        Shape s=new Circle();
        s.setColor(color);
        s.setFillColor(fillColor);
        s.setPosition(position);
        Map newP = new HashMap<>();
        for(Map.Entry k: properties.entrySet())
            newP.put(k.getKey(),k.getValue());
        s.setProperties(newP);
        return s;
        
    }
    public boolean Contains(Point p)
    {
        double i,j;
        double mag;
        i= (double)position.x - (double)p.x;
        j= (double)position.y - (double)p.y;
        mag = Math.sqrt(Math.pow(i,2) + Math.pow(j,2));
        if (mag <= properties.get("radius"))
            return true;
        else return false;


    }

    
    
}
