package rybas.figures;

import rybas.models.Cell;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class Bishop implements Figure, Movable {
    private Cell currentCell;
    private final Figure.Type type;
    private final Figure.Color color;

    public Bishop(Color color) {
        this.color = color;
        type = Type.BISHOP;
    }

    @Override
    public Color getColor() {
        return null;
    }

    @Override
    public Type getType() {
        return null;
    }

    @Override
    public Cell getCurrentCell() {
        return null;
    }

    @Override
    public void setCurrentCell(Cell c) {

    }


    @Override
    public void move(Cell c) {

    }
}
