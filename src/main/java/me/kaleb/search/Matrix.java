package me.kaleb.search;

import java.util.ArrayList;
import java.util.List;

public class Matrix {

    private List<char[]> charMatrix;

    public Matrix(String ocr) {
        ocr = ocr.replaceAll(" ", "");
        this.charMatrix = getCharMatrix(ocr);
    }

    public int getHeight() {
        return charMatrix.size();
    }

    public int getWidth() {
        return charMatrix.get(0).length;
    }

    public char getCharAt(int x, int y) {
        return charMatrix.get(y)[x];
    }

    public boolean isValidLocation(int x, int y) {
        if (x < 0 || y  < 0)
            return false;

        if (y >= charMatrix.size() || x >= charMatrix.get(y).length)
            return false;
        else
            return true;
    }

    public boolean isValid() {
        if (charMatrix.isEmpty())
            return false;

        int length = charMatrix.get(0).length;
        for (char[] array : charMatrix) {
            if (length != array.length)
                return false;
        }

        return true;
    }

    public List<char[]> getCharMatrix() {
        return charMatrix;
    }

    public static List<char[]> getCharMatrix(String ocr) {
        List<char[]> charList = new ArrayList<>();

        for (String line : ocr.split("\n"))
            charList.add(line.toUpperCase().toCharArray());

        return charList;
    }

}
