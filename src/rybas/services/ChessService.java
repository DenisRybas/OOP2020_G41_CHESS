//package rybas.services;
//
//import rybas.figures.Figure;
//import rybas.figures.FigureColor;
//import rybas.figures.FigureType;
//import rybas.models.Board;
//import rybas.models.Cell;
//
//import java.awt.*;
//import java.util.HashMap;
//import java.util.LinkedHashMap;
//import java.util.LinkedHashSet;
//import java.util.Map;
//
///*  coordinates of board
// *   are like in array (0-7 x 0-7)
// *   A1 == (0,0)
// *
// */
//
//public class ChessService {
//    public enum TypeOfMove {
//        BEAT,
//        MOVE
//    }
//
//    private Map<FigureType, FigureTypeActionService> figureTypeActionServiceMap = new HashMap<>();
//
//    public LinkedHashMap<TypeOfMove, LinkedHashSet<Cell>> getPossibleMoves(Board board, Cell cell) {
//        Figure f = cell.getFigure();
//        FigureTypeActionService svc = figureTypeActionServiceMap.get(f.getType());
//        svc.findMoves(cell, f);
//        return null;
//    }
//
//    public static LinkedHashMap<TypeOfMove, LinkedHashSet<Cell>> getKingPossibleMoves(Board board, Cell cell) {
//        LinkedHashMap<TypeOfMove, LinkedHashSet<Cell>> pm = new LinkedHashMap<>();
//        LinkedHashSet<Cell> beatMoves = new LinkedHashSet<>();
//        LinkedHashSet<Cell> moves = new LinkedHashSet<>();
//        Cell[][] field = board.getField();
//        int posX = cell.getCoordinate().x;
//        int posY = cell.getCoordinate().y;
//
//        for (int i = posY - 1; i < posY + 2; i++) {
//            for (int j = posX - 1; j < posX + 2; j++) {
//                if (isOnBoard(new Point(j, i))) {
//                    if (field[i][j].getFigure() != null) {
//                        if (field[i][j].getFigure().getColor() != cell.getFigure().getColor()) {
//                            beatMoves.add(field[i][j]);
//                        }
//                    }
//                    if (field[i][j] == null) moves.add(field[i][j]);
//                }
//            }
//        }
//        pm.put(TypeOfMove.MOVE, moves);
//        pm.put(TypeOfMove.BEAT, beatMoves);
//        return pm;
//    }
//
//    public static LinkedHashMap<TypeOfMove, LinkedHashSet<Cell>> getKnightPossibleMoves(Board board, Cell cell) {
//        LinkedHashMap<TypeOfMove, LinkedHashSet<Cell>> pm = new LinkedHashMap<>();
//        LinkedHashSet<Cell> beatMoves = new LinkedHashSet<>();
//        LinkedHashSet<Cell> moves = new LinkedHashSet<>();
//        Cell[][] field = board.getField();
//        int posX = cell.getCoordinate().x;
//        int posY = cell.getCoordinate().y;
//
//        for (int i = -2; i < 3; i++) {
//            for (int j = -2; j < 3; j++) {
//                if (i == 0) break;
//                if (i % 2 == 0) {
//                    if (j % 2 == 1) {
//                        if (isOnBoard(new Point(posX + j, posY + i)))
//                            if (field[posX + j][posY + i].getFigure() == null) moves.add(field[posX + j][posY + i]);
//                            else {
//                                if (field[posX + j][posY + i].getFigure().getColor() != cell.getFigure().getColor())
//                                    beatMoves.add(field[posX + j][posY + i]);
//                            }
//                    }
//                } else {
//                    if (j == -2 || j == 2) {
//                        if (isOnBoard(new Point(posX + j, posY + i)))
//                            if (field[posX + j][posY + i].getFigure() == null) moves.add(field[posX + j][posY + i]);
//                            else {
//                                if (field[posX + j][posY + i].getFigure().getColor() != cell.getFigure().getColor())
//                                    beatMoves.add(field[posX + j][posY + i]);
//                            }
//                    }
//                }
//            }
//        }
//        pm.put(TypeOfMove.MOVE, moves);
//        pm.put(TypeOfMove.BEAT, beatMoves);
//        return pm;
//    }
//
//    public static LinkedHashMap<TypeOfMove, LinkedHashSet<Cell>> getPawnPossibleMoves(Board board, Cell cell) {
//        LinkedHashMap<TypeOfMove, LinkedHashSet<Cell>> pm = new LinkedHashMap<>();
//        LinkedHashSet<Cell> beatMoves = new LinkedHashSet<>();
//        LinkedHashSet<Cell> moves = new LinkedHashSet<>();
//        Cell[][] field = board.getField();
//        int posX = cell.getCoordinate().x;
//        int posY = cell.getCoordinate().y;
//
//        //TODO: пешка дошла до конца
//
//        if (cell.getFigure().getColor() == FigureColor.WHITE) {
//            if (posY == 6) {
//                for (int i = posY - 1; i > posY - 3; i--) {
//                    if (field[posX][i].getFigure() == null) moves.add(field[posX][i]);
//                }
//            } else {
//                if (isOnBoard(new Point(posX, posY - 1)) && field[posX][posY - 1].getFigure() == null)
//                    moves.add(field[posX][posY - 1]);
//            }
//
//            if (isOnBoard(new Point(posX - 1, posY - 1)) &&
//                    field[posX - 1][posY - 1].getFigure() != null &&
//                    field[posX - 1][posY - 1].getFigure().getColor() == FigureColor.BLACK)
//                beatMoves.add(field[posX - 1][posY - 1]);
//            if (isOnBoard(new Point(posX + 1, posY - 1)) &&
//                    field[posX + 1][posY - 1].getFigure() != null &&
//                    field[posX + 1][posY - 1].getFigure().getColor() == FigureColor.BLACK)
//                beatMoves.add(field[posX + 1][posY - 1]);
//        } else {
//            if (posY == 1) {
//                for (int i = posY + 1; i < posY + 3; i++) {
//                    if (field[posX][i].getFigure() == null) moves.add(field[posX][i]);
//                }
//            } else {
//                if (isOnBoard(new Point(posX, posY + 1)) &&
//                        field[posX][posY + 1].getFigure() == null)
//                    moves.add(field[posX][posY + 1]);
//            }
//
//            if (isOnBoard(new Point(posX - 1, posY + 1)) &&
//                    field[posX - 1][posY + 1].getFigure() != null &&
//                    field[posX - 1][posY + 1].getFigure().getColor() == FigureColor.WHITE)
//                beatMoves.add(field[posX - 1][posY + 1]);
//            if (isOnBoard(new Point(posX + 1, posY + 1)) &&
//                    field[posX + 1][posY + 1].getFigure() != null &&
//                    field[posX + 1][posY + 1].getFigure().getColor() == FigureColor.WHITE)
//                beatMoves.add(field[posX + 1][posY + 1]);
//        }
//        pm.put(TypeOfMove.MOVE, moves);
//        pm.put(TypeOfMove.BEAT, beatMoves);
//        return pm;
//    }
//
//    public static LinkedHashMap<TypeOfMove, LinkedHashSet<Cell>> getRookPossibleMoves(Board board, Cell cell) {
//        LinkedHashMap<TypeOfMove, LinkedHashSet<Cell>> pm = new LinkedHashMap<>();
//        LinkedHashSet<Cell> beatMoves = new LinkedHashSet<>();
//        LinkedHashSet<Cell> moves = new LinkedHashSet<>();
//        Cell[][] field = board.getField();
//        int posX = cell.getCoordinate().x;
//        int posY = cell.getCoordinate().y;
//
//        //TODO: рокировка
//        for (int i = posY; i >= 0; i--) {
//            if (field[posX][i].getFigure() == null) {
//                moves.add(field[posX][i]);
//            } else {
//                if (field[posX][i].getFigure().getColor() != cell.getFigure().getColor())
//                    beatMoves.add(field[posX][i]);
//            }
//        }
//
//        for (int i = posY; i < field.length; i++) {
//            if (field[posX][i].getFigure() == null) {
//                moves.add(field[posX][i]);
//            } else {
//                if (field[posX][i].getFigure().getColor() != cell.getFigure().getColor())
//                    beatMoves.add(field[posX][i]);
//            }
//        }
//
//        for (int i = posX; i >= 0; i--) {
//            if (field[i][posY].getFigure() == null) {
//                moves.add(field[i][posY]);
//            } else {
//                if (field[i][posY].getFigure().getColor() != cell.getFigure().getColor())
//                    beatMoves.add(field[i][posY]);
//            }
//        }
//
//        for (int i = posX; i < field[i].length; i++) {
//            if (field[i][posY].getFigure() == null) {
//                moves.add(field[i][posY]);
//            } else {
//                if (field[i][posY].getFigure().getColor() != cell.getFigure().getColor())
//                    beatMoves.add(field[i][posY]);
//            }
//        }
//
//        pm.put(TypeOfMove.MOVE, moves);
//        pm.put(TypeOfMove.BEAT, beatMoves);
//        return pm;
//    }
//
//    public static LinkedHashMap<TypeOfMove, LinkedHashSet<Cell>> getQueenPossibleMoves(Board board, Cell cell) {
//        return new LinkedHashMap<>() {{
//            putAll(getBishopPossibleMoves(board, cell));
//            putAll(getRookPossibleMoves(board, cell));
//        }};
//    }
//
//    public static boolean isOnBoard(Point p) {
//        if (p == null) return false;
//        return !(p.getX() < 0 ||
//                p.getX() >= 8 ||
//                p.getY() < 0 ||
//                p.getY() >= 8
//        );
//    }
//}
