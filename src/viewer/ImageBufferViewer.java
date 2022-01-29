/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewer;

import com.Screen.ScreenCapture;
import convert.GreyScale;
import convert.OpenCvUtils;
import imageDetails.Pixel;
import imageprocessing.ImageProcessing;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import org.opencv.core.Mat;
import test.CustomImage;

/**
 *
 * @author root
 */
public class ImageBufferViewer extends JPanel {

    String filename = "image.png";
    String resourceDir = "E:\\project work\\java\\project source code\\new\\ImageProcessing\\build\\classes\\imageprocessing\\resources\\";
    int posX = 0;
    int posY = 0;
    ScreenCapture screenCapture;
    public JPanel jpanel = this;
    BufferedImage image = null;

    public ImageBufferViewer() {
        screenCapture = new ScreenCapture();

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
//        CustomImage customImage = new CustomImage();
////        BufferedImage img = customImage.createImageBufferFromFile(this.getClass().getClassLoader().getResource("imageprocessing\\resources\\image.png").getPath());
//        BufferedImage img = customImage.createImageBufferFromFile(resourceDir+filename);
//        Path currentRelativePath = Paths.get("");
//        String s = currentRelativePath.toAbsolutePath().toString();
//        System.out.println("Current absolute path is: " +this.getClass().getClassLoader().getResource("imageprocessing/resources/image.png").getPath()+"/imageprocessing/resources/image.png");
//        g.drawImage(img, 0, 0, this);
//         
//        GreyScale greyScale = new GreyScale();
//        img= greyScale.convertRGBToGreyScaleFromBufferImage(img);
////        createTextToImage(customImage);
//        g.drawImage(img, 70, 0, this);
//        
////        img= greyScale.convertGreyScaleToRGBFromBufferImage(img);
//        Mat mat = OpenCvUtils.loadImage(resourceDir+filename);
//        mat = OpenCvUtils.matToErisionMat(mat);
//        try {
//            img = OpenCvUtils.Mat2BufferedImage(mat);
//        } catch (IOException ex) {
//            Logger.getLogger(ImageBufferViewer.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        g.drawImage(img, 140, 0, this);
//        posX = posX + 100;
//        g.drawImage(new ScreenCapture().capture(ImageProcessing.frame.getX(), ImageProcessing.frame.getY(), 100, 100), posX, 0, this);
        if (image != null) {
            g.drawImage(image, 0, 0, this); //.capture(this)
        }
//       this.repaint();
//        this.revalidate();

    }

    void createTextToImage(CustomImage customImage) {
        Graphics g = customImage.getGraphics();
        customImage.tileBackgroundColor(g, 0, 0, 200, 5, Color.GREEN);
        g.setColor(Color.red);
        g.drawString("umm", 0, 20);
        customImage.tileBackgroundColor(g, 10, 25, 10, 10, Color.yellow);
    }

    void pixelInfoFromImage(BufferedImage img) {
        Pixel pixel = new Pixel();
        pixel.getPixelFromBufferImage(img);
    }

    public void refreshScreen(JFrame frame) {
//        this.repaint();
        SwingWorker<Void, BufferedImage> worker = new SwingWorker<Void, BufferedImage>() {

            private BufferedImage buffimage;
            private ReentrantLock lckParked = new ReentrantLock();

            @Override
            protected Void doInBackground() throws Exception {
                while (true) {
                    buffimage = screenCapture.capture(jpanel);
                    Thread.sleep(500);
                    lckParked.lock();
                    try {
                        publish(buffimage);
                    } finally {
                        lckParked.unlock();
                    }

                    System.out.print("do");
                }

//                return null;
            }

            @Override
            protected void process(List<BufferedImage> images) {

                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        lckParked.lock();
                        try {
                            if (!images.isEmpty()) {
                                ImageBufferViewer.this.image = images.get(images.size() - 1);
//                    ImageBufferViewer.this.removeAll();
//                    ImageBufferViewer.this.repaint();
                                frame.invalidate();
                                frame.repaint();
                            }
                        } finally {
                            lckParked.unlock();
                        }
                    }
                });

            }

        };
        worker.execute();
//    this.revalidate();
    }

}
