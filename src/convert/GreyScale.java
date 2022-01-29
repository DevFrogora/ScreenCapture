/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convert;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author root
 */
public class GreyScale {

    BufferedImage bufferImage = null;
    int width;
    int height;

    public BufferedImage convertRGBToGreyScaleFromBufferImage(BufferedImage bufferedImage) {
        try {
            bufferImage = bufferedImage;
            width = bufferedImage.getWidth();
            height = bufferedImage.getHeight();

            for (int i = 0; i < height; i++) {

                for (int j = 0; j < width; j++) {

                    Color c = new Color(bufferImage.getRGB(j, i));
                    int red = (int) (c.getRed() * 0.299);
                    int green = (int) (c.getGreen() * 0.587);
                    int blue = (int) (c.getBlue() * 0.114);
                    Color newColor = new Color(red + green + blue,
                            red + green + blue, red + green + blue);

                    bufferImage.setRGB(j, i, newColor.getRGB());
                }
            }

            return bufferImage;

        } catch (Exception e) {
            System.out.println("convert.GreyScale.convertGreyScaleFromBufferImage()"+e);
        }
        return bufferImage;
    }
    
        public BufferedImage convertGreyScaleToRGBFromBufferImage(BufferedImage bufferedImage) {
        try {
            bufferImage = bufferedImage;
            width = bufferedImage.getWidth();
            height = bufferedImage.getHeight();

            for (int i = 0; i < height; i++) {

                for (int j = 0; j < width; j++) {

                    Color c = new Color(bufferImage.getRGB(j, i));
                    int red = (int) (c.getRed() * 0.299);
                    int green = (int) (c.getGreen() * 0.587);
                    int blue = (int) (c.getBlue() * 0.114);
                    Color newColor = new Color(red + green + blue,
                            red + green + blue, red + green + blue);

                    bufferImage.setRGB(j, i, newColor.getRGB());
                }
            }

            return bufferImage;

        } catch (Exception e) {
            System.out.println("convert.GreyScale.convertGreyScaleFromBufferImage()"+e);
        }
        return bufferImage;
    }

}
