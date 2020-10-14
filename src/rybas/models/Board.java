package rybas.models;


import rybas.figures.*;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Board {
    private Cell[][] field;
    private Cell downLeft;
    private Cell upRight;


    public Board() {
        field = new Cell[8][8];

        boolean isWhite = true;
        for (int i = 0; i < 8; i++) {
            if (i > 1) isWhite = false;
            CellColor c = i % 2 == 0 ? CellColor.LIGHT : CellColor.DARK;
            for (int j = 0; j < 8; j++) {
                c = c == CellColor.DARK ? CellColor.LIGHT : CellColor.DARK;
                if (i == 0 || i == 7) {
                    if (j == 0 || j == 7)
                        field[i][j] = (new Cell(c, new Point(j, i), new Figure(FigureType.ROOK, isWhite ? FigureColor.WHITE : FigureColor.BLACK)));
                    if (j == 1 || j == 6) field[i][j] = new Cell(c, new Point(j, i),
                            new Figure(FigureType.KNIGHT, isWhite ? FigureColor.WHITE : FigureColor.BLACK));
                    if (j == 2 || j == 5) field[i][j] = new Cell(c, new Point(j, i),
                            new Figure(FigureType.BISHOP, isWhite ? FigureColor.WHITE : FigureColor.BLACK));
                    if (j == 3) field[i][j] = new Cell(c, new Point(j, i),
                            new Figure(FigureType.KING, isWhite ? FigureColor.WHITE : FigureColor.BLACK));
                    if (j == 4) field[i][j] = new Cell(c, new Point(j, i),
                            new Figure(FigureType.QUEEN, isWhite ? FigureColor.WHITE : FigureColor.BLACK));
                } else if (i == 1 || i == 6) {
                    field[i][j] = new Cell(c, new Point(j, i),
                            new Figure(FigureType.PAWN, isWhite ? FigureColor.WHITE : FigureColor.BLACK));
                } else field[i][j] = new Cell(c, new Point(j, i), null);
            }
        }
    }

    public Cell getCell(Point position) {
        return field[position.x][position.y];
    }

    public Point getPosition(Cell cell) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == cell) return new Point(j, i);
            }
        }
        return null;
    }

    public Cell[][] getField() {
        return field;
    }
}
