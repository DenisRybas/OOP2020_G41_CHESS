package rybas.figures;

public class King implements Figure {
    private final Type type = Type.KING;
    private final Color c;

    public King(Color c) {
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
