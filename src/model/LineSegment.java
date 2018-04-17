/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Graphics;

/**
 *
 * @author MaramH
 */
public class LineSegment extends AbstractShape {
    public void draw(Object canvas)
    {
        Graphics g = (Graphics)canvas;
        g.drawLine(position.x,position.y , Integer.parseInt(properties.get("x").toString()), 
                Integer.parseInt(properties.get("y").toString()));
    }
   
    
    
    
}
