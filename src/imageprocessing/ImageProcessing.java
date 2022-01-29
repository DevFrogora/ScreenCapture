/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageprocessing;

import java.awt.EventQueue;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingWorker;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;
import viewer.ImageBufferViewer;

/**
 *
 * @author root
 */
public class ImageProcessing {

    public static JFrame frame;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
                EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
        frame = new JFrame();
        ImageBufferViewer imageBufferViewer = new ImageBufferViewer();
        frame.getContentPane().add(imageBufferViewer);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500, 500);
        frame.setVisible(true);
        imageBufferViewer.refreshScreen(frame);
            }});
//        frame.addComponentListener(new ComponentAdapter() {
//            public void componentMoved(ComponentEvent ce) {
//                System.out.println("x = ");
////                frame.setVisible(false);
//                 imageBufferViewer.repaint();
//                    imageBufferViewer.validate();
//                    frame.setVisible(true);
//            }
//        });



//        Thread thread = new Thread(new Runnable() {
//            int counter = 0;
//
//            @Override
//            public void run() {
//                while (true) {
//                    try {
////                        frame.setVisible(false);
//                        Thread.sleep(5000);
////                        frame.setVisible(true);
//                        imageBufferViewer.refreshScreen();
//                        frame.repaint();
//                        frame.revalidate();
//                    } catch (InterruptedException ex) {
//                        Logger.getLogger(ImageProcessing.class.getName()).log(Level.SEVERE, null, ex);
//                    }
////                    imageBufferViewer.refreshScreen();
//                    System.out.println("Painter " + counter++ + "Frame GetX Value : " + frame.getX() + " Frame GetY Value : " + frame.getY()+ " Panel location on screen : "+ imageBufferViewer.getLocationOnScreen());
//                }
//
//            }
//        });
//        thread.start();
        


        System.out.println("Image Loaded");
    }

}
