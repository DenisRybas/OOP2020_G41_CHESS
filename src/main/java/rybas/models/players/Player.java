package rybas.models.players;

import rybas.models.figures.FigureColor;

public class Player {
    private FigureColor color;

    public Player(FigureColor color) {
        this.color = color;
    }

    public FigureColor getColor() {
        return color;
    }
}
