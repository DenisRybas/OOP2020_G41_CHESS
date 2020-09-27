package rybas.figures;

public class Knight implements Figure {
    private final Type type = Type.KNIGHT;
    private Color c;

    public Knight(Color c) {
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
