package me.kaleb.ui;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;

public class WordsearchPanel extends JPanel {

    SolverFrame parent;
    HashMap<int[], JLabel> letterMap = new HashMap<>();

    public WordsearchPanel(SolverFrame parent, Dimension size) {
        this.parent = parent;
        setSize(size);
        setLayout(new GridLayout(parent.getSolver().getMatrix().getHeight(), parent.getSolver().getMatrix().getWidth()));
        fillLetterLabels();
    }

    public void fillLetterLabels() {
        int x = 0, y = 0;
        for (char[] charArray : parent.getSolver().getMatrix().getCharMatrix()) {
            for (char character : charArray) {
                JLabel letter = new JLabel(character + "", JLabel.CENTER);
                letter.setForeground(Color.BLACK);
                letter.setFont(letter.getFont().deriveFont(15f));
                add(letter);
                letterMap.put(new int[] {x,y}, letter);
                x++;
            }
            x = 0;
            y++;
        }
    }

    public void refresh(List<int[]> newLocations) {
        letterMap.values().forEach(letter -> letter.setForeground(Color.BLACK));

        for (int[] letters : letterMap.keySet()) {
            for (int[] newLoc : newLocations) {
                if (letters[0] == newLoc[0] && letters[1] == newLoc[1]) {
                    letterMap.get(letters).setForeground(Color.RED);
                }
            }
        }
    }

}
