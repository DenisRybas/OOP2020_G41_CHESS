package rybas.figures;

public class Queen implements Figure{
    private final Type type = Type.QUEEN;
    private final Color c;
    @Override
    public Type getType() {
        return null;
    }

    @Override
    public void setType(Type type) {

    }

    public Queen(Color c) {
        this.c = c;
    }

    @Override
    public Color getColor() {
        return c;
    }

    @Override
    public void beat() {

    }
}
