package rybas.models;

import rybas.figures.Figure;

import java.awt.*;

public class Cell {
    private Figure f;
    private CellColor c;

    enum CellColor {
        LIGHT,
        DARK
    }

    public Cell(Figure f, CellColor c) {
        this.f = f;
        this.c = c;
    }

    public Cell() {
        this.f = null;
    }

    public void setFigure(Figure f) {
        this.f = f;
    }

    public Figure getFigure() {
        return f;
    }
}
