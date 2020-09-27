package rybas;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CircularPlayerList {
    private Player white, black;
    private Player activePlayer;

    public CircularPlayerList(Player white, Player black) {
        this.white = white;
        this.black = black;
        this.activePlayer = white;
        white.setNext(black);
        black.setNext(white);
    }

    public Player getActivePlayer() {
        return activePlayer;
    }

    public void setActivePlayer(Player activePlayer) {
        this.activePlayer = activePlayer;
    }
}
