/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

//import Database.JSON;
import java.awt.Graphics;
import model.Shape;
import java.util.ArrayList;
import model.AbstractShape;
import java.awt.Canvas;
import java.util.logging.Level;
import java.util.logging.Logger;
//import org.json.JSONException;
import static view.Canvas.setCanvas;

/**
 *
 * @author Miralalaa
 */
public class Parser implements DrawingEngine {

    private ArrayList<AbstractShape> sh = new ArrayList<AbstractShape>();
    private Originator Org = new Originator();
    private Caretaker care = new Caretaker();
    private int counter = 0;
    private static Parser uniqueParser;

    public static Parser getInstance() {
        if (uniqueParser == null) {
            uniqueParser = new Parser();
        }
        return uniqueParser;
    }

    public Parser() {

    }

    public Caretaker getCare() {
        return care;
    }

    public Originator getOrg() {
        return Org;
    }

    public void setOrg(Originator Org) {
        this.Org = Org;
    }

    @Override
    public void draw(Object canvas) {
        Graphics g = (Graphics) canvas;
        if (sh.isEmpty()) {
        } else {
            for (Shape shape : sh) {
                shape.draw(g);

            }
        }

    }

    public ArrayList<AbstractShape> getSh() {
        return sh;
    }

    public void addShape(Shape shape) {

        sh.add((AbstractShape) shape);
        Org.setCan(sh);
        care.addMemento(Org.createMemento());
        int x = getCounter();
        x++;
        setCounter(x);
        System.out.println(x);
    }

    public void removeShape(Shape shape) {

        try {

            for (int i = 0; i < sh.size(); i++) {
                if ((sh.get(i)).equals((AbstractShape) shape)) {
                    sh.remove(i);
                }
            }
            Org.setCan(sh);
            care.addMemento(Org.createMemento());
            int x = getCounter();
            x++;
            setCounter(x);
        } catch (IndexOutOfBoundsException e) {
        }

    }

    public void updateShape(Shape oldShape, Shape newShape) {
        for (Shape shapes : sh) {
            if (shapes.equals(oldShape)) {
                sh.set(sh.indexOf(oldShape), (AbstractShape) newShape);
            }
        }
        Org.setCan(sh);
        care.addMemento(Org.createMemento());
        int x = getCounter();
        x++;
        setCounter(x);
    }

    @Override
    public Shape[] getShapes() {
        Shape[] shapes = new Shape[sh.size()];
        shapes = sh.toArray(shapes);
        return shapes;
    }

    @Override
    public void undo() {
        try{
       
        int x = getCounter();
        System.out.println(x);
        
        x--;

        //ArrayList<AbstractShape> aee = new ArrayList<AbstractShape>();
        this.setSh(Org.returnMemento(care.getMemento(x)));
        
        //System.out.println(b);
        System.out.println(x);

        setCounter(x);
        }

        catch(IndexOutOfBoundsException e)
        {
                 
         //  undo();
         }
    }

    public void setSh(ArrayList<AbstractShape> sh) {
        this.sh = sh;
    }

    @Override
    public void redo() {

        try {
       
        int x = getCounter();
        System.out.println(x);
        
        

        
        x++;

        
        this.setSh(Org.returnMemento(care.getMemento(x)));
        
        
        System.out.println(x);

        setCounter(x);
            
        } catch (IndexOutOfBoundsException e) {
           
          // redo();
        }

    }

    public void save(String path) {}
        //if(path.contains("JSON"))
            //JSON.JSONWriter(path);
    //}

    public void load(String path) {
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

}
