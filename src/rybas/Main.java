package rybas;

import com.google.gson.JsonElement;
import rybas.figures.Figure;
import rybas.figures.FigureColor;
import rybas.figures.FigureType;
import rybas.tests.FigureTests;
import java.time.Period;

public class Main {
    public static void main(String[] args) {
//        MainWindow mw = new MainWindow();
//        mw.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        mw.setSize(800, 600);
//        mw.setVisible(true);
        FigureTests.testAll();
    }
}
