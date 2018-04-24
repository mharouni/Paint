/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.awt.*;
import java.util.Map;
import javax.swing.JComponent;

/**
 *
 * @author MaramH
 */
public abstract class AbstractShape extends JComponent implements Shape {
    protected Point position;
    protected Map<String, Double> properties;
    protected Color color=Color.BLACK ;
    protected Color fillColor;
    protected boolean Selected;
    

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
    
     public void setProperties(java.util.Map<String, Double> properties){
            this.properties=properties;}
     
     
    public java.util.Map<String, Double> getProperties(){return this.properties; }
    
    public Object clone() throws CloneNotSupportedException
    {
        return null;
    }

    public boolean isSelected() {
        return Selected;
    }

    public void setSelected(boolean Selected) {
        this.Selected = Selected;
    }
    
    //public abstract boolean Contains(Point p);
    
    }