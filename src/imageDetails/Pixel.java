/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageDetails;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author root
 */
public class Pixel {
   BufferedImage image;
   int width;
   int height;
   
   public void getPixelFromFile(File input) {
      try {
         image = ImageIO.read(input);
         width = image.getWidth();
         height = image.getHeight();
         
         int count = 0;
         
         for(int i=0; i<height; i++) {
         
            for(int j=0; j<width; j++) {
            
               count++;
               Color c = new Color(image.getRGB(j, i));
               System.out.println("S.No: " + count + " Red: " + c.getRed() +"  Green: " + c.getGreen() + " Blue: " + c.getBlue());
            }
         }

      } catch (Exception e) {}
   }
   
      public void getPixelFromBufferImage(BufferedImage image) {
      try {
         width = image.getWidth();
         height = image.getHeight();
         
         int count = 0;
         
         for(int i=0; i<height; i++) {
         
            for(int j=0; j<width; j++) {
            
               count++;
               Color c = new Color(image.getRGB(j, i));
               if(c.getRed() > 0 || c.getGreen() >0 || c.getBlue() >0)
               {
                   System.out.println("S.No: " + count + " Red: " + c.getRed() +"  Green: " + c.getGreen() + " Blue: " + c.getBlue());
               }
            }
         }

      } catch (Exception e) {}
   }
}
