/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
public class LineSegment extends AbstractShape {
   
    public LineSegment()
    {
        properties=new HashMap<>();
        properties.put("X2",0.0);
        properties.put("Y2",0.0);
    }
    
    
    public void draw(Object canvas)
    {
       // Graphics g = (Graphics)canvas;
       // ((Graphics2D)canvas).setColor(getColor());
        ((Graphics2D)canvas).drawLine((int)position.x,(int)position.y,(int)properties.get("X2").intValue(),(int)properties.get("Y2").intValue());
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
    public boolean Contains(Point p)
    {
        double i= position.x-properties.get("x2");
        double j= position.y-properties.get("y2");
        double i1= position.x-p.x;
        double j1 = position.y-p.y;
        double mag= Math.sqrt(Math.pow(i, 2) + Math.pow(j, 2));
        double mag1 = Math.sqrt(Math.pow(i1,2) + Math.pow(j1,2));
        double angle= Math.toDegrees(Math.atan(j/i));
        double angle1= Math.toDegrees(Math.atan(j1/i1));
        if (mag>=mag1 && angle == angle1  )
                return true;
        else return false;
        
    }
   

    
    
}
