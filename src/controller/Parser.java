/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Graphics;
import model.Shape;
import java.util.ArrayList;

/**
 *
 * @author MaramH
 */
public class Parser implements DrawingEngine {
    private ArrayList<Shape> sh = new ArrayList<Shape>();
    @Override
    public void draw(Object canvas){
    
        for(Shape shape: sh){
           shape.draw(canvas);
        }
    }
    
    
    public void addShape(Shape shape){
        
        sh.add(shape);
    }
    
    
    public void removeShape(Shape shape){
    
        for(Shape shapes: sh){
            if(shapes.equals(shape))
                sh.remove(shape);
            
        }
    }
    
    
    public void updateShape(Shape oldShape, Shape newShape){
      for(Shape shapes: sh){
            if(shapes.equals(oldShape))
                sh.set(sh.indexOf(oldShape), newShape);}}
    
    
    
    @Override
    public Shape[] getShapes(){ 
        Shape[] shapes = new Shape[sh.size()];
        shapes= sh.toArray(shapes);
        return shapes;}
    
    
    public void undo(){}
    
    
    public void redo(){}
    
    
    public void save(String path){}
    
    
    public void load(String path){}
    
    }
