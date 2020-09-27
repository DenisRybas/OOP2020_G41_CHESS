package rybas;

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

    public void next() {
        activePlayer = activePlayer.getNext();
    }

    public void setActivePlayer(Player activePlayer) {
        this.activePlayer = activePlayer;
    }
}
