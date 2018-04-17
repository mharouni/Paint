/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.awt.Graphics;
import java.util.Map;

/**
 *
 * @author MaramH
 */
public class Circle extends Ellipse{
    
    public void draw(Object canvas)
    {
        Graphics g = (Graphics)canvas;
        g.drawOval(position.x,position.y,Integer.parseInt(properties.get("radius").toString()),Integer.parseInt(properties.get("radius").toString()));
        
    }
    
}
