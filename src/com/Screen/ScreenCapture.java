/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Screen;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author root
 */
public class ScreenCapture {

    public BufferedImage capture(JPanel pane) {
        try {
            // TODO code application logic here
            Robot robot = new Robot();
            Rectangle rectangle = new Rectangle(pane.getLocationOnScreen(), pane.getSize() );
            BufferedImage image = robot.createScreenCapture(rectangle);
            return  image;

        } catch (AWTException ex) {
            Logger.getLogger(ScreenCapture.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
