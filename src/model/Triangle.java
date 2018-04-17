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
public class Triangle extends AbstractShape {
    @Override
    public void draw(Object canvas){
        Graphics g = (Graphics)canvas;
        int[] xPoints = {position.x,Integer.parseInt(properties.get("x2").toString(),
                Integer.parseInt(properties.get("x3").toString()))};
        int[] yPoints = {position.y,Integer.parseInt(properties.get("y2").toString(),
                Integer.parseInt(properties.get("y3").toString()))};
        g.drawPolygon(xPoints, yPoints, 3);
    }
    
}
