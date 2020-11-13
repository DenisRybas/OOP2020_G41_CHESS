package rybas.services;

import rybas.figures.FigureColor;
import rybas.models.Board;
import rybas.models.Cell;

import java.awt.*;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/*  coordinates of board
 *   are like in array (0-7 x 0-7)
 *   A1 == (0,0)
 *
 */

public class ChessService {

    public LinkedHashMap<TypeOfMove, LinkedHashSet<Cell>> getPossibleMoves(Board board, Cell cell) {
        return switch (cell.getFigure().getType()) {
            case ROOK -> getRookPossibleMoves(board, cell);
            case PAWN -> getPawnPossibleMoves(board, cell);
            case KING -> getKingPossibleMoves(board, cell);
            case BISHOP -> getBishopPossibleMoves(board, cell);
            case KNIGHT -> getKnightPossibleMoves(board, cell);
            case QUEEN -> getQueenPossibleMoves(board, cell);
        };
    }

    private LinkedHashMap<TypeOfMove, LinkedHashSet<Cell>> getPawnPossibleMoves(Board board, Cell cell) {
        LinkedHashMap<TypeOfMove, LinkedHashSet<Cell>> pm = new LinkedHashMap<>();
        LinkedHashSet<Cell> beatMoves = new LinkedHashSet<>();
        LinkedHashSet<Cell> moves = new LinkedHashSet<>();
        Cell[][] field = board.getField();
        int posX = cell.getCoordinate().x;
        int posY = cell.getCoordinate().y;

        //TODO: пешка дошла до конца

        if (cell.getFigure().getColor() == FigureColor.BLACK) {
            if (posY == 6) {
                for (int i = posY - 1; i > posY - 3; i--) {
                    if (field[i][posX].getFigure() == null) moves.add(field[i][posX]);
                }
            } else {
                if (isOnBoard(new Point(posX, posY - 1)) && field[posY - 1][posX].getFigure() == null)
                    moves.add(field[posY - 1][posX]);
            }

            if (isOnBoard(new Point(posX - 1, posY - 1)) &&
                    field[posY - 1][posX - 1].getFigure() != null &&
                    field[posY - 1][posX - 1].getFigure().getColor() == FigureColor.WHITE)
                beatMoves.add(field[posX - 1][posY - 1]);
            if (isOnBoard(new Point(posX + 1, posY - 1)) &&
                    field[posY - 1][posX + 1].getFigure() != null &&
                    field[posY - 1][posX + 1].getFigure().getColor() == FigureColor.WHITE)
                beatMoves.add(field[posY - 1][posX + 1]);
        } else {
            if (posY == 1) {
                for (int i = posY + 1; i < posY + 3; i++) {
                    if (field[i][posX].getFigure() == null) moves.add(field[i][posX]);
                }
            } else {
                if (isOnBoard(new Point(posX, posY + 1)) &&
                        field[posY + 1][posX].getFigure() == null)
                    moves.add(field[posY + 1][posX]);
            }

            if (isOnBoard(new Point(posX - 1, posY + 1)) &&
                    field[posY + 1][posX - 1].getFigure() != null &&
                    field[posY + 1][posX - 1].getFigure().getColor() == FigureColor.BLACK)
                beatMoves.add(field[posY + 1][posX - 1]);
            if (isOnBoard(new Point(posX + 1, posY + 1)) &&
                    field[posY + 1][posX + 1].getFigure() != null &&
                    field[posY + 1][posX + 1].getFigure().getColor() == FigureColor.BLACK)
                beatMoves.add(field[posY + 1][posX + 1]);
        }
        pm.put(TypeOfMove.MOVE, moves);
        pm.put(TypeOfMove.BEAT, beatMoves);
        return pm;
    }

    private LinkedHashMap<TypeOfMove, LinkedHashSet<Cell>> getKingPossibleMoves(Board board, Cell cell) {
        LinkedHashMap<TypeOfMove, LinkedHashSet<Cell>> pm = new LinkedHashMap<>();
        LinkedHashSet<Cell> beatMoves = new LinkedHashSet<>();
        LinkedHashSet<Cell> moves = new LinkedHashSet<>();
        Cell[][] field = board.getField();
        int posX = cell.getCoordinate().x;
        int posY = cell.getCoordinate().y;

        for (int i = posY - 1; i < posY + 2; i++) {
            for (int j = posX - 1; j < posX + 2; j++) {
                if (isOnBoard(new Point(j, i))) {
                    if (field[i][j].getFigure() != null) {
                        if (field[i][j].getFigure().getColor() != cell.getFigure().getColor()) {
                            beatMoves.add(field[i][j]);
                        }
                    } else moves.add(field[i][j]);
                }
            }
        }
        pm.put(TypeOfMove.MOVE, moves);
        pm.put(TypeOfMove.BEAT, beatMoves);
        return pm;
    }

    private LinkedHashMap<TypeOfMove, LinkedHashSet<Cell>> getKnightPossibleMoves(Board board, Cell cell) {
        LinkedHashMap<TypeOfMove, LinkedHashSet<Cell>> pm = new LinkedHashMap<>();
        LinkedHashSet<Cell> beatMoves = new LinkedHashSet<>();
        LinkedHashSet<Cell> moves = new LinkedHashSet<>();
        Cell[][] field = board.getField();
        int posX = cell.getCoordinate().x;
        int posY = cell.getCoordinate().y;

        for (int i = -2; i < 3; i++) {
            for (int j = -2; j < 3; j++) {
                if (i == 0) break;
                if (i % 2 == 0) {
                    if (j % 2 == 1) {
                        if (isOnBoard(new Point(posX + j, posY + i)))
                            if (field[posY + i][posX + j].getFigure() == null) moves.add(field[posY + i][posX + j]);
                            else {
                                if (field[posY + i][posX + j].getFigure().getColor() != cell.getFigure().getColor())
                                    beatMoves.add(field[posY + i][posX + j]);
                            }
                    }
                } else {
                    if (j == -2 || j == 2) {
                        if (isOnBoard(new Point(posX + j, posY + i)))
                            if (field[posY + i][posX + j].getFigure() == null) moves.add(field[posY + i][posX + j]);
                            else {
                                if (field[posY + i][posX + j].getFigure().getColor() != cell.getFigure().getColor())
                                    beatMoves.add(field[posY + i][posX + j]);
                            }
                    }
                }
            }
        }
        pm.put(TypeOfMove.MOVE, moves);
        pm.put(TypeOfMove.BEAT, beatMoves);
        return pm;
    }

    private LinkedHashMap<TypeOfMove, LinkedHashSet<Cell>> getRookPossibleMoves(Board board, Cell cell) {
        LinkedHashMap<TypeOfMove, LinkedHashSet<Cell>> pm = new LinkedHashMap<>();
        LinkedHashSet<Cell> beatMoves = new LinkedHashSet<>();
        LinkedHashSet<Cell> moves = new LinkedHashSet<>();
        Cell[][] field = board.getField();
        int posX = cell.getCoordinate().x;
        int posY = cell.getCoordinate().y;

        //TODO: рокировка
        if (isOnBoard(new Point(posX, posY - 1)))
            for (int i = posY - 1; i >= 0; i--) {
                if (field[i][posX].getFigure() == null) {
                    moves.add(field[i][posX]);
                } else {
                    if (field[i][posX].getFigure().getColor() != cell.getFigure().getColor())
                        beatMoves.add(field[i][posX]);
                    break;
                }
            }

        if (isOnBoard(new Point(posX, posY + 1)))
            for (int i = posY + 1; i < field.length; i++) {
                if (field[i][posX].getFigure() == null) {
                    moves.add(field[i][posX]);
                } else {
                    if (field[i][posX].getFigure().getColor() != cell.getFigure().getColor())
                        beatMoves.add(field[i][posX]);
                    break;
                }
            }

        if (isOnBoard(new Point(posX - 1, posY)))
            for (int i = posX - 1; i >= 0; i--) {
                if (field[posY][i].getFigure() == null) {
                    moves.add(field[posY][i]);
                } else {
                    if (field[posY][i].getFigure().getColor() != cell.getFigure().getColor())
                        beatMoves.add(field[posY][i]);
                    break;
                }
            }

        if (isOnBoard(new Point(posX + 1, posY)))
            for (int i = posX + 1; i < field.length; i++) {
                if (field[posY][i].getFigure() == null) {
                    moves.add(field[posY][i]);
                } else {
                    if (field[posY][i].getFigure().getColor() != cell.getFigure().getColor())
                        beatMoves.add(field[posY][i]);
                    break;
                }
            }

        pm.put(TypeOfMove.MOVE, moves);
        pm.put(TypeOfMove.BEAT, beatMoves);
        return pm;
    }

    private LinkedHashMap<TypeOfMove, LinkedHashSet<Cell>> getBishopPossibleMoves(Board board, Cell cell) {
        LinkedHashMap<TypeOfMove, LinkedHashSet<Cell>> pm = new LinkedHashMap<>();
        LinkedHashSet<Cell> beatMoves = new LinkedHashSet<>();
        LinkedHashSet<Cell> moves = new LinkedHashSet<>();
        Cell[][] field = board.getField();
        int posX = cell.getCoordinate().x;
        int posY = cell.getCoordinate().y;


        int i = posY + 1, j = posX + 1;
        while (isOnBoard(new Point(j, i))) {
            if (field[i][j].getFigure() == null) moves.add(field[i][j]);
            else {
                if (field[i][j].getFigure() != null &&
                        field[i][j].getFigure().getColor() != cell.getFigure().getColor())
                    beatMoves.add(field[i][j]);
                break;
            }
            i++;
            j++;
        }

        i = posY - 1;
        j = posX - 1;
        while (isOnBoard(new Point(j, i))) {
            if (field[i][j].getFigure() == null) moves.add(field[i][j]);
            else {
                if (field[i][j].getFigure() != null &&
                        field[i][j].getFigure().getColor() != cell.getFigure().getColor())
                    beatMoves.add(field[i][j]);
                break;
            }
            i--;
            j--;
        }

        i = posY - 1;
        j = posX + 1;
        while (isOnBoard(new Point(j, i))) {
            if (field[i][j].getFigure() == null) moves.add(field[i][j]);
            else {
                if (field[i][j].getFigure() != null &&
                        field[i][j].getFigure().getColor() != cell.getFigure().getColor())
                    beatMoves.add(field[i][j]);
                break;
            }
            i--;
            j++;
        }

        i = posY + 1;
        j = posX - 1;
        while (isOnBoard(new Point(j, i))) {
            if (isOnBoard(new Point(j, i))) {
                if (field[i][j].getFigure() == null) moves.add(field[i][j]);
                else {
                    if (field[i][j].getFigure() != null &&
                            field[i][j].getFigure().getColor() != cell.getFigure().getColor())
                        beatMoves.add(field[i][j]);
                    break;
                }
            }
            i++;
            j--;
        }

        pm.put(TypeOfMove.MOVE, moves);
        pm.put(TypeOfMove.BEAT, beatMoves);
        return pm;
    }

    private LinkedHashMap<TypeOfMove, LinkedHashSet<Cell>> getQueenPossibleMoves(Board board, Cell cell) {
        return new LinkedHashMap<>() {{
            putAll(getBishopPossibleMoves(board, cell));
            putAll(getRookPossibleMoves(board, cell));
        }};
    }

    private boolean isOnBoard(Point p) {
        if (p == null) return false;
        return !(p.getX() < 0 ||
                p.getX() >= 8 ||
                p.getY() < 0 ||
                p.getY() >= 8
        );
    }
}
