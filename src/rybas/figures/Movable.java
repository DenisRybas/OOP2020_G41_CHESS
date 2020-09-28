package rybas.figures;

import rybas.models.Board;
import rybas.models.Cell;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public interface Movable {
    enum TypeOfMove {
        BEAT,
        MOVE
    }
//    LinkedHashMap<TypeOfMove, LinkedHashSet<Cell>> getPossibleMoves(Board b, Cell c);
//    LinkedHashMap<TypeOfMove, LinkedHashSet<Cell>> getPossibleMoves(Board b);
    void move(Cell c);
}
