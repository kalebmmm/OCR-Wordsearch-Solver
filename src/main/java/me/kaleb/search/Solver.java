package me.kaleb.search;

import java.util.ArrayList;
import java.util.List;

public class Solver {

    private Matrix matrix;

    public Solver(Matrix matrix) {
        this.matrix = matrix;
    }

    public List<int[]> findWord(String word) {
        List<int[]> locations = new ArrayList<>();
        word = word.toUpperCase();
        char firstLetter = word.charAt(0);

        for (int y = 0; y < matrix.getHeight(); y++) {
            for (int x = 0; x < matrix.getWidth(); x++) {
                if (firstLetter == matrix.getCharAt(x, y)) {
                    locations.addAll(searchUp(x, y, word));
                    locations.addAll(searchDown(x, y, word));
                    locations.addAll(searchLeft(x, y, word));
                    locations.addAll(searchRight(x, y, word));
                    locations.addAll(searchDownRight(x, y, word));
                    locations.addAll(searchUpLeft(x, y, word));
                    locations.addAll(searchUpRight(x, y, word));
                    locations.addAll(searchDownLeft(x, y, word));
                    locations.addAll(searchDownRight(x, y, word));
                }
            }
        }

        return locations;
    }

    public List<int[]> searchUp(int startX, int startY, String word) {
        List<int[]> locations = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            if (matrix.isValidLocation(startX, startY) && matrix.getCharAt(startX, startY) == word.charAt(i)) {
                locations.add(new int[] {startX, startY});
            } else {
                return new ArrayList<>();
            }

            startY--;
        }

        return locations;
    }

    public List<int[]> searchDown(int startX, int startY, String word) {
        List<int[]> locations = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            if (matrix.isValidLocation(startX, startY) && matrix.getCharAt(startX, startY) == word.charAt(i)) {
                locations.add(new int[] {startX, startY});
            } else {
                return new ArrayList<>();
            }

            startY++;
        }

        return locations;
    }

    public List<int[]> searchLeft(int startX, int startY, String word) {
        List<int[]> locations = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            if (matrix.isValidLocation(startX, startY) && matrix.getCharAt(startX, startY) == word.charAt(i)) {
                locations.add(new int[] {startX, startY});
            } else {
                return new ArrayList<>();
            }

            startX--;
        }

        return locations;
    }

    public List<int[]> searchRight(int startX, int startY, String word) {
        List<int[]> locations = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            if (matrix.isValidLocation(startX, startY) && matrix.getCharAt(startX, startY) == word.charAt(i)) {
                locations.add(new int[] {startX, startY});
            } else {
                return new ArrayList<>();
            }

            startX++;
        }

        return locations;
    }

    public List<int[]> searchUpLeft(int startX, int startY, String word) {
        List<int[]> locations = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            if (matrix.isValidLocation(startX, startY) && matrix.getCharAt(startX, startY) == word.charAt(i)) {
                locations.add(new int[] {startX, startY});
            } else {
                return new ArrayList<>();
            }

            startY--;
            startX--;
        }

        return locations;
    }

    public List<int[]> searchUpRight(int startX, int startY, String word) {
        List<int[]> locations = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            if (matrix.isValidLocation(startX, startY) && matrix.getCharAt(startX, startY) == word.charAt(i)) {
                locations.add(new int[] {startX, startY});
            } else {
                return new ArrayList<>();
            }

            startY--;
            startX++;
        }

        return locations;
    }

    public List<int[]> searchDownLeft(int startX, int startY, String word) {
        List<int[]> locations = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            if (matrix.isValidLocation(startX, startY) && matrix.getCharAt(startX, startY) == word.charAt(i)) {
                locations.add(new int[] {startX, startY});
            } else {
                return new ArrayList<>();
            }

            startY++;
            startX--;
        }

        return locations;
    }

    public List<int[]> searchDownRight(int startX, int startY, String word) {
        List<int[]> locations = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            if (matrix.isValidLocation(startX, startY) && matrix.getCharAt(startX, startY) == word.charAt(i)) {
                locations.add(new int[] {startX, startY});
            } else {
                return new ArrayList<>();
            }

            startY++;
            startX++;
        }

        return locations;
    }

    public Matrix getMatrix() {
        return matrix;
    }
}
