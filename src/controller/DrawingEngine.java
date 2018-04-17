/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Graphics;
import model.Shape;

/**
 *
 * @author MaramH
 */
public interface DrawingEngine {
 
    public void draw(Graphics canvas);
    public void addShape(Shape shape);
    public void removeShape(Shape shape);
    public void updateShape(Shape oldShape, Shape newShape);
    public Shape[] getShapes();
    public void undo();
    public void redo();
    public void save(String path);
    public void load(String path);
    
    
}
