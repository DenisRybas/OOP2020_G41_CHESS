package rybas.models;

import rybas.figures.Figure;

import java.awt.*;

public class Cell {
    private Figure f;
    private CellColor c;
    private Point coordinate;

    enum CellColor {
        LIGHT,
        DARK
    }

    public Cell(Figure f, CellColor c, Point coordinate) {
        this.f = f;
        this.c = c;
        this.coordinate = coordinate;
    }

    public Point getCoordinate() {
        return coordinate;
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
