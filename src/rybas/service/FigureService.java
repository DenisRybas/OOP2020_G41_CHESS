package rybas.service;

import rybas.models.Cell;

import java.util.LinkedHashMap;
import java.util.Set;

public interface FigureService {
    enum TypeOfMove {
        BEAT,
        MOVE
    }
    LinkedHashMap<TypeOfMove, Set<Cell>> getPossibleMoves();
}
