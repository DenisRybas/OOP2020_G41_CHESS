package rybas;


import rybas.figures.Pawn;

public class Board {
    private Cell[][] field;

    public Board() {
        field = new Cell[8][8];
    }

    private void setDefaultField() {
        for (int i = 0; i < 8; i++) {
        }
    }

    private Cell[][] getField() {
        return field;
    }
}
