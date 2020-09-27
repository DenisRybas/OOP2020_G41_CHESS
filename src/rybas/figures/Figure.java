package rybas.figures;

import java.awt.*;

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
    Figure.Type getType();
    void setType(Figure.Type type);
    Color getColor();
    void beat();
}
