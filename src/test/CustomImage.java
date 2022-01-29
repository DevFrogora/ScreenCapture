/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URI;
import javax.imageio.ImageIO;

/**
 *
 * @author root
 */
public class CustomImage {

    BufferedImage bufferedImage = null;
    Graphics g;

    public BufferedImage createImageBuffer(int widthSize, int heightSIze) {
        bufferedImage = new BufferedImage(widthSize, heightSIze, BufferedImage.TYPE_INT_RGB);
        g = bufferedImage.getGraphics();
        return bufferedImage;
    }

    public BufferedImage createImageBufferFromFile(String imagePath) {
        try {
            File input = new File(imagePath);
            bufferedImage = ImageIO.read(input);
            g = bufferedImage.getGraphics();
            return bufferedImage;

        } catch (Exception e) {
            System.out.println("test.CustomImage.createImageBufferFromFile()"+e);
        }
        return bufferedImage;
    }

    public Graphics getGraphics() {
        return g;
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public void setbackgroundColor(Graphics g, int imgWidth, int imgHeight, Color bgColor) {
        g.setColor(bgColor);
        g.fillRect(0, 0, imgWidth, imgHeight);
//        return  g;
    }

    public void tileBackgroundColor(Graphics g, int startX, int startY, int imgWidth, int imgHeight, Color bgColor) {
        g.setColor(bgColor);
        g.fillRect(startX, startY, imgWidth, imgHeight);
//        return  g;
    }
}
