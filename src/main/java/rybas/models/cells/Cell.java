package rybas.models.cells;

import rybas.models.figures.Figure;

import java.awt.*;

public class Cell {
    private CellColor color;
    private Point coordinate;
    private Figure figure;

    public Cell(CellColor color, Point coordinate, Figure figure) {
        this.figure = figure;
        this.color = color;
        this.coordinate = coordinate;
    }

    public Point getCoordinate() {
        return coordinate;
    }

    public CellColor getColor() {
        return color;
    }

    public Cell() {
        this.figure = null;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }

    public Figure getFigure() {
        return figure;
    }

    @Override
    public String toString() {
        return coordinate.toString();
    }
}
