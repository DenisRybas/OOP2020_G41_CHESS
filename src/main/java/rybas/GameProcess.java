package rybas;

import rybas.models.figures.Figure;
import rybas.models.Board;
import rybas.models.players.CircularPlayerList;
import rybas.models.players.Player;

import java.util.*;

public class GameProcess {
    private final int playerCount = 2;
    private final CircularPlayerList playerList;
    private Map<Player, Set<Figure>> players = new HashMap<>();

    private Board field;

    public GameProcess(CircularPlayerList playerList) {
        field = new Board();
        this.playerList = new CircularPlayerList();
    }

}