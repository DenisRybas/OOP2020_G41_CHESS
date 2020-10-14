package rybas.figures;

import rybas.models.Cell;
import rybas.figures.FigureColor;

public class Figure {
    FigureType type;
    FigureColor color;

    public Figure(FigureType type, FigureColor color) {
        this.type = type;
        this.color = color;
    }

    public FigureColor getColor() {
        return null;
    }

    public Figure getType() {
        return null;
    }

    public Cell getCurrentCell() {
        return null;
    }

    public void setCurrentCell(Cell c) {

    }
}
