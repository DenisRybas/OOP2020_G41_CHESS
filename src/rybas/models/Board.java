package rybas.models;


import rybas.factories.figureFactory.FigureFactory;
import rybas.figures.*;

import java.awt.*;

public class Board {
    private Cell[][] field;

    public Board() {
        field = new Cell[8][8];
        boolean isWhite = true;
        FigureFactory f = new FigureFactory();
        for (int i = 0; i < field.length; i++) {
            if (i > 1) isWhite = false;
            Cell.CellColor c = i % 2 == 0 ? Cell.CellColor.LIGHT : Cell.CellColor.DARK;
            for (int j = 0; j < field[i].length; j++) {
                c = c == Cell.CellColor.DARK ? Cell.CellColor.LIGHT : Cell.CellColor.DARK;
                if (i == 0 || i == field.length - 1) {
                    if (j == 1 || j == field[i].length - 1) field[i][j] = new Cell(
                            f.createNewFigure(Figure.Type.PAWN, isWhite ? Figure.Color.WHITE : Figure.Color.BLACK), c);
                    if (j == 2 || j == field[i].length - 2) field[i][j] = new Cell(
                            f.createNewFigure(Figure.Type.KNIGHT, isWhite ? Figure.Color.WHITE : Figure.Color.BLACK), c);
                    if (j == 3 || j == field[i].length - 3) field[i][j] = new Cell(
                            f.createNewFigure(Figure.Type.BISHOP, isWhite ? Figure.Color.WHITE : Figure.Color.BLACK), c);
                    if (j == 4) field[i][j] = new Cell(
                            f.createNewFigure(Figure.Type.KING, isWhite ? Figure.Color.WHITE : Figure.Color.BLACK), c);
                    if (j == 5) field[i][j] = new Cell(
                            f.createNewFigure(Figure.Type.QUEEN, isWhite ? Figure.Color.WHITE : Figure.Color.BLACK), c);
                } else if (i == 1 || i == field.length - 2) {
                    field[i][j] = new Cell(
                            f.createNewFigure(Figure.Type.PAWN, isWhite ? Figure.Color.WHITE : Figure.Color.BLACK), c);
                } else {
                    field[i][j] = new Cell(null, c);
                }
            }
        }
    }

    public boolean isInBoard(Point p) {
        if (p == null) return false;
        return !(p.getX() < 0 ||
                p.getX() >= 8 ||
                p.getY() < 0 ||
                p.getY() >= 8
        );
    }

    public Cell getCell(Point position) {
        return field[position.x][position.y];
    }
    public Point getPosition(Cell cell) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == cell) return new Point(i, j);
            }
        }
        return null;
    }

    public Cell[][] getField() {
        return field;
    }
}
