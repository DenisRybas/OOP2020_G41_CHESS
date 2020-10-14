package rybas.figures;

import rybas.models.Cell;
import rybas.figures.FigureColor;
import rybas.figures.FigureType;

public class Figure {
    FigureType type;
    FigureColor color;

    public Figure(FigureType type, FigureColor color) {
        this.type = type;
        this.color = color;
    }

    public FigureColor getColor() {
        return color;
    }

    public FigureType getType() {
        return type;
    }

    public Cell getCurrentCell() {
        return null;
    }

    public void setCurrentCell(Cell c) {

    }
}
