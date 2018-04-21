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
public class Square extends Rectangle {
  
    public Square()
    {
          properties=new HashMap<>();
        properties.put("side",0.0);
        
    }
    
    public void draw(Graphics canvas)
    {
        Graphics g = (Graphics)canvas;
        ((Graphics2D)canvas).setColor(getFillColor());
        ((Graphics2D)canvas).fillRect((int)position.x,(int)position.y,(int)properties.get("side").intValue(),(int)properties.get("side").intValue());
        ((Graphics2D)canvas).setStroke(new BasicStroke(2));
        ((Graphics2D)canvas).setColor(getColor());
        ((Graphics2D)canvas).drawRect((int)position.x,(int)position.y,(int)properties.get("side").intValue(),(int)properties.get("side").intValue());
        
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException{
        Shape s=new Square();
        s.setColor(color);
        s.setFillColor(fillColor);
        s.setPosition(position);
        Map newP = new HashMap<>();
        for(Map.Entry k: properties.entrySet())
            newP.put(k.getKey(),k.getValue());
        s.setProperties(newP);
        return s;
        
    }
    }

