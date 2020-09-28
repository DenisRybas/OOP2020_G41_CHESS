package rybas.services;

import rybas.figures.Figure;
import rybas.models.Board;
import rybas.models.Cell;

import java.awt.*;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/*  coordinates of board
 *   are like in array (0-7 x 0-7)
 *   A1 == (0,0)
 *
 */

public class ChessService {
    enum TypeOfMove {
        BEAT,
        MOVE
    }

    public static LinkedHashMap<TypeOfMove, LinkedHashSet<Cell>> getBishopPossibleMoves(Board board, Cell cell) {
        return null;
    }

    public static LinkedHashMap<TypeOfMove, LinkedHashSet<Cell>> getKingPossibleMoves(Board board, Cell cell) {
        return null;
    }

    public static LinkedHashMap<TypeOfMove, LinkedHashSet<Cell>> getKnightPossibleMoves(Board board, Cell cell) {
        return null;
    }

    public static LinkedHashMap<TypeOfMove, LinkedHashSet<Cell>> getPawnPossibleMoves(Board board, Cell cell) {
        LinkedHashMap<TypeOfMove, LinkedHashSet<Cell>> pm = new LinkedHashMap<>();
        LinkedHashSet<Cell> beatMoves = new LinkedHashSet<>();
        LinkedHashSet<Cell> moves = new LinkedHashSet<>();
        Cell[][] field = board.getField();
        int posX = cell.getCoordinate().x;
        int posY = cell.getCoordinate().y;

        if (cell.getFigure().getColor() == Figure.Color.WHITE) {
            if (posY == 6) {
                for (int i = posY - 1; i > posY - 3; i--) {
                    if (field[posX][i].getFigure() == null) moves.add(field[posX][i]);
                }
            } else {
                if (field[posX][posY - 1].getFigure() == null) moves.add(field[posX][posY - 1]);
            }

            if (field[posX - 1][posY - 1].getFigure() != null) beatMoves.add(field[posX - 1][posY - 1]);
            if (field[posX + 1][posY - 1].getFigure() != null) beatMoves.add(field[posX + 1][posY - 1]);
        } else {
            if (posY == 1) {
                for (int i = posY + 1; i < posY + 3; i++) {
                    if (field[posX][i].getFigure() == null) moves.add(field[posX][i]);
                }
            } else {
                if (field[posX][posY + 1].getFigure() == null) moves.add(field[posX][posY + 1]);
            }

            if (field[posX - 1][posY + 1].getFigure() != null) beatMoves.add(field[posX - 1][posY + 1]);
            if (field[posX + 1][posY + 1].getFigure() != null) beatMoves.add(field[posX + 1][posY + 1]);
        }
        pm.put(TypeOfMove.MOVE, moves);
        pm.put(TypeOfMove.BEAT, beatMoves);
        return pm;
    }

    public static LinkedHashMap<TypeOfMove, LinkedHashSet<Cell>> getRookPossibleMoves(Board board, Cell cell) {
        return null;
    }

    public static LinkedHashMap<TypeOfMove, LinkedHashSet<Cell>> getQueenPossibleMoves(Board board, Cell cell) {
        return null;
    }
}
