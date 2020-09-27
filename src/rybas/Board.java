package rybas;


import rybas.factories.figureFactory.FigureFactory;
import rybas.figures.*;

public class Board {
    private Cell[][] field;

    public Board() {
        field = new Cell[8][8];
        boolean isWhite = true;
        FigureFactory f = new FigureFactory();
        for (int i = 0; i < field.length; i++) {
            if (i > 1) isWhite = false;
            for (int j = 0; j < field[i].length; j++) {
                if (i == 0 || i == field.length - 1) {
                    if (j == 1 || j == field[i].length - 1) field[i][j] = new Cell(
                            f.createNewFigure(Figure.Type.PAWN, isWhite ? Figure.Color.WHITE : Figure.Color.BLACK));
                    if (j == 2 || j == field[i].length - 2) field[i][j] = new Cell(
                            f.createNewFigure(Figure.Type.KNIGHT, isWhite ? Figure.Color.WHITE : Figure.Color.BLACK));
                    if (j == 3 || j == field[i].length - 3) field[i][j] = new Cell(
                            f.createNewFigure(Figure.Type.BISHOP, isWhite ? Figure.Color.WHITE : Figure.Color.BLACK));
                    if (j == 4) field[i][j] = new Cell(
                            f.createNewFigure(Figure.Type.KING, isWhite ? Figure.Color.WHITE : Figure.Color.BLACK));
                    if (j == 5) field[i][j] = new Cell(
                            f.createNewFigure(Figure.Type.QUEEN, isWhite ? Figure.Color.WHITE : Figure.Color.BLACK));
                } else if (i == 1 || i == field.length - 2) {
                    field[i][j] = new Cell(
                            f.createNewFigure(Figure.Type.PAWN, isWhite ? Figure.Color.WHITE : Figure.Color.BLACK)));
                } else {
                    field[i][j] = new Cell(null);
                }
            }
        }
    }

    public static boolean isInField(Position position) {
        if (position == null) return false;
        return !(position.getFirst() < 0 ||
                position.getFirst() >= 8 ||
                position.getSecond() < 0 ||
                position.getSecond() >= 8
        );
    }

    private Cell[][] getField() {
        return field;
    }
}
