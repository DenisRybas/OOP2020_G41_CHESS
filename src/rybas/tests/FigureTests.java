package rybas.tests;

import rybas.figures.Figure;
import rybas.figures.FigureColor;
import rybas.figures.FigureType;
import rybas.models.Board;
import rybas.services.ChessService;

import java.awt.*;

public class FigureTests {
    public static void rookMoveTest() {
        Board b = new Board();
        b.getCell(new Point(4, 4)).setFigure(new Figure(FigureType.ROOK, FigureColor.BLACK));
        System.out.println(ChessService.getPossibleMoves(b, b.getCell(new Point(4, 4))).toString());
    }

    public static void rookBeatTest() {
        Board b = new Board();
        b.getCell(new Point(4, 4)).setFigure(new Figure(FigureType.ROOK, FigureColor.BLACK));
        b.getCell(new Point(4, 5)).setFigure(new Figure(FigureType.ROOK, FigureColor.WHITE));
        b.getCell(new Point(5, 4)).setFigure(new Figure(FigureType.ROOK, FigureColor.WHITE));
        b.getCell(new Point(3, 4)).setFigure(new Figure(FigureType.ROOK, FigureColor.WHITE));
        b.getCell(new Point(4, 3)).setFigure(new Figure(FigureType.ROOK, FigureColor.WHITE));
        System.out.println(ChessService.getPossibleMoves(b, b.getCell(new Point(4, 4))).toString());
    }

    public static void pawnBeatTest() {
        Board b = new Board();
        b.getCell(new Point(4, 4)).setFigure(new Figure(FigureType.PAWN, FigureColor.BLACK));
        b.getCell(new Point(3, 3)).setFigure(new Figure(FigureType.ROOK, FigureColor.WHITE));
        b.getCell(new Point(4, 3)).setFigure(new Figure(FigureType.ROOK, FigureColor.WHITE));
        b.getCell(new Point(5, 3)).setFigure(new Figure(FigureType.ROOK, FigureColor.WHITE));
        System.out.println(ChessService.getPossibleMoves(b, b.getCell(new Point(4, 4))).toString());
    }

    public static void pawnMoveTest() {
        Board b = new Board();
        b.getCell(new Point(4, 1)).setFigure(new Figure(FigureType.PAWN, FigureColor.BLACK));
        System.out.println(ChessService.getPossibleMoves(b, b.getCell(new Point(4, 6))).toString());
    }

    public static void queenTest() {
        Board b = new Board();
        b.getCell(new Point(4, 4)).setFigure(new Figure(FigureType.ROOK, FigureColor.BLACK));
        b.getCell(new Point(4, 5)).setFigure(new Figure(FigureType.ROOK, FigureColor.WHITE));
        b.getCell(new Point(5, 5)).setFigure(new Figure(FigureType.ROOK, FigureColor.WHITE));
        System.out.println(ChessService.getPossibleMoves(b, b.getCell(new Point(4, 4))).toString());
    }

    public static void kingBeatTest() {
        Board b = new Board();
        b.getCell(new Point(4, 4)).setFigure(new Figure(FigureType.KING, FigureColor.BLACK));
        b.getCell(new Point(3, 4)).setFigure(new Figure(FigureType.ROOK, FigureColor.WHITE));
        b.getCell(new Point(5, 4)).setFigure(new Figure(FigureType.ROOK, FigureColor.WHITE));
        b.getCell(new Point(3, 5)).setFigure(new Figure(FigureType.ROOK, FigureColor.WHITE));
        b.getCell(new Point(4, 5)).setFigure(new Figure(FigureType.ROOK, FigureColor.WHITE));
        b.getCell(new Point(5, 5)).setFigure(new Figure(FigureType.ROOK, FigureColor.WHITE));
        b.getCell(new Point(3, 3)).setFigure(new Figure(FigureType.ROOK, FigureColor.WHITE));
        b.getCell(new Point(4, 3)).setFigure(new Figure(FigureType.ROOK, FigureColor.WHITE));
        b.getCell(new Point(5, 3)).setFigure(new Figure(FigureType.ROOK, FigureColor.WHITE));
        System.out.println(ChessService.getPossibleMoves(b, b.getCell(new Point(4, 4))).toString());
    }

    public static void kingMoveTest() {
        Board b = new Board();
        b.getCell(new Point(4, 4)).setFigure(new Figure(FigureType.KING, FigureColor.BLACK));
        System.out.println(ChessService.getPossibleMoves(b, b.getCell(new Point(4, 4))).toString());
    }

    public static void bishopMoveTest() {
        Board b = new Board();
        b.getCell(new Point(4, 3)).setFigure(new Figure(FigureType.BISHOP, FigureColor.BLACK));
        System.out.println(ChessService.getPossibleMoves(b, b.getCell(new Point(4, 3))).toString());
    }

    public static void bishopBeatTest() {
        Board b = new Board();
        b.getCell(new Point(4, 3)).setFigure(new Figure(FigureType.BISHOP, FigureColor.BLACK));
        b.getCell(new Point(5, 4)).setFigure(new Figure(FigureType.ROOK, FigureColor.WHITE));
        b.getCell(new Point(3, 2)).setFigure(new Figure(FigureType.ROOK, FigureColor.WHITE));
        b.getCell(new Point(5, 2)).setFigure(new Figure(FigureType.ROOK, FigureColor.WHITE));
        b.getCell(new Point(3, 4)).setFigure(new Figure(FigureType.ROOK, FigureColor.WHITE));
        System.out.println(ChessService.getPossibleMoves(b, b.getCell(new Point(4, 3))).toString());
    }

    public static void knightMoveTest() {
        Board b = new Board();
        b.getCell(new Point(4, 4)).setFigure(new Figure(FigureType.KNIGHT, FigureColor.BLACK));
        System.out.println(ChessService.getPossibleMoves(b, b.getCell(new Point(4, 4))).toString());
    }

    public static void knightBeatTest() {
        Board b = new Board();
        b.getCell(new Point(4, 4)).setFigure(new Figure(FigureType.KNIGHT, FigureColor.BLACK));
        b.getCell(new Point(5, 2)).setFigure(new Figure(FigureType.ROOK, FigureColor.WHITE));
        b.getCell(new Point(2, 3)).setFigure(new Figure(FigureType.ROOK, FigureColor.WHITE));
        b.getCell(new Point(6, 3)).setFigure(new Figure(FigureType.ROOK, FigureColor.WHITE));
        b.getCell(new Point(2, 5)).setFigure(new Figure(FigureType.ROOK, FigureColor.WHITE));
        b.getCell(new Point(6, 5)).setFigure(new Figure(FigureType.ROOK, FigureColor.WHITE));
        System.out.println(ChessService.getPossibleMoves(b, b.getCell(new Point(4, 4))).toString());
    }

    public static void testAll() {
        System.out.println("Rook test:\nmove:");
        rookMoveTest();
        System.out.println("beat:");
        rookBeatTest();
        System.out.println("---------------------------------------------");

        System.out.println("Pawn test:\nmove:");
        pawnMoveTest();
        System.out.println("beat");
        pawnBeatTest();
        System.out.println("---------------------------------------------");

        System.out.println("King test:\nmove:");
        kingMoveTest();
        System.out.println("beat:");
        kingBeatTest();
        System.out.println("---------------------------------------------");

        System.out.println("Knight test:\nmove:");
        knightMoveTest();
        System.out.println("beat:");
        knightBeatTest();
        System.out.println("---------------------------------------------");

        System.out.println("Bishop test:\nmove:");
        bishopMoveTest();
        System.out.println("beat:");
        bishopBeatTest();
        System.out.println("---------------------------------------------");
    }
}
