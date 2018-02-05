package com.mahuriventures.erp.desktop;

import com.mahuriventures.erp.desktop.ui.DashBoard;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Application {
    public static void main(String[] args) throws Exception{
        SwingUtilities.invokeAndWait(new Runnable() {
            public void run() {
                // open the main application
                DashBoard dashBoard = new DashBoard();
                dashBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                dashBoard.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                });

                dashBoard.setVisible(true);
            }
        });
        // do all the bootstrapping here

    }
}
