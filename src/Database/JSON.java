/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.*;

import controller.Parser;
import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.AbstractShape;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.Arrays;
import model.*;

/**
 *
 * @author MaramH
 */
public class JSON implements Files {

    public void save(String s) throws IOException {

        JSONObject obj = new JSONObject();
        JSONObject object = new JSONObject();
        JSONArray array = new JSONArray();
        FileWriter writer = new FileWriter(s);
        //BufferedWriter bw = new BufferedWriter(writer);
        
        JSONObject obj1 = new JSONObject();
        for (AbstractShape shape : Parser.getInstance().getSh()) {

            StringBuilder builder;
            if (shape instanceof Circle) {
                obj = new JSONObject();
                obj.put("Type", "Circle");
                obj.put("radius", shape.getProperties().get("radius"));
                builder = new StringBuilder();
                builder.append("\"").append(shape.getColor().getRGB()).append("\"");
                //builder.append("\"").append(shape.getColor().getRed()).append(",").append(shape.getColor().getGreen()).append(",").append(shape.getColor().getBlue()).append("\"");
                obj.put("LineColor", builder);
                builder = new StringBuilder();
                builder.append("\"").append(shape.getFillColor().getRGB()).append("\"");
                //builder.append("\"").append(shape.getFillColor().getRed()).append(",").append(shape.getFillColor().getGreen()).append(",").append(shape.getFillColor().getBlue()).append("\"");
                obj.put("FillColor", builder);
                builder = new StringBuilder();
                builder.append("\"").append((int) shape.getPosition().getX()).append(",").append((int) shape.getPosition().getY()).append("\"");
                obj.put("Position", builder);
                array.add(obj);

                
            } else if (shape instanceof Ellipse) {
                obj1.put("Type", "Ellipse");
                obj1.put("width", shape.getProperties().get("width"));
                obj1.put("height", shape.getProperties().get("height"));

                builder = new StringBuilder();
                builder.append("\"").append(shape.getColor().getRGB()).append("\"");
                //builder.append("\"").append(shape.getColor().getRed()).append(",").append(shape.getColor().getGreen()).append(",").append(shape.getColor().getBlue()).append("\"");
                obj1.put("LineColor", builder);
                builder = new StringBuilder();
                builder.append("\"").append(shape.getFillColor().getRGB()).append("\"");
                //builder.append("\"").append(shape.getFillColor().getRed()).append(",").append(shape.getFillColor().getGreen()).append(",").append(shape.getFillColor().getBlue()).append("\"");
                obj1.put("FillColor", builder);
                builder = new StringBuilder();
                builder.append("\"").append((int) shape.getPosition().getX()).append(",").append((int) shape.getPosition().getY()).append("\"");
                obj1.put("Position", builder);
                array.add(obj1);
                // bw.newLine();

            } else if (shape instanceof Triangle) {
                obj = new JSONObject();
                obj.put("Type", "Triangle");
                obj.put("x2", shape.getProperties().get("x2"));
                obj.put("y2", shape.getProperties().get("y2"));
                obj.put("x3", shape.getProperties().get("x3"));
                obj.put("y3", shape.getProperties().get("y3"));
                builder = new StringBuilder();
                builder.append("\"").append(shape.getColor().getRGB()).append("\"");
                //builder.append("\"").append(shape.getColor().getRed()).append(",").append(shape.getColor().getGreen()).append(",").append(shape.getColor().getBlue()).append("\"");
                obj.put("LineColor", builder);
                builder = new StringBuilder();
                builder.append("\"").append(shape.getFillColor().getRGB()).append("\"");
                //builder.append("\"").append(shape.getFillColor().getRed()).append(",").append(shape.getFillColor().getGreen()).append(",").append(shape.getFillColor().getBlue()).append("\"");
                obj.put("FillColor", builder);
                builder = new StringBuilder();
                builder.append("\"").append((int) shape.getPosition().getX()).append(",").append((int) shape.getPosition().getY()).append("\"");
                obj.put("Position", builder);
                array.add(obj);
                // bw.newLine();

            } else if (shape instanceof LineSegment) {
               obj = new JSONObject();
                obj.put("Type", "LineSegment");
                obj.put("X2", shape.getProperties().get("X2"));
                obj.put("Y2", shape.getProperties().get("Y2"));
                builder = new StringBuilder();
                builder.append("\"").append(shape.getColor().getRGB()).append("\"");
                //builder.append("\"").append(shape.getColor().getRed()).append(",").append(shape.getColor().getGreen()).append(",").append(shape.getColor().getBlue()).append("\"");
                obj.put("LineColor", builder);
               
                builder = new StringBuilder();
                builder.append("\"").append((int) shape.getPosition().getX()).append(",").append((int) shape.getPosition().getY()).append("\"");
                obj.put("Position", builder);
                array.add(obj);
               

            }
            if (shape instanceof Square) {
                obj = new JSONObject();
                obj.put("Type", "Square");
                obj.put("side", shape.getProperties().get("side"));
                builder = new StringBuilder();
                builder.append("\"").append(shape.getColor().getRGB()).append("\"");
                //builder.append("\"").append(shape.getColor().getRed()).append(",").append(shape.getColor().getGreen()).append(",").append(shape.getColor().getBlue()).append("\"");
                obj.put("LineColor", builder);
                builder = new StringBuilder();
                builder.append("\"").append(shape.getFillColor().getRGB()).append("\"");
                //builder.append("\"").append(shape.getFillColor().getRed()).append(",").append(shape.getFillColor().getGreen()).append(",").append(shape.getFillColor().getBlue()).append("\"");
                obj.put("FillColor", builder);
                builder = new StringBuilder();
                builder.append("\"").append((int) shape.getPosition().getX()).append(",").append((int) shape.getPosition().getY()).append("\"");
                obj.put("Position", builder);
                array.add(obj);


            } else if (shape instanceof Rectangle) {
                obj = new JSONObject();
                obj.put("Type", "Rectangle");
                obj.put("width", shape.getProperties().get("width"));
                 obj.put("height", shape.getProperties().get("height"));
                builder = new StringBuilder();
                builder.append("\"").append(shape.getColor().getRGB()).append("\"");
                //builder.append("\"").append(shape.getColor().getRed()).append(",").append(shape.getColor().getGreen()).append(",").append(shape.getColor().getBlue()).append("\"");
                obj.put("LineColor", builder);
                builder = new StringBuilder();
                builder.append("\"").append(shape.getFillColor().getRGB()).append("\"");
                //builder.append("\"").append(shape.getFillColor().getRed()).append(",").append(shape.getFillColor().getGreen()).append(",").append(shape.getFillColor().getBlue()).append("\"");
                obj.put("FillColor", builder);
                builder = new StringBuilder();
                builder.append("\"").append((int) shape.getPosition().getX()).append(",").append((int) shape.getPosition().getY()).append("\"");
                obj.put("Position", builder);
                array.add(obj);
            }

        }
        object.put("Shapes", array);
        writer.write(object.toJSONString());

        writer.flush();
        writer.close();
    }

    @Override
    public void load(String s) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        FileReader read = new FileReader(s);
        BufferedReader bf = new BufferedReader(read);
        JSONObject obj = (JSONObject) parser.parse(bf);
        Parser.getInstance().getSh().clear();
        JSONArray array = (JSONArray) obj.get("Shapes");

        for (int i = 0; i < array.size(); i++) {
            JSONObject temp = (JSONObject) array.get(i);
            if (temp.get("Type").toString().equalsIgnoreCase("circle")) {
                Circle c = new Circle();
                String lineColor = (String) temp.get("LineColor");
                c.setColor(new Color(Integer.parseInt(lineColor)));
                // c.setColor((Color) jsonObj.get("LineColor"));
                String fillColor = (String) temp.get("FillColor");
                c.setFillColor(new Color(Integer.parseInt(fillColor)));
                // c.setFillColor((Color) jsonObj.get("FillColor"));
                String coordinates = (String) temp.get("Position");
                String[] list = coordinates.split(",");
                c.setPosition(new Point(Integer.parseInt(list[0]), Integer.parseInt(list[1])));
                //c.setPosition((Point) jsonObj.get("Position"));
                c.getProperties().put("radius", (double) temp.get("radius"));
                Parser.getInstance().getSh().add(c);
            }
            
            else if(temp.get("Type").toString().equalsIgnoreCase("ellipse"))
            {
                Ellipse e = new Ellipse();
                String lineColor = (String) temp.get("LineColor");
                e.setColor(new Color(Integer.parseInt(lineColor)));
                // c.setColor((Color) jsonObj.get("LineColor"));
                String fillColor = (String) temp.get("FillColor");
                e.setFillColor(new Color(Integer.parseInt(fillColor)));
                // c.setFillColor((Color) jsonObj.get("FillColor"));
                String coordinates = (String) temp.get("Position");
                String[] list = coordinates.split(",");
                e.setPosition(new Point(Integer.parseInt(list[0]), Integer.parseInt(list[1])));
                //c.setPosition((Point) jsonObj.get("Position"));
                e.getProperties().put("width", (double) temp.get("width"));
                e.getProperties().put("height", (double) temp.get("height"));
                Parser.getInstance().getSh().add(e);
            }
             else if(temp.get("Type").toString().equalsIgnoreCase("triangle"))
            {
                Triangle t = new Triangle();
                String lineColor = (String) temp.get("LineColor");
                t.setColor(new Color(Integer.parseInt(lineColor)));
                // c.setColor((Color) jsonObj.get("LineColor"));
                String fillColor = (String) temp.get("FillColor");
                t.setFillColor(new Color(Integer.parseInt(fillColor)));
                // c.setFillColor((Color) jsonObj.get("FillColor"));
                String coordinates = (String) temp.get("Position");
                String[] list = coordinates.split(",");
                t.setPosition(new Point(Integer.parseInt(list[0]), Integer.parseInt(list[1])));
                //c.setPosition((Point) jsonObj.get("Position"));
                t.getProperties().put("x2", (double) temp.get("x2"));
                t.getProperties().put("y2", (double) temp.get("y2"));
                t.getProperties().put("x3", (double) temp.get("x3"));
                t.getProperties().put("y3", (double) temp.get("y3"));
                Parser.getInstance().getSh().add(t);
            }
              else if(temp.get("Type").toString().equalsIgnoreCase("LineSegment"))
            {
               LineSegment t = new LineSegment();
                String lineColor = (String) temp.get("LineColor");
                t.setColor(new Color(Integer.parseInt(lineColor)));
                // c.setColor((Color) jsonObj.get("LineColor"));
               
                String coordinates = (String) temp.get("Position");
                String[] list = coordinates.split(",");
                t.setPosition(new Point(Integer.parseInt(list[0]), Integer.parseInt(list[1])));
                //c.setPosition((Point) jsonObj.get("Position"));
                t.getProperties().put("X2", (double) temp.get("X2"));
                t.getProperties().put("Y2", (double) temp.get("Y2"));
               
                Parser.getInstance().getSh().add(t);
            }
             
            else if(temp.get("Type").toString().equalsIgnoreCase("Square"))
            {
                Square e = new Square();
                String lineColor = (String) temp.get("LineColor");
                e.setColor(new Color(Integer.parseInt(lineColor)));
                // c.setColor((Color) jsonObj.get("LineColor"));
                String fillColor = (String) temp.get("FillColor");
                e.setFillColor(new Color(Integer.parseInt(fillColor)));
                // c.setFillColor((Color) jsonObj.get("FillColor"));
                String coordinates = (String) temp.get("Position");
                String[] list = coordinates.split(",");
                e.setPosition(new Point(Integer.parseInt(list[0]), Integer.parseInt(list[1])));
                //c.setPosition((Point) jsonObj.get("Position"));
                e.getProperties().put("side", (double) temp.get("side"));
            
                Parser.getInstance().getSh().add(e);
            }
            
              else if(temp.get("Type").toString().equalsIgnoreCase("Rectangle"))
            {
                Rectangle e = new Rectangle();
                String lineColor = (String) temp.get("LineColor");
                e.setColor(new Color(Integer.parseInt(lineColor)));
                // c.setColor((Color) jsonObj.get("LineColor"));
                String fillColor = (String) temp.get("FillColor");
                e.setFillColor(new Color(Integer.parseInt(fillColor)));
                // c.setFillColor((Color) jsonObj.get("FillColor"));
                String coordinates = (String) temp.get("Position");
                String[] list = coordinates.split(",");
                e.setPosition(new Point(Integer.parseInt(list[0]), Integer.parseInt(list[1])));
                //c.setPosition((Point) jsonObj.get("Position"));
                e.getProperties().put("width", (double) temp.get("width"));
                 e.getProperties().put("height", (double) temp.get("height"));
           
                Parser.getInstance().getSh().add(e);
            }
            
        }
      
    }

}
