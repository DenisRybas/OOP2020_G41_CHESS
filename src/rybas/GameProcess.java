package rybas;

import rybas.figures.Figure;
import rybas.models.Board;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GameProcess {
    private final int playerCount = 2;
    private Board board;
    private final CircularPlayerList playerList;
    private Map<Player, Set<Figure>> player = new HashMap<>();

    public GameProcess(CircularPlayerList playerList) {
        board = new Board();
        this.playerList = playerList;
    }
}
