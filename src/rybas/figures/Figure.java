package rybas.figures;

import rybas.models.Cell;

public interface Figure {
    enum Type {
        KING,
        QUEEN,
        ROOK,
        BISHOP,
        KNIGHT,
        PAWN
    }

    enum Color {
        BLACK,
        WHITE
    }

    Color getColor();
    Figure.Type getType();
    Cell getCurrentCell();
    void setCurrentCell(Cell c);
    void move(Cell c);
}
