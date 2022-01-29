/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convert;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

/**
 *
 * @author root
 */
public class OpenCvUtils {

    public static BufferedImage Mat2BufferedImage(Mat mat) throws IOException {
        //Encoding the image
        MatOfByte matOfByte = new MatOfByte();
        Imgcodecs.imencode(".png", mat, matOfByte);
        //Storing the encoded Mat in a byte array
        byte[] byteArray = matOfByte.toArray();
        //Preparing the Buffered Image
        InputStream in = new ByteArrayInputStream(byteArray);
        BufferedImage bufImage = ImageIO.read(in);
        return bufImage;
    }
    
    public static Mat loadImage(String filepath){
         //Loading the OpenCV core library  
      System.loadLibrary(Core.NATIVE_LIBRARY_NAME); 
      
      //Instantiating the imagecodecs class 
      Imgcodecs imageCodecs = new Imgcodecs(); 

      //Reading the Image from the file and storing it in to a Matrix object 
      String file =filepath;   
      Mat mat = imageCodecs.imread(file); 
      return mat;
    }
    
    public static Mat matToErisionMat(Mat src){
          // Creating an empty matrix to store the result
      Mat dst = new Mat();

      // Preparing the kernel matrix object
      Mat kernel = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, 
         new  Size((2*2) + 1, (2*2)+1));

      // Applying erode on the Image
      Imgproc.erode(src, dst, kernel);
      return  dst;
    }
}
