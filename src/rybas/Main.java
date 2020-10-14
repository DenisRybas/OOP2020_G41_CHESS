package rybas;

import rybas.figures.Figure;
import rybas.figures.FigureColor;
import rybas.figures.FigureType;
import rybas.models.Board;
import rybas.models.Cell;
import rybas.services.ChessService;

import java.awt.*;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class Main {
    public static void main(String[] args) {
        Board b = new Board();
        b.getCell(new Point(4, 2)).setFigure(new Figure(FigureType.PAWN, FigureColor.BLACK));
        b.getCell(new Point(3, 1)).setFigure(new Figure(FigureType.KING, FigureColor.BLACK));
        b.getCell(new Point(4, 6)).setFigure(new Figure(FigureType.KING, FigureColor.BLACK));
        b.getCell(new Point(5, 6)).setFigure(new Figure(FigureType.KING, FigureColor.BLACK));
        b.getCell(new Point(3, 4)).setFigure(new Figure(FigureType.KING, FigureColor.BLACK));
        b.getCell(new Point(0, 1)).setFigure(new Figure(FigureType.KING, FigureColor.BLACK));
        b.getCell(new Point(1, 0)).setFigure(new Figure(FigureType.KING, FigureColor.BLACK));

        Point p = new Point(0, 0);

        LinkedHashMap<ChessService.TypeOfMove, LinkedHashSet<Cell>> pm = ChessService.getPossibleMoves(b, b.getCell(p));
        GameProcess gp = new GameProcess(null);
    }
}
