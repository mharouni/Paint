/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.awt.*;
import java.util.Map;

/**
 *
 * @author MaramH
 */
public abstract class AbstractShape implements Shape {
    protected Point position;
    protected Map<String, Double> properties;
    protected Color color;
    protected Color fillColor;

    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public void setPosition(Point position) {
        this.position = position;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public Color getFillColor() {
        return fillColor;
    }

    @Override
    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }
    
    public Object clone() throws CloneNotSupportedException{return null;}
    
    }