package rybas.figures;

public class Pawn implements Figure {
    private Type type = Type.PAWN;
    private final Color c;

    public Pawn(Color c) {
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
