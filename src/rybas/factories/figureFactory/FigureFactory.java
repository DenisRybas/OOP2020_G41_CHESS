package rybas.factories.figureFactory;

import rybas.figures.*;
import rybas.models.Cell;

public class FigureFactory {
    public Figure createNewFigure(Figure.Type t, Figure.Color c, Cell cell) {
        switch (t) {
            case KING -> {
                return new King(c, cell);
            }
            case QUEEN -> {
                return new Queen(c, cell);
            }
            case ROOK -> {
                return new Rook(c, cell);
            }
            case BISHOP -> {
                return new Bishop(c, cell);
            }
            case KNIGHT -> {
                return new Knight(c, cell);
            }
            case PAWN -> {
                return new Pawn(c, cell);
            }
        }
        return null;
    }
}
