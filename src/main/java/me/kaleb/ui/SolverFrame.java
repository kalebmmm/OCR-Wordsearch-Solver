package me.kaleb.ui;

import me.kaleb.search.Solver;

import javax.swing.*;
import java.awt.*;

public class SolverFrame extends JFrame {

    private Solver solver;
    private WordsearchPanel wordsearchPanel;

    public SolverFrame(final Solver solver) {
        super("Wordsearch Solver");
        this.solver = solver;

        Dimension size = new Dimension((solver.getMatrix().getHeight() * 35) + 10, solver.getMatrix().getWidth() * 35);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setMinimumSize(new Dimension(size));
        setBounds(200, 200, size.height, size.width);
        try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); } catch(Exception e) { }

        this.wordsearchPanel = new WordsearchPanel(this, size);

        JPanel search = new JPanel();
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(size.width / 2, 20));

        JButton button = new JButton("Search");
        button.addActionListener(e -> wordsearchPanel.refresh(solver.findWord(textField.getText())));

        search.add(textField);
        search.add(button);

        getContentPane().add(search, BorderLayout.SOUTH);
        getContentPane().add(wordsearchPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    public Solver getSolver() {
        return solver;
    }
}
