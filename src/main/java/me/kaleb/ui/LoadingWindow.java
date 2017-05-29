package me.kaleb.ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LoadingWindow extends JFrame {

    private JPanel contentPane;

    public LoadingWindow() {
        setAlwaysOnTop(true);
        setType(Type.POPUP);
        setTitle("OCR In Progress");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setBounds(100, 100, 422, 66);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); } catch(Exception e) { }

        JLabel lblPerformingOcrPlease = new JLabel("Performing OCR... Please wait.");
        lblPerformingOcrPlease.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblPerformingOcrPlease.setHorizontalAlignment(SwingConstants.LEFT);
        contentPane.add(lblPerformingOcrPlease, BorderLayout.NORTH);
        this.setVisible(true);
    }

}
