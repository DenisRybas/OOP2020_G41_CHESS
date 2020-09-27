package rybas.factories.figureFactory;

import rybas.figures.*;

public class FigureFactory {
    public Figure createNewFigure(Figure.Type t, Figure.Color c) {
        switch (t) {
            case KING -> {
                return new King(c);
            }
            case QUEEN -> {
                return new Queen(c);
            }
            case ROOK -> {
                return new Rook(c);
            }
            case BISHOP -> {
                return new Bishop(c);
            }
            case KNIGHT -> {
                return new Knight(c);
            }
            case PAWN -> {
                return new Pawn(c);
            }
        }
        return null;
    }
}
