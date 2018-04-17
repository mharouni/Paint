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
public class Square extends Rectangle {
    public void draw(Object canvas)
    {
        Graphics g = (Graphics)canvas;
            g.drawRect(position.x, position.y, Integer.parseInt(properties.get("side").toString()),Integer.parseInt(properties.get("side").toString()));}

    }

