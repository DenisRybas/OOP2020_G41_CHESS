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
    default Figure.Type getType() {
        return null;
    }

    void beat();
}
