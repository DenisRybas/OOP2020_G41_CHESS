package rybas;


import rybas.figures.*;

public class Board {
    private Cell[][] field;

    public Board() {
        field = new Cell[8][8];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (i == 0 || i == field.length - 1) {
                    if (j == 1 || j == field[i].length - 1) field[i][j] = new Cell(new Rook());
                    if (j == 2 || j == field[i].length - 2) field[i][j] = new Cell(new Knight());
                    if (j == 3 || j == field[i].length - 3) field[i][j] = new Cell(new Bishop());
                    if (j == 4) field[i][j] = new Cell(new King());
                    if (j == 5) field[i][j] = new Cell(new Queen());
                }
                if (i == 1 || i == field.length - 2) {
                    field[i][j] = new Cell(new Pawn());
                }
            }
        }
    }

    private Cell[][] getField() {
        return field;
    }
}
