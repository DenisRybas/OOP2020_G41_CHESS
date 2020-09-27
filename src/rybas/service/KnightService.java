package rybas.service;

import rybas.models.Cell;
import rybas.service.FigureService;

import java.util.LinkedHashMap;
import java.util.Set;

public class KnightService implements FigureService {
    @Override
    public LinkedHashMap<TypeOfMove, Set<Cell>> getPossibleMoves() {
        return null;
    }
}
