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
public class Rectangle extends AbstractShape{
    
    public void draw(Object canvas){
        Graphics g = (Graphics)canvas;
        
    g.drawRect(position.x, position.y, Integer.parseInt(properties.get("width").toString()),Integer.parseInt(properties.get("height").toString()));}
    
    
}
