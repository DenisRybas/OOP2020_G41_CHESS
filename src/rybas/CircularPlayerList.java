package rybas;

public class CircularPlayerList {
    private Player activePlayer;

    private Player head = null;
    private Player tail = null;

    public void add(Player player) {
        if (head == null) {
            head = player;
            activePlayer = head;
            tail = head;
        }
        player.setNext(head);
        tail.setNext(player);
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
