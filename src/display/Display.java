package display;

import IO.Input;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Arrays;

public abstract class Display {

    private  static  boolean created = false;

    private static JFrame windows;
    private static Canvas contents;

    private static Graphics       bufferGraphics;
    private static BufferedImage  bufferedImage;
    private static BufferStrategy bufferStrategy;

    private static int   clearColor;
    private static int[] bufferData;

    public static void create(int width, int height, String title, int _clearColor, int numbBuffers){
        if (created )
            return;

        windows = new JFrame(title);
        windows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contents = new Canvas();
        Dimension size = new Dimension(width, height);
        contents.setPreferredSize(size);

        windows.getContentPane().add(contents);
        windows.pack();
        windows.setLocationRelativeTo(null);
        windows.setResizable(false);
        windows.setVisible(true);

        bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        bufferData = ((DataBufferInt)bufferedImage.getRaster().getDataBuffer()).getData();
        bufferGraphics = bufferedImage.getGraphics();

        ((Graphics2D) bufferGraphics).setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        clearColor = _clearColor;

        contents.createBufferStrategy(numbBuffers);
        bufferStrategy = contents.getBufferStrategy();

        created = true;

    }

    public static void clear(){
        Arrays.fill(bufferData, clearColor);
    }

    public static void swapBuffers(){
        Graphics g = bufferStrategy.getDrawGraphics();
        g.drawImage(bufferedImage, 0, 0, null);
        bufferStrategy.show();
    }
    public static Graphics2D getGraphics(){
        return (Graphics2D) bufferGraphics;

    }

    public static void destroy(){
        if (!created )
            return;
        windows.dispose();
    }

    public static void setTitle(String title){
        windows.setTitle(title);
    }

    public static void addInputListener (Input inputListener){
        windows.add(inputListener);
    }
}
