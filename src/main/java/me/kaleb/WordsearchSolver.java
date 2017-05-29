package me.kaleb;

import me.kaleb.search.Matrix;
import me.kaleb.search.Solver;
import me.kaleb.ui.ErrorWindow;
import me.kaleb.ui.LoadingWindow;
import me.kaleb.ui.SolverFrame;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.LoadLibs;

import java.io.File;

public class WordsearchSolver  {

    public static void main(String[] args) {
        if (args.length == 0) {
            new ErrorWindow("No image supplied!", "You must supply an image argument.");
            return;
        }

        File image = new File(args[0]);

        if (image.exists()) {
            new WordsearchSolver(image);
        } else {
            new ErrorWindow("Invalid image", "That file does not exist.");
        }
    }

    public WordsearchSolver(File image) {
        ITesseract tessInstance = new Tesseract();
        tessInstance.setTessVariable("tessedit_char_whitelist", "ABCDEFGHIJKLMNOPQRSTUVWXYZ");

        try {
            LoadingWindow load = new LoadingWindow();
            File tessDataFolder = LoadLibs.extractTessResources("tessdata");
            tessInstance.setDatapath(tessDataFolder.getAbsolutePath());
            Solver solver = new Solver(new Matrix(tessInstance.doOCR(image)));
            load.setVisible(false);
            new SolverFrame(solver);
        } catch (TesseractException e) {
            new ErrorWindow("Tesseract Error", e.getMessage());
            e.printStackTrace();
        }
    }

}
