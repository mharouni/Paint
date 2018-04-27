/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.Factory;
import controller.Parser;
import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author MaramH
 */
public class Square extends Rectangle {

    public Square() {
        properties = new HashMap<>();
        properties.put("side", 0.0);

    }

    public void draw(Object canvas) {
        //Graphics g = (Graphics)canvas;
        ((Graphics2D) canvas).setColor(getFillColor());
        ((Graphics2D) canvas).fillRect((int) position.x, (int) position.y, (int) properties.get("side").intValue(), (int) properties.get("side").intValue());
        ((Graphics2D) canvas).setStroke(new BasicStroke(2));
        ((Graphics2D) canvas).setColor(getColor());
        ((Graphics2D) canvas).drawRect((int) position.x, (int) position.y, (int) properties.get("side").intValue(), (int) properties.get("side").intValue());

    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Shape s = new Square();
        s.setColor(color);
        s.setFillColor(fillColor);
        s.setPosition(position);
        Map newP = new HashMap<>();
        for (Map.Entry k : properties.entrySet()) {
            newP.put(k.getKey(), k.getValue());
        }
        s.setProperties(newP);
        return s;

    }

    @Override
    public boolean Contains(Point p) {

        double i = properties.get("side");
        Point c = new Point();
        c.x = (int) (position.x + (i / 2));
        c.y = (int) (position.y - (i / 2));
        if (c.x > p.x && c.y > p.y) {
            if (((double) c.x - p.x <= i / 2) && ((double) c.y - p.y <= i / 2)) {
                return true;
            } else {
                return false;
            }
        } else if (c.x < p.x && c.y > p.y) {
            if (((double) p.x - c.x <= i / 2) && ((double) c.y - p.y <= i / 2)) {
                return true;
            } else {
                return false;
            }
        } else if (c.x > p.x && c.y < p.y) {
            if (((double) c.x - p.x <= i / 2) && ((double) p.y - c.y <= i / 2)) {
                return true;
            } else {
                return false;
            }
        } else if (c.x < p.x && c.y < p.y) {
            if (((double) p.x - c.x <= i / 2) && ((double) p.y - c.y <= i / 2)) {
                return true;
            } else {
                return false;
            }
        } else if (c.x == p.x && c.y < p.y) {
            if (p.y - c.y <= i / 2) {
                return true;
            } else {
                return false;
            }
        } else if (c.x == p.x && c.y > p.y) {
            if (c.y - p.y <= i / 2) {
                return true;
            } else {
                return false;
            }
        } else if (c.y == p.y && c.x < p.x) {
            if (p.x - c.x <= i / 2) {
                return true;
            } else {
                return false;
            }
        } else if (c.y == p.y && c.x > p.x) {
            if (c.x - p.x <= i / 2) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public AbstractShape resize( double x, double y) throws CloneNotSupportedException {
        Factory f = new Factory();

        Square newS = (Square) this.clone();

        f.factoryProp(newS, x, y);

        return newS;
    }

    public void move(Shape e, Point p) throws CloneNotSupportedException {
        Square newT = (Square) e.clone();
        newT.setPosition(p);
        Parser.getInstance().updateShape(e, newT);
    }

    public void copy(Shape e, Point p) throws CloneNotSupportedException {
        Square newT = (Square) e.clone();
        newT.setPosition(p);

        Parser.getInstance().addShape(newT);
    }

    public void delete(Shape e) {
        Parser.getInstance().removeShape(e);
    }

}
