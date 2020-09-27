package rybas;

public class GameProcess {
    private final int playerCount = 2;
    private Board board;
    private final CircularPlayerList playerList;

    public GameProcess(CircularPlayerList playerList) {
        board = new Board();
        this.playerList = playerList;
    }
}
