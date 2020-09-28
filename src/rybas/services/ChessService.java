package rybas.services;

import rybas.models.Board;
import rybas.models.Cell;

import java.util.LinkedHashMap;
import java.util.Set;

public class ChessService {
    enum TypeOfMove {
        BEAT,
        MOVE
    }

    public static LinkedHashMap<TypeOfMove, Set<Cell>> getBishopPossibleMoves(Board b, Cell c) {
        return null;
    }

    public static LinkedHashMap<TypeOfMove, Set<Cell>> getKingPossibleMoves(Board b, Cell c) {
        return null;
    }

    public static LinkedHashMap<TypeOfMove, Set<Cell>> getKnightPossibleMoves(Board b, Cell c) {
        return null;
    }

    public static LinkedHashMap<TypeOfMove, Set<Cell>> getPawnPossibleMoves(Board b, Cell c) {
        return null;
    }

    public static LinkedHashMap<TypeOfMove, Set<Cell>> getRookPossibleMoves(Board b, Cell c) {
        return null;
    }

    public static LinkedHashMap<TypeOfMove, Set<Cell>> getQueenPossibleMoves(Board b, Cell c) {
        return null;
    }
}
