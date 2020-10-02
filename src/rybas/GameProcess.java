package rybas;

import rybas.figures.Figure;
import rybas.figures.Movable;
import rybas.models.Board;
import rybas.models.Cell;
import rybas.services.ChessService;

import java.awt.*;
import java.util.*;

public class GameProcess {
    private final int playerCount = 2;
    private static Board board;
    private final CircularPlayerList playerList;
    private Map<Player, Set<Figure>> player = new HashMap<>();

    public GameProcess(CircularPlayerList playerList) {
        board = new Board();
        this.playerList = playerList;
    }

    public static void main(String[] args) {
        board = new Board();
        LinkedHashMap<ChessService.TypeOfMove, LinkedHashSet<Cell>> cd =  ChessService.getKnightPossibleMoves(board, board.getCell(new Point(2, 0)));
        System.out.println(board.toString());
    }
}
