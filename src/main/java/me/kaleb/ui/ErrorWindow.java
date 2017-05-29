package me.kaleb.ui;

import javax.swing.*;

public class ErrorWindow extends JFrame {

    public ErrorWindow(String title, String message) {
        JFrame frame = new JFrame();
        try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); } catch(Exception e) { }
        JOptionPane.showMessageDialog(frame, message, title, JOptionPane.ERROR_MESSAGE);
    }

}
