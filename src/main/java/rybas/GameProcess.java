package rybas;

import rybas.models.figures.Figure;
import rybas.models.Board;
import rybas.models.figures.FigureColor;
import rybas.models.players.Player;

import java.util.*;

public class GameProcess {
    private final LinkedList<Player> players;
    private Board field;
    private Player activePlayer;

    public void setField(Board field) {
        this.field = field;
    }

    public LinkedList<Player> getPlayers() {
        return players;
    }

    public Board getField() {
        return field;
    }

    public void nextPlayer() {
        FigureColor prev = this.activePlayer.getColor();
        for (Player player : players) {
            if (!activePlayer.equals(player) && !prev.equals(player.getColor()))
                this.activePlayer = player;
        }
    }

    public Player getActivePlayer() {
        return activePlayer;
    }

    public GameProcess() {
        this.players = new LinkedList<>(){{
            add(new Player(FigureColor.WHITE));
            add(new Player(FigureColor.BLACK));
        }};
        this.activePlayer = players.getFirst();
        field = new Board();
    }

}