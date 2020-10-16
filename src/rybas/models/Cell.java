package rybas.models;

import rybas.figures.Figure;

import java.awt.*;

public class Cell {
    private CellColor c;
    private Point coordinate;
    private Figure f;

    public Cell(CellColor c, Point coordinate, Figure f) {
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

    @Override
    public String toString() {
        return coordinate.toString();
    }
}
