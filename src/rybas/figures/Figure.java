package rybas.figures;

public interface Figure {
    enum Type {
        KING,
        QUEEN,
        ROOK,
        BISHOP,
        KNIGHT,
        PAWN
    }
    Figure.Type getType();
    void setType(Figure.Type type);

    void beat();
}
