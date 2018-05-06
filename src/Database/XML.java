/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import controller.Parser;
import java.awt.Color;
import java.awt.Point;
import model.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.io.File;
import  java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.IIOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import model.LineSegment;
import model.Square;
import org.json.simple.parser.ParseException;
import org.xml.sax.SAXException;


/**
 *
 * @author MaramH
 */
public class XML implements Files {

    
    
    public void load( String s) throws ParseException, IOException{
    DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dbuilder;

    {
        try {
            dbuilder = builderFactory.newDocumentBuilder();
            Document document = dbuilder.parse("C:\\Users\\MaramH\\Desktop\\FinalPaint");
            document.normalize();
            NodeList rootnodes = document.getElementsByTagName("shapes");
            Node rootnode = ((NodeList) rootnodes).item(0);
            Element root = (Element) rootnode;
            NodeList shapes = root.getElementsByTagName("shape");
            for (int i =0;i<shapes.getLength();i++)
            {
                Node node = shapes.item(i);
                Element el = (Element) node;
                if (el.getAttribute("name").equalsIgnoreCase("Circle"))
                {
 Circle c = new Circle();
 
              String lineColor = (String)el.getAttribute("LineColor");
              c.setColor(new Color(Integer.parseInt(lineColor)));
            // c.setColor((Color) jsonObj.get("LineColor"));
           String fillColor = (String) el.getAttribute("FillColor");
             c.setFillColor(new Color(Integer.parseInt(fillColor)));
              // c.setFillColor((Color) jsonObj.get("FillColor"));
            String coordinates = (String) el.getAttribute("Position");
           String[] list = coordinates.split(",");
            c.setPosition(new Point(Integer.parseInt(list[0]), Integer.parseInt(list[1])));
            //c.setPosition((Point) jsonObj.get("Position"));
             c.getProperties().put("radius",Double.parseDouble(el.getAttribute("radius")));
             Parser.getInstance().getSh().add(c);

                }
                
                
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    }
    public XML() throws IOException, ParserConfigurationException {
     
    }

    
    public void save (String s) throws IOException {
        DocumentBuilderFactory docfactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docbuilder = null;
        try {
            docbuilder = docfactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document xmldoc = docbuilder.newDocument();
        Element rootelement = xmldoc.createElement("shapes");
        Element main;
        for (AbstractShape shape : Parser.getInstance().getSh()) {
            main = xmldoc.createElement("shape");
            if (shape instanceof Circle) {
                main.setAttribute("name", "Circle");
                main.setAttribute("radius", shape.getProperties().get("radius").toString());
                main.setAttribute("LineColor", String.valueOf(shape.getColor().getRGB()));
                main.setAttribute("FillColor", String.valueOf(shape.getFillColor().getRGB()));
                main.setAttribute("Position", (int)shape.getPosition().getX()+","+ (int)shape.getPosition().getY());//check string thing
                rootelement.appendChild(main);


            } else if (shape instanceof Ellipse) {
                main.setAttribute("name", "Ellipse");
                main.setAttribute("width", shape.getProperties().get("width").toString());
                main.setAttribute("height", shape.getProperties().get("height").toString());
                main.setAttribute("LineColor", String.valueOf(shape.getColor().getRGB()));
                main.setAttribute("FillColor", String.valueOf(shape.getFillColor().getRGB()));
                main.setAttribute("Position", (int)shape.getPosition().getX()+","+(int)shape.getPosition().getY());//check string thin
                rootelement.appendChild(main);
            } else if (shape instanceof Triangle) {
                main.setAttribute("name", "Triangle");
                main.setAttribute("x2", shape.getProperties().get("x2").toString());
                main.setAttribute("y2", shape.getProperties().get("y2").toString());
                main.setAttribute("x3", shape.getProperties().get("x3").toString());
                main.setAttribute("y3", shape.getProperties().get("y3").toString());
                main.setAttribute("LineColor", String.valueOf(shape.getColor().getRGB()));
                main.setAttribute("FillColor", String.valueOf(shape.getFillColor().getRGB()));
                main.setAttribute("Position", (int)shape.getPosition().getX()+","+(int)shape.getPosition().getY());
                rootelement.appendChild(main);
            }
            else if (shape instanceof LineSegment)
            {
                main.setAttribute("name", "LineSegment");
                main.setAttribute("X2", shape.getProperties().get("X2").toString());
                main.setAttribute("Y2", shape.getProperties().get("Y2").toString());
                main.setAttribute("LineColor",  String.valueOf(shape.getColor().getRGB()));
                main.setAttribute("FillColor", String.valueOf(shape.getFillColor().getRGB()));
                main.setAttribute("Position",(int) shape.getPosition().getX()+","+(int)shape.getPosition().getY());//c
                rootelement.appendChild(main);
  
            }
            else if ((shape instanceof Square))
            
            {
                main.setAttribute("name", "Square");
                main.setAttribute("side", shape.getProperties().get("side").toString());
                main.setAttribute("LineColor", String.valueOf(shape.getColor().getRGB()));
                main.setAttribute("FillColor", String.valueOf(shape.getFillColor().getRGB()));
                main.setAttribute("Position", (int)shape.getPosition().getX()+","+(int)shape.getPosition().getY());//c
                rootelement.appendChild(main);
                
            }
            else if (shape instanceof Rectangle)
            {
                main.setAttribute("name", "Rectangle");
                main.setAttribute("width", shape.getProperties().get("width").toString());
                main.setAttribute("height", shape.getProperties().get("height").toString());
                main.setAttribute("LineColor", String.valueOf(shape.getColor().getRGB()));
                main.setAttribute("FillColor", String.valueOf(shape.getFillColor().getRGB()));
                main.setAttribute("Position",(int) shape.getPosition().getX()+","+(int)shape.getPosition().getY());//c
                rootelement.appendChild(main);
                
            }

        }
        xmldoc.appendChild(rootelement);


        OutputFormat outFormat = new OutputFormat(xmldoc);
        outFormat.setIndenting(true);
        File xmlFile = new File("shapes.xml");
        FileOutputStream outStream = new FileOutputStream(xmlFile);
        XMLSerializer serializer = new XMLSerializer(outStream, outFormat);
        serializer.serialize(xmldoc);
    }
    }