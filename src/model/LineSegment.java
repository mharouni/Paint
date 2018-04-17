/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author MaramH
 */
public class LineSegment extends AbstractShape {
   
    public LineSegment()
    {
        properties=new HashMap<>();
        properties.put("x2",0.0);
        properties.put("y2",0.0);
    }
    
    
    public void draw(Graphics canvas)
    {
        Graphics g = (Graphics)canvas;
        ((Graphics2D)canvas).setColor(getFillColor());
        ((Graphics2D)canvas).drawLine((int)position.x,(int)position.y,(int)properties.get("x2").intValue(),(int)properties.get("y2").intValue());
        ((Graphics2D)canvas).setStroke(new BasicStroke(2));
        ((Graphics2D)canvas).setColor(getColor());
        
    }
    
        @Override
    public Object clone() throws CloneNotSupportedException{
        Shape s=new LineSegment();
        s.setColor(color);
        s.setPosition(position);
        Map newP = new HashMap<>();
        for(Map.Entry k: properties.entrySet())
            newP.put(k.getKey(),k.getValue());
        s.setProperties(newP);
        return s;
        
    }
   
    
    
    
}
