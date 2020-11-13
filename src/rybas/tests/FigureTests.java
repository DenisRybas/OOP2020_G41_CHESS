package rybas.tests;

import rybas.figures.Figure;
import rybas.figures.FigureColor;
import rybas.figures.FigureType;
import rybas.models.Board;
import rybas.services.ChessService;

import java.awt.*;

public class FigureTests {
    public static void rookMoveTest() {
        var service = new ChessService();
        Board b = new Board();
        Point p = new Point(4, 4);
        System.out.println("Current cell is " + p.toString());
        b.getCell(p).setFigure(new Figure(FigureType.ROOK, FigureColor.BLACK));
        System.out.println(service.getPossibleMoves(b, b.getCell(p)).toString());
    }

    public static void rookBeatTest() {
        var service = new ChessService();
        Board b = new Board();
        Point p = new Point(4,4);
        System.out.println("Current point is " + p.toString());
        b.getCell(p).setFigure(new Figure(FigureType.ROOK, FigureColor.BLACK));
        b.getCell(new Point(4, 5)).setFigure(new Figure(FigureType.ROOK, FigureColor.WHITE));
        b.getCell(new Point(5, 4)).setFigure(new Figure(FigureType.ROOK, FigureColor.WHITE));
        b.getCell(new Point(3, 4)).setFigure(new Figure(FigureType.ROOK, FigureColor.WHITE));
        b.getCell(new Point(4, 3)).setFigure(new Figure(FigureType.ROOK, FigureColor.WHITE));
        System.out.println(service.getPossibleMoves(b, b.getCell(p)).toString());
    }

    public static void pawnBeatTest() {
        var service = new ChessService();
        Board b = new Board();
        Point p = new Point(4,4);
        System.out.println("Current point is " + p.toString());
        b.getCell(p).setFigure(new Figure(FigureType.PAWN, FigureColor.BLACK));
        b.getCell(new Point(3, 3)).setFigure(new Figure(FigureType.ROOK, FigureColor.WHITE));
        b.getCell(new Point(4, 3)).setFigure(new Figure(FigureType.ROOK, FigureColor.WHITE));
        b.getCell(new Point(5, 3)).setFigure(new Figure(FigureType.ROOK, FigureColor.WHITE));
        System.out.println(service.getPossibleMoves(b, b.getCell(p)).toString());
    }

    public static void pawnMoveTest() {
        var service = new ChessService();
        Board b = new Board();
        Point p = new Point(4,6);
        System.out.println("Current point is " + p.toString());
        System.out.println(service.getPossibleMoves(b, b.getCell(p)).toString());
    }

    public static void kingBeatTest() {
        var service = new ChessService();
        Board b = new Board();
        Point p = new Point(4,4);
        System.out.println("Current point is " + p.toString());
        b.getCell(p).setFigure(new Figure(FigureType.KING, FigureColor.BLACK));
        b.getCell(new Point(3, 4)).setFigure(new Figure(FigureType.ROOK, FigureColor.WHITE));
        b.getCell(new Point(5, 4)).setFigure(new Figure(FigureType.ROOK, FigureColor.WHITE));
        b.getCell(new Point(3, 5)).setFigure(new Figure(FigureType.ROOK, FigureColor.WHITE));
        b.getCell(new Point(4, 5)).setFigure(new Figure(FigureType.ROOK, FigureColor.WHITE));
        b.getCell(new Point(5, 5)).setFigure(new Figure(FigureType.ROOK, FigureColor.WHITE));
        b.getCell(new Point(3, 3)).setFigure(new Figure(FigureType.ROOK, FigureColor.WHITE));
        b.getCell(new Point(4, 3)).setFigure(new Figure(FigureType.ROOK, FigureColor.WHITE));
        b.getCell(new Point(5, 3)).setFigure(new Figure(FigureType.ROOK, FigureColor.WHITE));
        System.out.println(service.getPossibleMoves(b, b.getCell(p)).toString());
    }

    public static void kingMoveTest() {
        var service = new ChessService();
        Board b = new Board();
        Point p = new Point(4,4);
        System.out.println("Current point is " + p.toString());
        b.getCell(p).setFigure(new Figure(FigureType.KING, FigureColor.BLACK));
        System.out.println(service.getPossibleMoves(b, b.getCell(p)).toString());
    }

    public static void bishopMoveTest() {
        var service = new ChessService();
        Board b = new Board();
        Point p = new Point(4,3);
        System.out.println("Current point is " + p.toString());
        b.getCell(p).setFigure(new Figure(FigureType.BISHOP, FigureColor.BLACK));
        System.out.println(service.getPossibleMoves(b, b.getCell(p)).toString());
    }

    public static void bishopBeatTest() {
        var service = new ChessService();
        Board b = new Board();
        Point p = new Point(4,3);
        System.out.println("Current point is " + p.toString());
        b.getCell(p).setFigure(new Figure(FigureType.BISHOP, FigureColor.BLACK));
        b.getCell(new Point(5, 4)).setFigure(new Figure(FigureType.ROOK, FigureColor.WHITE));
        b.getCell(new Point(3, 2)).setFigure(new Figure(FigureType.ROOK, FigureColor.WHITE));
        b.getCell(new Point(5, 2)).setFigure(new Figure(FigureType.ROOK, FigureColor.WHITE));
        b.getCell(new Point(3, 4)).setFigure(new Figure(FigureType.ROOK, FigureColor.WHITE));
        System.out.println(service.getPossibleMoves(b, b.getCell(p)).toString());
    }

    public static void knightMoveTest() {
        var service = new ChessService();
        Board b = new Board();
        Point p = new Point(4,4);
        System.out.println("Current point is " + p.toString());
        b.getCell(p).setFigure(new Figure(FigureType.KNIGHT, FigureColor.BLACK));
        System.out.println(service.getPossibleMoves(b, b.getCell(p)).toString());
    }

    public static void knightBeatTest() {
        var service = new ChessService();
        Board b = new Board();
        Point p = new Point(4,4);
        System.out.println("Current point is " + p.toString());
        b.getCell(p).setFigure(new Figure(FigureType.KNIGHT, FigureColor.BLACK));
        b.getCell(new Point(5, 2)).setFigure(new Figure(FigureType.ROOK, FigureColor.WHITE));
        b.getCell(new Point(2, 3)).setFigure(new Figure(FigureType.ROOK, FigureColor.WHITE));
        b.getCell(new Point(6, 3)).setFigure(new Figure(FigureType.ROOK, FigureColor.WHITE));
        b.getCell(new Point(2, 5)).setFigure(new Figure(FigureType.ROOK, FigureColor.WHITE));
        b.getCell(new Point(6, 5)).setFigure(new Figure(FigureType.ROOK, FigureColor.WHITE));
        System.out.println(service.getPossibleMoves(b, b.getCell(p)).toString());
    }

    public static void queenMoveTest() {
        var service = new ChessService();
        Board b = new Board();
        Point p = new Point(4,4);
        System.out.println("Current point is " + p.toString());
        b.getCell(p).setFigure(new Figure(FigureType.QUEEN, FigureColor.BLACK));
        System.out.println(service.getPossibleMoves(b, b.getCell(p)).toString());
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
