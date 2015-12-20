package main;

import display.Display;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Main {

    private static int wigth  = 800;
    private static int height = 600;
    private static final String title = "Game";
    public static void main(String[] args) {

        Display.create(wigth, height, title);
        Timer timer = new Timer(1000 / 60, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Display.render();
            }
        });

        timer.setRepeats(true);timer.start();
    }

}
