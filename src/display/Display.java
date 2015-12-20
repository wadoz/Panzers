package display;

import javax.swing.*;
import java.awt.*;

public abstract class Display {

    private  static  boolean created = false;
    private static JFrame windows;
    private static Canvas contents;

    public static void create(int width, int height, String title){
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

    }

    public static void render() {

    }
}
