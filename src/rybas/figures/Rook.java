package rybas.figures;

import rybas.models.Cell;

public class Rook implements Figure, Movable {
    private Cell currentCell;
    private Figure.Type type;
    private Figure.Color color;

    public Rook(Color color) {
        this.color = color;
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
