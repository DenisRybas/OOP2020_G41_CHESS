package rybas.models;

public class MainModel {
    private static MainModel instance;
    private Board board;

    private MainModel() {
        this.board = new Board();
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }

    public static MainModel getInstance() {
        if (instance == null) {
            instance = new MainModel();
        }
        return instance;
    }
}
