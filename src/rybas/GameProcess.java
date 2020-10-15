package rybas;

import rybas.figures.Figure;
import rybas.figures.FigureColor;
import rybas.figures.FigureType;
import rybas.figures.Movable;
import rybas.models.Board;
import rybas.models.Cell;
import rybas.models.CellColor;

import java.awt.*;
import java.util.*;

public class GameProcess {
    private final int playerCount = 2;
    private final CircularPlayerList playerList;
    private Map<Player, Set<Figure>> players = new HashMap<>();

    private Board field;
    private Cell downLeft;
    private Cell upRight;

    public GameProcess(CircularPlayerList playerList) {
        field = new Board();
        downLeft = new Cell();
        upRight = new Cell();
        this.playerList = new CircularPlayerList();
    }


}