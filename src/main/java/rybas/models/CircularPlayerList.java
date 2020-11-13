package rybas.models;

public class CircularPlayerList {
    private Player activePlayer;
    private Player head = null;
    private Player tail = null;

    public void add(Player player) {
        if (head == null) {
            head = player;
            tail = player;
            tail.setNext(head);
            activePlayer = head;
        }
        tail.setNext(player);
        tail = player;
        tail.setNext(head);
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
