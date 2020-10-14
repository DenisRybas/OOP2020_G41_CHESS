package rybas.services;

import rybas.figures.Figure;
import rybas.models.Cell;

public abstract class FigureTypeActionService {

    public abstract Cell findMove(Cell cell, Figure f);
}
