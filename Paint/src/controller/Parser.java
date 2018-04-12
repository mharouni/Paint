/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Shape;

/**
 *
 * @author MaramH
 */
public class Parser implements DrawingEngine {
    public void draw(Object canvas){}
    public void addShape(Shape shape){}
    public void removeShape(Shape shape){}
    public void updateShape(Shape oldShape, Shape newShape){}
    public Shape[] getShapes(){return null;}
    public void undo(){}
    public void redo(){}
    public void save(String path){}
    public void load(String path){}
    
    }
