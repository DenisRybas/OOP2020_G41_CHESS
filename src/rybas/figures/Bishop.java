package rybas.figures;

import java.awt.*;

public class Bishop implements Figure {
    private final Type type = Type.BISHOP;
    private final Color c;

    public Bishop(Color c) {
        this.c = c;
    }

    @Override
    public Type getType() {
        return null;
    }

    @Override
    public void setType(Type type) {

    }

    @Override
    public Color getColor() {
        return c;
    }

    @Override
    public void beat() {

    }
}
