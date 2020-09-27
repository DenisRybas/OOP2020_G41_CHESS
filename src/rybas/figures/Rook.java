package rybas.figures;

public class Rook implements Figure {
    private Type type = Type.ROOK;
    private Color c;

    public Rook(Color c) {
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
